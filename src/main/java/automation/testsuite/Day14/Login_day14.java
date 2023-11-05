package automation.testsuite.Day14;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import pageLocator.LoginPage;
import pageLocator.loginPageFactory;

public class Login_day14 extends CommonBase {
	
	@BeforeMethod
	public void openChromeDriver() {
		driver=initChromeDriver(CT_Account.webURL);

	}
	
	@Test(priority=1)
	public void LoginSuccessfully() {
		LoginPage page = new LoginPage(driver);
		page.LoginFunction("admin@demo.com", "riseDemo");
		assertTrue(driver.findElement(CT_Account.dasboardText).isDisplayed());
	}
}
