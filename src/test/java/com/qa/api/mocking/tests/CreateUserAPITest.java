package com.qa.api.mocking.tests;

import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.mock.APIMocks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserAPITest extends BaseTest{
	
	@Test
	public  void  CreateDummyUserTest() {
		APIMocks.CreateDummyUser();
		String dummyJson="{\"name\" : \"Tom\"}";
	Response response=	restClient.post(BASE_URL_LOCALHOST_PORT,"/api/users", dummyJson, null, null, AuthType.NO_AUTH, ContentType.JSON);
		response.then()
		.assertThat()
		.statusCode(201)
		.statusLine("HTTP/1.1 201 user is created")
		.body("id", equalTo(1));
		
		
		
	}
	
	@Test
	public void createDummyUserWithJsonFileTest() {
		APIMocks.createDummyUserWithJsonFile();
		
		String dummyJson = "{\"name\": \"api\"}";
		Response response = restClient.post(BASE_URL_LOCALHOST_PORT, "/api/users", dummyJson, null, null, AuthType.NO_AUTH, ContentType.JSON);
		response.then()
			.assertThat()
				.statusCode(201)
					.statusLine(equalTo("HTTP/1.1 201 user is created"))
					.body("id", equalTo(101));
		
	}

}
