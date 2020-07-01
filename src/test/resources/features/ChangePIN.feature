@Android @ChangePIN
Feature: Check the Change PIN feature functionality
#BEFORE YOU RUN THE TEST MAKE SURE TO CHANGE YOUR PHONE NUMBER, YOUR ACCOUNT USER ID, AND YOUR DEVICE TYPE ON SOME
  #SCENARIO, SAME AS BEFORE
  Background:
    Given User in the sign in page
    When User input registered phone number "08555222333"
    And User click the sign in button

  @CP_001
  Scenario: Change Pin with valid otp and PIN
    When User input their pin on the pin page "909090"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2048"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User click yes on the dialog box
    And User click the profile menu on the bottom bar
    And User is in the profile page
    And User click the sign out menu
    And User click yes on the dialog box
    And User in the sign in page
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input new pin number on the pin page
    Then User is in the main page

  @CP_002
  Scenario: Change Pin using Resend OTP with valid OTP and PIN
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User wait for the otp to expire in three minutes.
    And User Click resend OTP
    And User input valid otp number with user id "2048"
    And User click next button on the otp page
    And User input new PIN "515151"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User click yes on the dialog box
    And User click the profile menu on the bottom bar
    And User is in the profile page
    And User click the sign out menu
    And User click yes on the dialog box
    And User in the sign in page
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input new pin number on the pin page
    Then User is in the main page

  @CP_003
  Scenario: Change PIN with invalid OTP
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input invalid otp number "1111"
    And User click next button on the otp page
    Then User see display error "incorrect OTP"

  @CP_004-009
  Scenario Outline: Change PIN with invalid OTP (symbols and alphabets)
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input invalid otp number "<OTP>"
    And User click next button on the otp page
    Then User see display error "invalid OTP"
    Examples:
      | OTP  |
      | 90*9 |
      | #909 |
      | 909+ |
      | 9.09 |
      | 9-90 |
      | P90A |

  @CP_010
  Scenario: Change PIN with empty OTP
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    Then User cannot click next the button is disabled

  @CP_011
  Scenario: Change PIN but inputting with only 2 digits of OTP number
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input two digits otp number with user id "2040"
    Then User cannot click next the button is disabled

  @CP_012
  Scenario: Change PIN but with expired OTP
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User get otp number with user id "2040"
    And User wait for the otp to expire in three minutes.
    And User input the old otp
    And User click next button on the otp page
    Then User see display error "Code is expired. Please tap Resend button"

  @CP_013
  Scenario: Change PIN with valid OTP but empty new PIN
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    Then User cannot click next the button is disabled

  @CP_014
  Scenario: Change PIN with valid OTP but invalid new PIN
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "51515"
    Then User cannot click next the button is disabled

  @CP_015-020
  Scenario Outline: Change PIN with valid OTP but invalid new PIN (symbols and alphabets)
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "<PIN>"
    Then User see display error "Must be 6 digits and cannot start with 0"
    Examples:
      | PIN    |
      | 51*515 |
      | #51515 |
      | 50505+ |
      | 5.1515 |
      | 515-15 |
      | P51A5S |

  @CP_021
  Scenario: Change PIN with valid OTP but empty confirmation PIN
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "404040"
    And User click next button on the new pin page
    Then User cannot click finish button the button is disabled

  @CP_022
  Scenario: Change PIN with valid OTP but with incorrect confirmation PIN
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "404040"
    And User click next button on the new pin page
    And User input incorrect pin on the confirmation page "414141"
    Then User see display error "PIN doesn't match"

  @CP_023-028
  Scenario Outline: Change PIN with valid OTP but with incorrect confirmation PIN (symbols and alphabets)
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "404040"
    And User click next button on the new pin page
    And User input incorrect pin on the confirmation page "<PIN>"
    Then User see display error "Must be 6 digits and cannot start with 0"
    Examples:
      | PIN    |
      | 51*515 |
      | #51515 |
      | 50505+ |
      | 5.1515 |
      | 515-15 |
      | P51A5S |

  @CP_029
  Scenario: Successfully Change PIN with valid otp and PIN, but Login with Old PIN
    When User input their pin on the pin page "515151"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2048"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User click yes on the dialog box
    And User click the profile menu on the bottom bar
    And User is in the profile page
    And User click the sign out menu
    And User click yes on the dialog box
    And User in the sign in page
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input old pin number on the page "515151"
    Then User see display error "incorrect pin"

  @CP-OTP_001
  Scenario: Go back to Profile Screen Using the Arrow Icon Button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User click the back arrow icon on top bar
    Then User is in the profile page

  @CP-OTP_002
  Scenario: Go back to Profile Screen Using the device back button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User click device back button
    Then User is in the profile page

  @CP-OTP_003
    Scenario: Back to OTP Screen by opening the app after tapping the device home button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User is in otp page
    And User click home button and reopen the app
    Then User is in otp page

  @CP-OTP_004
  Scenario: Still on OTP Screen by opening the app after locking and unlocking the device
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User is in otp page
    And User lock the device
    And User unlock the device
    Then User is in otp page

  @CP-OTP_005
  Scenario: Resend button tapped without waiting for 3 minutes.
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    Then User cannot click resend the button is disabled

  @CP_OTP_006
  Scenario: Resend button tapped after it has been tapped before
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User wait for the otp to expire in three minutes.
    And User Click resend OTP
    Then User cannot click resend the button is disabled

  @CP-OTP_007
  Scenario: Resend button tapped after waiting for 3 minutes but can't connect to the server
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User wait for the otp to expire in three minutes.
    And User turn internet off
    And User Click resend OTP
    Then User see display error "Connection Error"
    And User turn internet on

  @CP-OTP_008
    Scenario: Pasted Valid OTP from clipboard
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input otp via pasting with user id "2040"
    Then User cant perform paste on the OTP input "10.0"

  @CP-OTP_009
  Scenario: Click next with valid OTP but can't connect to server
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User turn internet off
    And User click next button on the otp page
    Then User see display error "Connection Error"
    And User turn internet on

  @CP-NP_001 @CNP
  Scenario: Go back to Change PIN-OTP Screen Using the Arrow Icon Button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User click the back arrow icon on top bar
    Then User is in the profile page

  @CP-NP_002 @CNP
  Scenario: Go back to Change PIN-OTP Screen using the device back button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User click device back button
    Then User is in the profile page

  @CP-NP_003 @CNP
  Scenario: Back to Change PIN - New PIN screen by opening the app after tapping the device home button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User click home button and reopen the app
    Then User is in the new pin page

  @CP-NP_004 @CNP
  Scenario: Still on Change PIN - New PIN screen by opening the app after locking and unlocking the device
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User lock the device
    And User unlock the device
    Then User is in the new pin page

  @CP-NP_005 @CNP
    Scenario: Pasted Valid PIN from clipboard into New PIN input
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User input new pin via pasting "505050"
    Then User cant perform paste on the new pin input "10.0"

  @CP-CPN_001 @CCP
  Scenario: Go back to Change PIN-New PIN Screen Using the Arrow Icon Button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click the back arrow icon on top bar
    Then User is in the new pin page

  @CP-CPN_002 @CCP
  Scenario: Go back to Change PIN-New PIN Screen using the device back button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click device back button
    Then User is in the new pin page

    #try
  @CP-CPN_003 @CCP
  Scenario: Back to Change PIN - Confrim PIN screen by opening the app after tapping the device home button
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click home button and reopen the app
    Then User is in the confirmation page

#try
  @CP-CPN_004 @CCP
  Scenario: Still on Change PIN - Confirm PIN screen by opening the app after locking and unlocking the device
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User lock the device
    And User unlock the device
    Then User is in the confirmation page

#try
  @CP-CPN_005 @CCP
    Scenario: Pasted Valid PIN from clipboard into New PIN input
    When User input their pin on the pin page "505050"
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User input confirm pin via pasting
    Then User cant perform paste on the confirm input "10.0"

#try
  @CP-CPN_006 @CCP
  Scenario: Input all valid OTP, new PIN, and confirm PIN, but can't connect to server when clicking finish button
    When User input their pin on the pin page "505050"
    And User is in the main page
    When User click the profile menu on the bottom bar
    And User click the change pin menu
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "505050"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User turn internet off
    And User click finish button on the confirmation page
    Then User see display error "Connection Error"
    And User turn internet on





