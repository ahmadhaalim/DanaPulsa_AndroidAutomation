package demo.steps;

import demo.pages.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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
                signUpFullNamePage.inputFullName(input);
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
        }
    }

    @Then("User maybe cannot proceed because Next button on {string} page is not clickable")
    public void userMaybeCannotProceedBecauseNextButtonOnPageIsNotClickable(String page) {
        switch (page) {
            case "Full Name":
                if (signUpFullNamePage.isOnPage()) {
                    if (signUpFullNamePage.nextButtonDisabled()) {
                        boolean btnNotClickable = signUpFullNamePage.nextButtonDisabled();
                        Assert.assertTrue(btnNotClickable);
                    }
                }
                break;
            case "Email":
                if (signUpEmailPage.isOnPage()) {
                    if (signUpEmailPage.nextButtonDisabled()) {
                        boolean btnNotClickable = signUpEmailPage.nextButtonDisabled();
                        Assert.assertTrue(btnNotClickable);
                    }
                }
                break;
            case "Phone Number":
                if (signUpPhoneNumberPage.isOnPage()) {
                    if (signUpPhoneNumberPage.nextButtonDisabled()) {
                        boolean btnNotClickable = signUpPhoneNumberPage.nextButtonDisabled();
                        Assert.assertTrue(btnNotClickable);
                    }
                }
                break;
            case "Create PIN":
                if (signUpCreatePINPage.isOnPage()) {
                    if (signUpCreatePINPage.nextButtonDisabled()) {
                        boolean btnNotClickable = signUpCreatePINPage.nextButtonDisabled();
                        Assert.assertTrue(btnNotClickable);
                    }
                }
                break;
            default: break;
        }
    }

    @When("The Next button on {string} page is clickable, User tap Next button")
    public void theNextButtonOnPageIsClickableUserTapNextButton(String page) {
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

    @Then("User maybe see warning message {string} on {string} page")
    public void userMaybeSeeWarningMessageOnPage(String warningMsg, String page) throws IOException, URISyntaxException {
        switch (page) {
            case "Create PIN":
                if (signUpCreatePINPage.isOnPage()) {
                    if (signUpCreatePINPage.warningMessageShown()) {
                        Assert.assertEquals(warningMsg, signUpCreatePINPage.getWarningMessage());
                    }
                }
                break;
            case "Confirm PIN":
                if (signUpConfirmPINPage.isOnPage()) {
                    if (signUpConfirmPINPage.warningMessageShown()) {
                        Assert.assertEquals(warningMsg, signUpConfirmPINPage.getWarningMessage());
                    }
                }
                break;
            default: break;
        }
    }

    @When("The warning message on Create PIN page is not shown")
    public void theWarningMessageOnCreatePINIsNotShown() {
    }

    @Then("User maybe cannot proceed because Finish button on Confirm PIN page is not clickable")
    public void userMaybeCannotProceedBecauseFinishButtonOnConfirmPINPageIsNotClickable() {
        if (signUpConfirmPINPage.isOnPage()) {
            if (signUpConfirmPINPage.finishButtonDisabled()) {
                boolean btnNotClickable = signUpConfirmPINPage.finishButtonDisabled();
                Assert.assertTrue(btnNotClickable);
            }
        }
    }

    @When("The Finish button on Confirm PIN page is clickable, User tap Finish button")
    public void theFinishButtonOnConfirmPINPageIsClickableUserTapFinishButton() {
        signUpConfirmPINPage.tapFinishButton();
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
            default: break;
        }
    }

    @When("User paste clipboard data to {string} input field by tapping Paste")
    public void userPasteClipboardDataToInputFieldByTappingPaste(String field) throws InterruptedException {
        switch (field) {
            case "Full Name":
                signUpFullNamePage.tapPaste();
                break;
            case "Email":
                signUpEmailPage.tapPaste();
                break;
            case "Phone Number":
                signUpPhoneNumberPage.tapPaste();
                break;
            default: break;
        }
    }

    @Then("User see {string} is shown in {string} input field")
    public void userSeeIsShownInInputField(String clipboardData, String field) {
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
    public void userTapBackButtonOnPage(String page) {
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
                androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
                break;
            case "Home":
                androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
                Thread.sleep(3000);
                break;
            case "Overview":
                androidDriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
                break;
            default: break;
        }
    }

    @When("User tap the app on the device's overview")
    public void userTapTheAppOnTheDeviceSOverview() throws InterruptedException {
        tapOnCenter();
        Thread.sleep(2000);
    }

    @When("User lock the device")
    public void userLockTheDevice() throws InterruptedException {
        androidDriver.pressKey(new KeyEvent(AndroidKey.POWER));
        Thread.sleep(5000);
    }

    @When("User unlock the device by swiping up the screen")
    public void userUnlockTheDeviceBySwipingUpTheScreen() throws InterruptedException {
        androidDriver.pressKey(new KeyEvent(AndroidKey.POWER));
        swipeUp();
        Thread.sleep(2000);
    }

    @When("User close the app")
    public void userCloseTheApp() throws InterruptedException {
        String appPackage = androidDriver.getCurrentPackage();
        androidDriver.terminateApp(appPackage);
        Thread.sleep(3000);
    }

    @When("User open the app")
    public void userOpenTheApp() {
        String appPackage = androidDriver.getCurrentPackage();
        androidDriver.activateApp(appPackage);
    }

    @Then("User see warning message {string} on {string} page")
    public void userSeeWarningMessageOnPage(String warningMsg, String page) throws IOException, URISyntaxException {
        switch (page) {
            case "Full Name":
                if (signUpFullNamePage.warningMessageShown()) {
                    Assert.assertEquals(warningMsg, signUpFullNamePage.getWarningMessage());
                }
                break;
            case "Email":
                if (signUpEmailPage.warningMessageShown()) {
                    Assert.assertEquals(warningMsg, signUpEmailPage.getWarningMessage());
                }
                break;
            case "Phone Number":
                if (signUpPhoneNumberPage.warningMessageShown()) {
                    Assert.assertEquals(warningMsg, signUpPhoneNumberPage.getWarningMessage());
                }
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
        }
        androidDriver.toggleWifi();
        androidDriver.toggleData();
    }
}
