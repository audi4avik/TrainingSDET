package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@createproduct",
    strict = true,
	monochrome = true,
	plugin = {"pretty", "html:target/crm/crm_4_result.html"}
)

public class CRMRunner_4 {}
