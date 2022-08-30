package com.qa.listeners;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.observer.entity.MediaEntity;

import com.qa.main.BaseTest;
import com.qa.reports.ExtentManager;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;

public class TestListener implements ITestListener {
	
	private static ExtentReports extent = ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	protected BaseTest base = new BaseTest();
	protected TestUtils utils = new TestUtils();

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName() + " :: " + 
				result.getMethod().getMethodName()).assignAuthor("Test She")
				.assignCategory("Sample Category").assignDevice(base.getDeviceName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
		utils.log().info("Test Status: PASSED");
	}

	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		extentTest.get().log(Status.SKIP, m);
		utils.log().info("Test Status: SKIPPED");
	}
	
	public void onTestFailure(ITestResult result) {
		if(result.getThrowable() != null) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		result.getThrowable().printStackTrace(pw);
		System.out.println(sw.toString());
		}
		
		String methodName = result.getMethod().getMethodName();
//		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//		extentTest.get().fail("<details><summary><b><font color=red>" + 
//								"Exception Occured, click to see details:"+ "</font></b></summary>" + 
//								exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
		
		extentTest.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
		extentTest.get().fail(result.getThrowable());
		
		AppiumDriver driver = ((BaseTest)result.getInstance()).getDriver();
		String path = captureScreenshot(driver, result.getMethod().getMethodName());
		extentTest.get().fail("<b><font color=red>" + "Screenshot of failure:" + "</font</b>", 
								MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
//		String logText = "<b>Test Method " + methodName + " Failed</b>";
//		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//		extentTest.get().log(Status.FAIL, m);
		
		utils.log().info("Test Status FAILED. Please the error below: \n", result.getThrowable());
	}
	


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}
	
	public String captureScreenshot(AppiumDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("===============================================");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("===============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getScreenshotName(String methodName) {
		Date date = new Date();
		String fileName = methodName + "_" + date.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

}
