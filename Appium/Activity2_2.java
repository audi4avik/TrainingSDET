package appium_session;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity2_2 {
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "380d0e41");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", ".cal.CalculatorActivity");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);
        
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test (priority=2)
    public void add() {
    	// Find elements by Id (resource-id)
        driver.findElementById("btn_9_s").click();
        driver.findElementById("btn_plus_s").click();
        driver.findElementById("btn_5_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String addResult = driver.findElementById("result").getText().substring(2);
        System.out.println(addResult);
        Assert.assertEquals(addResult, "14");
        
        driver.findElementByAccessibilityId("clear").click();
    }
    
    @Test (priority=3)
    public void subtract() {
    	driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        // Find element with Accessibility Id (content-desc)
        driver.findElementByAccessibilityId("minus").click();
        driver.findElementById("btn_5_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String subResult = driver.findElementById("result").getText().substring(2);
        System.out.println(subResult);
        Assert.assertEquals(subResult, "5");
        
        driver.findElementByAccessibilityId("clear").click();
    }

    @Test (priority=1)
    public void multiply() {
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_mul_s").click();
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_0_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String mulResult = driver.findElementById("result").getText().substring(2);
        System.out.println(mulResult);
        Assert.assertEquals(mulResult, "500");
        
        driver.findElementByAccessibilityId("clear").click();
    }

    @Test (priority=0)
    public void divide() {
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_div_s").click();
        driver.findElementById("btn_2_s").click();
        // Perform Calculation
        driver.findElementById("btn_equal_s").click();

        // Display Result
        String divResult = driver.findElementById("result").getText().substring(2);
        System.out.println(divResult);
        Assert.assertEquals(divResult, "25");
        
        driver.findElementByAccessibilityId("clear").click();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}