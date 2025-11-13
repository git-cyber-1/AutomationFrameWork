package baseClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import objectRepository.HomeNeeds;
import objectRepository.My_Account;
import utility.AndroidDriverUtilty;
import utility.ExcellUtility;
import utility.GestureUtility;
import utility.PropertiesFileUtility;

public class BaseClass {
	public static AppiumDriverLocalService service;
	public AndroidDriver driver;
	PropertiesFileUtility putil = new PropertiesFileUtility();
	public static AndroidDriver sdriver;


	public My_Account ma;
	public AndroidDriverUtilty driverUtilty;
	public GestureUtility gutility;
	public HomeNeeds hn;

	@BeforeSuite(alwaysRun = true)
	public static void startServer() {
		String Path = "C:\\Users\\girij\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		File file = new File(Path);
		service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1").usingPort(4723)
				.withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		System.out.println("server started");
	}

	@AfterSuite(alwaysRun = true)
	public void closeServer() {
		service.stop();
		System.out.println("server stopped");
	}

	@SuppressWarnings("deprecation")
	@BeforeClass(alwaysRun = true)
	public void launchApp() throws IOException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", putil.getDataFromProperties("platformName"));
		dc.setCapability("automationName", putil.getDataFromProperties("automationName"));
		dc.setCapability("deviceName", putil.getDataFromProperties("deviceName"));
		dc.setCapability("udid", putil.getDataFromProperties("udid"));
		dc.setCapability("appPackage", putil.getDataFromProperties("appPackage"));
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiError", true);
		dc.setCapability("autoGrantPermissions", true);

		driver = new AndroidDriver(new URL("http://localhost:4723"), dc);
		driver.activateApp(putil.getDataFromProperties("appPackage"));
		sdriver = driver;

	}

	@AfterClass(alwaysRun = true)
	public void closeApp() throws IOException {
		if (driver != null) {
			driver.terminateApp(putil.getDataFromProperties("appPackage"));
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void loginApp() throws EncryptedDocumentException, IOException, InterruptedException {
		ma = new My_Account(driver);
		driverUtilty = new AndroidDriverUtilty(driver);

		System.out.println("Driver initialized successfully: " + (driver != null)); // Debug log

		if (driver == null) {
			throw new IllegalStateException("Driver is not initialized. Check @BeforeClass.");
		}

		driverUtilty.waitTillVisibilty(ma.getMy_Account());
		ma.getMy_Account().click();
		Thread.sleep(3000);
		driverUtilty.waitTillVisibilty(ma.getLogin());
		ma.getLogin().click();
		ma.getNone_of_above().click();

		ExcellUtility eutil = new ExcellUtility();
	   System.out.println(eutil.readDataFromExcell("my_account", 1, 1));
		ma.getMobile_num().sendKeys(eutil.readDataFromExcell("my_account", 1, 0));
		ma.getContinue_login().click();
		Thread.sleep(16000);
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		// Add null/driver checks to prevent IllegalStateException
		if (driver != null && ma != null) {
			try {
				ma.getSign_out().click();
				ma.getFrom_this_device().click();
				System.out.println("Logged out successfully.");
			} catch (Exception e) {
				System.err.println("Logout failed (possibly due to session state): " + e.getMessage());
			}
		} else {
			System.err.println("Driver or My_Account is null—skipping logout.");
		}
	}
}
