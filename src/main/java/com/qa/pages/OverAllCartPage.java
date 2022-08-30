package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OverAllCartPage extends BaseTest{

	//Element Locators
	@AndroidFindBy (accessibility = "Cart") 
	private MobileElement idCartLbl;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@index='5']") 
	private MobileElement xpathShopCart;
	
	@AndroidFindBy (accessibility = "Check Out Shop") 
	private MobileElement idCheckoutShopBtn;
	
    public void waitForCartLabelToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idCartLbl));
    }
    
    public Boolean verifyPresenceOfCartLabel() {
    	return idCartLbl.isDisplayed();
    }
    
    public Boolean verifyPresenceOfShopCart() {
    	return xpathShopCart.isDisplayed();
    }
    
    public ShopCartPage goToShopCart() throws InterruptedException {
    	Thread.sleep(2000);
    	utils.log().info("Go to Shop Cart");
    	click(xpathShopCart);
    	
    	return new ShopCartPage();
    }
    
    public CheckoutPage goToShopCheckout() {
		if (idCheckoutShopBtn.isDisplayed()) {
			utils.log().info("Proceed on Checkout Page");
			click(idCheckoutShopBtn);
		} else {
			System.out.println("Checkout Shop button is not available. ABORT RUN.");
		}

    	return new CheckoutPage();
    }
	
//    public OverAllCartPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
