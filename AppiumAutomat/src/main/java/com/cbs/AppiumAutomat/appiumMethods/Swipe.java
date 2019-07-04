package com.cbs.AppiumAutomat.appiumMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Swipe extends AppSetup{
	
	AndroidGesture gesture = new AndroidGesture();
	
	@BeforeTest
	public void setUp() {
		
		AppSetup.launchApp("emulator-5554", "9", "io.appium.android.apis", "io.appium.android.apis.ApiDemos");
	}
	
	 
	@Test
	public void swipeAction() {
		
		gesture.swipe();			
	}

}
