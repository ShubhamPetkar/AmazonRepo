package Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testClass.BaseTest;
import utility.ScreenShot;

public class TestNGListeners extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentReportGen.extentReportGenerator();
	public static ExtentTest test ;
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been started");
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been passed");
		test.log(Status.PASS, "Test case is passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been failed");
		try 
		{
			ScreenShot.captureWithPath(driver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(ScreenShot.captureWithPath(driver, result.getName()));
		}
		catch (IOException e) 
		{
			System.out.println("Exception arrived catch is executing");
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case :"+result.getMethod().getMethodName()+" has been skipped");
		test.log(Status.SKIP, "Test case got skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Test tag "+context.getName()+" has been started");
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Test tag "+context.getName()+" has been finished");
		extent.flush();
	}
}
