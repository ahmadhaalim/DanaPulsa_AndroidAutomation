@Android @SignUpE2E
Feature: Sign Up

  Background:
    Given User is on "Sign In" page
    And User tap the Sign Up button on Sign In page
    And User is on "Full Name" page

  # PLEASE USER YOUR OWN DATA TABLE FOR THIS SCENARIO
  @Valid
  Scenario Outline: Sign up using valid inputs
    When User input "<full_name>" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "<email>" on "Email" page
    And User tap Next button on "Email" page
    And User input "<phone_number>" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "<pin>" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User input "<confirm_pin>" on "Confirm PIN" page
    And User tap Finish button on Confirm PIN page
    Then User is on "Home" page
    When User tap Profile icon
    Then User see "<full_name>" as his "Full Name" on Profile page
    And User see "<email>" as his "Email" on Profile page
    And User see "<phone_number>" as his "Phone Number" on Profile page
    When User tap Sign Out button on Profile page
    Then User is on "Sign In" page
    Examples:
      | full_name            | email                         | phone_number  | pin    | confirm_pin |
      | Zak                  | zakifaridzan@gmail.com        | 081223176610  | 654321 | 654321      |
      | Zaki Ahmad           | zakiakhmadfaridzaa@gmail.com  | 081223176611  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zakiakhmadfaridznn@gmail.com  | 081223176612  | 654321 | 654321      |
      | zakiakhmadfaridzan   | zakiakhmadfaridzzz@gmail.com  | 081223176613  | 654321 | 654321      |
      | ZAKIAKHMADFARIDZAN   | zakiakhmadfaridzzn@gmail.com  | 081223176614  | 654321 | 654321      |
      | zakiAkhmadFaridzan   | zakiakhmadfaridzna@gmail.com  | 081223176615  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zakiakhmadf25@gmail.com       | 081223176616  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zaki.akhmadf@gmail.com        | 081223176618  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zaki_akhmadf@gmail.com        | 081223176619  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zaki-akhmadf@gmail.com        | 081223176620  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | endeavour@my-company.id       | 081223176622  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | falconheavy@mars.space.org    | 081223176623  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zakiakhmadfaridzan1@gmail.com | 0812234565    | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zakiakhmadfaridzan2@gmail.com | 0812234565888 | 654321 | 654321      |

  # Email michaelschofield@gmail.com and Phone Number 08997775555 already registered
  @Registered
  Scenario Outline: Sign up using registered email and/or phone number
    When User input "<full_name>" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "<email>" on "Email" page
    And User tap Next button on "Email" page
    And User input "<phone_number>" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "<pin>" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User input "<confirm_pin>" on "Confirm PIN" page
    And User tap Finish button on Confirm PIN page
    Then User see error message "Email or phone number already exist"
    Examples:
      | full_name            | email                         | phone_number | pin    | confirm_pin |
      | Zaki Akhmad Faridzan | michaelschofield@gmail.com    | 081223176621 | 654321 | 654321      |
      | Zaki Akhmad Faridzan | zakiakhmadfaridzan3@gmail.com | 08997775555  | 654321 | 654321      |
      | Zaki Akhmad Faridzan | michaelschofield@gmail.com    | 08997775555  | 654321 | 654321      |

  @Invalid
  Scenario Outline: Sign up using invalid inputs
    When User input "<full_name>" on "Full Name" page
    Then User maybe cannot proceed because Next button on "Full Name" page is not clickable
    When The Next button on "Full Name" page is clickable, User tap Next button
    And User input "<email>" on "Email" page
    Then User maybe cannot proceed because Next button on "Email" page is not clickable
    When The Next button on "Email" page is clickable, User tap Next button
    And User input "<phone_number>" on "Phone Number" page
    Then User maybe cannot proceed because Next button on "Phone Number" page is not clickable
    When The Next button on "Phone Number" page is clickable, User tap Next button
    And User input "<pin>" on "Create PIN" page
    Then User maybe cannot proceed because Next button on "Create PIN" page is not clickable
    When The Next button on "Create PIN" page is clickable, User tap Next button
    Then User maybe see warning message "PIN format is invalid" on "Create PIN" page
    When The warning message on Create PIN page is not shown
    And User input "<confirm_pin>" on "Confirm PIN" page
    Then User maybe cannot proceed because Finish button on Confirm PIN page is not clickable
    When The Finish button on Confirm PIN page is clickable, User tap Finish button
    Then User maybe see warning message "PIN doesn't match" on "Confirm PIN" page
    Examples:
      | full_name             | email                          | phone_number   | pin    | confirm_pin |
      |                       |                                |                |        |             |
      | Za                    |                                |                |        |             |
      | Zaki Akhmad Faridzann |                                |                |        |             |
      | Zaki123               |                                |                |        |             |
      | 123456                |                                |                |        |             |
      | Zaki!@                |                                |                |        |             |
      | Zaki🙃                |                                |                |        |             |
      | Zaki Akhmad Faridzan  |                                |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmad                     |                |        |             |
      | Zaki Akhmad Faridzan  | zakifaridzan.@gmail.com        |                |        |             |
      | Zaki Akhmad Faridzan  | zaki akhmad@gmail.com          |                |        |             |
      | Zaki Akhmad Faridzan  | zaki!$#akhmadf20@gmail.com     |                |        |             |
      | Zaki Akhmad Faridzan  | .zakiakhmad@gmail.com          |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadgmail.com            |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmad@                    |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmad@gmail               |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmad@.gmail.com          |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmad@@gmail.com          |                |        |             |
      | Zaki Akhmad Faridzan  | zaki..akhmad@gmail.com         |                |        |             |
      | Zaki Akhmad Faridzan  | zaki.akhmad@gmail..com         |                |        |             |
      | Zaki Akhmad Faridzan  | zakifaridzan@gmail.com.        |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmad@gmail.c             |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com |                |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | +628122317663  |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 628122317663   |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176      |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 08122317661700 |        |             |
#      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | nomortelepon   |        |             |
#      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | A812231766B    |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | ._,--,_._-.    |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 0812231766-.   |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | -08122317664   |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 0812-2317-661  |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   |        |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | 6543   |             |
#      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | 65*432 |             |
#      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | 6#5432 |             |
#      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | .65432 |             |
#      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | 654-32 |             |
#      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | P65A4S |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | 123456 |             |
      | Zaki Akhmad Faridzan  | zakiakhmadfaridzan12@gmail.com | 081223176630   | 123456 | 123987      |

