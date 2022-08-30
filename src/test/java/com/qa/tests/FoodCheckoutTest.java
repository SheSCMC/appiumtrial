package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class FoodCheckoutTest extends BaseTest {
	TouchAction touchAction;
	
	By accessIdApp = MobileBy.AccessibilityId("SMOnline-Dev");
//	@AndroidFindBy (accessibility = "SMOnline-Dev") private MobileElement accessIdApp;
	
	@BeforeMethod
	public void beforeMethod(Method method) {
//		utils.log().info("\n" + "================ Starting test: " + method.getName() + " ================" + "\n");
		utils.log().info("\n" + "==========================================================================");
	}
	
	@AfterMethod
	public void afterMethod(Method method) {
		utils.log().info("\n" + "================ End of test: " + method.getName() + " ================" + "\n");
	}
	
	@Test(priority=1)
	public void clearHomepage() {
		touchAction = new TouchAction(getDriver());
		touchAction.tap(ElementOption.element(getDriver().findElement(accessIdApp))).perform();
		
		homepage.closeWelcomeModal();
//		homepage.clearBanner();
		Assert.assertTrue(homepage.verifyPresenceOfShopsCateg());
		
	}
	
  @Test(priority=2)
  public void selectProduct() {
	  
	  //Select Product
	  foodPage = homepage.goToFoodPage();
	  Assert.assertTrue(foodPage.verifyPresenceOfFoodLbl());
	  
	  brandPage = foodPage.goToStore();
	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
	  
	  productDetailsPage = brandPage.selectAbeProduct();
	  productDetailsPage.addQuantity();
	  
  }
	
//  @Test(priority=3)
//  public void buyNowFnBCash() {
//	  
//	  //Proceed on Buy Now
//	  checkoutPage = productDetailsPage.buyNow();
//	  
//	  paymentMethod = checkoutPage.goToPaymentMethodPage();
//	  orderSuccess = paymentMethod.proceedOnCashPayment();
//	  Assert.assertTrue(orderSuccess.verifyPresenceOfOrderTrackerButton());
//
//  }
//	
//  @Test(priority=4)
//  public void verifyOrder() {
//	  
//	  orderTracker = orderSuccess.goToOrderTrackerPage();
//	  Assert.assertTrue(orderTracker.verifyPresenceOfOngoingTab());
//	  System.out.println("F&B Buy Now via Cash payment has been completed.");
//  }
  
}
