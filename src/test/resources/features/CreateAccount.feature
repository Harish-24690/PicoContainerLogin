
Feature: login to Printerpix.com and Create Account

  @loginwithchrome
  Scenario: Navigate to Printerpix-USA  in Chrome and perform Create Account
    Given User  launch the  browser "chrome"
    When User navigates to "https://www.printerpix.com/"
    And User clicks on Account button
    And User clicks on Looking to create a new account link
    And User enter the EmailId has "testautomation0691@gmail.com"
    And user enter Firstname as "Test"
    And user enter Lastname as "Automation"
    And User enter the password as "Test0691"
    And user enter the confirm password as "Test0691"
    And User clicks on Register button
