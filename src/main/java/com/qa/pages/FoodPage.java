package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FoodPage extends BaseTest {
	
	//Element Locators
	@AndroidFindBy (accessibility = "Food") 
	private MobileElement idFoodLbl;
	
	@AndroidFindBy (accessibility = "Abe") 
	private MobileElement idAbeStore;
	
    public Boolean verifyPresenceOfFoodLbl() {
    	return idFoodLbl.isDisplayed();
    }
    
    public void waitForStoreToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idAbeStore));
    }
	
    public BrandPage goToStore() {
    	utils.log().info("Go to Store Page");
    	click(idAbeStore);
    	return new BrandPage();
    }
    
//    public FoodPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
