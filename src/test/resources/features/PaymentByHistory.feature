@Android @History
Feature: Mobile Recharge

  Background:
#    Given User is already login
  @MR026,MR027
  Scenario Outline: Top up (13 digit phone number)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see payment detail page
    When User click back button at payment detail page
    And User click yes button on pop up dialog
    Then User directed to home screen
    When User click history button
    Then User click in progress tab
    And User click in progress payment
    Then User see payment detail page
    And User pay the bill
    And User see payment success page
    And  User see payment status "<statusPayment>"
    And User click back to home button
    Then User is on homepage
    Examples:
      | phoneNumber    | topUp | statusPayment |
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
      | 0895333333333  | 5k    | success       |
      | 0896333333333  | 5k    | success       |
      | 0897333333333  | 5k    | success       |
      | 0898333333333  | 5k    | success       |
      | 0899333333333  | 5k    | success       |
      | 0815333333333  | 5k    | success       |
      | 0816333333333  | 5k    | success       |
      | 0855333333333  | 5k    | success       |
      | 0856333333333  | 5k    | success       |
      | 0857333333333  | 5k    | success       |
      | 0858333333333  | 5k    | success       |
      | 08823333333333 | 5k    | success       |
      | 08833333333333 | 5k    | success       |
      | 08843333333333 | 5k    | success       |
      | 08853333333333 | 5k    | success       |
      | 08863333333333 | 5k    | success       |
      | 08873333333333 | 5k    | success       |
      | 08883333333333 | 5k    | success       |
      | 08893333333333 | 5k    | success       |
      | 0833333333333  | 5k    | success       |
      | 0838333333333  | 5k    | success       |
      | 0831333333333  | 5k    | success       |
      | 0859133333333  | 5k    | success       |
      | 0859833333333  | 5k    | success       |