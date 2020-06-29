@Android @SignUpE2E
Feature: Sign Up

  Background:
    Given User is on "Sign In" page
    And User tap the Sign Up button on Sign In page
    And User is on "Full Name" page

  # PLEASE USE YOUR OWN DATA TABLE TO RUN THIS SCENARIO
  @SU001-SU014
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
    And User tap YES button on dialog box
    Then User is on "Sign In" page
    Examples:
      | full_name            | email                        | phone_number  | pin    | confirm_pin |
      | Lin                  | linc@yahoo.com               | 08571112201   | 456456 | 456456      |
      | Lincoln Br           | lincolnbr@yahoo.com          | 08571112202   | 456456 | 456456      |
      | John Lincoln Burrows | lincolnburrows@yahoo.com     | 08571112203   | 456456 | 456456      |
      | lincolnburrows       | burrows@yahoo.com            | 08571112204   | 456456 | 456456      |
      | LINCOLNBURROWS       | burrowslinc@yahoo.com        | 08571112205   | 456456 | 456456      |
      | lincolnBurrows       | burrowslc@yahoo.com          | 08571112206   | 456456 | 456456      |
      | Lincoln Burrows      | lincolnbr55@yahoo.com        | 08571112207   | 456456 | 456456      |
      | Lincoln Burrows      | lincoln.burrows@yahoo.com    | 08571112208   | 456456 | 456456      |
      | Lincoln Burrows      | lincoln_burrows@yahoo.com    | 08571112209   | 456456 | 456456      |
      | Lincoln Burrows      | lincoln-burrows@yahoo.com    | 08571112210   | 456456 | 456456      |
      | Lincoln Burrows      | lincolnburrows@my-company.id | 08571112211   | 456456 | 456456      |
      | Lincoln Burrows      | lincolnburrows@run.hood.org  | 08571112212   | 456456 | 456456      |
      | Lincoln Burrows      | lincolnburrows1@yahoo.com    | 0857111220    | 456456 | 456456      |
      | Lincoln Burrows      | lincolnburrows2@yahoo.com    | 0857111220123 | 456456 | 456456      |

  # PLEASE USE YOUR OWN DATA TABLE TO RUN THIS SCENARIO
  @SU015
  Scenario Outline: Sign Up using valid inputs with Full Name that is changed by user after input and proceed a Full Name
    When User input "<full_name>" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User tap Back button on "Email" page
    And User input "<new_full_name>" on "Full Name" page
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
    Then User see "<new_full_name>" as his "Full Name" on Profile page
    And User see "<email>" as his "Email" on Profile page
    And User see "<phone_number>" as his "Phone Number" on Profile page
    When User tap Sign Out button on Profile page
    And User tap YES button on dialog box
    Then User is on "Sign In" page
    Examples:
      | full_name | new_full_name | email                     | phone_number | pin    | confirm_pin |
      | Burrows   | Lincoln       | lincolnburrows4@yahoo.com | 08571112214  | 200500 | 200500      |

  # PLEASE USE YOUR OWN DATA TABLE TO RUN THIS SCENARIO
  @SU016
  Scenario Outline: Sign Up using valid inputs with Email that is changed by user after input and proceed an Email
    When User input "<full_name>" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "<email>" on "Email" page
    And User tap Next button on "Email" page
    And User tap Back button on "Phone Number" page
    And User input "<new_email>" on "Email" page
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
    And User see "<new_email>" as his "Email" on Profile page
    And User see "<phone_number>" as his "Phone Number" on Profile page
    When User tap Sign Out button on Profile page
    And User tap YES button on dialog box
    Then User is on "Sign In" page
    Examples:
      | full_name | email                     | new_email                 | phone_number | pin    | confirm_pin |
      | Lincoln   | lincolnburrows4@yahoo.com | lincolnburrows5@yahoo.com | 08571112215  | 200500 | 200500      |

  # PLEASE USE YOUR OWN DATA TABLE TO RUN THIS SCENARIO
  @SU017
  Scenario Outline: Sign Up using valid inputs with Phone Number that is changed by user after input and proceed a Phone Number
    When User input "<full_name>" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "<email>" on "Email" page
    And User tap Next button on "Email" page
    And User input "<phone_number>" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User tap Back button on "Create PIN" page
    And User input "<new_phone_number>" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "<pin>" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User input "<confirm_pin>" on "Confirm PIN" page
    And User tap Finish button on Confirm PIN page
    Then User is on "Home" page
    When User tap Profile icon
    Then User see "<full_name>" as his "Full Name" on Profile page
    And User see "<email>" as his "Email" on Profile page
    And User see "<new_phone_number>" as his "Phone Number" on Profile page
    When User tap Sign Out button on Profile page
    And User tap YES button on dialog box
    Then User is on "Sign In" page
    Examples:
      | full_name | email                     | phone_number | new_phone_number | pin    | confirm_pin |
      | Lincoln   | lincolnburrows6@yahoo.com | 08571112215  | 08571112216      | 200500 | 200500      |

  # PLEASE USE YOUR OWN DATA TABLE TO RUN THIS SCENARIO
  @SU018
  Scenario Outline: Sign Up using valid inputs with PIN that is changed by user after input and proceed a PIN
    When User input "<full_name>" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "<email>" on "Email" page
    And User tap Next button on "Email" page
    And User input "<phone_number>" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "<pin>" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User tap Back button on "Confirm PIN" page
    And User input "<new_pin>" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User input "<confirm_pin>" on "Confirm PIN" page
    And User tap Finish button on Confirm PIN page
    Then User is on "Home" page
    And User tap Profile icon
    And User tap Sign Out button on Profile page
    And User tap YES button on dialog box
    When User sign in using Phone Number "<phone_number>" and PIN "<new_pin>"
    Then User is on "Home" page
    When User tap Profile icon
    And User tap Sign Out button on Profile page
    And User tap YES button on dialog box
    Then User is on "Sign In" page
    Examples:
      | full_name | email                     | phone_number | pin    | new_pin | confirm_pin |
      | Lincoln   | lincolnburrows7@yahoo.com | 08571112217  | 200500 | 300600  | 300600      |

  # Email michaelschofield@gmail.com and Phone Number 08997775555 already registered
  @SU019-SU021
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

  @SU022-SU029
  Scenario Outline: Sign up using invalid Full Name
    When User input "<full_name>" on "Full Name" page
    Then User cannot proceed because Next button on "Full Name" page is not clickable
    Examples:
      | full_name             |
      |                       |
      | (threeSpaces)         |
      | (space)Z(space)       |
      | Za                    |
      | Zaki123               |
      | 123456                |
      | Zaki!@                |
      | Zaki🙃                |

  @SU030-SU044
  Scenario Outline: Sign up using invalid Email
    When User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "<email>" on "Email" page
    Then User cannot proceed because Next button on "Email" page is not clickable
    Examples:
      | email                      |
      |                            |
      | zakiakhmad                 |
      | zakifaridzan.@gmail.com    |
      | zaki akhmad@gmail.com      |
      | zaki!$#akhmadf20@gmail.com |
      | .zakiakhmad@gmail.com      |
      | zakiakhmadgmail.com        |
      | zakiakhmad@                |
      | zakiakhmad@gmail           |
      | zakiakhmad@.gmail.com      |
      | zakiakhmad@@gmail.com      |
      | zaki..akhmad@gmail.com     |
      | zaki.akhmad@gmail..com     |
      | zakifaridzan@gmail.com.    |
      | zakiakhmad@gmail.c         |

  @SU045-SU054
  Scenario Outline: Sign up using invalid Phone Number
    When User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "<phone_number>" on "Phone Number" page
    Then User cannot proceed because Next button on "Phone Number" page is not clickable
    Examples:
      | phone_number   |
      |                |
      | +628122317663  |
      | 628122317663   |
      | 081223176      |
      | nomortelepon   |
      | A812231766B    |
      | ._,--,_._-.    |
      | 0812231766-.   |
      | -08122317664   |
      | 0812-2317-661  |

  @SU055-SU056
  Scenario Outline: Sign up using less than 6 digit PIN
    When User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081223176630" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "<pin>" on "Create PIN" page
    Then User cannot proceed because Next button on "Create PIN" page is not clickable
    Examples:
      | pin  |
      |      |
      | 6543 |

  @SU057-SU062
  Scenario Outline: Sign up using invalid PIN format
    When User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081223176630" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "<pin>" on "Create PIN" page
    Then User see error message "Must be 6 digits and cannot start with 0"
    Examples:
      | pin    |
      | 065432 |
      | 65*432 |
      | 6#5432 |
      | .65432 |
      | 654-32 |
      | P65A4S |

  @SU063
  Scenario: Sign up using empty Confirmation PIN
    When User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081223176630" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "123456" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User input "" on "Confirm PIN" page
    Then User cannot proceed because Finish button on Confirm PIN page is not clickable
  
  @SU064
  Scenario: Sign up using incorrect Confirmation PIN
    When User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081223176630" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "123456" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And User input "123987" on "Confirm PIN" page
    Then User see error message "PIN doesn't match"

  @SU065
  Scenario: Sign up using valid inputs but the device's internet is off when user want to Finish on Confirm PIN screen
    When User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081120203030" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User input "500505" on "Create PIN" page
    And User tap Next button on "Create PIN" page
    And The device's internet connection is turned "off"
    And User input "500505" on "Confirm PIN" page
    And User tap Finish button on Confirm PIN page
    Then User see error message "Connection Error"
    And The device's internet connection is turned "on"
