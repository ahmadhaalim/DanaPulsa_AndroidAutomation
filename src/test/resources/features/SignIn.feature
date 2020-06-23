@Android @SignIn

#Tap/Tapping = tap/taping
Feature: Sign In Feature Functionality Check

  Background:
    Given User directed to "sign in" screen

  @SI001
  Scenario: Successfully sign in using registered phone number
    #Change the phone number according your data table
    When User input phone number "08555333444"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "123456" while internet is "on"
    Then User directed to "home" screen
    #When User tap profile button
    #Then User directed to profile screen
    #And User see phone number  "08555333444" used to signing in on profile screen

  @SI002 @SI005
  Scenario Outline: Failed to sign in because internet problem at Sign In screen /
  Using unregistered phone number
    When User input phone number "<phone>"
    And User tap sign in button while internet is "<state>"
    Then User see toast message pop up "<message>" on sign in screen
    Examples:
      | phone        | state | message                |
      # [@SI002] Sign In using registered phone number but internet problem at Sign In screen
      | 08555333444  | off   | Connection Error       |
      # [@SI005] Sign In using unregistered phone number
      | 081223232323 | on    | incorrect phone number |

  @SI003 @SI004
  Scenario Outline: Failed to sign in because invalid PIN /
  Internet problem while on Input PIN Screen
    When User input phone number "<phone>"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "<pin>" while internet is "<state>"
    Then User see warning message pop up "<message>" on input pin screen
    Examples:
      | phone       | pin    | state | message          |
      #[@SI003] Sign In using registered phone number but using invalid PIN
      | 08555333444 | 987654 | on    | incorrect pin    |
      #[@SI004] Sign In using registered phone number but internet problem at Input Pin screen
      | 08555333444 | 123456 | off   | Connection Error |

  @SI006 @SI007 @SI008 @SI009
  Scenario Outline: User failed to sign in because invalid phone number format
    When User input phone number "<phone>"
    Then User see error message text "<errorMessage>" on sign in screen
    And User see sign button disabled
    Examples:
    # [Warning!] Change the registered phone number according your data table
      | phone         | errorMessage              |
      # [@SI006] Registered phone number but invalid format (Start with +62)
      | +628555333444 | Invalid phone number      |
      # [@SI007] Registered phone number but invalid format (Start with 62)
      | 628555333444  | Invalid phone number      |
      # [@SI008] Empty phone number field
      |               | Please input phone number |
      # [@SI009] Invalid phone number format (less than 10, only 9 digits)
      | 081111111     | Invalid phone number      |

  @SI-IPN001 @SI-IPN005 @SI-IPN006
  Scenario Outline: Go to sign up screen by tapping sign up text
  and tap back button / device back button
    When User tap sign up button
    Then User directed to sign up screen
    When User perform action "<action>" while on "sign up" screen
    Then User directed to "sign in" screen
    Examples:
      | action                 |
      # [@SI-IPN001 @SI-IPN005] Go to sign up screen by tapping sign up text and tap back button
      | tap back button        |
      # [@SI-IPN006] Go to sign up screen by tapping sign up text and tap device back button
      | tap device back button |

  @SI-IPN002 @SI-IPN003 @SI-IPN004
  Scenario Outline: Perform action while on sign in screen
    When User perform action "<action>" while on "sign in" screen
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen      |
      # [@SI-IPN003] Proceed to Device Home by tapping device back button
      | tap device home button                 | device home |
      # [@SI-IPN003] Back to sign in Screen by opening the app after running in the background for a moment
      | reopen app after in the background     | sign in     |
      # [@SI-IPN004] Still on sign in Screen when unlocking device
      | unlock the device after being unlocked | sign in     |

  #@SI-IPN007
  #Scenario: Filling phone number field with clipboard data
    #When User copy and paste clipboard data "08555333444" on "Sign In Screen"
    #Then User see input field is not empty on "Input Phone Number at Sign Screen"


  @SI-IP001 @SI-IP002 @SI-IP003 @SI-IP004
  Scenario Outline: Perform action while on input pin screen
    When User input phone number "<phone>"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User perform action "<action>" while on "input pin" screen
    Then User directed to "<screen>" screen
    Examples:
      | phone       | action                                 | screen    |
      # [@SI-IP001] Back to sign in screen by tapping back button while in input pin screen
      | 08555333444 | tap back button                        | sign in   |
      # [@SI-IP002] Back to sign in screen by tapping device back button while in input pin screen
      | 08555333444 | tap device back button                 | sign in   |
      # [@SI-IP003] Back to input pin screen by opening the app after running in the background for a moment
      | 08555333444 | reopen app after in the background     | input pin |
      # [@SI-IP004S] Still on input pin screen when unlocking device
      | 08555333444 | unlock the device after being unlocked | input pin |

  @SI-IP005 @SI-IP006 @SI-IP007
  Scenario Outline: Go to forgot pin screen by tapping forgot pin text
  and tap back button / device back button
    When User input phone number "08555333444"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User tap forgot pin text
    Then User directed to "forgot pin" screen
    When User perform action "<action>" while on "forgot pin" screen
    Then User directed to "input pin" screen
    Examples:
      | action                 |
      # [@SI-IP005 @SI-IP006] Go to forgot pin screen and back to input pin screen by tapping back button
      | tap back button        |
      # [SI-IP007] Go to forgot pin screen and back to input pin screen by tapping device back button
      | tap device back button |

