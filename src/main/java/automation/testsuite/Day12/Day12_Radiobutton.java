package automation.testsuite.Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_Radiobutton extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}
	@Test
	public void handleRadioButton() {
		WebElement femaleRadio = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
		
		if(femaleRadio.isSelected()==false && femaleRadio.isEnabled()==true) {
			femaleRadio.click();
		}
	}

	
	

}
