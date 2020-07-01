# -----------------------------------------------------------------------------
# PLEASE TURN ON YOUR DEVICE SCREEN LOCK TO SWIPE BEFORE EXECUTE THIS FEATURE
# by go to Settings > Security > Screen Lock > Swipe
# -----------------------------------------------------------------------------

@Android @SignUpPhoneNumber
Feature: Functionality on Sign up - Phone Number page

  Background:
    Given User is on "Sign In" page
    And User tap the Sign Up button on Sign In page
    And User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User is on "Phone Number" page

  @SUPN001
  Scenario: Use data from clipboard to fill Phone Number input field
    Given User has copied "081120203030" to the clipboard
    When User press and hold on "Phone Number" input field
    # CHANGE the "Android 8.0" according to your android version e.g. "Android 10.0" or "Android 6.0"
    And User paste clipboard data by tapping "Android 8.0" Paste button
    Then User see "081120203030" is shown in "Phone Number" input field

  @SUPN002
  Scenario: Back to the Email page by tapping Back button on Phone Number page
    When User tap Back button on "Phone Number" page
    Then User is on "Email" page

  @SUPN003
  Scenario: Back to the Email page by tapping the device's Back button
    When User tap the device's "Back" button
    Then User is on "Email" page

  @SUPN004
  Scenario: Display the Phone Number page again by reopening the app after the device's Home button is tapped
    When User tap the device's "Home" button
    And User tap the device's "Overview" button
    And User tap the app on the device's overview
    Then User is on "Phone Number" page

  @SUPN005
  Scenario: Display the Phone Number page again by unlocking the device after it's been locked before
    When User lock the device
    And User unlock the device by swiping up the screen
    Then User is on "Phone Number" page

  @SUPN006
  Scenario: Relaunch the app after it's been closed before when User is on Phone Number page
    When User close the app
    And User open the app
    Then User is on "Sign In" page

  @SUPN007
  Scenario: Validate the Phone Number when user input 14 digits on Phone Number field
    When User input "08122317661700" on "Phone Number" page
    Then User see on "Phone Number" field is not "08122317661700" because input length can't be more than 13

  @SUPN008-SUPN017
  Scenario Outline: Showing the warning message by inputting invalid Phone Number
    When User input "<phone_number>" on "Phone Number" page
    Then User see warning message "<warning_message>" on "Phone Number" page
    Examples:
      | phone_number   | warning_message               |
      |                | Field must be filled          |
      | +628122317663  | 10–13 digits and start with 0 |
      | 628122317663   | 10–13 digits and start with 0 |
      | 081223176      | 10–13 digits and start with 0 |
      | nomortelepon   | 10–13 digits and start with 0 |
      | A812231766B    | 10–13 digits and start with 0 |
      | ._,--,_._-.    | 10–13 digits and start with 0 |
      | 0812231766-.   | 10–13 digits and start with 0 |
      | -08122317664   | 10–13 digits and start with 0 |
      | 0812-2317-661  | 10–13 digits and start with 0 |