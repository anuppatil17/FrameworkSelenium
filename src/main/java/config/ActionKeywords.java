package config;
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
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import bsh.ParseException;
import executionEngine.DriverScript;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;
import reporting.CReporter;
import utility.ExcelUtils;
import utility.Log;

/**
 * @author vikapale kapale
 *
 */
public class ActionKeywords {
	public static String ObjectText = null;
	public static AppiumDriver<WebElement> driver;
	public static WebDriver wdriver;
	public static WebDriverWait wait;
	public static Object object;
	public CReporter reporter;
	public String splatformName = "";
	public DriverScript driverscript;
	public GenericMethods genericmethods;
	public DesiredCapabilities capabilities = new DesiredCapabilities();
	public String browserName = "mobileOS";
	public DesiredCapabilities capabilities_cloud = new DesiredCapabilities(browserName, "", Platform.ANY);
	public String sException = "Exception";
	public String sExceptionMsg = "Exception Message";
	public String adeviceid, aosversion, aurl, adatasheetloc, strValues, aappname, aappbrowser, aappurl,
			ascreenshotsloc, aappType, aappPack, aappAct, aplatformName, abundleID, afileLocdir, aTestStepID, aplatform,
			auser, apassword;
	public String platformName = "";
	public static boolean bStopExecution = false;
	public static AppiumDriver driver1;
	public static WebDriver driver2;
	public static HashMap<String, String> hGlobalOR;
	public static FrameworkFunctions ff;
	public static HashMap<String, String> DInput;
	public static HashMap<String, String> DOutput = new HashMap<String, String>();
	// public static HashMap<String, String> DOutput1;
	// Collection Objects
	public ArrayList contexts = new ArrayList();
	static Hashtable<String, String> hTab = new Hashtable<String, String>();

	// ActionKeywords actionkeywords= new ActionKeywords();

	/**
	 * @author vikapale kapale
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
	 * @author vikapale kapale 'Description : None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
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
	 * @author vikapale kapale 'Description : This method would set File
	 * location and test step id 'InputParameters : byDefault 'OutPutParameters:
	 * None 'Author: Vikram Kapale. 'Date: 3-Dec-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void setMethod_Screencapture(String fileLocdir, String sTestStepID) throws Exception {
		afileLocdir = fileLocdir;
		aTestStepID = sTestStepID;
	}

	/**
	 * 
	 * @param reporter1
	 * @throws Exception
	 */
	/* For Reporting */
	public void setReporter(CReporter reporter1) throws Exception {
		reporter = reporter1;
	}

	public static void testing() throws Exception {
		System.out.println("test");

		Set<String> keys = hGlobalOR.keySet();
		for (String key : keys) {
			System.out.println(key);
		}

	}

	/**
	 * Default Constructor
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public ActionKeywords() {
		hGlobalOR = driverscript.hGlobalOR;
		ff = new FrameworkFunctions();
		DInput = genericmethods.hmap;
	}

	public static String ReadDictionary(String key) {
		String value = "";
		value = GenericMethods.hmap.get(key);
		return value;
	}

	public static void WriteDictionary(String HeaderName, String Value) {

		try {

			DOutput.put(HeaderName, Value);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * This method would set capabilities for Appium Run
	 * 
	 * @throws MalformedURLException
	 */

