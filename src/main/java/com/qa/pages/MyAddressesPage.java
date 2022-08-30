package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyAddressesPage extends BaseTest {

	//Element Locators
	@AndroidFindBy (accessibility = "Saved Addresses") 
	private MobileElement idSavedAddressesLbl;
	
	@AndroidFindBy (accessibility = "Address is updated.") 
	private MobileElement idAddressUpdatedLbl;
	
	@AndroidFindBy (xpath = "(//android.view.View[@content-desc=\"Edit\"])[2]") 
	private MobileElement xpathEditBtnOfAddress;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button") 
	private MobileElement xpathBackBtn;
		
    public void waitForThePage2ToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idSavedAddressesLbl));
    }
    
    public Boolean verifyPresenceOfSavedAddressesLabel() {
    	waitForVisibility(idSavedAddressesLbl);
    	return idSavedAddressesLbl.isDisplayed();
    }
	
	public void waitForPageToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idAddressUpdatedLbl));
    }
	
    public EditAddressDetailsPage selectAddress() {
    	utils.log().info("Select an address");
    	click(xpathEditBtnOfAddress);
    	return new EditAddressDetailsPage();
    }
    
	public String getSuccessMessage() {
		String successMessage = getAttribute(idAddressUpdatedLbl, "content-desc").toString();
		String updateAddressSuccessMessage = successMessage.substring(0, 19);
		
		return updateAddressSuccessMessage;
	}
    
    public Boolean verifyPresenceOfAddressUpdatedLabel() {
    	waitForVisibility(idAddressUpdatedLbl);
    	return idAddressUpdatedLbl.isDisplayed();
    }
    
    public AccountPage goBackToAccountPage() {
    	utils.log().info("Go back to Account Page");
    	click(xpathBackBtn);
    	return new AccountPage();
    }
    
//    public MyAddressesPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }

}
