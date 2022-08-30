package com.qa.pages;

//import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ShopCartPage extends BaseTest{

	//Element Locators
	@AndroidFindBy (xpath = "//android.widget.CheckBox[@index='0']") 
	private List<MobileElement> xpathCheckbox1;
	
	@AndroidFindBy (xpath = "//android.widget.Button[@index='4']") 
	private MobileElement xpathCheckoutBtn;
	
	@AndroidFindBy (accessibility = "Adidas Men's Ankle Socks DZ9406\n"
    		+ "M\n"
    		+ "₱ 300.00\n"
    		+ "1") private MobileElement idProductAdidas;
	
	@AndroidFindBy (accessibility = "TPLINK  USB ADAPTER UE330 \n"
    		+ "₱ 200.00\n"
    		+ "1") private MobileElement idProductAcer;
	
	@AndroidFindBy (accessibility = "TPLINK MINI WIFI USB ADAPTER ARCHER T3U\n"
			+ "Black\n"
			+ "₱ 250.00\n"
			+ "1") private MobileElement idProductAcer2;
	
	@AndroidFindBy (accessibility ="POP! Ghostbusters Afterlife: Mini Puft (in cappuccino cup)\n"
    		+ "₱ 600.00\n"
    		+ "1") private MobileElement idProductFilbars;
	
	@AndroidFindBy (accessibility = "Adidas - SM Mall of Asia Complex\n"
    		+ "₱ 300.00") private MobileElement idAdidasTotal;
	
	@AndroidFindBy (accessibility = "Acer - SM Mall of Asia Complex\n"
			+ "₱ 250.00") private MobileElement idAcerTotal;
	
	@AndroidFindBy (accessibility = "Filbars - SM Mall of Asia Complex\n"
    		+ "₱ 600.00") private MobileElement idFilbarsTotal;
    
    public void waitForProductToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(idProductAdidas));
    }
    
    public void waitForCheckoutBtnToLoad(WebDriverWait wait) {
    	wait.until(ExpectedConditions.visibilityOf(xpathCheckoutBtn));
    }
    
	public StringBuilder getProductNames() throws InterruptedException {
//		Thread.sleep(2000);
		String adidasName = getAttribute(idProductAdidas, "content-desc").toString();
		String adidasProdName = adidasName.substring(0, 31);

		String acerName = getAttribute(idProductAcer2, "content-desc").toString(); 
		String acerProdName = acerName.substring(0, 39);

		String filbarsName = getAttribute(idProductFilbars, "content-desc").toString();
		String filbarsProdName = filbarsName.substring(0, 38);
		
       	StringBuilder actualProductNames = new StringBuilder().append(adidasProdName).append(", ").append(acerProdName).append(", ").append(filbarsProdName); 
       	return actualProductNames;
	}
	
	public String getExpectedSubTotal () {
		String store1Amount = getAttribute(idAdidasTotal, "content-desc").toString().substring(34, 41);
		Double getTotalStore1 = Double.parseDouble(store1Amount);
		
		String store2Amount = getAttribute(idAcerTotal, "content-desc").toString().substring(33, 38);
		Double getTotalStore2 = Double.parseDouble(store2Amount);
		
		String store3Amount = getAttribute(idFilbarsTotal, "content-desc").toString().substring(36, 41);
		Double getTotalStore3 = Double.parseDouble(store3Amount);
		
		Double totalAmount = getTotalStore1 + getTotalStore2 + getTotalStore3;
//		DecimalFormat formatter = new DecimalFormat("#,###.00");
		String amountStore = String.format("%,.2f", totalAmount);

		return amountStore;
	}
	
	public void selectProducts() {
		utils.log().info("Select products on Cart");
		List<MobileElement> checkboxes = xpathCheckbox1;
		for(int i=0; i<checkboxes.size(); i++)
		{
			if(checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled())
			{
				checkboxes.get(i).click();
//                   ((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView(" + "new UiSelector().description(\"insert-here\"))").click();
			}
		}
	}
	
//	public void selectFirstProductOnTheList() {
//		click(xpathCheckbox1);
//	}
	
	public String getActualSubtotal () {
		String subtotalAmount = getAttribute(xpathCheckoutBtn, "content-desc").toString().substring(11, 19);
		
		return subtotalAmount;
	}
	
	public CheckoutPage goToCheckoutPage() {
		utils.log().info("Click the Checkout button");
		click(xpathCheckoutBtn);

		return new CheckoutPage();
	}
	
//    public ShopCartPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
