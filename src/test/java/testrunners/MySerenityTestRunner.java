package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/resources/Appfeatures/LoginPage.feature"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty"}
		)

public class MySerenityTestRunner {

}

/**
 Used to run Serenity report
 1: Added serenity dependency and plugin
 **/
