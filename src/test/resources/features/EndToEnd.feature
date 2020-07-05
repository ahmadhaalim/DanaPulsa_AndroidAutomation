@Android @EndToEnd
Feature: End-to-End

  Background:
    Given User is on "Sign In" page

  Scenario Outline: End-to-end testing for the main features in DANA Pulsa app
    # Sign up and check user profile
    When User tap the Sign Up button on Sign In page
    And User input "<full_name>" on "Full Name" page then tap Next button
    And User input "<email>" on "Email" page then tap Next button
    And User input "<phone_number>" on "Phone Number" page then tap Next button
    And User input "<pin>" on "Create PIN" page then tap Next button
    And User input "<pin>" on Confirm PIN page then tap Finish button
    Then User is on "Home" page
    When User tap "Profile" icon
    Then User see "<full_name>", "<email>", and "<phone_number>" as his account information
    And User sign out
    # Sign in
    When User sign in using Phone Number "<phone_number>" and PIN "<pin>"
    Then User is on "Home" page
    # First payment with no voucher. Then check the balance, transaction history (detail), and voucher afterwards
    When User buy "<nominal_1>" pulsa for "<phone_number>" at a price of "<price_1>"
    And User pay with the amount of "<price_1>"
    Then User "do" see a dialog box tells that he "got a new voucher" then back to Home page
    And User see his balance decrease by "<price_1>"
    When User go to History and choose the first transaction on Completed history tab
    Then User see a "Completed" pulsa transaction with nominal top up "<nominal_1>" for "<phone_number>" at a price of "<price_1>"
    When User tap Back button on Transaction Detail page
    And User tap "Voucher" icon
    Then User see there is a new voucher which is "<voucher_1>" for buying pulsa
    # Second payment with no voucher. To issue a new voucher, so the user will have 2 vouchers (precondition for third payment)
    When User tap "Home" icon
    And User buy "<nominal_2>" pulsa for "<phone_number>" at a price of "<price_2>"
    And User pay with the amount of "<price_2>"
    Then User "do" see a dialog box tells that he "got a new voucher" then back to Home page
    And User see his balance decrease by "<price_2>"
    When User tap "Voucher" icon
    Then User see there is a new voucher which is "<voucher_2>" for buying pulsa
    # Third payment using a voucher. To check the most valuable voucher recommendation on payment page
    When User tap "Home" icon
    And User buy "<nominal_1>" pulsa for "<phone_number>" at a price of "<price_1>"
    # voucher_1 is the most benefit for user (instead of voucher_2)
    Then User see there is a "<voucher_1>" voucher applied on Payment page
    When User pay with the amount of "<price_3>"
    Then User "don't" see a dialog box tells that he "got a new voucher" then back to Home page
    And User see his balance decrease by "<price_3>"
    When User tap "Voucher" icon
    Then User see that the "<voucher_1>" voucher no longer exists
    When User tap "Profile" icon
    And User sign out
    Then User is on "Sign In" page
    Examples:
    # nominal_1 and price_1 SHOULD BE HIGHER THAN nominal_2 and price_2
    | full_name | email              | phone_number | pin    | nominal_1 | price_1 | voucher_1    | nominal_2 | price_2 | voucher_2   | price_3 |
    | Schofield | schofield6@mail.co | 08122317681  | 123456 | 100.000   | 100000  | Diskon 20%   | 50.000    | 50000   | Diskon 5%   | 80000   |