package cucumberRunners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@ExtendedCucumberOptions(jsonReport = "target/features/Cucumber.json",
retryCount = 0,
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = true,
coverageReport = true,
//jsonUsageReport = "target/cucumber-usage.json",
//usageReport = true,
featureOverviewChart = true,
toPDF = true,
excludeCoverageTags = {"@flaky" },
includeCoverageTags = {"@passed" },
outputFolder = "target/features/reports/")


@CucumberOptions( 
		format ={ "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		features = {"src/test/resources/"},
		glue = {"stepdefinition"},
		tags= {"@TC01,@TC02,@TC03,@TC04"})


public class TestRunner_gist {
}
