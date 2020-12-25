package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@jobapply",
    strict = true,
	monochrome = true,
	plugin = {"pretty", "html:target/jobboard/jobboard_2_result.html"}
)

public class JobBoardRunner_2 {}
