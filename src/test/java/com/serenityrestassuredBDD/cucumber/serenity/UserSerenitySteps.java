/**
 * 
 */
package com.serenityrestassuredBDD.cucumber.serenity;

import java.util.HashMap;

import com.serenityrestassuredBDD.model.UserDetails;
import com.serenityrestassuredBDD.utils.ReuseableSpecifications;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSerenitySteps {
	
	@Step("Creating the user with all manadatory details title:{0}, author:{1}, id:{2}")
	public ValidatableResponse createUser(String title, String author, int id ) {
		
		UserDetails objUserDetails= new UserDetails();
		objUserDetails.setTitle(title);
		objUserDetails.setAuthor(author);
		objUserDetails.setId(id);
		
		return SerenityRest.rest().given()
			.spec(ReuseableSpecifications.getGenericRequestSpec())
			.log()
			.all()
			.when()
				.body(objUserDetails)
				.post("/posts")
			.then();
	}
	
	@Step("Getting user detials based on the id:{0}")
	public HashMap<String,Object> getDetailsOfCreatedUser(int id){
		return SerenityRest.rest().given()
				.spec(ReuseableSpecifications.getGenericRequestSpec())
				.log()
				.all()
				.when()
					.get("/posts")
				.then()
					.extract()
					.path("findAll{it.id=="+id+"}.get(0)");
		
	}
	
	@Step("Update the user details latest field values based on the id:{0}")
	public ValidatableResponse updateTheUserDetails(String title, String author, int id) {
		
		UserDetails objUserDetails= new UserDetails();
		objUserDetails.setTitle(title+"_updated");
		objUserDetails.setAuthor(author);
		objUserDetails.setId(id);
		
		return SerenityRest.rest().given()
				.spec(ReuseableSpecifications.getGenericRequestSpec())
			.when()
				.body(objUserDetails)
				.put("/posts/"+id)
			.then();
	}
	
	@Step("Delete the user details based on the id:{0}")
	public ValidatableResponse deleteTheUserDetails(int id) {
		
		SerenityRest.rest().given()
		.spec(ReuseableSpecifications.getGenericRequestSpec())
		.when()
			.delete("/posts/"+id)
		.then();
	
	return SerenityRest.rest().given()
			.spec(ReuseableSpecifications.getGenericRequestSpec())
			.when()
				.get("/posts/"+id)
			.then();
	}

}
