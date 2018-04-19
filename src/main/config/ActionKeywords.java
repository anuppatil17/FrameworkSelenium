package config;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.ParseException;
import executionEngine.DriverScript;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import reporting.CReporter;
import utility.ExcelUtils;
import utility.Log;

public class ActionKeywords 
{
	
	public static String ObjectText = null;
	public static AppiumDriver  driver;
	public static WebDriver wdriver;
	public static WebDriverWait wait;
	public static Object object;
	public CReporter reporter;
	public DriverScript driverscript;
	public GenericMethods genericmethods;
	public DesiredCapabilities capabilities = new DesiredCapabilities();
	public String browserName = "mobileOS";
	public DesiredCapabilities capabilities_cloud = new DesiredCapabilities(browserName, "", Platform.ANY);
	public String sException = "Exception";
	public String sExceptionMsg = "Exception Message";
	public String adeviceid;
	public String aosversion;
	public String aappPack;
	public String aappAct;
	public String aplatformName;
	public String abundleID;
	public static boolean bStopExecution = false;
	public String afileLocdir;
	public String aTestStepID;
	public String aplatform;
	public String auser;
	public String apassword;
	public String aurl;
	public String adatasheetloc;
	public String ascreenshotsloc;
	public String aappType;
	public String aappurl;
	public String aappbrowser;
	public String aappname;
	public String strValues;
	public static AppiumDriver driver1;
	public static WebDriver driver2;

	// Collection Objects
	public ArrayList contexts = new ArrayList();
	static Hashtable<String, String> hTab = new Hashtable<String, String>();

	//ActionKeywords actionkeywords= new ActionKeywords();
	
	
	

	/**
	 * 
	 * @param device
	 *            -
	 * @param platformName
	 * @param os_version
	 * @param bundleID
	 * @param appPack
	 * @param appAct
	 * @param platform
	 * @param user
	 * @param password
	 * @param url
	 * @param datasheetloc
	 * @param screenshotsloc
	 * @param appType
	 * @param appurl
	 * @param appbrowser
	 * @param appname
	 * @throws Exception
	 */
	/*
	 * 'Description : This method would retrieve values from testng.xml and
	 * assign value to variables 'InputParameters : byDefault 'OutPutParameters:
	 * None 'Author: Vikram Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void setMethod(String device, String platformName, String os_version, String bundleID, String appPack,
			String appAct, String platform, String user, String password, String url, String datasheetloc,
			String screenshotsloc, String appType, String appurl, String appbrowser, String appname) throws Exception {
		adeviceid = device;
		aplatformName = platformName;
		aosversion = os_version;
		abundleID = bundleID;
		aappPack = appPack;
		aappAct = appAct;
		aplatform = platform;
		auser = user;
		apassword = password;
		aurl = url;
		adatasheetloc = datasheetloc;
		ascreenshotsloc = screenshotsloc;
		aappType = appType;
		aappurl = appurl;
		aappbrowser = appbrowser;
		aappname = appname;
	}

	/**
	 * 
	 * @param fileLocdir
	 *            - File location directory
	 * @param sTestStepID
	 *            - TestStep id
	 * @throws Exception
	 *             -
	 */
	/*
	 * 'Description : This method would set File location and test step id
	 * 'InputParameters : byDefault 'OutPutParameters: None 'Author: Vikram
	 * Kapale. 'Date: 3-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void setMethod_Screencapture(String fileLocdir, String sTestStepID) throws Exception 
	{
		afileLocdir = fileLocdir;
		aTestStepID = sTestStepID;
	}

	/**
	 * 
	 * @param reporter1
	 * @throws Exception
	 */
	/* For Reporting */
	public void setReporter(CReporter reporter1) throws Exception 
	{
		reporter = reporter1;
	}

	/**
	 * Default Constructor
	 */
	public ActionKeywords() 
	{
		String a="sdfd";	}

	/**
	 * This method would set capabilities for Appium Run
	 * 
	 * @throws MalformedURLException
	 */

	/*
	 * 'Description : This method would set the capabilities for Appium run
	 * 'InputParameters : byDefault 'OutPutParameters: None 'Author: 'Date:
	 * 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void setupCapabilities() throws MalformedURLException {
		System.out.println("Into setupCapabilities()::");
		System.out.println(adeviceid);
		System.out.println(aplatformName);
		System.out.println(aosversion);
		System.out.println(abundleID);
		System.out.println(aappPack);
		System.out.println(aappAct);

		if (aplatform.equalsIgnoreCase("PERFECTO") && aappType.equalsIgnoreCase("WEB")) 
		{
			capabilities_cloud.setCapability("deviceName", adeviceid);
			capabilities_cloud.setCapability("platformName", aplatformName);
			capabilities_cloud.setCapability("automationName", "Appium");
			capabilities_cloud.setCapability("platformVersion", aosversion);
		}

		else 
		{
			capabilities.setCapability("deviceName", adeviceid);
			capabilities.setCapability("platformName", aplatformName);
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("platformVersion", aosversion);
		}
	}

	/**
	 * 
	 * @param TestDesc
	 * @param objectref
	 * @param inputparam
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 * @return
	 * @throws Throwable
	 */

	/*
	 * 'Description : This method would launch an Application 'InputParameters :
	 * byDefault 'OutPutParameters: None 'Author: Vikram Kapale. 'Date:
	 * 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */



	// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 * @param TestDesc
	 *            - Test Description
	 * @param objectref
	 *            - Object Referrence
	 * @param inputparam
	 *            - Input Parameter
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 * @throws Throwable
	 * 
	 * 
	 */

	/*
	 * 'Description : This method would enter text in the object
	 * 'InputParameters : byDefault 'OutPutParameters: None 'Author: Vikram
	 * Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void enter(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {
			Thread.sleep(1000);
			System.out.println("Into Enter() :: Driver Is:" + driver);
			System.out.println("Into Enter() :: Object Reference Is:" + objectref);
			System.out.println("Into Enter() :: Input Parameter Is:" + inputparam);
			System.out.println("Into Enter() :: ObjectType Is:" + objectType);
			Log.info("Entering the text in " + objectref);
			System.out.println("...................Enter Event Started........");
			Iterator iterator = contexts.iterator();
			while (iterator.hasNext()) {
				String contextName = iterator.next().toString();
				System.out.println(contextName);
				if (contextName.contains(objectType)) {
					// ((AppiumDriver) driver).context(contextName);
				//	driver.context(contextName);
					break;
				}
			}

			// System.out.println("Current Context of Driver
			// Is:"+((AppiumDriver) driver).getContext());
			System.out.println("Current Context of Driver Is:" + driver.getContext());
			if (aplatformName.equalsIgnoreCase("Andriod")) {
				// ((AppiumDriver)driver).findElementByXPath(objectref);
				// ((AppiumDriver)driver).getKeyboard().sendKeys(inputparam);

				driver.findElementByXPath(objectref);
				driver.getKeyboard().sendKeys(inputparam);

			} else {
				driver.findElement(By.xpath(objectref)).sendKeys(inputparam);
			}
			System.out.println("...............Enter Event Completed........");
			Thread.sleep(1000);
			captureScreenShot(driver);
			reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
			Thread.sleep(2000);
		}

		catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
			Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}
	}

	// ================================================================================================================

	/**
	 * 
	 */
	/*
	 * 'Description : This method would capture Screen Print 'InputParameters :
	 * byDefault 'OutPutParameters: None 'Author: Vikram Kapale. 'Date:
	 * 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void captureScreenShot(RemoteWebDriver driver) throws Exception {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		System.out.println("src::" + src);

		try {
			// now copy the screenshot to desired location using copyFile method

			String destfileloc = afileLocdir + "\\";

			System.out.println("destfileloc::" + destfileloc);

			FileUtils.copyFile(src, new File(destfileloc + aTestStepID + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public void captureScreenShot(WebDriver driver) throws Exception {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		System.out.println("src::" + src);

		try {
			// now copy the screenshot to desired location using copyFile method

			String destfileloc = afileLocdir + "\\";

			System.out.println("destfileloc::" + destfileloc);

			FileUtils.copyFile(src, new File(destfileloc + aTestStepID + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}
	

	public void screenShot(String fileName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(src, new File(fileName));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param TestDesc
	 *            - Test Description
	 * @param objectref
	 *            - Object Reference
	 * @param inputparam
	 *            - Input Parameter
	 * @param objectType
	 *            – Type of Object
	 * @param bResult
	 *            - Result
	 * @param inputparam1
	 *            Input Parameter
	 * @throws Throwable
	 */

	/*
	 * 'Description : This method would validate object Text 'InputParameters :
	 * byDefault 'OutPutParameters: None 'Author: Vikram Kapale. 'Date:
	 * 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void validateObjectText(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		try {
			Thread.sleep(1000);
			System.out.println("Into ValidateText() :: Driver Is:" + driver);
			System.out.println("Into ValidateText() :: Object Reference Is:" + objectref);
			System.out.println("Into ValidateText() :: Input Parameter Is:" + inputparam);
			System.out.println("Into ValidateText() :: ObjectType Is:" + objectType);
			Log.info("Entering the text in " + objectref);
			System.out.println("...................ValidateText Event Started........");

			WebElement WebE = driver.findElement(By.xpath(objectref));
			String oString = WebE.getAttribute("content-desc");
			oString = formatstringforvalidation(oString);
			inputparam = formatstringforvalidation(inputparam);

			if (oString == inputparam)

			{
				Log.info("matching");
			}

		} catch (Exception e) {
			Log.error("Not able to perform Text Validation --- " + e.getMessage());
			e.printStackTrace();
			DriverScript.bResult = false;
			Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}
	}

	/**
	 * 
	 * @param string1
	 *            - Input String for format
	 * @return
	 */

	/*
	 * 'Description : This method would format the string > Trim > convert in to
	 * Lowercase 'InputParameters : byDefault 'OutPutParameters: None 'Author:
	 * Vikram Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public String formatstringforvalidation(String string1) {
		String strFormat;
		strFormat = string1.trim();
		strFormat = string1.toLowerCase();
		return strFormat;
	}

	
	public void handleServiceDown(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		
	}
	
	
	
	/**
	 * 
	 * @param TestDesc
	 *            - Test Description
	 * @param objectref
	 *            - Object Reference
	 * @param inputparam
	 *            - Input Parameter
	 * @param objectType
	 *            – Type of Object
	 * @param bResult
	 *            - Result
	 * @param inputparam1
	 *            Input Parameter
	 * @throws Throwable
	 */

