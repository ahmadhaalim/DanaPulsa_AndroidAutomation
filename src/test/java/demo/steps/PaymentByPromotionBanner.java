package demo.steps;

import demo.pages.HomePage;
import demo.pages.PromotionDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentByPromotionBanner {

    HomePage homePage;
    PromotionDetailPage detailPage;

    @When("User click Promotion Banner")
    public void userClickPromotionBanner() {
        homePage.clickPromotionItem();
    }

    @And("User click Buy Pulsa Now")
    public void userClickBuyPulsaNow() {detailPage.clickBuyPulsaNowButton();
    }

}
