package automation.testsuite.Day15.HW;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import pageLocator.ClientPageFactory;
import pageLocator.LoginPage;

public class AddClient extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://rise.fairsketch.com/signin");
	}
	@Test
	public void addClientSuccessfully() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com	", "riseDemo");
		ClientPageFactory clientpage = new ClientPageFactory(driver);
		clientpage.addNewClientFunction("company71123");
		assertTrue(driver.findElement(By.xpath("//a[text()='company71123']")).isDisplayed());	
	}
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
