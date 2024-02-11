package tech.klok.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber/report"},
        features = "src/test/resources/features",
        glue = "tech.klok.stepDefinitions"
)
public class Runner {

}
