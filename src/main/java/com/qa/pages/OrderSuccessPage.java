package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrderSuccessPage extends BaseTest {

	//Element Locators
	@AndroidFindBy (accessibility = "Confirmation") 
	private MobileElement idConfirmationLbl;
	
	@AndroidFindBy (accessibility = "Track Order") 
	private MobileElement idTrackOrderBtn;
    
    public Boolean verifyPresenceOfOrderTrackerButton() {
    	waitForVisibility(idTrackOrderBtn);
    	return idTrackOrderBtn.isDisplayed();
    }
    
    public void waitForOrderTrackerButtonToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idTrackOrderBtn));
    }
    
    public String getConfirmationText() {
    	String label = idConfirmationLbl.getText();
    	return label;
    }
    
    public OrderTrackerPage goToOrderTrackerPage() {
    	utils.log().info("Go to Order Tracker Page");
    	click(idTrackOrderBtn);

    	return new OrderTrackerPage();
    }

//	public OrderSuccessPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
