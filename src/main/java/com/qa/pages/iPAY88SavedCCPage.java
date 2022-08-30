package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class iPAY88SavedCCPage extends BaseTest {
	
	//Element Locators
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View") 
	private MobileElement xpathPageTitle;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[5]/android.widget.EditText") 
	private MobileElement xpathCVCField;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[7]/android.widget.CheckBox") 
	private MobileElement xpathAuthorizeCheckbox;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.ListView/android.view.View[8]/android.widget.Button[1]") 
	private MobileElement xpathProceedBtn;
			
    //Actions to be done in form of methods
	public Boolean verifyPresenceOfPageTitle() {
    	return xpathPageTitle.isDisplayed();
    }
	
    public void waitForCVCFieldToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(xpathCVCField));
    }
    
    public iPAY88ACSPage inputCCDetails(String cvv) {
    	utils.log().info("Input the CVC/CVV value");
    	sendKeys(xpathCVCField, cvv);
    	utils.log().info("Proceed with the payment process to complete the checkout");
    	click(xpathAuthorizeCheckbox);
    	click(xpathProceedBtn);

		return new iPAY88ACSPage();
    }
	
//    public iPAY88SavedCCPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
