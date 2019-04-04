/**
 * 
 */
package com.serenityrestassuredBDD.junit.allTypesTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

/**
 * @author India
 *
 */

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

	
	@BeforeClass
	public static void init() {
		
		RestAssured.baseURI="https://reqres.in/";
		
	}
	
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
	
	@Pending
	@Test
	public void pendingTest() {
		
	}
	
	@Manual
	@Test
	public void manualTest() {
		
	}
	
	@Ignore
	@Test
	public void ignoreTest() {
		
	}
	
	@Test
	public void errorTest() {
		
		System.out.println("this is error test:"+(5/0));
		
	}
	
	@Test
	public void fileDoesNotExist() throws FileNotFoundException {
		
		File file= new File("e://file.txt");
		FileReader fr= new FileReader(file);
		
	}
	
	
	
	
	
	
}
