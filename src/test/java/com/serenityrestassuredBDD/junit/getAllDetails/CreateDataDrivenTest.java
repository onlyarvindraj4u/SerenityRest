package com.serenityrestassuredBDD.junit.getAllDetails;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.serenityrestassuredBDD.cucumber.serenity.UserSerenitySteps;
import com.serenityrestassuredBDD.testbase.BaseTest;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

@Concurrent(threads="4x")
@UseTestDataFrom("testdata/userDetails.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateDataDrivenTest extends BaseTest{
	
	@Steps
	 UserSerenitySteps objUserSerenitySteps;
	
	String title;
	String author;
	int id;
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Title("DataDriven test for adding multiple user.")
	@Test
	public void createMultipleUser() {
		
		objUserSerenitySteps.createUser(title, author, id)
		.statusCode(201)
		.log().all();
	}

}
