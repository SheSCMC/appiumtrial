package com.qa.pages;

import com.qa.main.BaseTest;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ShopsPage extends BaseTest{

	//Element Locators
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]") 
	private MobileElement xpathBackBtn;
	
	@AndroidFindBy (accessibility = "Shops") 
	private MobileElement idShopsLbl;
	
	@AndroidFindBy (accessibility = "Adidas") 
	private MobileElement idAdidasStore;
	
	@AndroidFindBy (accessibility = "Acer") 
	private MobileElement idAcerStore;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().description(\"Filbars\"))") private MobileElement filbarsStore;
	
    public Boolean verifyPresenceOfShopsLbl() {
    	return idShopsLbl.isDisplayed();
    }
    
    public BrandPage goToStore() {
    	utils.log().info("Go to the Adidas Store/Brand");
    	click(idAdidasStore);

    	return new BrandPage();
    }
    
    public BrandPage goToStore2() {
    	utils.log().info("Go to the Acer Store/Brand");
    	click(idAcerStore);

    	return new BrandPage();
    }
    
    public BrandPage goToStore3() {
    	utils.log().info("Go to the Filbars Store/BRand");
    	click(filbarsStore);

    	return new BrandPage();
    }
    
    public HomePage goBackToHomePage() {
    	utils.log().info("Go back to Homepage");
    	click(xpathBackBtn);
    	
    	return new HomePage();
    }
	
//    public ShopsPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
