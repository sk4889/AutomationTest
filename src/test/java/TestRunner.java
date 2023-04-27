import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "Features",glue={"StepDefinition"},plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true)
class Runner
{

}
