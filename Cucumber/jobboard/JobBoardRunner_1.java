package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@createuser",
    strict = true,
	monochrome = true,
	plugin = {"pretty", "html:target/jobboard/jobboard_1_result.html"}
)

public class JobBoardRunner_1 {}
