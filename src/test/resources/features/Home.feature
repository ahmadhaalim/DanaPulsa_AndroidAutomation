@Android @Home

Feature: Home Feature Functionality Check

  Background:
    Given User is on sign in page
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen

  @HOSC001-HOSC011
  Scenario: Click every clickable elements and back to previous screen
    When User click mobile recharge icon
    Then User directed to mobile recharge screen
    When User click back button on mobile recharge screen
    Then User directed to home screen
    When User click one of promotion banner
    Then User directed to promotion detail screen
    When User click buy pulsa now button
    Then User directed to mobile recharge screen
    When User click back button on mobile recharge screen
    Then User directed to promotion detail screen
    When User click back button on promotion detail screen
    Then User directed to home screen
    When User click view all button
    Then User directed to promotion list screen
    When User click one of promotion banner at promotion list screen
    Then User directed to promotion detail screen
    When User click buy pulsa now button
    Then User directed to mobile recharge screen
    When User click back button on mobile recharge screen
    Then User directed to promotion detail screen
    When User click back button on promotion detail screen
    Then User directed to promotion list screen
    When User click back button on promotion list screen
    Then User directed to home screen
    When User click home button
    Then User directed to home screen

  @HOSC027
  Scenario: Promotion banner image doesn't show up on home screen
    When User click home button
    Then User see warning message "Connection error" on promotion area

  @HOSC028 @HOSC030
  Scenario: Promotion detail doesn't show up after tapping promotion banner image on home screen
    When User click one of promotion banner
    Then User directed to promotion detail screen
    And User see warning message "Connection error" on promotion detail screen

  @HOSC029
  Scenario: Promotion list doesn't show up after tapping view all button
    When User click view all button
    Then User directed to promotion list screen
    And User see warning message "Connection error" on promotion list screen