package demo.steps;

import demo.locator.RechargeInputPhoneNumberPageLocator;
import demo.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PaymentByHistoryStepsDefinition {

    HomePage homePage;
    RechargeInputNumberPage inputNumber;
    RechargeChooseTopUpPage topUpPage;
    RechargePaymentDetailPage detailPage;
    RechargePaymentStatusPage statusPage;
    HistoryPage historyPage;

    @Given("User is on homepage")
    public void userIsOnHomepage() {
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
    public void userDirectedToHomeScreen() {
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

}
