package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseTest {
	
	//Element Locators
	@AndroidFindBy (accessibility = "Shop Now") 
	private MobileElement idShopNowBtnInWelcomeModal;
	
	@AndroidFindBy (accessibility = "Learn More") 
	private MobileElement idLearnMoreBtn;
	
	@AndroidFindBy (accessibility = "Food") 
	private MobileElement idFoodCateg;
	
	@AndroidFindBy (accessibility = "Shops") 
	private MobileElement idShopsCateg;
	
	@AndroidFindBy (accessibility = "What are you shopping for today?") 
	private MobileElement idSearchBox;
	
	@AndroidFindBy (accessibility = "CART\n"
			+ "Tab 3 of 4") private MobileElement idCartMenuBtn;
	@AndroidFindBy (accessibility = "ACCOUNT\n"
			+ "Tab 4 of 4") private MobileElement idAccount;
    
    //Actions to be done in form of methods
    public void waitForWelcomeModalToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idShopNowBtnInWelcomeModal));
    }
    
    public Boolean verifyPresenceOfWelcomeModal() {
    	return idShopNowBtnInWelcomeModal.isDisplayed();
    }
    
    public void waitForModalToClose(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idSearchBox));
    }
    
    public Boolean verifyPresenceOfHomepageSearch() {
    	return idSearchBox.isDisplayed();
    }
    
    public String getTextFromSearchBox() {
    	return getAttribute(idSearchBox, "content-desc").toString();
    }
    
    public HomePage closeWelcomeModal() {
//    	utils.log().info("Click the Shop Now button on the Welcome Modal");
    	click(idShopNowBtnInWelcomeModal, "Click the Shop Now button on the Welcome Modal");
    	return this;
    }
    
    public void clearBanner() {
    	if (idLearnMoreBtn.isDisplayed()) {
    		utils.log().info("Close the banner");
    		click(idLearnMoreBtn);
    	    ((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    	} else {
    		System.out.println("No banner.");
    	}
    }
    
    public void waitForShopsCategToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idShopsCateg));
    }
    
    public Boolean verifyPresenceOfShopsCateg() {
    	return idShopsCateg.isDisplayed();
    }
    
    public Boolean verifyPresenceOfCartMenu() {
    	return idCartMenuBtn.isDisplayed();
    }

    public FoodPage goToFoodPage() {
    	utils.log().info("Go to Food Page");
    	click(idFoodCateg);
    	return new FoodPage();
    }
    public ShopsPage goToShopsPage() {
    	utils.log().info("Go to Shops Page");
    	click(idShopsCateg);
    	return new ShopsPage();
    }
    
    public AccountPage goToAccount() {
    	utils.log().info("Go to ACCOUNT Page");
    	click(idAccount);
    	return new AccountPage();
    }
    
    public OverAllCartPage goToCartPage() {
    	utils.log().info("Go to CART Page");
    	click(idCartMenuBtn);
    	return new OverAllCartPage();
    }
    
//    public HomePage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
    
}