	/*
	 * @author vikapale kapale 'Description : This method would set the
	 * capabilities for Appium run 'InputParameters : byDefault
	 * 'OutPutParameters: None 'Author: 'Date: 'Status := Executed
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

		if (aplatform.equalsIgnoreCase("PERFECTO") && aappType.equalsIgnoreCase("WEB")) {
			capabilities_cloud.setCapability("deviceName", adeviceid);
			capabilities_cloud.setCapability("platformName", aplatformName);
			capabilities_cloud.setCapability("automationName", "Appium");
			capabilities_cloud.setCapability("platformVersion", aosversion);
		}

		else {
			capabilities.setCapability("deviceName", adeviceid);
			capabilities.setCapability("platformName", aplatformName);
			capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("platformVersion", aosversion);
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
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
	 * 12-Nov-2017 'Status := Executed
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
	 * @author vikapale kapale
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

	// ================================================================================================================

	/**
	 * @author vikapale kapale
	 */
	/*
	 * 'Description : This method would capture Screen Print 'InputParameters :
	 * byDefault 'OutPutParameters: None 'Author: Vikram Kapale. 'Date:
	 * 12-Nov-2017 'Status := Executed
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

	/*
	 * @author vikapale kapale 'Description : Capture ScreenPrint None 'Author:
	 * Vikram Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
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
		objectref = ff.OR(objectref);
		try {
			// Thread.sleep(1000);
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
			// Thread.sleep(2000);
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
	 * Lowercase 'InputParameters : byDefault 'OutPutParameters: None 'Author: *
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

	public void customSet(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {

		objectref = ff.OR(objectref);
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
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(webelement));
					// Thread.sleep(2000);
					webelement.sendKeys(inputparam);
					driverscript.bResult = true;
					// driver.hideKeyboard();
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
	 * 'Description : Wait None 'Author: Vikram Kapale. 'Date: Sept-2017 'Status
	 * := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void customWait(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Integer iWait = Integer.parseInt(inputparam);
		// Thread.sleep(iWait);
	}

	/*
	 * 'Description : Web : it would hide opened keyboard None 'Author: Vikram
	 * Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void hideKeboard(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		// Thread.sleep(2000);
		// ((AppiumDriver) driver).hideKeyboard();
		driver.hideKeyboard();
		// Thread.sleep(2000);
	}

	/*
	 * 'Description : Web : Wait for object None 'Author: Vikram Kapale. 'Date:
	 * Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public boolean waitForObject(String objectref, WebDriver driver) {
		// WebDriver driver = null;
		boolean oFlag = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
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

	/*
	 * 'Description : Mobile : Wait for object None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public boolean waitForObject(String objectref, AppiumDriver driver) {
		// WebDriver driver = null;
		boolean oFlag = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
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

	/*
	 * 'Description : Wait till object is enabled for click None 'Author: Vikram
	 * Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void waitForObjectVisibleAndClick(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		WebDriverWait objectEnabled = new WebDriverWait(driver, 30);

		WebElement element = driver.findElement(By.xpath(objectref));
		boolean bFlag = element.isEnabled();

	}

	/*
	 * 'Description : Wait None 'Author: Vikram Kapale. 'Date: Sept-2017 'Status
	 * := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void wait(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		long l = Long.parseLong(inputparam);
		l = l * 1000;
		Thread.sleep(l);
	}

	/*
	 * 'Description : Web : Validate object property text None 'Author: Vikram
	 * Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void verifyObjectPropText(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		boolean oElemFlag = waitForObject(objectref, driver);
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
			WebDriverWait wait = new WebDriverWait(driver, 30);
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

	public WebElement isObjectClickableBy(String objectref, String inputparam) {
		boolean oFlag = false;
		WebElement WebEl;
		WebEl = null;
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);

			switch (objectref) {
			case "xpath":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputparam)));
				WebEl = driver.findElement(By.xpath(inputparam));
				oFlag = true;
				break;
			case "name":
				wait.until(ExpectedConditions.elementToBeClickable(By.name(inputparam)));
				WebEl = driver.findElement(By.name(inputparam));
				oFlag = true;
				break;
			case "css":
				wait.until(ExpectedConditions.elementToBeClickable(By.name(inputparam)));
				WebEl = driver.findElement(By.cssSelector(inputparam));
				oFlag = true;
				break;
			}
			return WebEl;
		}

		catch (Exception e) {
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
		// boolean oFlag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
			WebDriverWait wait = new WebDriverWait(driver, 30);
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

	public void validation1(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {

		System.out.println(ReadDictionary("input"));
		System.out.println(ReadDictionary("input1"));
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
			String inputparam1) throws Throwable {
		// Thread.sleep(2000);
		if (driverscript.sDevice_ID_TestCase.contains("web")) {
			Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
			Log.info(TestDesc + "|" + objectref + "|" + inputparam);
			String sObjectref = null;
			String sInputparam = null;

			objectref = ff.OR(objectref);

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
					// Thread.sleep(2000);
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
					// Thread.sleep(2000);
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

	/*
	 * 'Description : Move Cursor None 'Author: Vikram Kapale. 'Date: Sept-2017
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
	public void moveCursorToObject(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		WebElement webelement = genericmethods.findElement(objectref, inputparam, wdriver);
		Actions act = new Actions(wdriver);
		act.moveToElement(webelement);
		act.click().build().perform();
		// Thread.sleep(2000);
		act.click();
		// Thread.sleep(3000);

	}

	/*
	 * 'Description : Mobile Tap(Click) None 'Author: Vikram Kapale. 'Date:
	 * Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
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

	/*
	 * 'Description : Validate Object properties None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
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
	////////////////////////
	public void clickFindElementByMoB(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		if (aplatformName.contains("Android"))

		{
			if(driver !=null){
			//	driver=(AppiumDriver<WebElement>) wdriver;
			wdriver=driver;
			
			}
			try {

				objectref = ff.OR(objectref);
				String[] aobjectref = objectref.split("\\|");
				objectref = aobjectref[0];
				inputparam = aobjectref[1];
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

			finally {

				ActionKeywords.handleLoader();
				if (inputparam1.length() != 0) {
					try {
						String[] aobjectref = inputparam1.split("\\|");
						String sby = aobjectref[0];
						String sproprty = aobjectref[1];
						wdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						WebElement webelement = genericmethods.findElement(sby, sproprty, wdriver);
						WebDriverWait wait = new WebDriverWait(wdriver, 120);
						wait.until(ExpectedConditions.elementToBeClickable(webelement));
					} catch (Exception e) {
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

	
	
	
	
	
//////////////////////////
	public void clickFindElementBy(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		if (driverscript.sDevice_ID_TestCase.contains("web"))

		{
			try {

				objectref = ff.OR(objectref);
				String[] aobjectref = objectref.split("\\|");
				objectref = aobjectref[0];
				inputparam = aobjectref[1];
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

			finally {

				ActionKeywords.handleLoader();
				if (inputparam1.length() != 0) {
					try {
						String[] aobjectref = inputparam1.split("\\|");
						String sby = aobjectref[0];
						String sproprty = aobjectref[1];
						wdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						WebElement webelement = genericmethods.findElement(sby, sproprty, wdriver);
						WebDriverWait wait = new WebDriverWait(wdriver, 120);
						wait.until(ExpectedConditions.elementToBeClickable(webelement));
					} catch (Exception e) {
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

	public void mouseclick(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {

		WebElement input = wdriver.findElement(By.xpath(objectref));
		new Actions(wdriver).moveToElement(input).click().perform();

		// Thread.sleep(1000);
	}

	/*
	 * 'Description : Validate if object exist None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void check_ObjExist(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {
			WebElement e1 = wdriver.findElement(By.xpath(objectref));
			boolean flag = e1.isDisplayed();
			if (flag) {
				driverscript.bResult = true;
				captureScreenShot(wdriver);
				reporter.onSuccessscreenshot(TestDesc, inputparam, afileLocdir + "\\" + aTestStepID + ".png");

			} else {
				driverscript.bResult = false;
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, inputparam1, afileLocdir + "\\" + aTestStepID + ".png");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Author:
	public void switchAndMaximize_window(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		String parentWindow = wdriver.getWindowHandle();
		Set<String> handles = wdriver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				wdriver.switchTo().window(windowHandle);
				wdriver.switchTo().window(windowHandle).manage().window().maximize();
				/*
				 * wdriver.close(); wdriver.switchTo().window(parentWindow);
				 */
			}
		}
	}

	// Author:
	public void radio_selectbyvalue(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {

		// input[@value='Postpaid']

		String xpth = "//input[@value='" + inputparam + "']";
		WebElement el = wdriver.findElement(By.xpath(xpth));
		if (el != null) {
			el.click();
		} else {
			System.out.println("Radio Button does not exist");
			driverscript.bResult = false;
			captureScreenShot(wdriver);
			reporter.onFailure(TestDesc, "Radio Button does not exist", afileLocdir + "\\" + aTestStepID + ".png");
		}

	}

	// Author:
	public void select_ByValue(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		wdriver.findElement(By.xpath(objectref)).click();
		Select comboBox = new Select(wdriver.findElement(By.xpath(objectref)));
		comboBox.selectByValue(inputparam);

	}

	public boolean launch_M(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		boolean flag = false;

		// --------------------Running this---------------------------

		if ((aappType.equalsIgnoreCase("NATIVE") || aappType.equalsIgnoreCase("HYBRID"))
				&& aplatform.equalsIgnoreCase("GRID") && aplatformName.equalsIgnoreCase("Android")) {
			try {
				// AppiumDriver driver = null;
				if (driver == null) {
					Log.info("Launch Mobile App");
					System.out.println("...................Launch Mobile App Event Started........");
					Log.error("Not able to launch app ");
					setupCapabilities();
					capabilities.setCapability("appPackage", aappPack);
					capabilities.setCapability("appActivity", aappAct);
					System.out.println("Into Device ID:" + adeviceid);

					// capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					// "uiautomator2");

					// driver.installApp("C://Users//IBM_ADMIN//Desktop//APK//22Feb.apk");
					driver = new AndroidDriver(new URL(aurl), capabilities);
					driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
					// Thread.sleep(2000);
					Set contextNames = ((AppiumDriver) driver).getContextHandles();
					Iterator iterator = contextNames.iterator();
					while (iterator.hasNext()) {
						String contextName = iterator.next().toString();
						contexts.add(contextName);
					}
					flag = true;
					// return true;
				} else {
					driver.resetApp();
					flag = true;
					// Thread.sleep(5000);
					try {
						WebElement wAllow = driver.findElement(By.name("Allow"));
						wAllow.click();
						// Thread.sleep(10000);
					} catch (Exception e) {
						System.out.println("Allow not displayed");
					}

				}
			} catch (Exception e) {
				return false;
			}

		}

		// driver = (AppiumDriver) driver1;
		try {
			// Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 1);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			WebElement wAllow = driver.findElement(By.name("Allow"));
			wAllow.click();
			// Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("Allow not displayed");
		}
		boolean oElemFlag = false;

		if (2 <= inputparam.length())

		{
			oElemFlag = waitForObject(inputparam, driver);

			if (oElemFlag == false) {
				System.out.println("Launch event exit...");
				System.exit(0);
			}

			if (flag == false) {
				Log.error("Not able to launch app ");
				DriverScript.bResult = false;
				// Thread.sleep(2000);
				// captureScreenShot(driver);
				reporter.onFailure(TestDesc, "is failed",
						"C://MobilePOC//Sayom'sVersion//Appium_ScriptLess_Framework//logos//Stop.png");
			} else if (flag == true) {
				captureScreenShot(driver);
				reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
				// Thread.sleep(6000);

			}
		}
		return oElemFlag;
	}

	/*
	 * 'Description : None 'Author: Vikram Kapale. 'Date: Sept-2017 'Status :=
	 * Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void changeValue(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable

	{
		String alphabet = "abcdefhigjklmnopqrstuvwxyz";
		String s = RandomStringUtils.random(8, alphabet);
		WebElement webelement = wdriver.findElement(By.xpath(objectref));
		webelement.clear();
		// Thread.sleep(1000);
		webelement.sendKeys(s);
		// Thread.sleep(1000);

	}

	/*
	 * 'Description : None 'Author: Vikram Kapale. 'Date: Sept-2017 'Status :=
	 * Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void scrollIntoView(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws InterruptedException {

		WebElement element = wdriver.findElement(By.xpath("//li[contains(.,'final')]"));
		((JavascriptExecutor) wdriver).executeScript("arguments[0].scrollIntoView(true);", element);

		// Thread.sleep(500);

	}

	public void getWebText(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
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
			// ((AndroidDriver) driver).scrollTo(str1);
			Actions actions = new Actions(((AppiumDriver) driver));
			actions.moveToElement(element);
			// actions.click();
			actions.perform();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 'Description : Clear values from textbox None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void clearTextboxValue(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1)

	{
		try {

			WebElement element = genericmethods.findElement(objectref, inputparam, driver);
			element.sendKeys("test");
			// Thread.sleep(2000);
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
			// Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}
	}

	/*
	 * 'Description : Validate object Text None 'Author: Vikram Kapale. 'Date:
	 * Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
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

		catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
			// Thread.sleep(2000);
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

	public void isObjectExist(String objectref, WebDriver driver) throws Throwable {
		Log.info("IsObjectExist Method started");
		Log.info(objectref);
		boolean oElemFlag = waitForObject(objectref, driver);
		if (oElemFlag == false) {
			captureScreenShot(driver);
			reporter.onFailure("Validation", objectref + "" + " : Passed", afileLocdir + "\\" + aTestStepID + ".png");
		} else {
			captureScreenShot(driver);
			reporter.onSuccessscreenshot("Validation", objectref + "" + " : Failed",
					afileLocdir + "\\" + aTestStepID + ".png");
		}
		Log.info("IsObjectExist Method Ended");
	}

	/*
	 * 'Description : Capture values in Screen None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
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

	/*
	 * 'Description : Get object text None 'Author: Vikram Kapale. 'Date:
	 * Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
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

	// ---------------------------------------------------------------------------------------------------------------------------

	/*
	 * 'Description : Clear text box value None 'Author: Vikram Kapale. 'Date:
	 * Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void clearTextboxValueWeb(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1)

	{
		try {

			WebElement element = genericmethods.findElement(objectref, inputparam, wdriver);

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

	public void reLaunch(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) {
		try {
			driver.resetApp();
			// Thread.sleep(5000);
			try {
				WebElement wAllow = driver.findElement(By.name("Allow"));

				wAllow.click();
			} catch (Exception e) {
				System.out.println("error");
			}
		} catch (Exception e) {
			System.out.println("Unable to close the application");
		}
	}

	/*
	 * 'Description : Close Webdriver instance None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void close(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws InterruptedException {

		int i = 10;

		try {

			wdriver.manage().deleteAllCookies();
			wdriver.close();
			wdriver.quit();
			System.out.println("Last");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	public void closeAll(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		int i = 10;
		wdriver.manage().deleteAllCookies();
		wdriver.close();
		wdriver.quit();
		// System.out.println("Last");
	}

	public void close() {
		wdriver.manage().deleteAllCookies();
		wdriver.close();
		wdriver.quit();

	}

	public void selectFromHamMenu(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) {
		((AppiumDriver) driver).closeApp();
	}

	/*
	 * 'Description : Get uniq Mobile Number None 'Author: Vikram Kapale. 'Date:
	 * Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void uniqueMobileNumber(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		WebElement mobile;
		Random rand = new Random();
		int num1, num2, num3;
		num1 = rand.nextInt(90) + 10;
		num2 = rand.nextInt(643) + 100;
		num3 = rand.nextInt(9000) + 1000;
		String mobileNumber = "9" + Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num3);
		// System.out.println(mobileNumber);
		wdriver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys(mobileNumber);
		// Thread.sleep(1000);
		wdriver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		wdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(wdriver, 2);
		try {
			for (int i = 0; i < 10; i++) {
				try {
					mobile = wdriver.findElement(By.xpath("//button[contains(.,'OK')]"));
				} catch (Exception e) {
					return;
				}
				mobile.click();
				// Random rand = new Random();
				// int num1, num2, num3;
				num1 = rand.nextInt(900) + 100;
				num2 = rand.nextInt(643) + 100;
				num3 = rand.nextInt(9000) + 1000;
				mobileNumber = Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num3);
				// System.out.println(mobileNumber);
				wdriver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys(mobileNumber);
				// Thread.sleep(1000);
				wdriver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
				wdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				// WebDriverWait wait = new WebDriverWait(wdriver, 2);
				try {
					mobile = wdriver.findElement(By.xpath("//button[contains(.,'OK')]"));
				} catch (Exception e) {
					return;
				}

			}
		} catch (Exception e) {
			return;
		}
	}

	public void navigate(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		wdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objectref = objectref.toLowerCase();
		switch (objectref) {

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

	/*
	 * 'Description : validate all links displayed on page None 'Author: Vikram
	 * Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
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

					if (FundTransferOption != null && FundTransferOption.isDisplayed()) {
						sDisplayedOptions.append(sOptionVal);
						sDisplayedOptions.append("|");
						strValues = sDisplayedOptions.toString();
					}

					else {
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
				// Thread.sleep(2000);
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
			}
		}
	}

	/*
	 * 'Description : Validate displayed objects on the Page None 'Author:
	 * Vikram Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void validateAllObjects(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {

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

					if (FundTransferOption != null && FundTransferOption.isDisplayed()) {
						sDisplayedOptions.append(sOptionVal);
						sDisplayedOptions.append("|");
						strValues = sDisplayedOptions.toString();
					}

					else {
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
				// Thread.sleep(2000);
				captureScreenShot(wdriver);
				reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
			}
		}
	}

	public void validateTextOnWebPage(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {

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

					if (FundTransferOption != null && FundTransferOption.isDisplayed()) {
						sDisplayedOptions.append(sOptionVal);
						sDisplayedOptions.append("|");
						strValues = sDisplayedOptions.toString();
					}

					else {
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
				// Thread.sleep(2000);
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
			// Thread.sleep(2000);
			captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is Failed", afileLocdir + "\\" + aTestStepID + ".png");
		}

	}

	public void pageLoad(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		wdriver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

	}

	public void scrollToText(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");

		boolean flag = false;
		if (String.valueOf(driverscript.sDevice_ID_TestCase).contains("web")) {
			WebElement webelement = genericmethods.findElement(objectref, inputparam, wdriver);
			Actions actions = new Actions(wdriver);
			actions.moveToElement(webelement);
			actions.perform();
		}

		else {
			try {
				((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
								+ objectref + "\").instance(0))");

			} catch (Exception e) {
				Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ "**********");
				Log.error("Exception message : " + e.getMessage());
			}
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		// Thread.sleep(5000);
	}

	public void selectValueFromDropdown(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		Select comboBox = new Select(wdriver.findElement(By.xpath(objectref)));
		comboBox.selectByVisibleText(inputparam);
	}

	public void mobileScroll1(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {
			Object WebDriverWait;
			{
				WebDriverWait wait = new WebDriverWait(driver, 30);
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement webelement = genericmethods.findElement(objectref, inputparam, driver);
			org.openqa.selenium.Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			driver.swipe(0, scrollStart, 0, scrollEnd, 2000);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void mobileScroll(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		// driver.findElement(ByAndroidUIAutomator)
		String APP_SCROLLVIEW = "android.widget.ScrollView";
		String DESTINATION_ELEMENT_TEXT = "Contact Details";
		((AndroidDriver) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(APP_SCROLLVIEW)).scrollIntoView(new UiSelector().text(DESTINATION_ELEMENT_TEXT))");
	}

	/*
	 * 'Description : Click on X and Y Co-ordinates None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
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

	/*
	 * 'Description : Write value/s in excel File None 'Author: Vikram Kapale.
	 * 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public void writeInExcel(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		String[] aobjectref = objectref.split("\\|");
		WebElement element = genericmethods.findElement(aobjectref[0], aobjectref[1], driver);
		String value = element.getAttribute("name");
		ExcelUtils.setCellData(value, driverscript.iTestStep, Constants.Col_InputParams, Constants.Sheet_TestSteps,
				adatasheetloc);
	}

	/*
	 * 'Description : Write in Excel None 'Author: Vikram Kapale. 'Date:
	 * Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void writeInExcel(String value) throws Throwable {

		ExcelUtils.setCellData(value, driverscript.iTestStep, Constants.Col_InputParams, driverscript.sTestCaseID1,
				adatasheetloc);

	}

	public void testing(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		System.out.println("hello world!!");
	}

	public void launchWebPar(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {

		// splatformName = driverscript.ssplatform;
		String platformName = driverscript.ssplatform;
		if (platformName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverscript.projectpath + "//tools//chromedriver.exe");
			wdriver = new ChromeDriver();
			wdriver.get("http://newtours.demoaut.com/");
		} else if (platformName.equalsIgnoreCase("ie")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			System.setProperty("webdriver.ie.driver", driverscript.projectpath + "//tools//IEDriverServer.exe");
			wdriver = new InternetExplorerDriver(capabilities);
			wdriver.get("http://newtours.demoaut.com/");
		}
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
			String inputparam1) throws Throwable {
		boolean flag = false;

		// String a= ReadDictionary("test");
		WriteDictionary("output", "$1000");
		WriteDictionary("output1", "$21000");

		if (String.valueOf(driverscript.sDevice_ID_TestCase).contains("web")) {
			if (String.valueOf(driverscript.sDevice_ID_TestCase).contains(aplatformName)) {

				try {
					String[] aobjectref = driverscript.sDevice_ID_TestCase.split("\\|");
					String sType = aobjectref[0];
					String sBrowser = aobjectref[1];
					wdriver = ExecutionDriver.getInstanceWeb(aobjectref[1], objectref);
					
					flag = true;
					if (inputparam.length() > 2) {
						boolean oElemFlag = waitForObject(inputparam, wdriver);
						if (oElemFlag == false) {
							Log.error("Not able to launch app ");
							DriverScript.bResult = false;
							// Thread.sleep(2000);
							captureScreenShot(wdriver);
							reporter.onFailure(TestDesc, "is failed", afileLocdir + "\\" + aTestStepID + ".png");
							System.out.println("Launch event exit...");
							// return oElemFlag;
						} else {
							captureScreenShot(wdriver);
							reporter.onSuccessscreenshot(TestDesc, "is successful",
									afileLocdir + "\\" + aTestStepID + ".png");
							// Thread.sleep(6000);

						}
					} else {
						boolean oElemFlag = true;
					}
				} catch (Exception e) {
					WebDriver driver = null;
					driverscript.bResult = false;
					captureScreenShot(driver);
					reporter.onFailure("Error message", "Error message has been displayed",
							afileLocdir + "\\" + aTestStepID + ".png");
				}
			}
		}

	}
	///////////// ********************************MOBILE Browser/
	///////////// ANUP///////////////

	public boolean launchMobWeb(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		boolean flag = false;

		boolean oElemFlag;

		// --------------------Running this---------------------------

		if ((aappbrowser.equalsIgnoreCase("Chrome") || aappType.equalsIgnoreCase("NATIVE")
				|| aappType.equalsIgnoreCase("HYBRID")) && aplatform.equalsIgnoreCase("GRID")
				&& aplatformName.equalsIgnoreCase("Android")) {

			try {
				// AppiumDriver driver = null;
				if (driver == null) {
					Log.info("Launch Mobile App");
					System.out.println("...................Launch Mobile App Event Started........");

					DesiredCapabilities capabilities = DesiredCapabilities.android();

					// set the capability to execute test in chrome browser
					capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

					// set the capability to execute our test in Android
					// Platform
					capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

					// we need to define platform name
					capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, aplatformName);

					// Set the device name as well (you can give any name)
					capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, adeviceid);

					// set the android version as well
					capabilities.setCapability(MobileCapabilityType.VERSION, aosversion);

					// Create object of URL class and specify the appium server
					// address

					////
					/*
					 * setupCapabilities();
					 * capabilities.setCapability("appPackage", aappPack);
					 * capabilities.setCapability("appActivity", aappAct)
					 */;
					System.out.println("Into Device ID:" + adeviceid);

					// capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					// "uiautomator2");

					// driver.installApp("C://Users//IBM_ADMIN//Desktop//APK//22Feb.apk");
					driver = new AndroidDriver(new URL(aurl), capabilities);

					driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
					// Thread.sleep(2000);

					driver.get(objectref);

					flag = true;
				}
			} catch (Exception e) {
				oElemFlag = false;
				return false;

			}

		}

		// driver = (AppiumDriver) driver1;

		if (2 <= inputparam.length())

		{
			oElemFlag = waitForObject(inputparam, driver);

			if (oElemFlag == false) {
				System.out.println("Launch event exit...");
				System.exit(0);
			}
		} else {
			oElemFlag = true;
		}

		if (flag == false) {
			Log.error("Not able to launch app ");
			DriverScript.bResult = false;
			// Thread.sleep(2000);
			// captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is failed",
					"C://MobilePOC//Sayom'sVersion//Appium_ScriptLess_Framework//logos//Stop.png");
		} else if (flag == true) {
			oElemFlag = true;

			captureScreenShot(driver);
			reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
			// Thread.sleep(6000);

		}

		return oElemFlag;

	}
	/////////////////////////////////////////////////////

	public void launchWeb1(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		// String a= ReadDictionary("test");
		WriteDictionary("price", "$1000");
	}

	public static void handleLoader() throws InterruptedException {
		// Thread.sleep(2000);
		for (int i = 0; i <= 60; i++) {
			try {
				WebDriverWait wait = new WebDriverWait(wdriver, 1);
				wdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				WebElement w1 = wdriver.findElement(By.xpath("//div[(@class='loader')]"));
				if (w1.isDisplayed() == false) {
					return;
				}
				boolean bFlag = false;
				// Thread.sleep(5000);
			} catch (Exception e) {
				return;
			}

		}

	}

	public boolean launchMobApp(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		boolean flag = false;
		boolean oElemFlag = false;
		// --------------------Running this---------------------------

		if ((aappType.equalsIgnoreCase("NATIVE") || aappType.equalsIgnoreCase("HYBRID"))
				&& aplatform.equalsIgnoreCase("GRID") && aplatformName.equalsIgnoreCase("Android")) {
			try {
				// AppiumDriver driver = null;
				if (driver == null) {
					Log.info("Launch Mobile App");
					System.out.println("...................Launch Mobile App Event Started........");

					setupCapabilities();

					///////////////////////////
					File app = new File(objectref);
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
					capabilities.setCapability("deviceName", "Samsung");
					capabilities.setCapability("udid", "SOT8BQCESCPRE6IF");

					// logger.log(LogStatus.INFO, "Device UDID:-->"+UDID);

					// capabilities.setCapability("platformVersion",
					// platformVersion_);
					capabilities.setCapability("platformName", "Android");
					capabilities.setCapability("app", app.getAbsolutePath());
					capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
					capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
					AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(
							new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

					driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
					// Thread.sleep(2000);
					Set contextNames = ((AppiumDriver) driver).getContextHandles();
					Iterator iterator = contextNames.iterator();
					while (iterator.hasNext()) {
						String contextName = iterator.next().toString();
						contexts.add(contextName);
					}

					flag = true;
					// return true;
				} else {
					System.out.println("else");
					driver.resetApp();
					flag = true;
					// Thread.sleep(5000);
					try {
						WebElement wAllow = driver.findElement(By.name("Allow"));
						wAllow.click();
						// Thread.sleep(10000);
					} catch (Exception e) {
						System.out.println("Allow not displayed");
					}

				}
			} catch (Exception e) {
				return false;
			}

		}

		if (2 <= inputparam.length())

		{
			oElemFlag = waitForObject(inputparam, driver);

			if (oElemFlag == false) {
				System.out.println("Launch event exit...");
				System.exit(0);
			}
		} else {
			oElemFlag = true;
		}

		if (flag == false) {
			Log.error("Not able to launch app ");
			DriverScript.bResult = false;
			// Thread.sleep(2000);
			// captureScreenShot(driver);
			reporter.onFailure(TestDesc, "is failed",
					"C://MobilePOC//Sayom'sVersion//Appium_ScriptLess_Framework//logos//Stop.png");
		} else if (flag == true) {
			captureScreenShot(driver);
			reporter.onSuccessscreenshot(TestDesc, "is successful", afileLocdir + "\\" + aTestStepID + ".png");
			// Thread.sleep(6000);

		}

		System.out.println(flag);

		if (flag == true) {
			oElemFlag = true;
		}

		System.out.println("Flag Launch-" + oElemFlag);
		return oElemFlag;

	}

	@Test
	public void test(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		try {
			WebDriver driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.co.in/?gfe_rd=cr&ei=qpjbWOTWMevI8AeagIGYCQ");
		} catch (Exception e) {
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

	public void validateError(String TestDesc, String objectref, String inputparam, String objectType, boolean bResult,
			String inputparam1) throws Throwable {
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		Log.info(TestDesc + "|" + objectref + "|" + inputparam);

		WebDriverWait wait = new WebDriverWait(driver, 1);
		WebElement webelement = genericmethods.findElement("name", "Error", driver);

		if (webelement == null) {
			driverscript.bResult = true;
			captureScreenShot(driver);
			reporter.onSuccessscreenshot("Error message", "Error message has not been displayed",
					afileLocdir + "\\" + aTestStepID + ".png");
		} else {
			driverscript.bResult = false;
			captureScreenShot(driver);
			reporter.onFailure("Error message", "Error message has been displayed",
					afileLocdir + "\\" + aTestStepID + ".png");
		}

		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
	}

	public boolean validateRunTimeError() throws Throwable {
		if (driverscript.sDevice_ID_TestCase.contains("web")) {
			bStopExecution = false;
			Log.info("Started : **********" + "Runtime error validation" + "**********");
			WebElement webelement = null;
			WebDriverWait wait = new WebDriverWait(wdriver, 1);
			wdriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			try {
				webelement = wdriver.findElement(By.name("Error"));
			} catch (Exception e) {
				webelement = null;
			}

			if (webelement == null) {
				driverscript.bResult = true;
				return false;
			} else {
				bStopExecution = true;
				driverscript.bResult = false;
				captureScreenShot(wdriver);
				reporter.onFailure("Error message", "Error message has been displayed",
						afileLocdir + "\\" + aTestStepID + ".png");
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
			try {
				webelement = driver.findElement(By.name("Error"));
			} catch (Exception e) {
				webelement = null;
			}

			if (webelement == null) {
				driverscript.bResult = true;
				return false;
			} else {
				bStopExecution = true;
				driverscript.bResult = false;
				captureScreenShot(driver);
				reporter.onFailure("Error message", "Error message has been displayed",
						afileLocdir + "\\" + aTestStepID + ".png");
				return true;
			}
		}
	}

	public static int rowCount(String tablexpath) throws Exception {
		int rowCount;
		rowCount = 0;
		String sXpath = tablexpath + "/tbody/tr";
		try {
			rowCount = wdriver.findElements(By.xpath(sXpath)).size();
		} catch (Exception e) {
			e.getMessage();
		}
		return rowCount;
	}

	public static int colCount(String tablexpath) throws Exception {
		int colCount;
		colCount = 0;
		String sXpath = tablexpath + "/tbody/tr[1]/td";
		colCount = wdriver.findElements(By.xpath(sXpath)).size();
		return colCount;
	}

	public static boolean waitTillTableData(String tablexpath) throws Exception {
		boolean data = false;
		for (int iwait = 0; iwait < 20; iwait++) {
			int row = rowCount(tablexpath);
			if (1 < row) {
				data = true;
				break;
			} else {
				// Thread.sleep(5000);
			}
		}
		return data;
	}

	public static String getCellData(String tablexpath, int tbody, int row, int col) throws Exception {
		String data = "";
		String first_part = tablexpath + "/tbody[" + tbody + "]/tr[";
		String second_part = "]/td[";
		String third_part = "]";
		String final_xpath = first_part + row + second_part + col + third_part;
		try {
			data = wdriver.findElement(By.xpath(final_xpath)).getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public static BigDecimal currency(String savingamt) {
		// Object currencyVal;
		// BigDecimal currencyVal = null;
		try {
			BigDecimal currencyVal = new BigDecimal(savingamt);

			return currencyVal;
		} catch (Exception e) {
			Object currencyVal = null;
			System.out.println(e.getMessage());
			return (BigDecimal) currencyVal;
		}
		// return currencyVal;
	}

	public static String sGetNumber(String getDisplayedBalance) {
		getDisplayedBalance = getDisplayedBalance.trim();
		getDisplayedBalance = getDisplayedBalance.replaceAll("-", "");
		getDisplayedBalance = getDisplayedBalance.replaceAll(",", "");
		getDisplayedBalance = getDisplayedBalance.replaceAll(",", "");
		getDisplayedBalance = getDisplayedBalance.replaceAll(" ", "");
		getDisplayedBalance = getDisplayedBalance.replace(".", "");
		return getDisplayedBalance;

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

	
	
	public void hybridFramework(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {
		
		boolean oElemFlag = false;
		try{
			
			
			String[] aobjectref = driverscript.sDevice_ID_TestCase.split("\\|");
			String sType = aobjectref[0];
			String sBrowser = aobjectref[1];
			String sTestcaseID = null;
			System.out.println(DriverScript.sTestCaseID1);
			wdriver = ExecutionDriver.getInstanceWeb(sBrowser, objectref);
			
			//	wdriver.manage().window().maximize();
				Thread.sleep(2000);
				
				int lastcol=ExcelUtils.getColCount(DriverScript.sTestCaseID1,1);
				for(int i=9;i<lastcol-1;i++){			
					String Header =ExcelUtils.getCellData(0,i,DriverScript.sTestCaseID1);
					String Value =ExcelUtils.getCellData(1,i,DriverScript.sTestCaseID1);
					String action[]=Value.split(":");
					String act=action[0];
					String val=action[1];
					switch (act.toLowerCase()) {
					case "enter":
						try{
						ORobj(Header).sendKeys(val);
						oElemFlag=true;
						}catch (Exception e) {
						
							System.out.println("issue-"+e);
							// TODO: handle exception
						}
						break;
					
					case "click":
						
						try{
							ORobj(Header).click();	
							oElemFlag=true;
						}catch (Exception e) {
						
							System.out.println("issue-"+e);// TODO: handle exception
						}
						
					
					
					break;
					
					}
					
					
				
				
				}
			
					if (oElemFlag == false) {
						Log.error("Not able to launch app ");
						DriverScript.bResult = false;
						// Thread.sleep(2000);
						captureScreenShot(wdriver);
						reporter.onFailure(TestDesc, "is failed", afileLocdir + "\\" + aTestStepID + ".png");
						System.out.println("Launch event exit...");
						// return oElemFlag;
					} else {
						captureScreenShot(wdriver);
						reporter.onSuccessscreenshot(TestDesc, "is successful",
								afileLocdir + "\\" + aTestStepID + ".png");
						// Thread.sleep(6000);

					}
				
			
		}catch (Exception e) {
			WebDriver driver = null;
			driverscript.bResult = false;
			captureScreenShot(driver);
			reporter.onFailure("Error message", "Error message has been displayed",
					afileLocdir + "\\" + aTestStepID + ".png");
						
		}
		
		
		
		
	
		
		
		
	}

	public WebElement ORobj(String objectref) throws Throwable {
		WebElement webelement = null;
		objectref = ff.OR(objectref);
		String[] aobjectref = objectref.split("\\|");
		String sby = aobjectref[0];
		String sproprty = aobjectref[1];

		webelement = genericmethods.findElement(sby, sproprty, wdriver);
		return webelement;
	}

	public WebElement MORobj(String objectref) throws Throwable {
		WebElement webelement = null;
		String[] aobjectref = objectref.split("\\|");
		String sby = aobjectref[0];
		String sproprty = aobjectref[1];

		webelement = genericmethods.findElement(sby, sproprty, driver);
		return webelement;
	}

	/*
	 * 'Description : Mobile - Scroll vertical and Type None 'Author: Vikram
	 * Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void verticalScrollAndType(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {

		for (int i = 0; i <= 100; i++) {
			WebElement display = null;
			String value = null;
			String property = null;
			display = genericmethods.findElement("xpath",
					"//android.widget.EditText[contains(@text,'What are you saving for? ')]", driver, 1);
			display.click();
			display.sendKeys("test");
			if (display.getAttribute("focused") == "true") {
				WebElement setObject = genericmethods.findElement("xpath",
						"//android.widget.EditText[contains(@text,'What are you saving for? ')]", driver, 1);
				setObject.sendKeys("test");
				return;
			} else {
				org.openqa.selenium.Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int x = width / 2;
				int starty = (int) (height * 0.70);
				int endy = (int) (height * 0.30);
				driver.swipe(x, starty, x, endy, 500);
			}

		}

	}

	/*
	 * 'Description : Mobile Vertical Scroll and Click None 'Author: Vikram
	 * Kapale. 'Date: Sept-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */
	public void verticalScrollAndClick(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {

		for (int i = 0; i <= 100; i++) {

			WebElement display = null;
			String value = null;
			String property = null;

			display = genericmethods.findElement("xpath", objectref, driver, 1);
			display.click();

			try {
				boolean bFlag = (boolean) genericmethods.findElement("xpath", inputparam, driver, 1).isDisplayed();
				if (bFlag == true) {
					return;
				}
			} catch (Exception e) {

			}
			org.openqa.selenium.Dimension dim = driver.manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			int x = width / 2;
			int starty = (int) (height * 0.70);
			int endy = (int) (height * 0.30);
			driver.swipe(x, starty, x, endy, 500);
		}

	}

	public void horizontalScrollPAL(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {

		// Thread.sleep(5000);

		try {
			String element = wdriver.findElement(By.xpath("//div[2]/div/div[1]/form[1]/div/span")).getText();
			int element_int = 0;
			System.out.println(element);
			if (element != "" || element != null) {
				element_int = Integer.parseInt(element.replace("", "").trim());
			}
			for (int i = element_int; i < 75000; i++) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");

				// Thread.sleep(2000);
			}
		} catch (Exception e) {

			System.out.println(e);
		}

	}

	/**
	 * @param TestDesc
	 * @param objectref
	 * @param inputparam
	 * @param objectType
	 * @param bResult
	 * @param inputparam1
	 * @throws Throwable
	 */
	public void scrollToText_web(String TestDesc, String objectref, String inputparam, String objectType,
			boolean bResult, String inputparam1) throws Throwable {

		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");

		// Thread.sleep(3000);

		try {
			WebElement webelement = wdriver.findElement(By.xpath(objectref));
			((JavascriptExecutor) wdriver).executeScript("arguments[0].scrollIntoView(true);", webelement);
		}

		catch (Exception e) {

			System.out.println(e);

		}
		// Thread.sleep(1000);
	}

}
