package com.cucumber

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources/features"],
    glue = ["com.cucumber.stepdefinitions"],
    plugin = ["json:target/cucumber.json"]
)
class RunTest {}
