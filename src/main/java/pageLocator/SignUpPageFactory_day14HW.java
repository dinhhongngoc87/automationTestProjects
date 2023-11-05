package pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageFactory_day14HW {
	private WebDriver webdriver;

	public SignUpPageFactory_day14HW(WebDriver _driver) {
		this.webdriver = _driver;
		PageFactory.initElements(webdriver, this);
	}

	@FindBy(id = "txtFirstname")
	private WebElement txtName;
	@FindBy(id = "txtEmail")
	private WebElement txtEmail;
	@FindBy(id = "txtCEmail")
	private WebElement txtCEmail;
	@FindBy(id = "txtPassword")
	private WebElement txtPassword;
	@FindBy(id = "txtCPassword")
	private WebElement txtCPassword;
	@FindBy(id = "txtPhone")
	private WebElement txtPhone;
	@FindBy(id = "chkRight")
	private WebElement chkRight;
	@FindBy(xpath = "//button[@type='submit' and text()='ĐĂNG KÝ']")
	private WebElement btnSubmit;

	public void SignUp(String name, String email, String cEmail, String pass, String cPass, String phone) {
		// name
		txtName.clear();
		txtName.sendKeys(name);
		// Email
		txtEmail.clear();
		txtEmail.sendKeys(email);
		// cEmail
		txtCEmail.clear();
		txtCEmail.sendKeys(cEmail);
		// pass
		txtPassword.clear();
		txtPassword.sendKeys(pass);
		// cPass
		txtCPassword.clear();
		txtCPassword.sendKeys(cPass);
		// phone
		txtPhone.clear();
		txtPhone.sendKeys(phone);
		
		if(!chkRight.isSelected()) {
			chkRight.click();
		}
		btnSubmit.click();

	}
}
