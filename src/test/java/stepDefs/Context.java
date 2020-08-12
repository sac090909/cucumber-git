package stepDefs;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Context {

	WebDriver driver;
	//String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());

	@Before
	public void openBrowser() {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("Hook - Before" + timeStamp);
		if (driver == null) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

	}

	public WebDriver getDriver() {
		System.out.println("Method - getDriver");
		return driver;
	}

	@After
	public void closeBrowser(Scenario scenario) {

		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			final byte[] screenshort = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshort, "image/png", scenario.getName());
		}
		driver.quit();
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		System.out.println("Hook - After" + timeStamp);
		
	}

}
