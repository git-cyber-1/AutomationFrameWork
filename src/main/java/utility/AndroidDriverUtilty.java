package utility;

import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverUtilty {
	
	public AndroidDriver driver;
	
	public AndroidDriverUtilty(AndroidDriver driver)
	{
		this.driver=driver;
	}
	public void installApp(String Path)
	{
		driver.installApp(Path);
	}
	public boolean isInstalledApp(String appPackage)
	{
		boolean result = driver.isAppInstalled(appPackage);
		return result;
	}
	public void deleteApp(String appPackage)
	{
		driver.removeApp(appPackage);
	}
	public void closeApp(String appPackage)
	{
	  driver.terminateApp(appPackage);
	}
	public void notification()
	{
		driver.openNotifications();
	}
	public void keyboardHide()
	{
		driver.hideKeyboard();
	}
	public void airplaneMode()
	{
		driver.toggleAirplaneMode();
	}
	public void activateApp(String appPackage)
	{
		driver.activateApp(appPackage);
	}
	public void landscapeOrientation()
	{
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.LANDSCAPE);
	}
	public void portraitOrientation()
	{
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.PORTRAIT);
	}
	public void backgroundRunningApp(long time)
	{
		driver.runAppInBackground(Duration.ofSeconds(time));
	}
	public void waitTillVisibilty(WebElement ele) 
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitTillElementClickable(WebElement ele) 
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
       element.click();
	}
	
}
