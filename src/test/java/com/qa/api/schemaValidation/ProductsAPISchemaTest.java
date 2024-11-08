package com.qa.api.schemaValidation;

import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ProductsAPISchemaTest extends BaseTest{
	@Test
	
	public void productApiSchemaTest() {
		RestAssured.given()
		.baseUri("https://fakestoreapi.com")
		.when()
		.get("/products")
		.then()
		.assertThat()
		.statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/product-schema.json"));
		
	}

}
