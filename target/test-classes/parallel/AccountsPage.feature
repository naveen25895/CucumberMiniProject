Feature: Account page feature

Background:
Given user has already logged into a application
|username|password|
|bamulymu@decabg.eu|bamulymu@decabg|

Scenario: Accounts page title
Given user is on  Accounts page
When user gets the title of the page
Then page title should be "Rahul Shetty Academy"

Scenario: Accounts section count
Given user is on  Accounts page
Then users gets enroll course section
|Core Java for Automation Testers + Interview Programs|
|Write effective QA Resume that will turn to interview call|
And enroll course section count should be 2