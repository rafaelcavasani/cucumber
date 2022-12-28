package com.cucumber.stepdefinitions

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert


class Test {

    @Given("test {int}")
    fun test(int1: Int) {
        println(int1)
    }

    @When("test {int} is run")
    fun testIsRun(int1: Int) {
        println(int1)
    }

    @Then("test {int} should be {int}")
    fun testShouldBe(int1: Int, int2: Int) {
        Assert.assertEquals(int1, 1)
    }

}