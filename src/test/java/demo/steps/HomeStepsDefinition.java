package demo.steps;

import demo.pages.HomePage;
import demo.pages.PromotionDetailPage;
import demo.pages.PromotionListPage;
import deviceutilities.AndroidDeviceUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStepsDefinition{

    AndroidDeviceUtilities androidDeviceUtilities = new AndroidDeviceUtilities();
    HomePage homePage = new HomePage();
    PromotionDetailPage promotionDetailPage = new PromotionDetailPage();
    PromotionListPage promotionListPage = new PromotionListPage();

    @When("User tap {string} on home screen while internet is {string}")
    public void userTapOnHomeScreen(String elementKeyword, String state){
        if(state.equalsIgnoreCase("off")){
            androidDeviceUtilities.toggleWifi();
            androidDeviceUtilities.toggleData();
        }
        if ("Mobile Recharge Icon".equals(elementKeyword)) {
            homePage.clickMobileRechargeButton();
        } else if("Promotion Banner".equals(elementKeyword)) {
            homePage.clickPromotionBanner();
        } else if("View All Button".equals(elementKeyword)) {
            homePage.clickViewAllButton();
        }
    }

    @When("user click buy pulsa now on promotion detail screen")
    public void userClickBuyPulsaNowOnPromotionDetailScreen() {
        promotionDetailPage.clickBuyPulsaNowButton();
    }

    @Then("User see warning message {string} on promotion area")
    public void userSeeWarningMessageOnPromotionArea(String expected) {
        String actual = homePage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        androidDeviceUtilities.toggleWifi();
        androidDeviceUtilities.toggleData();
    }

    @And("User see warning message {string} on promotion detail screen")
    public void userSeeWarningMessageOnPromotionDetailScreen(String expected) {
        String actual = promotionDetailPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        androidDeviceUtilities.toggleWifi();
        androidDeviceUtilities.toggleData();
    }

    @And("User see warning message {string} on promotion list screen")
    public void userSeeWarningMessageOnPromotionListScreen(String expected) {
        String actual = promotionListPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        androidDeviceUtilities.toggleWifi();
        androidDeviceUtilities.toggleData();
    }

    @When("User tap promotion banner on promotion list screen while internet is {string}")
    public void userTapPromotionBannerOnPromotionListScreenWhileInternetIs(String state) {
        if(state.equalsIgnoreCase("off")){
            androidDeviceUtilities.toggleWifi();
            androidDeviceUtilities.toggleData();
        }
    }
}
