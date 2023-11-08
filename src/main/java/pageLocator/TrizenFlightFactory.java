package pageLocator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TrizenFlightFactory {
	WebDriver driver;
//	JavascriptExecutor excecutor;

	public TrizenFlightFactory(WebDriver driver) {
		this.driver = driver;
//		this.excecutor = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "(//label[text()='Departing']/following-sibling::div/input[@name='daterange-single' and @readonly])[1]") WebElement departingDate;
	@FindBy(xpath = "//ul[@id='myTab3']/li")
	WebElement listFlight;
	@FindBy(xpath = "//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Departing']/following-sibling::div/input")
	WebElement departing;
	@FindBy(xpath = "//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Passengers']/following-sibling::div//label[text()='Adults']/following-sibling::div//i[@class='la la-plus']")
	WebElement btnIncPassenger;

	@FindBy(xpath = "//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Coach']/following-sibling::div//select")
	WebElement selectCoach;

	@FindBy(xpath = "//div[@id='myTabContent3']//div[@id='one-way']//form/div[last()]/a")
	WebElement btnSearch;

	public void chooseDateTime(String datetime) {
		
		WebElement departingDate = driver.findElement(By.xpath(
				"(//label[text()='Departing']/following-sibling::div/input[@name='daterange-single' and @readonly])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", departingDate);
		departingDate.clear();
		departingDate.sendKeys(datetime);
		departingDate.sendKeys(Keys.TAB);
		
	}

	public void choosePassengers(String adultQty) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int qty = Integer.valueOf(adultQty);
		WebElement dropdownPassenger = driver.findElement(By.xpath(
				"//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Passengers']/following-sibling::div/div"));
		WebElement btnIncAdult = driver.findElement(By.xpath(
				"//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Passengers']/following-sibling::div//label[text()='Adults']/following-sibling::div//i[@class='la la-plus']"));
		js.executeScript("arguments[0].click()", dropdownPassenger);
		for (int i = 0; i < qty; i++) {
			js.executeScript("arguments[0].click()", btnIncAdult);
		}
	}

	public void chooseCoach(String coach) {
		Select selectCoach = new Select(driver.findElement(By.xpath(
				"//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Coach']/following-sibling::div//select")));
		assertFalse(selectCoach.isMultiple());
		
		selectCoach.selectByVisibleText(coach.trim());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(coach.trim()+" and "+selectCoach.getFirstSelectedOption().getText().trim());
//		assertEquals(coach.trim(), selectCoach.getFirstSelectedOption().getText().trim());

	}

	public void chooseWay(String way) {
		List<WebElement> flightList = driver.findElements(By.xpath("//ul[@id='myTab3']/li/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement webElement : flightList) {
			System.out.println("1:" + webElement.getText().trim() + "   2:" + way.trim());
			if (webElement.getText().equalsIgnoreCase(way.trim())) {
				js.executeScript("arguments[0].click()", webElement);
				js.executeScript("arguments[0].setAttribute('class','nav-link active')", webElement);

			}
		}
	}

	public void fillInput(String flyingFrom, String Flyingto) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement txtFlightFrom = driver.findElement(By.xpath(
				"//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Flying from']/following-sibling::div/input"));

		js.executeScript("arguments[0].setAttribute('value',arguments[1])", txtFlightFrom, flyingFrom);
		WebElement txtFlightTo = driver.findElement(By.xpath(
				"//div[@id='myTabContent3']//div[@id='one-way']//label[text()='Flying to']/following-sibling::div/input"));

		js.executeScript("arguments[0].setAttribute('value',arguments[1])", txtFlightTo, Flyingto);

	}

	public void searchFlight(String way, String flyingFrom, String Flyingto, String departingDate, String passenger,
			String coach) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		chooseWay(way);
		Thread.sleep(3000);

		fillInput(flyingFrom, Flyingto);
		Thread.sleep(3000);

		chooseDateTime(departingDate);
		
		Thread.sleep(3000);
		choosePassengers(passenger);
		Thread.sleep(3000);
		chooseCoach(coach);
		Thread.sleep(3000);
		WebElement btnSearch = driver.findElement(By.xpath(
				"//div[@id='myTabContent3']//div[@id='one-way']//form/div[last()]/a"));
		js.executeScript("arguments[0].click()",btnSearch);
		

		

	}

}
