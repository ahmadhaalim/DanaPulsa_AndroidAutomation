@Android @Profile

#Tap/Tapping = Click/Clicking
Feature: Profile Feature Functionality Check

  Background:
    Given User directed to "sign in" screen
    #Change the phone number according your data table
    When User input phone number "08555333444"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "123456" while internet is "on"
    Then User directed to "home" screen

  @PRSC001-PRSC003
  Scenario: Go to change pin screen and click back button
    When User tap "profile" menu button while internet is "on"
    Then User directed to profile screen
    When User click "change pin" button on profile screen
    Then User directed to change pin screen
    When User perform action "tap back button" while on "change pin" screen
    Then User directed to profile screen

  @PRSC004
  Scenario: User signed out from the app
    When User tap "profile" menu button while internet is "on"
    Then User directed to profile screen
    When User click "sign out" button on profile screen
    And User click "yes" button on profile screen
    Then User directed to "sign in" screen

  @PRSC005
  Scenario: User signed out from the app
    When User tap "profile" menu button while internet is "on"
    Then User directed to profile screen
    When User click "sign out" button on profile screen
    And User click "no" button on profile screen
    Then User directed to "profile" screen


  @PRSC009
  Scenario: User can't sign out because internet problem
    When User tap "profile" menu button while internet is "off"
    Then User directed to profile screen
    When User click "sign out" button on profile screen
    Then User see warning pop up "Connection Error"

  #---Activity outside app scenarios---#

   @PRSC005
  Scenario: Proceed to device home by tapping device back button
    When User tap "profile" menu button while internet is "on"
    Then User directed to profile screen
    When User click device back button
    Then User directed to device home from profile screen

   @PRSC006
  Scenario: Back to profile screen by opening the app after running in the background
    When User click profile button
    Then User directed to profile screen
    When User open the app after running in the background for a moment
    Then User directed to profile screen

   @PRSC007
  Scenario: Still on profile screen when unlocking device
    When User click profile button
    Then User directed to profile screen
    When User lock the device
    And User unlock the device
    Then User directed to profile screen

  @OutsideAppProfile @PRSC008
  Scenario: Proceed to device home by tapping device back button after signing out from the app
    When User click profile button
    Then User directed to profile screen
    When User click sign out button on profile screen
    Then User directed to sign in screen
    When User click device back button
    Then User directed to device home from sign in screen
