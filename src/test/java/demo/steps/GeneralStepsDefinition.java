package demo.steps;

import deviceutilities.AndroidDeviceUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class GeneralStepsDefinition extends AndroidDeviceUtilities {

    @When("User click device home button")
    public void userClickDeviceHomeButton() {
        pressDeviceHomeButton();
    }
    @When("User click device back button")
    public void userClickDeviceBackButton() {
        pressDeviceBackButton();
    }
    @When("User lock the device")
    public void userLockTheDevice() {
        lockDevice();
    }
    @And("User unlock the device")
    public void userUnlockTheDevice() {
        unlockDevice();
    }
    @When("User open the app after running in the background for a moment")
    public void userOpenTheAppAfterRunningInTheBackgroundForAMoment() throws InterruptedException {
        runAppInBackground();
    }
}
