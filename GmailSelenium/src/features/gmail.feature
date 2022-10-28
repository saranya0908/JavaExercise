Feature: Login

Scenario: Successful Login

Given I have a browser opened with IXL website
When I enter correct user id and password
And click on submit button
Then I should be able to navigate to home page