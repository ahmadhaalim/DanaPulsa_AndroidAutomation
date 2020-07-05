package demo.steps;

import demo.pages.nauval.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MobileRechargeDefinition {
    HomePage homePage = new HomePage();
    RechargeInputNumberPage inputNumber = new RechargeInputNumberPage();
    RechargeChooseTopUpPage topUpPage = new RechargeChooseTopUpPage();
    RechargePaymentDetailPage detailPage = new RechargePaymentDetailPage();
    RechargePaymentStatusPage statusPage = new RechargePaymentStatusPage();
    RechargeChooseVoucherPage chooseVoucher = new RechargeChooseVoucherPage();
    ProfilePage profile = new ProfilePage();

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        boolean on_page = homePage.onHomePage();
        Assert.assertTrue(on_page);
    }

    @When("User click mobile recharge icon")
    public void userClickMobileRechargeIcon() {
        homePage.chooseMobileRecharge();
    }

    @And("User input {string}")
    public void userInputPhoneNumber(String phoneNumber) {
        inputNumber.inputNumber(phoneNumber);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("User choose {string} nominal")
    public void userChooseTopUpNominalBasedOn(String topUp) {
        topUpPage.chooseTopUpNominal(topUp);
    }

    @And("User see payment detail page")
    public void userSeePaymentDetailPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(detailPage.isOnPage());
    }

    @And("User pay the bill")
    public void userPayTheBill() {
        detailPage.payButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User see payment status page")
    public void userSeePaymentStatusPage() throws InterruptedException {
        Thread.sleep(5000);
        statusPage.isOnPage();
    }

    @And("User see payment status {string}")
    public void userSeePaymentStatus(String status) {
        String status_page = statusPage.statusPayment();
        Assert.assertTrue(status_page.contains(status));
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

    @And("User choose voucher value {string}")
    public void userChooseVoucherValueChooseVoucher(String voucherValue) throws InterruptedException {
        Thread.sleep(5000);
        if (voucherValue.contains("Cashback")){
            chooseVoucher.chooseCashback(voucherValue);
        }
        if (voucherValue.contains("Diskon")){
            chooseVoucher.chooseDiscount(voucherValue);
        }
        if (voucherValue.equalsIgnoreCase("no")){
            chooseVoucher.noVoucher();
        }
    }

    @Then("User see top up catalog")
    public void userSeeTopUpCatalog() {
        Assert.assertTrue(topUpPage.displayTopUp());
    }

    @And("User click back to home button")
    public void userClickBackToHomeButton() {
        statusPage.backToHome();
    }

    @And("User pick a voucher")
    public void userPickAVoucher() {
        detailPage.pickVoucher();
    }

    @And("if {string} is {string}, user choose no voucher")
    public void ifIsAvailableUserChooseNoVoucher(String status, String actual) {
        if (status.equals(actual)){
            detailPage.pickVoucher();
            chooseVoucher.noVoucher();
        }
    }

    @And("User open action menu")
    public void userOpenActionMenu() {
        detailPage.actionMenu();
    }

    @And("User cancel transaction")
    public void userCancelTransaction() {
        detailPage.cancelButton();
    }

    @And("User confirm to cancel transaction")
    public void userConfirmToCancelTransaction() {
        detailPage.cancelDialog();
        detailPage.cancelPositive();
    }

    @And("User click history icon")
    public void userClickHistoryIcon() {
        homePage.chooseHistory();
    }

    @And("User choose completed tab")
    public void userChooseCompletedTab() {
    }

    @Then("User see cancelled transaction")
    public void userSeeCancelledTransaction() {
    }

    @And("User choose from recent number")
    public void userChooseFromRecentNumber() {
        inputNumber.recentNumber();
    }

    @And("if {string} is {string}, user get a voucher")
    public void ifIsUserGetAVoucher(String status, String actual) {
        if(status.equals(actual)){
            statusPage.voucherDialog();
            statusPage.confirmDialog();
        }
    }

    @And("User click profile")
    public void userClickProfile() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.chooseProfile();
    }

    @And("User click sign out")
    public void userClickLogOut() {
        profile.isOnPage();
        profile.signOut();
        profile.confirmPositive();
    }

    @Then("User see that balance is reduce")
    public void userCalculateBalance() {
        int calculate = homePage.balanceInit - detailPage.calcOrder;
        int balance = homePage.getFinalBalance();
        Assert.assertEquals(balance, calculate);
    }

    @When("User check initial balance")
    public void userCheckInitialBalance() {
        int balance = homePage.getInitialBalance();
        System.out.println(balance);
    }

    @And("User check total payment")
    public void userCheckTotalPayment() {
        int total = detailPage.getTotal();
        System.out.println(total);
    }

    @And("User click select from contact button")
    public void userClickSelectFromContactButton() {
        inputNumber.selectContact();
    }

    @And("User choose a contact")
    public void userChooseAContact() {
        inputNumber.chooseContact();
    }
}
