@Android @Recharge

Feature: Mobile Recharge


  Background:
    Given User is on sign in page
    When User input phone number "08555777888"
    And User input pin number "123456"
#  Gunakan username dan PIN masing-masing!!

  @MR001 @MR006
  Scenario Outline: Checking provider logo and top up nominal
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User see top up catalog
    Examples:
      | phoneNumber |
      | 0859200000  |
      | 0812000000  |
      | 0898000000  |
      | 0815000000  |
      | 0882000000  |
      | 0833000000  |

  #minimum top up to get voucher = 10000 (price)
  @MR007 @MR009 @MR010 @MR012 @MR013 @MR015 @MR016 @MR018 @MR019 @MR021 @MR022 @MR024
  Scenario Outline: Top up (10 digit and 13 digit phone number) without voucher
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And if "<statusVoucher>" is "available", user choose no voucher
    And User pay the bill
    And User see payment success page
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | phoneNumber   | topUp | statusVoucher | statusPayment |
      | 0895200000    | 5000  | unavailable   | success       |
      | 0859300000    | 5000  | unavailable   | success       |
      | 0859400000    | 5000  | unavailable   | success       |
      | 0859500000    | 5000  | unavailable   | success       |
      | 0859600000    | 5000  | unavailable   | success       |
      | 0859700000    | 5000  | unavailable   | success       |
      | 0859900000    | 5000  | unavailable   | success       |
      | 0877000000    | 5000  | unavailable   | success       |
      | 0878000000    | 5000  | unavailable   | success       |
      | 0817000000    | 5000  | unavailable   | success       |
      | 0818000000    | 5000  | unavailable   | success       |
      | 0819000000    | 5000  | unavailable   | success       |
      | 0859233333333 | 5000  | unavailable   | success       |
      | 0859333333333 | 5000  | unavailable   | success       |
      | 0859433333333 | 5000  | unavailable   | success       |
      | 0859533333333 | 5000  | unavailable   | success       |
      | 0859633333333 | 5000  | unavailable   | success       |
      | 0859733333333 | 5000  | unavailable   | success       |
      | 0859933333333 | 5000  | unavailable   | success       |
      | 0877333333333 | 5000  | unavailable   | success       |
      | 0878333333333 | 5000  | unavailable   | success       |
      | 0817333333333 | 5000  | unavailable   | success       |
      | 0818333333333 | 5000  | unavailable   | success       |
      | 0819333333333 | 5000  | unavailable   | success       |
      | 0812000000    | 15000 | available     | success       |
      | 0813000000    | 15000 | available     | success       |
      | 0821000000    | 15000 | available     | success       |
      | 0822000000    | 15000 | available     | success       |
      | 0823000000    | 15000 | available     | success       |
      | 0852000000    | 15000 | available     | success       |
      | 0853000000    | 15000 | available     | success       |
      | 0851000000    | 15000 | available     | success       |
      | 0812000000    | 15000 | available     | success       |
      | 0813000000    | 15000 | available     | success       |
      | 0821000000    | 15000 | available     | success       |
      | 0822000000    | 15000 | available     | success       |
      | 0823000000    | 15000 | available     | success       |
      | 0852000000    | 15000 | available     | success       |
      | 0853000000    | 15000 | available     | success       |
      | 0851000000    | 15000 | available     | success       |
      | 0898000000    | 5000  | unavailable   | success       |
      | 0899000000    | 5000  | unavailable   | success       |
      | 0895000000    | 5000  | unavailable   | success       |
      | 0896000000    | 5000  | unavailable   | success       |
      | 0897000000    | 5000  | unavailable   | success       |
      | 0895333333333 | 5000  | unavailable   | success       |
      | 0896333333333 | 5000  | unavailable   | success       |
      | 0897333333333 | 5000  | unavailable   | success       |
      | 0898333333333 | 5000  | unavailable   | success       |
      | 0899333333333 | 5000  | unavailable   | success       |
      | 0815000000    | 5000  | unavailable   | success       |
      | 0816000000    | 5000  | unavailable   | success       |
      | 0855000000    | 5000  | unavailable   | success       |
      | 0856000000    | 5000  | unavailable   | success       |
      | 0857000000    | 5000  | unavailable   | success       |
      | 0858000000    | 5000  | unavailable   | success       |
      | 0815333333333 | 5000  | unavailable   | success       |
      | 0816333333333 | 5000  | unavailable   | success       |
      | 0855333333333 | 5000  | unavailable   | success       |
      | 0856333333333 | 5000  | unavailable   | success       |
      | 0857333333333 | 5000  | unavailable   | success       |
      | 0858333333333 | 5000  | unavailable   | success       |
      | 08820000000   | 5000  | unavailable   | success       |
      | 08830000000   | 5000  | unavailable   | success       |
      | 08840000000   | 5000  | unavailable   | success       |
      | 08850000000   | 5000  | unavailable   | success       |
      | 08860000000   | 5000  | unavailable   | success       |
      | 08870000000   | 5000  | unavailable   | success       |
      | 08880000000   | 5000  | unavailable   | success       |
      | 08890000000   | 5000  | unavailable   | success       |
      | 0882333333333 | 5000  | unavailable   | success       |
      | 0883333333333 | 5000  | unavailable   | success       |
      | 0884333333333 | 5000  | unavailable   | success       |
      | 0885333333333 | 5000  | unavailable   | success       |
      | 0886333333333 | 5000  | unavailable   | success       |
      | 0887333333333 | 5000  | unavailable   | success       |
      | 0888333333333 | 5000  | unavailable   | success       |
      | 0889333333333 | 5000  | unavailable   | success       |
      | 0833000000    | 5000  | unavailable   | success       |
      | 0838000000    | 5000  | unavailable   | success       |
      | 0831000000    | 5000  | unavailable   | success       |
      | 0859100000    | 5000  | unavailable   | success       |
      | 0859800000    | 5000  | unavailable   | success       |
      | 0833333333333 | 5000  | unavailable   | success       |
      | 0838333333333 | 5000  | unavailable   | success       |
      | 0831333333333 | 5000  | unavailable   | success       |
      | 0859133333333 | 5000  | unavailable   | success       |
      | 0859833333333 | 5000  | unavailable   | success       |

  @MR008 @MR011 @MR014 @MR017 @MR020 @MR023
  Scenario Outline: Top Up (12 digit phone number) using voucher (if available)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And User pick a voucher
    And User choose voucher value "<chooseVoucher>"
    And User pay the bill
    Then User see payment success page
    #tambahkan step dapet/ga dapet voucher
    And  User see payment status "<statusPayment>"
    Examples:
      | phoneNumber  | topUp   | statusVoucher | chooseVoucher | statusPayment |
      | 085902222222 | 5000    | unavailable   | no            | success       |
      | 085902222222 | 10000   | available     | no            | success       |
      | 085902222222 | 10000   | available     | cashback 1K   | success       |
      | 085902222222 | 15000   | available     | no            | success       |
      | 085902222222 | 15000   | available     | cashback 1K   | success       |
      | 085902222222 | 30000   | available     | no            | success       |
      | 085902222222 | 30000   | available     | cashback 1K   | success       |
      | 085902222222 | 30000   | available     | cashback 1.5K | success       |
      | 085902222222 | 30000   | available     | cashback 2K   | success       |
      | 085902222222 | 50000   | available     | no            | success       |
      | 085902222222 | 50000   | available     | cashback 1K   | success       |
      | 085902222222 | 50000   | available     | cashback 1.5K | success       |
      | 085902222222 | 50000   | available     | cashback 2K   | success       |
      | 085902222222 | 50000   | available     | cashback 2.5K | success       |
      | 085902222222 | 50000   | available     | cashback 3K   | success       |
      | 085902222222 | 50000   | available     | cashback 3.5K | success       |
      | 085902222222 | 100000  | available     | no            | success       |
      | 085902222222 | 100000  | available     | cashback 1K   | success       |
      | 085902222222 | 100000  | available     | cashback 1.5K | success       |
      | 085902222222 | 100000  | available     | cashback 2K   | success       |
      | 085902222222 | 100000  | available     | cashback 2.5K | success       |
      | 085902222222 | 100000  | available     | cashback 3K   | success       |
      | 085902222222 | 100000  | available     | cashback 3.5K | success       |
      | 085902222222 | 100000  | available     | discount 5%   | success       |
      | 085902222222 | 100000  | available     | discount 10%  | success       |
      | 085902222222 | 100000  | available     | discount 15%  | success       |
      | 085902222222 | 150000  | available     | no            | success       |
      | 085902222222 | 150000  | available     | cashback 1K   | success       |
      | 085902222222 | 150000  | available     | cashback 1.5K | success       |
      | 085902222222 | 150000  | available     | cashback 2K   | success       |
      | 085902222222 | 150000  | available     | cashback 2.5K | success       |
      | 085902222222 | 150000  | available     | cashback 3K   | success       |
      | 085902222222 | 150000  | available     | cashback 3.5K | success       |
      | 085902222222 | 150000  | available     | discount 5%   | success       |
      | 085902222222 | 150000  | available     | discount 10%  | success       |
      | 085902222222 | 150000  | available     | discount 15%  | success       |
      | 085902222222 | 150000  | available     | discount 20%  | success       |
      | 085902222222 | 200000  | available     | no            | success       |
      | 085902222222 | 200000  | available     | cashback 1K   | success       |
      | 085902222222 | 200000  | available     | cashback 1.5K | success       |
      | 085902222222 | 200000  | available     | cashback 2K   | success       |
      | 085902222222 | 200000  | available     | cashback 2.5K | success       |
      | 085902222222 | 200000  | available     | cashback 3K   | success       |
      | 085902222222 | 200000  | available     | cashback 3.5K | success       |
      | 085902222222 | 200000  | available     | discount 5%   | success       |
      | 085902222222 | 200000  | available     | discount 10%  | success       |
      | 085902222222 | 200000  | available     | discount 15%  | success       |
      | 085902222222 | 200000  | available     | discount 20%  | success       |
      | 085902222222 | 200000  | available     | discount 25%  | success       |
      | 085902222222 | 300000  | available     | no            | success       |
      | 085902222222 | 300000  | available     | cashback 1K   | success       |
      | 085902222222 | 300000  | available     | cashback 1.5K | success       |
      | 085902222222 | 300000  | available     | cashback 2K   | success       |
      | 085902222222 | 300000  | available     | cashback 2.5K | success       |
      | 085902222222 | 300000  | available     | cashback 3K   | success       |
      | 085902222222 | 300000  | available     | cashback 3.5K | success       |
      | 085902222222 | 300000  | available     | discount 5%   | success       |
      | 085902222222 | 300000  | available     | discount 10%  | success       |
      | 085902222222 | 300000  | available     | discount 15%  | success       |
      | 085902222222 | 300000  | available     | discount 20%  | success       |
      | 085902222222 | 300000  | available     | discount 25%  | success       |
      | 085902222222 | 300000  | available     | discount 30%  | success       |
      | 085902222222 | 300000  | available     | discount 35%  | success       |
      | 085902222222 | 500000  | available     | no            | success       |
      | 085902222222 | 500000  | available     | cashback 1K   | success       |
      | 085902222222 | 500000  | available     | cashback 1.5K | success       |
      | 085902222222 | 500000  | available     | cashback 2K   | success       |
      | 085902222222 | 500000  | available     | cashback 2.5K | success       |
      | 085902222222 | 500000  | available     | cashback 3K   | success       |
      | 085902222222 | 500000  | available     | cashback 3.5K | success       |
      | 085902222222 | 500000  | available     | discount 5%   | success       |
      | 085902222222 | 500000  | available     | discount 10%  | success       |
      | 085902222222 | 500000  | available     | discount 15%  | success       |
      | 085902222222 | 500000  | available     | discount 20%  | success       |
      | 085902222222 | 500000  | available     | discount 25%  | success       |
      | 085902222222 | 500000  | available     | discount 30%  | success       |
      | 085902222222 | 500000  | available     | discount 35%  | success       |
      | 085902222222 | 500000  | available     | discount 40%  | success       |
      | 085902222222 | 1000000 | available     | no            | success       |
      | 085902222222 | 1000000 | available     | cashback 1K   | success       |
      | 085902222222 | 1000000 | available     | cashback 1.5K | success       |
      | 085902222222 | 1000000 | available     | cashback 2K   | success       |
      | 085902222222 | 1000000 | available     | cashback 2.5K | success       |
      | 085902222222 | 1000000 | available     | cashback 3K   | success       |
      | 085902222222 | 1000000 | available     | cashback 3.5K | success       |
      | 085902222222 | 1000000 | available     | discount 5%   | success       |
      | 085902222222 | 1000000 | available     | discount 10%  | success       |
      | 085902222222 | 1000000 | available     | discount 15%  | success       |
      | 085902222222 | 1000000 | available     | discount 20%  | success       |
      | 085902222222 | 1000000 | available     | discount 25%  | success       |
      | 085902222222 | 1000000 | available     | discount 30%  | success       |
      | 085902222222 | 1000000 | available     | discount 35%  | success       |
      | 085902222222 | 1000000 | available     | discount 40%  | success       |
      | 085902222222 | 1000000 | available     | discount 45%  | success       |

  Scenario: Cancel a transaction
    Given User is on homepage
    When User click mobile recharge icon
    And User input "085902222222"
    And User choose "5K" nominal
    And User see payment detail page
    And User open action menu
    And User cancel transaction
    And User confirm to cancel transaction
    And User is on homepage
    And User click history icon
    And User choose completed tab
    Then User see cancelled transaction

  Scenario: Top Up Recent Number
    Given User is on homepage
    When User click mobile recharge icon
    And User choose from recent number
    And User choose "5K" nominal
    Then User see payment detail page

  @Trial-1
  Scenario Outline: Top up (10 digit and 13 digit phone number) without voucher
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And if "<statusVoucher>" is "available", user choose no voucher
    And User pay the bill
    And User see payment success page
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | phoneNumber | topUp | statusVoucher | statusPayment |
      | 0895200000  | 5.000 | unavailable   | Completed     |
#      | 0851000000  | 15.000 | available     | success       |