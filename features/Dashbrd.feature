Feature: 002 Dashboard Page Feature
	As a logged in user at dashboard page
I want to access CRM page
So that I can add Contact

#Background:
#Given using username "techfiosdemo@gmail.com" and password "abc123" in dashboard page

Background: 
	Given At login page using valid username and password user in dashboard page 
		|techfiosdemo@gmail.com|abc123|
		
@functional
Scenario: Add contact 
	When user navigates CRM ----> Add Contact 
	Then Add Contact page is displayed 
	When user enters information 
		|FullName|Test|
		|Email|test|
	And submit the form 
	Then added infromation should display