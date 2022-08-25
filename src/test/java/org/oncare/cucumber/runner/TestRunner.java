package org.oncare.cucumber.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {
                "org.oncare.cucumber.stepDef",
                "org.oncare.cucumber.hooks"
        },
        plugin = {
                "json:target/reports/cucumber/cucumber.json",
                "html:target/reports/cucumber/cucumber.html"
        }
)
public class TestRunner {
}
