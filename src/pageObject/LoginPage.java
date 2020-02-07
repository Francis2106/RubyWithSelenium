package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import seleniumUtility.SeleniumWebdriver;

public class LoginPage extends SeleniumWebdriver{
	// Verify the Hompe page Options
	private static By Home = By.xpath("//a [@id ='1']");
	public static By About_btn = By.xpath(" //a [@id ='2']");
    public static By Trending_btn = By.xpath(" //a [@id ='4']");
    public static By Contact_btn = By.xpath(" //a [@id ='5']");
    
    //Verify the Contact us optios validation
    
    public static By Name = By.xpath("//input[@id='con-name']");
    public static By Email = By.xpath("//input[@id='con-email']");
    public static By MobileNumber = By.xpath("//input[@id='con-mno']");
    public static By Message = By.xpath("//div[@class='contact-bottom col-xs-12 col-md-5 text-left col-sm-6']/div[4]");
    public String message = " Hi this is antony dass, I like this app";

	public LoginPage(){
		PageFactory.initElements(SeleniumWebdriver.driver, this);
		waitForElement(Home, 60);		
	}
	// Invalid Username Credentials 
	
	public void VerifyHomepageoptions() throws InterruptedException{
		Thread.sleep(5000);
		ClickElement(About_btn);
		ClickElement(Trending_btn);
		ClickElement(Contact_btn);	
		ClickElement(Home);
	}
	public void VerifyContactUsField(){
		ClickElement(Contact_btn);
		ClickElement(Name);
		typeCharacter(Name, "Antony");
		ClickElement(Email);
		typeCharacter(Email, "antony602@gmail.com");
		ClickElement(MobileNumber);
		typeCharacter(MobileNumber, "9176450707");
		ClickElement(Message);
		typeCharacter(Message, "message");
		
		
		
		
		
//		String actual = driver.findElement(Alertmsg).getText();
//		String Expected = "Please enter valid Email ID/Mobile number";		
//		Assert.assertEquals("This test is pass", Expected, actual);			
	}
	// Invalid Password Credentials 
	
	public void InvalidVerifyContactUsField(){
		ClickElement(Name);
		typeCharacter(Name, "123456");
		ClickElement(Email);
		typeCharacter(Email, "antony602gmail.com");
		ClickElement(MobileNumber);
		typeCharacter(MobileNumber, "Number");
		ClickElement(Message);
		typeCharacter(Message, "");
		}
//			String actual = driver.findElement(Wrongpasswordalert).getText();
//			String Expected = "Your username or password is not correct";		
//			Assert.assertEquals("This test is pass", Expected, actual);	
//			System.out.println(actual);
//		}
	
	// Login The Application : Verify the Correct Credentials //
	
	
		
	
				
			
		}
		 
		
	
	
