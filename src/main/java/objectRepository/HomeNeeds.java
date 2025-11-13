package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeNeeds {

public AppiumDriver driver;
	
	public HomeNeeds(AppiumDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Home Needs']")
	private WebElement homeNeedsToggle;
	
	@AndroidFindAll({@AndroidBy(xpath="//android.widget.TextView[@text='Home & Kitchen']"),@AndroidBy(id="in.dmart:id/tvTextBannerView")
	,@AndroidBy(uiAutomator="new UiSelector().resourceId(\"in.dmart:id/tvTextBannerView\")")})
	private WebElement Home_and_Kitchen;

	public WebElement getHomeNeedsToggle() {
		return homeNeedsToggle;
	}

	public void setHomeNeedsToggle(WebElement homeNeedsToggle) {
		this.homeNeedsToggle = homeNeedsToggle;
	}

	public WebElement getHome_and_Kitchen() {
		return Home_and_Kitchen;
	}

	public void setHome_and_Kitchen(WebElement home_and_Kitchen) {
		Home_and_Kitchen = home_and_Kitchen;
	}
	
	
}
