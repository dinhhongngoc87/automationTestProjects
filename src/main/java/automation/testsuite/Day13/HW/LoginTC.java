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

public class LoginTC extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_Account.webURL);
	}

	@Test(priority = 1)
	public void loginSuccessfully() {
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if (txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@demo.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if (txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if (btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
		assertTrue(driver.findElement(By.xpath("//ul[@id='sidebar-menu']/descendant::span[text()='Dashboard']"))
				.isDisplayed());

	}

	@Test(priority = 2)
	public void loginFail_IncorrectEmail() {
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if (txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@de.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if (txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if (btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
		assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}

	@Test(priority = 3)
	public void loginFail_IncorrectPass() {
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if (txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@de.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if (txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}

		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if (btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());

	}

	@Test(priority = 4)
	public void loginFail_IncorrectEmailAndPass() {
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if (txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@de.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if (txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDem");
		}

		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if (btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());

	}

	@Test(priority = 5)
	public void Logout() {
		loginSuccessfully();

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
