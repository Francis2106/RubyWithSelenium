package testClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import testBaseClass.TestBaseClass;


public class LoginApp extends TestBaseClass{
	
	
	public LoginPage login;


	// Login page Data Reader Connection  //
	@Test
	public void HomepageOption_TC_001() throws InterruptedException, IOException{
		Thread.sleep(100);
		login.VerifyHomepageoptions();
		
	}
    
				
		@Test
		public void ContactOptioN_TC_002() throws InterruptedException{
			login.VerifyContactUsField();
	
	}
}
	
	

