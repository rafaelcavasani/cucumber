package com.cucumber.steps

import io.restassured.RestAssured.given
import org.json.JSONObject


class PersonSteps {

    fun insertPerson(requestBody: JSONObject) {
        given()
            .contentType("application/json")
            .header("Content-Type", "application/json")
            .body(requestBody)
            .`when`()
            .post("/v1/person")
    }

    fun getPersonById(id: Int) {
        given()
            .contentType("application/json")
            .header("Content-Type", "application/json")
            .`when`()
            .get("/v1/person/$id")
    }
}