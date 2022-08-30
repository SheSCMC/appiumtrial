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

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestClass extends BaseTest{
	
//	AppiumDriver driver;
//	TouchAction touchAction;
//	WebDriverWait wait;
//	
//	HomePage homepage;
//	AccountPage accountPage;
//	MyAddressesPage myAddresses;
//	EditAddressDetailsPage addressDetails;
//	MainSignUpLoginPage mainPage;
//	ShopsPage shopsPage;
//	BrandPage brandPage;
//	ProductDetailsPage productDetailsPage;
//	CheckoutPage checkoutPage;
//	ChangeFulfillmentMethodPage changeFulfillment;
//	PaymentMethodPage paymentMethod;
//	OrderSuccessPage orderSuccess;	
//	OrderTrackerPage orderTracker;
//	OverAllCartPage overallCart;
//	ShopCartPage shopCart;
//	iPAY88SavedCCPage ipay88SavedCC;
//	iPAY88CreditDebitCardPage ipay88CCDB;
//	iPAY88ACSPage ipay88ACS;
//	OrderDetailsPage orderDetails;
	
	@Test
	public void clearHomepage() {
		homepage.waitForWelcomeModalToLoad(wait);
		homepage.closeWelcomeModal();
		homepage.waitForShopsCategToLoad(wait);
		Assert.assertTrue(homepage.verifyPresenceOfShopsCateg());
	}
 
  @Test
  public void addToCartSingleProduct() {
//	  homepage.waitForWelcomeModalToLoad(wait);
//	  homepage.closeWelcomeModal();
//	  homepage.waitForShopsCategToLoad(wait);
//	  Assert.assertTrue(homepage.verifyPresenceOfShopsCateg());
	  
	  
	  //Add to Cart Product
	  shopsPage = homepage.goToShopsPage();
	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
	  
	  brandPage = shopsPage.goToStore();
	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
	  
	  productDetailsPage = brandPage.selectProduct1();
	  productDetailsPage.addToCart1();
	  productDetailsPage.waitForAddedToCartMessage(wait);
	  Assert.assertTrue(productDetailsPage.verifyPresenceOfItemAddedToCartTxt());
	  
	  brandPage = productDetailsPage.goBackToBrandPage();
	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
	  
	  shopsPage = brandPage.goBackToShopsPage();
	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
	  
	  homepage = shopsPage.goBackToHomePage();
	  String actualHomepageSearchText = homepage.getTextFromSearchBox();
	  String expectedHomepageSearchText = "What are you shopping for today?";
	  Assert.assertEquals(actualHomepageSearchText, expectedHomepageSearchText);
  }
	
//  @Test
//  public void addToCartMultipleProducts() {
//	  homepage.waitForWelcomeModalToLoad(wait);
//	  homepage.closeWelcomeModal();
//	  homepage.waitForShopsCategToLoad(wait);
//	  Assert.assertTrue(homepage.verifyPresenceOfShopsCateg());
//	  
//	  //Add to Cart 1st Product
//	  shopsPage = homepage.goToShopsPage();
//	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
//	  
//	  brandPage = shopsPage.goToStore();
//	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
//	  
//	  productDetailsPage = brandPage.selectProduct1();
//	  productDetailsPage.addToCart1();
//	  productDetailsPage.waitForAddedToCartMessage(wait);
//	  Assert.assertTrue(productDetailsPage.verifyPresenceOfItemAddedToCartTxt());
//	  
//	  brandPage = productDetailsPage.goBackToBrandPage();
//	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
//	  
//	  shopsPage = brandPage.goBackToShopsPage();
//	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
//	  
//	  //Add to Cart 2nd Product
//	  brandPage = shopsPage.goToStore2();
//	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
//	  
//	  productDetailsPage = brandPage.selectProduct3();
//	  productDetailsPage.addToCartWithoutSelectingVariant();
//	  productDetailsPage.waitForAddedToCartMessage(wait);
//	  Assert.assertTrue(productDetailsPage.verifyPresenceOfItemAddedToCartTxt());
//	  
//	  brandPage = productDetailsPage.goBackToBrandPage();
//	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
//	  
//	  shopsPage = brandPage.goBackToShopsPage();
//	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
//	  
//	  //Add to Cart 3rd Product
//	  brandPage = shopsPage.goToStore3();
//	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
//	  
//	  brandPage.selectLvl2Category();
//	  
//	  productDetailsPage = brandPage.scrollAndSelectProduct();
//	  productDetailsPage.addToCartWithoutSelectingVariant();
//	  productDetailsPage.waitForAddedToCartMessage(wait);
//	  Assert.assertTrue(productDetailsPage.verifyPresenceOfItemAddedToCartTxt());
//	  
//	  brandPage = productDetailsPage.goBackToBrandPage();
//	  Assert.assertTrue(brandPage.verifyPresenceOfShopBarSection());
//	  
//	  //Go back to Homepage
//	  shopsPage = brandPage.goBackToShopsPage();
//	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
//	  
//	  homepage = shopsPage.goBackToHomePage();
//	  String actualHomepageSearchText = homepage.getTextFromSearchBox();
//	  String expectedHomepageSearchText = "What are you shopping for today?";
//	  Assert.assertEquals(actualHomepageSearchText, expectedHomepageSearchText);
//	  
//	  System.out.println("Multiple GM Products are added to Cart.");
//  }
  
//  @Test
//  public void buyNowGMCash() {
//	  brandPage.selectProduct1();
//	  checkoutPage = productDetailsPage.buyNow();
//	  changeFulfillment = checkoutPage.goToFulfillmentMethodPageViaBuyNow();
//	  Assert.assertTrue(changeFulfillment.verifyPresenceOfChangeFulfillmentTitle());
//	  
//	  checkoutPage = changeFulfillment.changeFulfillmentType();
//	  Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
//	  
//	  paymentMethod = checkoutPage.goToPaymentMethodPage();
//	  orderSuccess = paymentMethod.proceedOnCashPayment();
//	  Assert.assertTrue(orderSuccess.verifyPresenceOfConfirmationLabel());
//
//	  orderTracker = orderSuccess.goToOrderTrackerPage();
//	  Assert.assertTrue(orderTracker.verifyPresenceOfOngoingTab(), "title not found.");
//
//  }
  
//  @Test
//  public void checkoutFromShopCartCash() throws InterruptedException {
////	  homepage.waitForWelcomeModalToLoad(wait);
////	  homepage.closeWelcomeModal();
////	  homepage.waitForShopsCategToLoad(wait);
////	  Assert.assertTrue(homepage.verifyPresenceOfShopsCateg());
//	  
//	  overallCart = homepage.goToCartPage();
//	  Assert.assertTrue(overallCart.verifyPresenceOfCartLabel());
//	  
//	  Thread.sleep(2000);
//	  overallCart.goToShopCart();
//	  
//	  shopCart.selectProducts();
//	  checkoutPage = shopCart.goToCheckoutPage();
//	  Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
//
//	  checkoutPage.waitForFulfillmentButtonToLoad(wait);
//	  changeFulfillment = checkoutPage.goToFulfillmentMethodPageForMultiple();
//	  Assert.assertTrue(changeFulfillment.verifyPresenceOfChangeFulfillmentTitle());
//	  
//	  checkoutPage = changeFulfillment.changeFulfillmentType();
//	  Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
//	  
//	  paymentMethod = checkoutPage.goToPaymentMethodPage();
//	  orderSuccess = paymentMethod.proceedOnCashPayment();
//	  Assert.assertTrue(orderSuccess.verifyPresenceOfConfirmationLabel());
//
//	  orderTracker = orderSuccess.goToOrderTrackerPage();
//	  Assert.assertTrue(orderTracker.verifyPresenceOfOngoingTab());
//  }
  
//  @Test
//  public void checkoutShopFromOverallCartViaSavedCC() {
//	  //GM checkout from OverAllCart Via Saved CC - Default fulfillment
//	  homepage.waitForWelcomeModalToLoad(wait);
//	  homepage.closeWelcomeModal();
//	  Assert.assertTrue(homepage.verifyPresenceOfCartMenu());
//	  
//	  overallCart = homepage.goToCartPage();
//	  Assert.assertTrue(overallCart.verifyPresenceOfCartLabel());
//	  
//	  checkoutPage = overallCart.goToShopCheckout();
//	  	  
//	  paymentMethod = checkoutPage.goToPaymentMethodPage();
//	  paymentMethod.verifyPresenceOfSavedCC1047();
//	  ipay88SavedCC = paymentMethod.proceedOnSavedCCPayment();
//	  ipay88ACS = ipay88SavedCC.inputSavedCCDetails("123");
//	  ipay88ACS.waitForSubmitBtnToLoad(wait);
//	  orderSuccess = ipay88ACS.completeCCCheckout();
//
//	  orderTracker = orderSuccess.goToOrderTrackerPage();
//	  Assert.assertTrue(orderTracker.verifyPresenceOfOngoingTab());
//  }

	
//  @Test
//  public void checkoutShopFromOverallCartViaCreditDebit() {
//		GM checkout from OverAllCart Via Saved CC - Default fulfillment
//  	homepage.waitForWelcomeModalToLoad(wait);
//  	homepage.closeWelcomeModal();
//  	Assert.assertTrue(homepage.verifyPresenceOfCartMenu());
//  
//  	overallCart = homepage.goToCartPage();
//  	Assert.assertTrue(overallCart.verifyPresenceOfCartLabel());
//		  
//  	checkoutPage = overallCart.goToShopCheckout();
//  	Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
//  	checkoutPage.waitForFulfillmentButtonToLoad(wait);
//	
//  	changeFulfillment = checkoutPage.goToFulfillmentMethodPageForMultiple();
//  	Assert.assertTrue(changeFulfillment.verifyPresenceOfChangeFulfillmentTitle());
//	  
//  	checkoutPage = changeFulfillment.changeFulfillmentType();
//  	Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
//	  
//  	paymentMethod = checkoutPage.goToPaymentMethodPage();
//  	ipay88CCDB = paymentMethod.proceedOnCreditDebitPayment();
//  	ipay88ACS = ipay88CCDB.inputCreditDebitDetails("She Test", "3540599999991047", "123");	  
//  	ipay88ACS.waitForSubmitBtnToLoad(wait);
//	  
//  	orderSuccess = ipay88ACS.completeCCCheckout();
//	 	orderTracker = orderSuccess.goToOrderTrackerPage();
//		Assert.assertTrue(orderTracker.verifyPresenceOfOngoingTab());
//	  
//	  	System.out.println("Checkout with mulitple product is successful.");
//	  }
	
//  @Test
//  public void editAddressDetails() throws Exception {
//	  accountPage = homepage.goToAccount();
//	  accountPage.waitForPageToLoad(wait);
//	  Assert.assertTrue(accountPage.verifyPresenceOfAccountLabel());
//	  
//	  myAddresses = accountPage.goToMyAddresses();
//	  myAddresses.waitForThePage2ToLoad(wait);
//	  Assert.assertTrue(myAddresses.verifyPresenceOfSavedAddressesLabel());
//	  
//	  addressDetails = myAddresses.selectAddress();
//	  addressDetails.editAddressDetails("Tagaytay", "Test Floor", "Brgy. 123 Test", "Sample landmark");
//	  addressDetails.saveAddressDetails();
//	  myAddresses.waitForPageToLoad(wait);
//	  Assert.assertTrue(myAddresses.verifyPresenceOfAddressUpdatedLabel());
//	  
//	  myAddresses.goBackToAccountPage();
//	  accountPage.waitForPageToLoad(wait);
//	  Assert.assertTrue(accountPage.verifyPresenceOfAccountLabel());
//  }
  
//  @Test
//  public void logoutAccount() {
//	  accountPage.performLogout();
//	  Assert.assertTrue(mainPage.verifyPresenceOfSignUpLbl());
//	  System.out.println("You are in Main SignUp/Login Page.");
//  }
  
//  @BeforeClass
//  public void beforeClass() throws Exception {
//	  
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		
//		desiredCapabilities.setCapability("platformName", "Android");
//		desiredCapabilities.setCapability("appium:deviceName", "ZenFone 8");
//		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
//		desiredCapabilities.setCapability("appium:udid", "M5AIB760J829M75");
//		desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
//		//below desiredcapabilities are optional for app launch
////		desiredCapabilities.setCapability("appium:appPackage", "com.smsupermalls.smmallsonline.dev");
////		desiredCapabilities.setCapability("appium:appActivity", "com.smsupermalls.smmallsonline.MainActivity");
//			 
//		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//		    
//		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		    
//		touchAction = new TouchAction(driver);
//		    
//		By accessIdApp = MobileBy.AccessibilityId("SMOnline-Dev");
//		touchAction.tap(ElementOption.element(driver.findElement(accessIdApp))).perform();
////		System.out.println("App launched");
//		    
//		wait = new WebDriverWait(driver, 45);
//		
//		homepage = new HomePage(driver, touchAction);
//		accountPage = new AccountPage(driver, touchAction);
//		myAddresses = new MyAddressesPage(driver, touchAction);
//		addressDetails = new EditAddressDetailsPage(driver, touchAction);
//		mainPage = new MainSignUpLoginPage(driver, touchAction);
//		shopsPage = new ShopsPage(driver, touchAction);
//		brandPage = new BrandPage(driver, touchAction);
//		productDetailsPage = new ProductDetailsPage(driver, touchAction);
//		checkoutPage = new CheckoutPage(driver, touchAction);
//		changeFulfillment = new ChangeFulfillmentMethodPage(driver, touchAction);
//		paymentMethod = new PaymentMethodPage(driver, touchAction);
//		orderSuccess = new OrderSuccessPage(driver, touchAction);
//		orderTracker = new OrderTrackerPage(driver, touchAction);
//		overallCart = new OverAllCartPage(driver, touchAction);
//		shopCart = new ShopCartPage(driver, touchAction);
//		ipay88SavedCC = new iPAY88SavedCCPage(driver, touchAction);
//		ipay88ACS = new iPAY88ACSPage(driver, touchAction);
//		ipay88CCDB = new iPAY88CreditDebitCardPage(driver, touchAction);
//		orderDetails = new OrderDetailsPage(driver, touchAction);
//  }
//
//  @AfterClass
//  public void afterClass() {
////	  driver.closeApp();
//  }

}
