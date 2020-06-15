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

  @SU-PN_001
  Scenario: Use data from clipboard to fill Phone Number input field
    Given User has copied "081120203030" to the clipboard
    When User press and hold on "Phone Number" input field
    And User paste clipboard data to "Phone Number" input field by tapping Paste
    Then User see "081120203030" is shown in "Phone Number" input field

  @SU-PN_002
  Scenario: Back to the Email page by tapping Back button on Phone Number page
    When User tap Back button on "Phone Number" page
    Then User is on "Email" page

  @SU-PN_003
  Scenario: Back to the Email page by tapping the device's Back button
    When User tap the device's "Back" button
    Then User is on "Email" page

  @SU-PN_004
  Scenario: Display the Phone Number page again by reopening the app after the device's Home button is tapped
    When User tap the device's "Home" button
    And User tap the device's "Overview" button
    And User tap the app on the device's overview
    Then User is on "Phone Number" page

  @SU-PN_005
  Scenario: Display the Phone Number page again by unlocking the device after it's been locked before
    When User lock the device
    And User unlock the device by swiping up the screen
    Then User is on "Phone Number" page

  @SU-PN_006
  Scenario: Relaunch the app after it's been closed before when User is on Phone Number page
    When User close the app
    And User open the app
    Then User is on "Sign In" page

  @WarningMessage
  Scenario Outline: Showing the warning message by inputting invalid Phone Number
    When User input "<phone_number>" on "Phone Number" page
    Then User see warning message "10-13 digits and start with 0" on "Phone Number" page
    Examples:
      | phone_number   |
      |                |
      | +628122317663  |
      | 628122317663   |
      | 081223176      |
      | 08122317661700 |
#      | nomortelepon   |
#      | A812231766B    |
      | ._,--,_._-.    |
      | 0812231766-.   |
      | -08122317664   |
      | 0812-2317-661  |