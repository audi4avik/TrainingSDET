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
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_4 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "380d0e41");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
        
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
        
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void todoList() {

    	// Wait for page to load
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.Button")));
    	  	
    	// Scroll to To-Do List
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"To-Do List\"))")).click();

    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	
    	String clearBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]";
    	// Add Task
    	driver.findElementByXPath(clearBtn).click();
    	
    	String[] taskList = {"Add tasks to list", "Get number of tasks", "Clear the list"};
    	int i;

    	for (i=0; i<taskList.length; i++) {
    		
	    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys(taskList[i]);
	    	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
    	
    	}
    	
    	driver.findElementByXPath("//*[@text='Add tasks to list']").click();
    	driver.findElementByXPath("//*[@text='Get number of tasks']").click();
    	driver.findElementByXPath("//*[@text='Clear the list']").click();
    	
    	driver.findElementByXPath(clearBtn).click();
    	
    	
    	List<MobileElement> tasks = driver.findElementsByXPath("//*[@id='tasksList']");
    	
    	Assert.assertEquals(0, tasks.size());

    }
    

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
