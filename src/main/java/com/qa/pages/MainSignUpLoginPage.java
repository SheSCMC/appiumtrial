package com.qa.pages;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainSignUpLoginPage extends BaseTest{

	//Element Locators
	@AndroidFindBy (accessibility = "Welcome to \n"
			+ "SM Malls Online!") private MobileElement idWelcomeToSMTitle;
	
	@AndroidFindBy (accessibility = "Sign up") 
	private MobileElement idSignUpLbl;
	
    public Boolean verifyPresenceOfWelcomeMessage() {
    	waitForVisibility(idWelcomeToSMTitle);
    	return idWelcomeToSMTitle.isDisplayed();
    }
    
    public Boolean verifyPresenceOfSignUpLbl() {
    	return idSignUpLbl.isDisplayed();
    }
	
//    public MainSignUpLoginPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
