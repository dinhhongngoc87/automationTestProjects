package pageLocator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {

	private WebDriver driver;

	public ClientPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientsMenu;
	
	@FindBy(xpath = "//a[@title='Add client']")
	WebElement btnAddClient;
	
	@FindBy(id="company_name")
	WebElement textCompanyName;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath ="//a[text()='Clients']")
	WebElement tabClientsList;
	
	@FindBy(xpath ="//input[@type='search']")
	WebElement textSearch;
	
	public void addNewClientFunction (String companyName) throws InterruptedException  {
		clientsMenu.click();
		btnAddClient.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnAddClient);
		Thread.sleep(3000);
		textCompanyName.sendKeys(companyName);
		btnSave.click();
		//find the record has just added
		js.executeScript("arguments[0].click();", tabClientsList);
		Thread.sleep(3000);
		textSearch.sendKeys(companyName);
	}
	
	public void searchClient(String clientName) {
		
	}
	
}
