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

import com.serenityrestassuredBDD.cucumber.serenity.UserSerenitySteps;
import com.serenityrestassuredBDD.model.UserDetails;
import com.serenityrestassuredBDD.testbase.BaseTest;
import com.serenityrestassuredBDD.utils.Common;
import com.serenityrestassuredBDD.utils.ReuseableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

/**
 * @author India
 *
 */

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserCRUDTestWithReusableMethod extends BaseTest{

	static String title="Serenity";
	static String author="Lead";
	static int id=Common.generateRamdom();
	
	@Steps
	UserSerenitySteps steps;
	
	@Title("This test will create a User with reusable method")
	@Test
	public void test001() {
		steps.createUser(title, author, id)
				.spec(ReuseableSpecifications.getGenericResponseSpec())
				.statusCode(201)
				.log().all();
	}
	
	@Title("verify if the user was added to the application with reusable method")
	@Test
	public void test002() {
		
		HashMap<String,Object> userDetails=steps.getDetailsOfCreatedUser(id);
		assertThat(userDetails,hasValue(id));
	}

	@Title("Update the particular user and verify the updated details with reusable method")
	@Test
	public void test003() {
		Response res=steps.updateTheUserDetails(title, author, id).extract().response();
		assertThat(res.getStatusCode(), equalTo(200));
		
		System.out.println(res.getBody().asString());
		
	}
	
	@Title("Delete the user details with reusable method")
	@Test
	public void test004() {
		steps.deleteTheUserDetails(id)
			.spec(ReuseableSpecifications.getGenericResponseSpec())
			.statusCode(404)
			.log().all();
	}
	
}
