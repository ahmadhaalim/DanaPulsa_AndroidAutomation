# -----------------------------------------------------------------------------
# PLEASE TURN ON YOUR DEVICE SCREEN LOCK TO SWIPE BEFORE EXECUTE THIS FEATURE
# by go to Settings > Security > Screen Lock > Swipe
# -----------------------------------------------------------------------------

@Android @SignUpConfirmPIN
Feature: Functionality on Sign up - Confirm PIN page

  Background:
    Given User is on "Sign In" page
    And User tap the Sign Up button on Sign In page
    And User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081120203030" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "500505" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User is on "Confirm PIN" page

  @SUCP001
  Scenario: Back to the Create PIN page by tapping Back button on Confirm PIN page
    When User tap Back button on "Confirm PIN" page
    Then User is on "Create PIN" page

  @SUCP002
  Scenario: Back to the Create PIN page by tapping the device's Back button
    When User tap the device's "Back" button
    Then User is on "Create PIN" page

  @SUCP003
  Scenario: Display the Confirm PIN page again by reopening the app after the device's Home button is tapped
    When User tap the device's "Home" button
    And User tap the device's "Overview" button
    And User tap the app on the device's overview
    Then User is on "Confirm PIN" page

  @SUCP004
  Scenario: Display the Confirm PIN page again by unlocking the device after it's been locked before
    When User lock the device
    And User unlock the device by swiping up the screen
    Then User is on "Confirm PIN" page

  @SUCP005
  Scenario: Relaunch the app after it's been closed before when User is on Confirm PIN page
    When User close the app
    And User open the app
    Then User is on "Sign In" page

  @SUCP006
  Scenario: Use data from clipboard to fill Confirm PIN field
    When User has copied "500505" to the clipboard
    And User press and hold on "Confirm PIN" input field
    # CHANGE the "Android 10.0" according to your android version e.g. "Android 8.0" or "Android 6.0"
    Then User cannot paste clipboard data because the "Android 10.0" Paste button is not shown