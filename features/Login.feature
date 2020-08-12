Feature: 001 Login Page Feature
	As a valid user 
	I want to login 
	So that I can access dashboardpage

#Background: To login 
#	Given In login page url "http://techfios.com/test/billing/?ng=admin/"


Background:
Given in login page url "url"

#Scenario: User Login 
#	When user provides username "username" and password "password" 
#	And click on login button 
#	Then user lands on dashboardpage 

@regression
Scenario: Valid User login
	When user provides username "techfiosdemo@gmail.com" and password "abc123" 
	And click on login button 
	Then user lands on dashboardpage 


Scenario Outline: Invalid (/valid) user login 
	When user provides username "<username>" and password "<password>" 
	And click on login button 
	Then user lands on dashboardpage 
	
Examples: 
		|username|password|
		|techfiosdemo@gmail.com|abc23|
#		|techfiosdemo@gmail.com|abc123|
		
		