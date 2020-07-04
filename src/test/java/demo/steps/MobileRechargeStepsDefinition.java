package demo.steps;

import demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MobileRechargeStepsDefinition {

    MobileRechargePage mobileRechargePage = new MobileRechargePage();
    LetsPayPage letsPayPage = new LetsPayPage();
    PaymentSuccesPage paymentSuccesPage = new PaymentSuccesPage();
    TransactionDetailPage transactionDetailPage = new TransactionDetailPage();
    PickAvoucherPage pickAvoucherPage = new PickAvoucherPage();

    String choosedPrice = "";
    String transactionIdOnPaymentResult = "";
    String transactionProductOnPaymentResult = "";
    String transactionPhoneOnPaymentResult = "";
    String transactionDateOnPaymentResult = "";
    String transactionStatusOnPaymentResult = "";

    @When("User input phone number {string} on mobile recharge screen")
    public void userInputPhoneNumberOnMobileRechargeScreen(String phoneNumber) throws InterruptedException {
        mobileRechargePage.inputPhoneNumber(phoneNumber);
        Thread.sleep(8000);
    }

    @And("User choose pulsa {string} with price {string}")
    public void userChoosePulsaWithPrice(String pulsa, String price) throws InterruptedException {
        Assert.assertTrue(mobileRechargePage.checkNominalPulsa());
        choosedPrice = mobileRechargePage.checkPrice(price);
        mobileRechargePage.choosePulsa(pulsa);
        Thread.sleep(15000);
    }

    @Then("User directed to lets pay screen and see total payment")
    public void userDirectedToLetsPayScreenAndSeeTotalPayment() {
        Assert.assertTrue(letsPayPage.isOnPage());
        String actualPrice = letsPayPage.getTotalPrice();
        Assert.assertEquals(choosedPrice, actualPrice);

    }

    @When("User tap pay button")
    public void userTapPayButton() throws InterruptedException {
        letsPayPage.clickPayButton();
        Thread.sleep(10000);
    }

    @Then("User directed to success payment screen")
    public void userDirectedToSuccessPaymentScreen() {
        Assert.assertTrue(paymentSuccesPage.isOnPage());
        transactionIdOnPaymentResult = paymentSuccesPage.getId();
        transactionProductOnPaymentResult = paymentSuccesPage.getProduct();
        transactionPhoneOnPaymentResult = paymentSuccesPage.getPhone();
        transactionDateOnPaymentResult = paymentSuccesPage.getDate();
        transactionStatusOnPaymentResult = paymentSuccesPage.getStatus();

    }

    @And("User tap back to home button")
    public void userTapBackToHomeButton() {
        paymentSuccesPage.clickBackToHomeButton();
    }

    @And("User see transaction detail")
    public void userSeeTransactionDetail() {
        Assert.assertTrue(transactionDetailPage.isOnPage());
        Assert.assertEquals(transactionIdOnPaymentResult, transactionDetailPage.getTransactionId());
        Assert.assertEquals(transactionProductOnPaymentResult, transactionDetailPage.getTransactionProduct());
        Assert.assertEquals(transactionPhoneOnPaymentResult, transactionDetailPage.getTransactionPhone());
        Assert.assertEquals(transactionDateOnPaymentResult, transactionDetailPage.getTransactionDate());
        Assert.assertEquals(transactionStatusOnPaymentResult, transactionDetailPage.getTransactionStatus());
    }

    @When("User tap change voucher button")
    public void userTapChangeVoucherButton() {
        letsPayPage.clickChangeVoucherButton();
    }

    @And("User tap continue without voucher button")
    public void userTapContinueWithoutVoucherButton() {
        Assert.assertTrue(pickAvoucherPage.isOnPage());
        pickAvoucherPage.clickContinueButton();
    }

    @And("User see used voucher {string}")
    public void userSeeUsedVoucher(String voucher) {
        String actualVoucher = letsPayPage.getChoosedVoucher();
        Assert.assertEquals(voucher, actualVoucher);
    }
}
