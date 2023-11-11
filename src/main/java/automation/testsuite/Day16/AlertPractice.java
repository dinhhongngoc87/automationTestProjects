package automation.testsuite.Day16;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertPractice extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
	}
	
	@Test(priority = 1)
	public void dismissAlert() {

		click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		click(By.xpath("//button[text()='click the button to display a confirm box ']"));
		driver.switchTo().alert().dismiss();
		assertTrue(isElementPresent(By.xpath("//p[@id='demo' and text()='You Pressed Cancel']")));
		
	}
	@Test(priority = 2)
	public void alertWithTextbox() {

		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
		driver.switchTo().alert().sendKeys("alert practice");
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[@id='demo1' and text()='Hello alert practice How are you today']")));
		
	}
	
	
	
	@AfterMethod
	public void closeChrome() {
		quitDriver(driver);
	}
}
