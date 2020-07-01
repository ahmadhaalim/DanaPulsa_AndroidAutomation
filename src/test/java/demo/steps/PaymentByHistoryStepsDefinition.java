package demo.steps;

import demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PaymentByHistoryStepsDefinition {

    HomePage homePage = new HomePage();
    RechargeInputNumberPage inputNumber = new RechargeInputNumberPage();
    RechargeChooseTopUpPage topUpPage = new RechargeChooseTopUpPage();
    RechargeChooseVoucherPage chooseVoucherPage = new RechargeChooseVoucherPage();
    RechargePaymentDetailPage detailPage = new RechargePaymentDetailPage();
    RechargePaymentStatusPage statusPage = new RechargePaymentStatusPage();
    HistoryPage historyPage = new HistoryPage();

    @Given("User is on homepage")
    public void userIsOnHomepage(){
        Assert.assertTrue(homePage.onHomePage());
    }

    @When("User click mobile recharge icon")
    public void userClickMobileRechargeIcon() {homePage.chooseMobileRecharge();
    }

    @And("User input {string}")
    public void userInput(String phoneNumber) {
        inputNumber.inputNumber(phoneNumber);
    }

    @And("User choose {string} nominal")
    public void userChooseNominal(String topUp) {
        topUpPage.chooseTopUpNominal(topUp);
    }

    @Then("User see payment detail page")
    public void userSeePaymentDetailPage() {detailPage.isOnPage();
    }

    @When("User click back button at payment detail page")
    public void userClickBackButtonAtPaymentDetailPage() {detailPage.clickBackButton();
    }

    @And("User click yes button on pop up dialog")
    public void userClickYesButtonOnPopUpDialog() {detailPage.clickYesButton();
    }

    @Then("User directed to home screen")
    public void userDirectedToHomeScreen() throws InterruptedException {
        Assert.assertTrue(homePage.onHomePage());
    }

    @When("User click history button")
    public void userClickHistoryButton() {homePage.clickHistoryButton();
    }

    @Then("User click in progress tab")
    public void userClickInProgressTab() {historyPage.clickInProgressTab();
    }

    @And("User click in progress payment")
    public void userClickInProgressPayment() {historyPage.clickInProgressTransaction();
    }

    @And("User check status voucher availability {string}")
    public void userCheckStatusVoucherAvailability(String statusVoucher) {
        if (statusVoucher.equals("unavailable")){
            boolean status = detailPage.voucherUnavailable();
            Assert.assertFalse(status);
        }
        if (statusVoucher.equals("available")){
            boolean status = detailPage.voucherAvailable();
            Assert.assertTrue(status);
        }
    }

    @And("User pick a voucher")
    public void userPickAVoucher() {
        detailPage.pickVoucher();
    }

    @And("User choose voucher value {string}")
    public void userChooseVoucherValueChooseVoucher(String chooseVoucher) {
        if (chooseVoucher.contains("Cashback")){
            chooseVoucherPage.chooseCashback(chooseVoucher);
        }
        if (chooseVoucher.contains("Diskon")){
            chooseVoucherPage.chooseDiscount(chooseVoucher);
        }
//        else {
//            chooseVoucherPage.noVoucher();
//        }
    }

    @And("User pay the bill")
    public void userPayTheBill() {
        detailPage.payButton();
    }

    @And("User see payment status {string}")
    public void userSeePaymentStatus(String status) {
        String status_page = statusPage.statusPayment();
        Assert.assertTrue(status_page.contains(status));
    }

    @And("User click back to home button")
    public void userClickBackToHomeButton() {
        statusPage.backToHome();
    }

    @And("User click OK")
    public void userClickOK() {statusPage.confirmationButton();
    }
}
