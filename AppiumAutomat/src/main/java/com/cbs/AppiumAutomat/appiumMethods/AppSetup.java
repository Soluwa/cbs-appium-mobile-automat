package com.cbs.AppiumAutomat.appiumMethods;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppSetup {

//	public static void main(String[] args) {
//
//		launchApp("emulator-5556", "9", "com.android.calculator2", "com.android.calculator2.Calculator");
//	}
	
  public static AndroidDriver<AndroidElement> driver;

	public static void launchApp(String deviceName, String platformVersion, String appPackage, String appActivity) {	

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("newCommandTimeout", 10); 	
		 
		try {
			 driver = new AndroidDriver<AndroidElement>(
					new URL("http:/127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			System.out.println(" Could not connect to Appium server, Check that server is running!");
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



	}

}
