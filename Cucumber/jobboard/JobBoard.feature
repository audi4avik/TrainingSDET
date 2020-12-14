@JobBoardTests
Feature: Test the job board functionalities

@createuser
Scenario: Creating new user
    Given User logs on to Jobboard admin page 
    When User proceeds to add new user
    Then User enters the new user info
    And Verify the new user has been created
    And Close the browser for jobboard activity
    
@jobapply
Scenario: Apply for a job
    Given User navigates to job board page
    When User searches for a specific job
    Then User gets the job details using xpath
    And Close the browser for jobboard activity
    
@jobpost
Scenario: Post a new job
    Given User navigates to job board page
    When User clicks on post job button
    Then User fills in job details with email "admin@ymail.com" title "SDET Automation 5+ years" location "India" jd "This is a new SDET job" url "abhiram@cklabs.com"
    And Submit the new job posting
    And Verify the new job is visible in Job listing page
    And Close the browser for jobboard activity
    
@examplepost
Scenario Outline: Post a new job using example table
    Given User navigates to job board page
    When User clicks on post job button
    Then User fills in job details with email "<Email>" title "<JobTitle>" location "<Location>" jd "<Details>" url "<URL>"
    And Submit the new job posting
    And Verify the new job is visible in Job listing page
    And Close the browser for jobboard activity
    
Examples:
| Email           | JobTitle                 | Location | Details           | URL |
| admin@gmail.com | SDET Automation 5+ years |    India | This is a new job | abhiram@cklabs.com |
