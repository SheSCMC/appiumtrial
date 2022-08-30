package com.qa.pages;

import java.util.List;
import java.util.Random;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class iPAY88CreditDebitCardPage extends BaseTest{
	
	//Element Locators
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View/android.view.View") 
	private MobileElement xpathPageTitle;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[2]/android.view.View/android.widget.CheckBox") 
	private MobileElement xpathPrivacyCheckbox;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[4]/android.widget.EditText") 
	private MobileElement xpathNameField;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[5]/android.widget.EditText") 
	private MobileElement xpathCardNumField;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[6]/android.widget.EditText") 
	private MobileElement xpathCVCField;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[7]/android.view.View[2]") 
	private MobileElement xpathMonthDropdown;
	
	@AndroidFindBy (xpath = "//android.widget.CheckedTextView") 
	private List<MobileElement> xpathMonthList;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[7]/android.view.View[3]") 
	private MobileElement xpathYearDropdown;
	
	@AndroidFindBy (xpath = "//android.widget.CheckedTextView") 
	private List<MobileElement> xpathYearList;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[8]/android.widget.CheckBox") 
	private MobileElement xpathAuthorizeCheckbox;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[9]/android.widget.Button[1]") 
	private MobileElement xpathProceedBtn;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]") 
	private MobileElement xpathMonthNull;
	
	//Element Locators on the Summary Transaction Page of iPAY88
//	By xpathMonthList = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView");
//	By xpathMonthList = MobileBy.xpath("//android.widget.CheckedTextView");
//	By xpathYearList = MobileBy.xpath("//android.widget.CheckedTextView");
//	By xpathYearList = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView");
	
    //Actions to be done in form of methods
	public Boolean verifyPresenceOfPageTitle() {
    	return xpathPageTitle.isDisplayed();
    }
    
    public iPAY88ACSPage inputSavedCCDetails(String cvv) {
    	utils.log().info("Input CVV/CVC details...");
    	sendKeys(xpathCVCField, cvv);
    	utils.log().info("Tick the Authorize checkbox");
    	click(xpathAuthorizeCheckbox);
    	utils.log().info("Click the Proceed button");
    	click(xpathProceedBtn);
    	
		return new iPAY88ACSPage();
    }
    
    public iPAY88ACSPage inputCreditDebitDetails(String name, String cardNum, String cvv) {
    	utils.log().info("Tick the Privacy checkbox");
    	click(xpathPrivacyCheckbox);
    	utils.log().info("Input the Name, Card Number and CVC/CVV details");
    	sendKeys(xpathNameField, name);
    	sendKeys(xpathCardNumField, cardNum);
    	sendKeys(xpathCVCField, cvv);
    	utils.log().info("Select a month from the list");
    	click(xpathMonthDropdown);
    	
		List<MobileElement> monthButtons = xpathMonthList;
		monthButtons.remove(0);
		Random rand = new Random();
		int monthIndex = rand.nextInt(monthButtons.size()-1); // -1 because index will start from 0
		System.out.println("index is: " + monthIndex);
		
		monthButtons.get(monthIndex).click();
		
		utils.log().info("Select a year from the list");
		click(xpathYearDropdown);
		
		List<MobileElement> yearButtons = xpathYearList;
		yearButtons.remove(0);
		int yearIndex = rand.nextInt(yearButtons.size()-1); // -1 because index will start from 0

		yearButtons.get(yearIndex).click();
		
		utils.log().info("Tick the Authorization Checkbox to proceed");
    	click(xpathAuthorizeCheckbox);
    	utils.log().info("Tap the proceed button");
    	click(xpathProceedBtn);
    	
		return new iPAY88ACSPage();
    }
	
//    public iPAY88CreditDebitCardPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
