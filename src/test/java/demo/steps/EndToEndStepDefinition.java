package demo.steps;

import demo.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EndToEndStepDefinition {

    SignUpFullNamePage signUpFullNamePage = new SignUpFullNamePage();
    SignUpEmailPage signUpEmailPage = new SignUpEmailPage();
    SignUpPhoneNumberPage signUpPhoneNumberPage = new SignUpPhoneNumberPage();
    SignUpCreatePINPage signUpCreatePINPage = new SignUpCreatePINPage();
    SignUpConfirmPINPage signUpConfirmPINPage = new SignUpConfirmPINPage();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    DialogPage dialogPage = new DialogPage();
    MobileRechargePage mobileRechargePage = new MobileRechargePage();
    PaymentPage paymentPage = new PaymentPage();
    PaymentSuccessPage paymentSuccessPage = new PaymentSuccessPage();
    HistoryPage historyPage = new HistoryPage();
    TransactionDetailPage transactionDetailPage = new TransactionDetailPage();
    VoucherPage voucherPage = new VoucherPage();

    @When("User input {string} on {string} page then tap Next button")
    public void userInputOnPageThenTapNextButton(String input, String page) {
        switch (page) {
            case "Full Name":
                signUpFullNamePage.inputFullName(input);
                signUpFullNamePage.tapNextButton();
                break;
            case "Email":
                signUpEmailPage.inputEmail(input);
                signUpEmailPage.tapNextButton();
                break;
            case "Phone Number":
                signUpPhoneNumberPage.inputPhoneNumber(input);
                signUpPhoneNumberPage.tapNextButton();
                break;
            case "Create PIN":
                signUpCreatePINPage.inputPIN(input);
                signUpCreatePINPage.tapNextButton();
                break;
            default: break;
        }
    }

    @When("User input {string} on Confirm PIN page then tap Finish button")
    public void userInputOnConfirmPINPageThenTapFinishButton(String input) {
        signUpConfirmPINPage.inputConfirmPIN(input);
        signUpConfirmPINPage.tapFinishButton();
    }

    @When("User tap {string} icon")
    public void userTapIcon(String icon) {
        switch (icon) {
            case "Home":
                homePage.tapHomeIcon();
                break;
            case "History":
                homePage.tapHistoryIcon();
                break;
            case "Voucher":
                homePage.tapVoucherIcon();
                break;
            case "Profile":
                homePage.tapProfileIcon();
                break;
            default: break;
        }
    }

    @Then("User see {string}, {string}, and {string} as his account information")
    public void userSeeAndAsHisAccountInformation(String fullName, String email, String phoneNumber) throws InterruptedException {
        Assert.assertEquals(fullName, profilePage.getFullNameText());
        Assert.assertEquals(email, profilePage.getEmailText());
        Assert.assertEquals(phoneNumber, profilePage.getPhoneNumberText());
        Thread.sleep(3000);
    }

    @When("User sign out")
    public void userSignOut() {
        profilePage.tapSignOutButton();
        dialogPage.tapOKButton();
    }

    @When("User buy {string} pulsa for {string} at a price of {string}")
    public void userBuyPulsaForAtAPriceOf(String nominal, String rechargedNumber, String price) {
        homePage.tapMobileRechargeIcon();
        mobileRechargePage.inputPhoneNumber(rechargedNumber);
        mobileRechargePage.chooseNominal(nominal, price);
    }

    @When("User pay with the amount of {string}")
    public void userPayWithTheAmountOf(String totalPaid) {
        String actualTotal = paymentPage.totalPaidOnPayButton();
        if (totalPaid.equals(actualTotal)) {
            paymentPage.tapPayButton();
        } else {
            Assert.fail("Actual total paid is " + actualTotal + " not " + totalPaid);
        }
    }

    @Then("User {string} see a dialog box tells that he {string} then back to Home page")
    public void userSeeADialogBoxTellsThatHeGotANewVoucherThenBackToHomePage(String condition, String message) {
        if (condition.equals("do")) {
            if (dialogPage.dialogIsShown()) {
                Assert.assertTrue(dialogPage.getDialogMessage().contains(message));
                dialogPage.tapOKButton();
            }
        }
        Assert.assertEquals("Payment Completed", paymentSuccessPage.getTitle());
        paymentSuccessPage.tapBackToHome();
    }

    @Then("User see his balance decrease by {string}")
    public void userSeeHisBalanceDecreaseBy(String totalPaid) throws InterruptedException {
        int currentBalance = homePage.getCurrentBalance();
        Assert.assertEquals(homePage.previousBalance - Integer.parseInt(totalPaid), currentBalance);
        Thread.sleep(3000);
    }

    @When("User go to History and choose the first transaction on Completed history tab")
    public void userGoToHistoryAndChooseTheFirstTransactionOnCompletedHistoryTab() {
        homePage.tapHistoryIcon();
        historyPage.tapCompletedTab();
        historyPage.tapFirstTransaction();
    }

    @Then("User see a {string} pulsa transaction with nominal top up {string} for {string} at a price of {string}")
    public void userSeeAPulsaTransactionWithNominalTopUpForAtAPriceOf(String status, String nominal, String rechargedNumber, String totalPaid) throws InterruptedException {
        Assert.assertTrue(transactionDetailPage.getProduct().contains(nominal));
        Assert.assertTrue(transactionDetailPage.getPhoneNumber().contains(rechargedNumber));
        Assert.assertEquals(status, transactionDetailPage.getStatus());
        Assert.assertEquals(totalPaid, transactionDetailPage.getTotalPaid());
        Thread.sleep(5000);
    }

    @Then("User see there is a new voucher which is {string} for buying pulsa")
    public void userSeeThereIsANewVoucherWhichIsForBuyingPulsa(String voucherValue) throws InterruptedException {
        Assert.assertTrue(voucherPage.voucherFound(voucherValue));
        Thread.sleep(3000);
    }

    @When("User choose to not using a voucher")
    public void userChooseToNotUsingAVoucher() {
        paymentPage.tapChangeVoucherButton();
        paymentPage.tapWithoutVoucherButton();
    }

    @Then("User see there is a {string} voucher applied on Payment page")
    public void userSeeThereIsAVoucherAppliedOnPaymentPage(String voucher) throws InterruptedException {
        Assert.assertTrue(paymentPage.getVoucherTitle().contains(voucher));
        Thread.sleep(3000);
    }

    @Then("User see that the {string} voucher no longer exists")
    public void userSeeThatTheVoucherNoLongerExists(String voucherValue) throws InterruptedException {
        Assert.assertFalse(voucherPage.voucherFound(voucherValue));
        Thread.sleep(3000);
    }

    @When("User tap Back button on Transaction Detail page")
    public void userTapBackButtonOnTransactionDetailPage() {
        transactionDetailPage.tapBackButton();
    }
}
