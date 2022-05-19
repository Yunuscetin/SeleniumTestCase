import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/LoginPage.feature", glue = {"StepDefinitions"},
        monochrome = true
)
public class TestRunner {

}

