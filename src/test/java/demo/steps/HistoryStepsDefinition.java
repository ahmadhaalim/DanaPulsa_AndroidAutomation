package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HistoryStepsDefinition {

    MobileRechargeStepsDefinition mobileRechargeStepsDefinition = new MobileRechargeStepsDefinition();

    HomePage homePage = new HomePage();
    HistoryPage historyPage = new HistoryPage();
    TransactionDetailPage transactionDetailPage = new TransactionDetailPage();


    @When("User click history button")
    public void userClickHistoryButton() {
        homePage.clickHistoryButton();
    }

    @Then("User directed to history screen")
    public void userDirectedToHistoryScreen() {
        Assert.assertTrue(historyPage.isOnPage());
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


    @Then("User see  latest pending transaction at in progress tab")
    public void userSeeLatestPendingTransactionAtInProgressTab() {
        historyPage.waitUntilTransactionItemIsDiyplayed();
    }

    @When("User click {string} tab on history screen")
    public void userClickTabOnHistoryScreen(String tabKeyword) {
        if("In Progress".equals(tabKeyword)){
            historyPage.clickInProgressTab();
        } else if("Completed".equals(tabKeyword)){
            historyPage.clickCompletedTab();
        }
    }

    @Then("User see {string} on history screen")
    public void userSeeOnHistoryScreen(String expected) {
        String actual = historyPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }

    @When("User click in progress transaction with price {string}")
    public void userClickInProgressTransactionWithNominal(String price) {
        historyPage.waitUntilTransactionItemIsDiyplayed();
        historyPage.clickInProgressTransaction(price);
    }

    @And("User click completed transaction with price {string}")
    public void userClickCompletedTransactionWithPrice(String price) {
        historyPage.waitUntilTransactionItemIsDiyplayed();
        historyPage.clickCompletedTransaction(price);
    }

    @Then("User directed to transaction detail screen")
    public void userDirectedToTransactionDetailScreen() {
        Assert.assertTrue(transactionDetailPage.isOnPage());
    }

    @When("User click back button on transaction detail screen")
    public void userClickBackButtonOnTransactionDetailScreen() {
        transactionDetailPage.clickBackButton();
    }

    @And("User click in progress tab while internet is off")
    public void userClickInProgressTabWhileInternetIsOff() {
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
        historyPage.clickInProgressTab();
    }

    @Then("User see warning {string} on history screen")
    public void userSeeWarningOnHistoryScreen(String expected) {
        String actual = historyPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }

    @When("User click completed tab while internet is off")
    public void userClickCompletedTabWhileInternetIsOff() {
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
        historyPage.clickCompletedTab();
    }

    @And("User click one completed transaction while internet is off")
    public void userClickOneCompletedTransactionWhileInternetIsOff() {
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
        historyPage.clickOneCompletedTransaction();
    }

    @And("User see warning {string} at transaction detail screen")
    public void userSeeWarningAtTransactionDetailScreen(String expected) {
        String actual = transactionDetailPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }


    @Then("User directed to transaction detail screen with price {string}")
    public void userDirectedToTransactionDetailScreenWithPrice(String expected) {
        String actualStatus = transactionDetailPage.getTransactionStatus();
        String actualId = transactionDetailPage.getTransactionId();
        String actualPhone = transactionDetailPage.getTransactionPhone();
        String actualProduct = transactionDetailPage.getTransactionProduct();
        String actualPrice = transactionDetailPage.getTransactionPrice();
        Assert.assertEquals(expected, actualPrice);
        Assert.assertEquals(mobileRechargeStepsDefinition.transactionStatus, actualStatus);
        Assert.assertEquals(mobileRechargeStepsDefinition.transactionPhone, actualPhone);
        Assert.assertEquals(mobileRechargeStepsDefinition.transactionProduct, actualProduct);
        Assert.assertEquals(mobileRechargeStepsDefinition.transactionID,actualId);
    }

    @And("User click completed transaction summary")
    public void userClickCompletedTransactionSummary() {
        historyPage.clickCompletedTransaction(mobileRechargeStepsDefinition.transactionDate);
    }

    @When("User click {string} tab")
    public void userClickTab(String expected) {
        historyPage.waitUntilTransactionItemIsDiyplayed();
        String actual = historyPage.checkInProgressTransactionStatus();
        Assert.assertEquals(expected, actual);
    }

    @Then("User directed to device home from history screen")
    public void userDirectedToDeviceHomeFromHistoryScreen() {
        Assert.assertFalse(historyPage.isOnPage());
    }

    @And("User click one of completed transaction summary")
    public void userClickOneOfCompletedTransactionSummary() {
        historyPage.clickOneCompletedTransaction();
    }
}
