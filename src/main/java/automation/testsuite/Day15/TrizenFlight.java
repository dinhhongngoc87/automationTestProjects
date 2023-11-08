package automation.testsuite.Day15;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import pageLocator.TrizenFlightFactory;


public class TrizenFlight extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
	}
	
	@Test
	public void chooseDateTimeSuccessfully() {
		TrizenFlightFactory trizenFlight = new TrizenFlightFactory(driver);
		trizenFlight.chooseDateTime("25082023");
	}
	
	
}
