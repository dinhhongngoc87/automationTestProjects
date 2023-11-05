package pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory {
	private WebDriver driver;
	
	public loginPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	WebElement txtEmail;
	
	@FindBy(id = "password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit' and text()='Sign in']")
	WebElement btnLogin;
	
	public void LoginFunction(String email, String pass) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPassword.clear();
		txtPassword.sendKeys(pass);
		btnLogin.click();
	}
	
	
	
	
}
