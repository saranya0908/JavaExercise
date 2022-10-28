package com.gmail.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/features/gmail.feature",
		glue="com.gmail.stepdefinition",
		plugin = {"pretty", "html:report/TodayReport.html"}
)
public class Runner {

}
