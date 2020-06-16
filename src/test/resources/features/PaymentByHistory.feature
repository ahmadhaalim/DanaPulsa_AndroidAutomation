@Android
Feature: Payment
  @MR026,MR027
  Scenario: Complete payment by In Progress page
    Given User at main page
    When User click History
    Then User click unfinished payment
    And User see payment detail page
    And User click Pay Now
    Then User see Payment Success Page