package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass {
	public AppiumDriver driver;

    @FindBy(id = "Email")
    private WebElement EmailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "error-message")
    private WebElement errorMessage;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
public void Apply() {
	WebElement ApplyasTalent =null;
	driver.findElement (By.xpath("//div[@class='main-header']//div[@class='row align-items-center']"));
	ApplyasTalent.click();
	
	WebElement CandidateLogin = null;
	driver.findElement(By.xpath("//a[@id='nav_sign_in']"));
	CandidateLogin.click();
	
	driver.findElement(By.xpath("//h2[normalize-space()='Welcome!'] ")).getText();
	
}
    public void enteremail(String email) {
    	WebElement EmailFeild ;
    	driver.findElement(By.xpath("//input[@id='Username']"));
        EmailField.sendKeys(email);
    }

    public void enterPassword(String password) {
    	WebElement passwordFeild ;
    	driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
    	driver.findElement(By.xpath("(//button[normalize-space()='LOG IN'])[1]"));
        loginButton.click();
    }
    
    public void verifyHomePage() {
    	WebElement Title ;
    	driver.findElement(By.xpath("//h2[normalize-space()='All Jobs']")).getText();
    	System.out.println("All Jobs");
    }

    public String getErrorMessage() {
    	driver.findElement(By.xpath("//div[@class='error']"));
        return errorMessage.getText();
    }
	public void sendKeys(String string) {
		
	}
	
}
