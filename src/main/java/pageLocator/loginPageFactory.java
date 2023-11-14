package pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;

public class loginPageFactory extends CommonBase {
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
//		txtEmail.clear();
//		txtEmail.sendKeys(email);
//		txtPassword.clear();
//		txtPassword.sendKeys(pass);
//		btnLogin.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		type(By.id("email"), email);
		type(By.id("password"), pass);
		click(By.xpath("//button[@type='submit' and text()='Sign in']"));
	}
	
	
	
	
}
