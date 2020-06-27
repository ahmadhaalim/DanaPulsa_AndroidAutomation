package demo.steps;

import demo.pages.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.AndroidPageObject;


import java.io.IOException;
import java.net.URISyntaxException;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class SignUpStepDefinition extends AndroidPageObject {

    SignInPage signInPage = new SignInPage();
    SignUpFullNamePage signUpFullNamePage = new SignUpFullNamePage();
    SignUpEmailPage signUpEmailPage = new SignUpEmailPage();
    SignUpPhoneNumberPage signUpPhoneNumberPage = new SignUpPhoneNumberPage();
    SignUpCreatePINPage signUpCreatePINPage = new SignUpCreatePINPage();
    SignUpConfirmPINPage signUpConfirmPINPage = new SignUpConfirmPINPage();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    DialogPage dialogPage = new DialogPage();

    @Given("User is on {string} page")
    public void userIsOnPage(String page) {
        switch (page) {
            case "Sign In":
                boolean signInButtonDisplayed = signInPage.isOnPage();
                Assert.assertTrue(signInButtonDisplayed);
                break;
            case "Home":
                boolean mobRechargeIconDisplayed = homePage.isOnPage();
                Assert.assertTrue(mobRechargeIconDisplayed);
                break;
            case "Full Name":
                boolean textFullNameDisplayed = signUpFullNamePage.isOnPage();
                Assert.assertTrue(textFullNameDisplayed);
                break;
            case "Email":
                boolean textEmailDisplayed = signUpEmailPage.isOnPage();
                Assert.assertTrue(textEmailDisplayed);
                break;
            case "Phone Number":
                boolean textPhoneNumberDisplayed = signUpPhoneNumberPage.isOnPage();
                Assert.assertTrue(textPhoneNumberDisplayed);
                break;
            case "Create PIN":
                boolean textCreatePINDisplayed = signUpCreatePINPage.isOnPage();
                Assert.assertTrue(textCreatePINDisplayed);
                break;
            case "Confirm PIN":
                boolean textConfirmPINDisplayed = signUpConfirmPINPage.isOnPage();
                Assert.assertTrue(textConfirmPINDisplayed);
                break;
            default: break;
        }
    }

    @Given("User tap the Sign Up button on Sign In page")
    public void userTapTheSignUpButtonOnSignInPage() {
        signInPage.tapSignUpButton();
    }

    @When("User input {string} on {string} page")
    public void userInputOnPage(String input, String page) {
        switch (page) {
            case "Full Name":
                if (input.equals("(threeSpaces)")) {
                    signUpFullNamePage.inputFullName("   ");
                } else if (input.equals("(space)Z(space)")) {
                    signUpFullNamePage.inputFullName(" Z ");
                } else {
                    signUpFullNamePage.inputFullName(input);
                }
                break;
            case "Email":
                signUpEmailPage.inputEmail(input);
                break;
            case "Phone Number":
                signUpPhoneNumberPage.inputPhoneNumber(input);
                break;
            case "Create PIN":
                signUpCreatePINPage.inputPIN(input);
                break;
            case "Confirm PIN":
                signUpConfirmPINPage.inputConfirmPIN(input);
                break;
            default: break;
        }
    }

    @When("User tap Next button on {string} page")
    public void userTapNextButtonOnPage(String page) {
        switch (page) {
            case "Full Name":
                signUpFullNamePage.tapNextButton();
                break;
            case "Email":
                signUpEmailPage.tapNextButton();
                break;
            case "Phone Number":
                signUpPhoneNumberPage.tapNextButton();
                break;
            case "Create PIN":
                signUpCreatePINPage.tapNextButton();
                break;
            default: break;
        }
    }

    @When("User tap Finish button on Confirm PIN page")
    public void userTapFinishButtonOnConfirmPINPage() {
        signUpConfirmPINPage.tapFinishButton();
    }

    @When("User tap Profile icon")
    public void userTapProfileIcon() {
        homePage.tapProfileIcon();
    }

    @Then("User see {string} as his {string} on Profile page")
    public void userSeeAsHisOnProfilePage(String userData, String data) {
        switch (data) {
            case "Full Name":
                String actualFullName = profilePage.getFullNameText();
                Assert.assertEquals(userData, actualFullName);
                break;
            case "Email":
                String actualEmail = profilePage.getEmailText();
                Assert.assertEquals(userData, actualEmail);
                break;
            case "Phone Number":
                String actualPhoneNumber = profilePage.getPhoneNumberText();
                Assert.assertEquals(userData, actualPhoneNumber);
                break;
            default: break;
        }
    }

    @When("User tap Sign Out button on Profile page")
    public void userTapSignOutButtonOnProfilePage() {
        profilePage.tapSignOutButton();
    }

    @Then("User see error message {string}")
    public void userSeeErrorMessage(String errorMsg) {
        if (dialogPage.dialogIsShown()) {
            String actualErrorMsg = dialogPage.getErrorMessage();
            Assert.assertEquals(errorMsg, actualErrorMsg);
            dialogPage.tapOKButton();
        } else { Assert.fail("The dialog box didn't show up"); }
    }

    @Then("User cannot proceed because Next button on {string} page is not clickable")
    public void userCannotProceedBecauseNextButtonOnPageIsNotClickable(String page) {
        switch (page) {
            case "Full Name":
                boolean cantProceedName = signUpFullNamePage.nextButtonDisabled();
                Assert.assertTrue(cantProceedName);
                break;
            case "Email":
                boolean cantProceedEmail = signUpEmailPage.nextButtonDisabled();
                Assert.assertTrue(cantProceedEmail);
                break;
            case "Phone Number":
                boolean cantProceedPhone = signUpPhoneNumberPage.nextButtonDisabled();
                Assert.assertTrue(cantProceedPhone);
                break;
            case "Create PIN":
                boolean cantProceedPIN = signUpCreatePINPage.nextButtonDisabled();
                Assert.assertTrue(cantProceedPIN);
                break;
            default: break;
        }
    }

    @Then("User cannot proceed because Finish button on Confirm PIN page is not clickable")
    public void userCannotProceedBecauseFinishButtonOnConfirmPINPageIsNotClickable() {
        boolean cantFinish = signUpConfirmPINPage.finishButtonDisabled();
        Assert.assertTrue(cantFinish);
    }

    @Given("User has copied {string} to the clipboard")
    public void userHasCopiedToTheClipboard(String clipboardData) {
        androidDriver.setClipboardText(clipboardData);
    }

    @When("User press and hold on {string} input field")
    public void userPressAndHoldOnInputField(String field) throws InterruptedException {
        switch (field) {
            case "Full Name":
                signUpFullNamePage.pressAndHoldInputField();
                break;
            case "Email":
                signUpEmailPage.pressAndHoldInputField();
                break;
            case "Phone Number":
                signUpPhoneNumberPage.pressAndHoldInputField();
                break;
            case "Create PIN":
                signUpCreatePINPage.pressAndHoldInputField();
                break;
            case "Confirm PIN":
                signUpConfirmPINPage.pressAndHoldInputField();
                break;
            default: break;
        }
    }

    @When("User paste clipboard data by tapping {string} Paste button")
    public void userPasteClipboardDataToInputFieldByTappingPaste(String androidVersion) throws IOException, URISyntaxException {
        switch (androidVersion) {
            case "Android 10.0":
                tapOnImage("paste-10.0.png");
                break;
            case "Android 8.0":
                tapOnImage("paste-8.0.png");
                break;
            case "Android 6.0":
                tapOnImage("paste-6.0.png");
                break;
            default: break;
        }
    }

    @Then("User see {string} is shown in {string} input field")
    public void userSeeIsShownInInputField(String clipboardData, String field) throws InterruptedException {
        Thread.sleep(2000);
        switch (field) {
            case "Full Name":
                String textInFullNameField = signUpFullNamePage.getFieldText();
                Assert.assertEquals(clipboardData, textInFullNameField);
                break;
            case "Email":
                String textInEmailField = signUpEmailPage.getFieldText();
                Assert.assertEquals(clipboardData, textInEmailField);
                break;
            case "Phone Number":
                String textInPhoneNumberField = signUpPhoneNumberPage.getFieldText();
                Assert.assertEquals(clipboardData, textInPhoneNumberField);
                break;
            default: break;
        }
    }

    @When("User tap Back button on {string} page")
    public void userTapBackButtonOnPage(String page) throws InterruptedException {
        Thread.sleep(1000);
        switch (page) {
            case "Full Name":
                signUpFullNamePage.tapBackButton();
                break;
            case "Email":
                signUpEmailPage.tapBackButton();
                break;
            case "Phone Number":
                signUpPhoneNumberPage.tapBackButton();
                break;
            case "Create PIN":
                signUpCreatePINPage.tapBackButton();
                break;
            case "Confirm PIN":
                signUpConfirmPINPage.tapBackButton();
                break;
            default: break;
        }
    }

    @Then("User see the inputted {string} which is {string} still exists")
    public void userSeeTheInputtedWhichIsStillExists(String field, String inputted) {
        switch (field) {
            case "Full Name":
                String textInFullNameField = signUpFullNamePage.getFieldText();
                Assert.assertEquals(inputted, textInFullNameField);
                break;
            case "Email":
                String textInEmailField = signUpEmailPage.getFieldText();
                Assert.assertEquals(inputted, textInEmailField);
                break;
            case "Phone Number":
                String textInPhoneNumberField = signUpPhoneNumberPage.getFieldText();
                Assert.assertEquals(inputted, textInPhoneNumberField);
                break;
            case "Create PIN":
                String pinInCustomView = signUpCreatePINPage.getCustomViewText();
                Assert.assertEquals(inputted, pinInCustomView);
                break;
            default: break;
        }
    }

    @When("User tap the device's {string} button")
    public void userTapTheDeviceSButton(String deviceButton) throws InterruptedException {
        switch (deviceButton) {
            case "Back":
                Thread.sleep(2000);
                androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
                break;
            case "Home":
                androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
                break;
            case "Overview":
                Thread.sleep(3000);
                androidDriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
                break;
            default: break;
        }
    }

    @When("User tap the app on the device's overview")
    public void userTapTheAppOnTheDeviceSOverview() throws InterruptedException {
        Thread.sleep(1000);
        tapOnCenter();
        Thread.sleep(2000);
    }

    @When("User lock the device")
    public void userLockTheDevice() {
        androidDriver.pressKey(new KeyEvent(AndroidKey.POWER));
    }

    @When("User unlock the device by swiping up the screen")
    public void userUnlockTheDeviceBySwipingUpTheScreen() throws InterruptedException {
        Thread.sleep(5000);
        androidDriver.pressKey(new KeyEvent(AndroidKey.POWER));
        swipeUp();
        Thread.sleep(2000);
    }

    @When("User close the app")
    public void userCloseTheApp() {
        String appPackage = androidDriver.getCurrentPackage();
        androidDriver.terminateApp(appPackage);
    }

    @When("User open the app")
    public void userOpenTheApp() throws InterruptedException {
        Thread.sleep(3000);
        androidDriver.activateApp("id.dana.apprentech.danapulsa.develop");
    }

    @Then("User see warning message {string} on {string} page")
    public void userSeeWarningMessageOnPage(String warningMsg, String page) {
        switch (page) {
            case "Full Name":
                if (signUpFullNamePage.warningIconShown()) {
                    String actualWarningMsg = signUpFullNamePage.getWarningMessage();
                    Assert.assertEquals(warningMsg, actualWarningMsg);
                } else { Assert.fail("Warning icon didn't show up"); }
                break;
            case "Email":
                if (signUpEmailPage.warningIconShown()) {
                    String actualWarningMsg = signUpEmailPage.getWarningMessage();
                    Assert.assertEquals(warningMsg, actualWarningMsg);
                } else { Assert.fail("Warning icon didn't show up"); }
                break;
            case "Phone Number":
                if (signUpPhoneNumberPage.warningIconShown()) {
                    String actualWarningMsg = signUpPhoneNumberPage.getWarningMessage();
                    Assert.assertEquals(warningMsg, actualWarningMsg);
                } else { Assert.fail("Warning icon didn't show up"); }
                break;
            default: break;
        }
    }

    @When("The device's internet connection is turned off")
    public void theDeviceSInternetConnectionIsTurnedOff() throws InterruptedException {
        androidDriver.toggleData();
        androidDriver.toggleWifi();
        Thread.sleep(2000);
    }

    @Then("User see error message {string} because connection issue")
    public void userSeeErrorMessageBecauseConnectionIssue(String errorMsg) throws InterruptedException {
        Thread.sleep(5000);
        if (dialogPage.dialogIsShown()) {
            String actualErrorMsg = dialogPage.getErrorMessage();
            Assert.assertEquals(errorMsg, actualErrorMsg);
        } else { Assert.fail("The dialog box didn't show up"); }
        dialogPage.tapOKButton();
        // Turning on the device's internet connection
        androidDriver.toggleWifi();
        androidDriver.toggleData();
        Thread.sleep(15000);
    }

    @Then("User cannot paste clipboard data because the {string} Paste button is not shown")
    public void userCannotPasteClipboardDataBecauseThePasteButtonIsNotShown(String androidVersion) throws IOException, URISyntaxException {
        switch (androidVersion) {
            case "Android 10.0":
                boolean btnPasteAPI29Shown = checkElementByImage("paste-10.0.png");
                Assert.assertFalse(btnPasteAPI29Shown);
                break;
            case "Android 8.0":
                boolean btnPasteAPI26Shown = checkElementByImage("paste-8.0.png");
                Assert.assertFalse(btnPasteAPI26Shown);
                break;
            case "Android 6.0":
                boolean btnPasteAPI23Shown = checkElementByImage("paste-6.0.png");
                Assert.assertFalse(btnPasteAPI23Shown);
                break;
        }
    }

    @And("User tap YES button on dialog box")
    public void userTapYESButtonOnDialogBox() {
        dialogPage.tapOKButton();
    }

    @Then("User see on {string} field is not {string} because input length can't be more than {int}")
    public void userSeeOnFieldIsNotBecauseCannotInputMoreThan(String field, String input, int boundaryValue) {
        switch (field) {
            case "Full Name":
                String fullNameOnField = signUpFullNamePage.getFieldText();
                int lengthOfCharactersOnField = fullNameOnField.length();
                Assert.assertNotEquals(input.length(), lengthOfCharactersOnField);
                Assert.assertEquals(input.substring(0, boundaryValue), fullNameOnField);
                break;
            case "Phone Number":
                String phoneNumberOnField = signUpPhoneNumberPage.getFieldText();
                int lengthOfDigitsOnField = phoneNumberOnField.length();
                Assert.assertNotEquals(input.length(), lengthOfDigitsOnField);
                Assert.assertEquals(input.substring(0, boundaryValue), phoneNumberOnField);
                break;
        }
    }
}
