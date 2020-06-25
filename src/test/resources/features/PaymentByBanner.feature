@Android @Promotion
Feature: Mobile Recharge

  Background:
    Given User is on sign in page
    When User input phone number "088245593542"
    And User input pin number "123456"

  @MR028
  Scenario Outline: Top up with voucher via promotion banner (13 digit phone number)
    Given User is on homepage
    When User click Promotion Banner
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
      | phoneNumber    | topUp | statusVoucher | chooseVoucher | statusPayment |
      | 0859233333333  | 15K   | available     | cashback 1K   | success       |
      | 0859333333333  | 15K   | available     | cashback 1K   | success       |
      | 0859433333333  | 15K   | available     | cashback 1K   | success       |
      | 0859533333333  | 15K   | available     | cashback 1K   | success       |
      | 0859633333333  | 15K   | available     | cashback 1K   | success       |
      | 0859733333333  | 15K   | available     | cashback 1K   | success       |
      | 0859933333333  | 15K   | available     | cashback 1K   | success       |
      | 0877333333333  | 15K   | available     | cashback 1K   | success       |
      | 0878333333333  | 15K   | available     | cashback 1K   | success       |
      | 0817333333333  | 15K   | available     | cashback 1K   | success       |
      | 0818333333333  | 15K   | available     | cashback 1K   | success       |
      | 0819333333333  | 15K   | available     | cashback 1K   | success       |
      | 0895333333333  | 15K   | available     | cashback 1K   | success       |
      | 0896333333333  | 15K   | available     | cashback 1K   | success       |
      | 0897333333333  | 15K   | available     | cashback 1K   | success       |
      | 0898333333333  | 15K   | available     | cashback 1K   | success       |
      | 0899333333333  | 15K   | available     | cashback 1K   | success       |
      | 0815333333333  | 15K   | available     | cashback 1K   | success       |
      | 0816333333333  | 15K   | available     | cashback 1K   | success       |
      | 0855333333333  | 15K   | available     | cashback 1K   | success       |
      | 0856333333333  | 15K   | available     | cashback 1K   | success       |
      | 0857333333333  | 15K   | available     | cashback 1K   | success       |
      | 0858333333333  | 15K   | available     | cashback 1K   | success       |
      | 08823333333333 | 15K   | available     | cashback 1K   | success       |
      | 08833333333333 | 15K   | available     | cashback 1K   | success       |
      | 08843333333333 | 15K   | available     | cashback 1K   | success       |
      | 08853333333333 | 15K   | available     | cashback 1K   | success       |
      | 08863333333333 | 15K   | available     | cashback 1K   | success       |
      | 08873333333333 | 15K   | available     | cashback 1K   | success       |
      | 08883333333333 | 15K   | available     | cashback 1K   | success       |
      | 08893333333333 | 15K   | available     | cashback 1K   | success       |
      | 0833333333333  | 15K   | available     | cashback 1K   | success       |
      | 0838333333333  | 15K   | available     | cashback 1K   | success       |
      | 0831333333333  | 15K   | available     | cashback 1K   | success       |
      | 0859133333333  | 15K   | available     | cashback 1K   | success       |
      | 0859833333333  | 15K   | available     | cashback 1K   | success       |


  @MR029
  Scenario Outline: Top up without voucher via promotion banner (13 digit phone number)
    Given User is on homepage
    When User click Promotion Banner
    Then User click Buy Pulsa Now
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see payment detail page
    And User pay the bill
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | phoneNumber    | topUp | statusPayment |
      | 0859233333333  | 5k    | success       |
      | 0859333333333  | 5k    | success       |
      | 0859433333333  | 5k    | success       |
      | 0859533333333  | 5k    | success       |
      | 0859633333333  | 5k    | success       |
      | 0859733333333  | 5k    | success       |
      | 0859933333333  | 5k    | success       |
      | 0877333333333  | 5k    | success       |
      | 0878333333333  | 5k    | success       |
      | 0817333333333  | 5k    | success       |
      | 0818333333333  | 5k    | success       |
      | 0819333333333  | 5k    | success       |
      | 0895333333333  | 5k    | success       |
      | 0896333333333  | 5k    | success       |
      | 0897333333333  | 5k    | success       |
      | 0898333333333  | 5k    | success       |
      | 0899333333333  | 5k    | success       |
      | 0815333333333  | 5k    | success       |
      | 0816333333333  | 5k    | success       |
      | 0855333333333  | 5k    | success       |
      | 0856333333333  | 5k    | success       |
      | 0857333333333  | 5k    | success       |
      | 0858333333333  | 5k    | success       |
      | 08823333333333 | 5k    | success       |
      | 08833333333333 | 5k    | success       |
      | 08843333333333 | 5k    | success       |
      | 08853333333333 | 5k    | success       |
      | 08863333333333 | 5k    | success       |
      | 08873333333333 | 5k    | success       |
      | 08883333333333 | 5k    | success       |
      | 08893333333333 | 5k    | success       |
      | 0833333333333  | 5k    | success       |
      | 0838333333333  | 5k    | success       |
      | 0831333333333  | 5k    | success       |
      | 0859133333333  | 5k    | success       |
      | 0859833333333  | 5k    | success       |