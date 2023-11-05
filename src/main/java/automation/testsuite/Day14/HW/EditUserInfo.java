package automation.testsuite.Day14.HW;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import javax.naming.InitialContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import pageLocator.EditUserInfoPageFactory;
import pageLocator.SignInPageFactory_day14HW;
import pageLocator.SignUpPageFactory_day14HW;
import org.openqa.selenium.interactions.Actions;

public class EditUserInfo extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-nhap.html");

	}

	@Test
	public void EditUserInfoSuccessfully() {
		String email = "dinhhongngoc2001@gmail.com";
		String currentPass="Ngocdinh08@";
		String newPasss;
		//sign in
		SignInPageFactory_day14HW signInPage = new SignInPageFactory_day14HW(driver);
		signInPage.SignIn(email, currentPass);
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
		
		//find edit button
		WebElement btnEdit = driver.findElement(By.xpath("//a[text()='Chỉnh sửa thông tin']"));
		driver.get(btnEdit.getAttribute("href"));
		assertEquals("https://alada.vn/thong-tin-ca-nhan", driver.getCurrentUrl());
		
		//change password
		EditUserInfoPageFactory editPage = new EditUserInfoPageFactory(driver);
		newPasss=currentPass;
		editPage.ChangePassword(currentPass, newPasss);
		pause(3000);
		assertEquals("Cập nhật mật khẩu mới thành công!",driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//logout
		driver.get(driver.findElement(By.xpath("//a[text()='Thoát']")).getAttribute("href"));
		driver.get(driver.findElement(By.xpath("//a[text()='Đăng Nhập']")).getAttribute("href"));
		//login again
		signInPage.SignIn(email,newPasss);
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
	}

	@AfterMethod
	public void closeChrome() {
		driver.close();
	}

}
