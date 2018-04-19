package executionEngine;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.TreeMap;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import config.ActionKeywords;
import config.CleaningActivity;
import config.Constants;
import config.FrameworkFunctions;
import config.GenericMethods;
import reporting.CReporter;
import utility.ExcelUtils;
import utility.Log;

public class DriverScript {

	public String sTestCaseDesc, sTestStepDesc, sObjectRef, sInputParams, sKeyword, sObjectType, sInputParams1,
			sTestCaseID, sTestStepID, sRunMode, sData, sOS_Version, sappPackage, sappActivity, splatformName, sbundleID,
			fileLocdir, splatform, suser, spassword, surl, sdatasheetloc, sscreenshotsloc, sappType, sappurl,
			sappbrowser;
	public int iTestLastStep, iTestCase;
	public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH mm ss");
	public static String sTestCaseID1, driversheet, sDriversheet, projectpath, sDModNumber, sDevice_ID_TestCase,
			sDevice_ID, ssplatform,CurrentDateTime;
	
	
	public static int iTestStep;
	public Properties OR;
	public ActionKeywords actionKeywords;
	public String sPageObject;
	public GenericMethods genericmethods;
	public ActionKeywords actionkeyword;
	public Method method[];
	public static HashMap<String, String> hmapGlobal;
	public static HashMap<String, String> hmapInput;
	public static HashMap<String, String> hmapOutput;
	public static XSSFWorkbook xDriverSheet;
	public static FrameworkFunctions frameworkfunctions;
	public static boolean bResult;
	public static boolean bTestCaseLevelStatus = true; 
	public static HashMap<String, String> hGlobalOR;
	/* for Reporting */
	public String sappname;
	public CReporter reporter = null;
	boolean bFlagCase = true;
	WebDriver driver = null;

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

@BeforeSuite

public void pre(){
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd_HH mm ss");
	Date dateobj = new Date();
	CurrentDateTime=df.format(dateobj).toString();
	

	
	
}

	@Parameters(
			{ "device_ID", "platformName", "os_Version", "bundleID", "appPackage", "appActivity", "platform",
			"user", "password", "url", "datasheetloc", "screenshotsloc", "appType", "appurl", "appbrowser", "appname",
			"driversheet" }
			)
	
	@BeforeTest

