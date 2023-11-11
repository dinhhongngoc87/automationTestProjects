package automation.testsuite.Day16.HW;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CommonBase;

public class Day16_HW extends CommonBase {

	By btnLogin = By.xpath("//button[@type='submit']");
	By editUser = By.xpath("//a[text()='Chỉnh sửa thông tin']");
	String email = "dinhhongngoc2001@gmail.com";
	String pass = "Ngocdinh08@";

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://alada.vn/tai-khoan/dang-nhap.html");
	}

	public void Login() {
		By txtEmail = By.id("txtLoginUsername");
		By txtPassword = By.id("txtLoginPassword");
		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
		inputTextJavaScriptValue(txtEmail, email);
		inputTextJavaScriptValue(txtPassword, pass);
		click(btnLogin);
		assertTrue(getElementPresentDOM(By.xpath("//a[text()='Khóa học của tôi']")).isDisplayed());
		System.out.println("Login successfully");
	}

	public void navigateToEditUser() {

		Actions action = new Actions(driver);
		action.moveToElement(getElementPresentDOM(By.xpath("//li[@id='showsub']/parent::ul"))).perform();
		pause(3000);
		driver.get(getElementPresentDOM(editUser).getAttribute("href"));

	}

	@Test
	public void changePassword() {
		Login();
		navigateToEditUser();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtpassword")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtnewpass")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtrenewpass")));
		inputTextJavaScriptValue(By.id("txtpassword"), pass);
		inputTextJavaScriptValue(By.id("txtnewpass"), "Ngocdinh08@");
		inputTextJavaScriptValue(By.id("txtrenewpass"), "Ngocdinh08@");
		click(By.xpath("//form[@id='frmPassword']/button"));

		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
