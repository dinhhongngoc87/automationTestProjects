package pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageFactory_day14HW {
	private WebDriver driver;

	public SignInPageFactory_day14HW(WebDriver _driver) {
		super();
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtLoginUsername")
	private WebElement txtLoginUsername;
	@FindBy(id = "txtLoginPassword")
	private WebElement txtLoginPassword;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSignIn;

	public void SignIn(String email, String pass) {
		txtLoginUsername.clear();
		txtLoginUsername.sendKeys(email);

		txtLoginPassword.clear();
		txtLoginPassword.sendKeys(pass);

		btnSignIn.click();

	}

}
