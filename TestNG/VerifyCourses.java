package project_LMS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class VerifyCourses {
WebDriver driver;

	  @BeforeClass
	  public void beforeClass() {
		  
		  driver = new FirefoxDriver();
		  driver.get("https://alchemy.hguy.co/lms");
		  
	  }
	
	  @Test
	  public void courseTest() {
		    
		  driver.findElement(By.linkText("All Courses")).click();
		  
		  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  
		  List<WebElement> courses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
		  
		  int courseCount = courses.size();
		  
		  System.out.println("The number of course is: " +courseCount);
	  }
	  	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
