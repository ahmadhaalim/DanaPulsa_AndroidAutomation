@Android @Voucher

#Tap/Tapping = Click/Clicking
Feature: Voucher Feature Functionality Check

#[Warning] Please use a new fresh account, which no transaction has been made before!!!

  Background:
    Given User is on sign in page
    #Change the phone number according your account
    When User input phone number "08555333444"
    And User click sign in button
    Then User directed to input pin screen
    When User input pin "123456"
    Then User directed to home screen

  #[WARNING] Run this scenario first before other scenarios!
  @VOSC001 @VOSC011-VOSC013
  Scenario Outline: User doesn't have any voucher
    When User click voucher button
    Then User directed to voucher screen
    When User click "<button>" button on voucher screen
    Then User see "<text>" message on voucher screen
    Examples:
      | button   | text                            |
      | All      | You don't have any voucher      |
      | Discount | You don't have discount voucher |
      | Cashback | You don't have cashback voucher |

  #[WARNING] Run this scenario first before @VOSC002, @VOSC004, @VOSC005, and @VOSC006
  @VOSC003
  Scenario: Go to Discount  Voucher List screen by tapping Discount button
    #Precondition to get discount voucher
    When User click "Mobile Recharge Icon" on home screen
    Then User directed from home screen to "Mobile Recharge Screen"
    When User input phone number "081271465456" on mobile recharge screen
    And User choose nominal "50.000"
    When User click pay button
    Then User directed to payment success screen
    When User click yes button on pop up dialog payment success screen
    And User click back to home button
    Then User directed to home screen
    #Main scenario
    When User click history button
    And User click "Discount" button on voucher screen
    Then User see voucher banner "5%"

   #[WARNING] Run this scenario first before @VOSC004, @VOSC005, and @VOSC006
  @VOSC004
  Scenario: Go to Cashback Voucher List screen by tapping Casback button
    #Precondition to get cashback voucher
    When User click "Mobile Recharge Icon" on home screen
    Then User directed from home screen to "Mobile Recharge Screen"
    When User input phone number "081271465456" on mobile recharge screen
    And User choose nominal "15.000"
    And User click voucher action button
    Then User directed to pick a voucher screen
    When User click continue without using voucher
    Then User directed to lets pay screen
    When User click pay button
    Then User directed to payment success screen
    When User click yes button on pop up dialog payment success screen
    And User click back to home button
    Then User directed to home screen
    #Main scenario
    When User click history button
    And User click "Cashback" button on voucher screen
    Then User see voucher banner "5.0000"

  @VOSC002 @VOSC005 @VOSC006
  Scenario: Go to voucher detail screen by tapping all button and click back button
    When User click voucher button
    Then User directed to voucher screen
    And User click "All" button on voucher screen
    And User click voucher banner "5%"
    Then User directed to voucher detail screen
    When user click back button on voucher detail screen
    Then User directed to voucher screen
    When User click voucher banner "5.0000"
    Then User directed to voucher detail screen
    When user click back button on voucher detail screen
    Then User directed to voucher screen

  @VOSC018-VOSC020
  Scenario Outline: Voucher doesn't show up because internet connection isn't available
    When User click voucher button while internet is off
    Then User directed to voucher screen
    When User click "<button>" button on voucher screen
    Then User see warning "Connection error" on voucher screen
    Examples:
      | button   |
      | All      |
      | Discount |
      | Cashback |

  @VOSC021
  Scenario: Voucher Detail doesn't show up because internet connection isn't available
    When User click voucher button
    Then User directed to voucher screen
    When User click one of voucher banner while internet is off
    Then User directed to voucher detail screen
    Then User see warning "Connection error" on voucher detail screen