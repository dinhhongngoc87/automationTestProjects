package pageLocator;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class LoginPage extends CommonBase {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Login() {
		By txtEmail = By.id("txtLoginUsername");
		By txtPassword = By.id("txtLoginPassword");
		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
		assertTrue(getElementPresentDOM(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
		System.out.println("Login successfully");
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
