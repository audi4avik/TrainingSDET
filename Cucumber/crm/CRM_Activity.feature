@CRMTests
Feature: Test the CRM functionalities

@crmcount
Scenario: Count the dashlets on CRM homepage
    Given User logs on to CRM website with username "admin" and password "pa$$w0rd" 
    When User counts the number of dashlets on homepage
    Then User prints the details of each dashlet
    And Closes the browser for crm activity
    
@createleads
Scenario: Create leads using parameterization
    Given User logs on to CRM website with username "admin" and password "pa$$w0rd" 
    When User navigates to Create lead scetion
    Then User fills in the required details "John" "Doe" to create leads
    And User validates the lead created successfully
    And Closes the browser for crm activity
    
@createmeeting
Scenario Outline: Create a meeting and invite memebers using examples table
    Given User logs on to CRM website with username "admin" and password "pa$$w0rd" 
    When User navigates to create meeting section
    Then User fills in the required details for the meeting
    And User selects the members "<Email>" for the meeting 
    And User navigates to view meetings to confirm
    And Closes the browser for crm activity
    
Examples:
| Email           |
| dev.hr@example.org |
| vegan72@example.edu |
|	jim@example.com |

@createvacancy
Scenario Outline: Create a meeting and invite memebers using examples table
    Given User logs on to CRM website with username "admin" and password "pa$$w0rd" 
    When User navigates to create meeting section
    Then User fills in the required details for the meeting
    And User selects the members "<Email>" for the meeting 
    And User navigates to view meetings to confirm
    And Closes the browser for crm activity
    

