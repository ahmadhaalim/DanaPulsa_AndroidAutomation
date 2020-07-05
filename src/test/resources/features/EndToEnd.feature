@Android @History
Feature: End to End Mobile Recharge

  Background:
    Given User is on sign in page
    When User input phone number "088245593542"
    And User input pin number "123456"

  @EndToEnd1
  Scenario Outline: Top up without voucher via history in progress then top up with voucher via history in progress (13 digit phone number)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see payment detail page
    When User click back button at payment detail page
    And User click yes button on pop up dialog
    Then User directed to home screen
    When User click history button
    Then User click in progress tab
    And User click in progress payment
    Then User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And if "<statusVoucher>" is "available", user choose no voucher
    And User pay the bill
    And User click OK
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | phoneNumber    | topUp |statusVoucher| statusPayment |
      | 0859233333333  | 10.000    |unavailable| Payment Completed       |
      | 0813000000  | 15.000    |unavailable| Payment Completed       |

  @EndToEnd2
  Scenario Outline: Top up with voucher via history in progress (13 digit phone number)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see payment detail page
    When User click back button at payment detail page
    And User click yes button on pop up dialog
    Then User directed to home screen
    When User click history button
    Then User click in progress tab
    And User click in progress payment
    Then User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And User pick a voucher
    And User choose voucher value "<chooseVoucher>"
    And User pay the bill
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | phoneNumber    | topUp | statusVoucher | chooseVoucher | statusPayment |
      | 0859233333333  | 10.000   | available     | Cashback Rp 1.000 buat beli pulsa | Payment Completed       |
      | 0813000000  | 15.000   | available     | Cashback Rp 1.500 buat beli pulsa | Payment Completed       |