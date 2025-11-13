package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class My_Account {

	public AppiumDriver driver;

	public My_Account(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
	private WebElement my_Account;

	@AndroidFindBy(uiAutomator= "new UiSelector().text(\"Sign Out\")")
	private WebElement sign_out;

	@AndroidFindAll({@AndroidBy(uiAutomator = "new UiSelector().resourceId(\"in.dmart:id/tvActionBtnText\")")})
	private WebElement login;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='NONE OF THE ABOVE']")
	private WebElement None_of_above;

	@AndroidFindBy(id = "in.dmart:id/edMobileNumber")
	private WebElement mobile_num;

	@AndroidFindBy(id = "in.dmart:id/btnLoginInUser")
	private WebElement continue_login;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"in.dmart:id/tvGpsEnableButton\"]")
	private WebElement TURN_ON;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='WHILE USING THE APP']")
	private WebElement while_using_app;

	@AndroidFindBy(id = "in.dmart:id/btnConfirmLocation")
	private WebElement confirm_Location;

	@AndroidFindBy(id="in.dmart:id/tvLogoutPositive")
	private WebElement from_this_device;
	
	public WebElement getFrom_this_device() {
		return from_this_device;
	}

	public void setFrom_this_device(WebElement from_this_device) {
		this.from_this_device = from_this_device;
	}

	public WebElement getTURN_ON() {
		return TURN_ON;
	}

	public void setTURN_ON(WebElement tURN_ON) {
		TURN_ON = tURN_ON;
	}

	public WebElement getWhile_using_app() {
		return while_using_app;
	}

	public void setWhile_using_app(WebElement while_using_app) {
		this.while_using_app = while_using_app;
	}

	public WebElement getConfirm_Location() {
		return confirm_Location;
	}

	public void setConfirm_Location(WebElement confirm_Location) {
		this.confirm_Location = confirm_Location;
	}

	public WebElement getMy_Account() {
		return my_Account;
	}

	public void setMy_Account(WebElement my_Account) {
		this.my_Account = my_Account;
	}

	public WebElement getSign_out() {
		return sign_out;
	}

	public void setSign_out(WebElement sign_out) {
		this.sign_out = sign_out;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}

	public WebElement getNone_of_above() {
		return None_of_above;
	}

	public void setNone_of_above(WebElement none_of_above) {
		None_of_above = none_of_above;
	}

	public WebElement getMobile_num() {
		return mobile_num;
	}

	public void setMobile_num(WebElement mobile_num) {
		this.mobile_num = mobile_num;
	}

	public WebElement getContinue_login() {
		return continue_login;
	}

	public void setContinue_login(WebElement continue_login) {
		this.continue_login = continue_login;
	}

}
