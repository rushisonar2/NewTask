package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {
	public AppiumDriver driver;

    @FindBy(id = "title")
    private WebElement title;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy (name="q")
	WebElement searchBox ;
    WebElement searchdata;
    
    public void enterSearchData(String string) throws InterruptedException {
    	driver.get("https://www.google.com");
		searchBox.sendKeys("Uplers");
		
		 WebElement element =driver.findElement(By.linkText("https://www.uplers.com"));
		 element.click();
	}
	public void PressenterKeyOnSearchBox() {
		searchBox.sendKeys(Keys.RETURN);
	}
	
public String getTitle() {
        return title.getText();
        }

}
