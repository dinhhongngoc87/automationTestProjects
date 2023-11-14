package automation.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonBase1 {
	public WebDriver driver;
	public int initWaitTime = 10;

	public WebDriver initChromeDriver(String URL) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(initWaitTime, TimeUnit.SECONDS);
		return driver;
	}

	public void inputTextJavaScriptInnerHTML(By inputElement, String innerText) {
		WebElement element = getElementPresentDOM(inputElement);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + innerText + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(2000);
			inputTextJavaScriptInnerHTML(inputElement, innerText);
		}
	}

	public void inputTextJavaScriptValue(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value',arguments[1])", element,value);
		} catch (StaleElementReferenceException e) {
			pause(1000);
			inputTextJavaScriptValue(locator, value);
		}
	}

	public void scrollToElement(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public boolean isElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
		return getElementPresentDOM(locator).isDisplayed();
	}
	
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}

	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
							
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//get absolute path of file 
	public String getAbsoluteFilePath(String relativeFilePath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir+relativeFilePath;
		return absolutePath;
	}
	public void quitDriver(WebDriver driver) {
		if(driver.toString().contains("null")) {
			System.out.println("All browswe windows are closed");
		}else {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.close();
		}
	}

}
