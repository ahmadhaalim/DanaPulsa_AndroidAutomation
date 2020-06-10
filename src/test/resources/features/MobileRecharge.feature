@Android @Recharge

Feature: Mobile Recharge

  Background:
#    Given User is already login

  @Recharge_1
  Scenario Outline: Top up without voucher
    Given User is on homepage
    When User click mobile recharge icon
    And User input <phoneNumber>
    And User choose top up nominal based on "<provider>"
    And User see payment detail page
    And User pay the bill
    Then User see payment success page
    Examples:
      | phoneNumber    | provider  |
      | 0895200000     | XL        |
      | 0859300000     | XL        |
      | 0859400000     | XL        |
      | 0859500000     | XL        |
      | 0859600000     | XL        |
      | 0859700000     | XL        |
      | 0859900000     | XL        |
      | 0877000000     | XL        |
      | 0878000000     | XL        |
      | 0817000000     | XL        |
      | 0818000000     | XL        |
      | 0819000000     | XL        |
      | 0859233333333  | XL        |
      | 0859333333333  | XL        |
      | 0859433333333  | XL        |
      | 0859533333333  | XL        |
      | 0859633333333  | XL        |
      | 0859733333333  | XL        |
      | 0859933333333  | XL        |
      | 0877333333333  | XL        |
      | 0878333333333  | XL        |
      | 0817333333333  | XL        |
      | 0818333333333  | XL        |
      | 0819333333333  | XL        |
      | 0812000000     | Telkomsel |
      | 0813000000     | Telkomsel |
      | 0821000000     | Telkomsel |
      | 0822000000     | Telkomsel |
      | 0823000000     | Telkomsel |
      | 0852000000     | Telkomsel |
      | 0853000000     | Telkomsel |
      | 0851000000     | Telkomsel |
      | 0812000000     | Telkomsel |
      | 0813000000     | Telkomsel |
      | 0821000000     | Telkomsel |
      | 0822000000     | Telkomsel |
      | 0823000000     | Telkomsel |
      | 0852000000     | Telkomsel |
      | 0853000000     | Telkomsel |
      | 0851000000     | Telkomsel |
      | 0898000000     | Tri       |
      | 0899000000     | Tri       |
      | 0895000000     | Tri       |
      | 0896000000     | Tri       |
      | 0897000000     | Tri       |
      | 0895333333333  | Tri       |
      | 0896333333333  | Tri       |
      | 0897333333333  | Tri       |
      | 0898333333333  | Tri       |
      | 0899333333333  | Tri       |
      | 0815000000     | Indosat   |
      | 0816000000     | Indosat   |
      | 0855000000     | Indosat   |
      | 0856000000     | Indosat   |
      | 0857000000     | Indosat   |
      | 0858000000     | Indosat   |
      | 0815333333333  | Indosat   |
      | 0816333333333  | Indosat   |
      | 0855333333333  | Indosat   |
      | 0856333333333  | Indosat   |
      | 0857333333333  | Indosat   |
      | 0858333333333  | Indosat   |
      | 08820000000    | Smartfren |
      | 08830000000    | Smartfren |
      | 08840000000    | Smartfren |
      | 08850000000    | Smartfren |
      | 08860000000    | Smartfren |
      | 08870000000    | Smartfren |
      | 08880000000    | Smartfren |
      | 08890000000    | Smartfren |
      | 08823333333333 | Smartfren |
      | 08833333333333 | Smartfren |
      | 08843333333333 | Smartfren |
      | 08853333333333 | Smartfren |
      | 08863333333333 | Smartfren |
      | 08873333333333 | Smartfren |
      | 08883333333333 | Smartfren |
      | 08893333333333 | Smartfren |
      | 0833000000     | Axis      |
      | 0838000000     | Axis      |
      | 0831000000     | Axis      |
      | 0859100000     | Axis      |
      | 0859800000     | Axis      |
      | 0833333333333  | Axis      |
      | 0838333333333  | Axis      |
      | 0831333333333  | Axis      |
      | 0859133333333  | Axis      |
      | 0859833333333  | Axis      |