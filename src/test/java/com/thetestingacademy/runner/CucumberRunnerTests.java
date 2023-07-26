package com.thetestingacademy.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "",
        features = {"src/test/resources/features/VWOLogin.feature"},
        glue = {"com.thetestingacademy.definitions"},
        plugin = { "pretty", "html:target/cucumber-reports.html"}
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}

