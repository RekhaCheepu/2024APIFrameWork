package com.qa.contacts.api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.manager.ConfigManager;
import com.qa.api.pojo.ContactsCredentials;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ContactsAPITest extends BaseTest {
	private String tokenId;
	@BeforeMethod
	public void getToken() {
		ContactsCredentials cred=	 ContactsCredentials.builder()
				.email("rekha.cheepu@gmail.com")
				.password("Aut0m@t!on")
				.build();
		 
	Response response=	 restClient.post(BASE_URL_CONTACTS,"/users/login", cred, null, null, AuthType.NO_AUTH	, ContentType.JSON);
	
	tokenId =response.jsonPath().getString("token");
	System.out.println("token id is==>"+tokenId);
	ConfigManager.set("contacts_bearer_Token", tokenId);
	}
	@Test
	public void getContactsTest() {
	Response response=restClient.get(BASE_URL_CONTACTS,"/contacts", null, null, AuthType.CONTACTS_BEARER_TOKEN, ContentType.JSON);
	Assert.assertEquals(response.getStatusCode(), 200);
	}

}
