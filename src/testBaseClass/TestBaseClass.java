package testBaseClass;

import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameter;

import pageObject.LoginPage;
import seleniumUtility.SeleniumWebdriver;
import static org.testng.internal.EclipseInterface.ASSERT_LEFT;
	 import static org.testng.internal.EclipseInterface.ASSERT_MIDDLE;
	 import static org.testng.internal.EclipseInterface.ASSERT_RIGHT;

	 import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
	 import java.net.URL;
	 import java.text.SimpleDateFormat;
	 import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
	 import org.openqa.selenium.OutputType;
	 import org.openqa.selenium.TakesScreenshot;
	 import org.openqa.selenium.WebDriver;
	 import org.openqa.selenium.chrome.ChromeDriver;
	 import org.openqa.selenium.firefox.FirefoxDriver;
	 import org.openqa.selenium.firefox.FirefoxProfile;
	 import org.openqa.selenium.ie.InternetExplorerDriver;
	 import org.openqa.selenium.remote.Augmenter;
	 import org.openqa.selenium.remote.DesiredCapabilities;
	 import org.openqa.selenium.remote.RemoteWebDriver;
	 import org.openqa.selenium.safari.SafariDriver;
	 import org.openqa.selenium.support.ui.WebDriverWait;
	 import org.testng.Assert;
	 import org.testng.ITestResult;
	 import org.testng.Reporter;
	 import org.testng.annotations.AfterMethod;
	 import org.testng.annotations.BeforeMethod;
	 import org.testng.annotations.Parameters;

	

	 public class TestBaseClass{
	 	/**
	 	 * This page object is initialized before the start of every test.
	 	 */
		// protected final Logger log = Logger.getLogger(getClass().getSimpleName());
			
			 @SuppressWarnings("unused")
			 private String logBasePath;
			 private String logFile;
			 protected boolean logTitleMessage(String message1) {
		 			  logCustomMessage().setAttribute(getCurrentDateAndTime(), message1);
		 		
		 	 						
		 	 		//log.info(message1);
		 	 		return true;
	 	 	}
			 protected String getCallingMethodAndLineNumber() {
		 		StackTraceElement[] stackTraceElements = Thread.currentThread()
			 				.getStackTrace();
		
		 		String callingMethodWithLineNumber = stackTraceElements[3].getClassName()
		 				
		 				+ stackTraceElements[3].getMethodName()
			 				+ stackTraceElements[3].getLineNumber();
		
		 		return callingMethodWithLineNumber;
			 	}

				 protected ITestResult logCustomMessage() {
				  return Reporter.getCurrentTestResult();
				 }

				 
				 
		 
		 
	 	protected LoginPage loginPage;

	 	/**
	 	 * For Core Selenium2 functionality
	 	 */
	 	protected static WebDriver driver;
	 	protected WebDriverWait wait;
	 	private final String deliminator = "####";
	 	
	 	/**
	 	 * Standard log4j logger.
	 	 */
	 	

	 	/**
	 	 * To Read the environment details
	 	 */
//	 	EnvironmentPropertiesReader environmentPropertiesReader;
//	 	String notes = null;
//	 	String testLinkResult = null;
//	 	TestLinkAPIClient api = null;

	 	/**
	 	 * Getting the base path of screen shot
	 	 */
	 
	 	

	 	/**
	 	 * Instantiating the driver path
	 	 */
	 	private static final String IE_FILE_PATH = "/src/main/resources/extensions/IEDriverServer.exe";
	 	private static final String CHROME_FILE_PATH = "/home/amtex/Desktop/chromedriver";
	 	private static final String Log1 = "/FlipKart Automation Project/TestData/log4j.properties";

	 	/**
	 	 * For DB connection
	 	 */
	 	//public String filePath = "//Users//kutung2//Desktop//Codings//AC Load Testing//src/com//Authorcafe//Testdata/config.properties";

		

		
	 //	private static DataAccessClient dataAccess = null;

	 	public enum BrowserType {
	 		FIREFOX("firefox"), IE("iexplore"), SAFARI("SAFARI"), CHROME("CHROME");
	 		private String label;

	 		private BrowserType(String label) {
	 			this.label = label;
	 		}

	 		public String Value() {
	 			return label;
	 		}
	 	}

	 	/**
	 	 * Displaying the environment details
	 	 * 
	 	 * @throws IOException
	 	 */

	 	public TestBaseClass() {
	 		//Getting the properties
	 		try {
//	 		PropertyConfigurator.configure(new File(".").getCanonicalPath()
//	 					+ File.separator + "src" + File.separator + "TestData"+File.separator
//	 				    + "log4j.properties");
//	 			String log4j= "/FlipKart Automation Project/TestData/log4j.properties";

//	 			// Location for screenshot
//	 			screenshotBasePath = new File(".").getCanonicalPath()
//	 					+ File.separator + "test-output" + File.separator
//	 					+ "screenshots";

	 			// Location for logs
	 			logBasePath = new File(".").getCanonicalPath() + File.separator
	 					+ "test-output" + File.separator + "logs";

	 			// Instantiating logger
	 			logFile = new File(".").getCanonicalPath() + File.separator
	 					+ "test-output" + File.separator + "temp.log";

	 		} catch (IOException e) {
	 			e.getMessage();
	 		}
	 	}

	 	/**
	 	 * Initializing the DB connection
	 	 * 
	 	 * @return DataAccessClient
	 	 * @throws Exception
	 	 */
	 	/**protected DataAccessClient getDataAccessClient() throws Exception {
	 		if (dataAccess == null) {
	 			dataAccess = new DataAccessClient(
	 					environmentPropertiesReader.getDbDriver(),
	 					environmentPropertiesReader.getDBurl(),
	 					environmentPropertiesReader.getDBusername(),
	 					environmentPropertiesReader.getDBpassword());
	 		}
	 		return dataAccess;
	 	}
	 */
	 	/**
	 	 * Set up logger info
	 	 * 
	 	 * @throws IOException
	 	 * 
	 	 * @throws Exception
	 	 */
	 	@BeforeMethod(alwaysRun = true)
	 	@Parameters({"url","browser","seleniumHost","seleniumPort"})
	 	public final void genericSetUp(String url, String browser, String seleniumHost, String seleniumPort) throws IOException {
	 		// Instantiating Logger

	 		driver = loadURL(url,browser,seleniumHost, seleniumPort);
	 		SeleniumWebdriver.driver = driver;
	 		
	 		
	 		//String fileParam = System.getProperty("selenium.properties.file");
	 	}
	 
	 	/**
	 	 * Returning the driver based on the browser
	 	 * 
	 	 * @param browser
	 	 * @return
	 	 * @throws IOException
	 	 */
	 	public WebDriver loadURL(String url,String browser,String seleniumHost, String seleniumPort) throws IOException {

	 		// Instantiating the browser
	 		driver = getWebDriver(browser,seleniumHost, seleniumPort);
	 		wait = new WebDriverWait(driver, 30);
	 		driver.get(url);
	 		
	 		// Maximize the window
	 		driver.manage().window().maximize();

	 		return driver;

	 	}

	 	/**
	 	 * Returning the driver based on the browser
	 	 * 
	 	 * @param browser
	 	 * @return
	 	 * @throws IOException
	 	 */
	 	public static WebDriver getWebDriver(String browser,String seleniumHost, String seleniumPort) throws IOException {
	 		switch (BrowserType.valueOf(browser)) {
	 		case FIREFOX:
	 			DesiredCapabilities capabilities = new DesiredCapabilities();
	 			FirefoxProfile fireFoxProfile;
	 			if(seleniumHost.contains("localchost")){ 
	 	            fireFoxProfile = new FirefoxProfile(); 
	 	           	driver=new FirefoxDriver(fireFoxProfile);
	 			}else{
	 			// if a matching driver cannot be located
	 			URL url=new URL("http",seleniumHost,Integer.parseInt(seleniumPort),"/wd/hub");
	 			capabilities.setBrowserName(browser);
	 			driver = new RemoteWebDriver(url,capabilities);
	 			} 
	 			return driver;
	 			
	 		case IE:
	 			DesiredCapabilities ieCapabilities = DesiredCapabilities
	 					.internetExplorer();
	 			ieCapabilities.setCapability("nativeEvents", false);
	 			ieCapabilities.setCapability("requireWindowFocus", true);
	 			ieCapabilities
	 					.setCapability(
	 							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	 							true);
	 			ieCapabilities.setCapability("enableElementCacheCleanup", true);
	 			File file = new File(new java.io.File(".").getCanonicalPath()
	 					+ IE_FILE_PATH);
	 			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	 			return new InternetExplorerDriver(ieCapabilities);
	 		case SAFARI:
	 			DesiredCapabilities safariCapabilities = DesiredCapabilities
	 					.safari();
//	 			safariCapabilities.setCapability(
//	 					SafariDriver.CLEAN_SESSION_CAPABILITY, true);
	 			return new SafariDriver(safariCapabilities);
	 		case CHROME:
	 			DesiredCapabilities chromeCapabilities = DesiredCapabilities
	 					.chrome();
	 			
	 			System.setProperty("webdriver.chrome.driver",CHROME_FILE_PATH);
	 			return new ChromeDriver(chromeCapabilities);
	 		default:
	 			throw new RuntimeException("Browser type unsupported");
	 		}
	 	}

	 	/**
	 	 * Capturing screenshot, Setting test result and creating log files after
	 	 * each test run
	 	 * 
	 	 * @param result
	 	 * @throws IOException
	 	 * @throws TestLinkAPIException
	 	 */
	 	@AfterMethod(alwaysRun = true)
	 	@Parameters({"seleniumHost"})
	 	public final void tearDown() throws IOException {
	 		
	 		try{
	 			if(driver!=null){
	 				driver.close();
	 				
	 			}
	 		}
	 			catch (Exception e){
	 				System.out.println("Window is Running Now:" + e);
	 			}
	 				
	 			
	 		}
	 	


	 	

	 	/**
	 	 * used for get the calling method name with line number
	 	 * 
	 	 * @return
	 	 */

	 	/**
	 	 * This method returns the current date and time in format HH-mm-ss.SSS
	 	 * 
	 	 * @return time - in the above mentioned format
	 	 */
	 	protected static String getCurrentDateAndTime() {
	 		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	 		Date date = new Date();
	 		String time = sdf.format(date);
	 		return time;
	 	}

	 	/**
	 	 * used to get the custom attribute value
	 	 * 
	 	 * @param operation
	 	 * @param elementLocator1
	 	 * @param optional
	 	 * @param status
	 	 * @param screenShot
	 	 * @param callingMethodAndLineNumber
	 	 * @return
	 	 */
	 	protected String getCustomAttributeValue(String operation,
	 			String elementLocator1, String optional, String status,
	 			String screenShot, String callingMethodAndLineNumber) {

	 		return operation + deliminator + elementLocator1 + deliminator
	 				+ optional + deliminator + status + deliminator + screenShot
	 				+ deliminator + callingMethodAndLineNumber;

	 	}



	 	/**
	 	 * Asserts that a condition is true. If it isn't, an AssertionError, with
	 	 * the given message, is thrown.
	 	 * 
	 	 * @param condition
	 	 *            the condition to evaluate
	 	 * @param message
	 	 *            the assertion error message
	 	 */


	 	static private void failNotEquals(Object actual, Object expected,
	 			String message) {
	 		Assert.fail(format(actual, expected, message));
	 	}

	 	static String format(Object actual, Object expected, String message) {
	 		String formatted = "";
	 		if (null != message) {
	 			formatted = message + " ";
	 		}

	 		return formatted + ASSERT_LEFT + expected + ASSERT_MIDDLE + actual
	 				+ ASSERT_RIGHT;
	 	}

	 	
	 	/**
	 	 * Asserts that a condition is true. If it isn't, an AssertionError, with
	 	 * the given message, is thrown.
	 	 * 
	 	 * @param condition
	 	 *            the condition to evaluate
	 	 * @param message
	 	 *            the assertion error message
	 	 */

	 }
