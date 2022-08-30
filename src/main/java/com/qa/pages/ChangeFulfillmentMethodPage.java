package com.qa.pages;

import java.util.List;
import java.util.Random;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChangeFulfillmentMethodPage extends BaseTest {
	
	//Element Locators
	@AndroidFindBy (accessibility = "Next Day Delivery") 
	private MobileElement idNextdayBtn;
	
	@AndroidFindBy (xpath ="//android.view.View[@content-desc=\"In Store Pick Up\n"
			+ "Collect your order in-person.\"]/android.widget.RadioButton") 
	private MobileElement xpathInStoreBtn;
	
	@AndroidFindBy (accessibility = "Save") 
	private MobileElement idSaveBtn;
	
	@AndroidFindBy (accessibility = "Change Fulfillment Method") 
	private MobileElement idChangeFulfillmentTitle;
	
	@AndroidFindBy (xpath = "//android.widget.RadioButton") 
	private List<MobileElement> xpathFulfillmentOptions;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View") 
	private MobileElement xpathFulfillment;
		
    public Boolean verifyPresenceOfChangeFulfillmentTitle() {
    	return idChangeFulfillmentTitle.isDisplayed();
    }
	
	public CheckoutPage changeFulfillmentType() {
//		Boolean selected = driver.findElement(xpathInStoreBtn).isSelected();
//		if (driver.findElement(xpathInStoreBtn).isSelected()) {
//			driver.findElement(idNextdayBtn).click();
//		} else {
//			driver.findElement(xpathInStoreBtn).click();
//		}
//		driver.findElement(idSaveBtn).click();
		
		List<MobileElement> fulfillmentOptions = xpathFulfillmentOptions;
		Random rand = new Random();
		int fulfillmentIndex = rand.nextInt(fulfillmentOptions.size()-1); // -1 because index will start from 0
		utils.log().info("Choose a fulfillment method");
		fulfillmentOptions.get(fulfillmentIndex).click();
		utils.log().info("Click the Save button");
		click(idSaveBtn);

		return new CheckoutPage();
	}
	
//    public ChangeFulfillmentMethodPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
