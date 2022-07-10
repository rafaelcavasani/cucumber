package com.cucumber.stepsdefinition

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import org.json.JSONObject
import org.junit.Assert

class InsertPersonSteps {

    lateinit var response: Response

    @Given("a valid request payload")
    fun getAllPerson() {
        val requestParams = JSONObject()
        requestParams.put("name", "Name")
        requestParams.put("age", 10)
        requestParams.put("last_name", "LastName")
        RestAssured.requestSpecification.body(requestParams.toString());
    }

    @When("call the post endpoint")
    fun validRequest() {
        response = RestAssured.post("/v1/person")
    }

    @Then("return should be {int}")
    fun returnOk(statusCode: Int) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("the person should be find in get endpoint")
    fun personInserted() {
        val jsonString = response.asString()
        val personId: Int = JsonPath.from(jsonString).get("id")
        val getPersonResponse = RestAssured.get("/v1/person/$personId")
        Assert.assertEquals(getPersonResponse.statusCode, 200)
    }
}