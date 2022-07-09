package com.cucumber

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
	features = ["src/main/resources/features"],
	glue = ["com.cucumber.stepsdefinition"]
)
class Runner