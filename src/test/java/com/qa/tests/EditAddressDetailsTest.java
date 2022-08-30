package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class EditAddressDetailsTest extends BaseTest{
	JSONObject addressData;
	TouchAction touchAction;
	
//	@AndroidFindBy (accessibility = "SMOnline-Dev") private MobileElement accessIdApp;
	By accessIdApp = MobileBy.AccessibilityId("SMOnline-Dev");
	
	@BeforeClass
	public void beforeClass() throws Exception {
		InputStream dataInput = null;
		try {
			String dataFileName = "data/addressDetails.json";
			dataInput = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(dataInput);
			addressData = new JSONObject(tokener);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(dataInput != null) {
				dataInput.close();
			}
		}
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
//		utils.log().info("\n" + "================ Starting test: " + method.getName() + " ================" + "\n");
		utils.log().info("\n" + "==========================================================================");
	}
	
	@AfterMethod
	public void afterMethod(Method method) {
		utils.log().info("\n" + "================ End of test: " + method.getName() + " ================" + "\n");
	}
	
//	@Test(priority=1)
//	public void clearHomepage() {
//		touchAction = new TouchAction(getDriver());
//		touchAction.tap(ElementOption.element(getDriver().findElement(accessIdApp))).perform();
//		
//		homepage.closeWelcomeModal();
////		homepage.clearBanner();
//		Assert.assertTrue(homepage.verifyPresenceOfShopsCateg());
//		
//	}
	
  @Test(priority=1)
  public void skipThis(){
	  utils.log().info("Sample: This is a skip test");
      System.out.println("Testcase 2 - skip exception example");
      throw new SkipException("Skipping this exception");
  }
	
  @Test(priority=2)
  public void editAddressDetails() throws Exception {
	  
	  homepage = orderTracker.goToHomepage();
	  
	  accountPage = homepage.goToAccount();
	  Assert.assertTrue(accountPage.verifyPresenceOfAccountLabel());
	  
	  myAddresses = accountPage.goToMyAddresses();
	  Assert.assertTrue(myAddresses.verifyPresenceOfSavedAddressesLabel());
	  
	  addressDetails = myAddresses.selectAddress();
//	  addressDetails.editAddressDetails("Test Alias", "Test Floor", "Brgy. 123 Test", "Sample landmark");
	  addressDetails.updateAlias(addressData.getJSONObject("updateAddressDetails").getString("alias"));
	  addressDetails.updateRoomFloorUnit(addressData.getJSONObject("updateAddressDetails").getString("roomFlr"));
	  addressDetails.updateStreetBrgy(addressData.getJSONObject("updateAddressDetails").getString("streetBrgy"));
	  addressDetails.updateLandmark(addressData.getJSONObject("updateAddressDetails").getString("landmark"));
	  addressDetails.saveAddressDetails();
	  
	  String expectedMessage = getStrings().get("update_address_success");
	  String actualMessage = myAddresses.getSuccessMessage();
	  Assert.assertEquals(expectedMessage, actualMessage);
	  System.out.println("Update address details has been completed.");
  }
  
  @Test(priority=3)
  public void sampleTestToFail() {
	  utils.log().info("Sample: This is a fail test");
	  System.out.println("Sample: This is a fail test.");
	  Assert.fail("Fail");
  }
  
  @Test(priority=4)
  public void verifyUpdatedAddress() {
	  
	  System.out.println("Verifying...");
	  myAddresses.goBackToAccountPage();
	  Assert.assertTrue(accountPage.verifyPresenceOfAccountLabel());
	  
	  myAddresses = accountPage.goToMyAddresses();
	  Assert.assertTrue(myAddresses.verifyPresenceOfSavedAddressesLabel());
	  addressDetails = myAddresses.selectAddress();
	  
	  StringBuilder collectDetails = addressDetails.getTextFromAddressFields();
	  String actualDetails = collectDetails.toString();
	  String expectedDetails = "Test Alias, Test Floor, Brgy. 123 Test, Sample landmark";
	  Assert.assertEquals(actualDetails, expectedDetails);
	  System.out.println("Actual: " + actualDetails + " \nExpected: " + expectedDetails + " \nUpdate Address Verification Passed");
	  
	  myAddresses = addressDetails.goBackToAddressList();
	  accountPage = myAddresses.goBackToAccountPage();
  }

}
