/**
 * 
 */
package com.serenityrestassuredBDD.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

/**
 * @author India
 *
 */
public class BaseTest {
	
	@BeforeClass
	public static void baseURL() {
		RestAssured.baseURI="http://localhost:3000";
	}

}
