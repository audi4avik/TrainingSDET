package project_LMS;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class VerifyLoginFeature {
WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.get("https://alchemy.hguy.co/lms");
		  
	  }
	
	  @Test
	  public void loginTest() {
		  
		//Find the navigation item
		  driver.findElement(By.linkText("My Account")).click();
		  	  
		  // Get the page title
		  String pageTitle = driver.findElement(By.xpath("//h1")).getText().strip();
		  
		  Assert.assertEquals("My Account", pageTitle);
		  
		  System.out.println ("We are on my account page");
		  
		  // Click on login link and input data
		  driver.findElement(By.xpath("//a[@href='#login']")).click();
		  
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  
		  driver.findElement(By.id("user_login")).sendKeys("root");
		  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		  driver.findElement(By.id("wp-submit")).click();
		  
		  //Scroll element into view
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,200)", "");
		  
		  //Explicit wait for the element to be visible
		  String editProfile = "//a[text()='Edit profile']";
		  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editProfile)));
		  
		  
		  // Assert the my profile page element
		  String myProfile = driver.findElement(By.xpath(editProfile)).getText();
		  
		  Assert.assertEquals("Edit profile", myProfile);
		  
		  System.out.println("Login test successful!");
		  
	  }
	  
	  
	
	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}
