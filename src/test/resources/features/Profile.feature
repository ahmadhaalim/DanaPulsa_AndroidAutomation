@Android @Profile

Feature: Profile Feature Functionality Check

  Background:
    Given User directed to "sign in" screen
    #Change the phone number according your data table
    When User input phone number "08555333444"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "123456" while internet is "on"
    Then User directed to "home" screen

  @PRSC001 @PRSC002 @PRSC003
  Scenario: Go to change pin screen and tap back button
    When User tap "profile" menu button while internet is "on"
    Then User directed to "profile" screen
    When User tap "change pin" button on profile screen
    Then User directed to change pin screen
    When User perform action "tap back button" while on "change pin" screen
    Then User directed to "profile" screen

  @PRSC004 @PRSC005
  Scenario Outline: Perform action on sign out pop up warning message
    When User tap "profile" menu button while internet is "on"
    Then User directed to "profile" screen
    When User tap "sign out" button on profile screen
    And User tap "<button>" button on profile screen
    Then User directed to "<screen>" screen
    Examples:
      | button | screen  |
      # [@PRSC004] Successfully signed out from the app
      | yes    | sign in |
      # [@PRSC005] Cancel to  sign out from the app
      | no     | profile |

  @PRSC010
  Scenario: User can't sign out because internet problem
    When User tap "profile" menu button while internet is "off"
    Then User directed to "profile" screen
    When User tap "sign out" button on profile screen
    And User tap "yes" button on profile screen
    Then User see toast message "Connection Error"

  @PRSC006 @PRSC007 @PRSC008
  Scenario Outline: Perform outside app action while on profile screen
    When User tap "profile" menu button while internet is "on"
    Then User directed to "profile" screen
    When User perform action "<action>" while on "forgot pin" screen
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen  |
      # [@PRSC006] Proceed to home screen by tapping device back button
      | tap device back button                 | home    |
      # [@PRSC007] Back to profile screen by opening the app after running in the background
      | reopen app after in the background     | home    |
      # [@PRSC008] Still on profile screen when unlocking device
      | unlock the device after being unlocked | profile |

  @PRSC009
  Scenario: Proceed to device home by tapping device back button after signing out from the app
    When User tap "profile" menu button while internet is "on"
    Then User directed to "profile" screen
    When User tap "sign out" button on profile screen
    And User tap "yes" button on profile screen
    Then User directed to "sign in" screen
    When User perform action "tap device back button" while on "sign in" screen
    Then User directed to "device home" screen
