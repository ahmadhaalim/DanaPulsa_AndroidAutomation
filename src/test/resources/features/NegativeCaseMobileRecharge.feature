@Android @NegativeCase
Feature: Mobile Recharge

  Background:
    Given User is on sign in page
    When User input phone number "088245593542"
    And User input pin number "123456"
    Then User is on homepage

  @MRN001
    #ubah dulu di database
  Scenario Outline: Top up any valid provider number without voucher and the balance is not sufficient
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    When User see payment detail page
    Then User cannot pay the bill
    Examples:
      | phoneNumber   | topUp |
      | 0859233333333 | 5.000    |

  @MRN002
  Scenario Outline: Top up any valid provider number with voucher but the balance is not sufficient
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User check status voucher availability
    And User pick a voucher
    And User choose voucher value "<chooseVoucher>"
    When User see payment detail page
    Then User cannot pay the bill
    Examples:
      | phoneNumber   | topUp | chooseVoucher |
      | 0859233333333 | 15.000   | Cashback Rp 1.000   |

  @MRN003
  Scenario: Input invalid provider
    When User click mobile recharge icon
    And User input "07986532124"
    Then User see invalid format message

  @MRN004
  Scenario: Input mobile phone number but in incorrect format (starting with +62)
    When User click mobile recharge icon
    And User input "+628123456789"
    Then User see invalid format message

  @MRN005
  Scenario Outline: Input mobile phone number but in incorrect format (9 digit)
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see invalid format message
    Examples:
      | phoneNumber   | topUp |
      | 085912345 | 5.000    |

  @MRN006
  Scenario: Input mobile phone number but in incorrect format (did not start with 0)
    When User click mobile recharge icon
    And User input "812345678910"
    Then User see invalid phone number message
