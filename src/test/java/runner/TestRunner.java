package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"},
monochrome=true,
plugin = {"pretty","junit:target/JUnitReport/report.xml",
		//"json:target/JSONReports/report.json",
		"html:target/HtmlReports/report.html"},
tags ="@FeatureSearch")

public class TestRunner {
	
	

}
