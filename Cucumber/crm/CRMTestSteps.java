package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRMTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    
    @Before ("@crmcount or @createleads or @createmeeting or @createproduct")
    public void openFirefox(){
        //Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://alchemy.hguy.co/crm/");
    }
    
    @Given("^User logs on to CRM website with username \"(.*)\" and password \"(.*)\"$")
    public void crmLoginPage(String uname, String passwd) {             
        
        String loginBtn = "//input[@title='Log In']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginBtn)));
        
        driver.findElement(By.id("user_name")).sendKeys(uname);
        driver.findElement(By.id("username_password")).sendKeys(passwd);
        driver.findElement(By.xpath(loginBtn)).click();
        
    }
       
    @When("^User counts the number of dashlets on homepage$")
    public void countDashlet() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='admin']")));
    	List<WebElement> dashletTitle = driver.findElements(By.xpath("//td[@class='dashlet-title']//span[2]"));
    	
    	System.out.println("The nuber of dashlets in homepage: " +dashletTitle.size());
	
    }
    
    @When("^User navigates to Create lead scetion$")
    public void gotoLead() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span//a[text()='Sales']")));
    	Actions actions = new Actions(driver);
     	WebElement menuOption = driver.findElement(By.xpath("//span//a[text()='Sales']"));
     	actions.moveToElement(menuOption).perform();
     	
     	driver.findElement(By.xpath("(//li//a[text()='Leads'])[1]")).click();
     	
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Leads')]")));
	
    }
    
    @When("^User navigates to create meeting section$")
    public void gotoMeeting() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span//a[text()='Activities']")));
    	Actions actions = new Actions(driver);
     	WebElement menuOption = driver.findElement(By.xpath("//span//a[text()='Activities']"));
     	actions.moveToElement(menuOption).perform();
     	
     	driver.findElement(By.xpath("(//li//a[text()='Meetings'])[1]")).click();
     	
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Meetings')]")));
	
    }
    
    @And("^User navigates to create product section$")
    public void gotoProduct() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span//a[text()='All']")));
    	Actions actions = new Actions(driver);
     	WebElement menuOption = driver.findElement(By.xpath("//span//a[text()='All']"));
     	actions.moveToElement(menuOption).perform();
     	
     	driver.findElement(By.xpath("(//li//a[text()='Products'])[1]")).click();
     	
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Products ')]")));
     	
     	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='Create Product']")).click();
	
    }
         
    @Then("^User prints the details of each dashlet$")
    public void dashletInfo() {
    	List<WebElement> dashletTitle = driver.findElements(By.xpath("//td[@class='dashlet-title']//span[2]"));
        for(WebElement title : dashletTitle ){
        	String titleTxt = title.getText();	
        	System.out.println(titleTxt);
        }

    }
    
    @Then("^User fills in the required details \"(.*)\" \"(.*)\" to create leads$")
    public void createLeads(String firstName, String lastName) {
    	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='Create Lead']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'OVERVIEW')]")));
    	
    	driver.findElement(By.id("first_name")).sendKeys(firstName);
    	driver.findElement(By.id("last_name")).sendKeys(lastName);

    	driver.findElement(By.xpath("(//input[@id='SAVE'])[1]")).click();
    	
    	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='View Leads']")).click();

    }
    
    @Then("^User fills in the required details for the meeting$")
    public void meetingInfo() {
    	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='Schedule Meeting']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'OVERVIEW')]")));
    	
    	driver.findElement(By.id("name")).sendKeys("SDET Scrum Meeting");
    	driver.findElement(By.id("date_start_date")).clear();
    	driver.findElement(By.id("date_start_date")).sendKeys("01/15/2021");
    	driver.findElement(By.id("date_end_date")).clear();
    	driver.findElement(By.id("date_end_date")).sendKeys("01/15/2021"); 	
    }
    
    @When("^User fills in the required details for the product \"(.*)\" and \"(.*)\"$")
    public void createProduct(String productName, String productPrice) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'CREATE')]")));
    	
    	driver.findElement(By.id("name")).sendKeys(productName);
    	driver.findElement(By.id("price")).sendKeys(productPrice);
    	
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	
    	driver.findElement(By.xpath("(//input[@id='SAVE'])[2]")).click();
    	
    }
    
    @And("^User validates the lead created successfully$")
    public void validateLead() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Leads')]")));
    	String leadName = driver.findElement(By.xpath("//td//b/a[contains(text(),'John Doe')]")).getText();
    	
    	Assert.assertEquals("John Doe", leadName);
    	
    }
    
    @And("^User selects the members \"(.*)\" for the meeting$")
    public void selectMember(String email) {
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	driver.findElement(By.xpath("//input[@id='search_email']")).sendKeys(email);
    	driver.findElement(By.id("invitees_search")).click();
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//input[@id='invitees_add_1']")).click();
    }
    
    @And("^User navigates to view meetings to confirm$")
    public void validateMeeting() {
    	driver.findElement(By.xpath("(//input[@id='SAVE_HEADER'])[2]")).click();
    	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='View Meetings']")).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Meetings')]")));
    	String meetingName = driver.findElement(By.xpath("//td//b/a[contains(text(),'SDET Scrum Meeting')]")).getText();
    	
    	Assert.assertEquals("SDET Scrum Meeting", meetingName);
    }
    

    @Then("^User navigates to view products to confirm \"(.*)\"$")
    public void validateProduct(String cnfName) {
    	driver.findElement(By.xpath("//div[@class='actionmenulink'][text()='View Products']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text'][contains(text(),'Products')]")));
    	String getName = driver.findElement(By.xpath("(//td[@scope='row']//a)[1]")).getText();
    	
    	Assert.assertEquals(cnfName, getName);
    	
    }
    
    
    @And("^Closes the browser for crm activity$")
    public void closeBrowser() {
        //Close browser
        driver.quit();
    }
}