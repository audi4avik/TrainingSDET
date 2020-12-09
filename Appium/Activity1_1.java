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


public class Activity1_1 {
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

    @Test
    public void division() {
        driver.findElementById("btn_8_s").click();
        driver.findElementById("btn_div_s").click();
        driver.findElementById("com.miui.calculator:id/btn_2_s").click();
        driver.findElementByAccessibilityId("equals").click();
        
        //Display Result
        String result = driver.findElementById("result").getText().substring(2);
        System.out.println(result);
        Assert.assertEquals(result, "4");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
