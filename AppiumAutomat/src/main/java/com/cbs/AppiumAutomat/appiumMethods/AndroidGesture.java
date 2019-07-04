package com.cbs.AppiumAutomat.appiumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.List;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidGesture extends AppSetup{
	
	public void longPress() {
		
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		 
		
		WebElement view = driver.findElementByAndroidUIAutomator("text(\"Views\")");
				   view.click();
	    WebElement expandList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
	               t.tap(tapOptions().withElement(element(expandList))).perform();
 	    WebElement customAdaptor = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
 	               t.tap(tapOptions().withElement(element(customAdaptor))).perform();
 	               
  	               
	    WebElement dogName = driver.findElementByAndroidUIAutomator("text(\"Cat Names\")");
	               t.longPress(longPressOptions().withElement(element(dogName)).withDuration(ofSeconds(2))).release().perform();
	    		
 	
	    		String title = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Sample menu']")).getText(); 	
	    		
	    		Assert.assertTrue(title.contentEquals("Sample menu"));
	}
	public void swipe() {
		
		  WebDriverWait waiter = new WebDriverWait(driver, 10);
		WebElement view = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		   view.click();
		   WebElement dateWidget = driver.findElement(By.xpath("//*[@text='Date Widgets']"));
		   waiter.until(ExpectedConditions.visibilityOf(dateWidget));
		   
		   @SuppressWarnings("rawtypes")
			TouchAction t = new TouchAction(driver);
		   t.tap(tapOptions().withElement(element(dateWidget))).perform();
		   
	    WebElement inline = driver.findElementByAndroidUIAutomator("text(\"2. Inline\")");
	    t.tap(tapOptions().withElement(element(inline))).perform();
	    
	    WebElement hour_2 = driver.findElement(By.xpath("//*[@content-desc = '2']"));
	    t.tap(tapOptions().withElement(element(hour_2))).perform();
	    WebElement minute_15 = driver.findElement(By.xpath("//*[@content-desc = '15']"));
	    WebElement minute_40 = driver.findElement(By.xpath("//*[@content-desc = '40']"));
	    
 
 
	    waiter.until(ExpectedConditions.visibilityOf(minute_15));
		t.longPress(longPressOptions().withElement(element(minute_15)).withDuration(ofSeconds(1))).moveTo(element(minute_40)).release().perform();
		String confirm_setMinute =  driver .findElement(By.xpath("//android.widget.TextView[@text='40']")).getText();
		Assert.assertEquals("40", confirm_setMinute);
	    
	}
	 
	 
	public void scroll() {
		// TODO Auto-generated method stub
		WebElement view = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		   view.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollInToView(text(\"WebView\"));");
	}
	public void scrollDown() {
		
		Dimension d = driver.manage().window().getSize();
		
		double scrollHeightStart = d.getHeight()*0.5;
		int scrollStart = (int) scrollHeightStart;
		
		double scrollHeightEnd = d.getHeight()*0.2;
		int scrollEnd = (int) scrollHeightEnd;
		
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
					t.press(PointOption.point(0,(int) scrollStart))
					 .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					 .moveTo(PointOption.point(0, scrollEnd))
					 .release().perform();
	}
	
//	public void scrollToElementAndClick(String element_name_to_scrollTo) {
//		
//		List<AndroidElement> elementInMind = driver.findElements(By.xpath("//android.widget.TextView[@text='" + element_name_to_scrollTo + "']"));
//		while(elementInMind.size() == 0) {
//			
//			scrollDown();
//			
//			if(elementInMind.size() > 0) {				
//				elementInMind.get(0).click();
//			}
//		}
//	}
	public void scrollToElementAndClick(String element_name_to_scrollTo) {
		// TODO Auto-generated method stub
		
//		String part1 = "//android.widget.TextView[@text='";
//		String part2 = "']";
		//String completeXpath = part1+element_name_to_scrollTo+part2;
		//List<AndroidElement> elementInMind = driver.findElements(By.xpath("//android.widget.TextView[@text='" + element_name_to_scrollTo + "']"));
		List<AndroidElement> elementInMind = driver.findElements(By.xpath("//android.widget.TextView[@text='" + element_name_to_scrollTo + "']"));
		while(elementInMind.size() == 0) {
			
			scrollDown();
			
			if(elementInMind.size() > 0) {				
				elementInMind.get(0).click();
			}
		}
	}
	public void clickElement(String elementToClick) {
		
//		String part1 = "//android.widget.TextView[@text='";
//		String part2 = "']";
//		String completeXpath = part1+elementtoClick+part2;
	WebElement view = driver.findElement(By.xpath("//android.widget.TextView[@text = ' $elementToClick  ']"));
//		WebElement view = driver.findElement(By.xpath(completeXpath));
//		
// 		   view.click();
		
		//WebElement view = driver.findElementByAndroidUIAutomator("text(${elementToClick})");
		   view.click();
		
		
	}

}
