package utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass extends ExtentReports {
	
	public static AndroidDriver driver;
	public static ExtentReports extents;
	public static ExtentSparkReporter spark;
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
	
	
}
