package project_LMS;

import org.testng.annotations.Test;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class VerifyWebsiteHeading {
WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        
	}
    
    @BeforeMethod
    public void beforeMethod() {

    	//Log the start of test
    	System.out.println("Heading test starts");
    	
    	// Implicit wait
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
 
    @Test
    public void headingTestCase() {
    	
    
        // Get text from the page heading
        WebElement headingTxt = driver.findElement(By.xpath("//h1[contains(text(),'Learn from Industry Experts')]"));
        
        String pageHeading = headingTxt.getText().strip();
        		 
        // Assert the heading text
        Assert.assertEquals("Learn from Industry Experts", pageHeading);
        
    }                

    @AfterMethod
    public void afterMethod() {
        //Log the end of test
    	System.out.println("Website heading test is completed");
        
    }
    
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.quit();
    }

}
