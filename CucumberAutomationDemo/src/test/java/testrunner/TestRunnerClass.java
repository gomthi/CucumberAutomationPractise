package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\gomathi\\eclipse-workspace\\CucumberAutomationDemo\\src\\test\\java\\automation.feature",glue="stepdefinition")
public class TestRunnerClass {

}
