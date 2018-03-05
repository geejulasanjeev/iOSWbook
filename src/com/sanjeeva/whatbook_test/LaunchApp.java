package com.sanjeeva.whatbook_test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;



public class LaunchApp {

	public static IOSDriver<MobileElement> driver;

	
	@Parameters({"deviceName_","UDID_","platformVersion_","URL_"})
	//@BeforeSuite
	@BeforeMethod
		//public void initialiseApplication(String port, String device) throws MalformedURLException{
		public static void initialiseApplication(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException, InterruptedException{
			DesiredCapabilities capabilities =  new DesiredCapabilities();

			capabilities.setCapability("platformVersion", platformVersion_);
			capabilities.setCapability("deviceName", deviceName_);
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("udid", UDID_);
			capabilities.setCapability("noReset", false);
			capabilities.setCapability("xcodeOrgId", "hedgehog lab");
			capabilities.setCapability("automationName","XCUITest");
			capabilities.setCapability("xcodeSigningId","iPhone Developer");
			capabilities.setCapability("autoAcceptAlerts",true);
			//capabilities.setCapability("app","/Users/sanjeevakumar/Desktop/whatbook.app");
			capabilities.setCapability("app","/Users/sanjeevakumar/Desktop/WhatbookQA1.ipa");

			driver = new IOSDriver<MobileElement>(new URL(URL_),capabilities);
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	        
	}
	

		
	//@AfterSuite
	@AfterMethod
		public static void closeApplication()
		{
			driver.quit();	
			
		}
		
		

}
