package automation.testsuite.Day12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_Multicheckbox extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	public void multiCheckbox1() {
		List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
		System.out.println("Tong so luong checkbox : "+listCheckbox.size());
		for(int i = 0; i< listCheckbox.size(); i++) {
			WebElement checkbox = listCheckbox.get(i);
			if(checkbox.isSelected()==true) {
				System.out.println("Checkbox ở vị trí thứ "+(i+1)+" đã được check");
			}else {
				checkbox.click();
			}
		}
		pause(2000);
	}
	
	@Test
	public void multiCheckbox3() {
		List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
		System.out.println("Tong so luong checkbox : "+listCheckbox.size());
		for(int i = 0; i< listCheckbox.size(); i++) {
			WebElement checkbox = driver.findElement(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']["+(i+1)+"]//input"));
			System.out.println("Checkbox ở vị trí thứ "+(i+1)+" có trạng thái là: "+checkbox.isSelected());
			if(checkbox.isSelected()==false) {
				checkbox.click();			}
			
		}
		pause(2000);
		driver.close();	
	}
	
	
}
