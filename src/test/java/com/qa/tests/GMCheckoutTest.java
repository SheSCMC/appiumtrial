package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.main.BaseTest;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class GMCheckoutTest extends BaseTest {

//	@AndroidFindBy (accessibility = "SMOnline-Dev") private MobileElement accessIdApp;
	String expectedProductNames;
	
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
  public void addToCartMultipleProducts() {
	  
	  homepage = orderTracker.goToHomepage();
	  
	  //Add to Cart 1st Product
	  shopsPage = homepage.goToShopsPage();
	  
	  brandPage = shopsPage.goToStore();
	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
//	  System.out.println("Adding products to cart...");
	  
	  productDetailsPage = brandPage.selectProduct1();
	  String adidasProductName = productDetailsPage.getAdidasProductName();
	  productDetailsPage.addToCart1();
	  Assert.assertTrue(productDetailsPage.verifyPresenceOfItemAddedToCartTxt());
	  
	  brandPage = productDetailsPage.goBackToBrandPage();
	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
	  
	  shopsPage = brandPage.goBackToShopsPage();
	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
	  
	  //Add to Cart 2nd Product
	  brandPage = shopsPage.goToStore2();
	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
	  
	  productDetailsPage = brandPage.selectAcerProduct();
	  String acerProductName = productDetailsPage.getAcerProductName();
	  productDetailsPage.addToCartWithoutSelectingVariant();
	  Assert.assertTrue(productDetailsPage.verifyPresenceOfItemAddedToCartTxt());
	  
	  brandPage = productDetailsPage.goBackToBrandPage();
	  
	  shopsPage = brandPage.goBackToShopsPage();
	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
	  
	  //Add to Cart 3rd Product
	  brandPage = shopsPage.goToStore3();
	  Assert.assertTrue(brandPage.verifyPresenceOfProductsLbl());
	  
	  brandPage.selectLvl2Category();
	  
	  productDetailsPage = brandPage.scrollAndSelectProduct();
	  String filbarsProductName = productDetailsPage.getFilbarsProductName();
	  productDetailsPage.addToCartWithoutSelectingVariant();
	  Assert.assertTrue(productDetailsPage.verifyPresenceOfItemAddedToCartTxt());
	  
	  brandPage = productDetailsPage.goBackToBrandPage();
	  Assert.assertTrue(brandPage.verifyPresenceOfShopBarSection());
	  
	  StringBuilder productNames = new StringBuilder().append(adidasProductName).append(", ").append(acerProductName).append(", ").append(filbarsProductName);
	  String expectedProductName = productNames.toString();
	  this.expectedProductNames = expectedProductName;
	  
	  //Go back to Homepage
	  shopsPage = brandPage.goBackToShopsPage();
	  Assert.assertTrue(shopsPage.verifyPresenceOfShopsLbl());
	  
	  homepage = shopsPage.goBackToHomePage();
	  String actualHomepageSearchText = homepage.getTextFromSearchBox();
	  String expectedHomepageSearchText = "What are you shopping for today?";
	  Assert.assertEquals(actualHomepageSearchText, expectedHomepageSearchText);
	  
//	  System.out.println("Multiple GM Products are added to Cart.");
  }
  
  @Test(priority=2)
  public void verifyAddedMultipleProducts() throws InterruptedException {
	  
		overallCart = homepage.goToCartPage();
		Assert.assertTrue(overallCart.verifyPresenceOfCartLabel());
		overallCart.goToShopCart();
		
		StringBuilder collectActualProductNames = shopCart.getProductNames();
		String actualProductNames = collectActualProductNames.toString();
		System.out.println("Checking if added products are correct...");
		Assert.assertEquals(actualProductNames, expectedProductNames);
//		System.out.println("Actual: " + actualProductNames + " \nExpected: " + expectedProductNames + " \nProduct Verification Passed");
		System.out.println("Product Verification Passed");
  }

	@Test(priority=3)
	public void checkoutFromShopCartViaSavedCC() throws InterruptedException {
		
		System.out.println("Checking SubTotal...");
		
		shopCart.selectProducts();
		String expectedSubtotal = shopCart.getExpectedSubTotal();
		String actualSubtotal = shopCart.getActualSubtotal();
		Assert.assertEquals(actualSubtotal, expectedSubtotal);
		System.out.println("Expected SubTotal: " + expectedSubtotal + " | Actual SubTotal: " + actualSubtotal + "\nSubtotal Verification Passed");
		checkoutPage = shopCart.goToCheckoutPage();
//		Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());

		changeFulfillment = checkoutPage.goToFulfillmentMethodPageForMultiple();
		Assert.assertTrue(changeFulfillment.verifyPresenceOfChangeFulfillmentTitle());
		  
		checkoutPage = changeFulfillment.changeFulfillmentType();
		Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
		  	  
		paymentMethod = checkoutPage.goToPaymentMethodPage();
		paymentMethod.verifyPresenceOfSavedCCJCB1047();
		ipay88SavedCC = paymentMethod.proceedOnSavedCCPayment();
		ipay88ACS = ipay88SavedCC.inputCCDetails("123");
		orderSuccess = ipay88ACS.completeCCCheckout();
		
		Assert.assertTrue(orderSuccess.verifyPresenceOfOrderTrackerButton());
	}
  
  @Test(priority=4)
  public void verifyOrder() {
	  
	  orderTracker = orderSuccess.goToOrderTrackerPage();
	  Assert.assertTrue(orderTracker.verifyPresenceOfOngoingTab());
	  System.out.println("GM Checkout via Saved CC has been completed.");
  }
  
//@Test
//public void addToCartSingleProduct() {
//	  homepage.waitForWelcomeModalToLoad(wait);
//	  homepage.closeWelcomeModal();
//	  homepage.waitForShopsCategToLoad(wait);
//	  Assert.assertTrue(homepage.verifyPresenceOfShopsCateg());
//	  
//	  //Add to Cart Product
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
//	  homepage = shopsPage.goBackToHomePage();
//	  String actualHomepageSearchText = homepage.getTextFromSearchBox();
//	  String expectedHomepageSearchText = "What are you shopping for today?";
//	  Assert.assertEquals(actualHomepageSearchText, expectedHomepageSearchText);
//}

//@Test
//public void checkoutFromShopCartCash() throws InterruptedException {
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
//	  
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
//}

//@Test
//public void checkoutShopFromOverallCartViaSavedCC() {
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
//}
  
//@Test
//public void checkoutShopFromOverallCartViaCreditDebit() {
//	  //GM checkout from OverAllCart Via Saved CC - Default fulfillment
////	  homepage.waitForWelcomeModalToLoad(wait);
////	  homepage.closeWelcomeModal();
////	  Assert.assertTrue(homepage.verifyPresenceOfCartMenu());
//	  
//	  overallCart = homepage.goToCartPage();
//	  Assert.assertTrue(overallCart.verifyPresenceOfCartLabel());
//		  
//	  checkoutPage = overallCart.goToShopCheckout();
//	  Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
//	  checkoutPage.waitForFulfillmentButtonToLoad(wait);
//
//	  changeFulfillment = checkoutPage.goToFulfillmentMethodPageForMultiple();
//	  Assert.assertTrue(changeFulfillment.verifyPresenceOfChangeFulfillmentTitle());
//	  
//	  checkoutPage = changeFulfillment.changeFulfillmentType();
//	  Assert.assertTrue(checkoutPage.verifyPresenceOfChekcoutLbl());
//	  
//	  paymentMethod = checkoutPage.goToPaymentMethodPage();
//	  ipay88CCDB = paymentMethod.proceedOnCreditDebitPayment();
//	  ipay88ACS = ipay88CCDB.inputCreditDebitDetails("She Test", "3540599999991047", "123");	  
//	  ipay88ACS.waitForSubmitBtnToLoad(wait);
//	  
//	  orderSuccess = ipay88ACS.completeCCCheckout();
//	  } 

}
