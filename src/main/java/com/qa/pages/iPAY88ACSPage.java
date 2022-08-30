package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class iPAY88ACSPage extends BaseTest{
	
	//Element Locators
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[12]/android.view.View/android.widget.Button") 
	private MobileElement xpathSubmitBtn;
	
    //Actions to be done in form of methods
    public void waitForSubmitBtnToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(xpathSubmitBtn));
    }
    
    public OrderSuccessPage completeCCCheckout() {
    	utils.log().info("Click the Submit button to complete the checkout process");
    	click(xpathSubmitBtn);
		return new OrderSuccessPage();
    }
	
//    public iPAY88ACSPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
