package com.qa.products.api.tests;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;
import com.qa.api.pojo.Product;
import com.qa.api.utils.JsonUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProductAPITestWithDeserialization extends BaseTest{
	
	@Test
	public void getProductsTest() {
	Response response=	restClient.get(BASE_URL_PRODUCT ,"/products", null, null, AuthType.NO_AUTH, ContentType.JSON);
	Assert.assertEquals(response.statusCode(), 200);
Product[] product=	JsonUtils.deserialize(response, Product[].class);

System.out.println(Arrays.toString(product));
for(Product p:product) {
	System.out.println("Id is"+p.getId());
	System.out.println("title"+p.getTitle());
	System.out.println("rate "+p.getRating().getRate());
	}


}
}