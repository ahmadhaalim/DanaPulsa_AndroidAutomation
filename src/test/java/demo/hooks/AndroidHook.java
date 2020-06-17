package demo.hooks;
import demo.driver.AndroidDriverInstance;
import demo.pages.ProfilePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AndroidHook {


    @Before(value = "@Android")
    public void initializeWebDriver() {
        AndroidDriverInstance.initialize();
    }

    @After(value = "@Android")
    public void quitWebDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario
                    .embed(((TakesScreenshot) AndroidDriverInstance.androidDriver)
                                    .getScreenshotAs(OutputType.BYTES),
                            "image/png");
            scenario.write("Scenario Fail");
        }
        AndroidDriverInstance.quit();
    }
}
