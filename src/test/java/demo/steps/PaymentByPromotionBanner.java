package demo.steps;

import demo.pages.HomePage;
import demo.pages.PromotionDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentByPromotionBanner {

    HomePage homePage = new HomePage();
    PromotionDetailPage detailPage = new PromotionDetailPage();

//    @When("User click Promotion Banner")
//    public void userClickPromotionBanner() {
//        homePage.clickPromotionItem();
//    }

    @And("User click Buy Pulsa Now")
    public void userClickBuyPulsaNow() {detailPage.clickBuyPulsaNowButton();
    }

    @When("User choose {string} on banner")
    public void userChooseOnBanner(String titles) {
        homePage.clickPromotionItem(titles);
    }
}
