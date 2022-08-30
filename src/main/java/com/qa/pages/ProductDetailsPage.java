package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailsPage extends BaseTest{

	//Element Locators
	@AndroidFindBy (accessibility = "M") 
	private MobileElement idProductVariant;
	
	@AndroidFindBy (accessibility = "Add to cart") 
	private MobileElement idAddToCartBtn;
	
	@AndroidFindBy (accessibility = "Item added to cart") 
	private MobileElement idItemAddedToCartTxt;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]") 
	private MobileElement xpathBackBtn;
	
	@AndroidFindBy (accessibility = "Buy Now") 
	private MobileElement idBuyNowBtn;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.ScrollView/android.widget.Button[2]") 
	private MobileElement xpathAddQuantity;
	
	//Products' Element Locators
	@AndroidFindBy (accessibility = "Adidas Men's Ankle Socks DZ9406") 
	private MobileElement idProductAdidas1;
	
	@AndroidFindBy (accessibility = "TPLINK  USB ADAPTER UE330 ") 
	private MobileElement idProductAcer1;
	
	@AndroidFindBy (accessibility = "TPLINK MINI WIFI USB ADAPTER ARCHER T3U")
	private MobileElement idProductAcer2;
	
	@AndroidFindBy (accessibility = "POP! Ghostbusters Afterlife: Mini Puft (in cappuccino cup)") 
	private MobileElement idProductFilbars;
	
    
    public void waitForAddedToCartMessage(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idItemAddedToCartTxt));
    }
    
    public void waitForBuyNowButtonToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idBuyNowBtn));
    }
    
    public Boolean verifyPresenceOfItemAddedToCartTxt() {
    	waitForVisibility(idItemAddedToCartTxt);
    	return idItemAddedToCartTxt.isDisplayed();
    }
    
	public String getAdidasProductName() {
		String adidasName = getAttribute(idProductAdidas1, "content-desc").toString();
		String adidasProdName = adidasName.substring(0, 31);
		
		return adidasProdName;
	}
	
	public String getFilbarsProductName() {
		String filbarsName = getAttribute(idProductFilbars, "content-desc").toString();
		String filbarsProdName = filbarsName.substring(0, 38);
		
		return filbarsProdName;
	}
	
	public String getAcerProductName() {
		String acerName = getAttribute(idProductAcer2, "content-desc").toString();
		String acerProdName = acerName.substring(0, 39);
		
		return acerProdName;
	}
	
    public void addToCart1() {
    	utils.log().info("Choose a product variant");
    	click(idProductVariant);
    	utils.log().info("Proceed on add to cart");
    	click(idAddToCartBtn);
    }
    
    public void addToCartWithoutSelectingVariant() {
    	utils.log().info("Proceed on add to cart");
    	click(idAddToCartBtn);
    }
    
    public CheckoutPage buyNow() {
    	utils.log().info("Proceed on Buy Now");
    	click(idBuyNowBtn);
    	
    	return new CheckoutPage();
    }
    
    public BrandPage goBackToBrandPage() {
    	utils.log().info("Go back to Brand Page");
    	click(xpathBackBtn);

    	return new BrandPage();
    }
    
    public void addQuantity() {
    	utils.log().info("Adjust the quantity");
	    getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView(" + "new UiSelector().description(\"Quantity\"))"));
    	click(xpathAddQuantity);
    }
	
//    public ProductDetailsPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
