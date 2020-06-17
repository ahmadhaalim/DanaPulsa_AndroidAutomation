@Android @Profile

#Tap/Tapping = Click/Clicking
Feature: Profile Feature Functionality Check

  Background:
    Given User is on sign in page
    #Change the phone number according your data table
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen

  @PRSC001-PRSC003
  Scenario: Go to change pin screen and click back button
    When User click profile button
    Then User directed to profile screen
    When User click change pin menu
    Then User directed to change pin screen
    When User click back button at change pin screen
    Then User directed to profile screen

  @PRSC004
  Scenario: User signed out from the app
    When User click profile button
    Then User directed to profile screen
    When User click sign out button on profile screen
    Then User directed to sign in screen

  @PRSC009
  Scenario: User detail doesn't show up because internet connection isn't available
    When User click profile button while internet is off
    Then User directed to profile screen
    And User see warning "null" on user data display

  @PRSC010
  Scenario: User can't sign out because internet connection isn't available
    When User click profile button while internet is off
    Then User directed to profile screen
    When User click sign out button on profile screen
    Then User see warning pop up "Connection Error"

  #---Activity outside app scenarios---#

  @OutsideAppProfile @PRSC005
  Scenario: Proceed to device home by tapping device back button
    When User click profile button
    Then User directed to profile screen
    When User click device back button
    Then User directed to device home from profile screen

  @OutsideAppProfile @PRSC006
  Scenario: Back to profile screen by opening the app after running in the background
    When User click profile button
    Then User directed to profile screen
    When User open the app after running in the background for a moment
    Then User directed to profile screen

  @OutsideAppProfile @PRSC007
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
