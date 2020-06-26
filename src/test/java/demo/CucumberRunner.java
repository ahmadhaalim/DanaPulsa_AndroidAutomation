package demo;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"json:build/cucumber.json", "pretty", "html:build/result"},
        features = {"src/test/resources/features"},
        tags = {"@FP-OTP_004"}
)
public class CucumberRunner {
}
