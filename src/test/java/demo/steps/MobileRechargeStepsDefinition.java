package demo.steps;

import demo.pages.LetsPayPage;
import demo.pages.MobileRechargePage;
import demo.pages.PaymentSuccesPage;
import demo.pages.PickAvoucherPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MobileRechargeStepsDefinition {

    MobileRechargePage mobileRechargePage = new MobileRechargePage();
    LetsPayPage letsPayPage = new LetsPayPage();
    PaymentSuccesPage paymentSuccesPage = new PaymentSuccesPage();
    PickAvoucherPage pickAvoucherPage = new PickAvoucherPage();

    @Then("User directed to mobile recharge screen")
    public void userDirectedToMobileRechargeScreen() {
        Assert.assertTrue(mobileRechargePage.isOnPage());
    }

    @When("User input phone number {string} on mobile recharge screen")
    public void userInputPhoneNumberOnMobileRechargeScreen(String phoneNumber) {
        mobileRechargePage.inputPhoneNumber(phoneNumber);
    }

    @And("User choose nominal {string}")
    public void userChooseNominal(String nominal) {
        mobileRechargePage.checkPulsaNominal();
        mobileRechargePage.choosePulsaNominal(nominal);
    }

    @Then("User directed to lets pay screen")
    public void userDirectedToLetsPayScreen() {
        Assert.assertTrue(letsPayPage.isOnPage());
    }

    @When("User click back button at lets pay screen")
    public void userClickBackButtonAtLetsPayScreen() {
        letsPayPage.clickBackButton();
    }

    @And("User click yes button on pop up dialog")
    public void userClickYesButtonOnPopUpDialog() {
        letsPayPage.clickYesButton();
    }

    @When("User click pay button")
    public void userClickPayButton() {
        letsPayPage.clickPayButton();
    }

    @Then("User directed to payment success screen")
    public void userDirectedToPaymentSuccessScreen() {
        Assert.assertTrue(paymentSuccesPage.isOnPage());
    }

    @When("User click back to home button")
    public void userClickBackToHomeButton() {
        paymentSuccesPage.clickBackToHomeButton();
    }

    @When("User click yes button on pop up dialog payment success screen")
    public void userClickYesButtonOnPopUpDialogPaymentSuccessScreen() {
        paymentSuccesPage.clickYesButton();
    }

    @And("User click voucher action button")
    public void userClickVoucherActionButton() {
        letsPayPage.clickVoucherActionButton();
    }

    @Then("User directed to pick a voucher screen")
    public void userDirectedToPickAVoucherScreen() {
        Assert.assertTrue(pickAvoucherPage.isOnPage());
    }

    @When("User click continue without using voucher")
    public void userClickContinueWithoutUsingVoucher() {
        pickAvoucherPage.clickContinueButton();
    }
}
