package demo;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"json:build/cucumber.json", "pretty", "html:build/result"},
        features = {"src/test/resources/features"},
        tags = {"@CP-CPN_005 or @CP-CPN_006"}
)
public class CucumberRunner {
}
