package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrderTrackerPage extends BaseTest {

	//Element Locators
	@AndroidFindBy (accessibility = "Ongoing") 
	private MobileElement idOngoingTab;
	
	@AndroidFindBy (xpath = "//android.view.View[@index='0']") 
	private MobileElement xpathFirstOrderCard;
	
	@AndroidFindBy (accessibility = "HOME\n"
			+ "Tab 1 of 4") private MobileElement idHomeBtn;
	
    public void waitForOngoingTabToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idOngoingTab));
    }
    
    public void waitForOrderCardToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idOngoingTab));
    }
    
    public Boolean verifyPresenceOfOngoingTab() {
    	return idOngoingTab.isDisplayed();
    }
    
    public OrderDetailsPage goToOrderDetailsPage() {
    	utils.log().info("Click the Ongoing Tab");
    	click(idOngoingTab);
    	
    	return new OrderDetailsPage();
    }
    
    public HomePage goToHomepage() {
    	utils.log().info("Go to Homepage");
    	click(idHomeBtn);
    	
    	return new HomePage();
    }
	
//	public OrderTrackerPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}	
