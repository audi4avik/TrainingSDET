package project_session;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_3 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "380d0e41");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);
        
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void addActivities() {
    	
		// Click add new task
    	driver.findElementByAccessibilityId("New text note").click();
    	
    	// Wait for input box
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
    	
        // Add note title and content
    	driver.findElementById("editable_title").sendKeys("Reminder");
    	driver.findElementById("edit_note_text").sendKeys("This is a reminder created with appium");
    	
    	// Click on add reminder icon
    	driver.findElementByAccessibilityId("Reminder").click();
    	
    	// Wait for reminder box
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Add reminder\")")));
        
        // Select time from dropdown
        driver.findElementById("time_spinner").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Evening\")")));
        
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Evening\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
    	
    	driver.findElementByAccessibilityId("Navigate up").click();
    	
    	// Wait for the main screen
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("androidx.cardview.widget.CardView")));
	
        driver.findElementById("browse_note_interior_content").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("reminder_chip")));
        String getTime = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Today, 6:00 pm\")")).getText();
        
    	// Assert the tasks added
    	System.out.println(getTime);
    	Assert.assertEquals("Today, 6:00 pm", getTime);

    }
    

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
