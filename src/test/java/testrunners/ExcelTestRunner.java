package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome = true,
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"},
		features = {"src/test/resources/Appfeatures/AddCustomer.feature"}
		)

public class ExcelTestRunner{

}

/**
 To run in parallel mode on junit 
 remove all testng dependencies
 and run with pom.xml file by commenting surefireplugin and run with filesafe plugin (cmd: mvn clean verify)
 Note: Junit execute parallel mode only in feature level not at senario level 
 **/