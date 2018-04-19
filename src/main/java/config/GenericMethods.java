package config;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionEngine.DriverScript;
import io.appium.java_client.AppiumDriver;
import utility.ExcelUtils;
import utility.Log;

public class GenericMethods



{
	public static RemoteWebDriver driver;
	public static ActionKeywords actionkeywords;
	public static FrameworkFunctions ff;
	public static HashMap<String, String> hmap = new HashMap<String, String>();
	public static HashMap<String, String> hmapOut;
	
	
	public GenericMethods() {
		ff = new FrameworkFunctions();
	}

	/*
	 * 'Description : This method would find the element 'InputParameters :
	 * Object Locator and Object Property 'OutPutParameters: WebElement 'Author:
	 * Vikram Kapale. 'Date: 9-January-2017 'Status := Executed
	 * '************************************************************************
	 * ************************** ' C H A N G E H I S T O R Y
	 * '************************************************************************
	 * ************************** ' Date Change made by Purpose of change
	 * '-------- -------------------
	 * ------------------------------------------------- '
	 * '************************************************************************
	 * **************************
	 */

	public static WebElement findElement(String objectLocator, String Prop, RemoteWebDriver _driver) throws Throwable {

		driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		// driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		try {
			switch (objectLocator) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(Prop)));
				Element1 = driver.findElement(By.id(Prop));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.className(Prop)));
				Element1 = driver.findElement(By.className(Prop));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				// driver.findElement(By.name(Prop)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "tagname":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.tagName(Prop)));
				Element1 = driver.findElement(By.tagName(Prop));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Prop)));
				Element1 = driver.findElement(By.cssSelector(Prop));
				break;
			case "linktext":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Prop)));
				Element1 = driver.findElement(By.linkText(Prop));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop)));
				Element1 = driver.findElement(By.xpath(Prop));
				break;
			case "text":
				String sElement = "//*[contains(text(), '" + Prop + "')]";
				Element1 = driver.findElement(By.xpath(sElement));
				break;
			case "accessibilityid":
				break;
			case "nameA":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			}
		} catch (Exception e) {
			System.out.println("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.error("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception message : " + e.getMessage());
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		return Element1;
	}

	/**
	 * @param objectLocator
	 * @param Prop
	 * @param driver
	 * @return
	 * @throws Throwable
	 * 
	 *             Author : Vikram Kapale Date : Dec 2017 This method would find
	 *             element with different parameters
	 * 
	 */
	public static WebElement findElement(String objectLocator, String Prop, WebDriver driver) throws Throwable {
		// WebDriver wdriver;
		// driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			switch (objectLocator) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(Prop)));
				Element1 = driver.findElement(By.id(Prop));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.className(Prop)));
				Element1 = driver.findElement(By.className(Prop));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				// driver.findElement(By.name(Prop)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "tagname":
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Prop)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.tagName(Prop)));
				Element1 = driver.findElement(By.tagName(Prop));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Prop)));
				Element1 = driver.findElement(By.cssSelector(Prop));
				break;
			case "linktext":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Prop)));
				Element1 = driver.findElement(By.linkText(Prop));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop)));
				Element1 = driver.findElement(By.xpath(Prop));
				break;
			case "text":
				String sElement = "//*[contains(text(), '" + Prop + "')]";
				Element1 = driver.findElement(By.xpath(sElement));
				break;
			case "accessibilityid":
				break;
			case "nameA":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "nameB":
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;

			}
		} catch (Exception e) {
			System.out.println("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.error("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception message : " + e.getMessage());
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		return Element1;
	}

	
	public static boolean findElement(String objectref, WebDriver driver) throws Throwable {

		boolean bFlag = false;
		objectref = ff.OR(objectref);
		String[] aobjectref = objectref.split("\\|");
		 objectref = aobjectref[0];
		 String Prop = aobjectref[1];
		
		
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;

		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			switch (objectref) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(Prop)));
				Element1 = driver.findElement(By.id(Prop));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.className(Prop)));
				Element1 = driver.findElement(By.className(Prop));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				// driver.findElement(By.name(Prop)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "tagname":
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Prop)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.tagName(Prop)));
				Element1 = driver.findElement(By.tagName(Prop));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Prop)));
				Element1 = driver.findElement(By.cssSelector(Prop));
				break;
			case "linktext":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Prop)));
				Element1 = driver.findElement(By.linkText(Prop));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop)));
				Element1 = driver.findElement(By.xpath(Prop));
				break;
			case "text":
				String sElement = "//*[contains(text(), '" + Prop + "')]";
				Element1 = driver.findElement(By.xpath(sElement));
				break;
			case "accessibilityid":
				break;
			case "nameA":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "nameB":
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;

			}
		} catch (Exception e) {
			System.out.println("Object not found : " + objectref + Prop + e.getMessage());
			Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.error("Object not found : " + objectref + Prop + e.getMessage());
			Log.error("Exception message : " + e.getMessage());
		}
		
		finally {
			if (Element1!=null)
			{
				bFlag = true;
			}
			
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		return bFlag;
	}

	
	public static WebElement findElement(String objectLocator, String Prop, AppiumDriver<WebElement> driver) throws Throwable {

		// driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		// driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		try {
			switch (objectLocator) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(Prop)));
				Element1 = driver.findElement(By.id(Prop));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.className(Prop)));
				Element1 = driver.findElement(By.className(Prop));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				// driver.findElement(By.name(Prop)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "tagname":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.tagName(Prop)));
				Element1 = driver.findElement(By.tagName(Prop));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Prop)));
				Element1 = driver.findElement(By.cssSelector(Prop));
				break;
			case "linktext":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Prop)));
				Element1 = driver.findElement(By.linkText(Prop));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop)));
				Element1 = driver.findElement(By.xpath(Prop));
				break;
			case "text":
				String sElement = "//*[contains(text(), '" + Prop + "')]";
				Element1 = driver.findElement(By.xpath(sElement));
				break;
			case "accessibilityid":

				break;

			case "nameA":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;

			case "nameB":
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;

			}
		} catch (Exception e) {
			System.out.println("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.error("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception message : " + e.getMessage());
		}
		Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		return Element1;
	}

	
	public static void hmapInputHeaders(XSSFWorkbook ExcelWBook) throws Exception
	{
		int iLastCol = ExcelUtils.getColCount(DriverScript.sTestCaseID1, DriverScript.iTestStep);
		
		for(int iExcelVal=1; iExcelVal < iLastCol; iExcelVal++)
		{
			String sKey =  ExcelUtils.getCellData(DriverScript.iTestStep-1, iExcelVal,Constants.Sheet_TestSteps);
			String sVal =  ExcelUtils.getCellData(DriverScript.iTestStep, iExcelVal,Constants.Sheet_TestSteps);
			
			hmap.put(sKey, sVal);
		}
	}
	
	
	public static void hmapOutputHeaders(XSSFWorkbook ExcelWBook, String DataSheetLocation, HashMap<String, String> DOutput) throws Exception
	{
		try {
			if (false == DOutput.isEmpty()) {
				int iLastCol = ExcelUtils.getColCount(DriverScript.sTestCaseID1, DriverScript.iTestStep - 1);
				Set<String> keys = DOutput.keySet();
				for (String key : keys) {

					for (int iExcelVal = 1; iExcelVal < iLastCol; iExcelVal++) {
						String sKey = ExcelUtils.getCellData(DriverScript.iTestStep - 1, iExcelVal,
								Constants.Sheet_TestSteps);

						if (sKey.contains(key)) {
							ExcelUtils.setCellData(DOutput.get(sKey), DriverScript.iTestStep, iExcelVal,
									Constants.Sheet_TestSteps, DataSheetLocation);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static WebElement findElement(String objectLocator, String Prop, AppiumDriver driver, int waitTime)
			throws Throwable {
		// driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		// driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		try {
			switch (objectLocator) {
			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.id(Prop)));
				Element1 = driver.findElement(By.id(Prop));
				break;
			case "class":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.className(Prop)));
				Element1 = driver.findElement(By.className(Prop));
				break;
			case "name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				// driver.findElement(By.name(Prop)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "tagname":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.tagName(Prop)));
				Element1 = driver.findElement(By.tagName(Prop));
				break;
			case "css":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Prop)));
				Element1 = driver.findElement(By.cssSelector(Prop));
				break;
			case "linktext":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Prop)));
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(Prop)));
				Element1 = driver.findElement(By.linkText(Prop));
				break;
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop)));
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop)));
				Element1 = driver.findElement(By.xpath(Prop));
				break;
			case "text":
				String sElement = "//*[contains(text(), '" + Prop + "')]";
				Element1 = driver.findElement(By.xpath(sElement));
				break;
			case "accessibilityid":

				break;

			case "nameA":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;

			case "nameB":
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;

			}
		} catch (Exception e) {
			/*
			 * System.out.println("Object not found : " + objectLocator + Prop +
			 * e.getMessage()); Log.error("Exception : **********" +
			 * Thread.currentThread().getStackTrace()[1].getMethodName() +
			 * "**********"); Log.error("Object not found : " + objectLocator +
			 * Prop + e.getMessage()); Log.error("Exception message : " +
			 * e.getMessage());
			 */
		}
		// Log.info("Ended : **********" +
		// Thread.currentThread().getStackTrace()[1].getMethodName() +
		// "**********");
		return Element1;
	}

}
