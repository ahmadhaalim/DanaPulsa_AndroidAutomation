package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.VoucherDetailPage;
import demo.pages.VoucherPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VoucherStepsDefinition {

    VoucherPage voucherPage = new VoucherPage();
    VoucherDetailPage voucherDetailPage = new VoucherDetailPage();

    String expectedName = "";

    @When("User tap {string} button on voucher screen while internet is {string}")
    public void userTapButtonOnVoucherScreen(String button, String state) {
        if(state.equalsIgnoreCase("off")){
            //AndroidDriverInstance.androidDriver.toggleWifi();
            AndroidDriverInstance.androidDriver.toggleData();
        }
        if ("All".equals(button)){
            voucherPage.clickAllButton();
        } else if("Discount".equals(button)){
            voucherPage.clickDiscountButton();
        } else if("Cashback".equals(button)){
            voucherPage.clickCashbackButton();
        }
    }

    @Then("User see {string} message on voucher screen")
    public void userSeeMessageOnVoucherScreen(String expected) throws InterruptedException {
        Thread.sleep(5000);
        String actual = voucherPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }

    @Then("User see voucher banner {string}")
    public void userSeeVoucherBanner(String expected) {
        voucherPage.waitUntilVoucherBannerDisplayed();
        String actual = voucherPage.getVoucherName(expected);
        Assert.assertEquals(expected, actual);
    }

    @And("User tap voucher banner {string} while internet is {string}")
    public void userTapVoucherBanner(String value, String state) {
        Assert.assertTrue(voucherPage.waitUntilVoucherBannerDisplayed());
        if(state.equalsIgnoreCase("off")){
            AndroidDriverInstance.androidDriver.toggleData();
            //AndroidDriverInstance.androidDriver.toggleWifi();
        }
        expectedName = voucherPage.getVoucherName(value);
        voucherPage.chooseVoucherBanner(value);
    }

    @Then("User see warning {string} on voucher screen")
    public void userSeeWarningOnVoucherScreen(String expected) {
        String actual = voucherPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        //AndroidDriverInstance.androidDriver.toggleWifi();
    }

    @Then("User see warning {string} on voucher detail screen")
    public void userSeeWarningOnVoucherDetailScreen(String expected) {
        String actual = voucherDetailPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        //AndroidDriverInstance.androidDriver.toggleWifi();
    }

    @Then("User is on {string} screen")
    public void userIsOnScreen(String screen) throws InterruptedException {
        Thread.sleep(5000);
        if(screen.equalsIgnoreCase("voucher")){
            Assert.assertTrue(voucherPage.isOnPage());
        } else if (screen.equalsIgnoreCase("voucher detail")) {
            Assert.assertTrue(voucherDetailPage.isOnPage());
            String actualValue = voucherDetailPage.getVoucherName();
            Assert.assertEquals(expectedName, actualValue);
        }
    }

    @Then("User see {string} banner list")
    public void userSeeBannerList(String expected) {
        Assert.assertTrue(voucherPage.waitUntilVoucherBannerDisplayed());
        String actual = voucherPage.getVoucherTitle(expected);
        Assert.assertEquals(expected, actual);
    }

    @Then("User see voucher {string} dismissed")
    public void userSeeVoucherDismissed(String expected) {
        voucherPage.waitUntilVoucherBannerDisplayed();
        String actual = voucherPage.getVoucherName(expected);
        Assert.assertNotEquals(expected, actual);
    }
}
