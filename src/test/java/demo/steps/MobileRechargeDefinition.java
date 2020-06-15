package demo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileRechargeDefinition {
    @Given("User is on homepage")
    public void userIsOnHomepage() {
    }

    @When("User click mobile recharge icon")
    public void userClickMobileRechargeIcon() {
    }

    @And("User input {string}")
    public void userInputPhoneNumber(String phoneNumber) {
    }

    @And("User choose {string} nominal")
    public void userChooseTopUpNominalBasedOn(String topUp) {
    }

    @And("User see payment detail page")
    public void userSeePaymentDetailPage() {
    }

    @And("User pay the bill")
    public void userPayTheBill() {
    }

    @Then("User see payment success page")
    public void userSeePaymentSuccessPage() {
    }

    @And("User check status voucher availability {string}")
    public void userCheckStatusVoucherAvailability(String statusVoucher) {

    }

    @And("User choose voucher value {string}")
    public void userChooseVoucherValueChooseVoucher(String voucherValue) {
    }
}
