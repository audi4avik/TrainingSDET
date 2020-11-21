package project_LMS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class VerifyCourseComplete {
WebDriver driver;
  
	@BeforeClass
	public void beforeClass() {
		
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	
	}
	
	@Test
	public void testCourseComplete() {
		
		driver.findElement(By.linkText("All Courses")).click();
		  
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  
		driver.findElement(By.xpath("//article[@id='post-69']//a/img")).click();
		
		String courseImg = "//div[@class='post-thumb-img-content post-thumb']";
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(courseImg)));
		
		String loginLocator = "//a[text()='Login to Enroll']"; 
		
		WebElement loginLink = driver.findElement(By.xpath(loginLocator));
		
		//Scroll element into view
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", loginLink);
	    
	    driver.findElement(By.xpath(loginLocator)).click();
	    
	    // Input login creds
	    
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
	    
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		JavascriptExecutor course = (JavascriptExecutor) driver;
		course.executeScript("window.scrollTo(0, document.body.scrollHeight)");

//		String courseLocator = "//span[text()='Monitoring & Advertising']";
//		
//		WebElement course = driver.findElement(By.xpath(courseLocator)) ;
//		
//		JavascriptExecutor courseJs = (JavascriptExecutor) driver;
//		courseJs.executeScript("arguments[0].scrollIntoView();", course);
		
		driver.findElement(By.xpath("(//div[@class='ld-item-title'])[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='Monitoring & Advertising']")).click();
		
		String courseHeading = "//div[@class='ld-focus-content']/h1";
		
		WebDriverWait waitforCourse = new WebDriverWait(driver, 10);
		waitforCourse.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(courseHeading)));
		
		
		try{
			 driver.findElements(By.xpath("(//input[@value='Mark Complete'])[1]"));
			 //Since, no exception, so element is present
			 driver.findElement(By.xpath("completeBtn")).click();
			 System.out.println("Course is marked completed successfully!");
			 
			}
		catch(NoSuchElementException e){
			 //Element is not present
			 System.out.println("Course is already completed!");
			}

	}
	  
	
	@AfterClass
	public void afterClass() {
	
		driver.quit();
	}

}
