package com.cbs.AppiumAutomat.appiumMethods;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Calculator extends AppSetup{
	
	
	public void add_2Numbers(int firstNumber, int secondNumber) {
		 
		driver.findElement(By.id("com.android.calculator2:id/digit_"+firstNumber)).click();
		driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_"+secondNumber)).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		int result = Integer.parseInt((driver.findElement(By.id("com.android.calculator2:id/result")).getText()));
		Assert.assertEquals((firstNumber + secondNumber), result);		
	}
	public void multiply_2Numbers(int firstNumber, int secondNumber) {
		
		driver.findElement(By.id("com.android.calculator2:id/digit_"+firstNumber)).click();
		driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_"+secondNumber)).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		int result = Integer.parseInt((driver.findElement(By.id("com.android.calculator2:id/result")).getText()));
		Assert.assertEquals((firstNumber * secondNumber), result);	
	}
	
	public void devide_2Numbers(int firstNumber, int secondNumber) {
		
		 
		driver.findElement(By.id("com.android.calculator2:id/digit_"+firstNumber)).click();
		driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_"+secondNumber)).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		double result = Float.parseFloat((driver.findElement(By.id("com.android.calculator2:id/result")).getText()));
		Assert.assertEquals((firstNumber / secondNumber), result);		
	}

}
