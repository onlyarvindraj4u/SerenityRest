package com.serenityrestassuredBDD.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;

public class UserStepDefs {

	@When("^user sends a GET request to teh list endpoint, they must get back as valid code 200$")
	public void verifyStatusCode200() {
		
		SerenityRest.rest().given()
				.log()
				.all()
				.when()
					.get("/api/users?page=2")
					.then()
					.statusCode(200)
					.log()
					.all();
	}
	
	@Given("^user hits the application end url as \"([^\"]*)\"$")
	public void user_hits_the_application_end_url_as(String endPoint) {
		
		RestAssured.baseURI=endPoint;
	}
}
