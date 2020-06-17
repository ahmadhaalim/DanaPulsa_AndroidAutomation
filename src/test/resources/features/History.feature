@Android @History

#Tap/Tapping = Click/Clicking
Feature: Home Feature Functionality Check

#[Warning] Please use a new fresh account, which no transaction has been made before!!!

  @HISC001
  Background:
    Given User is on sign in page
    #Change the phone number according your account
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen


  #[WARNING] Run this scenario first before other scenarios!
  @HISC010 @HISC011
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
    When User click "in progress" tab
    And User click in progress transaction with price "Rp5.000"
    Then User directed to lets pay screen
    When User click pay button
    Then User directed to payment success screen
    When User click back to home button
    Then User directed to home screen
    #Main scenario
    When User click history button
    And User click completed tab
    And User click completed transaction summary
    Then User directed to transaction detail screen with price "Rp.5000"
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


  #---Activity outside app scenarios---#

  @OutsideAppHistory @HISC007
  Scenario: Proceed to device home by tapping device back button
    When User click history button
    Then User directed to history screen
    When User click device back button
    Then User directed to device home from history screen

  @OutsideAppHistory @HISC008
  Scenario: Back to history screen by opening the app after running in the background
    When User click history button
    Then User directed to history screen
    When User open the app after running in the background for a moment
    Then User directed to history screen

  @OutsideAppHistory @HISC009
  Scenario: Still on history screen when unlocking device
    When User click history button
    Then User directed to history screen
    When User lock the device
    And User unlock the device
    Then User directed to history screen

  @OutsideAppHistory @HISC012
  Scenario: Back to history screen by tapping device back button while on completed transaction detail screen
    When User click history button
    Then User directed to history screen
    When User click completed tab
    And User click one of completed transaction summary
    And User click device back button
    Then User directed to history screen

  @OutsideAppHistory @HISC013
  Scenario: Back to completed transaction detail screen by opening the app after running in the background
    When User click history button
    Then User directed to history screen
    When User click completed tab
    And User click one of completed transaction summary
    And User open the app after running in the background for a moment
    Then User directed to transaction detail screen

  @OutsideAppHistory @HISC014
  Scenario: Still on completed transaction detail screen when unlocking device
    When User click history button
    Then User directed to history screen
    When User click completed tab
    And User click one of completed transaction summary
    When User lock the device
    And User unlock the device
    Then User directed to transaction detail screen






