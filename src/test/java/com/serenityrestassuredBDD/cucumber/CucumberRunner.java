package com.serenityrestassuredBDD.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-html-report"},
		features="src/test/resources/feature/"
		)
public class CucumberRunner {
	
	

}
