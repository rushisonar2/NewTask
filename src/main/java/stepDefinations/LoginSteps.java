package stepDefinations;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.util.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseClass;

public class LoginSteps extends BaseClass {
	LoginPage pg;
	HomePage hg;
	
	
	@Before
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities capabilities =new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","samsung SM-A910F");
		capabilities.setCapability("udid","17685585");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("automationName","Uiautomator2");
		capabilities.setCapability("plarformversion","8.0");
		
		capabilities.setCapability("appium:newCommandTimeout","60");
		capabilities.setCapability("chromeDriverExcutiable","C:\\Users\\RUSHI\\OneDrive\\Desktop\\TaskAutomation\\TaskAutomation\\drivers");
		
		URL url=URI.create("htts://127.0.0.1:4723/").toURL();
		driver =new AndroidDriver(url,capabilities);
		
		extents =new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark.htmal");
		extents.attachReporter(spark);
	}
	@After
	public void teatDown() {
		driver.close();
		driver.quit();
		extents.flush();
		
	}
	
	@Given("I am on Upler Page")
	public void i_am_on_Upler_Page() {
		driver.get("https://www.google.com");
		pg.sendKeys("Uplers");
		
	WebElement element =driver.findElement(By.linkText("https://www.uplers.com"));
		 element.click();
		
		driver.findElement(By.xpath("//h3[normalize-space()='Login']")).click();
		
		
	}


    @When("I enter username as {string}")
    public void enterUsername(String email) {
    	driver.findElement(By.xpath("//input[@id='email']"));
        pg.enteremail(email);
    }

    @When("I enter password as {string}")
    public void enterPassword(String password) {
    	driver.findElement(By.xpath("//input[@id='password']"));
        pg.enterPassword(password);
    }

    @When("I login")
    public void login() {
    	driver.findElement(By.xpath("(//button[normalize-space()='LOG IN'])[1]"));
        pg.clickLogin();
    }

    @Then("I should see Home page with title {string}")
    public void verifyHomePageTitle(String expectedTitle) {
    driver.findElement(By.xpath("//h2[normalize-space()='All Jobs']")).getText();
    System.out.println("All Jobs");
    }

    @Then("login should fail with an error {string}")
    public void verifyLoginError(String expectedError) {
    	driver.findElement(By.xpath("By.xpath(\"//div[@class='error']\")")).getText();
    	 System.out.println("Password is icorrect");
    }
	
}
