package com.qa.api.schemaValidation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.api.base.BaseTest;
import com.qa.api.utils.StringUtility;


public class UserAPISchemaTest extends BaseTest {
	@Test	
	public void userAPISchemaTest() {
String jsonFilePath="src/test/resources/schema/user-schema.json";
ObjectMapper mapper=new ObjectMapper();
try {
	mapper.readTree(Files.readAllBytes(Paths.get(jsonFilePath)));
	String UniqueEmailId=StringUtility.getRandomEmailId();
} catch (IOException e) {
	
	
	e.printStackTrace();
}
	
	
	
//	public void UserApiSchemaTest() {
//		RestAssured.given()
//		.baseUri("https://gorest.co.in")
//		.when()
//		.get("/public/v2/users/7495006")
//		.then()
//		.assertThat()
//		.statusCode(200)
//		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/user-schema.json"));
//		
	}
}
