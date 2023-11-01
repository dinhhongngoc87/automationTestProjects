package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
public static String webURL = "https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/events";	
public static By textBoxEmail = By.id("email");
public static By textBoxPassword = By.id("password");
public static By btnLogin= By.xpath("//button[@type='submit' and text()='Sign in']");
public static By userDropdown = By.xpath("//a[@id='user-dropdown']");
public static By btnLogout = By.xpath("//a[text()=' Sign Out']");

}
