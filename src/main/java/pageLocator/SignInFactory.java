package pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class SignInFactory {
	private WebDriver driver;

	public SignInFactory(WebDriver _driver) {
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
//		
//		inputTextJavaScriptValue(txtLoginUsername, email);
//		inputTextJavaScriptValue(txtLoginPassword, pass);


		btnSignIn.click();

	}

}
