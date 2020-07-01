package demo.steps;

import demo.pages.HomePage;
import demo.pages.PromotionListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentByPromotionList {

    HomePage homePage = new HomePage();
    PromotionListPage listPage = new PromotionListPage();

    @When("User click view all")
    public void userClickViewAll() {
        homePage.clickViewAll();
    }

    @Then("User click promotion")
    public void userClickPromotion() {
        listPage.clickPromotionBanner();
    }

    @Then("User choose {string} on promotion list")
    public void userChooseOnPromotionList(String titles) {
        homePage.clickPromotionItem(titles);
    }
}
