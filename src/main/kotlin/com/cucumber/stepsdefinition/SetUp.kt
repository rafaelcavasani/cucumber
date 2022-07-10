package com.cucumber.stepsdefinition

import com.cucumber.utils.AppUtils
import cucumber.api.java.Before
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.http.ContentType

class SetUp {

    @Before
    fun setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssured.baseURI = AppUtils.BASE_URL
        RestAssured.requestSpecification = RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .build()
        RestAssured.responseSpecification = ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .build()
    }

}