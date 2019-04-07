Feature: Testing different requests on the user application

@smoke
Scenario: Check if the user application can be accessed by users
	
	Given user hits the application end url as "https://reqres.in/"
	When user sends a GET request to teh list endpoint, they must get back as valid code 200