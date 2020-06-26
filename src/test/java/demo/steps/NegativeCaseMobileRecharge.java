package demo.steps;

import demo.pages.RechargeInputNumberPage;
import demo.pages.RechargePaymentDetailPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class NegativeCaseMobileRecharge {

    RechargePaymentDetailPage detailPage = new RechargePaymentDetailPage();
    RechargeInputNumberPage inputNumberPage = new RechargeInputNumberPage();

    @Then("User cannot pay the bill")
    public void userCannotPayTheBill() {
        Assert.assertFalse(detailPage.checkPayButton());
    }

    @Then("User didn't see provider icon")
    public void userDidnTSeeProviderIcon() {
        Assert.assertFalse(inputNumberPage.checkProviderIcon());
    }


    @Then("User see invalid format message")
    public void userSeeInvalidFormatMessage() { Assert.assertTrue(inputNumberPage.checkErrorMessage());
    }
}
