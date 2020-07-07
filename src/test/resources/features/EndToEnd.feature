@Android

Feature: End to End

  Background:
    Given User is on sign in page
    When User input phone number "0877010101"
    And User input pin number "123456"
    Then User is on homepage

  @EndtoEnd
  Scenario Outline: End to End
    Given User is on homepage
    When User check initial balance
    And User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUpNominal>" nominal
    And User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And if "<statusVoucher>" is "available", user choose no voucher
    And If "<statusVoucher>" is "available", user choose voucher value "<voucher>"
    And User check total payment
    And User pay the bill
    And if "<statusVoucher>" is "unavailable", user get a voucher
    And User see payment status page
    And User see payment status "<statusPayment>"
    And User click back to home button
    And User is on homepage
    And User see that balance is reduce
    And User click history icon
    And User click completed tab
    And User choose a history
    And User see history status "<statusPayment>"
    And User back to history completed list
    And User go to homepage
    And User click voucher icon
    And User get "<voucher>" voucher
    And User go to homepage
    And User click profile
    Then User click sign out
    Examples:
    |phoneNumber|topUpNominal|statusVoucher|voucher|statusPayment|
