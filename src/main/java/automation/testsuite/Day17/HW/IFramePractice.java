package automation.testsuite.Day17.HW;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase1;

public class IFramePractice extends CommonBase1 {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://codestar.vn/");
	}
	
	public void findIndexIFrameChatbox() {
		pause(10000);
		int iframeSize = driver.findElements(By.tagName("iframe")).size();
		for(int i = 0; i< iframeSize; i++) {
			driver.switchTo().frame(i);
			int indexFrame = driver.findElements(By.xpath("//span[normalize-space()='Bắt đầu chat']")).size();
			System.out.println("index: "+i+"-"+indexFrame);//5
			driver.switchTo().defaultContent();
		}
	}

	public void findIndexIFrameRegistration() {
	pause(10000);
	int iframeSize = driver.findElements(By.tagName("iframe")).size();
	System.out.println("Size: "+iframeSize);
	for(int i = 0; i< iframeSize; i++) {
		driver.switchTo().frame(i);
		int sizeFrame = driver.findElements(By.xpath("//button[normalize-space()='Gửi ngay']")).size();
		System.out.println(i+" - "+sizeFrame);//1
		driver.switchTo().defaultContent();
	}
	}
	@Test
	public void handleFrameChatBox() {
		pause(10000);
		driver.switchTo().frame(5);
		click(By.xpath("//span[normalize-space()='Bắt đầu chat']"));
		assertTrue(driver.findElement(By.xpath("//div[normalize-space()='Đăng nhập']")).isDisplayed());
		
		
	}
	
	@Test
	public void handleFrameRegistration() {
		pause(2000);
		scrollToElement(By.xpath("//h2[contains(normalize-space(),'Đăng kí nhận tư vấn lộ trình')]"));
		driver.switchTo().frame(1);
		type(By.xpath("//input[@id='account_phone']"), "0392109981");
		click(By.xpath("//button[@type='submit' and normalize-space()='Gửi ngay']"));
		assertTrue(driver.findElement(By.xpath("//button[@type='submit' and normalize-space()='Gửi ngay']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeChrome() {
		quitDriver(driver);
	}
}
