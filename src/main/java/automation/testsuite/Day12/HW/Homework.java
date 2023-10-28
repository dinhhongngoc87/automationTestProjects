package automation.testsuite.Day12.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Homework extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.seleniumeasy.com/input-form-demo.html");
	}

	@Test
	public void handleDropdownList() {

		Select select = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		Assert.assertFalse(select.isMultiple());
		select.selectByVisibleText("Hawaii");
		Assert.assertEquals("Hawaii", select.getFirstSelectedOption().getText());
		System.out.println("Đã chọn một tùy chọn thành công");

		pause(2000);
		driver.close();
	}

	@Test
	public void handleRadiobox() {
		WebElement radio = driver.findElement(By.xpath("//input[@type='radio' and @value='yes']"));
		if (radio.isSelected()) {
			System.out.println("radiobox đã được chọn");
		} else {
			radio.click();
		}
		pause(2000);
		driver.close();
	}
}
