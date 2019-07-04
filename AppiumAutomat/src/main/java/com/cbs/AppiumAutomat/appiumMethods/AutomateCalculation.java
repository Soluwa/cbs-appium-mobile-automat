package com.cbs.AppiumAutomat.appiumMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomateCalculation extends AppSetup {

	Calculator calculator  = new Calculator();
	@BeforeTest
	public void setUp() {
		
		AppSetup.launchApp("emulator-5556", "9", "com.android.calculator2", "com.android.calculator2.Calculator");
	}
	@Test
	public void calculate() {
		 calculator.add_2Numbers(6, 9);
	}
	
   }
