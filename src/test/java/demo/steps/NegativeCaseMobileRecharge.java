package demo.steps;

import demo.locator.RechargeInputPhoneNumberPageLocator;
import demo.pages.RechargeChooseTopUpPage;
import demo.pages.RechargeInputNumberPage;
import demo.pages.RechargePaymentDetailPage;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static demo.driver.AndroidDriverInstance.androidDriver;

public class NegativeCaseMobileRecharge {

    RechargePaymentDetailPage detailPage = new RechargePaymentDetailPage();
    RechargeInputNumberPage inputNumberPage = new RechargeInputNumberPage();
    RechargeChooseTopUpPage topUpPage = new RechargeChooseTopUpPage();

    @Then("User cannot pay the bill")
    public void userCannotPayTheBill() {
        Assert.assertTrue(detailPage.checkPayButton());
    }

    @Then("User didn't see provider icon")
    public void userDidnTSeeProviderIcon() {
        Assert.assertTrue(topUpPage.checkOperatorIcon());
    }


    @Then("User see invalid format message")
    public void userSeeInvalidFormatMessage() { Assert.assertTrue(inputNumberPage.checkErrorMessage());
    }

    @Then("User see invalid phone number message")
    public void userSeeInvalidPhoneNumberMessage() {Assert.assertTrue(inputNumberPage.invalidErrorMessage());
    }

    @Then("User not see any top up nominal")
    public void userNotSeeAnyTopUpNominal() {Assert.assertFalse(inputNumberPage.topupUnavailable());
    }

    @And("User check status voucher availability")
    public void userCheckStatusVoucherAvailability() {Assert.assertTrue(detailPage.checkVoucherButton());
    }
}
