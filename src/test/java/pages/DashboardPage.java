package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DashboardPage {

	WebDriver driver;
	//String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]")
	WebElement dashboardPageHeader;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'CRM')]")
	WebElement crmMenu;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Contact')]")
	WebElement addContactMenu;
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Contacts ')]")
	WebElement contactHeader;

	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement fullName;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement email;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement submitBtn;
	
	public boolean getDashboardPageHeader() {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("D display" + timeStamp);
		return dashboardPageHeader.isDisplayed();

	}

	public void clickOnCRM() {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("CRM" + timeStamp);
		crmMenu.click();
		
	}
	
	public void clickOnAddContact() {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("Add Contact" + timeStamp);
		
		addContactMenu.click();
		
	}
	
	public boolean getContactHeader() {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("Contact Header" + timeStamp);
		return contactHeader.isDisplayed();

	}
	

	public void setFullName(String name) {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("FullName" + timeStamp);
		fullName.sendKeys(name);
		
	}

	public void setEmail(String emailID) {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("Email" + timeStamp);
		email.sendKeys(emailID);
		
	}
	
	public void clickOnSubmitButton() {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("Submit" + timeStamp);
				submitBtn.click();
		
	}
	
}

