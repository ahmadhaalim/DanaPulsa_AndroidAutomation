@Android @Recharge

Feature: Mobile Recharge

  Background:
    Given User is on sign in page
#    When User input phone number "08555777888"
#    When User input phone number "0812000000"
    When User input phone number "0877010101"
#    And User input pin number "111111"
    And User input pin number "123456"
    Then User is on homepage
#  Gunakan username dan PIN masing-masing!!

  #passed
  @MR001 @MR006
  Scenario Outline: Checking phone number validity
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User see top up catalog
    Examples:
      | phoneNumber |
      | 0859200000  |
#      | 0812000000  |
#      | 0898000000  |
#      | 0815000000  |
#      | 0882000000  |
#      | 0833000000  |

  #minimum top up to get voucher = 10000 (price)
  #passed
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
#    And if "<statusVoucher>" is "available", user get a voucher
    And User see payment status page
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    And User click profile
    And User click sign out
    Examples:
      | phoneNumber | topUp | statusVoucher | statusPayment |
#      XL
#      | 0859200000  | 5.000 | unavailable   | Completed     |
#      | 0859300000  | 5.000 | unavailable   | Completed     |
#      | 0859400000  | 5.000 | unavailable   | Completed     |
#      | 0859500000  | 5.000 | unavailable   | Completed     |
#      | 0859600000  | 5.000 | unavailable   | Completed     |

#      | 0859700000  | 5.000 | unavailable   | Completed     |
#      | 0859900000  | 5.000 | unavailable   | Completed     |
#      | 0877000000  | 5.000 | unavailable   | Completed     |
#      | 0878000000  | 5.000 | unavailable   | Completed     |

#      | 0817000000  | 5.000 | unavailable   | Completed     |
#      | 0818000000  | 5.000 | unavailable   | Completed     |
#      | 0819000000  | 5.000 | unavailable   | Completed     |
#      | 0859233333333 | 5.000  | unavailable   | Completed     |
#      | 0859333333333 | 5.000  | unavailable   | Completed     |
#      | 0859433333333 | 5.000  | unavailable   | Completed     |
#      | 0859533333333 | 5.000  | unavailable   | Completed     |

#      | 0859633333333 | 5.000  | unavailable   | Completed     |
#      | 0859733333333 | 5.000  | unavailable   | Completed     |
#      | 0859933333333 | 5.000  | unavailable   | Completed     |
#      | 0877333333333 | 5.000  | unavailable   | Completed     |

#      | 0878333333333 | 5.000  | unavailable   | Completed     |
#      | 0817333333333 | 5.000  | unavailable   | Completed     |
#      | 0818333333333 | 5.000  | unavailable   | Completed     |
#      | 0819333333333 | 5.000  | unavailable   | Completed     |
#  Telkomsel
#      | 0812000000  | 15.000 | available     | Completed     |
#      | 0813000000  | 15.000 | available     | Completed     |
#      | 0821000000  | 15.000 | available     | Completed     |
#      | 0822000000  | 15.000 | available     | Completed     |
#      | 0823000000  | 15.000 | available     | Completed     |
#      | 0852000000  | 15.000 | available     | Completed     |
#      | 0853000000  | 15.000 | available     | Completed     |
#      | 0851000000  | 15.000 | available     | Completed     |
#      | 0812000000  | 15.000 | available     | Completed     |

#      | 0813000000  | 15.000 | available     | Completed     |
#      | 0821000000  | 15.000 | available     | Completed     |
#      | 0822000000  | 15.000 | available     | Completed     |
#      | 0823000000  | 15.000 | available     | Completed     |
#      | 0852000000  | 15.000 | available     | Completed     |
#      | 0853000000  | 15.000 | available     | Completed     |
#      | 0851000000  | 15.000 | available     | Completed     |
#      | 0812000000  | 15.000 | available     | Completed     |
#      | 0813000000  | 15.000 | available     | Completed     |

