Feature: Registering into the application

#Scenario: Validate registering into the account by providing only mandatory fields

#Given user lands on the website
#When user clicks on the myAccount dropmenu and clicks on register option
#And user enters all mandatory details and click on continue button
#Then Account success message should be displayed

#Scenario: Validate error messages displayed when user clicks on continue bt without providing any details

#Given user lands on the website
#When user clicks on the myAccount dropmenu and clicks on register option
#And clicks on continue button without providing mandatory details
#Then error messages should be displayed for mandatory fields

#Scenario: validate registering an account by entering different passwords in password and confirm password fields

#Given user lands on the website
#When user clicks on the myAccount dropmenu and clicks on register option
#And user enters all mandatory details but enters different passwords in password and confirm password fields and click on continue button
#Then Warning message is displayed

Scenario: validate all the fields in the reigister account page have proper placeholders or not

Given user lands on the website
When user clicks on the myAccount dropmenu and clicks on register option
Then proper placeholders should be displayed for all mandatory fields


