package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@addcandidate",
    strict = true,
	monochrome = true,
	plugin = {"pretty", "html:target/hrm/hrm_2_result.html"}
)

public class HRMRunner_2 {}
