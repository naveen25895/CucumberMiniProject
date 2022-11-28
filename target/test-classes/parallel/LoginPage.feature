@Login
Feature: Login page feature

@Smoke
Scenario: Login page title
Given user is on  login page
When user gets the title of the page
Then page title should be "Rahul Shetty Academy"

@Smoke @skip_scenario
Scenario: Forgot Password link
Given user is on  login page
Then forgot your password link should be displayed

@Regression @Skip
Scenario: Login with correct credentials
Given user is on  login page
When user enters username "bamulymu@decabg.eu"
And user enters password "bamulymu@decabg"
And user clicks on Login button
Then user gets the title of the page
And page title should be "Rahul Shetty Academy"