@orangehrmtests
Feature: Test the HRM website functionalities

@createjobvacancy
Scenario:  To create a job vacancy for “Automation Test Engineer”
	  Given User logs in to the OrangeHRM website
	  And User navigates to "Recruitment" page
	  And User navigates to vacancies section to "Add Job Vacancy"
	  When User provides the job details "Automation Test Engineer", "SDET Automation II", "IBM 01" 
	  Then User validates the newly added vacancy was created with "Automation Test Engineer", "SDET Automation II"
	  And Close the Browser for hrm activity
	  
@addcandidate
Scenario:  Add information about a candidate for recruitment
    Given User logs in to the OrangeHRM website
	  And User navigates to "Recruitment" page
    And User clicks on the Add button to add candidate
    When User fills out candidate details with "John", "Doe", "johndoe@mail.com", "SDET Automation" 
    And User uploads resume "C:\\Users\\ibmadmin\\Desktop\\Sample_Resume.docx"
    Then User navigates back to the Recruitments page to validate candidate entry with "John Doe", "SDET Automation"
    And Close the Browser for hrm activity
    
@addmultipleEmployee
Scenario Outline:  Add multiple employees using an the Examples table
    Given User logs in to the OrangeHRM website
    And User clicks on the PIM menu link
    And User clicks on the add employee button
		And User checks the "Create Login Details" checkbox
    When User fills out employee details with "<FirstName>", "<LastName>"
    Then User verifies that the employee details has been created
    And Close the Browser for hrm activity
    
Examples:
| FirstName		| LastName      | 
| John        | Lenon         | 
| Hugh        | Jackman       |  
    
    
@createMultipleVacancies
Scenario Outline:  Create multiple job vacancies
    Given User logs in to the OrangeHRM website
	  And User navigates to "Recruitment" page
    And User navigates to vacancies section to "Add Job Vacancy"
    When User fills out vacancy details from "<JobTitle>", "<VacancyName>", "<HiringMgr>" example table
    Then User validates that the vacancies were created with "<JobTitle>", "<VacancyName>", "<HiringMgr>"
    And Close the Browser for hrm activity
    
Examples:
|JobTitle                    | VacancyName                 | HiringMgr         |
|Java Developer	             | Full Stack Jave Developer   | Hugh Jackman			 |
|Automation Test Engineer    | SDET Level I 						   | John Lenon        |