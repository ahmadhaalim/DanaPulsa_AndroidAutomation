package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.ChangePinPage;
import demo.pages.HomePage;
import demo.pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProfileStepsDefinition {

    ProfilePage profilePage = new ProfilePage();
    ChangePinPage changePinPage = new ChangePinPage();

    @Then("User directed to profile screen")
    public void userDirectedToProfileScreen() {
        Assert.assertTrue(profilePage.isOnPage());
    }

    @And("User see phone number  {string} used to signing in on profile screen")
    public void userSeePhoneNumberUsedToSigningInOnProfileScreen(String expected) {
        String actual = profilePage.getPhoneNumber();
        Assert.assertEquals(expected, actual);
    }

    @When("User click change pin menu")
    public void userClickChangePinMenu() {
        profilePage.clickChangePinButton();
    }

    @Then("User directed to change pin screen")
    public void userDirectedToChangePinScreen() {
        Assert.assertTrue(changePinPage.isOnPage());
    }

    @When("User click back button at change pin screen")
    public void userClickBackButtonAtChangePinScreen() {
        changePinPage.clickBackButton();
    }

    @And("User see warning {string} on user data display")
    public void userSeeWarningOnUserDataDisplay(String expected) {
        String actualName = profilePage.getName();
        String actualPhone = profilePage.getPhoneNumber();
        String actualEmail = profilePage.getEmail();
        Assert.assertEquals(actualName, expected);
        Assert.assertEquals(actualPhone, expected);
        Assert.assertEquals(actualEmail, expected);
        AndroidDriverInstance.androidDriver.toggleData();
        AndroidDriverInstance.androidDriver.toggleWifi();
    }

    @Then("User see warning pop up {string}")
    public void userSeeWarningPopUp(String expected) {
        String actual = profilePage.getSignOutWarningMessage();
        Assert.assertEquals(expected, actual);
    }


    @When("User click {string} button on profile screen")
    public void userClickButtonOnProfileScreen(String button) {
        if(button.equalsIgnoreCase("change pin")) {
            profilePage.clickChangePinButton();
        } else if(button.equalsIgnoreCase("sign out")){
            profilePage.clickSignOutButton();
        } else if(button.equalsIgnoreCase("yes")) {
            Assert.assertTrue(profilePage.waitUntilSignOutPopUpMessageIsShown());
            profilePage.clickYesButton();
        } else if(button.equalsIgnoreCase("no")) {
            Assert.assertTrue(profilePage.waitUntilSignOutPopUpMessageIsShown());
            profilePage.clickNoButton();
        }
    }
}
