package config;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utility.Log;


public class GenericMethods 

{
	public static RemoteWebDriver driver;
	public static ActionKeywords actionkeywords;
	
	/*
	'Description : This method would find the element
	'InputParameters : Object Locator and Object Property  
	'OutPutParameters:  WebElement 
	'Author: Vikram Kapale.
	'Date:  9-January-2017
	'Status := Executed
	'**************************************************************************************************
	'		C  H  A  N  G  E		H  I  S  T  O  R  Y
	'**************************************************************************************************
	' Date			Change made by		Purpose of change
	'--------		------------------- -------------------------------------------------
	'
	'**************************************************************************************************  
	*/
	
	
	public static WebElement findElement(String objectLocator, String Prop,RemoteWebDriver _driver) throws Throwable
	{
		
		driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;
		WebDriverWait wait = new WebDriverWait(driver, 120);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
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
				//driver.findElement(By.name(Prop)).click();
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
	
	
	public static WebElement findElement(String objectLocator, String Prop,WebDriver driver) throws Throwable
	{
		//WebDriver wdriver;
		//driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;
	
		WebDriverWait wait = new WebDriverWait(driver, 90);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
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
				//driver.findElement(By.name(Prop)).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;
			case "tagname":
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(Prop)));
				//wait.until(ExpectedConditions.elementToBeClickable(By.tagName(Prop)));
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
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
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

	
	
	
	
	
	public static WebElement findElement(String objectLocator, String Prop,AppiumDriver driver) throws Throwable
	{
		
		//driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
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
				//driver.findElement(By.name(Prop)).click();
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
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop)));
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
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
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
	

	
	
	
	
	
	
	
	
	
	public static WebElement findElement(String objectLocator, String Prop,AppiumDriver driver, int waitTime) throws Throwable
	{
		//driver = _driver;
		Log.info("Started : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		WebElement Element1 = null;
		WebDriverWait wait = new WebDriverWait(driver,waitTime);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
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
				//driver.findElement(By.name(Prop)).click();
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
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop)));
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
	//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Prop)));
				Element1 = driver.findElement(By.name(Prop));
				break;	

			}
		} catch (Exception e) {
	/*		System.out.println("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception : **********" + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ "**********");
			Log.error("Object not found : " + objectLocator + Prop + e.getMessage());
			Log.error("Exception message : " + e.getMessage()); */
		}
		//Log.info("Ended : **********" + Thread.currentThread().getStackTrace()[1].getMethodName() + "**********");
		return Element1;
	}
	

	
	
	
	
	
	public void smartSearchTransaction(String TestDesc, String objectref, String inputparam,String objectType,boolean bResult,String inputparam1) throws Throwable
	{
		int aa = 10;
		java.util.List<WebElement> view = ((AppiumDriver) driver).findElements(By.xpath(objectref));
		for (int i = 0; i <= view.size(); i++) {
			String sText = view.get(i).getText();
			if (sText.contains("+") && sText.contains(",")) {
				String sPlus = sText;
				WebElement parentElement = view.get(i).findElement(By.xpath("./.."));
				java.util.List<WebElement> view2 = parentElement.findElements(By.className("android.view.View"));
				for (int j = 0; j <= view.size(); j++) {
					if (view2.get(j).getText().contains("+") && view2.get(j).getText().contains(",")) {
						String sTransAmt = view2.get(j).getText();
						break;
					}
					try 
					{
						SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
						df.parse(view2.get(j).getText());
					} 
					catch (java.text.ParseException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
