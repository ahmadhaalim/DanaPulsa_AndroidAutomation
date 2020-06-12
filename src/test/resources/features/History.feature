@Android @History

Feature: Home Feature Functionality Check

  Background:
    Given User is on sign in page
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen

  @HISC001-HISC005 @HISC010 @HISC011
  Scenario: Click any clickable element and back to previous screen
    When User click history button
    Then User directed to history screen
    And User see "text" info
    When User click completed tab
    Then User see "text" info
    When User click home button
    And User click mobile recharge icon
    Then User directed to mobile recharge screen
    When User input phone number "087712345678" on mobile recharge screen
    And User click nominal top up "5.000"
    Then User directed to lets pay screen
    When User click back button on lets pay screen
    And User click yes button on cancel transaction dialog
    Then User directed to home screen
    When User click history button
    Then User see  latest pending transaction at in progress tab
    When User click pending transaction
    Then User directed to lets pay screen
    When User click pay on lets pay screen
    Then User directed to payment success info
    When User click back to home button
    Then User directed to home screen
    When User click history button
    Then User directed to history screen
    When User click completed tab
    And User click completed transaction
    Then User directed to transaction detail screen
    When User click back button on transaction detail screen
    Then User directed to history screen

  @HISC016
  Scenario: In Progress Transaction summary list doesn't show up
    When User click history button
    Then User see "Connection error" info

  @HISC017
  Scenario: Completed Transaction summary list doesn't show up
    When User click history button
    Then User see "Connection error" info

  @HISC018
  Scenario: Completed transaction detail doesn't show up on transaction detail screen
    When User click history button
    And User click completed tab
    And User click one completed transaction
    Then User directed to transaction detail screen
    And User see warning message "Connection error" at transaction detail screen

