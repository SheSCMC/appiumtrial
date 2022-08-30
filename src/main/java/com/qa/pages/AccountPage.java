package com.qa.pages;

import com.qa.main.BaseTest;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountPage extends BaseTest {
	
	//Element Locators
	@AndroidFindBy (accessibility = "Account") 
	private MobileElement idAccountLbl;
	
	@AndroidFindBy (accessibility = "My Addresses") 
	private MobileElement idMyAddresses;
	
	@AndroidFindBy (accessibility = "Logout") 
	private MobileElement idLogoutBtn;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().description(\"Logout\"))") private MobileElement logoutBtn;
	
	@AndroidFindBy (accessibility = "Yes") 
	private MobileElement idYesBtn;
	
	@AndroidFindBy (accessibility = "Cancel") 
	private MobileElement idCancelLogoutBtn;
    
    public Boolean verifyPresenceOfAccountLabel() {
    	waitForVisibility(idAccountLbl);
    	return idAccountLbl.isDisplayed();
    }
    
    public MyAddressesPage goToMyAddresses() {
    	utils.log().info("Go to My Addresses");
    	click(idMyAddresses);
    	return new MyAddressesPage();
    }
    
    public void performLogout() {
    	utils.log().info("Click the Logout button");
    	click(idLogoutBtn);
    	utils.log().info("Tap Yes to confirm logout");
    	click(idYesBtn);	
    }
    
    public void cancelLogout() {
    	click(logoutBtn);
    	utils.log().info("Tap Cancel button to cancel logout");
    	click(idCancelLogoutBtn);
    }

}
