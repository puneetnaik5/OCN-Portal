package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/Feature/login.feature",
        glue = {"StepDefinations", "Hooks"},
        tags = "@sanity",
        plugin ={"pretty", "me.jvt.cucumber.report.PrettyReports:target/Report"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

