package demo.steps;

import demo.pages.PaymentByHistory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PaymentByHistoryStepsDefinition {
    @Given("User at main page")
    public void userAtMainPage() {
        boolean actual = PaymentByHistory.isOnPage();
        Assert.assertTrue(actual);
    }

    @When("User click History")
    public void userClickHistory() {
    }

    @Then("User click unfinished payment")
    public void userClickUnfinishedPayment() {
    }

    @And("User see payment detail page")
    public void userSeePaymentDetailPage() {
    }

    @And("User click Pay Now")
    public void userClickPayNow() {
    }

    @Then("User see Payment Success Page")
    public void userSeePaymentSuccessPage() {
    }

}
