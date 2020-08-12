package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep {

	WebDriver driver;
	private Context context;
	
	public LoginStep(Context context){
		this.context=context;
	
	}
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@Given("in login page url {string}")
	public void in_login_page_url(String url) {
        System.out.println("Background - Given - Login");
		driver = context.getDriver();
		driver.get("http://techfios.com/test/billing/?ng=login/");
		
	}

	@When("user provides username {string} and password {string}")
	public void user_provides_username_and_password(String username, String password) {

			loginPage = new LoginPage(driver);
			loginPage.getUsernamePassword(username, password);
		
		
	}

	@And("click on login button")
	public void click_on_login_button() {

		loginPage.clickOnLogin();
		
	}

	@Then("user lands on dashboardpage")
	public void user_lands_on_dashboardpage() {

		dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.getDashboardPageHeader());
		
	}

}
