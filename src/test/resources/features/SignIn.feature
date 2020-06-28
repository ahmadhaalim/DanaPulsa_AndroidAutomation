@Android @SignIn

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
    When User tap "profile" menu button while internet is "on"
    Then User directed to "profile" screen
    And User see phone number  "08555333444" used to signing in on profile screen

  @SI002 @SI005
  Scenario Outline: Failed to sign in because internet problem at Sign In screen /
  Using unregistered phone number
    When User input phone number "<phone>"
    And User tap sign in button while internet is "<state>"
    Then User see warning message pop up "<message>"
    Examples:
      | phone        | state | message                |
      # [@SI002] Failed to sign in because internet problem at Sign In screen
      | 08555333444  | off   | Connection Error       |
      # [@SI005] Failed to sign in because using unregistered phone number
      | 081223232323 | on    | incorrect phone number |

  @SI003 @SI004
  Scenario Outline: Failed to sign in because using invalid PIN /
  Internet problem while on Input PIN Screen
    When User input phone number "<phone>"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "<pin>" while internet is "<state>"
    Then User see warning message pop up "<message>"
    Examples:
      | phone       | pin    | state | message          |
      # [@SI003] Failed to sign in because using invalid PIN
      | 08555333444 | 987654 | on    | incorrect pin    |
      # [@SI004] Failed to sign in because internet problem at Input Pin screen
      | 08555333444 | 123456 | off   | Connection Error |

  @SI006 @SI007 @SI008 @SI009
  Scenario Outline: Failed to sign in because invalid phone number format
    When User input phone number "<phone>"
    Then User see error message text "<errorMessage>" on sign in screen
    And User see sign button disabled
    Examples:
    # [Warning!] Change the registered phone number according your data table
      | phone         | errorMessage              |
      # [@SI006] Failed to sign in because using registered phone number but invalid format (Start with +62)
      | +628555333444 | Invalid phone number      |
      # [@SI007] Failed to sign in because using registered phone number but invalid format (Start with 62)
      | 628555333444  | Invalid phone number      |
      # [@SI008] Failed to sign in because empty phone number field
      |               | Please input phone number |
      # [@SI009] Failed to sign in because using invalid phone number format (less than 10, only 9 digits)
      | 081111111     | Invalid phone number      |

  @SI-IPN001 @SI-IPN005 @SI-IPN006 @SI-IPN007 @SI-IPN008
  Scenario Outline: Perform action while on sign up screen
    When User tap sign up button
    Then User directed to sign up screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen |
      # [@SI-IPN001 @SI-IPN005] Go to sign up screen by tapping sign up text and tap back button
      | tap back button                        | sign in |
      # [@SI-IPN006] Go to sign up screen by tapping sign up text and tap device back button
      | tap device back button                 | sign in |
      # [@SI-IPN007] Back to sign in screen by opening the app after running in the background for a moment
      | reopen app after in the background     | sign in |
      # [@SI-IPN008] Still on sign in screen when unlocking device
      | unlock the device after being unlocked | sign up |

  @SI-IPN002 @SI-IPN003 @SI-IPN004
  Scenario Outline: Perform action while on sign in screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen      |
      # [@SI-IPN002] Proceed to Device Home by tapping device back button
      | tap device home button                 | device home |
      # [@SI-IPN003] Back to sign in screen by opening the app after running in the background for a moment
      | reopen app after in the background     | sign in     |
      # [@SI-IPN004] Still on sign in screen when unlocking device
      | unlock the device after being unlocked | sign in     |

  @SI-IP001 @SI-IP002 @SI-IP003 @SI-IP004
  Scenario Outline: Perform action while on input pin screen
    When User input phone number "08555333444"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen    |
      # [@SI-IP001] Back to sign in screen by tapping back button while in input pin screen
      | tap back button                        | sign in   |
      # [@SI-IP002] Back to sign in screen by tapping device back button while in input pin screen
      | tap device back button                 | sign in   |
      # [@SI-IP003] Back to input pin screen by opening the app after running in the background for a moment
      | reopen app after in the background     | input pin |
      # [@SI-IP004S] Still on input pin screen when unlocking device
      | unlock the device after being unlocked | input pin |

  @SI-IP005 @SI-IP006 @SI-IP007  @SI-IP008 @ @SI-IP009
  Scenario Outline: Perform action while on forgot pin screen
    When User input phone number "08555333444"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User tap forgot pin text
    Then User directed to "forgot pin" screen
    #And User tap ok button on warning dialog box
    And User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen     |
      # [@SI-IP005 @SI-IP006] Go to forgot pin screen and tap back button
      | tap back button                        | input pin  |
      # [SI-IP007] Go to forgot pin screen and tap device back button
      | tap device back button                 | input pin  |
      # [@SI-IP008] Back to forgot pin screen by opening the app after running in the background for a moment
      | reopen app after in the background     | input pin  |
      # [@SI-IP009] Still on forgot pin screen when unlocking device
      | unlock the device after being unlocked | forgot pin |

