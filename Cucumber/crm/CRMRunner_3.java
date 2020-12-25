package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@createmeeting",
    strict = true,
	monochrome = true,
	plugin = {"pretty", "html:target/crm/crm_3_result.html"}
)

public class CRMRunner_3 {}
