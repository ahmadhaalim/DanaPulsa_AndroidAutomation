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
    And User paste clipboard data to "Email" input field by tapping Paste
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
    Then User see warning message "Email format is invalid" on "Email" page
    Examples:
      | email                      |
      |                            |
      | zakiakhmad                 |
      | zakifaridzan.@gmail.com    |
      | zaki akhmad@gmail.com      |
      | zaki!$#akhmadf20@gmail.com |
      | .zakiakhmad@gmail.com      |
      | zakiakhmadgmail.com        |
      | zakiakhmad@                |
      | zakiakhmad@gmail           |
      | zakiakhmad@.gmail.com      |
      | zakiakhmad@@gmail.com      |
      | zaki..akhmad@gmail.com     |
      | zaki.akhmad@gmail..com     |
      | zakifaridzan@gmail.com.    |
      | zakiakhmad@gmail.c         |