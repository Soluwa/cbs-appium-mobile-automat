package com.cbs.AppiumAutomat.appiumMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendMessage extends AppSetup{
	
	SMS_Sender sender = new SMS_Sender();
	
	@BeforeTest
	public void setUp() {
		
		AppSetup.launchApp("emulator-5556", "9", "com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.ConversationListActivity");
	}
	@Test
	public void sendText() {
		
		sender.sendText("Hi, how is your day going? just made a pull request, can you review the code so that we can merge to develop branch. thanks");
	}
}
