@login
Feature: login to Printerpix.com

  @loginwithchrome
  Scenario Outline: Navigate to Printerpix-USA and perform login
    Given User  launch by passing the parameters browser  "<browser>" and os  "<os>" and os_version  "<os_version>"and browser_version  "<browser_version>"
    When User navigates to "https://www.printerpix.com/"
    And User clicks on Account button
    And User enters the username has "harish.r@syncoms.com"
    And User enters the password has "syncoms"
    And User clicks on Login button

    Examples:
    |browser|os     |os_version|browser_version|
    |Chrome |Windows|10        |80.0           |
    |Firefox|OS X   |Catalina  |85.0           |        
    |Safari |OS X   |Monterey  |15.0           |
    |Safari |OS X   |Big Sur   |14.1           |
 