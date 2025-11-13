package com.newproject.install_uninstall;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import utility.PropertiesFileUtility;

public class Install_Uninstall {

	PropertiesFileUtility putil = new PropertiesFileUtility();
	public AndroidDriver driver;

	@Test
	public void installApp() throws IOException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", putil.getDataFromProperties("platformName"));
		dc.setCapability("automationName", putil.getDataFromProperties("automationName"));
		dc.setCapability("deviceName", putil.getDataFromProperties("deviceName"));
		dc.setCapability("udid", putil.getDataFromProperties("udid"));

		String apkpath = "C:\\Users\\girij\\OneDrive\\Desktop\\Appium apk\\Fresh Grocery Bazaar_2.0.1_APKPure.apk";
		driver = new AndroidDriver(new URL("http://localhost:4723"), dc);
		driver.installApp(apkpath);
		Assert.assertEquals(true,driver.isAppInstalled(putil.getDataFromProperties("appPackage")));
	}
	@Test
	public void unInstallApp() throws IOException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", putil.getDataFromProperties("platformName"));
		dc.setCapability("automationName", putil.getDataFromProperties("automationName"));
		dc.setCapability("deviceName", putil.getDataFromProperties("deviceName"));
		dc.setCapability("udid", putil.getDataFromProperties("udid"));

		driver = new AndroidDriver(new URL("http://localhost:4723"), dc);
		driver.removeApp(putil.getDataFromProperties("appPackage"));
		Assert.assertEquals(false,driver.isAppInstalled(putil.getDataFromProperties("appPackage")));
	

		
	}

}
