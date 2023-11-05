package pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class EditUserInfoPageFactory {
	private WebDriver driver;

	public EditUserInfoPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtpassword")
	private WebElement txtOldPassword;
	@FindBy(id = "txtnewpass")
	private WebElement txtNewPassword;
	@FindBy(id = "txtrenewpass")
	private WebElement txtRenewPassword;
	@FindBy(xpath  = "//button[text()='Lưu mật khẩu mới']")
	private WebElement btnSaveNewPass;
	
	public void ChangePassword(String oldPass, String newPass) {
		txtOldPassword.clear();
		txtOldPassword.sendKeys(oldPass);
		
		txtNewPassword.clear();
		txtNewPassword.sendKeys(newPass);
		
		txtRenewPassword.clear();
		txtRenewPassword.sendKeys(newPass);
		
		btnSaveNewPass.click();
		
	}

}
