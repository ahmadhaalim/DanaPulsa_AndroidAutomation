package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.HomePage;
import demo.pages.MobileRechargePage;
import demo.pages.PromotionDetailPage;
import demo.pages.PromotionListPage;
import deviceutilities.AndroidDeviceUtilities;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStepsDefinition{

    AndroidDeviceUtilities androidDeviceUtilities = new AndroidDeviceUtilities();
    HomePage homePage = new HomePage();
    MobileRechargePage mobileRechargePage = new MobileRechargePage();
    PromotionDetailPage promotionDetailPage = new PromotionDetailPage();
    PromotionListPage promotionListPage = new PromotionListPage();

    String promotionTitleExpected = "";

    @When("User tap {string} on home screen while internet is {string}")
    public void userTapOnHomeScreen(String elementKeyword, String state){
        if(state.equalsIgnoreCase("off")){
            androidDeviceUtilities.toggleWifi();
            androidDeviceUtilities.toggleData();
        }
        if ("Mobile Recharge Icon".equals(elementKeyword)) {
            homePage.clickMobileRechargeButton();
        } else if("Promotion Banner".equals(elementKeyword)) {
            promotionTitleExpected = homePage.getPromotionBannerTitle();
            homePage.clickPromotionBanner();
        } else if("View All Button".equals(elementKeyword)) {
            homePage.clickViewAllButton();
        }
    }

    @Then("User is directed to {string} screen")
    public void userIsDirectedToScreen(String screenName)  {
        if(screenName.equalsIgnoreCase("home")) {
            Assert.assertTrue(homePage.isOnPage());
        } else if(screenName.equalsIgnoreCase("mobile recharge")) {
            Assert.assertTrue(mobileRechargePage.isOnPage());
        } else if(screenName.equalsIgnoreCase("promotion list")) {
            if("true".equalsIgnoreCase(promotionListPage.checkPromotionBanner())) {
                Assert.assertEquals("true",promotionListPage.checkAllPromotionBanner());
                Assert.assertTrue(promotionListPage.isOnPage());
            } else if ("false".equalsIgnoreCase(promotionListPage.checkPromotionBanner())) {
                Assert.assertTrue(promotionListPage.isOnPage());
            }
        } else if(screenName.equalsIgnoreCase("promotion detail")) {
            if("true".equalsIgnoreCase(promotionDetailPage.checkPromotionDetailTitle())) {
                String actual = promotionDetailPage.getPromotionDetailTitle();
                Assert.assertEquals(promotionTitleExpected, actual);
            } else if ("false".equalsIgnoreCase(promotionDetailPage.checkPromotionDetailTitle())) {
                Assert.assertTrue(promotionListPage.isOnPage());
            }
        } else if(screenName.equalsIgnoreCase("device home")){
            String appId = AndroidDriverInstance.androidDriver.getCurrentPackage();
            Assert.assertEquals(AndroidDriverInstance.androidDriver.queryAppState(appId), ApplicationState.RUNNING_IN_BACKGROUND);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        promotionTitleExpected = promotionListPage.getPromotionBannerTitle();
        promotionListPage.clickPromotionBanner();
    }


}