	public void setupDriver(String device_ID, String platformName, String os_Version, String bundleID,
			String appPackage, String appActivity, String platform, String user, String password, String url,
			String datasheetloc, String screenshotsloc, String appType, String appurl, String appbrowser,
			String appname, String driversheet) throws MalformedURLException, NoSuchMethodException, SecurityException {
		try {

			sDevice_ID = device_ID;
			splatformName = platformName;
			sOS_Version = os_Version;
			sbundleID = bundleID;
			sappPackage = appPackage;
			sappActivity = appActivity;
			splatform = platform;
			suser = user;
			spassword = password;
			surl = url;
			sdatasheetloc = datasheetloc;
			screenshotsloc = "C:\\TestExecutionRuns\\";
			sscreenshotsloc = screenshotsloc;
			sappType = appType;
			sappurl = appurl;
			sappbrowser = appbrowser;
			sappname = appname;
			sDriversheet = driversheet;
			actionKeywords.setMethod(sDevice_ID, splatformName, sOS_Version, sbundleID, sappPackage, sappActivity,
					splatform, suser, spassword, surl, sdatasheetloc, sscreenshotsloc, sappType, sappurl, sappbrowser,
					sappname);

			/* For Reporting */
			reporter = CReporter.getCReporter(sDevice_ID, splatformName, sOS_Version, true);
			actionKeywords.setReporter(reporter);
			ssplatform = splatformName;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void shutDownSelenium() throws Exception {
		CleaningActivity ca = new CleaningActivity();
		ca.killDrivers();
		ca.ResultCleaning();
	}

	@Test
	public void main_method() throws Throwable {

		projectpath = System.getProperty("user.dir");
		long threadId = Thread.currentThread().getId();
		sDriversheet = "";
		sDriversheet = projectpath + "//src//main//java//dataEngine//DriverSheet.xlsx";
		String sModulePath = projectpath + "//src//main//java//dataEngine//";
		xDriverSheet = ExcelUtils.setExcelFile1(sDriversheet);
		int iDriver = ExcelUtils.getRowCount(Constants.Drive, xDriverSheet);
		for (int iDrive = 1; iDrive < iDriver; iDrive++)

		{
			sDModNumber = ExcelUtils.getCellData(iDrive, Constants.Col_DModNumber, Constants.Drive, xDriverSheet);
			sRunMode = ExcelUtils.getCellData(iDrive, Constants.Col_DRunMode, Constants.Drive, xDriverSheet);
			if (sRunMode.contains("Yes")) {
				sdatasheetloc = sModulePath + sDModNumber + ".xlsx";
				ExcelUtils.setExcelFile(sdatasheetloc);
		 		DOMConfigurator.configure("log4j.xml");
				TreeMap m = new TreeMap();
				int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
				for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {
					bResult = true;
					sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID,
							Constants.Sheet_TestCases);
					sDevice_ID_TestCase = ExcelUtils.getCellData(iTestcase, Constants.Col_DeviceID,
							Constants.Sheet_TestCases);
					System.out.println(threadId + "::" + sTestCaseID);
					sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode, Constants.Sheet_TestCases);

					sTestCaseDesc = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseDesc,
							Constants.Sheet_TestCases);
					String sPlatformName = ExcelUtils.getCellData(iTestcase, 5, Constants.Sheet_TestCases);

					if (sRunMode.equals("Yes") && sDevice_ID_TestCase.contains(sDevice_ID)
							&& sDevice_ID_TestCase.contains(splatformName)) {
						frameworkfunctions.LoadOR();
						Constants.Sheet_TestSteps = sTestCaseID;
						sTestCaseID1 = sTestCaseID;
						Log.startTestCase(sTestCaseID);
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH mm ss");
						Date dateobj = new Date();
						String date = df.format(dateobj).toString();
						fileLocdir = sscreenshotsloc + df.format(dateobj) + "\\" + sTestCaseID;
						new File(fileLocdir).mkdirs();
						/* For Reporting */
						reporter.initTestCase(
								this.getClass().getName().substring(0, this.getClass().getName().lastIndexOf(".")),
								sTestCaseID, sTestCaseDesc, false);
						iTestCase = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID,
								Constants.Sheet_TestCases);

						sTestCaseDesc = ExcelUtils.getCellData(iTestCase, Constants.Col_TestCaseDesc,
								Constants.Sheet_TestCases);
						System.out.println(threadId + "::" + "Test Case Description Is:" + sTestCaseDesc);
						m.put("TC_DESC", sTestCaseDesc);
						iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID,
								Constants.Sheet_TestSteps);
						iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
						int iLastRow = ExcelUtils.getRowCount(sTestCaseID);
						System.out.println(threadId + "::" + iTestStep);
						System.out.println(threadId + "::" + iTestLastStep);
						bResult = true;
						for (; iTestStep < iLastRow; iTestStep++) {
							sTestStepID = ExcelUtils.getCellData(iTestStep, Constants.Col_TestScenarioID,
									Constants.Sheet_TestSteps);
							if (false == sTestStepID.contains("TS_ID")) {
								System.out.println(threadId + "::" + "sTestStepID:" + sTestStepID);

								// To Get The Test Step Description
								sTestStepDesc = ExcelUtils.getCellData(iTestStep, Constants.Col_TestStepDesc,
										Constants.Sheet_TestSteps);
								System.out.println(threadId + "::" + "Test Step Description Is:" + sTestStepDesc);

								// To Get The Object Reference
								sObjectRef = ExcelUtils.getCellData(iTestStep, Constants.Col_ObjectRef,
										Constants.Sheet_TestSteps);
								System.out.println(threadId + "::" + "Object Reference Is:" + sObjectRef);

								// To Get The Input Parame ters
								sInputParams = ExcelUtils.getCellData(iTestStep, Constants.Col_InputParams,
										Constants.Sheet_TestSteps);
								System.out.println(threadId + "::" + "Input Parameter Is:" + sInputParams);

								// To Get The Keyword for each Test Step
								sKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_Keyword,
										Constants.Sheet_TestSteps);
								System.out.println(threadId + "::" + "Keyword Is:" + sKeyword);

								// To Get The ObjectType for each Test Step
								sObjectType = ExcelUtils.getCellData(iTestStep, Constants.Col_ObjectType,
										Constants.Sheet_TestSteps);
								System.out.println(threadId + "::" + "ObjectType Is:" + sObjectType);

								// To Get The Input Parameters1
								sInputParams1 = ExcelUtils.getCellData(iTestStep, Constants.Col_InputParams1,
										Constants.Sheet_TestSteps);
								System.out.println(threadId + "::" + "Input Parameter1 Is:" + sInputParams);
								hmapGlobal = new HashMap<String, String>();
								
								//Read Values from excel
								genericmethods.hmapInputHeaders(ExcelUtils.workbook);
								
								// execute_Actions();
								for (int i = 0; i < method.length; i++) {
									if (method[i].getName().equals(sKeyword)) {
										bResult = true;
										actionKeywords.setMethod_Screencapture(fileLocdir, sTestStepID);
										// Object driver = null;
										method[i].invoke(actionKeywords, sTestStepDesc, sObjectRef, sInputParams,
												sObjectType, bResult, sInputParams1);
										Thread.sleep(1000);
										// write values in excel
										genericmethods.hmapOutputHeaders(ExcelUtils.workbook, sdatasheetloc, actionkeyword.DOutput);
										if (bResult == true) {
											ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep,
													Constants.Col_TestStepResult, Constants.Sheet_TestSteps,
													sdatasheetloc);
											m.put("TS_DESC_" + sTestStepID,
													sTestStepDesc + "::" + Constants.KEYWORD_PASS);
											break;
										} else {
											ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep,
													Constants.Col_TestStepResult, Constants.Sheet_TestSteps,
													sdatasheetloc);
											m.put("TS_DESC_" + sTestStepID,
													sTestStepDesc + "::" + Constants.KEYWORD_FAIL);
											bFlagCase = false;
											bTestCaseLevelStatus = false;
											break;
										}
									}
								}
							}
						}

						// boolean bFlagCase;
						if (bTestCaseLevelStatus == false) {
							ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestcase, Constants.Col_Result,
									Constants.Sheet_TestCases, sdatasheetloc);
							m.put("TC_STATUS", Constants.KEYWORD_FAIL);

							reporter.calculateTestCaseExecutionTime();
							reporter.closeDetailedReport();
							reporter.updateTestCaseStatus();
							reporter.createHtmlSummaryReport(sappType, true);
							Log.endTestCase(sTestCaseID);
							bTestCaseLevelStatus = true;
						}

						else {
							ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestcase, Constants.Col_Result,
									Constants.Sheet_TestCases, sdatasheetloc);
							m.put("TC_STATUS", Constants.KEYWORD_PASS);
							/* For Reporting */
							reporter.calculateTestCaseExecutionTime();
							reporter.closeDetailedReport();
							reporter.updateTestCaseStatus();
							reporter.createHtmlSummaryReport(sappType, true);
							Log.endTestCase(sTestCaseID);
						}

					}
				} // end of for loop
			}
		}
	}
	

}