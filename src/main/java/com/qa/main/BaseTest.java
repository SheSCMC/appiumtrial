package com.qa.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.ThreadContext;

import com.aventstack.extentreports.Status;
import com.qa.listeners.TestListener;
import com.qa.pages.AccountPage;
import com.qa.pages.BrandPage;
import com.qa.pages.ChangeFulfillmentMethodPage;
import com.qa.pages.CheckoutPage;
import com.qa.pages.EditAddressDetailsPage;
import com.qa.pages.FoodPage;
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
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {
	protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	protected WebDriverWait wait;
	protected static ThreadLocal <Properties> props = new ThreadLocal<Properties>();
	protected static ThreadLocal <String> platform = new ThreadLocal<String>();
	protected static ThreadLocal <HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <String> string = new ThreadLocal<String>();
	protected static ThreadLocal <String> dateTime = new ThreadLocal<String>();
	protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
	private static AppiumDriverLocalService server;
	protected TestUtils utils = new TestUtils();
	
	protected HomePage homepage;
	protected AccountPage accountPage;
	protected MyAddressesPage myAddresses;
	protected EditAddressDetailsPage addressDetails;
	protected MainSignUpLoginPage mainPage;
	protected ShopsPage shopsPage;
	protected FoodPage foodPage;
	protected BrandPage brandPage;
	protected ProductDetailsPage productDetailsPage;
	protected CheckoutPage checkoutPage;
	protected ChangeFulfillmentMethodPage changeFulfillment;
	protected PaymentMethodPage paymentMethod;
	protected OrderSuccessPage orderSuccess;	
	protected OrderTrackerPage orderTracker;
	protected OverAllCartPage overallCart;
	protected ShopCartPage shopCart;
	protected iPAY88SavedCCPage ipay88SavedCC;
	protected iPAY88CreditDebitCardPage ipay88CCDB;
	protected iPAY88ACSPage ipay88ACS;
	protected OrderDetailsPage orderDetails;
	
	  public AppiumDriver getDriver() {
		  return driver.get();
	  }
	  
	  public void setDriver(AppiumDriver driver2) {
		  driver.set(driver2);
	  }
	  
	  public Properties getProps() {
		  return props.get();
	  }
	  
	  public void setProps(Properties props2) {
		  props.set(props2);
	  }
	  
	  public String getPlatform() {
		  return platform.get();
	  }
	  
	  public void setPlatform(String platform2) {
		  platform.set(platform2);
	  }
	  
	  public HashMap<String, String> getStrings() {
		  return strings.get();
	  }
	  
	  public void setStrings(HashMap<String, String> strings2) {
		  strings.set(strings2);
	  }
	  
	  public String getDateTime() {
		  return dateTime.get();
	  }
	  
	  public void setDateTime(String dateTime2) {
		  dateTime.set(dateTime2);
	  }
	  
	  public String getDeviceName() {
		  return deviceName.get();
	  }
	  
	  public void setDeviceName(String deviceName2) {
		  deviceName.set(deviceName2);
	  }
	
	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@BeforeSuite
	public void beforeSuite() throws Exception, Exception {
		ThreadContext.put("ROUTINGKEY", "ServerLogs");
		
		//This is for Windows 
//		server = getAppiumServiceDefault();
		
		//This is for Mac and also working for Windows
		server = getAppiumService();
		
		if (!checkIfAppiumServerIsRunning(4723)) {
			server.start();
			server.clearOutPutStreams();
			utils.log().info("Appium Server started.");
		} else {
			utils.log().info("Server is already running.");
		}
	}
	
	public boolean checkIfAppiumServerIsRunning(int port) throws Exception{
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			System.out.println("1");
			isAppiumServerRunning = true;
		} finally {
			socket = null;
		}
		return isAppiumServerRunning;
	}
	
	@AfterSuite
	public void afterSuite() {
		server.stop();
		utils.log().info("Appium Server stopped.");
	}
	
//	This is for Windows to start the appium server programmatically 
//	(just in case this default option won't work, use the option to be used for Mac below)
	public AppiumDriverLocalService getAppiumServiceDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}
	
	//This is for Mac to start the appium server programmatically (can be used also for Windows just change the .withAppiumJS path)
	public AppiumDriverLocalService getAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();
