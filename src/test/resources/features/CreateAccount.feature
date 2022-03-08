Feature: login to Printerpix.com and Create Account

  @createAccount
  Scenario Outline: Navigate to Printerpix-USA and perform create Account
    Given User  launch by passing the parameters browser  "<browser>" and os  "<os>" and os_version  "<os_version>"and browser_version  "<browser_version>"
    When User navigates to "https://www.printerpix.com/"
    And User clicks on Account button
    And User clicks on Looking to create a new account link
    And User enter the EmailId has "testautomation0691@gmail.com"
    And user enter Firstname as "Test"
    And user enter Lastname as "Automation"
    And User enter the password as "Test0691"
    And user enter the confirm password as "Test0691"
    And User clicks on Register button

    Examples: 
      | browser | os      | os_version | browser_version |
      | Chrome  | Windows | 10         |            80.0 |
      | Firefox | OS X    | Catalina   |            85.0 |
      | Safari  | OS X    | Monterey   |            15.0 |
      | Safari  | OS X    | Big Sur    |            14.1 |
