# -----------------------------------------------------------------------------
# PLEASE TURN ON YOUR DEVICE SCREEN LOCK TO SWIPE BEFORE EXECUTE THIS FEATURE
# by go to Settings > Security > Screen Lock > Swipe
# -----------------------------------------------------------------------------

@Android @SignUpEmail
Feature: Functionality on Sign up - Email page

  Background:
    Given User is on "Sign In" page
    And User tap the Sign Up button on Sign In page
    And User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User is on "Email" page

  @SUE001
  Scenario: Use data from clipboard to fill Email input field
    Given User has copied "morgenstein@co.uk" to the clipboard
    When User press and hold on "Email" input field
    # CHANGE the "Android 10.0" according to your android version e.g. "Android 8.0" or "Android 6.0"
    And User paste clipboard data by tapping "Android 8.0" Paste button
    Then User see "morgenstein@co.uk" is shown in "Email" input field

  @SUE002
  Scenario: Back to the Full Name page by tapping Back button on Email page
    When User tap Back button on "Email" page
    Then User is on "Full Name" page

  @SUE003
  Scenario: Back to the Full Name page by tapping the device's Back button
    When User tap the device's "Back" button
    Then User is on "Full Name" page

  @SUE004
  Scenario: Display the Email page again by reopening the app after the device's Home button is tapped
    When User tap the device's "Home" button
    And User tap the device's "Overview" button
    And User tap the app on the device's overview
    Then User is on "Email" page

  @SUE005
  Scenario: Display the Email page again by unlocking the device after it's been locked before
    When User lock the device
    And User unlock the device by swiping up the screen
    Then User is on "Email" page

  @SUE006
  Scenario: Relaunch the app after it's been closed before when User is on Email page
    When User close the app
    And User open the app
    Then User is on "Sign In" page

  @SUE007-SUE021
  Scenario Outline: Showing the warning message by inputting invalid Email
    When User input "<email>" on "Email" page
    Then User see warning message "<warning_message>" on "Email" page
    Examples:
      | email                      | warning_message         |
      |                            | Field must be filled    |
      | zakiakhmad                 | Email format is invalid |
#      | zakifaridzan.@gmail.com    | Email format is invalid |
      | zaki akhmad@gmail.com      | Email format is invalid |
      | zaki!$#akhmadf20@gmail.com | Email format is invalid |
#      | .zakiakhmad@gmail.com      | Email format is invalid |
      | zakiakhmadgmail.com        | Email format is invalid |
      | zakiakhmad@                | Email format is invalid |
      | zakiakhmad@gmail           | Email format is invalid |
      | zakiakhmad@.gmail.com      | Email format is invalid |
      | zakiakhmad@@gmail.com      | Email format is invalid |
#      | zaki..akhmad@gmail.com     | Email format is invalid |
      | zaki.akhmad@gmail..com     | Email format is invalid |
      | zakifaridzan@gmail.com.    | Email format is invalid |
      | zakiakhmad@gmail.c         | Email format is invalid |