package project_LMS;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class VerifyMyAccountPage {
WebDriver driver;

	  @BeforeClass
	  public void beforeClass() {
		  
		  driver = new FirefoxDriver();
		  driver.get("https://alchemy.hguy.co/lms");
		  
	  }
	
	  @Test
	  public void myAccountTestCase() {
		  
		  //Find the navigation item
		  WebElement Element = driver.findElement(By.linkText("My Account"));
		  Element.click();
		  
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  // Get the page url
		  String currentUrl = driver.getCurrentUrl();
		  System.out.println("We are on: " +currentUrl);
		  
		  // Get the page title
		  String pageTitle = driver.findElement(By.xpath("//h1")).getText().strip();
		  
		  Assert.assertEquals("My Account", pageTitle);
		  
		  System.out.println ("We are on my account page");
		  
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
