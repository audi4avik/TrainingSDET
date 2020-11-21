package project_LMS;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class VerifyContactForm {
WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		  
		  driver = new FirefoxDriver();
		  driver.get("https://alchemy.hguy.co/lms");
		  
	}
	
	@Test
	public void contactFormTest() {
		  
		  driver.findElement(By.xpath("//a[text()='Contact']")).click();
		  
		  String contactHeading = "//h1[contains(text(),'Need Help?')]";
	      boolean headingVisible = driver.findElement(By.xpath(contactHeading)).isDisplayed();
	      
	      if (headingVisible == true) {
	    	
	    	WebElement fullName = driver.findElement(By.id("wpforms-8-field_0"));
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();", fullName);
		    
	    	driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Avik D");
	    	driver.findElement(By.id("wpforms-8-field_1")).sendKeys("avdatta@example.com");
	    	driver.findElement(By.id("wpforms-8-field_3")).sendKeys("SDET Course");
	    	driver.findElement(By.id("wpforms-8-field_2")).sendKeys("So far so good!");
	    	driver.findElement(By.id("wpforms-submit-8")).click();
	    	
	    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    	
	    	String messageSuccess = "Thanks for contacting us! We will be in touch with you shortly.";
	    	   	
	    	String actualTxt = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']/p")).getText();
	    	
	    	Assert.assertEquals(messageSuccess, actualTxt);
	    	
	    	
	      }
	      
	      else {
	    	  System.out.println("Contact page not loaded!");
	      }  
				  
	}
	  
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
