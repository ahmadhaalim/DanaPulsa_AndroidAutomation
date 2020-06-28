@Android @Voucher

Feature: Voucher Feature Functionality Check

#[Warning] Please use a new fresh account, which no transaction has been made before!!!

  Background:
    Given User directed to "sign in" screen
    #Change the phone number according your data table
    When User input phone number "081213130000"
    And User tap sign in button while internet is "on"
    Then User directed to "input pin" screen
    When User input pin "123456" while internet is "on"
    Then User directed to "home" screen

  #[WARNING] Run this scenario first before other scenarios!!!
  @VOSC001 @VOSC010-VOSC012
  Scenario Outline: User doesn't have any voucher
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    When User tap "<button>" button on voucher screen while internet is "on"
    Then User see "You have no voucher" message on voucher screen
    Examples:
      | button   |
      | All      |
      | Discount |
      | Cashback |

  @VOSC003 @VOSC004
  Scenario Outline: Go to Discount / Cashback Voucher List screen by tapping filter button
    When User tap "voucher" menu button while internet is "on"
    When User tap "<button>" button on voucher screen while internet is "on"
    Then User see "<voucher>" banner list
    Examples:
      | button   | voucher          |
      #[WARNING] Please make completed transaction first to get Discount Voucher!!!
      | Discount | Voucher Discount |
      #[WARNING] Please make completed transaction first to get Cashback Voucher!!!
      | Cashback | Voucher Cashback |
      | All      | Voucher Discount |
      | All      | Voucher Cashback |

  @VOSC002 @VOSC005 @VOSC006
  Scenario Outline: Go to voucher detail screen and click back button
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    When User tap "<button>" button on voucher screen while internet is "on"
    And User tap voucher banner "<voucher>" while internet is "on"
    Then User is on "voucher detail" screen
    When User perform action "tap back button"
    Then User is on "voucher" screen
    Examples:
      | button   | voucher                                  |
       #Change this to the voucher you have
      | Discount | Diskon 5% (max Rp 5.000) buat beli pulsa |
      | Cashback | Cashback Rp 3.500 buat beli pulsa        |

  @VOSC007 @VOSC008
  Scenario Outline: Perform action on voucher screen
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    When User perform action "<action>"
    Then User directed to "<screen>" screen
    Examples:
      | action                             | screen |
      # [@VOSC007] Proceed to home screen by tapping device back button
      | tap device back button             | home   |
      # [@VOSC008] Back to home screen by opening the app after running in the background for a moment
      | reopen app after in the background | home   |

  @VOSC009
  Scenario: Still on voucher screen when unlocking device
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    When User perform action "unlock the device after being unlocked"
    Then User is on "voucher" screen

  @VOSC013 @VOSC015
  Scenario Outline: Perform action on voucher detail screen
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    And User tap voucher banner "Diskon 5% (max Rp 5.000) buat beli pulsa" while internet is "on"
    Then User is on "voucher detail" screen
    When User perform action "<action>"
    Then User is on "<screen>" screen
    Examples:
      | action                                 | screen         |
      # [@VOSC013] Back to voucher screen by tapping device back button while in voucher detail screen
      | tap device back button                 | voucher        |
      # [@VOSC015] Still on voucher detail screen when unlocking device
      #| unlock the device after being unlocked | voucher detail |

  @VOSC014
  Scenario: Back to home screen from voucher detail screen by opening the app
  after running in the background for a moment
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    And User tap voucher banner "Diskon 5% (max Rp 5.000) buat beli pulsa" while internet is "on"
    Then User is on "voucher detail" screen
    When User perform action "reopen app after in the background"
    Then User is on "home" screen

  @VOSC016
  Scenario: Reload voucher screen by press down and release
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    #Change the point according to testing device screen resolution
    When User perform action "hold down and release"
    Then User is on "voucher" screen

  @VOSC023 @VOSC024 @VOSC025
  Scenario Outline: Voucher doesn't show up because internet connection isn't available
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    When User tap "voucher" menu button while internet is "off"
    When User tap "<button>" button on voucher screen while internet is "on"
    Then User see warning "Error getting your voucher" on voucher screen
    Examples:
      | button   |
      | All      |
      | Discount |
      | Cashback |

  @VOSC025
  Scenario: Voucher Detail doesn't show up because internet connection isn't available
    When User tap "voucher" menu button while internet is "on"
    Then User is on "voucher" screen
    When User tap voucher banner "Diskon 5% (max Rp 5.000) buat beli pulsa" while internet is "off"
    Then User see warning "Connection Error" on voucher detail screen