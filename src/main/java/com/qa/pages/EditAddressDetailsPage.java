package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class EditAddressDetailsPage extends BaseTest {
	TouchAction touchAction;

	//Element Locators
	@AndroidFindBy (accessibility = "Update Address") 
	private MobileElement idUpdateAddressLbl;
	
	@AndroidFindBy (accessibility = "Save") 
	private MobileElement idSaveBtn;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button") 
	private MobileElement xpathBackBtn;
	
    //Elements of fields when SELECTED
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]") 
	private MobileElement xpathAliasFieldSelected;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]") 
	private MobileElement xpathRoomFlrFieldSelected;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]") 
	private MobileElement xpathStreetBrgyFieldSelected;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]") 
	private MobileElement xpathLandmarkFieldSelected;
	
	//Elements of fields when NOT selected
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]") 
	private MobileElement xpathAliasField;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]") 
	private MobileElement xpathRoomFlrField;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]") 
	private MobileElement xpathStreetBrgyField;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]") 
	private MobileElement xpathLandmarkField;
	  
	public void waitForPageToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idUpdateAddressLbl));
    }
    
    public Boolean verifyPresenceOfUpdateAddressLabel() {
    	return idUpdateAddressLbl.isDisplayed();
    }
    
	public void editAddressDetails(String alias, String room, String street, String landmark) throws Exception {
		//Edit Alias Field
		System.out.println("Updating the address details in progress...");
    	click(xpathAliasField);
	    int aliasTextLength = xpathAliasFieldSelected.getText().length(); 
	    for (int i = 0; i < aliasTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathAliasFieldSelected, alias);
	    
	    //Edit Room/Floor/Unit # Building Name field
    	click(xpathRoomFlrFieldSelected);
	    int roomTextLength = xpathRoomFlrFieldSelected.getText().length(); 
	    for (int i = 0; i < roomTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathRoomFlrFieldSelected, room);

	    //Edit Street #, Barangay field
    	click(xpathStreetBrgyFieldSelected);
	    int streetTextLength = xpathStreetBrgyFieldSelected.getText().length(); 
	    for (int i = 0; i < streetTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathStreetBrgyFieldSelected, street);
	    
	    getDriver().hideKeyboard();
	    
	    //Edit Landmark field
    	click(xpathLandmarkField);
    	
	    Thread.sleep(2000);
    	
	    Dimension size = getDriver().manage().window().getSize();
	    
	    int startX = size.width / 2;
	    int endX = startX;
	    int startY = (int) (size.height * 0.4);
	    int endY = (int) (size.height * 0.2);
	    
	    //Manual Swipe once
	    touchAction = new TouchAction(getDriver());
	    touchAction.press(PointOption.point(startX, startY))
	    	.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
	    	.moveTo(PointOption.point(endX, endY))
	    	.release()
	    	.perform();
    	
	    int landmarkTextLength = xpathLandmarkFieldSelected.getText().length(); 
	    for (int i = 0; i < landmarkTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathLandmarkFieldSelected, landmark);
	    getDriver().hideKeyboard();
	    
    }
	
	public void updateAlias(String alias) {
		//Edit Alias Field
		System.out.println("Updating the address details...");
		
    	click(xpathAliasField);
	    int aliasTextLength = xpathAliasFieldSelected.getText().length(); 
	    for (int i = 0; i < aliasTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathAliasFieldSelected, alias, "Alias field value has been updated");
//	    utils.log().info("Alias field value has been updated");
	}
	
	public void updateRoomFloorUnit(String room) {
	    //Edit Room/Floor/Unit # Building Name field
    	click(xpathRoomFlrFieldSelected);
	    int roomTextLength = xpathRoomFlrFieldSelected.getText().length(); 
	    for (int i = 0; i < roomTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathRoomFlrFieldSelected, room, "Room/Floor/Unit #/Building Name field value has been updated");
//	    utils.log().info("Room/Floor/Unit #/Building Name field value has been updated");
	}
	
	public void updateStreetBrgy(String street) {
		//Edit Street #, Barangay field
    	click(xpathStreetBrgyFieldSelected);
	    int streetTextLength = xpathStreetBrgyFieldSelected.getText().length(); 
	    for (int i = 0; i < streetTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathStreetBrgyFieldSelected, street, "Street # and Barangay field value has been updated");
//	    utils.log().info("Street # and Barangay field value has been updated");
	    
	    getDriver().hideKeyboard();
	}
	
	public void updateLandmark(String landmark) throws Exception {
    	click(xpathLandmarkField);
    	
	    Thread.sleep(2000);
    	
	    Dimension size = getDriver().manage().window().getSize();
	    
	    int startX = size.width / 2;
	    int endX = startX;
	    int startY = (int) (size.height * 0.4);
	    int endY = (int) (size.height * 0.2);
	    
	    //Manual Swipe once
	    touchAction = new TouchAction(getDriver());
	    touchAction.press(PointOption.point(startX, startY))
	    	.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
	    	.moveTo(PointOption.point(endX, endY))
	    	.release()
	    	.perform();
    	
	    int landmarkTextLength = xpathLandmarkFieldSelected.getText().length(); 
	    for (int i = 0; i < landmarkTextLength; i++) {
	    	((AndroidDriver) getDriver()).pressKey(new KeyEvent().withKey(AndroidKey.DEL));
	    }
	    sendKeys(xpathLandmarkFieldSelected, landmark, "Landmark field value has been updated");
//	    utils.log().info("Landmark field value has been updated");
	    getDriver().hideKeyboard();
	}
	
	public void saveAddressDetails() {
	    //Save the updated address details
		utils.log().info("Click on the Save button to save the updated address details");
	    click(idSaveBtn);
	}
	
    public StringBuilder getTextFromAddressFields() {
    	utils.log().info("Get the updated address info");
    	String aliasOnly = getAttribute(xpathAliasField, "text").toString();
    	String actualAlias = aliasOnly.substring(0, 10);
    	
       	String roomOnly = getAttribute(xpathRoomFlrField, "text").toString();
       	String actualRoom = roomOnly.substring(0, 10);
       	
       	String streetOnly = getAttribute(xpathStreetBrgyField, "text").toString();
       	String actualStreet = streetOnly.substring(0, 14);
       	
       	String landmarkOnly = getAttribute(xpathLandmarkField, "text").toString();
       	String actualLandmark = landmarkOnly.substring(0, 15);
       	
       	StringBuilder actualDetails = new StringBuilder().append(actualAlias).append(", ").append(actualRoom).append(", ").append(actualStreet).append(", ").append(actualLandmark); 
       	return actualDetails;
    }
	
    public MyAddressesPage goBackToAddressList() {
    	utils.log().info("Go back to Address List");
    	click(xpathBackBtn);
    	return new MyAddressesPage();
    }
    
//    public EditAddressDetailsPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
    
}
