@Android
Feature: Payment
  Scenario: Complete payment by Promotion Banner
    Given User at main page
    When User click Promotion Banner
    Then User click Buy Pulsa Now
    And User input phone number
    And User choose top up nominal
    And User see payment detail page
    And User pay the bill
    Then User see payment success page
    And User click Pay Now
    Then User see Payment Success Page