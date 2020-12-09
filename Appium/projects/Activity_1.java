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

public class Activity_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "380d0e41");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);
        
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void addActivities() {
    	
    	String[] tasks = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"}; 	
    	
    	int i;
    	
    	// Loop through the task items and add task
    	
    	for (i=0; i<tasks.length; i++) {
    		
    		// Click add new task
        	driver.findElementByAccessibilityId("Create new task").click();
        	
        	// Wait for input box
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
        	
        	driver.findElementById("add_task_title").sendKeys(tasks[i]);
        	driver.findElementById("add_task_done").click();
        	
        	// Assert the tasks added
        	String taskName = driver.findElementById("task_name").getText();
        	Assert.assertEquals(tasks[i], taskName);
    		
    		
    	}

    	
    }
    

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
