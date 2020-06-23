@Android @NegativeCase
Feature: Mobile Recharge

  Background:
#    Given User is already login

  Scenario Outline: Top up any valid provider number without voucher and the balance is not sufficient
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User check status voucher availability "<statusVoucher>"
    And User pick a voucher
    And User choose voucher value "<chooseVoucher>"
    When User see payment detail page
    Then User cannot pay the bill
    Examples:
      | phoneNumber   | topUp | statusVoucher | chooseVoucher |
      | 0859233333333 | 15K   | available     | cashback 1K   |

  Scenario Outline: Top up any valid provider number with voucher but the balance is not sufficient
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    When User see payment detail page
    Then User cannot pay the bill
    Examples:
      | phoneNumber   | topUp |
      | 0859233333333 | 5k    |

  Scenario: Input invalid provider
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User didn't see provider icon

  Scenario: Input mobile phone number but in incorrect format (starting with +62)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User didn't see provider icon

  Scenario: Input mobile phone number but in incorrect format (9 digit)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see invalid format message

  Scenario: Input mobile phone number but in incorrect format (14 digit)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see invalid format message

  Scenario: Input mobile phone number but in incorrect format (did not start with 0)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User didn't see provider icon
