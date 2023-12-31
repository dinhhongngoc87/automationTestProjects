package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
public static String webURL = "https://rise.fairsketch.com/signin";	
public static By textBoxEmail = By.id("email");
public static By textBoxPassword = By.id("password");
public static By btnLogin= By.xpath("//button[@type='submit' and text()='Sign in']");
public static By userDropdown = By.xpath("//a[@id='user-dropdown']");
public static By btnLogout = By.xpath("//a[text()=' Sign Out']");
public static By dasboardText = By.xpath("//ul[@id='sidebar-menu']/descendant::span[text()='Dashboard']");
public static String WEB_ALADA = "https://alada.vn/";
public static String CODESTAR = "https://codestar.vn/";
}
