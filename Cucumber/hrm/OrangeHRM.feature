@orangehrmtests
Feature: Test the HRM website functionalities

@createjobvacancy
Scenario:  To create a job vacancy for “Automation Test Engineer”
	  Given User logs in to the OrangeHRM website
	  And User navigates to "Recruitment" page
	  And User navigates to vacancies section to "Add Job Vacancy"
	  When User provides the job details "Automation Test Engineer", "SDET Automation II", "IBM 01" 
	  Then Validate the newly added vacancy was created with "Automation Test Engineer", "SDET Automation II"
	  And Close the Browser for hrm activity