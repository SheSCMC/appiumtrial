package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutPage extends BaseTest{
	
	//Element Locators
	@AndroidFindBy (accessibility = "Checkout") 
	private MobileElement idCheckoutLbl;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[6]") 
	private MobileElement xpathFulfillmentBtnNoScroll;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[6]") 
	private MobileElement xpathFulfilmmentBtnWithScroll;
	
	@AndroidFindBy (accessibility = "Continue") 
	private MobileElement idContinueBtn;
	
	@AndroidFindBy (xpath = "//android.view.View[@index='6']") 
	private MobileElement xpathSeeDetails;
		
    public Boolean verifyPresenceOfChekcoutLbl() {
    	return idCheckoutLbl.isDisplayed();
    }
    
    public void waitForContinueButtonToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idContinueBtn));
    }
    
    public void waitForFulfillmentButtonToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(xpathFulfilmmentBtnWithScroll));
    }
    
    public Boolean verifyPresenceOfFulfillmentButton() {
    	return xpathFulfilmmentBtnWithScroll.isDisplayed();
    }
	
    public ChangeFulfillmentMethodPage goToFulfillmentMethodPageViaBuyNow() {
    	click(xpathFulfillmentBtnNoScroll);
    	return new ChangeFulfillmentMethodPage();
    }
    
    public ChangeFulfillmentMethodPage goToFulfillmentMethodPageForMultiple() {
    	click(xpathFulfilmmentBtnWithScroll);
    	return new ChangeFulfillmentMethodPage();
    }
    
    public void seeAmountDetails() throws InterruptedException {
    	Thread.sleep(2000);
    	utils.log().info("Click the 'See Details'");
    	click(xpathSeeDetails);
    }
    
    public PaymentMethodPage goToPaymentMethodPage() {
    	utils.log().info("Proceed to Payment Method Page");
    	click(idContinueBtn);
    	return new PaymentMethodPage();
    }
    
//    public CheckoutPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
