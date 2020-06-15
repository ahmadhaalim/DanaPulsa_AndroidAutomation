@Android @Recharge

Feature: Mobile Recharge

  Background:
#    Given User is already login

  @MR007,MR009,MR010,MR012,MR013,MR015,MR016,MR018,MR019,MR021,MR022,MR024
  Scenario Outline: Top up (10 digit and 13 digit phone number) without voucher
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User see payment detail page
    And User pay the bill
    Then User see payment success page
    Examples:
      | phoneNumber    | topUp |
      | 0895200000     | 5k    |
      | 0859300000     | 5k    |
      | 0859400000     | 5k    |
      | 0859500000     | 5k    |
      | 0859600000     | 5k    |
      | 0859700000     | 5k    |
      | 0859900000     | 5k    |
      | 0877000000     | 5k    |
      | 0878000000     | 5k    |
      | 0817000000     | 5k    |
      | 0818000000     | 5k    |
      | 0819000000     | 5k    |
      | 0859233333333  | 5k    |
      | 0859333333333  | 5k    |
      | 0859433333333  | 5k    |
      | 0859533333333  | 5k    |
      | 0859633333333  | 5k    |
      | 0859733333333  | 5k    |
      | 0859933333333  | 5k    |
      | 0877333333333  | 5k    |
      | 0878333333333  | 5k    |
      | 0817333333333  | 5k    |
      | 0818333333333  | 5k    |
      | 0819333333333  | 5k    |
      | 0812000000     | 15k   |
      | 0813000000     | 15k   |
      | 0821000000     | 15k   |
      | 0822000000     | 15k   |
      | 0823000000     | 15k   |
      | 0852000000     | 15k   |
      | 0853000000     | 15k   |
      | 0851000000     | 15k   |
      | 0812000000     | 15k   |
      | 0813000000     | 15k   |
      | 0821000000     | 15k   |
      | 0822000000     | 15k   |
      | 0823000000     | 15k   |
      | 0852000000     | 15k   |
      | 0853000000     | 15k   |
      | 0851000000     | 15k   |
      | 0898000000     | 5k    |
      | 0899000000     | 5k    |
      | 0895000000     | 5k    |
      | 0896000000     | 5k    |
      | 0897000000     | 5k    |
      | 0895333333333  | 5k    |
      | 0896333333333  | 5k    |
      | 0897333333333  | 5k    |
      | 0898333333333  | 5k    |
      | 0899333333333  | 5k    |
      | 0815000000     | 5k    |
      | 0816000000     | 5k    |
      | 0855000000     | 5k    |
      | 0856000000     | 5k    |
      | 0857000000     | 5k    |
      | 0858000000     | 5k    |
      | 0815333333333  | 5k    |
      | 0816333333333  | 5k    |
      | 0855333333333  | 5k    |
      | 0856333333333  | 5k    |
      | 0857333333333  | 5k    |
      | 0858333333333  | 5k    |
      | 08820000000    | 5k    |
      | 08830000000    | 5k    |
      | 08840000000    | 5k    |
      | 08850000000    | 5k    |
      | 08860000000    | 5k    |
      | 08870000000    | 5k    |
      | 08880000000    | 5k    |
      | 08890000000    | 5k    |
      | 08823333333333 | 5k    |
      | 08833333333333 | 5k    |
      | 08843333333333 | 5k    |
      | 08853333333333 | 5k    |
      | 08863333333333 | 5k    |
      | 08873333333333 | 5k    |
      | 08883333333333 | 5k    |
      | 08893333333333 | 5k    |
      | 0833000000     | 5k    |
      | 0838000000     | 5k    |
      | 0831000000     | 5k    |
      | 0859100000     | 5k    |
      | 0859800000     | 5k    |
      | 0833333333333  | 5k    |
      | 0838333333333  | 5k    |
      | 0831333333333  | 5k    |
      | 0859133333333  | 5k    |
      | 0859833333333  | 5k    |

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
    Examples:
      | phoneNumber  | topUp | statusVoucher | chooseVoucher |
      | 085902222222 | 5K    | unavailable   | no            |
      | 085902222222 | 10K   | available     | no            |
      | 085902222222 | 10K   | available     | cashback 1K   |
      | 085902222222 | 15K   | available     | no            |
      | 085902222222 | 15K   | available     | cashback 1K   |
      | 085902222222 | 30K   | available     | no            |
      | 085902222222 | 30K   | available     | cashback 1K   |
      | 085902222222 | 30K   | available     | cashback 1.5K |
      | 085902222222 | 30K   | available     | cashback 2K   |
      | 085902222222 | 50K   | available     | no            |
      | 085902222222 | 50K   | available     | cashback 1K   |
      | 085902222222 | 50K   | available     | cashback 1.5K |
      | 085902222222 | 50K   | available     | cashback 2K   |
      | 085902222222 | 50K   | available     | cashback 2.5K |
      | 085902222222 | 50K   | available     | cashback 3K   |
      | 085902222222 | 50K   | available     | cashback 3.5K |
      | 085902222222 | 100K  | available     | no            |
      | 085902222222 | 100K  | available     | cashback 1K   |
      | 085902222222 | 100K  | available     | cashback 1.5K |
      | 085902222222 | 100K  | available     | cashback 2K   |
      | 085902222222 | 100K  | available     | cashback 2.5K |
      | 085902222222 | 100K  | available     | cashback 3K   |
      | 085902222222 | 100K  | available     | cashback 3.5K |
      | 085902222222 | 100K  | available     | discount 5%   |
      | 085902222222 | 100K  | available     | discount 10%  |
      | 085902222222 | 100K  | available     | discount 15%  |
      | 085902222222 | 150K  | available     | no            |
      | 085902222222 | 150K  | available     | cashback 1K   |
      | 085902222222 | 150K  | available     | cashback 1.5K |
      | 085902222222 | 150K  | available     | cashback 2K   |
      | 085902222222 | 150K  | available     | cashback 2.5K |
      | 085902222222 | 150K  | available     | cashback 3K   |
      | 085902222222 | 150K  | available     | cashback 3.5K |
      | 085902222222 | 150K  | available     | discount 5%   |
      | 085902222222 | 150K  | available     | discount 10%  |
      | 085902222222 | 150K  | available     | discount 15%  |
      | 085902222222 | 150K  | available     | discount 20%  |
      | 085902222222 | 200K  | available     | no            |
      | 085902222222 | 200K  | available     | cashback 1K   |
      | 085902222222 | 200K  | available     | cashback 1.5K |
      | 085902222222 | 200K  | available     | cashback 2K   |
      | 085902222222 | 200K  | available     | cashback 2.5K |
      | 085902222222 | 200K  | available     | cashback 3K   |
      | 085902222222 | 200K  | available     | cashback 3.5K |
      | 085902222222 | 200K  | available     | discount 5%   |
      | 085902222222 | 200K  | available     | discount 10%  |
      | 085902222222 | 200K  | available     | discount 15%  |
      | 085902222222 | 200K  | available     | discount 20%  |
      | 085902222222 | 200K  | available     | discount 25%  |
      | 085902222222 | 300K  | available     | no            |
      | 085902222222 | 300K  | available     | cashback 1K   |
      | 085902222222 | 300K  | available     | cashback 1.5K |
      | 085902222222 | 300K  | available     | cashback 2K   |
      | 085902222222 | 300K  | available     | cashback 2.5K |
      | 085902222222 | 300K  | available     | cashback 3K   |
      | 085902222222 | 300K  | available     | cashback 3.5K |
      | 085902222222 | 300K  | available     | discount 5%   |
      | 085902222222 | 300K  | available     | discount 10%  |
      | 085902222222 | 300K  | available     | discount 15%  |
      | 085902222222 | 300K  | available     | discount 20%  |
      | 085902222222 | 300K  | available     | discount 25%  |
      | 085902222222 | 300K  | available     | discount 30%  |
      | 085902222222 | 300K  | available     | discount 35%  |
      | 085902222222 | 500K  | available     | no            |
      | 085902222222 | 500K  | available     | cashback 1K   |
      | 085902222222 | 500K  | available     | cashback 1.5K |
      | 085902222222 | 500K  | available     | cashback 2K   |
      | 085902222222 | 500K  | available     | cashback 2.5K |
      | 085902222222 | 500K  | available     | cashback 3K   |
      | 085902222222 | 500K  | available     | cashback 3.5K |
      | 085902222222 | 500K  | available     | discount 5%   |
      | 085902222222 | 500K  | available     | discount 10%  |
      | 085902222222 | 500K  | available     | discount 15%  |
      | 085902222222 | 500K  | available     | discount 20%  |
      | 085902222222 | 500K  | available     | discount 25%  |
      | 085902222222 | 500K  | available     | discount 30%  |
      | 085902222222 | 500K  | available     | discount 35%  |
      | 085902222222 | 500K  | available     | discount 40%  |
      | 085902222222 | 1M    | available     | no            |
      | 085902222222 | 1M    | available     | cashback 1K   |
      | 085902222222 | 1M    | available     | cashback 1.5K |
      | 085902222222 | 1M    | available     | cashback 2K   |
      | 085902222222 | 1M    | available     | cashback 2.5K |
      | 085902222222 | 1M    | available     | cashback 3K   |
      | 085902222222 | 1M    | available     | cashback 3.5K |
      | 085902222222 | 1M    | available     | discount 5%   |
      | 085902222222 | 1M    | available     | discount 10%  |
      | 085902222222 | 1M    | available     | discount 15%  |
      | 085902222222 | 1M    | available     | discount 20%  |
      | 085902222222 | 1M    | available     | discount 25%  |
      | 085902222222 | 1M    | available     | discount 30%  |
      | 085902222222 | 1M    | available     | discount 35%  |
      | 085902222222 | 1M    | available     | discount 40%  |
      | 085902222222 | 1M    | available     | discount 45%  |
