package automation.testsuite.Day13.HW;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import pageLocator.LoginPage;

public class LoginTC extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_Account.webURL);
	}

	@Test(priority = 1)
	public void loginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		assertTrue(driver.findElement(CT_Account.dasboardText).isDisplayed());
	}

	@Test(priority = 2)
	public void loginFail_IncorrectEmail() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@dem.com", "riseDemo");	
		assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}

	@Test(priority = 3)
	public void loginFail_IncorrectPass() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemoo");	
		assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	

	}

	@Test(priority = 4)
	public void loginFail_IncorrectEmailAndPass() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo0.com", "riseDemoo");	
		assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());

	}

	@Test(priority = 5)
	public void Logout() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");

		WebElement userDropdown = driver.findElement(CT_Account.userDropdown);
		if (userDropdown.isDisplayed()) {
			userDropdown.click();
		}
		pause(5000);
		WebElement btnLogout = driver.findElement(CT_Account.btnLogout);
		if (btnLogout.isDisplayed()) {
			btnLogout.click();
		}
		pause(5000);
		assertTrue(driver.findElement(By.xpath("//h2[text()='Sign in']")).isDisplayed());
	}

	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
