package automation.testsuite.Day17;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class IFrame extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_Account.CODESTAR);
	}

	@Test
	public void findIFrameIndex() {
		pause(20000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Tổng số frame: "+ size);
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			int indexIFrame = driver.findElements(By.xpath("//button[text()='Đăng ký ngay']")).size();
			System.out.println(indexIFrame);// frame 3
			driver.switchTo().defaultContent();
		}

	}
	@Test
	public void handleIFrame() {
		scrollToElement(By.xpath("//h2[contains(text(),'Đăng ký nhận tài liệu')]"));
		driver.switchTo().frame(3);
		type(By.xpath("//input[@name='account_name']"),"AutoTestName" );
		click(By.xpath("//button[text()='Đăng ký ngay']"));
		assertTrue(isElementPresent(By.xpath("//button[text()='Đăng ký ngay']")));
		driver.switchTo().defaultContent();
	}
	
	
	

	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
