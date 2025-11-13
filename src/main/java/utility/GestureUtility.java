package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {

	public AndroidDriver driver;
	public GestureUtility(AndroidDriver driver)
	{
		this.driver=driver;
	}
	public void longClickByElement(WebElement ele,int time)
	{
	   ((JavascriptExecutor)driver).executeScript(
			   "mobile: longClickGesture",
			   ImmutableMap.of("ElementId",((RemoteWebElement)ele).getId(),
			   "duration",time));
	}
	public void doubleClick(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript(
			"mobile: doubleClickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)ele).getId()));
	}
	public void ClickByElement(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: clickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId()));
	}
	public void longClickCoordinates(int x,int y,int time)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: longClickGesture",
				ImmutableMap.of("x",x,"y",y,"duration",time));
	}
	public void clickByCoordinates(int x,int y)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: clickGesture",
				ImmutableMap.of("x",x,"y",y));
	}
	public void doubleClickByCoordinates(int x,int y)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: doubleClickGesture",ImmutableMap.of("x",x,"y",y));
	}
	public void dragAndDrop(WebElement ele,int x,int y)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: dragGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"endx",x,
				"endy",y));
	}
	public void zoomIn(WebElement ele,double percent)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: pinchOpenGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"percent",percent));
	}
	public void zoomOut(WebElement ele,double percent)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: pinchCloseGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"percent",percent));
	}
	public void swipeByCoordinates(int left,int top,int width,int height,String direction,double percent)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: swipeGesture",
				ImmutableMap.of("left",left,"top",top,"width",width,"height",height,
						         "direction",direction,"percent",percent));
	}
	public void swipeByElement(WebElement ele,String direction,double percent)
	{
	  ((JavascriptExecutor)driver).executeScript(
			  "mobile: swipeGesture",ImmutableMap.of("elementId",
					  ((RemoteWebElement)ele).getId(),
					  "direction",direction,
					  "percent",percent));
	}
	public void scrollByCoordinates(int left,int top,int width,int height,String duration,double percent)
	{
		((JavascriptExecutor)driver).executeScript(
				"mobile: scrollGesture",
				ImmutableMap.of("left",left,"top",top,"width",width,"height",height,
						         "duration",duration,"percent",percent));
	}
	public WebElement scrollByText(String text) {
	    WebElement ele = driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"
	    ));
	    return ele;
	}
	public WebElement scrollByxpath(String xpath) {
	    WebElement ele = driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"" + xpath + "\"));"
	    ));
	    return ele;
	}

}
