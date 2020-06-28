package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.*;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HistoryStepsDefinition {

    HistoryPage historyPage = new HistoryPage();
    LetsPayPage letsPayPage = new LetsPayPage();
    TransactionDetailPage transactionDetailPage = new TransactionDetailPage();

    String ExpectedPrice = "";
    String ExpectedDate = "";
    String ExpectedStatus = "";

    @Then("User will directed to {string} screen")
    public void userWillDirectedToHistoryScreen(String screenName) {
        if(screenName.equalsIgnoreCase("history screen")) {
            Assert.assertTrue(historyPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("lets pay")) {
            Assert.assertTrue(letsPayPage.isOnPage());
        } else if(screenName.equalsIgnoreCase("transaction detail")) {
            Assert.assertTrue(transactionDetailPage.isOnPage());
            Assert.assertTrue(transactionDetailPage.waitUntilTotalPriceDisplayed());
            Assert.assertEquals(ExpectedPrice, transactionDetailPage.getTransactionPrice());
            Assert.assertEquals(ExpectedDate, transactionDetailPage.getTransactionDate());
            Assert.assertEquals(ExpectedStatus, transactionDetailPage.getTransactionStatus());
        } else if(screenName.equalsIgnoreCase("device home")){
            String appId = AndroidDriverInstance.androidDriver.getCurrentPackage();
            Assert.assertEquals(AndroidDriverInstance.androidDriver.queryAppState(appId), ApplicationState.RUNNING_IN_BACKGROUND);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User see info {string} on history screen and internet is {string}")
    public void userSeeInfoOnHistoryScreen(String expected, String state) throws InterruptedException {
        Thread.sleep(5000);
        String actual = historyPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        if(state.equalsIgnoreCase("off")){
            AndroidDriverInstance.androidDriver.toggleData();
            AndroidDriverInstance.androidDriver.toggleWifi();
        }
    }

    @When("User tap {string} tab while internet is {string}")
    public void userTapTab(String tab, String state) throws InterruptedException {
        Thread.sleep(3000);
        if(state.equalsIgnoreCase("off")){
            AndroidDriverInstance.androidDriver.toggleWifi();
            AndroidDriverInstance.androidDriver.toggleData();
        }
        if(tab.equalsIgnoreCase("in progress")){
            historyPage.clickInProgressTab();
        } else if(tab.equalsIgnoreCase("completed")) {
            historyPage.clickCompletedTab();
        }
    }

    @And("User tap {string} transaction with price {string} while internet is {string}")
    public void userTapTransactionWithPrice(String status, String price, String state) throws InterruptedException {
        Thread.sleep(15000);
        if(state.equalsIgnoreCase("off")){
            AndroidDriverInstance.androidDriver.toggleWifi();
            AndroidDriverInstance.androidDriver.toggleData();
        }
        historyPage.waitUntilTransactionHistoryDisplayed();
        ExpectedDate = historyPage.getTransactionHistoryDateAndTime(status, price);
        ExpectedPrice = historyPage.getTransactionHistoryPrice(status, price);
        ExpectedStatus = historyPage.getTransactionHistoryStatus(status, price);
        historyPage.clickOneTransactionHistory(status, price);
    }

    @Then("User see warning message {string} on transaction detail screen")
    public void userSeeWarningMessageOnTransactionDetailScreen(String expected) {
        String actual = transactionDetailPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }
}