#      | 0821000000  | 15.000 | available     | Completed     |
#      | 0822000000  | 15.000 | available     | Completed     |
#      | 0823000000  | 15.000 | available     | Completed     |
#      | 0852000000  | 15.000 | available     | Completed     |
#      | 0853000000  | 15.000 | available     | Completed     |
#      | 0851000000  | 15.000 | available     | Completed     |
#  Tri
#      | 0898000000    | 5.000  | unavailable   | Completed     |
#      | 0899000000    | 5.000  | unavailable   | Completed     |
#      | 0895000000    | 5.000  | unavailable   | Completed     |
#      | 0896000000    | 5.000  | unavailable   | Completed     |
#      | 0897000000    | 5.000  | unavailable   | Completed     |

#      | 0895333333333 | 5.000  | unavailable   | Completed     |
#      | 0896333333333 | 5.000  | unavailable   | Completed     |
#      | 0897333333333 | 5.000  | unavailable   | Completed     |
#      | 0898333333333 | 5.000  | unavailable   | Completed     |
#      | 0899333333333 | 5.000  | unavailable   | Completed     |
#  Indosat
#      | 0815000000    | 5.000  | unavailable   | Completed     |
#      | 0816000000    | 5.000  | unavailable   | Completed     |
#      | 0855000000    | 5.000  | unavailable   | Completed     |
#      | 0856000000    | 5.000  | unavailable   | Completed     |
#      | 0857000000    | 5.000  | unavailable   | Completed     |
#      | 0858000000    | 5.000  | unavailable   | Completed     |

#      | 0815333333333 | 5.000  | unavailable   | Completed     |
#      | 0816333333333 | 5.000  | unavailable   | Completed     |
#      | 0855333333333 | 5.000  | unavailable   | Completed     |
#      | 0856333333333 | 5.000  | unavailable   | Completed     |
#      | 0857333333333 | 5.000  | unavailable   | Completed     |
#      | 0858333333333 | 5.000  | unavailable   | Completed     |
#  Smartfren
#      | 08820000000   | 5.000  | unavailable   | Completed     |
#      | 08830000000   | 5.000  | unavailable   | Completed     |
#      | 08840000000   | 5.000  | unavailable   | Completed     |
#      | 08850000000   | 5.000  | unavailable   | Completed     |
#      | 08860000000   | 5.000  | unavailable   | Completed     |
#      | 08870000000   | 5.000  | unavailable   | Completed     |
#      | 08880000000   | 5.000  | unavailable   | Completed     |
#      | 08890000000   | 5.000  | unavailable   | Completed     |

#      | 0882333333333 | 5.000  | unavailable   | Completed     |
#      | 0883333333333 | 5.000  | unavailable   | Completed     |
#      | 0884333333333 | 5.000  | unavailable   | Completed     |
#      | 0885333333333 | 5.000  | unavailable   | Completed     |
#      | 0886333333333 | 5.000  | unavailable   | Completed     |
#      | 0887333333333 | 5.000  | unavailable   | Completed     |
#      | 0888333333333 | 5.000  | unavailable   | Completed     |
#      | 0889333333333 | 5.000  | unavailable   | Completed     |
#  Axis
#      | 0833000000    | 5.000  | unavailable   | Completed     |
#      | 0838000000    | 5.000  | unavailable   | Completed     |
#      | 0831000000    | 5.000  | unavailable   | Completed     |
#      | 0859100000    | 5.000  | unavailable   | Completed     |
#      | 0859800000    | 5.000  | unavailable   | Completed     |

#      | 0833333333333 | 5.000  | unavailable   | Completed     |
#      | 0838333333333 | 5.000  | unavailable   | Completed     |
#      | 0831333333333 | 5.000  | unavailable   | Completed     |
#      | 0859133333333 | 5.000  | unavailable   | Completed     |
#      | 0859833333333 | 5.000  | unavailable   | Completed     |

