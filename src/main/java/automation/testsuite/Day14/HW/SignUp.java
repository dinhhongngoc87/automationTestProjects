package automation.testsuite.Day14.HW;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import pageLocator.SignUpPageFactory_day14HW;

public class SignUp extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-ky.html");
	}
	
	@Test
	public void SignUpSuccessfully() {
		Random rand = new Random();
		int x = rand.nextInt(9 - 1) + 1;
		String email = "dinhhongngoc2001"+x+"@gmail.com";
		SignUpPageFactory_day14HW signUpPage = new SignUpPageFactory_day14HW(driver);
		signUpPage.SignUp("dinh thi hong ngoc",email, email, "Ngocdinh08@", "Ngocdinh08@", "0392109981");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
		System.out.println("Đăng ký thành công");
	}
	
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
