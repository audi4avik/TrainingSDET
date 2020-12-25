package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangeHRMTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    
    @Before ("@createjobvacancy or @addcandidate")
    public void openFirefox(){
        //Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    
    @Given("^User logs in to the OrangeHRM website$")
    public void loginToHRM() throws Throwable {	
	     //wait for the landing page
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInPanelHeading")));
	       
		 //set values to userName, password and login fields
	     driver.findElement(By.id("txtUsername")).sendKeys("orange");;
	     driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	     driver.findElement(By.id("btnLogin")).click();
	  
		  //Verify homepage has opened
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
		 
	 }
       
    @And("^User navigates to \"Recruitment\" page$")
	 public void gotoRecruitment() throws Throwable {

		 driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();


	 }
    
    @And("^User navigates to vacancies section to \"Add Job Vacancy\"$")
	 public void navigateToAddJob() throws Throwable {		  
		  driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srchVacancy")));
		  
		  driver.findElement(By.id("btnAdd")).click();

		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addJobVacancy")));
		 
	 }
    
    @And("^User clicks on the Add button to add candidate$")
	 public void navigateToAddCandidate() throws Throwable {		  
		  driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srchCandidates")));
		  
		  driver.findElement(By.id("btnAdd")).click();

		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addCandidateHeading")));
		 
	 }

    @When("^User provides the job details \"(.*)\", \"(.*)\", \"(.*)\"$")
	 public void fillJobDetails(String jobName, String vacancyName, String hiringMgr) throws Throwable {
		  
    	  WebElement titleDrpdwn = driver.findElement(By.id("addJobVacancy_jobTitle"));
		  Select dropdown=new Select(titleDrpdwn);
		  dropdown.selectByVisibleText(jobName);
		  
		  driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
		  
		  WebElement textbox = driver.findElement(By.id("addJobVacancy_hiringManager"));
		  textbox.sendKeys(hiringMgr);
		  textbox.sendKeys(Keys.ENTER);
		  
		  driver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys("5");	
		  
		  driver.findElement(By.id("btnSave")).click();
		  String text=driver.findElement(By.xpath("//div[@id='addJobVacancy']/div/h1")).getText();
		  Assert.assertEquals("The vacancy was not created", "Edit Job Vacancy", text);
		  
	 }
    
    @When("^User fills out candidate details with \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	 public void fillCandidateDetails(String fname, String lname, String email, String jobCode) throws Throwable {
		  
		  driver.findElement(By.id("addCandidate_firstName")).sendKeys(fname);
		  driver.findElement(By.id("addCandidate_lastName")).sendKeys(lname); 
		  driver.findElement(By.id("addCandidate_email")).sendKeys(email);
		  
		  WebElement jobDrpdwn = driver.findElement(By.id("addCandidate_vacancy"));
		  Select dropdown=new Select(jobDrpdwn);
		  dropdown.selectByVisibleText(jobCode);
		  
	 }
    
    @And("^User uploads resume \"(.*)\"$")
	 public void uploadResume(String filePath) throws Throwable{

		 driver.findElement(By.id("addCandidate_resume")).sendKeys(filePath);;
		 driver.findElement(By.id("addCandidate_keyWords")).click();
		 
		 driver.findElement(By.cssSelector("#btnSave")).click();
		 
	 }
    
    @Then("^Validate the newly added vacancy was created with \"(.*)\", \"(.*)\"$")
	 public void VerifyVacancyGenerated(String jobName, String vacancyName) throws Throwable{
		  
    	  driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srchVacancy")));
		 
		  WebElement jobTitle=driver.findElement(By.id("vacancySearch_jobTitle"));
		  Select dropdown=new Select(jobTitle);
		  dropdown.selectByVisibleText(jobName);
		  
		  WebElement jobVacancy=driver.findElement(By.id("vacancySearch_jobVacancy"));
		  Select dropdown1=new Select(jobVacancy);
		  dropdown1.selectByVisibleText(vacancyName);
		  
		  driver.findElement(By.id("btnSrch")).click();
		  
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  //Validate that the vacancy has been added 
		  List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		  
		  for (int i=1;i<=tableRows.size();i++){
			  WebElement vacancy =driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[2]/a")); 
			  Assert.assertEquals("The vacancy was not created", vacancyName, vacancy.getText());
		  }

	 }
    
    @Then("^User navigates back to the Recruitments page to validate candidate entry with \"(.*)\", \"(.*)\"$")
	 public void validateCandidate(String name, String jobTitle) throws Throwable{
		  driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		  
		  //wait for the vacancies page to load
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srchCandidates")));
		  
		  driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(name);
		  
		  WebElement jobList = driver.findElement(By.id("candidateSearch_jobVacancy"));
		  Select list1 = new Select(jobList);
		  list1.selectByVisibleText(jobTitle);
		  		  
		  driver.findElement(By.id("btnSrch")).click();
		  
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  		  
		  String candidateName = driver.findElement(By.xpath("(//tr[@class='odd'])[1]//td[@class='left'][2]/a")).getText(); 
		  Assert.assertEquals(name, candidateName);

	 }
  

    @And("^Close the Browser for hrm activity$")
    public void closeBrowser() {
        //Close browser
        driver.quit();
    }
}