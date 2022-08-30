package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.main.BaseTest;
import com.qa.pages.AccountPage;
import com.qa.pages.BrandPage;
import com.qa.pages.ChangeFulfillmentMethodPage;
import com.qa.pages.CheckoutPage;
import com.qa.pages.EditAddressDetailsPage;
import com.qa.pages.HomePage;
import com.qa.pages.MainSignUpLoginPage;
import com.qa.pages.MyAddressesPage;
import com.qa.pages.OrderDetailsPage;
import com.qa.pages.OrderSuccessPage;
import com.qa.pages.OrderTrackerPage;
import com.qa.pages.OverAllCartPage;
import com.qa.pages.PaymentMethodPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ShopCartPage;
import com.qa.pages.ShopsPage;
import com.qa.pages.iPAY88ACSPage;
import com.qa.pages.iPAY88CreditDebitCardPage;
import com.qa.pages.iPAY88SavedCCPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class LogoutTest extends BaseTest{
	
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
  public void logoutAccount() {
	  
	  accountPage = homepage.goToAccount();
	  System.out.println("Attempting to log out...");
	  
	  accountPage.cancelLogout();
	  System.out.println("Cancelled logout.");
	  
	  System.out.println("Logging out...");
	  accountPage.performLogout();
	  System.out.println("Account has been logged out.");
  }
  
  @Test(priority=2)
  public void verifyLogout() {
	  
	  mainPage.verifyPresenceOfWelcomeMessage();
	  Assert.assertTrue(mainPage.verifyPresenceOfWelcomeMessage());
	  System.out.println("You are now in Main SignUp/Login Page.");
  }
  
}
