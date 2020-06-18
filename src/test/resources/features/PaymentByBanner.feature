@Android @Promotion
Feature: Mobile Recharge

  Background:
#    Given User is already login
  @MR028,MR029
  Scenario: Complete payment by Promotion Banner
    Given User is on homepage
    When User click Promotion Banner
    Then User click Buy Pulsa Now
    And User input phone number
    And User choose top up nominal
    And User see payment detail page
    And User pay the bill
    Then User see payment success page