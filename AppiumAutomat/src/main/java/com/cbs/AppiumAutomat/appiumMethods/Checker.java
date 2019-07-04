package com.cbs.AppiumAutomat.appiumMethods;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Checker {
	
	//File pReader = new File("C:\\Users\\SamsonOluwashola\\Downloads");
	File pReader = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\appLocation");
	File fReader = new File(pReader, "General-Store.apk");
	//File fReader = new File(pReader, "ApiDemos-debug.apk");
	
	AndroidDriver<AndroidElement> driver;
	@Test
	public void checkSetup() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
							cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
							cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
							cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
							cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
							//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,20);
							cap.setCapability("newCommandTimeout", 10); 							
//							cap.setCapability("appPackage", "com.google.android.apps.messaging");
//							cap.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
							//cap.setCapability("appActivity", "com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
//							cap.setCapability("appActivity", "com.android.calculator2.Calculator");
//							cap.setCapability("appPackage", "com.android.calculator2");
							//cap.setCapability("appPackage", "com.google.android.apps.youtube.app.application.ShellSHomeActivity");
							cap.setCapability(MobileCapabilityType.APP, fReader.getAbsolutePath());
							cap.setCapability("automationName", "UiAutomator2");
							try {
								driver = new AndroidDriver<AndroidElement>(new URL("http:/127.0.0.1:4723/wd/hub"), cap);
							} catch (MalformedURLException e) {
								 System.out.println(" Could not connect to Appium server, Check that server is running!");
								 e.printStackTrace();
							}
							
//							
//							driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
//							driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
//							driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();
//							driver.findElement(By.id("com.android.calculator2:id/eq")).click();
//							int result = Integer.parseInt((driver.findElement(By.id("com.android.calculator2:id/result")).getText()));
//							Assert.assertEquals((15), result);
//							
	}

}
