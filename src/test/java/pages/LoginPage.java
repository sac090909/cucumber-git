package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(how=How.ID, using ="username") WebElement userName;
	@FindBy(how=How.ID, using="password") WebElement passWord;
	@FindBy(how=How.NAME, using="login") WebElement loginBtn;

	public void getUsernamePassword(String uname, String pwd) {
		userName.sendKeys(uname);
		passWord.sendKeys(pwd);
	}

	public void clickOnLogin() {
		loginBtn.sendKeys(Keys.RETURN);
		
	}
	

}
