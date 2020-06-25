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

    @And("User see phone number  {string} used to signing in on profile screen")
    public void userSeePhoneNumberUsedToSigningInOnProfileScreen(String expected) {
        String actual = profilePage.getPhoneNumber();
        Assert.assertEquals(expected, actual);
    }

    @Then("User directed to change pin screen")
    public void userDirectedToChangePinScreen() {
        Assert.assertTrue(changePinPage.isOnPage());
    }

    @When("User tap {string} button on profile screen")
    public void userTapButtonOnProfileScreen(String button) {
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

    @Then("User see profile data is displayed")
    public void userSeeProfileDataIsDisplayed() {
        Assert.assertNotNull(profilePage.getName());
        Assert.assertNotNull(profilePage.getEmail());
        Assert.assertNotNull(profilePage.getPhoneNumber());
    }

}