	/*
	 * 'Description : This method would set value/text in the object
	 * 'InputParameters : byDefault 'OutPutParameters: None 'Author: Vikram
	 * Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void customSetTest(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		
		if (driverscript.sDevice_ID_TestCase.contains("web"))
		{

		try {
			String[] aobjectref = objectref.split("\\|");
			String sby = aobjectref[0];
			String sproprty = aobjectref[1];
			
			WebElement webelement = genericmethods.findElement(sby, sproprty, wdriver);
		
			if (webelement != null) 
			{
				webelement.click();
				//	WebDriverWait wait = new WebDriverWait(driver, 60);
				//	wait.until(ExpectedConditions.elementToBeClickable(webelement));
				//	Thread.sleep(2000);
				webelement.sendKeys(inputparam);
				driverscript.bResult = true;
				reporter.onInfo(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");

			} 
			else 
			{
				driverscript.bResult = false;
				captureScreenShot(driver);
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			}

		} 
		catch (Exception e) 
		{
			driverscript.bResult = false;
			System.out.println(e);
			Log.error("Error in Customeset : " + e.getMessage());
		}
		}

		else
		{
		try {
			String[] aobjectref = objectref.split("\\|");
			String sby = aobjectref[0];
			String sproprty = aobjectref[1];
			
			WebElement webelement = genericmethods.findElement(sby, sproprty, driver);

			if (webelement != null) {
				webelement.click();
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.elementToBeClickable(webelement));
				Thread.sleep(2000);
				webelement.sendKeys(inputparam);
				driverscript.bResult = true;
			} else {
				driverscript.bResult = false;
				captureScreenShot(driver);
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			}

		} catch (Exception e) {
			driverscript.bResult = false;
			System.out.println(e);
			Log.error("Error in Customeset : " + e.getMessage());
		}
	}
	}

	
	
	
	/*
	 * 'Description : This method would set value/text in the object
	 * 'InputParameters : byDefault 'OutPutParameters: None 'Author: Vikram
	 * Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void customSet(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		if (driverscript.sDevice_ID_TestCase.contains("web")) {
			try {
				String[] aobjectref = objectref.split("\\|");
				String sby = aobjectref[0];
				String sproprty = aobjectref[1];
				WebElement webelement = genericmethods.findElement(sby, sproprty, wdriver);

				if (webelement != null) {
					webelement.click();
					if (inputparam.contains("KEYPAD")) {
						String[] keys = inputparam.split("\\|");
						String skeys = keys[1];
						switch (skeys) {
						case "ENTER":
							webelement.sendKeys(Keys.ENTER);
							break;

						case "CLEAR":
							webelement.clear();
							webelement.sendKeys(keys[2]);
							break;

						case "2":
							System.out.println("30");
							break;

							
							
							
						default:
							System.out.println("nothing has given");

						}
					} else {
						webelement.sendKeys(inputparam);
						ActionKeywords.handleLoader();
						driverscript.bResult = true;
						reporter.onInfo(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");
					}
				} else {
					driverscript.bResult = false;
					captureScreenShot(driver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				}

			} catch (Exception e) {
				driverscript.bResult = false;
				System.out.println(e);
				Log.error("Error in Customeset : " + e.getMessage());
			}
		}

		else {
			try {
				String[] aobjectref = objectref.split("\\|");
				String sby = aobjectref[0];
				String sproprty = aobjectref[1];
				WebElement webelement = genericmethods.findElement(sby, sproprty, driver);

				if (webelement != null) {
					webelement.click();
					WebDriverWait wait = new WebDriverWait(driver, 60);
					wait.until(ExpectedConditions.elementToBeClickable(webelement));
					Thread.sleep(2000);
					webelement.sendKeys(inputparam);
					driverscript.bResult = true;
				} else {
					driverscript.bResult = false;
					captureScreenShot(driver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				}

			} catch (Exception e) {
				driverscript.bResult = false;
				System.out.println(e);
				Log.error("Error in Customeset : " + e.getMessage());
			}
		}
	}
	

	
	public void myDreamSelectAccount(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) 
	{
		WebElement selectElement = driver.findElement(By.id("//select"));
		Select select = new Select(selectElement);
		List<WebElement> allOptions = select.getOptions();

		
		for (int i=0; i<=allOptions.size(); i++)
		{
			System.out.println(allOptions.get(i).getAttribute("value"));
		}
		//listitems.size();
		
	}
	
	
	
	
	
	
	
	
	
	
	public void findAllViewAndSelect(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) {
		// java.util.List<WebElement> view = ((AppiumDriver)
		// driver).findElements(By.xpath(objectref));
		java.util.List<WebElement> view = driver.findElements(By.xpath(objectref));

		for (int i = 0; i <= view.size(); i=i+1) {
			String Viewtext = view.get(i).getAttribute("content-desc");
			Viewtext = formatstringforvalidation(Viewtext);
			inputparam = formatstringforvalidation(inputparam);
			if (Viewtext == inputparam) {
				view.get(i).click();
			}
		}

	}

	public void customWait(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Integer iWait = Integer.parseInt(inputparam);
		Thread.sleep(iWait);
	}

	public void enterByName(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {

			Thread.sleep(1000);

			System.out.println("Into Enter() :: Driver Is:" + driver);
			System.out.println("Into Enter() :: Object Reference Is:" + objectref);
			System.out.println("Into Enter() :: Input Parameter Is:" + inputparam);
			System.out.println("Into Enter() :: ObjectType Is:" + objectType);

			Log.info("Entering the text in " + objectref);

			System.out.println("...................Enter Event Started........");

			Iterator iterator = contexts.iterator();
			while (iterator.hasNext()) {
				String contextName = iterator.next().toString();
				System.out.println(contextName);
				if (contextName.contains(objectType)) {
					// ((AppiumDriver) driver).context(contextName);
					//driver.context(contextName);
					break;
				}
			}

			System.out.println("Current Context of Driver Is:" + ((AppiumDriver) driver).getContext());

			if (aplatformName.equalsIgnoreCase("Andriod")) {
				// ((AppiumDriver)driver).findElement(By.name(objectref));
				// ((AppiumDriver)driver).getKeyboard().sendKeys(inputparam);

				driver.findElement(By.name(objectref));
				driver.getKeyboard().sendKeys(inputparam);
			} else {
				driver.findElement(By.name(objectref)).sendKeys(inputparam);
			}
			System.out.println("...............Enter Event Completed........");
			Thread.sleep(1000);
			captureScreenShot(driver);
			reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
			Thread.sleep(2000);
		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
			Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}
	}

	public void clickOnObject(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		boolean oElemFlag = waitForObject(objectref, driver);
		if (oElemFlag == false) {
			System.out.println("exit...");
			System.exit(0);
		}
		// WebElement WebEl = ((AppiumDriver)
		// driver).findElement(By.xpath(objectref));
		WebElement WebEl = driver.findElement(By.xpath(objectref));
		WebEl.click();
		Thread.sleep(500);
	}

	public void hideKeboard(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Thread.sleep(2000);
		// ((AppiumDriver) driver).hideKeyboard();
		driver.hideKeyboard();
		Thread.sleep(2000);
	}

	public boolean waitForObject(String objectref, WebDriver driver) {
		//WebDriver driver = null;
		boolean oFlag = false;
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectref)));
			WebElement WebEl = driver.findElement(By.xpath(objectref));
			oFlag = true;
			return oFlag;
		} catch (Exception e) {
			System.out.println("Object not visible : " + objectref);
			oFlag = false;
			return oFlag;
		}

	}

	
	public boolean waitForObject(String objectref, AppiumDriver driver) {
		//WebDriver driver = null;
		boolean oFlag = false;
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectref)));
			WebElement WebEl = driver.findElement(By.xpath(objectref));
			oFlag = true;
			return oFlag;
		} catch (Exception e) {
			System.out.println("Object not visible : " + objectref);
			oFlag = false;
			return oFlag;
		}

	}

	
	public void waitForObjectVisibleAndClick(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		WebDriverWait objectEnabled = new WebDriverWait(driver, 60);
	
		WebElement element = driver.findElement(By.xpath(objectref));
		boolean bFlag = element.isEnabled();

	}

	
	public void wait(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		long l = Long.parseLong(inputparam);
		l = l * 1000;
		Thread.sleep(l);
	}

	public void verifyObjectPropText(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		boolean oElemFlag = waitForObject(objectref,  driver);
		if (oElemFlag == false) {
			System.out.println("exit...");
			System.exit(0);
		}
		String ObjectText = driver.findElement(By.xpath(objectref)).getAttribute(inputparam1);
		if (ObjectText == inputparam) {

		}
	}

	public void isObjectExist(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		boolean oElemFlag = waitForObject(objectref, driver);
		if (oElemFlag == false) {
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		} else {
			captureScreenShot(driver);
			reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
		}
	}

	public boolean isObjectClickable(String objectref) {
		boolean oFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectref)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectref)));
			// WebElement WebEl = ((AppiumDriver)
			// driver).findElement(By.xpath(objectref));
			WebElement WebEl = driver.findElement(By.xpath(objectref));
			oFlag = true;
			return oFlag;
		} catch (Exception e) {
			System.out.println("Object not visible : " + objectref);
			oFlag = false;
			return oFlag;
		}

	}
	

public void AutoSearch(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable{
		
		Thread.sleep(1000);
	 
	WebElement webelement =  wdriver.findElement(By.xpath(objectref));
	webelement.sendKeys(inputparam);
	Thread.sleep(1000);
	wdriver.findElement(By.xpath(inputparam1)).click();
	//webelement.findElement(By.xpath(inputparam)).click();
	}
	
	public WebElement isObjectClickableBy(String objectref, String inputparam) 
	{
		boolean oFlag = false;
		WebElement WebEl;
		WebEl = null;
		try {
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 120);
			
			switch(objectref)
			{
			case "xpath" :
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputparam)));
				 WebEl = driver.findElement(By.xpath(inputparam));
				 oFlag = true;
				 break;
			case "name"	:
				wait.until(ExpectedConditions.elementToBeClickable(By.name(inputparam)));
				 WebEl = driver.findElement(By.name(inputparam));
				 oFlag = true;
				 break;
			case "css" : 
				wait.until(ExpectedConditions.elementToBeClickable(By.name(inputparam)));
				 WebEl = driver.findElement(By.cssSelector(inputparam));
				 oFlag = true;
				 break;
			}
			return WebEl;
		} 
		
		catch (Exception e) 
		{
			System.out.println("Object not visible : " + objectref);
			oFlag = false;
			return WebEl;
		}

	}
	
	
	
	/**
	 * 
	 * @param TestDesc
	 * @param objectref
	 * @param inputparam
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 * @return
	 */
	public void isObjectVisibleAndClickable(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Exception {
		//boolean oFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			try {
				WebElement webelement = genericmethods.findElement(objectref, inputparam, driver);
				wait.until(ExpectedConditions.elementToBeClickable(webelement));
				
				
			} catch (Throwable e) {
				System.out.println("Object not visible");
			}
			driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);

		} catch (Exception e) {
			System.out.println("Object not visible : " + objectref);

			
		}

	}

	public boolean isObjectVisible(String objectref) {
		boolean oFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectref)));
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectref)));
			// WebElement WebEl = ((AppiumDriver)
			// driver).findElement(By.xpath(objectref));
			WebElement WebEl = driver.findElement(By.xpath(objectref));
			oFlag = true;
			return oFlag;
		} catch (Exception e) {
			System.out.println("Object not visible : " + objectref);
			oFlag = false;
			return oFlag;
		}
	}

	public void selectObject(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		boolean oElemFlag = waitForObject(objectref, driver);
		if (oElemFlag == false) {
			System.out.println("exit...");
			System.exit(0);
		}

		String ObjectText = driver.findElement(By.xpath(objectref)).getAttribute(inputparam1);
		if (ObjectText == inputparam) {

		}
	}

	// =============================================================================================================================

	/*
	 * 'Description : This method would validate if expected page has been
	 * displayed 'InputParameters : byDefault 'OutPutParameters: None 'Author:
	 * Vikram Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	/**
	 * 
	 * @param TestDesc
	 * @param objectref
	 * @param inputparam
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 * @throws Throwable
	 */

	public void validation(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		Thread.sleep(2000);
		if (driverscript.sDevice_ID_TestCase.contains("web")) {
			Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			Log.info(TestDesc + "|" + objectref + "|" + inputparam);
			String sObjectref = null;
			String sInputparam = null;
			try {
				if (true == objectref.contains("|")) {
					String[] aObjectRef = objectref.split("\\|");
					sObjectref = aObjectRef[0];
					sInputparam = aObjectRef[1];
				} else {
					sObjectref = "name";
					sInputparam = objectref;
				}	

				WebDriverWait wait = new WebDriverWait(wdriver, 60);
				WebElement webelement = genericmethods.findElement(sObjectref, sInputparam, wdriver);

				if (webelement != null) {
					driverscript.bResult = true;
					wait.until(ExpectedConditions.elementToBeClickable(webelement));
					wait.until(ExpectedConditions.visibilityOf(webelement));
					Thread.sleep(2000);
					driverscript.bResult = true;
					captureScreenShot(wdriver);
					reporter.onSuccessscreenshot(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");

				} else {
					driverscript.bResult = false;
					captureScreenShot(wdriver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				}

			} catch (Throwable e) {
				driverscript.bResult = false;
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				e.printStackTrace();
				Log.info(sException + " : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "**********");
				Log.info(sExceptionMsg + "Exception message : " + e.getMessage());
			}
			Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");

		} else {
			Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			Log.info(TestDesc + "|" + objectref + "|" + inputparam);
			String sObjectref = null;
			String sInputparam = null;
			try {
				if (true == objectref.contains("|")) {
					String[] aObjectRef = objectref.split("\\|");
					sObjectref = aObjectRef[0];
					sInputparam = aObjectRef[1];
				} else {
					sObjectref = "name";
					sInputparam = objectref;
				}

				WebDriverWait wait = new WebDriverWait(driver, 60);
				WebElement webelement = genericmethods.findElement(sObjectref, sInputparam, driver);

				if (webelement != null) {
					driverscript.bResult = true;
					wait.until(ExpectedConditions.elementToBeClickable(webelement));
					wait.until(ExpectedConditions.visibilityOf(webelement));
					Thread.sleep(2000);
					driverscript.bResult = true;
					captureScreenShot(driver);
					reporter.onSuccessscreenshot(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");

				} else {
					driverscript.bResult = false;
					captureScreenShot(driver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				}

			} catch (Throwable e) {
				driverscript.bResult = false;
				captureScreenShot(driver);
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				e.printStackTrace();
				Log.info(sException + " : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "**********");
				Log.info(sExceptionMsg + "Exception message : " + e.getMessage());
			}
			Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		}
	}

	
	public void fDAgainstODSelectAccount(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	
	{
		String table = "//table[contains(.,'Fixed Deposit')]";
		waitTillTableData(table);
		int row = rowCount(table);
		int col = colCount(table);
		
		
		
		for(int i=1; i<=row; i++)
		{
			String strData = getCellData(table, 2, 1, 1);
			strData.replace(".00", "");
			strData.trim();
			Integer amount = Integer.parseInt(strData);
			//String s = "//table[contains(.,'Fixed Deposit')]/tbody[2]/tr[1]/td[6]";
			String s = "//table[contains(.,'Fixed Deposit')]/tbody[2]/tr[1]/td[6]";
			wdriver.findElement(By.xpath(s)).click();

		}
		
		
	}
	
	
	
	
	
	public void validationNotClickable(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Thread.sleep(5000);

		if (driverscript.sDevice_ID_TestCase.contains("web"))
		{
			Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			Log.info(TestDesc + "|" + objectref + "|" + inputparam);
			String sObjectref = null;
			String sInputparam = null;
			try {
				if (true == objectref.contains("|")) {
					String[] aObjectRef = objectref.split("\\|");
					sObjectref = aObjectRef[0];
					sInputparam = aObjectRef[1];
				} else {
					sObjectref = "name";
					sInputparam = objectref;
				}
				
				WebDriverWait wait = new WebDriverWait(wdriver, 60);
				WebElement webelement = genericmethods.findElement(sObjectref, sInputparam, wdriver);
				
				if (webelement != null) 
				{
					driverscript.bResult = true;
				//	wait.until(ExpectedConditions.elementToBeClickable(webelement));
			//		wait.until(ExpectedConditions.visibilityOf(webelement));
					Thread.sleep(2000);
					driverscript.bResult = true;
					captureScreenShot(wdriver);
					reporter.onSuccessscreenshot(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");

				} else 
				{
					driverscript.bResult = false;
					captureScreenShot(wdriver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				}
				
			} catch (Throwable e) {
				driverscript.bResult = false;
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				e.printStackTrace();
				Log.info(sException + " : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "**********");
				Log.info(sExceptionMsg + "Exception message : " + e.getMessage());
			}
			Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			
			
			
			
			
		}
		else
		{
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		Log.info(TestDesc + "|" + objectref + "|" + inputparam);
		String sObjectref = null;
		String sInputparam = null;
		try {
			if (true == objectref.contains("|")) {
				String[] aObjectRef = objectref.split("\\|");
				sObjectref = aObjectRef[0];
				sInputparam = aObjectRef[1];
			} else {
				sObjectref = "name";
				sInputparam = objectref;
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement webelement = genericmethods.findElement(sObjectref, sInputparam, driver);
		//	String Str1 = webelement.getAttribute("xpath");
			//boolean bVal = Boolean.parseBoolean(test1.getAttribute("clickable"));
			//WebElement bClickable = isObjectClickableBy(sObjectref, sInputparam);
			
			if (webelement != null) 
			{
				driverscript.bResult = true;
				wait.until(ExpectedConditions.elementToBeClickable(webelement));
				wait.until(ExpectedConditions.visibilityOf(webelement));
				Thread.sleep(2000);
				driverscript.bResult = true;
				captureScreenShot(driver);
				reporter.onSuccessscreenshot(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");

			} else 
			{
				driverscript.bResult = false;
				captureScreenShot(driver);
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			}
			
		} catch (Throwable e) {
			driverscript.bResult = false;
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			e.printStackTrace();
			Log.info(sException + " : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.info(sExceptionMsg + "Exception message : " + e.getMessage());
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
	}
	}


	
	
	
	
	
	
	// ==========================================================================================================================

	public void selectBeneficiary(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		try {

			WebElement Beneficiary = genericmethods.findElement(objectref, inputparam, driver);
			String Formatinputparam = inputparam.trim();
			Formatinputparam = Formatinputparam.toString();
			if (0 != inputparam.indexOf("Frequent Transfer")) {
				Beneficiary.click();
			}

			Beneficiary = genericmethods.findElement(objectref, inputparam1, driver);
			Beneficiary.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	
	public void moveCursorToObject(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		WebElement webelement = genericmethods.findElement(objectref, inputparam, wdriver);
		Actions act = new Actions(wdriver);
		act.moveToElement(webelement);
		act.click().build().perform();
		Thread.sleep(2000);
		act.click();
		Thread.sleep(3000);

	}
	
	public void tap(String objectref) throws Throwable {
		try {
			String s;
			boolean oElemFlag = waitForObject(objectref, driver);
			if (oElemFlag == false) {
				captureScreenShot(driver);
				reporter.onFailure("Unable to find the Object", "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
				System.exit(0);
			}
			System.out.println("Current Context of Driver Is:" + driver.getContext());
			((AppiumDriver) driver).findElement(By.xpath(objectref)).click();
		}

		catch (Exception e) {
		}
	}

	public void validateObjectProp(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		Log.info(TestDesc + "|" + objectref + "|" + inputparam);
		String[] aObjectRef = objectref.split("\\|");
		String sObjectref = aObjectRef[0];
		String sInputparam = aObjectRef[1];
		String sProp = aObjectRef[2];
		String sValue = aObjectRef[3];

		try {
			WebElement element = genericmethods.findElement(sObjectref, sInputparam, driver);
			if (element != null) {
				String sElementVal = element.getAttribute(sProp);
				if (sElementVal.trim().equalsIgnoreCase(sValue.trim())) {
					captureScreenShot(driver);
					reporter.onSuccessscreenshot(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");
					reporter.onSuccessscreenshot("Object property and given value is matching",
							"Object prop : " + (sElementVal.trim()).toLowerCase() + "|" + "Given Value is : "
									+ (sValue.trim()).toLowerCase(),
							afileLocdir + "\\" + aTestStepID + ".png");
				} else {
					captureScreenShot(driver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
					reporter.onFailure("Object property and given value is not matching",
							"Object prop : " + (sElementVal.trim()).toLowerCase() + "|" + "Given Value is : "
									+ (sValue.trim()).toLowerCase(),
							afileLocdir + "\\" + aTestStepID + ".png");

				}
				// captureScreenShot(driver);
				// reporter.onSuccessscreenshot(TestDesc, inputparam,
				// afileLocdir+"\\"+aTestStepID+".png");
			} else {
				captureScreenShot(driver);
				reporter.onFailure("Object not Found", inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			captureScreenShot(driver);
			reporter.onFailure("Object not Found", inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			e.printStackTrace();
			Log.info(sException + " : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.info(sExceptionMsg + "Exception message : " + e.getMessage());
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
	}

	// ===============================================================================================================================



	// ==============================================================================================================================
	/**
	 * 
	 * @param TestDesc
	 *            - Test Description
	 * @param objectref
	 *            - Object Reference
	 * @param inputparam
	 *            - Input parameter/s
	 * @param objectType
	 *            - Object Type
	 * @param bResult
	 *            - Result boolean
	 * @param inputparam1
	 *            - Input parameter1
	 * @throws Throwable 
	 */

	/*
	 * 'Description : This method would would click on object using
	 * xpath/name/id/css. 'InputParameters : byDefault 'OutPutParameters: None
	 * 'Author: Vikram Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void clickFindElementBy(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		if (driverscript.sDevice_ID_TestCase.contains("web"))
			
		{
			try {
				wdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				WebElement webelement = genericmethods.findElement(objectref, inputparam, wdriver);

				if (webelement != null) {
					try {
					} catch (Exception e) {
						System.out.println("Expected Condition failed");
					} finally {
						wdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						webelement.click();
						driverscript.bResult = true;
					}
				} else {
					driverscript.bResult = false;
					captureScreenShot(wdriver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				}
			} catch (Throwable e) {
				captureScreenShot(wdriver);
				reporter.onFailure("Object is not found", TestDesc + " | " + objectref + " | " + inputparam,
						afileLocdir + "\\" + aTestStepID + ".png");
			}
			
			finally
			{
				
				ActionKeywords.handleLoader();
				if (inputparam1.length() != 0)
				{
				try
				{
					String[] aobjectref = inputparam1.split("\\|");
					String sby = aobjectref[0];
					String sproprty = aobjectref[1];
					wdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					WebElement webelement = genericmethods.findElement(sby, sproprty, wdriver);
					WebDriverWait wait = new WebDriverWait(wdriver, 120);
					wait.until(ExpectedConditions.elementToBeClickable(webelement));
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			}
		}

		else {

			try {
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				WebElement webelement = genericmethods.findElement(objectref, inputparam, driver);
				// wait.until(ExpectedConditions.elementToBeClickable(webelement));

				if (webelement != null) {
					try {
					} catch (Exception e) {
						System.out.println("Expected Condition failed");
					} finally {
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						webelement.click();
						driverscript.bResult = true;

						if (inputparam1.length() != 0) {
							String[] aobjectref = inputparam1.split("\\|");
							String sby = aobjectref[0];
							String sproprty = aobjectref[1];
							WebDriverWait wait = new WebDriverWait(driver, 60);
							WebElement waitforelement = genericmethods.findElement(sby, sproprty, driver);
							if (waitforelement == null) {
								captureScreenShot(driver);
								reporter.onFailure("Object is not found",
										TestDesc + " | " + objectref + " | " + inputparam,
										afileLocdir + "\\" + aTestStepID + ".png");
							}
						}

					}
				} else {
					driverscript.bResult = false;
					captureScreenShot(driver);
					reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
				}

			} catch (Throwable e) {
				captureScreenShot(driver);
				reporter.onFailure("Object is not found", TestDesc + " | " + objectref + " | " + inputparam,
						afileLocdir + "\\" + aTestStepID + ".png");
			}

		}

	}

	
	
	public void getOTPAndEnterInTextbox(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Pract\\SBIAppiumMobileAutomationFramework\\tools\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://accounts.google.com/ServiceLogin?");
		driver1.findElement(By.xpath("//input[contains(@autocomplete,'username')]")).sendKeys("tqa7909");
		driver1.findElement(By.xpath(".//*[@id='identifierNext']")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath("//input[contains(@autocomplete,'current-password')]")).sendKeys("tEST@123");
		Thread.sleep(2000);
		driver1.findElement(By.xpath(".//*[@id='passwordNext']")).click();
		Thread.sleep(2000);
		driver1.get("https://mail.google.com/mail/#");
		Thread.sleep(6000);
		driver1.findElement(By.xpath("//a[contains(@title,'Inbox')]")).click();
		Thread.sleep(3000);
		String row = "//tr[contains(.,'OTP Request')]";
		String ee = "//tr[contains(.,'OTP Request')]/td[4]/div/span";
		driver1.findElement(By.xpath(row)).click();
		Thread.sleep(5000);
		String sOTP1 = driver1.findElement(By.xpath("//p[contains(.,'Your OTP is')]")).getAttribute("textContent");
		sOTP1 = sOTP1.replace("Your OTP is ", "");
		sOTP1 = sOTP1.substring(0, 6);
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div[2]/div[3]/div/div")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath(".//*[@id=':5']/div[2]/div[1]/div/div[2]/div[3]/div/div")).click();
		Thread.sleep(1000);
	//	driver1.close();
		wdriver.findElement(By.xpath(objectref)).sendKeys(sOTP1);
	}
	
	
	public void changeValue(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
            String inputparam1) throws Throwable{
   
        WebElement webelement = wdriver.findElement(By.xpath(objectref));
        webelement.clear();
        Thread.sleep(1000);
        webelement.sendKeys(inputparam);
        Thread.sleep(1000);
       

    }
	
	

	public  void scrollIntoView(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws InterruptedException{
		
		WebElement element = wdriver.findElement(By.xpath("//li[contains(.,'Average monthly')]"));
		((JavascriptExecutor) wdriver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		Thread.sleep(500); 
		
		
	}
	
	
	public void addProductsInWishList(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		ActionKeywords.handleLoader();

		String productName = null;
		String productPrice = null;
		int iProdClick = 1;
		objectref = "//slick[contains(@class,'slider product-list')]";
		java.util.List<WebElement> product = wdriver.findElements(By.xpath(objectref));

		for (int i = 0; i <= product.size(); i = i + 1) {
			product = wdriver.findElements(By.xpath(objectref));
			String Viewtext = product.get(i).getAttribute("settings");
			Viewtext = Viewtext.trim();
			if (Viewtext.contains("featuresSetting")) {
				java.util.List<WebElement> subProduct = product.get(i).findElements(By.className("img-prod-list"));
				ActionKeywords.handleLoader();
				for (int l = 0; l <= subProduct.size() - 1; l = l + 1) {
					product = wdriver.findElements(By.xpath(objectref));
					subProduct = product.get(i).findElements(By.className("img-prod-list"));
					subProduct.get(l).click();
					//Thread.sleep(5000);
					ActionKeywords.handleLoader();
					java.util.List<WebElement> subProduct1 = wdriver
							.findElements(By.xpath("//div[contains(@class,'product-name')]"));
					java.util.List<WebElement> prodimage = wdriver
							.findElements(By.xpath("//div[contains(@class,'productList')]"));

					for (int j = 0; j <= subProduct1.size() - 1; j = j + 1) {
						try {
							productName = subProduct1.get(j).getText();
							productPrice = subProduct1.get(j)
									.findElement(By.xpath("//div[contains(@class,'prodList-price')]")).getText();
						} 
						catch (Exception e) 
						{
							subProduct1 = wdriver.findElements(By.xpath("//div[contains(@class,'product-name')]"));
							java.util.List<WebElement> subProductprice = wdriver
									.findElements(By.xpath("//div[contains(@class,'prodList-price')]"));
							productName = subProduct1.get(j).getText();
							productPrice = subProductprice.get(j).getText();
							prodimage = wdriver.findElements(By.xpath("//div[contains(@class,'productList')]"));
						}

						prodimage.get(j).click();
					//	Thread.sleep(5000);
						ActionKeywords.handleLoader();
						if (productName.contains(wdriver
								.findElement(By.xpath("//div[@class='roboto-regular ng-binding']")).getText().trim()))
						{
							String proddesc = wdriver.findElement(By.xpath("//div[@class='roboto-regular ng-binding']")).getText().trim();
							captureScreenShot(wdriver);
							//String a = "PROD" + productName + " - " + "PRODU" + proddesc;
							//reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir+"\\"+aTestStepID+".png");
							try
							{
							reporter.onSuccessscreenshot("LIST " + productName + " DESCRPTION " + proddesc, "has been matching", afileLocdir + "\\" + aTestStepID + ".png");
							}
							catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
							}
						else
						{
							String proddesc = wdriver.findElement(By.xpath("//div[@class='roboto-regular ng-binding']")).getText().trim();
							captureScreenShot(wdriver);
						//	reporter.onFailure(TestDesc, "is Failed", afileLocdir+"\\"+aTestStepID+".png");
							reporter.onFailure("LIST " + productName + " DESCRPTION " + proddesc, "has NOT been matching", afileLocdir + "\\" + aTestStepID + ".png");

							//reporter.onFailure("Product name on PRODUCT LIST page : " + productName + " - Product name on PRODUCT DESCRIPTION page : " + proddesc, "Product name on Product list page and Product description page has not been matching", afileLocdir+"\\"+aTestStepID+".png");
						}	

						if (productPrice.contains(wdriver.findElement(By.xpath("//div[contains(@class,'pprice')]"))
								.getText().trim().substring(2))) 
						{
							String prodprice = wdriver.findElement(By.xpath("//div[contains(@class,'pprice')]"))
									.getText().trim().substring(2);
							captureScreenShot(wdriver);
							reporter.onSuccessscreenshot("LIST " + productPrice + " DESCRPTION " + prodprice, "has been matching", afileLocdir + "\\" + aTestStepID + ".png");

							//reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir+"\\"+aTestStepID+".png");
							//reporter.onSuccessscreenshot("Product price on PRODUCT LIST page : " + productPrice + " - Product price on PRODUCT DESCRIPTION page : " + prodprice, "Product price on Product list page and Product description page has been matching", afileLocdir+"\\"+aTestStepID+".png");
						}
						else
						{
							String prodprice = wdriver.findElement(By.xpath("//div[contains(@class,'pprice')]"))
									.getText().trim().substring(2);
							captureScreenShot(wdriver);
							reporter.onFailure("LIST " + productPrice + " DESCRPTION " + prodprice, "has been NOT matching", afileLocdir + "\\" + aTestStepID + ".png");

						//	reporter.onFailure(TestDesc, "is Failed", afileLocdir+"\\"+aTestStepID+".png");
							//reporter.onFailure("Product price on PRODUCT LIST page : " + productPrice + " - Product price on PRODUCT DESCRIPTION page : " + prodprice, "Product price on Product list page and Product description page has not been matching", afileLocdir+"\\"+aTestStepID+".png");
						}						
						wdriver.findElement(By.xpath(".//*[@id='ADD_WLT_IMG']")).click();
						iProdClick = iProdClick+ 1;
						try
						{
							wdriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
							WebDriverWait wait = new WebDriverWait(wdriver, 4);
							WebElement maxprod = wdriver.findElement(By.xpath("//p[contains(.,'You can add only 20 products in wishlist.')]"));
							if (maxprod.isDisplayed())
							{
								reporter.onInfo("number of time clicked : " + iProdClick, "20 Product", afileLocdir + "\\" + aTestStepID + ".png");
								reporter.onInfo("20 products has been added ", "20 Product", afileLocdir + "\\" + aTestStepID + ".png");
								captureScreenShot(wdriver);
								reporter.onSuccessscreenshot("20 Product has been displayed", "20 Product has been displayed", afileLocdir + "\\" + aTestStepID + ".png");
								Thread.sleep(5000);
								wdriver.findElement(By.xpath(".//*[@id='MAX_WARN_BTN']")).click();
								ActionKeywords.handleLoader();

								return;
							}
						}
						catch(Exception e)
						{
							
						}
					try
						{
						wdriver.navigate().back();
						ActionKeywords.handleLoader();

						}
						catch(Exception e)
						{
							System.out.println("error");
							System.exit(0);
						}
						
						Thread.sleep(5000);
					}
					wdriver.findElement(By.xpath("//a[contains(.,'Happily Married')]")).click();
					ActionKeywords.handleLoader();

					Thread.sleep(5000);
				}
			}
		}

		
		
	}

	public void wishListMaxProd(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{
		try
		{
			wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(wdriver, 30);
			WebElement maxprod = wdriver.findElement(By.xpath("//p[contains(.,'You can add only 20 products in wishlist.')]"));
			if (maxprod.isDisplayed())
			{
				wdriver.findElement(By.xpath(".//*[@id='MAX_WARN_BTN']")).click();
				System.out.println("Max 20 Prods displayed");
			}
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	
	public void getWebText(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{
		String[] aobjectref = objectref.split("\\|");
		String sby = aobjectref[0];
		String sproprty = aobjectref[1];

		wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement webelement = genericmethods.findElement(sby, sproprty, wdriver);
		webelement.getText();
	}
	
	
	
	
	public void moveToObject(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) {
		try {
			WebElement element = genericmethods.findElement(objectref, inputparam, driver);
			String str1 = element.getText();
			//((AndroidDriver) driver).scrollTo(str1);
			Actions actions = new Actions(((AppiumDriver) driver));
			actions.moveToElement(element);
			// actions.click();
			actions.perform();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clearTextboxValue(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1)

	{
		try {

			WebElement element = genericmethods.findElement(objectref, inputparam, driver);
			element.sendKeys("test");
			Thread.sleep(2000);
			element.clear();

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}


	public void tap(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {
			boolean oElemFlag = waitForObject(objectref, driver);
			if (oElemFlag == false) {
				System.out.println("exit...");
				System.exit(0);
			}
			((AppiumDriver) driver).findElement(By.xpath(objectref)).click();
			if (false == inputparam.isEmpty()) {
				boolean oElemFlag1 = waitForObject(inputparam, driver);
				if (oElemFlag1 == false) {
					System.out.println("Launch event exit...");
					System.exit(0);
				}
			}
		}

		catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
			Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}
	}

	
	public void SBICAPSecuritiesPortfolio(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		WebElement frame =  wdriver.findElement(By.xpath("//p[contains(.,'SBICAP Securities Portfolio')]/parent::div/../.."));
		frame.findElement(By.name("View")).click();
		if (wdriver.findElement(By.xpath("//h2[contains(.,'My Securities Portfolio')]")).isDisplayed())
		{
			captureScreenShot(wdriver);
			reporter.onSuccessscreenshot("My Securities Portfolio", "page has been displayed", afileLocdir + "\\" + aTestStepID + ".png");
		}
		else
		{
			captureScreenShot(wdriver);
			reporter.onFailure("My Securities Portfolio", "page has not been displayed", afileLocdir + "\\" + aTestStepID + ".png");
		}
		
		
		
		

	}
	
	
	
	
	
	public void validateText(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {
			boolean oElemFlag = waitForObject(objectref, driver);
			if (oElemFlag == false) {
				System.out.println("exit...");
				System.exit(0);
			}
			((AppiumDriver) driver).findElement(By.xpath(objectref)).click();
			if (false == inputparam.isEmpty()) {
				boolean oElemFlag1 = waitForObject(inputparam, driver);
				if (oElemFlag1 == false) {
					System.out.println("Launch event exit...");
					System.exit(0);
					
					
					
					
				}
			}
		}

		catch (Exception e) 
		{
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
			Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}
	}

	
	
	public void isObjectExist(String objectref, String inputparam) throws Throwable {
		Log.info("IsObjectExist Method started");
		Log.info(objectref + inputparam);
		boolean oElemFlag = waitForObject(objectref, driver);
		if (oElemFlag == false) {
			captureScreenShot(driver);
			reporter.onFailure("Validation", objectref + inputparam + " : Passed",
					afileLocdir + "\\" + aTestStepID + ".png");
		} else {
			captureScreenShot(driver);
			reporter.onSuccessscreenshot("Validation", objectref + inputparam + " : Failed",
					afileLocdir + "\\" + aTestStepID + ".png");
		}
		Log.info("IsObjectExist Method Ended");
	}

	public void captureScreenValues(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) {

		// WaitForObject(String objectref)

		String[] arrSplit = objectref.split("#");
		for (int iObjCounter = 0; iObjCounter < arrSplit.length; iObjCounter++) {
			String[] sObjProp = arrSplit[iObjCounter].split("\\|");
			try {
				String sObjectVal = getObjectText(sObjProp[0], sObjProp[1], sObjProp[2]);

				// oAddValHashTable(sObjProp[3],sObjectVal);
				oAddValInHashTab(sObjProp[3], sObjectVal);

			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * public void oAddValHashTable(String key, String value) { try {
	 * 
	 * if (htable == null) { Hashtable<String,String> Htable=new
	 * Hashtable<String,String>(); //Hashtable<String,String> Htable=new
	 * Hashtable<String,String>(); } Htable.put(key,value); } catch(Exception e)
	 * { System.out.println(e); } }
	 * 
	 */


	public String getObjectText(String sBy, String sValue, String sAttribute) throws Throwable {
		WebElement webelement = genericmethods.findElement(sBy, sValue, driver);
		if (webelement.equals(null)) {
			ObjectText = null;
		} else {
			ObjectText = getElementValue(webelement, sAttribute);
		}
		return ObjectText;
	}

	
	public void scrollUp(String TestDesc, String objectref, String inputparam, String objectType,
			 boolean bResult, String inputparam1) throws Throwable{
		
		
		Thread.sleep(5000);		
		
		((JavascriptExecutor)wdriver).executeScript("scroll(0,-200)");
		
	}
//---------------------------------------------------------------------------------------------------------------------------

	public void datePicker(String TestDesc, String objectref, String inputparam, String objectType,
			 boolean bResult, String inputparam1) throws ParseException, InterruptedException{
		
		//bhargav
		wdriver.findElement(By.xpath("//input[@id='datepicker']")).click();
		wdriver.findElement(By.xpath("//div/div[1]/div[2]/a/span")).click();
		String expectedDate="10-02-1991"; 
		
		String[] dateVal=expectedDate.split("-");
		int monthToSelect=Integer.parseInt(dateVal[1]);
		
	    String selectMonth = wdriver.findElement(By.xpath("//div[3]/div/datepicker/div/div[1]/div[2]")).getText();
	    SimpleDateFormat inputFormat= new SimpleDateFormat("MMMM");
	    Calendar cal = Calendar.getInstance();
	    try {
			cal.setTime(inputFormat.parse(selectMonth));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	    SimpleDateFormat outputFormat= new SimpleDateFormat("MM");
	    int parseMonth = Integer.parseInt(outputFormat.format(cal.getTime()));
	    
	    if (parseMonth>monthToSelect){
	    	
	    	for (int i=0; i<parseMonth-monthToSelect;i++){
	    		
	    		Thread.sleep(500);
	    		
	    		wdriver.findElement(By.xpath("//div[3]/div/datepicker/div/div[2]/div[2]/a[1]/b")).click();
	    		
	    		
	    
	    	}
	    	
	    	wdriver.findElement(By.xpath("//div/div[2]/div[1]/a[5]")).click();
	    	Thread.sleep(500);
		    wdriver.findElement(By.xpath("//div[3]/div/datepicker/div/div[4]/a[6]")).click();
	    }
		
	    else  {
	    	
	    	System.out.println("Test ");
	    	
	    }
	    
	    //driver.findElement(By.linkText(dateVal[0])).click();
	}
	
	
	public void clearTextboxValueWeb(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1)

	{
		try {

			WebElement element = genericmethods.findElement(objectref, inputparam, wdriver);
			//element.sendKeys("test");
			Thread.sleep(2000);
			element.clear();

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public String getElementValue(WebElement webelement, String property) {
		String sValue = null;
		try {
			switch (property) {
			case "name":
				sValue = webelement.getAttribute("name");
				break;
			case "class":
				sValue = webelement.getAttribute("className");
				break;
			}
		} catch (Exception e) {
			System.out.println("Object not found : " + e.getMessage());
			// Element1 = null;
		}
		return sValue;
	}

	public static void oAddValInHashTab(String sObjkey, String sObjVal) {

		try {
			// if (hTab == null)
			{
				hTab.put(sObjkey, sObjVal);
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 
	 * @param TestDesc
	 * @param objectref
	 * @param inputparam
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 */
	/*
	 * 'Description : This method would close the application 'InputParameters :
	 * byDefault 'OutPutParameters: None 'Author: Vikram Kapale. 'Date:
	 * 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void reLaunch(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) 
	{
		try{
			driver.resetApp();
			Thread.sleep(5000);
			try{
			WebElement wAllow = driver.findElement(By.name("Allow"));
			
			wAllow.click();
			}
			catch(Exception e)
			{
			System.out.println("error");
			}
		}
		catch(Exception e)
		{
			System.out.println("Unable to close the application");
		}
	}
	
	public void close(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) {
		wdriver.manage().deleteAllCookies();
		wdriver.close();
		wdriver.quit();
		
	
	}
	
	

	public void selectFromHamMenu(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) {
		((AppiumDriver) driver).closeApp();
	}

	/**
	 * 
	 * @param TestDesc
	 * @param objectref
	 * @param inputparam
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 * @throws Throwable
	 * 
	 * 
	 */

	/*
	 * 'Description : This method would validate available options/text on the
	 * screen 'InputParameters : byDefault 'OutPutParameters: None 'Author:
	 * Vikram Kapale. 'Date: 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void validateScreenOptions(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{

		if (driverscript.sDevice_ID_TestCase.contains("web"))
		{
		
		try {
			boolean bFlag = false;
			String strValues1 = null;
			StringBuilder sDisplayedOptions = new StringBuilder();
			StringBuilder sNotDisplayedOptions = new StringBuilder();
			String[] aFundTransferOptions = objectref.split("\\|");
			for (int i = 0; i < aFundTransferOptions.length; i++) {
				String sOptionVal = aFundTransferOptions[i];
				WebElement FundTransferOption = genericmethods.findElement("text", sOptionVal, wdriver);
				wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if (FundTransferOption != null  && FundTransferOption.isDisplayed()) 
				{
					sDisplayedOptions.append(sOptionVal);
					sDisplayedOptions.append("|");
					strValues = sDisplayedOptions.toString();
				}

				else 
				{
					sNotDisplayedOptions.append(sOptionVal);
					sNotDisplayedOptions.append("|");
					strValues1 = sNotDisplayedOptions.toString();
				}
			}
					captureScreenShot(wdriver);
					reporter.onSuccessscreenshot(TestDesc + " - Displayed Options are", strValues,
						afileLocdir + "\\" + aTestStepID + ".png");
			
			
			if (sNotDisplayedOptions.length() != 0) {
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, "Options not displayed are : " + strValues1, afileLocdir + "\\" + aTestStepID + ".png");
			} else {
				captureScreenShot(wdriver);
			}

		}

		catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
			Thread.sleep(2000);
			captureScreenShot(wdriver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}
		}
		
		else
		{
			
			try {
				boolean bFlag = false;
				String strValues1 = null;
				StringBuilder sDisplayedOptions = new StringBuilder();
				StringBuilder sNotDisplayedOptions = new StringBuilder();
				String[] aFundTransferOptions = objectref.split("\\|");
				for (int i = 0; i < aFundTransferOptions.length; i++) {
					String sOptionVal = aFundTransferOptions[i];

					WebElement FundTransferOption = genericmethods.findElement("name", sOptionVal, driver);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
					if (FundTransferOption != null  && FundTransferOption.isDisplayed()) 
					{
						sDisplayedOptions.append(sOptionVal);
						sDisplayedOptions.append("|");
						strValues = sDisplayedOptions.toString();
					}

					else 
					{
						sNotDisplayedOptions.append(sOptionVal);
						sNotDisplayedOptions.append("|");
						strValues1 = sNotDisplayedOptions.toString();
					}
				}

				
				captureScreenShot(driver);
					reporter.onSuccessscreenshot(TestDesc + " - Displayed Options are", strValues,
							afileLocdir + "\\" + aTestStepID + ".png");
				
				
				if (sNotDisplayedOptions.length() != 0) {
					captureScreenShot(driver);
					reporter.onFailure(TestDesc, "Options not displayed are : " + strValues1, afileLocdir + "\\" + aTestStepID + ".png");
				} else {
					captureScreenShot(driver);
				}

			}

			catch (Exception e) {
				Log.error("Not able to click --- " + e.getMessage());
				DriverScript.bResult = false;
				Thread.sleep(2000);
				captureScreenShot(driver);
				reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
			}
						
		}
		
	}

	 public void uploadFile(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
	            String inputparam1) throws IOException{
	       
	       Runtime.getRuntime().exec("C:\\Users\\IBM_ADMIN\\Desktop\\AutoIT\\ImageUpload.exe");   
	       }
	
	public void datePicker1(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{
		wdriver.findElement(By.xpath(".//*[@id='datepicker']")).click();
		Thread.sleep(1000);
		wdriver.findElement(By.xpath("//span[contains(.,'2017')]")).click();
		Thread.sleep(1000);
		wdriver.findElement(By.xpath("//parent::a[@ng-click='paginateYears(paginationYears[0])']")).click();
		Thread.sleep(1000);
		wdriver.findElement(By.xpath("//parent::a[@ng-click='paginateYears(paginationYears[0])']")).click();
		Thread.sleep(1000);
		wdriver.findElement(By.xpath("//parent::a[@ng-click='paginateYears(paginationYears[0])']")).click();
		Thread.sleep(1000);
		wdriver.findElement(By.xpath("//a[contains(.,'1994')]")).click();
		Thread.sleep(1000);
		wdriver.findElement(By.xpath("//a[contains(.,'19')]")).click();
		Thread.sleep(1000);
	}
	
	public void uniqueMobileNumber(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{
		WebElement mobile;
		Random rand = new Random();
	    int num1, num2, num3;
	    num1 = rand.nextInt (90) + 10;
	    num2 = rand.nextInt (643) + 100;
	    num3 = rand.nextInt (9000) + 1000;
	    String mobileNumber = "9" + Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num3);
	    //System.out.println(mobileNumber);
	    wdriver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys(mobileNumber);
	    Thread.sleep(1000);
	    wdriver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		wdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(wdriver, 2);
		try
		{
			for(int i=0 ; i<10; i++)
			{
				try
				{
					mobile = wdriver.findElement(By.xpath("//button[contains(.,'OK')]"));
				}
				catch(Exception e)
				{	
					return;
				}	
				mobile.click();
	//			Random rand = new Random();
	//		    int num1, num2, num3;
			    num1 = rand.nextInt (900) + 100;
			    num2 = rand.nextInt (643) + 100;
			    num3 = rand.nextInt (9000) + 1000;
			    mobileNumber = Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num3);
			    //System.out.println(mobileNumber);
			    wdriver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys(mobileNumber);
			    Thread.sleep(1000);
			    wdriver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
				wdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	//			WebDriverWait wait = new WebDriverWait(wdriver, 2);
				try
				{
				mobile = wdriver.findElement(By.xpath("//button[contains(.,'OK')]"));
				}
				catch(Exception e)
				{
					return;
				}

			}
		}
	    catch(Exception e)
		{
	    	return;
		}
	}
	
	
	

	public void profileEdit(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{
		String oldValue = wdriver.findElement(By.xpath(".//*[@id='1']/span")).getText();
		WebElement webel = genericmethods.findElement("xpath", ".//*[@id='PRSNL_INFO_ANC']/span[2]", wdriver);
		webel.click();
		WebElement webel1 = genericmethods.findElement("xpath", ".//*[@id='1']/div/div/button", wdriver);
		webel1.click();
		Thread.sleep(1000);
		
		
		
		
		java.util.List<WebElement>  option1 = webel1.findElements(By.xpath("//a[contains(@class,'option')]"));
		webel1.click();
		for (int i=0; i<option1.size()-1; i++)
		{
			webel1.click();
			String sOption = "//li[contains(.,'" + option1.get(i) +"')]";
			wdriver.findElement(By.xpath(sOption)).click();
			String newValue = wdriver.findElement(By.xpath(".//*[@id='1']/span")).getText();
			
		}
		
	}
	
	
	
	
	public void navigate(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable 
	{
		wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objectref = objectref.toLowerCase();
		switch(objectref)
		{  
		
	    case "back": 
	    	wdriver.navigate().back();
	    	break;  
	    	
	    case "forward": 
	    	wdriver.navigate().forward();
	    	break;  
	    	
	    default:
	    	System.out.println("switch case navigation is not matching");  
		
		}
	}	
	
	
	
	
	public void validateLinks(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {

		if (driverscript.sDevice_ID_TestCase.contains("web")) {

			try {
				boolean bFlag = false;
				String strValues1 = null;
				StringBuilder sDisplayedOptions = new StringBuilder();
				StringBuilder sNotDisplayedOptions = new StringBuilder();
				String[] aFundTransferOptions = objectref.split("\\|");
				for (int i = 0; i < aFundTransferOptions.length; i++) {
					String sOptionVal = aFundTransferOptions[i];
					sOptionVal = "//a[contains(.,'" + sOptionVal + "')]";
					WebElement FundTransferOption = genericmethods.findElement("xpath", sOptionVal, wdriver);
					wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					if (FundTransferOption != null && FundTransferOption.isDisplayed()) 
					{
						sDisplayedOptions.append(sOptionVal);
						sDisplayedOptions.append("|");
						strValues = sDisplayedOptions.toString();
					}

					else 
					{
						sNotDisplayedOptions.append(sOptionVal);
						sNotDisplayedOptions.append("|");
						strValues1 = sNotDisplayedOptions.toString();
					}
				}

				captureScreenShot(wdriver);
				reporter.onSuccessscreenshot(TestDesc + " - Displayed Options are", strValues,
						afileLocdir + "\\" + aTestStepID + ".png");

				if (sNotDisplayedOptions.length() != 0) {
					captureScreenShot(wdriver);
					reporter.onFailure(TestDesc, "Options not displayed are : " + strValues1,
							afileLocdir + "\\" + aTestStepID + ".png");
				} else {
					captureScreenShot(wdriver);
				}
			}

			catch (Exception e) {
				Log.error("Not able to click --- " + e.getMessage());
				DriverScript.bResult = false;
				Thread.sleep(2000);
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
			}
		}
	}	
	
	

	
	
	
	
	
	
	
	
	public void validateAllObjects(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {

		if (driverscript.sDevice_ID_TestCase.contains("web")) {

			try {
				boolean bFlag = false;
				String strValues1 = null;
				StringBuilder sDisplayedOptions = new StringBuilder();
				StringBuilder sNotDisplayedOptions = new StringBuilder();
				String[] aFundTransferOptions = inputparam.split("\\|");
				for (int i = 0; i < aFundTransferOptions.length; i++) {
					String sOptionVal = aFundTransferOptions[i];
					sOptionVal = "//" + objectref + " [contains(.,'" + sOptionVal + "')]";
					WebElement FundTransferOption = genericmethods.findElement("xpath", sOptionVal, wdriver);
					wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					if (FundTransferOption != null && FundTransferOption.isDisplayed()) 
					{
						sDisplayedOptions.append(sOptionVal);
						sDisplayedOptions.append("|");
						strValues = sDisplayedOptions.toString();
					}

					else 
					{
						sNotDisplayedOptions.append(sOptionVal);
						sNotDisplayedOptions.append("|");
						strValues1 = sNotDisplayedOptions.toString();
					}
				}

				captureScreenShot(wdriver);
				reporter.onSuccessscreenshot(TestDesc + " - Displayed Options are", strValues,
						afileLocdir + "\\" + aTestStepID + ".png");

				if (sNotDisplayedOptions.length() != 0) {
					captureScreenShot(wdriver);
					reporter.onFailure(TestDesc, "Options not displayed are : " + strValues1,
							afileLocdir + "\\" + aTestStepID + ".png");
				} else {
					captureScreenShot(wdriver);
				}
			}

			catch (Exception e) {
				Log.error("Not able to click --- " + e.getMessage());
				DriverScript.bResult = false;
				Thread.sleep(2000);
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
			}
		}
	}	

	
	
	
	
	
	
	
	
	
	
	public void validateTextOnWebPage(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {

		if (driverscript.sDevice_ID_TestCase.contains("web")) {

			try {
				boolean bFlag = false;
				String strValues1 = null;
				StringBuilder sDisplayedOptions = new StringBuilder();
				StringBuilder sNotDisplayedOptions = new StringBuilder();
				String[] aFundTransferOptions = objectref.split("\\|");
				for (int i = 0; i < aFundTransferOptions.length; i++) {
					String sOptionVal = aFundTransferOptions[i];
					sOptionVal = "//a[contains(.,'" + sOptionVal + "')]";
					WebElement FundTransferOption = genericmethods.findElement("xpath", sOptionVal, wdriver);
					wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					if (FundTransferOption != null && FundTransferOption.isDisplayed()) 
					{
						sDisplayedOptions.append(sOptionVal);
						sDisplayedOptions.append("|");
						strValues = sDisplayedOptions.toString();
					}

					else 
					{
						sNotDisplayedOptions.append(sOptionVal);
						sNotDisplayedOptions.append("|");
						strValues1 = sNotDisplayedOptions.toString();
					}
				}

				captureScreenShot(wdriver);
				reporter.onSuccessscreenshot(TestDesc + " - Displayed Options are", strValues,
						afileLocdir + "\\" + aTestStepID + ".png");

				if (sNotDisplayedOptions.length() != 0) {
					captureScreenShot(wdriver);
					reporter.onFailure(TestDesc, "Options not displayed are : " + strValues1,
							afileLocdir + "\\" + aTestStepID + ".png");
				} else {
					captureScreenShot(wdriver);
				}
			}

			catch (Exception e) {
				Log.error("Not able to click --- " + e.getMessage());
				DriverScript.bResult = false;
				Thread.sleep(2000);
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
			}
		}
	}	
	
	

	
	
	
	
	
	
	public void validateEnabledScreenOptions(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		try {
			StringBuilder sDisplayedOptions = new StringBuilder();
			StringBuilder sNotDisplayedOptions = new StringBuilder();
			String[] aFundTransferOptions = objectref.split("\\|");
			for (int i = 0; i < aFundTransferOptions.length; i++) {
				String sOptionVal = aFundTransferOptions[i];
				// sOptionVal = sOptionVal.trim();

				WebElement FundTransferOption = genericmethods.findElement("name", sOptionVal, driver);

				if (FundTransferOption == null) {
					sNotDisplayedOptions.append(sOptionVal);
					sNotDisplayedOptions.append("|");
					strValues = sNotDisplayedOptions.toString();
				}

				if (FundTransferOption != null && FundTransferOption.isEnabled() == true) {
					sDisplayedOptions.append(sOptionVal);
					sDisplayedOptions.append("|");
					strValues = sDisplayedOptions.toString();
				}
			}

			if (sNotDisplayedOptions.length() != 0) {
				captureScreenShot(driver);
				reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
				reporter.onInfo("UnMatched Options are", strValues, afileLocdir + "\\" + aTestStepID + ".png");
			} else {
				captureScreenShot(driver);
				reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
				reporter.onSuccessscreenshot("Matched Options are", strValues,
						afileLocdir + "\\" + aTestStepID + ".png");
			}

		}

		catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
			Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}

	}

	
	public void test111(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable
	{
		MobileElement fieldTwo = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[contains(@content-desc,'SAVE ')]"));
		fieldTwo.click();
	}
	
	
	
	public void test11(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		//MobileElement fieldTwo = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[contains(@content-desc,'SAVE ')]"));
		//((AndroidDriver) driver).findElementByAndroidUIAutomator()
		 MobileElement el2 = (MobileElement) ((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("text(\"Contact Details\")");
		 el2.click();
		//driver.swipe("", arg2, arg3, arg4);
		//fieldTwo.click();
	}

	
	
	public void pageLoad(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		 wdriver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	
	}
	
	public void scrollToText(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");

		boolean flag = false;
		if (String.valueOf(driverscript.sDevice_ID_TestCase).contains("web"))
		{
			WebElement webelement = genericmethods.findElement(objectref, inputparam, wdriver);
			Actions actions = new Actions(wdriver);
			actions.moveToElement(webelement);
			actions.perform();
		}

		else {
			try 
			{
				((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+objectref+"\").instance(0))");
				
			} catch (Exception e) 
			{
				Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "**********");
				Log.error("Exception message : " + e.getMessage());
			}
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		Thread.sleep(5000);
	}


	public void selectAccount(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable
	{
		try
		{
			boolean closeAccount = false;
			WebElement account = driver.findElement(By.xpath("//android.widget.Spinner[contains(@index,'0')]"));
			account.click();
			List dropList = driver.findElements(By.id("android:id/text1"));
			for(int i=0; i< dropList.size(); i++)
			{
				   MobileElement listItem = (MobileElement) dropList.get(i);   
				   String[] accountdetails = listItem.getText().split("₹ ");
				   String amount = accountdetails[1].trim();
				   amount = amount.replaceAll(",","");
				   Integer amt = Integer.parseInt(amount);
				   if (amt > 5000)
				   {
					  // Select d1 = new Select(account);
					   String optionxpath = "//android.widget.CheckedTextView[contains(@index,'" + i + "')]";
					   driver.findElement(By.xpath(optionxpath)).click();
					   try{
						   closeAccount = driver.findElement(By.xpath("//android.widget.Button[contains(@content-desc,'OK ')]")).isDisplayed(); 
					   }
					   catch(Exception e)
					   {
						   System.out.println(e.getMessage());
						   break;
					   }
					   
					if (closeAccount==true)
					   {
						   driver.findElement(By.xpath("//android.widget.Button[contains(@content-desc,'OK ')]")).click();
					   }
					   else
					   {
						   break;
					   }
				   }
			} 
		}
		catch (Exception e)
		{
			System.out.println();
		}
		

	}
	

	

	public void selectAccountM(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {
			boolean closeAccount = false;
			WebElement account = driver.findElement(By.xpath(objectref));
			account.click();
			List dropList = driver.findElements(By.id("android:id/text1"));

			for (int i = 0; i < dropList.size(); i++) {
				String selectview = "//android.widget.CheckedTextView[contains(@index,'" + i + "')]";
				MobileElement element = (MobileElement) driver.findElement(By.xpath(selectview));
				String text = element.getAttribute("text");
				// element.click();
				// String text = element.getText();
				String[] accountdetails = text.split("₹ ");
				// String amount = accountdetails[1].trim();
				String amount = accountdetails[1].replaceAll(",", "");
				amount = amount.substring(0, amount.length() - 3);
				Integer amt = Integer.parseInt(amount);
				if (amt > 5000) {
					element.click();
					try {
						closeAccount = driver
								.findElement(By.xpath("//android.widget.Button[contains(@content-desc,'OK ')]"))
								.isDisplayed();
					} catch (Exception e) {
						System.out.println(e.getMessage());
						break;
					}

					if (closeAccount == true) {
						driver.findElement(By.xpath("//android.widget.Button[contains(@content-desc,'OK ')]")).click();
						account.click();
					} else {
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println();
		}

	}
	
	
	
	public void selectValueFromDropdown(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable
	{
		Select comboBox = new Select(wdriver.findElement(By.xpath(objectref)));
		comboBox.selectByVisibleText(inputparam);
	}
	
	
	public void selectAccountPortal(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable
	{
		{
			Thread.sleep(10000);
			Select comboBox = new Select(wdriver.findElement(By.xpath(objectref)));
			String objref1 = objectref + "/option";
			Thread.sleep(1000);
			List<WebElement> l = wdriver.findElements(By.xpath(objref1));
			Thread.sleep(1000);
			for(int i=0; i<=l.size()-1; i++)
			{
				comboBox.selectByIndex(i);
				String strCurrentValue = comboBox.getFirstSelectedOption().getText();
				if (strCurrentValue.contains("Select Account"))
				{
					i=i+1;
					comboBox.selectByIndex(i);
					strCurrentValue = comboBox.getFirstSelectedOption().getText();
				}
				
				String[] aamt = strCurrentValue.split(" ");
				   String amount = aamt[aamt.length-1].trim();
				   if (amount.contains("₹"))
				   {
					   amount = amount.replace("₹", "");
				   }
				   amount = amount.replaceAll(",","");
				   amount =amount.substring(0,amount.length()-3);
				   Integer amt = Integer.parseInt(amount);
				if (amt > 1000)
				   {
					   WebDriverWait wait = new WebDriverWait(wdriver, 10);
					   wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					   try
					   {
					   WebElement inactiveaccount = wdriver.findElement(By.xpath("//span[contains(.,'Please use an active account to create the Fixed Deposit.')]"));
					   if (inactiveaccount.isDisplayed() == false)
					   {
						   break;
					   }
					   }
					   catch(Exception e)
					   {
						   break;
					   }
				   }
			}
		}
	}	
	
	public void selectAccountMobile(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable
	{
		{
			Thread.sleep(10000);
			Select comboBox = new Select(driver.findElement(By.xpath(objectref)));
			List<WebElement> l = comboBox.getOptions();
			for(int i=0; i<=l.size(); i++)
			{
				comboBox.selectByIndex(i);
				String strCurrentValue = comboBox.getFirstSelectedOption().getText();
				String[] aamt = strCurrentValue.split(" ");
				   String amount = aamt[aamt.length-1].trim();
				   amount = amount.replaceAll(",","");
				   amount =amount.substring(0,amount.length()-3);
				   Integer amt = Integer.parseInt(amount);
				if (amt > 2000)
				   {
					   WebDriverWait wait = new WebDriverWait(driver, 10);
					   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					   try
					   {
					   WebElement inactiveaccount = driver.findElement(By.xpath("//span[contains(.,'Please use an active account to create the Fixed Deposit.')]"));
					   if (inactiveaccount.isDisplayed() == false)
					   {
						   break;
					   }
					   }
					   catch(Exception e)
					   {
						   break;
					   }
				   }
			}
		}
	}	
	
	public void scrollToText111(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");

		boolean flag = false;
		if (String.valueOf(driverscript.sDevice_ID_TestCase).contains("web"))
		{
			WebElement webelement = genericmethods.findElement(objectref, inputparam, wdriver);
			Actions actions = new Actions(wdriver);
			actions.moveToElement(webelement);
			actions.perform();
		}

		else {
			try {
				String sText = "new UiScrollable(new UiSelector()).scrollIntoView("
						+ "new UiSelector().text(\"_Health Kart_\"));";
				sText = sText.replace("Health Kart", objectref);
				((AndroidDriver) driver).findElementByAndroidUIAutomator(sText);
			} catch (Exception e) {
				// captureScreenShot(driver);
				// reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\"
				// + aTestStepID + ".png");
				Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "**********");
				Log.error("Exception message : " + e.getMessage());
			}
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		Thread.sleep(5000);
	}


	
	
	
	
	public void scrollToText11(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		try
		{
			MobileElement m1 = (MobileElement) driver.findElement(By.name("Create Fixed Deposit"));	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", m1);
		}
		catch(Exception e)
		{
			System.out.println();
		}
}

	
	
	public void scrollToTexttest(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		String str = "Health & Personal Care";
		 ((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))");
	}
	
	
	public void scrollToText1(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		
		MobileElement m1 = (MobileElement) driver.findElement(By.name("Create Fixed Deposit"));
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.elementToBeClickable(m1));
			m1.click();
		}
			catch(Exception e)
		{
			System.out.println("");
		}
	
	}
	
	
	
	
	
	
	
	public void mobileScroll1(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		try
			{
			int i = Integer.parseInt(objectref);
			Object WebDriverWait;
			for(int j=0 ; j<=i; j++)
			{WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement webelement = genericmethods.findElement(objectref, inputparam, driver);
			org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();
		    Double screenHeightStart = dimensions.getHeight() * 0.5;
		    int scrollStart = screenHeightStart.intValue();
		    Double screenHeightEnd = dimensions.getHeight() * 0.2;
		    int scrollEnd = screenHeightEnd.intValue();
		    driver.swipe(0,scrollStart,0,scrollEnd,2000);
		    
		  
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	
	
	public void mobileScroll(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		//driver.findElement(ByAndroidUIAutomator)
		String APP_SCROLLVIEW = "android.widget.ScrollView";
		String DESTINATION_ELEMENT_TEXT= "Contact Details";
		((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().className(APP_SCROLLVIEW)).scrollIntoView(new UiSelector().text(DESTINATION_ELEMENT_TEXT))");	
	}
	
	
	public void clickOnCord(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		try {
			String[] aobjectref = inputparam.split("\\|");
			int x = Integer.parseInt(aobjectref[0]);
			int y = Integer.parseInt(aobjectref[1]);
			TouchAction touchAction = new TouchAction((MobileDriver) driver);
			touchAction.tap(x, y).perform();
		}

		catch (Exception e) {
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
			Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.error("Exception message : " + e.getMessage());
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
	}

	public void findAllObjectAndClick(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		try {
			java.util.List<WebElement> objects = driver.findElements(By.className(objectref));
			objects.get(0).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void writeInExcel(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		String[] aobjectref = objectref.split("\\|");
		WebElement element = genericmethods.findElement(aobjectref[0], aobjectref[1], driver);
		String value = element.getAttribute("name");
		ExcelUtils.setCellData(value, driverscript.iTestStep, Constants.Col_InputParams, Constants.Sheet_TestSteps,
				adatasheetloc);
	}

	public void writeInExcel(String value) throws Throwable {

		ExcelUtils.setCellData(value, driverscript.iTestStep, Constants.Col_InputParams, driverscript.sTestCaseID1,
				adatasheetloc);

	}

	public void getRSFromDropDownFixedDp(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		String[] aobjectref = objectref.split("\\|");
		WebElement element = genericmethods.findElement(aobjectref[0], aobjectref[1], driver);
		String value = element.getAttribute("name");
		String[] aValue = value.split("\\s+");

		writeInExcel(aValue[1]);
	}

	

	
	
	
	/*
	 * 'Description : This method would launch an Application 'InputParameters :
	 * byDefault 'OutPutParameters: None 'Author: Vikram Kapale. 'Date:
	 * 12-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void launchWeb(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		boolean flag = false;
	
		if (String.valueOf(driverscript.sDevice_ID_TestCase).contains("web")) 
		{
			if (String.valueOf(driverscript.sDevice_ID_TestCase).contains(aplatformName)) 
			{
			
			try {
				String[] aobjectref = driverscript.sDevice_ID_TestCase.split("\\|");
				String sType = aobjectref[0];
				String sBrowser = aobjectref[1];
				wdriver = ExecutionDriver.getInstanceWeb(aobjectref[1],objectref);
				flag = true;
				if (inputparam.length() > 2)
				{
					boolean oElemFlag = waitForObject(inputparam,wdriver);
					if (oElemFlag == false) 
					{
						Log.error("Not able to launch app ");
						DriverScript.bResult = false;
						Thread.sleep(2000);
						captureScreenShot(wdriver);
						reporter.onFailure(TestDesc, "is failed",afileLocdir + "\\" + aTestStepID + ".png");
						System.out.println("Launch event exit...");
						//return oElemFlag;
					}
					else
					{
						captureScreenShot(wdriver);
						reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
						Thread.sleep(6000);
						
					}
				}
				else
				{
					boolean oElemFlag = true;
				}
			} catch (Exception e) 
			{
				WebDriver driver= null;
				driverscript.bResult = false;
				captureScreenShot(driver);
				reporter.onFailure("Error message", "Error message has been displayed", afileLocdir + "\\" + aTestStepID + ".png");
			}
		}
		}
	}
	

	
	public static void handleLoader() throws InterruptedException 
	{
		Thread.sleep(2000);
		for (int i = 0; i <= 60; i++) 
		{
			try 
			{
				WebDriverWait wait = new WebDriverWait(wdriver, 1);
				wdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement w1 = wdriver.findElement(By.xpath("//div[(@class='loader')]"));
				if (w1.isDisplayed() == false)
				{
					return;
				}
				boolean bFlag = false;
				Thread.sleep(5000);
			} 
			catch (Exception e) 
			{
				return;
			}

		}

	}
	

	
	public boolean launch(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		boolean flag = false;
		
		// --------------------Running this---------------------------

		if ((aappType.equalsIgnoreCase("NATIVE") || aappType.equalsIgnoreCase("HYBRID"))
				&& aplatform.equalsIgnoreCase("GRID") && aplatformName.equalsIgnoreCase("Andriod")) {
			try {
				//AppiumDriver driver = null;
				if (driver == null)
				{
						Log.info("Launch Mobile App");
						System.out.println("...................Launch Mobile App Event Started........");
						Log.error("Not able to launch app ");
						setupCapabilities();
						capabilities.setCapability("appPackage", aappPack);
						capabilities.setCapability("appActivity", aappAct);
						System.out.println("Into Device ID:" + adeviceid);
						//	driver.installApp("C://Users//IBM_ADMIN//Desktop//APK//22Feb.apk");
						driver = new AndroidDriver(new URL(aurl), capabilities);
						driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
						Thread.sleep(2000);
						Set contextNames = ((AppiumDriver) driver).getContextHandles();
						Iterator iterator = contextNames.iterator();
						while (iterator.hasNext()) 
						{
							String contextName = iterator.next().toString();
							contexts.add(contextName);
						}
						flag = true;
					//	return true;
				}
				else
				{
					driver.resetApp();
					flag = true;
					Thread.sleep(5000);
					try
					{
					WebElement wAllow = driver.findElement(By.name("Allow"));
					wAllow.click();
					Thread.sleep(10000);
					}
					catch(Exception e)
					{
					System.out.println("Allow not displayed");
					}

				}
			} catch (Exception e) {
				return false;
			} 
			
		}

		//driver = (AppiumDriver) driver1;
		try
		{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 1);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);	
		WebElement wAllow = driver.findElement(By.name("Allow"));
		wAllow.click();
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
		System.out.println("Allow not displayed");
		}

		
		boolean oElemFlag = waitForObject(inputparam,driver);
		if (oElemFlag == false) 
		{
			System.out.println("Launch event exit...");
			System.exit(0);
		}

		if (flag == false) 
		{
			Log.error("Not able to launch app ");
			DriverScript.bResult = false;
			Thread.sleep(2000);
			// captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is failed",
					"C://MobilePOC//Sayom'sVersion//Appium_ScriptLess_Framework//logos//Stop.png");
		} 
		else if (flag == true) {
			captureScreenShot(driver);
			reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
			Thread.sleep(6000);

		}
		return oElemFlag;
	}

	
	
	
	
	
	
	
	
	
	
	
	public void test(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		try
		{
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=qpjbWOTWMevI8AeagIGYCQ");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	
	
	
	
	
	
	/**
	 * 	
	 * @param TestDesc
	 * @param objectref
	 * @param inputparam
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 * @return
	 * @throws Throwable
	 */
			
	  /*
		'Description : This method would launch an Application
		'InputParameters : byDefault
		'OutPutParameters:  None
		'Author: Vikram Kapale.
		'Date:  12-January-2017
		'Status := Executed
		'**************************************************************************************************
		'		C  H  A  N  G  E		H  I  S  T  O  R  Y
		'**************************************************************************************************
		' Date			Change made by		Purpose of change
		'--------		------------------- -------------------------------------------------
		'
		'**************************************************************************************************  
	  */	

	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void validateError(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
			Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			Log.info(TestDesc + "|" + objectref + "|" + inputparam);
			
			WebDriverWait wait = new WebDriverWait(driver, 1);
			WebElement webelement = genericmethods.findElement("name", "Error", driver);
			
			if (webelement == null) 
			{
				driverscript.bResult = true;
				captureScreenShot(driver);
				reporter.onSuccessscreenshot("Error message", "Error message has not been displayed", afileLocdir + "\\" + aTestStepID + ".png");
			} else 
			{
				driverscript.bResult = false;
				captureScreenShot(driver);
				reporter.onFailure("Error message", "Error message has been displayed", afileLocdir + "\\" + aTestStepID + ".png");
			}
		
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
	}

	
	public boolean validateRunTimeError() throws Throwable 
	{
		if (driverscript.sDevice_ID_TestCase.contains("web"))
		{
			bStopExecution = false;
			Log.info("Started : **********" + "Runtime error validation" + "**********");
			WebElement webelement = null;
			WebDriverWait wait = new WebDriverWait(wdriver, 1);
			wdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			try
			{
				webelement = wdriver.findElement(By.name("Error"));
			}
			catch(Exception e)
			{
				webelement = null;
			}
			
			if (webelement == null) 
			{
				driverscript.bResult = true;
				return false;
			} else 
			{
				bStopExecution = true;
				driverscript.bResult = false;
				captureScreenShot(wdriver);
				reporter.onFailure("Error message", "Error message has been displayed", afileLocdir + "\\" + aTestStepID + ".png");
				return true;
			}
	
		}
		
		else
			
		{
				bStopExecution = false;
				Log.info("Started : **********" + "Runtime error validation" + "**********");
				WebElement webelement = null;
				WebDriverWait wait = new WebDriverWait(driver, 1);
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				try
				{
					webelement = driver.findElement(By.name("Error"));
				}
				catch(Exception e)
				{
					webelement = null;
				}
				
				if (webelement == null) 
				{
					driverscript.bResult = true;
					return false;
				} else 
				{
					bStopExecution = true;
					driverscript.bResult = false;
					captureScreenShot(driver);
					reporter.onFailure("Error message", "Error message has been displayed", afileLocdir + "\\" + aTestStepID + ".png");
					return true;
				}
		}
	}	

	public void removeAllItemsFromWishlist(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		if (driverscript.sDevice_ID_TestCase.contains("web")) {

		} else {
			for (int i = 0; i <= 10; i++) {
				java.util.List<WebElement> remove = driver.findElements(By.name("delete"));
				if (remove.size() != 0) {
					remove.get(0).click();
					Thread.sleep(5000);
				} else {
					break;
				}
			}
		}

	}
	
	public void wishlist(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable 
	{
		int i = 0;
				for (int j = 0; j <= 10; j++)
				{
				
				try
				{
					java.util.List<WebElement> remove = wdriver.findElements(By.xpath("//img[contains(@src,'/wps/PA_omp/img/omp-icons/trash.svg')]"));
					for (i = 0; i <= remove.size()-1; i++)
						{
						Thread.sleep(1000);
						remove.get(i).click();
						Thread.sleep(1000);}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				}
	}	

	public static int rowCount(String tablexpath) throws Exception 
	{
		int rowCount;
		rowCount = 0;
		String sXpath = tablexpath + "/tbody/tr";
		try
		{
		rowCount = wdriver.findElements(By.xpath(sXpath)).size();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return rowCount;	
	}
	

	public static int colCount(String tablexpath) throws Exception 
	{
		int colCount;
		colCount = 0;
		String sXpath = tablexpath + "/tbody/tr[1]/td";
		colCount = wdriver.findElements(By.xpath(sXpath)).size();
		return colCount;	
	}

	public static boolean waitTillTableData(String tablexpath) throws Exception
	{
		boolean data = false;
		for (int iwait=0; iwait<20; iwait++)
		{
			int row = rowCount(tablexpath);
			if (1 < row)
			{
				data = true;
				break;
			}
			else
			{
				Thread.sleep(5000);
			}
		}
		return data;
	}
	
	public static String getCellData(String tablexpath, int tbody, int row, int col) throws Exception 
	{
		String data = "";
		String first_part = tablexpath + "/tbody[" + tbody + "]/tr[";
		String second_part = "]/td[";
		String third_part = "]";
		String final_xpath = first_part + row + second_part + col + third_part;
		try
		{
		data = wdriver.findElement(By.xpath(final_xpath)).getText();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return data;	
	}
	
	public static BigDecimal currency(String savingamt)
	{
	//Object currencyVal;
		//	BigDecimal currencyVal = null;
		try
		{
			BigDecimal currencyVal = new BigDecimal(savingamt);
			
			return currencyVal;
		}
		catch(Exception e)
		{
			Object currencyVal = null;
			System.out.println(e.getMessage());
			return (BigDecimal) currencyVal;
		}
		//return currencyVal;
	}
	
	public void validateMyBalance(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Exception 
	{
		BigDecimal totalSavingRs = new BigDecimal(0l);
		BigDecimal totalCurrentRs  = new BigDecimal(0l);
		BigDecimal myBalance = new BigDecimal(0l);
		
		// Calculate Saving Account Rs
		String xpathSavingAccount = "//table[@ng-show='displaySavings']";
		if (false == waitTillTableData(xpathSavingAccount))
		{
			reporter.onInfo("Table data", "Saving table data has not been displayed", afileLocdir + "\\" + aTestStepID + ".png");
			System.exit(0);
		}
		BigDecimal savingamtBig=null;
		BigDecimal currentamtBig=null;
		
		int row = rowCount(xpathSavingAccount);
		int col = colCount(xpathSavingAccount);
		for(int i=1; i<=row-1; i++ )
		{
			String savingamt = getCellData(xpathSavingAccount, 2, i, 3);
			
			savingamt = sGetNumber(savingamt);
			//savingamt = savingamt.trim();
			//savingamt = savingamt.replace(".", "");
			savingamtBig = currency(savingamt);
			totalSavingRs = totalSavingRs.add(savingamtBig) ;
		}
		
		
		// Calculate Current Account Rs
		String xpathCurrentAccount = "//table[@ng-show='displayCurrent']";
		if (false == waitTillTableData(xpathCurrentAccount))
		{
			reporter.onInfo("Table data", "Current table data has not been displayed", afileLocdir + "\\" + aTestStepID + ".png");
			System.exit(0);
		}

		row = rowCount(xpathCurrentAccount);
		col = colCount(xpathCurrentAccount);
		for(int i=1; i<=row-1; i++ )
		{
			String sCurrentAmt = getCellData(xpathCurrentAccount, 2, i, 3);
			sCurrentAmt = sGetNumber(sCurrentAmt);
		//	sCurrentAmt = sCurrentAmt.trim();
			//sCurrentAmt = sCurrentAmt.replace(".", "");
			currentamtBig = currency(sCurrentAmt);
			totalCurrentRs = totalCurrentRs.add(currentamtBig);
		}
		
		// Add Current balance and Saving balance
		myBalance = totalCurrentRs.add(totalSavingRs);
		
		String getDisplayedBalance = wdriver.findElement(By.xpath("//div[contains(@class,'RobotoRegular20px ng-binding')]/span")).getText();
		getDisplayedBalance = sGetNumber(getDisplayedBalance);
		
		if (myBalance.toString().contains(getDisplayedBalance))
			
		{
			captureScreenShot(wdriver);
			reporter.onSuccessscreenshot("Total", "My Balance = Savings Account + Current Account is matching", afileLocdir+"\\"+aTestStepID+".png");
			reporter.onInfo("Total : ", myBalance.toString() , afileLocdir + "\\" + aTestStepID + ".png");
			reporter.onInfo("Displayed balance : ", getDisplayedBalance, afileLocdir + "\\" + aTestStepID + ".png");
		}
		else
		{
			captureScreenShot(wdriver);
			reporter.onFailure("Total", "My Balance = Savings Account + Current Account is matching", afileLocdir+"\\"+aTestStepID+".png");
			reporter.onInfo("Total : ", myBalance.toString() , afileLocdir + "\\" + aTestStepID + ".png");
			reporter.onInfo("Displayed balance : ", getDisplayedBalance, afileLocdir + "\\" + aTestStepID + ".png");

		}
	}
	
	
	public static String sGetNumber(String getDisplayedBalance)
	{
		getDisplayedBalance = getDisplayedBalance.trim();
		getDisplayedBalance = getDisplayedBalance.replaceAll("-", "");
		getDisplayedBalance = getDisplayedBalance.replaceAll(",", "");
		getDisplayedBalance = getDisplayedBalance.replaceAll(",", "");
		getDisplayedBalance = getDisplayedBalance.replaceAll(" ", "");
		getDisplayedBalance = getDisplayedBalance.replace(".", "");
		return getDisplayedBalance;
		
	}
	
	
	
	public void validateSpendAnalysisOverall(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Exception 
	{
		String table = "//div/div[2]/table";
		WebElement wTable = wdriver.findElement(By.xpath(table));
		int row = rowCount(table);
		int col = colCount(table);
		// Validate %
		String savingamt = getCellData(table, 2, 1, 2);
		
		
	}
	
	
	
	
	public void test1(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Exception 
	{
		ActionKeywords act= new ActionKeywords();
		//String w = driver.findElement(By.xpath("html/body/div[1]/section/div/div[2]/div/div[2]/div[1]/div/section/div[3]/div[5]/section/ui-view/div/div/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[2]/tr[1]/td[1]")).getText();
		act.rowCount("//table[@ng-show='displaySavings']");
		act.colCount("//table[@ng-show='displaySavings']");
		act.getCellData("//table[@ng-show='displaySavings']", 2, 2, 1);
	}
	

	public void offerAndDiscount(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Exception
	{
		String sProductxpath = "//div[1]/div/div[3]/slick/div/div/div";
		java.util.List<WebElement> product = wdriver.findElements(By.xpath(sProductxpath));
		for(int i=0; i<product.size(); i++)
		{
			String str1 = product.get(i).getAttribute("src");
		}
	}

	
	
	public void getSelectedOption(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Exception {
		boolean bFlag = false;
		try {
			Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			bFlag = false;
			java.util.List<WebElement> radio = driver.findElements(By.className(objectref));
			for (int i = 0; i <= radio.size() - 1; i++) {
				if (((radio.get(i).getAttribute("checked")).trim()).toLowerCase().equals("true")) {
					writeInExcel(radio.get(i).getAttribute("name"));
					bFlag = true;
				}
			}
		} catch (Throwable e) {
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, TestDesc, afileLocdir + "\\" + aTestStepID + ".png");
			Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			Log.info(TestDesc + "|" + objectref + "|" + inputparam);
		} finally {
			if (bFlag == false) {
				captureScreenShot(driver);
				reporter.onFailure(TestDesc, "Selected primary account has not found",
						afileLocdir + "\\" + aTestStepID + ".png");
			}
		}
	}

}
