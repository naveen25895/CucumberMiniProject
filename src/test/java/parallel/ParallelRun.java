package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/parallel/LoginPage.feature"},
		glue = {"parallel"},
        tags = "not @Skip", // or cam be use "~@Skip"
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt"},
		monochrome = true		
		)

public class ParallelRun extends AbstractTestNGCucumberTests{
	   
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios()
	{
		return super.scenarios();
	}

}

/**
 TestNG Run
 TestNG: Supports parallel level execution in scenario level also (Plugin surefire)
 Change in folder structure 
 1:(Stepdefinition & Applicationhook files should be in same(parallel) package) (not as junit merge to package)
 2:Runner should be in same package and extends AbstractTestNGCucumberTests(parallel)
 3:Remove runwith @anotation from cucumber option
 4:add dataprovider with parallel mode true
 5:Add folder:glue as parallel(because merge of junit folder structure) refer testng documentation
 6:Create folder:parallel in resource folder and add cucumber feature files
 
 Using @Tag to skip the scenario
 1:add tags in @CucumberOptions plugin to skip scenario
 cmd : mvn test -DCucumber.options="--tags '@Login and not @Skip'" -->  include login exclude skip
 

 **/
