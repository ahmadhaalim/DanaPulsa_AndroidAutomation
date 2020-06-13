@Android @History

#Tap/Tapping = Click/Clicking
Feature: Home Feature Functionality Check

  @HISC001
  Background:
    Given User is on sign in page
    #Change the phone number according your data table
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen


  #[WARNING] Run this scenario first before other scenarios!
  @HISC011 @HISC012
  Scenario Outline: User doesn't have in progress or completed transaction
    When User click history button
    Then User directed to history screen
    When User click "<tab>" tab on history screen
    Then User see "<message>" on history screen
    Examples:
      | tab         | message                    |
      | In Progress | No In Progress Transaction |
      | Completed   | No Completed Transaction   |

  @HISC002-HISC006
  Scenario: User make success payment from pending transaction and go to transaction detail screen
    #Precondition to get in progress transaction
    When User click home button
    Then User directed to home screen
    When User click "Mobile Recharge Icon" on home screen
    Then User directed from home screen to "Mobile Recharge Screen"
    When User input phone number "087712345678" on mobile recharge screen
    And User choose nominal "5.000"
    Then User directed to lets pay screen
    When User click back button at lets pay screen
    And User click yes button on pop up dialog
    Then User directed to home screen
    When User click history button
    Then User directed to history screen
    #Precondition to get completed transaction
    When User click in progress transaction with price "Rp5.000"
    Then User directed to lets pay screen
    When User click pay button
    Then User directed to payment success screen
    When User click back to home button
    Then User directed to home screen
    #Main scenario
    When User click history button
    And User click completed tab
    And User click completed transaction with price "Rp5.000"
    Then User directed to transaction detail screen
    When User click back button on transaction detail screen
    Then User directed to history screen

  @HISC017 @HISC018
  Scenario: Transaction summary list doesn't show up because internet connection isn't available
    #Precondition to get in progress transaction
    When User click "Mobile Recharge Icon" on home screen
    Then User directed from home screen to "Mobile Recharge Screen"
    When User input phone number "087712345678" on mobile recharge screen
    And User choose nominal "5.000"
    When User click pay button
    Then User directed to payment success screen
    When User click back to home button
    Then User directed to home screen
    #Main scenario
    When User click history button
    And User click in progress tab while internet is off
    Then User see warning "Connection Error" on history screen
    When User click completed tab while internet is off
    Then User see warning "Connection Error" on history screen

  @HISC019
  Scenario: Completed transaction detail doesn't show up on transaction detail screen
  because internet connection isn't available
    When User click history button
    And User click completed tab
    And User click one completed transaction while internet is off
    Then User directed to transaction detail screen
    And User see warning "Connection error" at transaction detail screen