//		environment.put("PATH", "insert the path here" + System.getenv("PATH"));
//		environment.put("PATH", "insert the android sdk tools path here");
//		environment.put("ANDROID_HOME", "insert the android home path here");
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")) //path where node js installed
				.withAppiumJS(new File("C:\\Users\\she.viernes\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) //path where the appium is installed
				.usingPort(4723)
//				.withEnvironment(environment)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withLogFile(new File("ServerLogs/server.log")));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		((CanRecordScreen) getDriver()).startRecordingScreen();
	}
	
	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		
		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
		
		Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
		
		String directory = "videos" + File.separator + params.get("platformName") + "_" + params.get("deviceName") + File.separator 
				+ getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
		
		File videoDir = new File(directory);
		
		synchronized(videoDir){
			if(!videoDir.exists()) {
				videoDir.mkdirs();
			}
		}
		
		try {
			FileOutputStream stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
			stream.write(Base64.decodeBase64(media));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	  @Parameters({"emulator", "platformName", "deviceName", "udid", "systemPort", "chromeDriverPort"})
	  @BeforeClass
	  public void beforeClass(@Optional("androidOnly")String emulator, @Optional("androidOnly") String platformName, String deviceName, String udid,
			  String systemPort, String chromeDriverPort) throws Exception {
		  
		  setDateTime(utils.dateTime());
		  setPlatform(platformName);
		  setDeviceName(deviceName);
		  URL url;
		  InputStream inputStream = null;
		  InputStream stringInput = null;
		  Properties props = new Properties();
		  AppiumDriver driver;
		  
		//Route the logs to separate file for each thread
		  String strFile = "logs/" + File.separator + platformName + "_" + deviceName;
		  File logFile = new File (strFile);
		  if (!logFile.exists()) {
			  logFile.mkdirs();
		  }
		  ThreadContext.put("ROUTINGKEY", strFile);
		  
		  try {
			  props = new Properties();
			  String propFileName = "config.properties";
			  String xmlFileName = "strings/strings.xml";
			  
			  utils.log().info("load " + propFileName);
			  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			  props.load(inputStream);
			  setProps(props);
			  
			  utils.log().info("load " + xmlFileName);
			  stringInput = getClass().getClassLoader().getResourceAsStream(xmlFileName);
			  utils = new TestUtils();
			  setStrings(utils.parseStringXML(stringInput));
			  
			  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
				
			  desiredCapabilities.setCapability("platformName", platformName);
			  desiredCapabilities.setCapability("appium:deviceName", deviceName);
			  desiredCapabilities.setCapability("appium:udid", udid);
			  desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
			  desiredCapabilities.setCapability("appium:automationName", props.getProperty("androidAutomationName"));
//			  if(emulator.equalsIgnoreCase("true")) {
//				  desiredCapabilities.setCapability("appium:deviceName", deviceName);
//			  } 
			  desiredCapabilities.setCapability("appium:systemPort", systemPort);
			  desiredCapabilities.setCapability("appium:chromeDriverPort", chromeDriverPort);
			  url = new URL(props.getProperty("appiumURL"));
				    
			  driver = new AndroidDriver(url, desiredCapabilities);
			  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			  setDriver(driver);
		  } catch (Exception e) {
			  e.printStackTrace();
		  } finally {
			  if(inputStream != null) {
				  inputStream.close();
			  } 
			  if (stringInput != null) {
				  stringInput.close();
			  }
		  }
		  
		  homepage = new HomePage();
		  accountPage = new AccountPage();
		  myAddresses = new MyAddressesPage();
		  addressDetails = new EditAddressDetailsPage();
		  mainPage = new MainSignUpLoginPage();
		  shopsPage = new ShopsPage();
		  foodPage = new FoodPage();
		  brandPage = new BrandPage();
		  productDetailsPage = new ProductDetailsPage();
		  checkoutPage = new CheckoutPage();
		  changeFulfillment = new ChangeFulfillmentMethodPage();
		  paymentMethod = new PaymentMethodPage();
		  orderSuccess = new OrderSuccessPage();
		  orderTracker = new OrderTrackerPage();
		  overallCart = new OverAllCartPage();
		  shopCart = new ShopCartPage();
		  ipay88SavedCC = new iPAY88SavedCCPage();
		  ipay88ACS = new iPAY88ACSPage();
		  ipay88CCDB = new iPAY88CreditDebitCardPage();
		  orderDetails = new OrderDetailsPage();

	  }
	  
	  public void waitForVisibility(MobileElement e) {
//		  wait.until(ExpectedConditions.presenceOfElementLocated(e));
		  wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
		  wait.until(ExpectedConditions.visibilityOf(e));
	  }
	  
	  public void click(MobileElement e) {
		  waitForVisibility(e);
		  e.click();
	  }
	  
	  public void click(MobileElement e, String msg) {
		  waitForVisibility(e);
		  utils.log().info(msg);
//		  ExtentManager.test.log(Status.INFO, msg);
		  TestListener.extentTest.get().log(Status.INFO, msg);
		  e.click();
	  }
	  
	  public void sendKeys(MobileElement e, String txt) {
		  waitForVisibility(e);
		  e.sendKeys(txt);
	  }
	  
	  public void sendKeys(MobileElement e, String txt, String msg) {
		  waitForVisibility(e);
		  utils.log().info(msg);
		  TestListener.extentTest.get().log(Status.INFO, msg);
		  e.sendKeys(txt);
	  }
	  
	  public String getAttribute(MobileElement e, String attribute) {
		  waitForVisibility(e);
		  return e.getAttribute(attribute);
	  }
	  
	  @AfterClass
	  public void afterClass() {
//		  driver.closeApp();
		  if(getDriver() != null){
			  getDriver().quit();
		  }
	  }

}
