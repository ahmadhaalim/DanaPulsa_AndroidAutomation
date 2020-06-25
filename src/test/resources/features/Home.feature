@Android @Home

Feature: Home Feature Functionality Check

  Background:
    Given User directed to "sign in" screen
    #Change the phone number according your data table
    When User input phone number "08555333444"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "123456" while internet is "on"
    Then User directed to "home" screen

  @HOSC001 @HOSC002 @HOSC003 @HOSC005 @HOSC006 @HOSC007
  Scenario Outline: Go to another page from home screen using all clickable element
  and back to home screen using back button
    When User tap "<element>" on home screen while internet is "on"
    Then User directed to "<screen>" screen
    When User perform action "tap back button"
    Then User directed to "home" screen
    Examples:
      | element              | screen           |
      | Mobile Recharge Icon | mobile recharge  |
      | Promotion Banner     | promotion detail |
      | View All Button      | promotion list   |

  @HOSC004
  Scenario: Go to promotion detail screen by tapping one of promotion banner image
  on home screen and click buy pulsa now button
    When User tap "Promotion Banner" on home screen while internet is "on"
    Then User directed to "promotion detail" screen
    When user click buy pulsa now on promotion detail screen
    Then User directed to "mobile recharge" screen

  @HOSC008 @HOSC009
  Scenario: Go to promotion detail screen by tapping one of promotion banner image
  on promotion list screen and click buy puLsa now button
    When User tap "View All Button" on home screen while internet is "on"
    Then User directed to "promotion list" screen
    When User tap promotion banner on promotion list screen while internet is "on"
    Then User directed to "promotion detail" screen
    When user click buy pulsa now on promotion detail screen
    Then User directed to "mobile recharge" screen

  @HOSC010
  Scenario: Back to promotion list screen by tapping back button on promotion detail screen
    When User tap "View All Button" on home screen while internet is "on"
    Then User directed to "promotion list" screen
    When User tap promotion banner on promotion list screen while internet is "on"
    Then User directed to "promotion detail" screen
    When User perform action "tap back button"
    Then User directed to "promotion list" screen

  @HOSC011
  Scenario: Reload home screen by tapping home button
    When User tap "home" menu button while internet is "on"
    Then User directed to "home" screen

  @HOSC012 @HOSC013  @HOSC014
  Scenario Outline: Perform action on home screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen      |
      # [@HOSC012] Proceed to Device Home by tapping device back button
      | tap device back button                 | device home |
      # [@HOSC013] Back to Home screen by opening the app after running in the background for a moment
      | reopen app after in the background     | home        |
      # [@HOSC014] Still on home screen when unlocking device
      | unlock the device after being unlocked | home        |

  @HOSC017 @HOSC018 @HOSC019
  Scenario Outline: Perform action on promotion detail screen
    When User tap "Promotion Banner" on home screen while internet is "on"
    Then User directed to "promotion detail" screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen           |
      # [@HOSC017] ack to home screen by tapping device back button while in promotion detail screen (via home screen)
      | tap device back button                 | home             |
      # [@HOSC018] Back to promotion detail screen by opening the app after running in the background for a moment
      | reopen app after in the background     | promotion detail |
      # [@HOSC019] Still on promotion detail screen when unlocking device
      | unlock the device after being unlocked | promotion detail |

  @HOSC020
  Scenario: Back to promotion list screen by tapping device back button while in promotion detail screen
  (via view all button)
    When User tap "View All Button" on home screen while internet is "on"
    Then User directed to "promotion list" screen
    When User tap "Promotion Banner" on home screen while internet is "on"
    Then User directed to "promotion detail" screen
    When User perform action "tap device back button"
    Then User directed to "promotion list" screen

  @HOSC021 @HOSC022 @HOSC023
  Scenario Outline: Perform action on promotion list screen
    When User tap "View All Button" on home screen while internet is "on"
    Then User directed to "promotion list" screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen         |
      # [@HOSC021] Back to home screen by tapping device back button while in promotion list screen
      | tap device back button                 | home           |
      # [@HOSC022] Back to promotion list screen  by opening the app after running in the background for a moment
      | reopen app after in the background     | promotion list |
      # [@HOSC023] Still on promotion list screen when unlocking device
      | unlock the device after being unlocked | promotion list |

  @HOSC024 @HOSC025 @HOSC026
  Scenario Outline: Back to home screen by tapping device back button while in mobile recharge screen
    When User tap "Mobile Recharge Icon" on home screen while internet is "on"
    Then User directed to "Mobile Recharge" screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                                 | screen          |
      # [@HOSC024] Back to home screen by tapping device back button while in mobile recharge screen
      | tap device back button                 | home            |
      # [@HOSC025] Back to mobile recharge screen  by opening the app after running in the background for a moment
      | reopen app after in the background     | Mobile Recharge |
      # [@HOSC026] Still on mobile recharge screen when unlocking device
      | unlock the device after being unlocked | Mobile Recharge |

  @HOSC027
  Scenario: Reload home screen by press down and release the screen
    When User perform action "hold down and release"
    Then User directed to "home" screen

  @HOSC028 @HOSC029
  Scenario Outline: Reload promotion detail / promotion list screen by press down and release the screen
    When User tap "<element>" on home screen while internet is "on"
    Then User directed to "<screen>" screen
    When User perform action "hold down and release"
    Then User directed to "Promotion Detail" screen
    Examples:
      | element          | screen           |
      # [@HOSC028] Reload promotion detail screen by press down and release the screen
      | Promotion Banner | Promotion Detail |
      # [@HOSC029] Reload promotion list screen by press down and release the screen
      | View All Button  | promotion list   |

  @HOSC030
  Scenario: Promotion banner image doesn't show up on home screen because internet connection isn't available
    When User tap "home" menu button while internet is "off"
    Then User see warning message "Failed to get Promotion Info" on promotion area

  @HOSC031 @HOSC032 @HOSC033
  Scenario: Promotion detail doesn't show up because internet problem
    When User tap "Promotion Banner" on home screen while internet is "off"
    Then User directed to "Promotion Detail" screen
    When User perform action "hold down and release"
    And User see warning message "Failed to get Promotion Info" on promotion detail screen

  @HOSC034 @HOSC035
  Scenario: Promotion list doesn't show up because internet problem
    When User tap "View All Button" on home screen while internet is "off"
    Then User directed to "promotion list" screen
    When User perform action "hold down and release"
    And User see warning message "Failed to get Promotion Info" on promotion list screen

  @HOSC036
  Scenario: Failed to reload home screen by tapping home button
    When User tap "home" menu button while internet is "off"
    Then User see toast message "Balance Load Failed"

  @HOSC037
  Scenario: Failed to reload home screen by press down and release the screen
    When User tap "home" menu button while internet is "off"
    When User perform action "hold down and release"
    Then User see toast message "Balance Load Failed"
