@Android @Home

#Tap/Tapping = Click/Clicking
Feature: Home Feature Functionality Check

  Background:
    Given User directed to "sign in" screen
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
    #sign out
    When User click profile button
    And User click sign up button
    Then User directed to sign in screen
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
    Then User directed to promotion detail screen
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
  Scenario: Promotion list doesn't show up after tapping view all button because internet connection isn't available
    When User click view all on home screen while internet is off
    Then User directed from home screen to "Promotion List Screen"
    And User see warning message "Connection error" on promotion list screen
    
  
  #---Activity outside app scenarios---#

  @OutsideAppHome @HOSC012
  Scenario: Proceed to Device Home by tapping device back button
    When User click device home button
    Then User directed to device home from home screen

  @OutsideAppHome @HOSC013
  Scenario: Back to Home screen by opening the app after tapping device home button
    When User click device back button
    Then User directed to device home from home screen

  @OutsideAppHome @HOSC014
  Scenario: Still on home screen when unlocking device
    When User lock the device
    And User unlock the device
    Then User directed to home screen

  @OutsideAppHome @HOSC017
  Scenario: Back to home screen by tapping device back button while in promotion detail screen
  (via "Home" Screen)
    When User click "Promotion Banner" on home screen
    Then User directed from home screen to "Promotion Detail Screen"
    When User click device back button
    Then User directed to home screen

  @OutsideAppHome @HOSC018
  Scenario: Back to promotion detail screen by opening the app after running in the background
    When User click "Promotion Banner" on home screen
    Then User directed from home screen to "Promotion Detail Screen"
    When User open the app after running in the background for a moment
    Then User directed to promotion detail screen

  @OutsideAppHome @HOSC019
  Scenario: Still on promotion detail screen when unlocking device
    When User click "Promotion Banner" on home screen
    Then User directed from home screen to "Promotion Detail Screen"
    When User lock the device
    And User unlock the device
    Then User directed to promotion detail screen

  @OutsideAppHome @HOSC020
  Scenario: Back to promotion list screen by tapping device back button while in promotion detail screen
  (via View All Button)
    When User click "View All Button" on home screen
    Then User directed from home screen to "Promotion List Screen"
    When User click one of promotion banner at promotion list screen
    Then User directed to promotion detail screen
    When User click device back button
    Then User directed to promotion list screen

  @OutsideAppHome @HOSC021
  Scenario: Back to home screen by tapping device back button while in promotion list screen
    When User click "View All Button" on home screen
    Then User directed from home screen to "Promotion List Screen"
    When User click device back button
    Then User directed to home screen

  @OutsideAppHome @HOSC022
  Scenario: Back to promotion list screen  by opening the app after running in the background
    When User click "View All Button" on home screen
    Then User directed from home screen to "Promotion List Screen"
    When User open the app after running in the background for a moment
    Then User directed to promotion list screen

  @OutsideAppHome @HOSC023
  Scenario: Still on promotion list screen when unlocking device
    When User click "View All Button" on home screen
    Then User directed from home screen to "Promotion List Screen"
    When User lock the device
    And User unlock the device
    Then User directed to promotion list screen

  @OutsideAppHome @HOSC024
  Scenario: Back to home screen by tapping device back button while in mobile recharge screen
    When User click "Mobile Recharge Icon" on home screen
    Then User directed from home screen to "Mobile Recharge Screen"
    When User click device back button
    Then User directed to home screen

  @OutsideAppHome @HOSC025
  Scenario: Back to mobile recharge screen  by opening the app after running in the background
    When User click "Mobile Recharge Icon" on home screen
    Then User directed from home screen to "Mobile Recharge Screen"
    When User open the app after running in the background for a moment
    Then User directed to mobile recharge screen

  @OutsideAppHome @HOSC026
  Scenario: Still on mobile recharge screen when unlocking device
    When User click "Mobile Recharge Icon" on home screen
    Then User directed from home screen to "Mobile Recharge Screen"
    Then User directed to mobile recharge screen
