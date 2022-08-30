package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrderDetailsPage extends BaseTest{

	//Element Locators
	@AndroidFindBy (accessibility = "ORDER #") 
	private MobileElement idOrderNumLbl;
	
    public void waitForOrderNumberLabelToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idOrderNumLbl));
    }
	
//	public OrderDetailsPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
