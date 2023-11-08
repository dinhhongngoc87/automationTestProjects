package automation.testsuite.Day15.HW;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import pageLocator.TrizenFlightFactory;

public class AddFlight extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
	}
	@Test
	public void addFlightSuccessfully() throws InterruptedException {
		TrizenFlightFactory page = new TrizenFlightFactory(driver);
		page.searchFlight("One-way","Hà Nội", "TP.HCM", "08072001", "2", "Business");
		assertTrue(driver.findElement(By.xpath("//h2[text()='Flight Search Result']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
