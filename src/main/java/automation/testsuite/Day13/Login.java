package automation.testsuite.Day13;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.common.CommonBase1;
import automation.constant.CT_Account;

public class Login extends CommonBase1 {
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_Account.webURL);
	}
	
	@Test(priority = 3)
	public void loginSuccessfully() {
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@demo.com");
		}
		scrollToElement(By.xpath("//h2[text()='hello']"));
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if(btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
		assertEquals(true, driver.findElement(By.xpath("//ul[@id='sidebar-menu']/descendant::span[text()='Dashboard']")).isDisplayed());
	}
	
	@Test (priority = 2)
	public void loginFail_IncorrectEmail() {
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@demo");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if(btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
		assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}
	@Test (priority = 1)
	public void loginFail_IncorrectPass() {
		WebElement txtEmail = driver.findElement(CT_Account.textBoxEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@demo.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textBoxPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("rise");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnSubmit = driver.findElement(CT_Account.btnLogin);
		if(btnSubmit.isDisplayed()) {
			btnSubmit.click();
		}
		assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		
	}
	
	@AfterMethod
	public void closeChrome() {
		quitDriver(driver);
	}
	

}
