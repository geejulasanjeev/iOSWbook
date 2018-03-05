package com.sanjeeva.whatbook_test;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import com.sanjeeva.whatbook_elements.WhatbookElements;
import com.sanjeeva.whatbook_main.MobileCommonGestures;
import com.sanjeeva.whatbook_main.MobileCommonXYGestures;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.HideKeyboardStrategy;


public class CommonWhatbookObjects extends LaunchApp{

	MobileCommonGestures gestures = new MobileCommonGestures();
	
	 @SuppressWarnings({ "deprecation", "rawtypes" })
	@Test(description="I've Read This", priority=1)
		public void youHaveReadBook() throws InterruptedException {

		 	// searchIcon
		 	MobileCommonXYGestures.tapElement(140, 638);
	
		   	Thread.sleep(5000);
		      
		   	MobileCommonXYGestures.searchBox6s("ABC");
		   	
		   	Thread.sleep(2000);
		 
		   	gestures.iOSKeyboardSearch();

			Thread.sleep(5000);
			
			gestures.tapItemByDescription("ABC Scripts");

			Thread.sleep(5000);
			
			WhatbookElements.iHaveRead();

			WhatbookElements.loginLink();
			
			WhatbookElements.loginCredentials("sanjeeva.geejula+1@hedgehoglab.com","Passw0rd");
			
			Thread.sleep(5000);
	
			WhatbookElements.iHaveRead();
			
			MobileCommonXYGestures.thumbsUP6s();

			WhatbookElements.closeTitleView();	
			
	 }	
	 
	 @Test(description="I want to read this", priority=2)
	 public void iWantToReadThisBook() throws InterruptedException {
		 
		 	// searchIcon
		 	MobileCommonXYGestures.tapElement(140, 638);
		 	Thread.sleep(5000);
		 	
		   	MobileCommonXYGestures.searchBox6s("ABC");
		 
		   	gestures.iOSKeyboardSearch();

			Thread.sleep(5000);
			
			gestures.tapItemByDescription("ABC Scripts");

			Thread.sleep(5000);
			
			//WhatbookElements.iWantToRead();
			MobileElement iWantToRead = (MobileElement) driver.findElementByAccessibilityId("Add to List");
			iWantToRead.click();
			
			WhatbookElements.loginLink();
			
			WhatbookElements.loginCredentials("sanjeeva.geejula+1@hedgehoglab.com","Passw0rd");;
					
			Thread.sleep(3000);
			
			WhatbookElements.iWantToRead();
			
			Thread.sleep(5000);
			MobileCommonXYGestures.bookshelf6ss();
			
			gestures.tapItemByDescription("ABC Scripts");
			
			driver.navigate().back();

			Thread.sleep(2000);
			
			try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        HashMap scrollObject = new HashMap<>();
	        scrollObject.put("predicateString", "value == '" + "ABC Scripts" + "'");
	        js.executeScript("mobile: scroll", scrollObject);
	        MobileElement el = (driver).findElementByIosNsPredicate("value = '" + "ABC Scripts" + "'");
			TouchActions action = new TouchActions(driver);
			action.longPress(el);
			action.perform();
			Thread.sleep(5000);
			}
			catch(Exception e ) {
				System.out.println("No Such Element");
			}
	        
		 
	 }
	 
	 @Test(description="Follow a user", priority=3)
	 public void follow() throws InterruptedException{

		 	// searchIcon
		 	MobileCommonXYGestures.tapElement(140, 638);
		 	Thread.sleep(5000);
		 	
		   	MobileCommonXYGestures.searcBoxReader6s();
		   	
		   	Thread.sleep(5000);
			
			gestures.tapItemByDescription("sanjeevaa");
		 
			Thread.sleep(5000);
			
			WhatbookElements.follow();
			
			WhatbookElements.loginLink();
			
			WhatbookElements.loginCredentials("sanjeeva.geejula+1@hedgehoglab.com","Passw0rd");;
		
			Thread.sleep(3000);
			
			WhatbookElements.follow();
			Thread.sleep(5000);
			
	 }
	 
	 @Test(description="recommend", priority=4)
	 public void recommend() throws InterruptedException{
		 
		 
		 	// searchIcon
		 	MobileCommonXYGestures.tapElement(140, 638);
		 	Thread.sleep(5000); 
		 	
		   	MobileCommonXYGestures.searchBox6s("ABC");
		 
		   	gestures.iOSKeyboardSearch();

			Thread.sleep(5000);
			
			gestures.tapItemByDescription("ABC Scripts");

			Thread.sleep(5000);
			
			WhatbookElements.recommend();
			WhatbookElements.loginLink();
			
			WhatbookElements.loginCredentials("sanjeeva.geejula+1@hedgehoglab.com","Passw0rd");;
		
			Thread.sleep(5000);
			
			WhatbookElements.recommend();
			Thread.sleep(3000);
		 
	 }
	 
	 @Test(description="Currently Reading", priority=5)
	 public void currentlyReading() throws InterruptedException{
		 
		    WhatbookElements.profileIcon();
		    Thread.sleep(2000);
			WhatbookElements.loginLink();
			
			WhatbookElements.loginCredentials("sanjeeva.geejula+1@hedgehoglab.com","Passw0rd");;
		
			Thread.sleep(5000);
			WhatbookElements.findYourBook();
			
			MobileCommonXYGestures.searchBox6s("ABC");
			
			gestures.iOSKeyboardSearch();

			Thread.sleep(5000);
			
			gestures.tapItemByDescription("ABC Scripts");

			Thread.sleep(5000);
			
			gestures.tapItemByDescription("ABC Scripts");
			
			driver.findElement(By.name("Remove")).click();
			Thread.sleep(5000);
		 
	 }
	 
	 @Test(description="Collections", priority=6)
	 public void collection() throws InterruptedException{
	
		 WhatbookElements.bookshelfs();
		 
		 Thread.sleep(2000);
		 
			WhatbookElements.loginLink();
			
			WhatbookElements.loginCredentials("sanjeeva.geejula+1@hedgehoglab.com","Passw0rd");;
		
			Thread.sleep(5000);
			
			gestures.tapItemByDescription("Collections");
			
			//WhatbookElements.pluseAddCollection();
			MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Add");
			el1.click();
			el1.sendKeys("Space");
			
			(driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
			Thread.sleep(5000);
			
			// searchIcon
		 	MobileCommonXYGestures.tapElement(140, 638);
			Thread.sleep(2000);
			MobileCommonXYGestures.searchBox6s("ABC");
			gestures.iOSKeyboardSearch();
			Thread.sleep(5000);
			gestures.tapItemByDescription("ABC Scripts");

			MobileElement iWantToRead = (MobileElement) driver.findElementByAccessibilityId("Add to List");
			iWantToRead.click();
			driver.findElement(By.name("Space")).click();
			Thread.sleep(5000);
			driver.navigate().back();
			//WhatbookElements.bookshelfs();
			(new TouchAction(driver)).tap(234, 641).perform();
			Thread.sleep(3000);
			MobileElement collection1 = (MobileElement) driver.findElementByAccessibilityId("1");
			collection1.click();
			(new TouchAction(driver)).tap(349, 38).perform();
			
			MobileElement deleteCollection = (MobileElement) driver.findElementByAccessibilityId("Delete Collection");
			deleteCollection.click();
			driver.findElement(By.name("Delete")).click();
			Thread.sleep(5000);	
		 
	 }
	 

}
