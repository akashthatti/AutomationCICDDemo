package TestNGRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Search.feature",glue="stepdefinitions"
,monochrome=true,plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun=false)
public class TestngRunner extends AbstractTestNGCucumberTests
{
	

}
