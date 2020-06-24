@Android @ChangePIN
Feature: Check the Change PIN feature functionality
#BEFORE YOU RUN THE TEST MAKE SURE TO CHANGE YOUR PHONE NUMBER, YOUR ACCOUNT USER ID, AND YOUR DEVICE TYPE ON SOME
  #SCENARIO, SAME AS BEFORE
  Background:
    Given User in the sign in page
    When User input registered phone number "08126022339"
    And User click the sign in button
    And User input their pin on the pin page "919191"
    And User is in the main page

  @CP_001
  Scenario: Change Pin with valid otp and PIN
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User is in the profile page
    And User click the sign out menu
    And User in the sign in page
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input new pin number on the pin page
    Then User is in the main page

  @CP_002
  Scenario: Change Pin using Resend OTP with valid OTP and PIN
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User wait for the otp to expire in three minutes.
    And User Click resend OTP
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "515151"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User is in the profile page
    And User click the sign out menu
    And User in the sign in page
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input new pin number on the pin page
    Then User is in the main page

  @CP_003
  Scenario: Change PIN with invalid OTP
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input invalid otp number
    And User click next button on the otp page
    Then User see display error "Invalid OTP"

  @CP_004
  Scenario: Change PIN with empty OTP
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    Then User cannot click next the button is disabled

  @CP_005
  Scenario: Change PIN but inputting with only 2 digits of OTP number
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input two digits otp number with user id "1"
    Then User cannot click next the button is disabled

  @CP_006
  Scenario: Change PIN but with expired OTP
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User get otp number with user id "1"
    And User wait for the otp to expire in three minutes.
    And User input the old otp
    And User click next button on the otp page
    Then User see display error "Code is expired. Please tap Resend button"

  @CP_007
  Scenario: Change PIN with valid OTP but empty new PIN
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    Then User cannot click next the button is disabled

  @CP_008
  Scenario: Change PIN with valid OTP but invalid new PIN
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "51515"
    Then User cannot click next the button is disabled

  #probably not working
  @CP_009-014
  Scenario Outline: Change PIN with valid OTP but invalid new PIN (symbols and alphabets)
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "<PIN>"
    And User click next button on the new pin page
    Then User see warning message "PIN format is invalid"
    Examples:
      | PIN    |
      | 51*515 |
      | #51515 |
      | 50505+ |
      | 5.1515 |
      | 515-15 |
      | P51A5S |

  @CP_015
  Scenario: Change PIN with valid OTP but empty confirmation PIN
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "404040"
    And User click next button on the new pin page
    Then User cannot click finish button the button is disabled

  @CP_016
  Scenario: Change PIN with valid OTP but with incorrect confirmation PIN
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "404040"
    And User click next button on the new pin page
    And User input incorrect pin on the confirmation page "414141"
    And User click finish button on the confirmation page
    Then User see warning message on the confirmation page "PIN doesn’t match"

  @CP_017
  Scenario: Successfully Change PIN with valid otp and PIN, but Login with Old PIN
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User is in the profile page
    And User click the sign out menu
    And User in the sign in page
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input old pin number on the page "515151"
    Then User see display error "Invalid PIN"

  @CP-OTP_001
  Scenario: Resend button tapped after waiting for 3 minutes
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User wait for the otp to expire in three minutes.
    And User Click resend OTP
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    Then User is in the new pin page

  @CP-OTP_002
  Scenario: Go back to Profile Screen Using the Arrow Icon Button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User click the back arrow icon on top bar
    Then User is in the profile page

  @CP-OTP_003
  Scenario: Go back to Profile Screen Using the device back button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User click device back button
    Then User is in the profile page

  @CP-OTP_004
    Scenario: Back to OTP Screen by opening the app after tapping the device home button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User is in otp page
    And User click home button and reopen the app
    Then User is in otp page

  @CP-OTP_005
  Scenario: Still on OTP Screen by opening the app after locking and unlocking the device
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User is in otp page
    And User lock the device
    And User unlock the device
    Then User is in otp page

  @CP-OTP_006
  Scenario: Resend button tapped without waiting for 3 minutes.
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    Then User cannot click resend the button is disabled

  @CP_OTP_007
  Scenario: Resend button tapped after it has been tapped before
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User wait for the otp to expire in three minutes.
    And User Click resend OTP
    Then User cannot click resend the button is disabled

  @CP-OTP_008
  Scenario: Resend button tapped after waiting for 3 minutes but can't connect to the server
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User wait for the otp to expire in three minutes.
    And User turn internet off
    And User Click resend OTP
    Then User see display error "Connection error"
    And User turn internet on

  #CP-OTP_009
  @CP-OTP_009
    Scenario: Pasted Valid OTP from clipboard
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    #CHANGE THIS MANUALLY
    And User input otp via pasting with user id "1"
    Then User cant perform paste on the OTP input "6.0"

  @CP-OTP_010
  Scenario: Click next with valid OTP but can't connect to server
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User turn internet off
    And User click next button on the otp page
    Then User see display error "Connection error"
    And User turn internet on

  @CP-NP_001
  Scenario: Go back to Change PIN-OTP Screen Using the Arrow Icon Button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User is in the new pin page
    And User click the back arrow icon on top bar
    Then User is in otp page

  @CP-NP_002
  Scenario: Go back to Change PIN-OTP Screen using the device back button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User is in the new pin page
    And User click device back button
    Then User is in otp page

  @CP-NP_003
  Scenario: Back to Change PIN - New PIN screen by opening the app after tapping the device home button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User is in the new pin page
    And User click home button and reopen the app
    Then User is in the new pin page

  @CP-NP_004
  Scenario: Still on Change PIN - New PIN screen by opening the app after locking and unlocking the device
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User is in the new pin page
    And User lock the device
    And User unlock the device
    Then User is in the new pin page

        #CP-NP_005
  @CP-NP_005
    Scenario: Pasted Valid PIN from clipboard into New PIN input
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User is in the new pin page
    And User input new pin via pasting "505050"
    Then User cant perform paste on the new pin input "deviceType"

  @CP-CPN_001
  Scenario: Go back to Change PIN-New PIN Screen Using the Arrow Icon Button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click the back arrow icon on top bar
    Then User is in the new pin page

  @CP-CPN_002
  Scenario: Go back to Change PIN-New PIN Screen using the device back button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click device back button
    Then User is in the new pin page

  @CP-CPN_003
  Scenario: Back to Change PIN - Confrim PIN screen by opening the app after tapping the device home button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click home button and reopen the app
    Then User is in the confirmation page

  @CP-CPN_004
  Scenario: Still on Change PIN - Confirm PIN screen by opening the app after locking and unlocking the device
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User lock the device
    And User unlock the device
    Then User is in the confirmation page

    #CP-CPN_005
  @CP-CPN_005
    Scenario: Pasted Valid PIN from clipboard into New PIN input
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User input confirm pin via pasting
    Then User cant perform paste on the confirm input "deviceType"

  @CP-CPN_006
  Scenario: Input all valid OTP, new PIN, and confirm PIN, but can't connect to server when clicking finish button
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "1"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User turn internet off
    And User click finish button on the confirmation page
    And User turn internet on





