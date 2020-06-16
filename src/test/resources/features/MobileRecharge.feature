@Android @Recharge

Feature: Mobile Recharge

  Background:
#    Given User is already login
  @MR001-MR006
  Scenario Outline: Checking provider logo and top up nominal
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User see top up page
    Examples:
    |phoneNumber|


  @MR007,MR009,MR010,MR012,MR013,MR015,MR016,MR018,MR019,MR021,MR022,MR024
  Scenario Outline: Top up (10 digit and 13 digit phone number) without voucher
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User see payment detail page
    And User pay the bill
    And User see payment success page
    And  User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | phoneNumber    | topUp | statusPayment |
      | 0895200000     | 5k    | success       |
      | 0859300000     | 5k    | success       |
      | 0859400000     | 5k    | success       |
      | 0859500000     | 5k    | success       |
      | 0859600000     | 5k    | success       |
      | 0859700000     | 5k    | success       |
      | 0859900000     | 5k    | success       |
      | 0877000000     | 5k    | success       |
      | 0878000000     | 5k    | success       |
      | 0817000000     | 5k    | success       |
      | 0818000000     | 5k    | success       |
      | 0819000000     | 5k    | success       |
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
      | 0812000000     | 15k   | success       |
      | 0813000000     | 15k   | success       |
      | 0821000000     | 15k   | success       |
      | 0822000000     | 15k   | success       |
      | 0823000000     | 15k   | success       |
      | 0852000000     | 15k   | success       |
      | 0853000000     | 15k   | success       |
      | 0851000000     | 15k   | success       |
      | 0812000000     | 15k   | success       |
      | 0813000000     | 15k   | success       |
      | 0821000000     | 15k   | success       |
      | 0822000000     | 15k   | success       |
      | 0823000000     | 15k   | success       |
      | 0852000000     | 15k   | success       |
      | 0853000000     | 15k   | success       |
      | 0851000000     | 15k   | success       |
      | 0898000000     | 5k    | success       |
      | 0899000000     | 5k    | success       |
      | 0895000000     | 5k    | success       |
      | 0896000000     | 5k    | success       |
      | 0897000000     | 5k    | success       |
      | 0895333333333  | 5k    | success       |
      | 0896333333333  | 5k    | success       |
      | 0897333333333  | 5k    | success       |
      | 0898333333333  | 5k    | success       |
      | 0899333333333  | 5k    | success       |
      | 0815000000     | 5k    | success       |
      | 0816000000     | 5k    | success       |
      | 0855000000     | 5k    | success       |
      | 0856000000     | 5k    | success       |
      | 0857000000     | 5k    | success       |
      | 0858000000     | 5k    | success       |
      | 0815333333333  | 5k    | success       |
      | 0816333333333  | 5k    | success       |
      | 0855333333333  | 5k    | success       |
      | 0856333333333  | 5k    | success       |
      | 0857333333333  | 5k    | success       |
      | 0858333333333  | 5k    | success       |
      | 08820000000    | 5k    | success       |
      | 08830000000    | 5k    | success       |
      | 08840000000    | 5k    | success       |
      | 08850000000    | 5k    | success       |
      | 08860000000    | 5k    | success       |
      | 08870000000    | 5k    | success       |
      | 08880000000    | 5k    | success       |
      | 08890000000    | 5k    | success       |
      | 08823333333333 | 5k    | success       |
      | 08833333333333 | 5k    | success       |
      | 08843333333333 | 5k    | success       |
      | 08853333333333 | 5k    | success       |
      | 08863333333333 | 5k    | success       |
      | 08873333333333 | 5k    | success       |
      | 08883333333333 | 5k    | success       |
      | 08893333333333 | 5k    | success       |
      | 0833000000     | 5k    | success       |
      | 0838000000     | 5k    | success       |
      | 0831000000     | 5k    | success       |
      | 0859100000     | 5k    | success       |
      | 0859800000     | 5k    | success       |
      | 0833333333333  | 5k    | success       |
      | 0838333333333  | 5k    | success       |
      | 0831333333333  | 5k    | success       |
      | 0859133333333  | 5k    | success       |
      | 0859833333333  | 5k    | success       |

  @MR008,MR011,MR014,MR017,MR020,MR023
  Scenario Outline: Top Up (12 digit phone number) using voucher (if available)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User see payment detail page
    And User check status voucher availability "<statusVoucher>"
    And User choose voucher value "<chooseVoucher>"
    And User pay the bill
    Then User see payment success page
    And  User see payment status "<statusPayment>"
    Examples:
      | phoneNumber  | topUp | statusVoucher | chooseVoucher | statusPayment |
      | 085902222222 | 5K    | unavailable   | no            | success       |
      | 085902222222 | 10K   | available     | no            | success       |
      | 085902222222 | 10K   | available     | cashback 1K   | success       |
      | 085902222222 | 15K   | available     | no            | success       |
      | 085902222222 | 15K   | available     | cashback 1K   | success       |
      | 085902222222 | 30K   | available     | no            | success       |
      | 085902222222 | 30K   | available     | cashback 1K   | success       |
      | 085902222222 | 30K   | available     | cashback 1.5K | success       |
      | 085902222222 | 30K   | available     | cashback 2K   | success       |
      | 085902222222 | 50K   | available     | no            | success       |
      | 085902222222 | 50K   | available     | cashback 1K   | success       |
      | 085902222222 | 50K   | available     | cashback 1.5K | success       |
      | 085902222222 | 50K   | available     | cashback 2K   | success       |
      | 085902222222 | 50K   | available     | cashback 2.5K | success       |
      | 085902222222 | 50K   | available     | cashback 3K   | success       |
      | 085902222222 | 50K   | available     | cashback 3.5K | success       |
      | 085902222222 | 100K  | available     | no            | success       |
      | 085902222222 | 100K  | available     | cashback 1K   | success       |
      | 085902222222 | 100K  | available     | cashback 1.5K | success       |
      | 085902222222 | 100K  | available     | cashback 2K   | success       |
      | 085902222222 | 100K  | available     | cashback 2.5K | success       |
      | 085902222222 | 100K  | available     | cashback 3K   | success       |
      | 085902222222 | 100K  | available     | cashback 3.5K | success       |
      | 085902222222 | 100K  | available     | discount 5%   | success       |
      | 085902222222 | 100K  | available     | discount 10%  | success       |
      | 085902222222 | 100K  | available     | discount 15%  | success       |
      | 085902222222 | 150K  | available     | no            | success       |
      | 085902222222 | 150K  | available     | cashback 1K   | success       |
      | 085902222222 | 150K  | available     | cashback 1.5K | success       |
      | 085902222222 | 150K  | available     | cashback 2K   | success       |
      | 085902222222 | 150K  | available     | cashback 2.5K | success       |
      | 085902222222 | 150K  | available     | cashback 3K   | success       |
      | 085902222222 | 150K  | available     | cashback 3.5K | success       |
      | 085902222222 | 150K  | available     | discount 5%   | success       |
      | 085902222222 | 150K  | available     | discount 10%  | success       |
      | 085902222222 | 150K  | available     | discount 15%  | success       |
      | 085902222222 | 150K  | available     | discount 20%  | success       |
      | 085902222222 | 200K  | available     | no            | success       |
      | 085902222222 | 200K  | available     | cashback 1K   | success       |
      | 085902222222 | 200K  | available     | cashback 1.5K | success       |
      | 085902222222 | 200K  | available     | cashback 2K   | success       |
      | 085902222222 | 200K  | available     | cashback 2.5K | success       |
      | 085902222222 | 200K  | available     | cashback 3K   | success       |
      | 085902222222 | 200K  | available     | cashback 3.5K | success       |
      | 085902222222 | 200K  | available     | discount 5%   | success       |
      | 085902222222 | 200K  | available     | discount 10%  | success       |
      | 085902222222 | 200K  | available     | discount 15%  | success       |
      | 085902222222 | 200K  | available     | discount 20%  | success       |
      | 085902222222 | 200K  | available     | discount 25%  | success       |
      | 085902222222 | 300K  | available     | no            | success       |
      | 085902222222 | 300K  | available     | cashback 1K   | success       |
      | 085902222222 | 300K  | available     | cashback 1.5K | success       |
      | 085902222222 | 300K  | available     | cashback 2K   | success       |
      | 085902222222 | 300K  | available     | cashback 2.5K | success       |
      | 085902222222 | 300K  | available     | cashback 3K   | success       |
      | 085902222222 | 300K  | available     | cashback 3.5K | success       |
      | 085902222222 | 300K  | available     | discount 5%   | success       |
      | 085902222222 | 300K  | available     | discount 10%  | success       |
      | 085902222222 | 300K  | available     | discount 15%  | success       |
      | 085902222222 | 300K  | available     | discount 20%  | success       |
      | 085902222222 | 300K  | available     | discount 25%  | success       |
      | 085902222222 | 300K  | available     | discount 30%  | success       |
      | 085902222222 | 300K  | available     | discount 35%  | success       |
      | 085902222222 | 500K  | available     | no            | success       |
      | 085902222222 | 500K  | available     | cashback 1K   | success       |
      | 085902222222 | 500K  | available     | cashback 1.5K | success       |
      | 085902222222 | 500K  | available     | cashback 2K   | success       |
      | 085902222222 | 500K  | available     | cashback 2.5K | success       |
      | 085902222222 | 500K  | available     | cashback 3K   | success       |
      | 085902222222 | 500K  | available     | cashback 3.5K | success       |
      | 085902222222 | 500K  | available     | discount 5%   | success       |
      | 085902222222 | 500K  | available     | discount 10%  | success       |
      | 085902222222 | 500K  | available     | discount 15%  | success       |
      | 085902222222 | 500K  | available     | discount 20%  | success       |
      | 085902222222 | 500K  | available     | discount 25%  | success       |
      | 085902222222 | 500K  | available     | discount 30%  | success       |
      | 085902222222 | 500K  | available     | discount 35%  | success       |
      | 085902222222 | 500K  | available     | discount 40%  | success       |
      | 085902222222 | 1M    | available     | no            | success       |
      | 085902222222 | 1M    | available     | cashback 1K   | success       |
      | 085902222222 | 1M    | available     | cashback 1.5K | success       |
      | 085902222222 | 1M    | available     | cashback 2K   | success       |
      | 085902222222 | 1M    | available     | cashback 2.5K | success       |
      | 085902222222 | 1M    | available     | cashback 3K   | success       |
      | 085902222222 | 1M    | available     | cashback 3.5K | success       |
      | 085902222222 | 1M    | available     | discount 5%   | success       |
      | 085902222222 | 1M    | available     | discount 10%  | success       |
      | 085902222222 | 1M    | available     | discount 15%  | success       |
      | 085902222222 | 1M    | available     | discount 20%  | success       |
      | 085902222222 | 1M    | available     | discount 25%  | success       |
      | 085902222222 | 1M    | available     | discount 30%  | success       |
      | 085902222222 | 1M    | available     | discount 35%  | success       |
      | 085902222222 | 1M    | available     | discount 40%  | success       |
      | 085902222222 | 1M    | available     | discount 45%  | success       |
