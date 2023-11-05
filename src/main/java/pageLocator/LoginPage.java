package pageLocator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.constant.CT_Account;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String email, String pass) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if (txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys(email);
		}
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if (txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys(pass);
		}
		
		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if (btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
	}

}
