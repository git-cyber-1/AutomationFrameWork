package baseClass;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import objectRepository.HomeNeeds;
import objectRepository.My_Account;
import utility.AndroidDriverUtilty;
import utility.ExcellUtility;
import utility.GestureUtility;
import utility.PropertiesFileUtility;

public class BaseClassCloud {
	public static AppiumDriverLocalService service;
	public AndroidDriver driver;
	PropertiesFileUtility putil = new PropertiesFileUtility();
	public static AndroidDriver sdriver;


	public My_Account ma;
	public AndroidDriverUtilty driverUtilty;
	public GestureUtility gutility;
	public HomeNeeds hn;

	 public String USERNAME="girijasankardas_h7y9Uw";
	 public String ACCESSKEY="z1cUSsd54UQS7AmscEd2";
	 String url = "https://"+USERNAME+":"+ACCESSKEY+"@hub-cloud.browserstack.com/wd/hub";

	@SuppressWarnings("deprecation")
	@BeforeClass(alwaysRun = true)
	public void launchApp() throws IOException {
		//String USERNAME = putil.getDataFromProperties("UN");
		//String ACCESSKEY = putil.getDataFromProperties("ACCESSKEY");
		//String url = "https://"+USERNAME+":"+ACCESSKEY+"@hub-cloud.browserstack.com/wd/hub";
		DesiredCapabilities dc = new DesiredCapabilities();
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		bstackOptions.put("userName", "girijasankardas_h7y9Uw");
		bstackOptions.put("accessKey", "z1cUSsd54UQS7AmscEd2");
		bstackOptions.put("consoleLogs", "info");
		bstackOptions.put("seleniumVersion", "4.3.0");
		bstackOptions.put("projectName", "logintest");
		bstackOptions.put("buildName", "build1");
		bstackOptions.put("debug", "true");
		bstackOptions.put("networkLogs", "true");
		bstackOptions.put("telemetryLogs", "true");
		dc.setCapability("bstack:options", bstackOptions);
        dc.setCapability("platformName", putil.getDataFromProperties("platformName"));
		dc.setCapability("automationName", putil.getDataFromProperties("automationName"));
		dc.setCapability("deviceName","Samsung Galaxy S23");
		dc.setCapability("app", putil.getDataFromProperties("appCloud"));
		dc.setCapability("appPackage",putil.getDataFromProperties("appPackage"));
		dc.setCapability("noReset", true);
		dc.setCapability("ignoreHiddenApiError", true);
		dc.setCapability("autoGrantPermissions", true);
		

		driver = new AndroidDriver(new URL(url), dc);
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

		Thread.sleep(3000);
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
