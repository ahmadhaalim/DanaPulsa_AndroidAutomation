package demo.steps;

import demo.driver.AndroidDriverInstance;
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

    @Then("User directed to home screen")
    public void userDirectedToHomeScreen() {
        Assert.assertTrue(homePage.isOnPage());
    }

    @When("User click profile button")
    public void userClickProfileButton() {
        homePage.clickProfileButton();
    }

    @When("User click {string} on home screen")
    public void userClickOnHomeScreen(String elementKeyword){
        if ("Mobile Recharge Icon".equals(elementKeyword)) {
            homePage.clickMobileRechargeButton();
        } else if("Promotion Banner".equals(elementKeyword)) {
            homePage.clickPromotionBanner();
        } else if("View All Button".equals(elementKeyword)) {
            homePage.clickViewAllButton();
        }
    }

    @Then("User directed from home screen to {string}")
    public void userDirectedFromHomeScreenTo(String screenKeyword) {
        if ("Mobile Recharge Screen".equals(screenKeyword)) {
            Assert.assertTrue(mobileRechargePage.isOnPage());
        } else if("Promotion Detail Screen".equals(screenKeyword)) {
            Assert.assertTrue(promotionDetailPage.isOnPage());
        } else if("Promotion List Screen".equals(screenKeyword)) {
            Assert.assertTrue(promotionListPage.isOnPage());
        }
    }

    @When("User click back button at {string} while previously at the home screen")
    public void userClickBackButtonAtWhilePreviouslyAtTheHomeScreen(String screenKeyword) {
        if ("Mobile Recharge Screen".equals(screenKeyword)) {
            mobileRechargePage.clickBackButton();
        } else if("Promotion Detail Screen".equals(screenKeyword)) {
            promotionDetailPage.clickBackButton();
        } else if("Promotion List Screen".equals(screenKeyword)) {
            promotionDetailPage.clickBackButton();
        }
    }

    @When("user click buy pulsa now on promotion detail screen")
    public void userClickBuyPulsaNowOnPromotionDetailScreen() {
        promotionDetailPage.clickBuyPulsaNowButton();
    }

    @When("User click one of promotion banner at promotion list screen")
    public void userClickOneOfPromotionBannerAtPromotionListScreen() {
        promotionListPage.clickPromotionBanner();
    }

    @When("User click back button at promotion detail screen")
    public void userClickBackButtonAtPromotionDetailScreen() {
        promotionDetailPage.clickBackButton();
    }

    @Then("User directed to promotion list screen")
    public void userDirectedToPromotionListScreen() {
        Assert.assertTrue(promotionListPage.checkPromotionBanner());
    }

    @When("User click home button")
    public void userClickHomeButton() {
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
        homePage.clickHomeButton();
    }

    @Then("User see warning message {string} on promotion area")
    public void userSeeWarningMessageOnPromotionArea(String expected) {
        String actual = homePage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }

    @When("User click promotion banner on home screen")
    public void userClickPromotionBannerOnHomeScreen() {
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
        homePage.clickPromotionBanner();
    }

    @And("User see warning message {string} on promotion detail screen")
    public void userSeeWarningMessageOnPromotionDetailScreen(String expected) {
        String actual = promotionDetailPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }

    @When("User click view all on home screen")
    public void userClickViewAllOnHomeScreen() throws InterruptedException {
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
        homePage.clickViewAllButton();
    }

    @And("User see warning message {string} on promotion list screen")
    public void userSeeWarningMessageOnPromotionListScreen(String expected) {
        String actual = promotionListPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }

    @When("User click voucher button while internet is off")
    public void userClickVoucherButtonWhileInternetIsOff() {
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
        homePage.clickVoucherButton();
    }
}