#  passed
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
    And User see payment status page
    And User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    And User click profile
    And User click sign out
    Examples:
#    choose every voucher
      | phoneNumber  | topUp   | statusVoucher | chooseVoucher | statusPayment |
#      | 081222223333 | 1.000.000 | available     | Diskon 50%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 45%    | Completed     |
      | 081222223333 | 300.000 | available     | Diskon 40%    | Completed     |
      | 081222223333 | 300.000 | available     | Diskon 35%    | Completed     |
      | 081222223333 | 200.000 | available     | Diskon 30%    | Completed     |
      | 081222223333 | 150.000 | available     | Diskon 25%    | Completed     |
#      | 081222223333 | 100.000 | available     | Diskon 20%    | Completed     |
#      | 081222223333 | 75.000  | available     | Diskon 15%    | Completed     |
#      | 081222223333 | 75.000  | available     | Diskon 10%    | Completed     |
#      | 081222223333 | 50.000  | available     | Diskon 5%     | Completed     |
#      | 081222223333 | 500.000   | available     | Cashback Rp 3.500 | Completed     |
#      | 081222223333 | 500.000   | available     | Cashback Rp 3.000 | Completed     |
#      | 081222223333 | 500.000   | available     | Cashback Rp 2.500 | Completed     |
#      | 081222223333 | 500.000   | available     | Cashback Rp 2.000 | Completed     |
#      | 081222223333 | 500.000   | available     | Cashback Rp 1.500 | Completed     |
#      | 081222223333 | 500.000   | available     | Cashback Rp 1.000 | Completed     |
#      check if every provider can choose voucher
#      | 085902222222 | 50.000    | unavailable   | cashback Rp 3.500 | Completed     |
#      | 085902222222 | 50.000    | available     | cashback Rp 3.500 | Completed     |
#      | 089522222222 | 50.000    | unavailable   | cashback Rp 3.500 | Completed     |
#      | 089522222222 | 50.000    | available     | cashback Rp 3.500 | Completed     |
#      | 081422222222 | 50.000    | unavailable   | cashback Rp 3.500 | Completed     |
#      | 081422222222 | 50.000    | available     | cashback Rp 3.500 | Completed     |
#      | 088122222222 | 50.000    | unavailable   | cashback Rp 3.500 | Completed     |
#      | 088122222222 | 50.000    | available     | cashback Rp 3.500 | Completed     |
#      | 083222222222 | 50.000    | unavailable   | cashback Rp 3.500 | Completed     |
#      | 083222222222 | 50.000    | available     | cashback Rp 3.500 | Completed     |
#      check every top up nominal that available
#      | 085902222222 | 5.000     | unavailable   | cashback Rp 3.500 | Completed     |
#      | 085902222222 | 10.000    | available     | diskon 5%         | Completed     |
#      | 085902222222 | 15.000    | available     | diskon 10%        | Completed     |
#      | 085902222222 | 25.000    | available     | diskon 15%        | Completed     |
#      | 085902222222 | 30.000    | available     | no                | Completed     |
#      | 085902222222 | 50.000    | available     | cashback 1.000    | Completed     |
#      | 085902222222 | 100.000   | available     | cashback 1.500    | Completed     |
#      | 081122222222 | 150.000   | available     | cashback 2.000    | Completed     |
#      | 081122222222 | 200.000   | available     | cashback 2.500    | Completed     |
#      | 081122222222 | 300.000   | available     | cashback 3.000    | Completed     |
#      | 081122222222 | 500.000   | available     | cashback 3.500    | Completed     |
#      | 081122222222 | 1.000.000 | available     | diskon 5%         | Completed     |
#      | 081122222222 | 15.000    | available     | diskon 10%        | Completed     |
#      | 081122222222 | 20.000    | available     | diskon 15%        | Completed     |
#      | 081122222222 | 25.000    | available     | diskon 20%        | Completed     |
#      | 081122222222 | 30.000    | available     | no                | Completed     |
#      | 081122222222 | 40.000    | available     | cashback 1.000    | Completed     |
#      | 081122222222 | 50.000    | available     | cashback 1.500    | Completed     |
#      | 081122222222 | 75.000    | available     | cashback 2.000    | Completed     |
#      | 081122222222 | 100.000   | available     | cashback 2.500    | Completed     |
#      | 089522222222 | 150.000   | available     | cashback 3.000    | Completed     |
#      | 089522222222 | 200.000   | available     | cashback 3.500    | Completed     |
#      | 089522222222 | 300.000   | available     | diskon 5%         | Completed     |
#      | 089522222222 | 500.000   | available     | diskon 10%        | Completed     |
#      | 089522222222 | 1.000.000 | available     | diskon 15%        | Completed     |
#      | 089522222222 | 1.000     | unavailable   | diskon 20%        | Completed     |
#      | 089522222222 | 2.000     | unavailable   | diskon 25%        | Completed     |
#      | 089522222222 | 3.000     | unavailable   | no                | Completed     |
#      | 089522222222 | 4.000     | unavailable   | cashback 1.000    | Completed     |
#      | 089522222222 | 5.000     | unavailable   | cashback 1.500    | Completed     |
#      | 089522222222 | 8.000     | unavailable   | cashback 2.000    | Completed     |
#      | 089522222222 | 10.000    | available     | cashback 2.500    | Completed     |
#      | 089522222222 | 15.000    | available     | cashback 3.000    | Completed     |
#      | 089522222222 | 20.000    | available     | cashback 3.500    | Completed     |
#      | 089522222222 | 25.000    | available     | diskon 5%         | Completed     |
#      | 089522222222 | 30.000    | available     | diskon 10%        | Completed     |
#      | 089522222222 | 50.000    | available     | diskon 15%        | Completed     |
#      | 081422222222 | 100.000   | available     | diskon 20%        | Completed     |
#      | 081422222222 | 150.000   | available     | diskon 25%        | Completed     |
#      | 081422222222 | 200.000   | available     | diskon 30%        | Completed     |
#      | 081422222222 | 300.000   | available     | diskon 35%        | Completed     |
#      | 081422222222 | 500.000   | available     | no                | Completed     |
#      | 081422222222 | 5.000     | unavailable   | cashback 1.000    | Completed     |
#      | 081422222222 | 10.000    | available     | cashback 1.500    | Completed     |
#      | 081422222222 | 12.000    | available     | cashback 2.000    | Completed     |
#      | 081422222222 | 20.000    | available     | cashback 2.500    | Completed     |
#      | 081422222222 | 25.000    | available     | cashback 3.000    | Completed     |
#      | 081422222222 | 30.000    | available     | cashback 3.500    | Completed     |
#      | 081422222222 | 50.000    | available     | diskon 5%         | Completed     |
#      | 081422222222 | 60.000    | available     | diskon 10%        | Completed     |
#      | 081422222222 | 80.000    | available     | diskon 15%        | Completed     |
#      | 081422222222 | 100.000   | available     | diskon 20%        | Completed     |
#      | 088122222222 | 150.000   | available     | diskon 25%        | Completed     |
#      | 088122222222 | 200.000   | available     | diskon 30%        | Completed     |
#      | 088122222222 | 250.000   | available     | diskon 35%        | Completed     |
#      | 088122222222 | 500.000   | available     | diskon 40%        | Completed     |
#      | 088122222222 | 1.000.000 | available     | no                | Completed     |
#      | 088122222222 | 5.000     | unavailable   | cashback 1.000    | Completed     |
#      | 088122222222 | 10.000    | available     | cashback 1.500    | Completed     |
#      | 088122222222 | 20.000    | available     | cashback 2.000    | Completed     |
#      | 088122222222 | 50.000    | available     | cashback 2.500    | Completed     |
#      | 088122222222 | 60.000    | available     | cashback 3.000    | Completed     |
#      | 088122222222 | 100.000   | available     | cashback 3.500    | Completed     |
#      | 083222222222 | 150.000   | available     | diskon 5%         | Completed     |
#      | 083222222222 | 200.000   | available     | diskon 10%        | Completed     |
#      | 083222222222 | 250.000   | available     | diskon 15%        | Completed     |
#      | 083222222222 | 300.000   | available     | diskon 20%        | Completed     |
#      | 083222222222 | 500.000   | available     | diskon 25%        | Completed     |
#      | 083222222222 | 5.000     | unavailable   | diskon 30%        | Completed     |
#      | 083222222222 | 10.000    | available     | diskon 35%        | Completed     |
#      | 083222222222 | 25.000    | available     | diskon 40%        | Completed     |
#      | 083222222222 | 50.000    | available     | diskon 45%        | Completed     |

    #passed
  @MR030
  Scenario: Cancel a transaction
    Given User is on homepage
    When User click mobile recharge icon
    And User input "085902222222"
    And User choose "5.000" nominal
    And User see payment detail page
    And User open action menu
    And User cancel transaction
    And User confirm to cancel transaction
    Then User see payment status page
    And User see payment status "Canceled"

    #passed
  @MR035
  Scenario: Top Up Recent Number
    Given User is on homepage
    When User click mobile recharge icon
    And User choose from recent number
    And User choose "5.000" nominal
    Then User see payment detail page

