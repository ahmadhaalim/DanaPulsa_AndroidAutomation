@Android @Home

#Tap/Tapping = Click/Clicking
Feature: Home Feature Functionality Check

  Background:
    Given User is on sign in page
    #Change the phone number according your data table
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen

  @HOSC001-HOSC003 @HOSC005-HOSC007
  Scenario Outline: Go to another page from home screen using all clickable element
    and back to home screen using back button
    When User click "<element>" on home screen
    Then User directed from home screen to "<destinationScreen>"
    When User click back button at "<currentScreen>" while previously at the home screen
    Then User directed to home screen
    Examples:
      | element              | destinationScreen       | currentScreen           |
      | Mobile Recharge Icon | Mobile Recharge Screen  | Mobile Recharge Screen  |
      | Promotion Banner     | Promotion Detail Screen | Promotion Detail Screen |
      | View All Button      | Promotion List Screen   | Promotion List Screen   |

  @HOSC004
  Scenario: Go to mobile recharge screen by tapping buy pulsa now button on promotion detail screen
    When User click "Promotion Banner" on home screen
    Then User directed from home screen to "Promotion Detail Screen"
    When user click buy pulsa now on promotion detail screen
    Then User directed to mobile recharge screen

  @HOSC008-HOSC009
  Scenario: Go to promotion detail screen by tapping one of promotion banner image
    on promotion list screen and click buy puLsa now button
    When User click "View All Button" on home screen
    Then User directed from home screen to "Promotion List Screen"
    When User click one of promotion banner at promotion list screen
    Then User directed from home screen to "Promotion Detail Screen"
    When user click buy pulsa now on promotion detail screen
    Then User directed to mobile recharge screen

  @HOSC010
  Scenario: Back to promotion list screen by tapping back Button on promotion detail screen
    When User click "View All Button" on home screen
    Then User directed from home screen to "Promotion List Screen"
    When User click one of promotion banner at promotion list screen
    Then User directed from home screen to "Promotion Detail Screen"
    When User click back button at promotion detail screen
    Then User directed to promotion list screen

  @HOSC011
  Scenario: Reload home screen using home button
    When User click home button
    Then User directed to home screen


  @HOSC027
  Scenario: Promotion banner image doesn't show up on home screen because internet connection isn't available
    When User click home button while internet is off
    Then User see warning message "Connection error" on promotion area

  @HOSC028 @HOSC030
  Scenario: Promotion detail doesn't show up because internet connection isn't available
    When User click promotion banner on home screen while internet is off
    Then User directed from home screen to "Promotion Detail Screen"
    And User see warning message "Connection error" on promotion detail screen

  @HOSC029
  Scenario: Promotion list doesn't show up after tapping view all button
    When User click view all on home screen while internet is off
    Then User directed from home screen to "Promotion List Screen"