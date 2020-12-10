package project_session;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity_5 {
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
    
    @Test (priority=0)
    public void navigateToLoginPage() {

    	// Wait for page to load
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.Button")));
    	  	
    	// Scroll to To-Do List
    	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form\"))")).click();

    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"password\")")));

    }

    @Test (priority=1)
    public void successLogin() {

    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
    	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();

    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")));
    	
    	String successTxt = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
    	Assert.assertEquals("Welcome Back, admin", successTxt);
    	
    }
    
    @Test (priority=2)
    public void failureLogin() {

    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
    	driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("Password");
    	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();

    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")));
    	
    	String successTxt = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
    	Assert.assertEquals("Invalid Credentials", successTxt);
    	
    }
    

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
