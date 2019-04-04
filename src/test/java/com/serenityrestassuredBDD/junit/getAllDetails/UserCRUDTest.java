/**
 * 
 */
package com.serenityrestassuredBDD.junit.getAllDetails;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import com.serenityrestassuredBDD.model.UserDetails;
import com.serenityrestassuredBDD.testbase.BaseTest;
import com.serenityrestassuredBDD.utils.Common;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

/**
 * @author India
 *
 */

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserCRUDTest extends BaseTest{

	static String title="Serenity";
	static String auhtor="Lead";
	static int id=Common.generateRamdom();
	
	@Title("This test will create a User")
	@Test
	public void test001() {
		
		UserDetails objUserDetails= new UserDetails();
		objUserDetails.setTitle(title);
		objUserDetails.setAuthor(auhtor);
		objUserDetails.setId(id);
		
		SerenityRest.rest().given()
			.contentType(ContentType.JSON)
			.log()
			.all()
			.when()
				.body(objUserDetails)
				.post("/posts")
			.then()
				.statusCode(201)
				.log().all();
				
	}
	
	@Title("verify if the user was added to the application")
	@Test
	public void test002() {
		
		HashMap<String,Object> userDetails=SerenityRest.rest().given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
			.get("/posts")
			
		.then()
			.statusCode(200)
			.log()
			.all()
			.extract()
			.path("findAll{it.id=="+id+"}.get(0)");
		System.out.println(userDetails);

		assertThat(userDetails,hasValue(id));
	}

	@Title("Update the particular user and verify the updated details")
	@Test
	public void test003() {
		UserDetails objUserDetails= new UserDetails();
		objUserDetails.setTitle(title+"_updated");
		objUserDetails.setAuthor(auhtor);
		objUserDetails.setId(id);
		
		SerenityRest.rest().given()
			.contentType(ContentType.JSON)
			.log()
			.all()
			.when()
				.body(objUserDetails)
				.put("/posts/"+id)
			.then()
				.log().all();
		
	}
	
	@Title("Delete the user details")
	@Test
	public void test004() {
		
		SerenityRest.rest().given()
			.contentType(ContentType.JSON)
			.log()
			.all()
			.when()
				.delete("/posts/"+id)
			.then()
				.log().all();
		
		SerenityRest.rest().given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
			.get("/posts/"+id)
		.then()
			.statusCode(404)
			.log().all();
	}
	
}
