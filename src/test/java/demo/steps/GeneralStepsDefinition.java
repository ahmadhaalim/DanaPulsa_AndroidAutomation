package demo.steps;

import demo.driver.AndroidDriverInstance;
import demo.pages.SignInPage;
import deviceutilities.AndroidDeviceUtilities;
import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GeneralStepsDefinition{

    AndroidDeviceUtilities androidDeviceUtilities = new AndroidDeviceUtilities();
    SignInPage signInPage = new SignInPage();

    @When("User click device home button")
    public void userClickDeviceHomeButton() {
        androidDeviceUtilities.pressDeviceHomeButton();
    }
    @When("User click device back button")
    public void userClickDeviceBackButton() {
        androidDeviceUtilities.pressDeviceBackButton();
    }
    @When("User open the app after running in the background for a moment")
    public void userOpenTheAppAfterRunningInTheBackgroundForAMoment() throws InterruptedException {
        androidDeviceUtilities.runAppInBackground();
    }

    //@When("User copy and paste clipboard data {string} on {string}")
    public void userCopyAndPasteClipboardDataOn(String clipData, String screen){
        String clipboardData = androidDeviceUtilities.setAndGetClipboardData(clipData);
        if(screen.equalsIgnoreCase("Sign In Screen")) {
            signInPage.inputPhoneNumber(clipboardData);
        }
    }

    //@Then("User see input field is not empty on {string}")
    public void userSeeInputFieldIsNotEmptyOn(String field) {
        if(field.equalsIgnoreCase("Input Phone Number at Sign Screen")){
            String actual = signInPage.getInputPhoneNumberData();
            Assert.assertEquals("HALO", actual);
        }
    }
}
