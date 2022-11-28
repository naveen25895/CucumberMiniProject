package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"@target/failedrerun.txt"},
		glue = {"parallel"},
		plugin = {"pretty",
				"rerun:target/failedrerun.txt"},
		monochrome = true		
		)

public class FailedRun extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios()
	{
		return super.scenarios();
	}
	
}

/**
 Failed Rerun configuration
 1:plugin-->rerun:target/failedrerun.txt to save the failure testcase
 2:Create @cucumberOptions file with target name as saved failedrerun.txt file
 3:run the java class to execute
 **/
