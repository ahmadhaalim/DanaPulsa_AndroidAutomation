# -----------------------------------------------------------------------------
# PLEASE TURN ON YOUR DEVICE SCREEN LOCK TO SWIPE BEFORE EXECUTE THIS FEATURE
# by go to Settings > Security > Screen Lock > Swipe
# -----------------------------------------------------------------------------

@Android @SignUpFullName
Feature: Functionality on Sign up - Full Name page

  Background:
    Given User is on "Sign In" page
    And User tap the Sign Up button on Sign In page
    And User is on "Full Name" page

  @SUFN001
  Scenario: Use data from clipboard to fill Full Name input field
    Given User has copied "Morgenstein" to the clipboard
    When User press and hold on "Full Name" input field
    # CHANGE the "Android 8.0" according to your android version e.g. "Android 10.0" or "Android 6.0"
    And User paste clipboard data by tapping "Android 8.0" Paste button
    Then User see "Morgenstein" is shown in "Full Name" input field

  @SUFN002
  Scenario: Back to the Sign In page by tapping Back button on Full Name page
    When User tap Back button on "Full Name" page
    Then User is on "Sign In" page

  @SUFN003
  Scenario: Back to the Full Name page from the Confirm PIN page and validate that every inputs still exist
    When User input "Nick Jr" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "nickjr98@yahoo.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081223176640" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "789789" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User tap Back button on "Confirm PIN" page
    Then User see the inputted "PIN" which is "789789" still exists
    When User tap Back button on "Create PIN" page
    Then User see the inputted "Phone Number" which is "081223176640" still exists
    When User tap Back button on "Phone Number" page
    Then User see the inputted "Email" which is "nickjr98@yahoo.com" still exists
    When User tap Back button on "Email" page
    Then User see the inputted "Full Name" which is "Nick Jr" still exists

  @SUFN004
  Scenario: Back to the Sign In page by tapping the device's Back button
    When User tap the device's "Back" button
    Then User is on "Sign In" page

  @SUFN005
  Scenario: Display the Full Name page again by reopening the app after the device's Home button is tapped
    When User tap the device's "Home" button
    And User tap the device's "Overview" button
    And User tap the app on the device's overview
    Then User is on "Full Name" page

  @SUFN006
  Scenario: Display the Full Name page again by unlocking the device after it's been locked before
    When User lock the device
    And User unlock the device by swiping up the screen
    Then User is on "Full Name" page

  @SUFN007
  Scenario: Relaunch the app after it's been closed before when User is on Full Name page
    When User close the app
    And User open the app
    Then User is on "Sign In" page

  @SUFN008
  Scenario: Validate the Full Name when user input 21 characters on Full Name field
    When User input "Zaki Akhmad Faridzann" on "Full Name" page
    Then User see on "Full Name" field is not "Zaki Akhmad Faridzann" because input length can't be more than 20

  @SUFN009-SUFN016
  Scenario Outline: Showing the warning message by inputting invalid Full Name
    When User input "<full_name>" on "Full Name" page
    Then User see warning message "<warning_message>" on "Full Name" page
    Examples:
      | full_name       | warning_message                     |
      |                 | Field must be filled                |
      | (threeSpaces)   | 3–20 characters and alphabet \nonly |
      | (space)Z(space) | 3–20 characters and alphabet \nonly |
      | Za              | 3–20 characters and alphabet \nonly |
      | Zaki123         | 3–20 characters and alphabet \nonly |
      | 123456          | 3–20 characters and alphabet \nonly |
      | Zaki!@          | 3–20 characters and alphabet \nonly |
      | Zaki🙃          | 3–20 characters and alphabet \nonly |
