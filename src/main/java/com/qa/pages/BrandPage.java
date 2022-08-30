package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BrandPage extends BaseTest {
	
	//Element Locators
	@AndroidFindBy (accessibility = "Products") 
	private MobileElement idProductsLbl;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]") 
	private MobileElement xpathShopBarSection;
	
	@AndroidFindBy (accessibility = "Action Figures") 
	private MobileElement idLvl2ActionFigures;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]") 
	private MobileElement xpathBackBtn;
	
	
	@AndroidFindBy (accessibility = "Adidas Men's Ankle Socks DZ9406\n"
    		+ "₱ 300.00") private MobileElement idProductAdidas1;
	
	@AndroidFindBy (accessibility = "Adidas Classic Backpack FT8757\n"
    		+ "₱ 50.00") private MobileElement idProductAdidas2;
	
	@AndroidFindBy (accessibility = "TPLINK  USB ADAPTER UE330 \n"
    		+ "₱ 200.00") private MobileElement idProductAcer1;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().description(\"TPLINK  USB ADAPTER UE330 \n"
	        + "₱ 200.00\"))") private MobileElement acerProductUE330;
	
	@AndroidFindBy (accessibility = "TPLINK MINI WIFI USB ADAPTER ARCHER T3U\n"
			+ "₱ 250.00") private MobileElement idProductAcer2;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().description(\"Claude's Dream\n"
	        + "₱ 189.00\"))") private MobileElement abeProduct;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().description(\"POP! Ghostbusters Afterlife: Mini Puft (in cappuccino cup)\n"
	        + "₱ 600.00\"))") private MobileElement filbarsProduct;
	
	@AndroidFindBy (accessibility = "POP! Ghostbusters Afterlife: Mini Puft (in cappuccino cup)\n"
    		+ "₱ 600.00") private MobileElement idProductFilbars;
    
    
    public Boolean verifyPresenceOfProductsLbl() {
    	return idProductsLbl.isDisplayed();
    }
    
    public void waitForProductToBeVisible(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idProductAdidas2));
    }
    
    public void waitForAcerProductToBeVisible(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idProductAcer1));
    }
    
    public Boolean verifyPresenceOfProduct() {
    	return idProductAdidas2.isDisplayed();
    }
    
    public Boolean verifyPresenceOfShopBarSection() {
    	return xpathShopBarSection.isDisplayed();
    }
    
    public void selectLvl2Category() {
    	utils.log().info("Click a Level 2 Category");
    	click(idLvl2ActionFigures);
    }
	
    public ProductDetailsPage selectProduct1() {
    	utils.log().info("Select a Product");
    	click(idProductAdidas1);
    	return new ProductDetailsPage();
    }
    
    public void selectProduct2() {
    	utils.log().info("Select a Product");
    	click(idProductAdidas2);
    }
    
    //TPLINK MINI WIFI USB ADAPTER ARCHER T3U
    public ProductDetailsPage selectAcerProduct() {
    	utils.log().info("Select a Product");
    	click(idProductAcer2);
    	
    	return new ProductDetailsPage();
    }
    
    //POP! Ghostbusters Afterlife: Mini Puft (in cappuccino cup)
    public ProductDetailsPage scrollAndSelectProduct() {
    	utils.log().info("Select a Product");
	    click(filbarsProduct);
    	return new ProductDetailsPage();
    }
    
	public ProductDetailsPage selectAbeProduct() {
    	utils.log().info("Select an F&B product");
    	click(abeProduct);
    	return new ProductDetailsPage();
    }
    
	public StringBuilder getProductNames() {
		utils.log().info("Get product names");
		String adidasName = getAttribute(idProductAdidas1, "content-desc").toString();
		String adidasProdName = adidasName.substring(0, 31);

		String acerName = getAttribute(idProductAcer2, "content-desc").toString();
		String acerProdName = acerName.substring(0, 39);

		String filbarsName = getAttribute(idProductFilbars, "content-desc").toString();
		String filbarsProdName = filbarsName.substring(0, 38);
		
       	StringBuilder actualProductNames = new StringBuilder().append(adidasProdName).append(", ").append(acerProdName).append(", ").append(filbarsProdName); 
       	return actualProductNames;
	}
    
    public ShopsPage goBackToShopsPage() {
    	utils.log().info("Go back to Shops Page");
    	click(xpathBackBtn);
    	return new ShopsPage();
    }
    
//    public BrandPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
