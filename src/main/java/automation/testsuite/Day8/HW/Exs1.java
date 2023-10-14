package automation.testsuite.Day8.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Exs1 extends CommonBase {
	@BeforeMethod
	public void init() {
		driver = initDriverTest("https://selectorshub.com/xpath-practice-page/");
		
	}
	@Test
	public void getLocation() {
		WebElement email = driver.findElement(By.id("userId"));
		WebElement pwrd = driver.findElement(By.id("pass"));
		WebElement company = driver.findElement(By.name("company"));
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='mobile number']"));
		System.out.println("email location  : "+email);
		System.out.println("password location  : "+pwrd);
		System.out.println("company location  : "+company);
		System.out.println("phoneNumber location  : "+phoneNumber);
	}

}
