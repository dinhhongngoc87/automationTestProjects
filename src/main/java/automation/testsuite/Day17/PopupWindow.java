package automation.testsuite.Day17;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class PopupWindow extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.guru99.com/popup.php");
	}
	@Test
	public void VerifyNewTab() {
		
		click(By.xpath("//a[text()='Click Here']"));
		String mainWindow = driver.getWindowHandle();
		System.out.println("main window is: "+mainWindow);
		Set<String> listSubWindows = driver.getWindowHandles();
		for(String subWindow : listSubWindows) {
			System.out.println("windows: "+ subWindow);
			if(!subWindow.equals(mainWindow)) {
				driver.switchTo().window(subWindow);
				assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/articles_popup.php");
				System.out.println("subwwindow is : "+ driver.getCurrentUrl());
				type(By.xpath("//input[@name='emailid']"), "testdemo@gmail.com");
				click(By.xpath("//input[@name='btnLogin']"));			
				driver.close();
			}
		};
		driver.switchTo().window(mainWindow);
		System.out.println("Main window: "+driver.switchTo().window(mainWindow).getTitle());
		assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/popup.php");
	}
	
	@AfterMethod 
	public void closeChrome() {
		driver.close();
	}
}
