/**
 * 
 */
package com.serenityrestassuredBDD.junit.getAllDetails;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

/**
 * @author India
 *
 */

@RunWith(SerenityRunner.class)
public class GetMethodDetails {

	
	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI="https://reqres.in/";
		
	}
	
	@Title("This test will get the all user list successfully")
	@Test
	public void getMethod() {
		
		SerenityRest.given()
			.when()
				.get("/api/users?page=2")
				.then()
				.statusCode(200)
				.log().all();
		
	}
	
	@Test
	public void failedTestCase() {
		
		SerenityRest.given()
			.when()
				.get("/api/users?page=2")
				.then()
				.statusCode(500)
				.log().all();
	}
	
}
