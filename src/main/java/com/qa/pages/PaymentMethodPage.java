package com.qa.pages;

import com.qa.main.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PaymentMethodPage extends BaseTest{

	//Element Locators
	@AndroidFindBy (accessibility = "Cash") 
	private MobileElement idCashBtn;
	
	@AndroidFindBy (accessibility = "Confirm and Pay") 
	private MobileElement idConfirmAndPayBtn;
	
	@AndroidFindBy (accessibility = "Add Card") 
	private MobileElement idAddCardBtn;
	
	@AndroidFindBy (accessibility = "•••• •••• •••• 1047") 
	private MobileElement idSavedCCJCB1047;
	
	@AndroidFindBy (accessibility = "•••• •••• •••• 2630") 
	private MobileElement idSavedCCAMEX2630;
	
	@AndroidFindBy (accessibility = "Credit / Debit Card") 
	private MobileElement idCreditDebitOption;
	
    public Boolean verifyPresenceOfSavedCCJCB1047() {
    	return idSavedCCJCB1047.isDisplayed();
    }
	
	public OrderSuccessPage proceedOnCashPayment() {
		utils.log().info("Select CASH as payment method and proceed");
		click(idCashBtn);
		click(idConfirmAndPayBtn);

		return new OrderSuccessPage();
	}
	
	public iPAY88SavedCCPage proceedOnSavedCCPayment() {
		utils.log().info("Tap a saved Credit/Debit Card and confirm the selection");
		click(idSavedCCJCB1047);
		click(idConfirmAndPayBtn);

		return new iPAY88SavedCCPage();
	}
	
	public iPAY88CreditDebitCardPage proceedOnCreditDebitPayment() {
		utils.log().info("Select the Credit/Debit Cart option and confirm the selection");
		click(idCreditDebitOption);
		click(idConfirmAndPayBtn);

		return new iPAY88CreditDebitCardPage();
	}
	
//    public PaymentMethodPage(AppiumDriver driverFromMainClass, TouchAction touch) {
//    	this.driver = driverFromMainClass;
//    	this.touchAction = touch;
//    }
}
