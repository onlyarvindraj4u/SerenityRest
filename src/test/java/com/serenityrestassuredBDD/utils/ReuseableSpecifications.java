/**
 * 
 */
package com.serenityrestassuredBDD.utils;

import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author India
 *
 */
public class ReuseableSpecifications {
	
	public static RequestSpecBuilder rspecBuilder;
	public static RequestSpecification requestSpecification;
	
	public static ResponseSpecBuilder resSpecBuilder;
	public static ResponseSpecification responseSpecification;
	
	public static RequestSpecification getGenericRequestSpec() {
		rspecBuilder= new RequestSpecBuilder();
		rspecBuilder.setContentType(ContentType.JSON);
		requestSpecification=rspecBuilder.build();
		
		return requestSpecification;
	}

	public static ResponseSpecification getGenericResponseSpec() {
		resSpecBuilder= new ResponseSpecBuilder();
		resSpecBuilder.expectHeader("Content-type", "application/json; charset=utf-8");
		resSpecBuilder.expectHeader("Transfer-Encording", "chunked");
		resSpecBuilder.expectResponseTime(lessThan(10L),TimeUnit.SECONDS);
		
		responseSpecification=resSpecBuilder.build();
		return responseSpecification;
		
	}
}