#    passed
  @MR033
  Scenario: Check Balance
    Given User is on homepage
    When User check initial balance
    And User click mobile recharge icon
    And User input "085902222222"
    And User choose "5.000" nominal
    And User see payment detail page
    And User check total payment
    And User pay the bill
    And User see payment status page
    And User click back to home button
    And User is on homepage
    Then User see that balance is reduce

  @MR036
  Scenario: Choose from contact
    Given User is on homepage
    When User click mobile recharge icon
    And User click select from contact button
    And User choose a contact
    And User choose "5.000" nominal
    And User see payment detail page
    And User pay the bill
    Then User see payment status page

  @EndtoEnd
  Scenario: End to End
    Given User is on homepage
    When User check initial balance
    And User click mobile recharge icon
    And User input "0812000000"
    And User choose "10.000" nominal
    And User see payment detail page
    And User check status voucher availability "unavailable"
    And if "unavailable" is "available", user choose no voucher
    And User check total payment
    And User pay the bill
    And if "available" is "available", user get a voucher
    And User see payment status page
    And User see payment status "Completed"
    And User click back to home button
    And User is on homepage
    And User see that balance is reduce


  @Trial-2
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
    Then User see payment status page
    #tambahkan step dapet/ga dapet voucher
    And  User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    And User click profile
    And User click sign out
    Examples:
      | phoneNumber  | topUp   | statusVoucher | chooseVoucher     | statusPayment |
      | 081222223333 | 500.000 | available     | Diskon 45%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 40%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 35%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 30%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 25%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 20%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 15%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 10%        | Completed     |
      | 081222223333 | 500.000 | available     | Diskon 5%         | Completed     |
      | 081222223333 | 500.000 | available     | no                | Completed     |
      | 081222223333 | 500.000 | available     | Cashback Rp 3.500 | Completed     |
      | 081222223333 | 500.000 | available     | Cashback Rp 3.000 | Completed     |
      | 081222223333 | 500.000 | available     | Cashback Rp 2.500 | Completed     |
      | 081222223333 | 500.000 | available     | Cashback Rp 2.000 | Completed     |
      | 081222223333 | 500.000 | available     | Cashback Rp 1.500 | Completed     |
      | 081222223333 | 500.000 | available     | Cashback Rp 1.000 | Completed     |
