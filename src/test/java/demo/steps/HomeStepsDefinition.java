package demo.steps;

import demo.pages.HomePage;
import demo.pages.MobileRechargePage;
import demo.pages.PromotionDetailPage;
import demo.pages.PromotionListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStepsDefinition {

    HomePage homePage = new HomePage();
    MobileRechargePage mobileRechargePage = new MobileRechargePage();
    PromotionDetailPage promotionDetailPage = new PromotionDetailPage();
    PromotionListPage promotionListPage = new PromotionListPage();

    @When("User click mobile recharge icon")
    public void userClickMobileRechargeIcon() {
        homePage.clickMobileRechargeButton();
    }

    @Then("User directed to mobile recharge screen")
    public void userDirectedToMobileRechargeScreen() {
        mobileRechargePage.isOnPage();
    }

    @When("User click back button on mobile recharge screen")
    public void userClickBackButtonOnMobileRechargeScreen() {
        mobileRechargePage.clickBackButton();
    }

    @When("User click one of promotion banner")
    public void userClickOneOfPromotionBanner() throws InterruptedException {
        wait(10);
        homePage.clickPromotionBanner();
    }

    @Then("User directed to promotion detail screen")
    public void userDirectedToPromotionDetailScreen() {
        promotionDetailPage.isOnPage();
    }

    @When("User click buy pulsa now button")
    public void userClickBuyPulsaNowButton() {
        promotionDetailPage.clickBuyPulsaNowButton();
    }

    @When("User click back button on promotion detail screen")
    public void userClickBackButtonOnPromotionDetailScreen() {
        promotionDetailPage.clickBackButton();
    }

    @When("User click view all button")
    public void userClickViewAllButton() {
        homePage.clickViewAllButton();
    }

    @Then("User directed to promotion list screen")
    public void userDirectedToPromotionListScreen() {
        promotionListPage.isOnPage();

    }

    @When("User click one of promotion banner at promotion list screen")
    public void userClickOneOfPromotionBannerAtPromotionListScreen() {
        promotionListPage.clickPromotionBanner();
    }

    @When("User click back button on promotion list screen")
    public void userClickBackButtonOnPromotionListScreen() {
        promotionListPage.clickBackButton();
    }

    @When("User click home button")
    public void userClickHomeButton() throws InterruptedException {
        wait(10);
        homePage.clickHomeButton();
    }

    @Then("User see warning message {string} on promotion area")
    public void userSeeWarningMessageOnPromotionArea(String expected) {
        String actual = homePage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }

    @And("User see warning message {string} on promotion detail screen")
    public void userSeeWarningMessageOnPromotionDetailScreen(String expected) {
        String actual = promotionDetailPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }

    @And("User see warning message {string} on promotion list screen")
    public void userSeeWarningMessageOnPromotionListScreen(String expected) {
        String actual = promotionListPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }

}
