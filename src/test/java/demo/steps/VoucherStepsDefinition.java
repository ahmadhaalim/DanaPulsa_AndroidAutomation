package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.HomePage;
import demo.pages.VoucherDetailPage;
import demo.pages.VoucherPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VoucherStepsDefinition {

    VoucherPage voucherPage = new VoucherPage();
    HomePage homePage = new HomePage();
    VoucherDetailPage voucherDetailPage = new VoucherDetailPage();

    String voucherTitleExpected = "";

    @When("User click voucher button")
    public void userClickVoucherButton() {
        homePage.clickVoucherButton();
    }

    @Then("User directed to voucher screen")
    public void userDirectedToVoucherScreen() {
        Assert.assertTrue(voucherPage.isOnPage());
    }

    @When("User click {string} button on voucher screen")
    public void userClickButtonOnVoucherScreen(String buttonKeyWord) {
        if ("All".equals(buttonKeyWord)){
            voucherPage.clickAllButton();
        } else if("Discount".equals(buttonKeyWord)){
            voucherPage.clickDiscountButton();
        } else if("Cashback".equals(buttonKeyWord)){
            voucherPage.clickCashbackButton();
        }
    }

    @Then("User see {string} message on voucher screen")
    public void userSeeMessageOnVoucherScreen(String expected) {
        String actual = voucherPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
    }

    @Then("User see voucher banner {string}")
    public void userSeeVoucherBanner(String expected) {
        voucherPage.checkIfVoucherBannerIsDisplayed();
        String actual = voucherPage.getVoucherValue(expected);
        Assert.assertEquals(expected, actual);
    }


    @And("User click voucher banner {string}")
    public void userClickVoucherBanner(String value) {
        voucherTitleExpected = voucherPage.getVoucherValue(value);
        voucherPage.chooseVoucherBanner(value);
    }

    @Then("User directed to voucher detail screen")
    public void userDirectedToVoucherDetailScreen() {
        Assert.assertTrue(voucherDetailPage.isOnPage());
    }

    @When("user click back button on voucher detail screen")
    public void userClickBackButtonOnVoucherDetailScreen() {
        voucherDetailPage.clickBackButton();
    }

    @Then("User see warning {string} on voucher screen")
    public void userSeeWarningOnVoucherScreen(String expected) {
        String actual = voucherPage.getWarningMessage();
        Assert.assertEquals(expected, actual);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }
}
