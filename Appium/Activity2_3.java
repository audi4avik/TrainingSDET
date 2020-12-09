package appium_session;

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

public class Activity2_3 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "380d0e41");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void addContact() {
        // Click on add new contact floating button
        driver.findElementByAccessibilityId("Add").click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("name_container")));
        
        // Find the first name and phone number fields
        MobileElement name = driver.findElement(MobileBy.AndroidUIAutomator("className(\"android.widget.EditText\")"));
        name.sendKeys("Avik D");
        
        MobileElement phoneNumber = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Phone\")"));
        phoneNumber.sendKeys("9134567890");
        
        // Save the contact
        driver.findElementByAccessibilityId("OK").click();
        
        // Wait for contact card to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("title_container")));

        // Assertion
        MobileElement mobileCard = driver.findElementById("custom_title");
        Assert.assertTrue(mobileCard.isDisplayed());
        
        String contactName = driver.findElementById("custom_title").getText();
        Assert.assertEquals("Avik D", contactName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}