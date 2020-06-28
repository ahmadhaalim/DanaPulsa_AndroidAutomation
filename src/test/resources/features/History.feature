@Android @History

Feature: Home Feature Functionality Check

#[WARNING] Please use a new fresh account, which no transaction has been made before!!!

  Background:
    Given User directed to "sign in" screen
    #Change the phone number according your data table
    When User input phone number "081213130000"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "123456" while internet is "on"
    Then User directed to "home" screen

  #[WARNING] Run this scenario first before other scenarios!
  @HISC001 @HISC010 @HISC011
  Scenario Outline: User doesn't have in progress or completed transaction
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User tap "<tab>" tab while internet is "on"
    Then User see info "<message>" on history screen and internet is "on"
    Examples:
      | tab         | message                                    |
      | In Progress | You have no transaction in progress, yet.  |
      | Completed   | You haven't completed any transaction yet. |

  @HISC002 @HISC005 @HISC006
  Scenario: Go to completed transaction detail screen and click back button
    #[WARNING] Please make completed transaction first!!!
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User tap "Completed" tab while internet is "on"
    And User tap "Completed" transaction with price "Rp6.000" while internet is "on"
    Then User will directed to "transaction detail" screen
    When User perform action "tap back button"
    Then User will directed to "history" screen

  @HISC003 @HISC004
  Scenario: Go to lets pay screen by tapping in progress transaction history
    #[WARNING] Please make pending transaction first!!!
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User tap "in progress" tab while internet is "on"
    And User tap "waiting" transaction with price "Rp6.000" while internet is "on"
    Then User will directed to "lets pay" screen

  @HISC007 @HISC008
  Scenario Outline: Proceed to device home by tapping device back button
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User perform action "<action>"
    Then User is directed to "home" screen
    Examples:
      | action                             |
      # [@HISC007] Proceed to Home Screen tapping device back button
      | tap device back button             |
       # [@HISC008] Back to Home screen by opening the app after running in the background for a moment
      | reopen app after in the background |

  @HISC009
  Scenario: Still on history screen when unlocking the device
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User perform action "unlock the device after being unlocked"
    Then User will directed to "history" screen

  @HISC012 @HISC013 @HISC014
  Scenario Outline: Perform action on transaction detail screen
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User tap "completed" tab while internet is "on"
    And User tap "Completed" transaction with price "Rp6.000" while internet is "on"
    Then User will directed to "transaction detail" screen
    When User perform action "<action>"
    Then User will directed to "<screen>" screen
    Examples:
      | action                                 | screen             |
      | tap device back button                 | history            |
      | reopen app after in the background     | home               |
      | unlock the device after being unlocked | transaction detail |

  @HISC015 @HISC016
  Scenario Outline: Reload History screen by press down and release /
  Perform swiping on History Screen
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User perform action "<action>"
    Then User will directed to "history" screen
    Examples:
      | action                |
      # [@HISC015]
      | hold down and release |
      # [@HISC016]
      | swipe left and right  |

  @HISC020 @HISC021
  Scenario: Failed to load transaction history because internet problem
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User tap "completed" tab while internet is "off"
    Then User see info "Error getting your transaction history" on history screen and internet is "off"

  @HISC022
  Scenario: Completed Transaction detail doesn't show up because internet problem
    When User tap "history" menu button while internet is "on"
    Then User will directed to "history" screen
    When User tap "completed" tab while internet is "on"
    #Do manual scroll until the transaction history you need is found and show in the screen while steps down below is running
    And User tap "completed" transaction with price "Rp6.000" while internet is "off"
    Then User see warning message "Connection Error" on transaction detail screen