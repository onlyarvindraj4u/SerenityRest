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
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

/**
 * @author India
 *
 */

@RunWith(SerenityRunner.class)
public class TagTest {
	
	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI="https://reqres.in/";
		
	}
	
	@WithTag("UserFeature:Negative")
	@Title("Provide the 404 status code when incorrect HTTP method is used to access a resource--Negative test")
	@Test
	public void getMethod() {
		
		SerenityRest.given()
			.when()
				.post("/api/users?page=2")
				.then()
				.statusCode(415)
				.log().all();
		
		
	}
	
	
	@WithTags(
			{
				@WithTag("UserFeature:Smoke"),
				@WithTag("UserFeature:Positive")
			}
		)
	
	@Title("This test validate the status code is 200 for GET request")
	@Test
	public void verifyIfStatusCodeIs200() {
		
		SerenityRest.given()
			.when()
				.get("/api/users?page=2")
				.then()
				.statusCode(200)
				.log().all();
		
	}
	
	
	@WithTags(
				{
					@WithTag("UserFeature:Smoke"),
					@WithTag("UserFeature:Negative")
				}
			)
	
	@Title("This test will provide an error code 404 when user tries to access an invalid resource--Negative test")
	@Test
	public void incorretRespource() {
		
		SerenityRest.given()
			.when()
				.get("/apis/users?page=2")
				.then()
				.statusCode(404)
				.log().all();
	}

}
