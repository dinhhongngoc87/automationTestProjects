package automation.testsuite.Day8.HW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Exs2 extends CommonBase {
	
	@BeforeMethod
	public void init() {
		driver = initDriverTest("https://automationfc.github.io/basic-form/index.html");
		
	}
	@Test
	public void getLocation() {
		
		WebElement name = driver.findElement(By.id("name"));
		WebElement address = driver.findElement(By.id("address"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("name location  : "+name);
		System.out.println("address location  : "+address);
		System.out.println("email location  : "+email);
		System.out.println("password location  : "+password);
	}

}
