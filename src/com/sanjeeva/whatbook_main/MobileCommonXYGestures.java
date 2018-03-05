package com.sanjeeva.whatbook_main;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sanjeeva.whatbook_test.CommonWhatbookObjects;
import com.sanjeeva.whatbook_test.LaunchApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

public class MobileCommonXYGestures extends LaunchApp{


	public void aa() {
	
	//driver.findElementByAccessibilityId("Have an account already? Sign in").click();;
			//FluentWait<WebDriver> wait = new WebDriverWait(driver, 5);
			//try {
				
			//	wait.until(ExpectedConditions.titleContains(CommonWhatbookObjects.loginLink.getText()));
			//}
			//catch(Exception e) {
				
			//	System.out.println("Element not found...");
			//}
			
			//CommonWhatbookObjects.loginLink.click();		
			
			//try {
				
			//	wait.until(ExpectedConditions.visibilityOf(CommonWhatbookObjects.singIn));
			//	CommonWhatbookObjects.emailAddress.sendKeys("sanjeeva.geejula+25@hedgehoglab.com");
			//	CommonWhatbookObjects.password.sendKeys("Passw0rd");
			//	CommonWhatbookObjects.singIn.click();
			//}
			//catch(Exception e) {
			//	System.out.println("Not able to login");
			//}
			
			//try {
			//	wait.until(ExpectedConditions.alertIsPresent());
			//	driver.findElementByAccessibilityId("Allow").click();
			//}
			//catch(Exception e) {
			//	System.out.println("No Dialog is shown");
			//}

			
			//if(CommonWhatbookObjects.loginLink.isDisplayed()){
				
				//CommonWhatbookObjects.loginLink.click();
			//}
			//else
			//	System.out.println("Object did not found");
	}
	
	public static void tapElement(int x, int y)
	{
		try {
			(new TouchAction(driver)).tap(x, y).perform();
		}
		catch(Exception e) {
			
			System.out.println("Element not found");
			
			e.printStackTrace();
		}
	}
	
	
	public static void searchBox6s(String str) {
	(new TouchAction(driver)).tap(157, 86).perform();
	MobileElement searchBox = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeTable[@name=\"Empty list\"])[2]");
	searchBox.click();
	searchBox.clear();
	searchBox.sendKeys(str);
	}
	
	public static void searcBoxReader6s() {
		(new TouchAction(driver)).tap(157, 86).perform();
		MobileElement searchBox = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeTable[@name=\"Empty list\"])[2]");
		searchBox.click();
		searchBox.sendKeys("sanjeev");
		MobileElement reader = (MobileElement) driver.findElementByAccessibilityId("Reader");
		reader.click();
	}
	
	public static void thumbsUP6s() {
		(new TouchAction(driver)).tap(343, 46).perform();
	}
	
	public static void bookshelf6ss() {
		(new TouchAction(driver)).tap(234, 648).perform();
	}
	
	
}
