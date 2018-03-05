package com.sanjeeva.whatbook_elements;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.sanjeeva.whatbook_test.LaunchApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WhatbookElements extends LaunchApp{
	
	//public static AppiumDriver<MobileElement> driver;
	
	//public WhatbookElements(AppiumDriver<MobileElement> driver) {
	//this.driver=driver;
	//	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	//}
	

	//@iOSFindBy(accessibility="I've Read This")
	//private static MobileElement ivereadThis; 
	
	public static void iHaveRead() {
		
		MobileElement ivereadThis = (MobileElement) driver.findElementByAccessibilityId("I've Read This");
		ivereadThis.click();
	}
	
	public static void loginLink() {
		
		MobileElement loginLink = (MobileElement) driver.findElementByAccessibilityId("Have an account already? Sign in");
		
		loginLink.click();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	
	public static void loginCredentials(String email, String Password) throws InterruptedException {
	
		try {
		
		MobileElement emailAddress = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Whatbook\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]");
		
		MobileElement password = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Whatbook\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]");

		emailAddress.sendKeys(email);
		Thread.sleep(2000);
		
		(new TouchAction(driver)).tap(32, 172).perform();
	
		password.sendKeys(Password);

		Thread.sleep(5000);

		MobileElement singIn = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign in\"]");
		singIn.click();
		
		driver.findElement(By.name("Allow")).click();
		
		}
		catch(Exception e) {
			System.out.println("Expected screen is not shown, Check for internet connection ");
			driver.findElement(By.name("OK")).click();
		}
		
	}
	
	public static void iWantToRead(){
		
		MobileElement iWantToRead = (MobileElement) driver.findElementByAccessibilityId("Add to List");
		
		if(iWantToRead.isEnabled()) {
			
			iWantToRead.click();
			
			driver.findElement(By.name("I Want To Read This")).click();
		}
		else
		{
			driver.navigate().back();
		}
		
		//var theSpan = document.getElementById("thespan");
		//theSpan.addEventListener('click', function() { alert("You clicked!")}, false);
	}
	
	public static void closeTitleView() {
		
		MobileElement closeTitleView = (MobileElement) driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Whatbook\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]");
		
		closeTitleView.click();
	}
	
	public static void follow() {
		
		try {
			
			MobileElement follow = (MobileElement) driver.findElementByAccessibilityId("Follow");
		follow.click();
		}
		catch(Exception e){
			MobileElement following = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Following\"]");
			//MobileElement following = (MobileElement) driver.findElementByAccessibilityId("Following");
			if(following.isDisplayed())
			following.click();
			
		}

		/**
		if(follow.isDisplayed()) {
			follow.click();
		}
		else if(following.isDisplayed()){
		
		}
		NoSUch
		if(driver.findElement(By.name("Follow")).isDisplayed()) {
			driver.findElement(By.name("Follow")).click();
		}
		if(driver.findElement(By.name("Following")).isDisplayed()){
			driver.navigate().back();
		}*/
		
	}
	
	public static void recommend() {
		
		MobileElement recommend = (MobileElement) driver.findElementByAccessibilityId("Recommend");
		recommend.click();
	}
	
	public static void currentlyReading() {
		
	}
	
	public static void profileIcon() {
		
		MobileElement profileIcon = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"3 followers\"])[3]");
		
		profileIcon.click();
	}
	
	public static void findYourBook() {
		
		MobileElement findYourBook = (MobileElement) driver.findElementByAccessibilityId("Find your book");
		
		findYourBook.click();
	}
	
	public static void bookshelfs() {
		
		
		MobileElement bookshelf = (MobileElement) driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"3 followers\"])[2]");
		
		
		bookshelf.click();
	}
	
	public static void pluseAddCollection() {
		
		MobileElement pluseAddCollection = (MobileElement) driver.findElementByAccessibilityId("Add");
		
		pluseAddCollection.click();
	}
	


}
