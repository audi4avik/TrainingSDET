package project_LMS;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class VerifySecondPopularCourse {
	WebDriver driver;
	
	 @BeforeClass
	  public void beforeClass() {
		 
		 driver = new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms/");

		 
	  }
	
	
	@Test
	 public void validateTestCase() {
		  
		  WebElement Element = driver.findElement(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 '][2]"));
		  
		  //This will scroll the page till the element is found	
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("arguments[0].scrollIntoView();", Element);
	      
	      // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	      
	      // pause execution to make the actions visible
	      try{
	    	  Thread.sleep(3000);
	      }
	      catch(InterruptedException ie){
	      }

	      String courseTitle = driver.findElement(By.xpath("//h3[starts-with(text(),'Email Marketing')]")).getText();
	         
	      System.out.println("The second popular course title: " +courseTitle);
	      
	      Assert.assertEquals("Email Marketing Strategies", courseTitle);
	      System.out.println("Assertion successful, test completed!");
		
	 }
  

	@AfterClass
	 public void afterClass() {
		driver.quit();
	 }

}
