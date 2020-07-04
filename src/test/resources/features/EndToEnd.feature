@Android @EndToEnd

Feature: Dana Pulsa end to end functionality check

  Background:
    Given User directed to "sign in" screen

    Scenario: User signed in and buy pulsa to get a voucher then sign out
      #Sign Up
      When User tap sign up button
      Then User directed to sign up screen
      When User input "Novrizen" on "Full Name" screen
      And User tap Next button
      And User input "nzen8@gmail.com" on "Email" screen
      And User tap Next button
      And User input "08121314008" on "Phone Number" screen
      And User tap Next button
      And User input "123456" on "Create PIN" screen
      And User tap Next button
      And User input "123456" on "Confirm PIN" screen
      And User tap Finish button
      Then User directed to "home" screen
      #Sign Out
      When User tap "profile" menu button while internet is "on"
      Then User directed to "profile" screen
      When User tap "sign out" button on profile screen
      And User tap "yes" button on profile screen
      Then User directed to "sign in" screen
      #Sign In
      When User input phone number "08121314008"
      And User tap sign in button while internet is "on"
      Then User directed to "input pin" screen
      When User input pin "123456" while internet is "on"
      Then User directed to "home" screen
      #Buy Pulsa and get voucher then check balance
      When User tap "Mobile Recharge Icon" on home screen while internet is "on"
      Then User is directed to "mobile recharge" screen
      When User input phone number "081271465456" on mobile recharge screen
      And User choose pulsa "15.000" with price "Rp15.000"
      Then User directed to lets pay screen and see total payment
      When User tap pay button
      When User tap ok button on warning dialog box
      Then User directed to success payment screen
      And User tap back to home button
      Then User directed to "home" screen
      And User see DANA balance "Rp14.985.000"
      #Check transaction history
      When User tap "history" menu button while internet is "on"
      And User tap "completed" tab while internet is "on"
      And User tap "completed" transaction with price "Rp15.000" while internet is "on"
      Then User will directed to "transaction detail" screen
      And User see transaction detail
      #Check issued voucher
      When User perform action "tap back button"
      And User tap "voucher" menu button while internet is "on"
      Then User see voucher banner "Cashback Rp 1.500 buat beli pulsa"
      When User tap voucher banner "Cashback Rp 1.500 buat beli pulsa" while internet is "on"
      Then User is on "voucher detail" screen
      #Buy Pulsa and get 2nd Voucher
      When User perform action "tap back button"
      And User tap "home" menu button while internet is "on"
      Then User directed to "home" screen
      When User tap "Mobile Recharge Icon" on home screen while internet is "on"
      Then User is directed to "mobile recharge" screen
      When User input phone number "081271465456" on mobile recharge screen
      And User choose pulsa "15.000" with price "Rp15.000"
      Then User directed to lets pay screen and see total payment
      When User tap change voucher button
      And User tap continue without voucher button
      And User tap pay button
      When User tap ok button on warning dialog box
      Then User directed to success payment screen
      And User tap back to home button
      Then User directed to "home" screen
      #Check issued 2nd voucher
      When User tap "voucher" menu button while internet is "on"
      Then User see voucher banner "Cashback Rp 1.000 buat beli pulsa"
      #Buy Pulsa using most benefit voucher
      And User tap "home" menu button while internet is "on"
      Then User directed to "home" screen
      When User tap "Mobile Recharge Icon" on home screen while internet is "on"
      Then User is directed to "mobile recharge" screen
      When User input phone number "081271465456" on mobile recharge screen
      And User choose pulsa "15.000" with price "Rp15.000"
      Then User directed to lets pay screen and see total payment
      And User see used voucher "Cashback Rp 1.500 buat beli pulsa"
      When User tap pay button
      Then User directed to success payment screen
      When User tap back to home button
      Then User directed to "home" screen
      #Sign Out
      When User tap "profile" menu button while internet is "on"
      Then User directed to "profile" screen
      When User tap "sign out" button on profile screen
      And User tap "yes" button on profile screen
      Then User directed to "sign in" screen