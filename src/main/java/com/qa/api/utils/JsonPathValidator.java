package com.qa.api.utils;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import io.restassured.response.Response;



public class JsonPathValidator {
	private static String getResponseAsString(Response response) {
		return response.getBody().asString();
		
	}
	
	public static <T> List<T> readList(Response response, String jsonPath) {
	String JsonResponse=	getResponseAsString(response);
	ReadContext ctx = JsonPath.parse(JsonResponse);
	return	ctx.read(jsonPath);
		
	}
	public static <T> List<Map<String,T>> readListOfMaps(Response response, String jsonPath) {
		String JsonResponse=	getResponseAsString(response);
		ReadContext ctx = JsonPath.parse(JsonResponse);
		return	ctx.read(jsonPath);
			
		}
	public static <T> T read(Response response, String jsonPath) {
		String JsonResponse=	getResponseAsString(response);
		ReadContext ctx = JsonPath.parse(JsonResponse);
		return	ctx.read(jsonPath);
			
		}
	

}
