package com.Listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyListener implements ITestListener{
	
	protected static WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;

	public void onFinish(ITestContext context) {		
		System.out.println("I'm in Finish");
		reports.endTest(test);
		reports.flush();
	}

	public void onStart(ITestContext context) {
		System.out.println("I'm in Start");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("I'm in onTestFailedButWithinSuccessPercentage");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("I'm in onTestFailure");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Accenture-Pratiksha\\Screenshots" + result.getMethod().getMethodName() + ".png"));
			String file = test.addScreenCapture("C:\\Accenture-Pratiksha\\Screenshots" + result.getMethod().getMethodName() + ".png");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {		
		System.out.println("I'm in onTestSkipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("I'm in onTestStart");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("I'm in onTestSuccess");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}
	

}
