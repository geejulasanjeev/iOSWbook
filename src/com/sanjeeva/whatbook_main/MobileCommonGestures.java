package com.sanjeeva.whatbook_main;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sanjeeva.whatbook_test.LaunchApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;

public class MobileCommonGestures extends LaunchApp{

	public void scrolltoBottom(String str) {
		
		//driver.findElementByXPath("//*[@value='UpcomingInstallations']").click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}
	
	public void tapItemByDescription(String text) {
        System.out.println("   tapItemByDescription(): " + text);

        // scroll to item
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == '" + text + "'");
        js.executeScript("mobile: scroll", scrollObject);

        // tap item
        //WebElement el = ((IOSDriver) driver).findElementByIosNsPredicate("value = '" + text + "'");
        WebElement el = (driver).findElementByIosNsPredicate("value = '" + text + "'");
        //return tapElement((MobileElement) el);
        el.click();
    }
	
	public void iOSKeyboardSearch() {
		//((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done"); // Done can change to whatever valid on our screen
        //((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE);
        //last_iOSKeyboardKey.click(); //my favourite. last_iOSKeyboardKey you can find by any way you know.
        // last 4 is tap yourself outside in any place on screen outside keyboard e.g. in center of header
		
		(driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Search");
	}
	
	public void loadingIndicator() {
		WebElement waitElement = null;
		 
		//Sets FluentWait Setup
		FluentWait<RemoteWebDriver> fwait = new FluentWait<RemoteWebDriver>(driver)
		        .withTimeout(3, TimeUnit.SECONDS)
		        .pollingEvery(500, TimeUnit.MILLISECONDS)
		        .ignoring(NoSuchElementException.class)
		        .ignoring(TimeoutException.class);
		 
		//First checking to see if the loading indicator is found
		// we catch and throw no exception here in case they aren't ignored
		try {
		  waitElement = fwait.until(new Function<RemoteWebDriver, WebElement>() {
		   public WebElement apply(RemoteWebDriver driver) {
		      return driver.findElement(By.xpath("//AndroidLoading | //iOSLoading"));
		   }
		 });
		    } catch (Exception e) {
		   }
		 
		//checking if loading indicator was found and if so we wait for it to
		//disappear
		  if (waitElement != null) {
		      WebDriverWait wait = new WebDriverWait(driver, 60);
		      wait.until(ExpectedConditions.invisibilityOfElementLocated(
		                 By.xpath("//AndroidLoading| //iOSLoading"))
		            );
		        }
	}
	
	public void longTap() {
		
		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("element");
		TouchActions action = new TouchActions(driver);
		action.longPress(element);
		action.perform();
	}
	
	
	public void moveOnTheScreen() {
		TouchActions action = new TouchActions(driver);
		action.down(10, 10);
		action.move(50, 50);
		action.perform();
	}
	
	public void doubleTap() {
		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("element");
		TouchActions action = new TouchActions(driver);
		action.doubleTap(element);
		action.perform();
	}
	
	public void getElementAttribute() {
		List<MobileElement> element = (List<MobileElement>) driver.findElementByAccessibilityId("SomeAccessibilityID");
		String tagName = ((WebElement) element).getAttribute("content-desc");

	}
	
	public void getCSSValues() {
		
		List<MobileElement> element = (List<MobileElement>) driver.findElementById("SomeId");
		String cssProperty = ((WebElement) element).getCssValue("style");
	}
	
	public void getTagName() {
		List<MobileElement> element = (List<MobileElement>) driver.findElementByAccessibilityId("SomeAccessibilityID");
		String tagName = ((WebElement) element).getTagName();
	}
}
