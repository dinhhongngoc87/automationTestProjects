package automation.testsuite.Day14.HW;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import pageLocator.SignInPageFactory_day14HW;

public class SignIn extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-nhap.html");
	}
	
	@Test
	public void SignInSuccessfully() {
		SignInPageFactory_day14HW signInPage = new SignInPageFactory_day14HW(driver);
		signInPage.SignIn("dinhhongngoc2001@gmail.com", "Ngocdinh08@");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
		System.out.println("Đăng nhập thành công");
	}
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}

}
