package demo.steps;

import demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HistoryStepsDefinition {

    HomePage homePage = new HomePage();
    HistoryPage historyPage = new HistoryPage();
    MobileRechargePage mobileRechargePage = new MobileRechargePage();
    LetsPayPage letsPayPage = new LetsPayPage();
    PaymentSuccesPage paymentSuccesPage = new PaymentSuccesPage();
    TransactionDetailPage transactionDetailPage = new TransactionDetailPage();

    String totalPrice = "";
    String transactionId = "";
    String transactionDate = "";

    @When("User click history button")
    public void userClickHistoryButton() {
        homePage.clickHistoryButton();
    }

    @Then("User directed to history screen")
    public void userDirectedToHistoryScreen() {
        historyPage.isOnPage();
    }

    @And("User see {string} info")
    public void userSeeInfoAtInProgressTabScreen(String expected) {
        String actual = historyPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }

    @When("User click completed tab")
    public void userClickCompletedTab() {
        historyPage.clickCompletedTab();
    }

    @When("User input phone number {string} on mobile recharge screen")
    public void userInputPhoneNumberOnMobileRechargeScreen(String phoneNumber) {
        mobileRechargePage.InputPhoneNumber(phoneNumber);
    }

    @And("User click nominal top up {string}")
    public void userClickNominalTopUp(String pulsaNominal) {
        mobileRechargePage.ChoosePulsaNominal(pulsaNominal);
    }

    @Then("User directed to lets pay screen")
    public void userDirectedToLetsPayScreen() {
        letsPayPage.isOnPage();
    }

    @When("User click back button on lets pay screen")
    public void userClickBackButtonOnLetsPayScreen() {
        totalPrice = letsPayPage.getTotalPrice();
        letsPayPage.clickBackButton();
    }

    @And("User click yes button on cancel transaction dialog")
    public void userClickYesButtonOnCancelTransactionDialog() {
        letsPayPage.checkIfDialogBoxIsDisplayed();
        letsPayPage.clickYesButton();
    }

    @Then("User see  latest pending transaction at in progress tab")
    public void userSeeLatestPendingTransactionAtInProgressTab() {
        historyPage.waitUntilTransactionItemIsDiyplayed();
    }

    @When("User click pending transaction")
    public void userClickPendingTransaction() {
        historyPage.clickInProgressTransaction(totalPrice);
    }

    @When("User click pay on lets pay screen")
    public void userClickPayOnLetsPayScreen() {
        letsPayPage.clickPayButton();
    }

    @Then("User directed to payment success info")
    public void userDirectedToPaymentSuccessInfo() {
        paymentSuccesPage.isOnPage();
        transactionDate = paymentSuccesPage.getTransactionDate();
        transactionId = paymentSuccesPage.getTransactionId();
    }

    @When("User click back to home button")
    public void userClickBackToHomeButton() {
        paymentSuccesPage.clickBackToHomeButton();
    }

    @And("User click completed transaction")
    public void userClickCompletedTransaction() {
        historyPage.clickCompletedTransaction(transactionDate);
    }

    @Then("User directed to transaction detail screen")
    public void userDirectedToTransactionDetailScreen() {
        transactionDetailPage.isOnPage();
        String actualPrice = transactionDetailPage.getTotalPrice();
        Assert.assertEquals(totalPrice, actualPrice);
    }

    @When("User click back button on transaction detail screen")
    public void userClickBackButtonOnTransactionDetailScreen() {
        transactionDetailPage.clickBackButton();
    }

    @And("User click one completed transaction")
    public void userClickOneCompletedTransaction() {
        historyPage.clickOneOfCompletedTransaction();
    }

    @And("User see warning message {string} at transaction detail screen")
    public void userSeeWarningMessageAtTransactionDetailScreen(String expected) {
        String actual = transactionDetailPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }
}
