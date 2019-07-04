package com.cbs.AppiumAutomat.appiumMethods;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SMS_Sender extends AppSetup {

	public String sendText(String Actualmessage) {

		driver.findElement(By.id("com.google.android.apps.messaging:id/start_new_conversation_button")).click();
		driver.findElement(By.id("com.google.android.apps.messaging:id/contact_name")).click();
		driver.findElement(By.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys(Actualmessage);
		driver.findElement(By.id("com.google.android.apps.messaging:id/send_message_button_icon")).click();

		String expectedMessage =  driver.findElement(By.id("com.google.android.apps.messaging:id/message_text")).getText();
		Assert.assertEquals(Actualmessage, expectedMessage);

		System.out.println("Text message has been successfully sent!");
		return Actualmessage;
	}

}
