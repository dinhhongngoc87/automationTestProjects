package automation.testsuite.Day15;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import pageLocator.ClientPageFactory;
import pageLocator.loginPageFactory;

public class AddClientTC extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_Account.webURL);
	}
	
	@Test
	public void addClientSuccessfully() throws InterruptedException {
		loginPageFactory login = new loginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		ClientPageFactory client = new ClientPageFactory(driver);
		client.addNewClientFunction("AutoCompany2k1");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//a[text()='AutoCompany2k1']")).isDisplayed());
	}
}
