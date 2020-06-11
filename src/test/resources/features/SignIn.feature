@Android @SignIn

Feature: Sign In Feature Functionality Check

  Background:
    Given User is on sign in page

  @SI001
  Scenario: User successfully sign in using registered phone number
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen
    When User click profile button
    Then User directed to profile screen
    And User see phone number used to signing in

  @SI002
  Scenario: User failed to sign in using registered phone number because internet connection problem
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User see warning message "Connection error" on sign in page


  @SI003-006
  Scenario Outline: User failed to sign in using invalid phone number or invalid pin
    When User input phone number "<phone>"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "<pin>"
    Then User see warning message "<error>" on input pin screen
    Examples:
      | phone         | pin    | error                |
      | 08555333444   | 987654 | Invalid PIN          |
      | 081223232323  | 987654 | Invalid phone number |
      | +628555333444 | 123456 | Invalid phone number |
      | 628555333444  | 123456 | Invalid phone number |

  @SI007
  Scenario: User click sign in button without filling phone number field
    When User click sign in button
    Then User see warning message "Invalid phone number" on sign in page

  @SI-IPN001 @SI-IPN005
  Scenario: Go to sign up screen by tapping sign up text and click back button
    When User click sign up button
    Then User directed to sign up screen
    When User click back button on sign up screen
    Then User directed to sign in screen

  @SI-IP001
  Scenario: Back to sign in screen by tapping back button while in input pin screen
    When User input phone number "08555333444"
    And User click sign in button
    When User click back button on input pin screen
    Then User directed to sign in screen

  @SI-IP005 @SI-IP006
  Scenario: Go to forgot pin screen by tapping forgot pin text and click back button
    When User input phone number "08555333444"
    And User click sign in button
    When User click forgot pin text
    Then User directed to forgot pin screen
    When User click back button on forgot pin screen
    Then User directed to input pin screen

