package com.serenityrestassuredBDD.junit.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.serenityrestassuredBDD.junit.allTypesTest.FirstSerenityTest;
import com.serenityrestassuredBDD.junit.getAllDetails.CreateDataDrivenTest;
import com.serenityrestassuredBDD.junit.getAllDetails.GetMethodDetails;
import com.serenityrestassuredBDD.junit.getAllDetails.TagTest;
import com.serenityrestassuredBDD.junit.getAllDetails.UserCRUDTest;
import com.serenityrestassuredBDD.junit.getAllDetails.UserCRUDTestWithReusableMethod;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	FirstSerenityTest.class,
	GetMethodDetails.class,
	TagTest.class,
	UserCRUDTest.class,
	UserCRUDTestWithReusableMethod.class,
	CreateDataDrivenTest.class
       
})
public class SuiteClasses {
	//normally, this is an empty class
}