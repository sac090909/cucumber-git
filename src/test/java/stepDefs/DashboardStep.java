package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.List;

import javax.sound.sampled.Line;

import org.apache.commons.lang3.RandomStringUtils;

public class DashboardStep {

	WebDriver driver;
	private Context context;

	public DashboardStep(Context context) {
		this.context = context;

	}

	RandomStringUtils random = new RandomStringUtils();

	String name = "Name" + random.randomAlphabetic(3);
	String email = "name@" + random.randomNumeric(2) + "@gmail.com";

	DashboardPage dashboardPage;
	LoginPage loginPage;
	
	@Given("At login page using valid username and password user in dashboard page")
	public void at_login_page_using_valid_username_and_password_user_in_dashboard_page(DataTable table) {
		System.out.println("Background - Dashboard");
		
		List <List<String>> data = table.cells();
		driver = context.getDriver();
		driver.get("http://techfios.com/test/billing/?ng=login/");
		loginPage = new LoginPage(driver);
		loginPage.getUsernamePassword(data.get(0).get(0), data.get(0).get(1));
		loginPage.clickOnLogin();
		
		dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.getDashboardPageHeader());

		
	}
	
	
/*
	@Given("using username {string} and password {string} in dashboard page")
	public void using_username_and_password_in_dashboard_page(String username, String password) {

		System.out.println("Background - Dashboard");
		driver = context.getDriver();
		driver.get("http://techfios.com/test/billing/?ng=login/");
		loginPage = new LoginPage(driver);
		loginPage.getUsernamePassword(username, password);
		loginPage.clickOnLogin();
		dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.getDashboardPageHeader());

	}
*/
	@When("user navigates CRM ----> Add Contact")
	public void user_navigates_crm_add_contact() throws InterruptedException {

		dashboardPage.clickOnCRM();
		Thread.sleep(1000);
		dashboardPage.clickOnAddContact();

	}

	@Then("Add Contact page is displayed")
	public void add_contact_page_is_displayed() throws InterruptedException {
		
		Thread.sleep(1000);
		dashboardPage.getContactHeader();

	}

	@When("user enters information")
	public void user_enters_information(DataTable table) throws InterruptedException {

		List<List<String>> data = table.cells();
		Thread.sleep(1000);
		dashboardPage.setFullName(data.get(0).get(1).concat(name));
		dashboardPage.setEmail(data.get(1).get(1).concat(email));

	}

	@And("submit the form")
	public void submit_the_form() {

		dashboardPage.clickOnSubmitButton();

	}

	@Then("added infromation should display")
	public void added_infromation_should_display() {

	}

}
