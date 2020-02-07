package seleniumUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameter;

public class SeleniumWebdriver{
	public static WebDriver driver;
	public static WebDriverWait wait = null;
	
	// Click Action
	public static boolean ClickElement(By Locator){
		driver.findElement(Locator).click();		
		return true;
	}
	// Send Keys Action
	public static boolean typeCharacter(By Locator, String value){
		driver.findElement(Locator).clear();
		driver.findElement(Locator).sendKeys(value);
		return true;
	}
	// Wait For Element
	public static boolean waitForElement(By Locator, int seconds){
		WebDriverWait wait = new WebDriverWait(driver , seconds);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		return true;
		
	}
	// Select Class
	public boolean selectbyvalue(By locator, String value){
		Select selectbyvalue = new Select(driver.findElement(locator));
		selectbyvalue.selectByValue(value);
		return true;
		
	}
	public boolean selectByvisibleText(By locator , String text){
		Select selectbyvisibletext = new Select (driver.findElement(locator));
		selectbyvisibletext.deselectByVisibleText(text);
		return true;
		
	}
	public static boolean waitForPageToLoad(int Seconds) throws InterruptedException{
		Thread.sleep(Seconds);
		return true;
		
	}
	public boolean buttonpresence(By Locator){
		driver.findElement(Locator).isDisplayed();
		return true;
		
	}
	
	
	
	}
