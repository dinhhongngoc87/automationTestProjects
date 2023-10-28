package automation.testsuite.Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_Checkbox_Radio_Dropdownlist extends CommonBase  {
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}
	@Test
	public void clickOnCheckBox() {
		WebElement defaultCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Default Checked']/input"));
		if(defaultCheckbox.isSelected()) {
			System.out.println("Pass");
		}else {
			System.out.println("Faild");
		}
		//
		WebElement testCheckbox =  driver.findElement(By.xpath("//label[normalize-space()='Click on this check box']/input"));
		if(testCheckbox.isSelected()==false) {
			testCheckbox.click();
			System.out.println("test checkbox đã được check");
		}else {
			System.out.println("test checkbox chưa được check");
		}
		
	}
}
