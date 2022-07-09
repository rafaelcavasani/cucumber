package com.cucumber.stepsdefinition

import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import org.json.JSONObject
import org.junit.Assert

class InsertPersonSteps {

    private val BASE_URL = "http://localhost:8081"
    lateinit var request: RequestSpecification
    lateinit var response: Response

    @Before
    fun setUp() {
        RestAssured.baseURI = BASE_URL
    }

    @Given("the client wants to insert a person")
    fun getAllPerson() {
        request = RestAssured.given()
        request.header("Content-Type", "application/json")
    }

    @When("the request is valid")
    fun validRequest() {
        val requestParams = JSONObject()
        requestParams.put("name", "Name")
        requestParams.put("age", 10)
        requestParams.put("last_name", "LastName")
        request.body(requestParams.toString());
    }

    @And("call the post endpoint")
    fun callPostEndpoint() {
        response = request.post("/v1/person")
    }

    @Then("return should be {int}")
    fun returnOk(statusCode: Int) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("the person should be find in get endpoint")
    fun personInserted() {
        val jsonString = response.asString()
        val personId: Int = JsonPath.from(jsonString).get("id")
        val getPersonResponse = request.get("/v1/person/$personId")
        Assert.assertEquals(getPersonResponse.statusCode, 200)
    }
}