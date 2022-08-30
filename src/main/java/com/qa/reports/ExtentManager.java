package com.qa.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {
	
	public static ExtentReports extent;
//	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		
		extent = new ExtentReports();
//		spark = new ExtentSparkReporter("Extentreport.html");
		extent.attachReporter(spark);
		
		spark.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.EXCEPTION, ViewName.DEVICE, ViewName.CATEGORY, ViewName.AUTHOR}).apply();		
		spark.config().setReportName("Shopper App - Automation Test Report");
		spark.config().setDocumentTitle("Shopper App Test Summary");
		
		return extent;
	}
	
	public static String getReportName() {
		Date d = new Date();
		String filename = "ShopperApp" + "_" + d.toString().replace(":", "_").replace(" ", "_");
		return filename;
	}
}
