@Android @Promotion
Feature: Mobile Recharge

  Background:
    Given User is on sign in page
    When User input phone number "088245593542"
    And User input pin number "123456"

  @MR028
  Scenario Outline: Top up with voucher via promotion banner (13 digit phone number)
    Given User is on homepage
    When User choose "<title>" on banner
    Then User click Buy Pulsa Now
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And User pick a voucher
    And User choose voucher value "<chooseVoucher>"
    And User pay the bill
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | title | phoneNumber    | topUp | statusVoucher | chooseVoucher | statusPayment |
      | Cashback Rp 1.500 buat beli pulsa | 0859233333333  | 15.000   | available     | Cashback Rp 1.000 buat beli pulsa | Payment Completed       |
      | Cashback Rp 1.500 buat beli pulsa | 0859333333333  | 25.000   | available     | Cashback Rp 2.000 buat beli pulsa | Payment Completed       |
#      | 0859433333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0859533333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0859633333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0859733333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0859933333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0877333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0878333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0817333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0818333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0819333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0895333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0896333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0897333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0898333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0899333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0815333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0816333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0855333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0856333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0857333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0858333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 08823333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 08833333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 08843333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 08853333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 08863333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 08873333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 08883333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 08893333333333 | 15.000   | available     | cashback 1.000   | success       |
#      | 0833333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0838333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0831333333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0859133333333  | 15.000   | available     | cashback 1.000   | success       |
#      | 0859833333333  | 15.000   | available     | cashback 1.000   | success       |


  @MR029
  Scenario Outline: Top up without voucher via promotion banner (13 digit phone number)
    Given User is on homepage
    When User choose "<title>" on banner
    Then User click Buy Pulsa Now
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see payment detail page
    And User pay the bill
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | title | phoneNumber    | topUp | statusPayment |
      | Cashback Rp 1.500 buat beli pulsa | 0859233333333  | 15.000    | Payment Completed  |
#      | 0859333333333  | 15.000    | success       |
#      | 0859433333333  | 15.000    | success       |
#      | 0859533333333  | 15.000    | success       |
#      | 0859633333333  | 15.000    | success       |
#      | 0859733333333  | 15.000    | success       |
#      | 0859933333333  | 15.000    | success       |
#      | 0877333333333  | 15.000    | success       |
#      | 0878333333333  | 15.000    | success       |
#      | 0817333333333  | 15.000    | success       |
#      | 0818333333333  | 15.000    | success       |
#      | 0819333333333  | 15.000    | success       |
#      | 0812000000    | 15.000 | success       |
#      | 0813000000    | 15.000 | success       |
#      | 0821000000    | 15.000 | success       |
#      | 0822000000    | 15.000 | success       |
#      | 0823000000    | 15.000 | success       |
#      | 0852000000    | 15.000 | success       |
#      | 0853000000    | 15.000 | success       |
#      | 0851000000    | 15.000 | success       |
#      | 0812000000    | 15.000 | success       |
#      | 0813000000    | 15.000 | success       |
#      | 0821000000    | 15.000 | success       |
#      | 0822000000    | 15.000 | success       |
#      | 0823000000    | 15.000 | success       |
#      | 0852000000    | 15.000 | success       |
#      | 0853000000    | 15.000 | success       |
#      | 0851000000    | 15.000 | success       |
#      | 0895333333333  | 15.000    | success       |
#      | 0896333333333  | 15.000    | success       |
#      | 0897333333333  | 15.000    | success       |
#      | 0898333333333  | 15.000    | success       |
#      | 0899333333333  | 15.000    | success       |
#      | 0815333333333  | 10.000    | success       |
#      | 0816333333333  | 10.000    | success       |
#      | 0855333333333  | 10.000    | success       |
#      | 0856333333333  | 10.000    | success       |
#      | 0857333333333  | 10.000    | success       |
#      | 0858333333333  | 10.000    | success       |
#      | 08823333333333 | 10.000    | success       |
#      | 08833333333333 | 10.000    | success       |
#      | 08843333333333 | 10.000    | success       |
#      | 08853333333333 | 10.000    | success       |
#      | 08863333333333 | 10.000    | success       |
#      | 08873333333333 | 10.000    | success       |
#      | 08883333333333 | 10.000    | success       |
#      | 08893333333333 | 10.000    | success       |
#      | 0833333333333  | 10.000    | success       |
#      | 0838333333333  | 10.000    | success       |
#      | 0831333333333  | 10.000    | success       |
#      | 0859133333333  | 10.000    | success       |
#      | 0859833333333  | 10.000    | success       |