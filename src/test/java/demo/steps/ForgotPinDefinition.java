package demo.steps;

import demo.pages.loginHalim.LoginPage;
import demo.pages.mainPageHalim.MainPage;
import demo.pages.loginHalim.PinPage;
import demo.pages.mainPageHalim.ProfilePage;
import demo.pages.api.otp.OtpController;
import demo.pages.device.DeviceButton;
import demo.pages.displayerror.DisplayErrorPage;
import demo.pages.forgotchangepin.ConfirmPinPage;
import demo.pages.forgotchangepin.NewPinPage;
import demo.pages.forgotchangepin.OtpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class ForgotPinDefinition {
    String phonenumber;
    String newPin;
    String otp;
    LoginPage loginPage = new LoginPage();//dummy
    PinPage pinPage = new PinPage();//dummy
    OtpPage otpPage = new OtpPage();
    OtpController otpController = new OtpController();
    NewPinPage newPinPage = new NewPinPage();
    ConfirmPinPage confirmPinPage = new ConfirmPinPage();
    MainPage mainPage = new MainPage();
    ProfilePage profilePage = new ProfilePage();
    DisplayErrorPage displayErrorPage = new DisplayErrorPage();
    DeviceButton deviceButton = new DeviceButton();

    //DUMMY
    @Given("User in the sign in page")
    public void userInTheSignInPage() {
        loginPage.isOnPage();
    }

    //DUMMY
    @When("User input registered phone number {string}")
    public void userInputRegisteredPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
        loginPage.inputNomor(this.phonenumber);
    }

    //DUMMY
    @And("User click the sign in button")
    public void userClickTheSignInButton() {
        loginPage.clickSignIn();
    }

    //DUMMY
    @And("User click the forgot pin text")
    public void userClickTheForgotPinText() {
        pinPage.clickForgot();
    }


    @And("User input valid otp number with user id {string}")
    public void userInputValidOtpNumber(String userId) {

        Response response = otpController.getOtpNumber(userId);
        String otp = response.path("code").toString();

        otpPage.inputOTP(otp);
    }

    @And("User click next button on the otp page")
    public void userClickNextButtonOnTheOtpPage() throws InterruptedException {
        otpPage.clickNextOtp();
        Thread.sleep(5000);
    }

    @And("User input new PIN {string}")
    public void userInputNewPIN(String pin) {
        newPinPage.inputNewPin(pin);
        this.newPin = pin;
    }

    @And("User click next button on the new pin page")
    public void userClickNextButtonOnTheNewPinPage() {
        newPinPage.clickNext();
    }

    @And("User input the new pin on confirmation page")
    public void userInputTheNewPinOnConfirmationPage() {
        confirmPinPage.inputConfirmPin(this.newPin);
    }

    @And("User click finish button on the confirmation page")
    public void userClickFinishButtonOnTheConfirmationPage() {
        confirmPinPage.clickFinish();
    }

    @And("User input new pin number on the pin page")
    public void userInputNewPinNumberOnThePage() {
        pinPage.inputPin(this.newPin);
    }

    @And("User is in the main page")
    public void userIsInTheMainPage() {
        Assert.assertTrue(mainPage.isOnPage());

    }

    @And("User click the profile menu on the bottom bar")
    public void userClickTheProfileMenuOnTheBottomBar() throws InterruptedException {
        mainPage.clickProfileMenu();
    }

    @And("User click the sign out menu")
    public void userClickTheSignOutMenu() {
        profilePage.clickSignOutMenu();
    }

    @Then("User is back at the sign in page")
    public void userIsBackAtTheSignInPage() {
        Assert.assertTrue(loginPage.isOnPageBool());
    }

    @And("User wait for the otp to expire in three minutes.")
    public void userWaitForTheOtpToExpireInThreeMinutes() {
        otpPage.waitForResend();
    }

    @And("User Click resend OTP")
    public void userClickResendOTP() {
        otpPage.clickResendOtp();
    }

    @And("User input invalid otp number {string}")
    public void userInputInvalidOtpNumber(String otp) {
        otpPage.inputOTP(otp);
    }

    @Then("User see display error {string}")
    public void userSeeDisplayError(String errorMessage) {
        Assert.assertTrue(displayErrorPage.isDisplayed());
        Assert.assertEquals(errorMessage, displayErrorPage.getErrorText());
    }

    @Then("User cannot click next the button is disabled")
    public void userCannotClickNextTheButtonIsDisabled() {
        Assert.assertFalse(otpPage.checkIfNextEnabled());
    }

    @And("User input two digits otp number with user id {string}")
    public void userInputTwoDigitsOtpNumberWithUserId(String userId) throws InterruptedException {
        Response response = otpController.getOtpNumber(userId);
        String otp = response.path("code").toString();
        String twodigit = otp.substring(0, 3);
        otpPage.inputOTP(twodigit);
    }

    @And("User get otp number with user id {string}")
    public void userGetOtpNumber(String userId) throws InterruptedException {
        Response response = otpController.getOtpNumber(userId);
        this.otp = response.path("code").toString();
    }

    @And("User input the old otp")
    public void userInputTheOldOtp() {
        otpPage.inputOTP(this.otp);
    }

    @Then("User see warning message {string}")
    public void userSeeWarningMessage(String warning) {
        Assert.assertEquals(warning, newPinPage.getWarningMessage());
    }

    @And("User input incorrect pin on the confirmation page {string}")
    public void userInputIncorrectPinOnTheConfirmationPage(String incorrectpin) {
        confirmPinPage.inputConfirmPin(incorrectpin);
    }

    @Then("User see warning message on the confirmation page {string}")
    public void userSeeWarningMessageOnTheConfirmationPage(String warning) {
        Assert.assertEquals(warning, confirmPinPage.getWarningMessage());
    }

    @And("User input old pin number on the page {string}")
    public void userInputOldPinNumberOnThePage(String oldpin) {
        pinPage.inputPin(oldpin);
    }

    @Then("User see warning message on pin page {string}")
    public void userSeeWarningMessageOnPinPage(String error) {
        Assert.assertEquals(error, pinPage.getWarningMessage());
    }

    @Then("User is in the new pin page")
    public void userIsInTheNewPinPage() {
        Assert.assertTrue(newPinPage.isOnPage());
    }

    @And("User click the back arrow icon on top bar")
    public void userClickTheBackArrowIconOnTopBarOnOTPPage() {
        confirmPinPage.clickBack();
    }

    @Then("User is in the pin page")
    public void userIsInThePinPage() {
        Assert.assertTrue(pinPage.isOnPage());
    }

    @And("User click device back button")
    public void userClickDeviceBackButton() {
        deviceButton.pressDeviceBack();
    }

    @And("User lock the device")
    public void userLockTheDevice() {
        deviceButton.pressLockDevice();
    }

    @And("User unlock the device")
    public void userUnlockTheDevice() {
        deviceButton.pressUnlockDevice();
    }

    @Then("User is in otp page")
    public void userIsInOtpPage() {
        Assert.assertTrue(otpPage.isOnPage());
    }

    @Then("User cannot click resend the button is disabled")
    public void userCannotClickResendTheButtonIsDisabled() {
        Assert.assertFalse(otpPage.checkIfResendEnabled());
    }

    @And("User turn internet off")
    public void userTurnInternetOff() throws InterruptedException {
        deviceButton.switchInternet();
    }

    @And("User is in the confirmation page")
    public void userIsInTheConfirmationPage() {
        Assert.assertTrue(confirmPinPage.isOnPage());
    }

    @And("User input their pin on the pin page {string}")
    public void userInputTheirPinOnThePinPage(String pin) {
        pinPage.inputPin(pin);
    }

    @And("User click the change pin menu")
    public void userClickTheChangePinMenu() {
        profilePage.clickChangePinMenu();
    }

    @And("User is in the profile page")
    public void userIsInTheProfilePage() {
        Assert.assertTrue(profilePage.isOnPage());
    }

    @Then("User cannot click finish button the button is disabled")
    public void userCannotClickConfirmButtonTheButtonIsDisabled() {
        Assert.assertFalse(confirmPinPage.checkIfConfirmEnabled());
    }

    @And("User click home button and reopen the app")
    public void userClickHomeButton() throws InterruptedException {
        deviceButton.pressHomeButton();
    }


    @And("User input otp via pasting with user id {string}")
    public void userInputOtpViaPasting(String userId) throws InterruptedException {
        Response response = otpController.getOtpNumber(userId);
        String otp = response.path("code").toString();
        //String otp = "1111";
        otpPage.setForPaste(otp);
    }
    @Then("User cant perform paste on the OTP input {string}")
    public void userCantPerformPasteOnTheInput(String devicetype) {
        Assert.assertFalse(otpPage.tryToPaste(devicetype));
    }

    @And("User input new pin via pasting {string}")
    public void userInputNewPinViaPasting(String newpin) {
        newPinPage.setForPaste(newpin);
    }

    @And("User input confirm pin via pasting")
    public void userInputConfirmPinViaPasting() {
        confirmPinPage.setForPaste(this.newPin);
    }

    @Then("User cant perform paste on the confirm input {string}")
    public void userCantPerformPasteOnTheConfirmInput(String deviceType) {
        confirmPinPage.tryToPaste(deviceType);
    }

    @Then("User cant perform paste on the new pin input {string}")
    public void userCantPerformPasteOnTheNewPinInput(String deviceType) {
        newPinPage.tryToPaste(deviceType);
    }

    @And("User turn internet on")
    public void userTurnInternetOn() throws InterruptedException {
        deviceButton.switchInternet();
    }

    @And("User click yes on the dialog box")
    public void userClickYesOnTheDialogBox() {
        displayErrorPage.clickPositive();
    }
}
