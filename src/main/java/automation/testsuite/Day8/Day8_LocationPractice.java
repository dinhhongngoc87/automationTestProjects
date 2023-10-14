package automation.testsuite.Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day8_LocationPractice extends CommonBase {

	@BeforeMethod
	public void initChromeDriver() {
		initChromeDriver("https://bepantoan.vn/danh-muc/may-hut-mui-am-tu");
	}
	
	@Test
	public void findLocatorById () {
		
		WebElement elem1 =  driver.findElement(By.partialLinkText("Âm Tủ"));
		System.out.println("locator is : "+elem1);
	}
	
}
