package com.qa.api.mocking.tests;

import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.mock.APIMocks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MockDeleteUserAPITest extends BaseTest {
	
	@Test
	public void deleteDummyUserTest() {
		APIMocks.deleteDummyUser();
Response response=		restClient.delete(BASE_URL_LOCALHOST_PORT, "/api/users/1", null, null, AuthType.NO_AUTH	, ContentType.ANY);

response.then()
.assertThat()
.statusCode(204);
		
	}

}
