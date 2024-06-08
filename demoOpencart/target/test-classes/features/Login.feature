Feature: login functionality

#Scenario: validate logging into application by entering valid credentials

#Given user is on the landing page
#When user click on my account dropmenu and clicks on login option
#And enters valid username and password and clicks on login
#Then user should be logged in successfully

#Scenario: validate logging into application by entering invalid credentials

#Given user is on the landing page
#When user click on my account dropmenu and clicks on login option
#And user enters invalid username and password and clicks on login
#Then Warning message should be displayed

Scenario: Validate forgotten password link is available in login page and is working

Given user is on the landing page
When user click on my account dropmenu and clicks on login option
And forgotten password link should be visible
Then when clicked on forgotten password link forgot your password page should open

Scenario: validate copying of the text entered into the password field

Given user is on the landing page
When user click on my account dropmenu and clicks on login option
And enters the password and copies it
Then password should not be copied