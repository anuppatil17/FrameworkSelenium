package reporting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import config.ActionKeywords;
import executionEngine.DriverScript;


public class CReporter extends ActionKeywords  {
	private static final Logger LOG = Logger.getLogger(CReporter.class);
	private DeviceContext deviceContext = null;
	private String reportPath = null;
	private static Map<DeviceContext, CReporter> mapDeviceContextReporter = new HashMap<DeviceContext, CReporter>();
	private String[] package_testname;
	private RemoteWebDriver remotedriver;
	public String fileName="";
	public static String timing;
	
	private CReporter(String deviceName, String platform, String version,
			boolean append)  {
		this.deviceContext = DeviceContext.getDeviceContext(deviceName,
				platform, version);
		this.reportPath = this.filePath();
		LOG.info("instance member deviceContext was set to : ");
		LOG.info(this.deviceContext);

	}

	/**
	 * 
	 * @return DeviceContext
	 */
	public DeviceContext getDeviceContext() {
		return this.deviceContext;
	}

	/*public static synchronized CReporter getCReporter(String deviceName,
			String platform, String version, boolean append) throws Exception{
		CReporter reporter = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH mm ss");
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		
	    Date dateobj = new Date();
	    timing=df.format(dateobj).toString();
       
		DeviceContext deviceContext = DeviceContext.getDeviceContext(
				deviceName, platform, version);
		reporter = CReporter.mapDeviceContextReporter.get(deviceContext);
		if (reporter == null) {
			reporter = new CReporter(deviceName, platform, version, append);
			LOG.info("Instance Of CReporter Created");
			CReporter.mapDeviceContextReporter.put(deviceContext, reporter);
			LOG.info("reporter was placed into CReporter.mapBrowserContextReporter");
		}
		return reporter;
	}
*/
	public static synchronized CReporter getCReporter(String deviceName,
			String platform, String version, boolean append) throws Exception{
		CReporter reporter = null;
	//	DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH mm ss");
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		
	//    Date dateobj = new Date();
	  //  timing=df.format(dateobj).toString();
		System.out.println("time-"+DriverScript.CurrentDateTime);
        timing=DriverScript.CurrentDateTime;
       
		DeviceContext deviceContext = DeviceContext.getDeviceContext(
				deviceName, platform, version);
		reporter = CReporter.mapDeviceContextReporter.get(deviceContext);
		if (reporter == null) {
			reporter = new CReporter(deviceName, platform, version, append);
			LOG.info("Instance Of CReporter Created");
			CReporter.mapDeviceContextReporter.put(deviceContext, reporter);
			LOG.info("reporter was placed into CReporter.mapBrowserContextReporter");
		}
		return reporter;
	}

	private String getFileName(String filePath) throws Exception {
		String fileNameOnly = null;
		File file = new File(filePath);
		try {

			if (file.isFile()) {
				fileNameOnly = file.getName().toString();
			}

		} catch (Exception e) {
			LOG.error("Exception Encountered : " + e.getMessage());
			throw e;
		}
		return fileNameOnly;
	}

	/**
	 * 
	 * @return ResultDir for each browserContext
	 */
	private String filePath() {
		String strDirectory = "";
		String deviceName = this.deviceContext.getDeviceName();
		String deviceVersion = this.deviceContext.getDeviceVersion();
		String devicePlatform = this.deviceContext.getDevicePlatform();
        
		LOG.debug("device name = " + deviceName);
		//switch (deviceName.toLowerCase()) {
		
		if ("firefox".equals(deviceName.toLowerCase()))
		{
		//case "firefox":
			strDirectory = "FF";
		//	break;
		} 
		if ("chrome".equals(deviceName.toLowerCase()))
		{
		//case "chrome":
			strDirectory = "CHROME";
			//break;
		}
		if ("ie".equals(deviceName.toLowerCase()))
		{
		//case "ie":
			strDirectory = "IE";
			//break;
		}
		//default:
		if ("default".equals(deviceName.toLowerCase()))
		{
			strDirectory = deviceName;
		}
			/*
			 * try { throw new IOException("BrowserName not properly defined");
			 * } catch (IOException e) { // TODO Auto-generated catch block
			 * LOG.error("IOException Encountered : " + e.getMessage());
			 * e.printStackTrace(); }
			 */

	//	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		strDirectory = strDirectory + "-" + deviceVersion + "-" + devicePlatform;
		//Change 1 folder Structure-Anup
		File resultDir = new File(ReporterConstants.LOCATION_RESULT + File.separator +  timing + File.separator +strDirectory  );
		LOG.info("resultDir = " + resultDir);
		
		if (resultDir.exists() == false) {
			try {
				resultDir.mkdirs();
			} catch (Exception e) {
				LOG.info("Exception Encountered : " + e.getMessage());
			}
		}
		//Change 2 folder Structure-Anup
		File screenShotDir = new File(ReporterConstants.LOCATION_RESULT + File.separator + timing + File.separator + strDirectory + File.separator
				+ ReporterConstants.FOLDER_SCREENRSHOTS);

		if (screenShotDir.exists() == false) {
			try {
				screenShotDir.mkdirs();
				this.copyLogos(ReporterConstants.LOCATION_CLIENT_LOGO,
						ReporterConstants.LOCATION_COMPANY_LOGO,
						ReporterConstants.LOCATION_FAILED_LOGO,
						ReporterConstants.LOCATION_MINUS_LOGO,
						ReporterConstants.LOCATION_PASSED_LOGO,
						ReporterConstants.LOCATION_TEST_PASSED_LOGO,
						ReporterConstants.LOCATION_PLUS_LOGO,
						ReporterConstants.LOCATION_WARNING_LOGO,
						ReporterConstants.LOCATION_JQUERY_CSS_FOLDER,
						ReporterConstants.LOCATION_JQUERY_IMAGES_FOLDER,
						ReporterConstants.LOCATION_JQUERY_JS_FOLDER);
			} catch (Exception e) {
				LOG.info("Exception Encountered : " + e.getMessage());
			}
		}

		try {
			strDirectory = resultDir.getCanonicalPath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("IOException Encountered : " + e.getMessage());
			e.printStackTrace();
		}
		return strDirectory;
	}

	private void copyLogos(String... logos) {

		File destFolder = new File(this.filePath() + File.separatorChar
				+ ReporterConstants.FOLDER_SCREENRSHOTS);
		for (String logo : logos) {
			LOG.info("Current Logo Name : " + logo);
			File logoFile = new File(logo);
			/*if folder then copy folder*/
			if (logoFile.isDirectory()) {
				try {
					FileUtils.copyDirectoryToDirectory(logoFile, destFolder);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					LOG.info(logoFile + "could not be copied to " + destFolder);
					LOG.info("IOException Encountered : " + e.getMessage());
					e.printStackTrace();
				}
			}
			/*if file then copy file*/
			if (logoFile.isDirectory() == false) {
				/* copy File if exist */
				if (logoFile.exists()) {
					try {
						FileUtils.copyFileToDirectory(logoFile, destFolder);
						LOG.info(logoFile + "copied to " + destFolder);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						LOG.info(logoFile + "could not be copied to "
								+ destFolder);
						LOG.info("IOException Encountered : " + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}

	}


	
	
	/**
     * 
      * @param strStepName
     * @param strStepDes
     * @param fileName
	 * @throws Exception 
     */
     public void onSuccessscreenshot(String strStepName, String strStepDes,
                   String filename) throws Exception {

    	 fileName = this.filePath() + File.separatorChar
					+ ReporterConstants.FOLDER_SCREENRSHOTS
					+ File.separatorChar + strStepName + ".jpeg";

			fileName = makeUniqueImagePath(fileName);
    	 FileUtils.copyFile(new File(filename), new File(fileName));
            String href = "./"
                         + fileName
                                       .substring(
                                                     fileName.indexOf(ReporterConstants.FOLDER_SCREENRSHOTS),
                                                     fileName.length());
            String imgSrc = "'." + File.separatorChar
                         + ReporterConstants.FOLDER_SCREENRSHOTS + File.separatorChar
                         + this.getFileName(ReporterConstants.LOCATION_TEST_PASSED_LOGO)
                         + "'";
            Writer writer = null;
            try {
                   File file = new File(this.filePath() + File.separatorChar
                                + TestResult.strTestName.get(this.deviceContext)
                                + "_Results" +
                                /* + TestResult.timeStamp + */".html");// "SummaryReport.html"

                   writer = new FileWriter(file, true);
                   Integer stepNumValue = TestResult.stepNum.get(this.deviceContext);
                   if (stepNumValue != null) {

                         TestResult.stepNum.put(this.deviceContext, stepNumValue + 1);
                   }

                   writer.write("<tr class='content2' >");
                   writer.write("<td>" + TestResult.stepNum.get(this.deviceContext)
                                + "</td> ");
                   writer.write("<td class='justified'>" + strStepName + "</td>");
                   writer.write("<td class='justified'>" + strStepDes + "</td> ");

                   Integer passNumValue = TestResult.PassNum.get(this.deviceContext);
                   if (passNumValue != null) {
       				TestResult.PassNum.put(this.deviceContext, passNumValue + 1);
       			}

                   
                   writer.write("<td class='Pass' align='center'><a  href='"
                                + href
                                + "'"
                                + " alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img  src="
                                + imgSrc + "height='18'/></a></td>");

                   String strPassTime = CReporter.getTime();
       				writer.write("<td><small>" + strPassTime + "</small></td> ");
       				writer.write("</tr> ");
       				writer.close();
                   String strPackageName = TestResult.packageName
                                .get(this.deviceContext);
                   String strTcName = TestResult.tc_name.get(this.deviceContext);
                   if (!TestResult.mapDeviceContextTestCaseRef
                                .get(this.deviceContext)
                                .get(strPackageName + ":" + strTcName).equals("PASS")) {
                         TestResult.mapDeviceContextTestCaseRef
                                       .get(this.deviceContext).put(
                                                     strPackageName + ":" + strTcName, "FAIL");
                   }
            } catch (Exception e) {
                   LOG.info("Exception Encountered : " + e.getMessage());
                   e.printStackTrace();
            }

     }



	public void createHtmlSummaryReport(String AppType, boolean append)
			throws Exception {

		File file = new File(this.filePath() + "/" + "SummaryResults"
		/* + TestResult.timeStamp */+ ".html");// "SummaryReport.html"
		Writer writer = null;
		String imgSrcClientLogo = "." + File.separatorChar
				+ ReporterConstants.FOLDER_SCREENRSHOTS + File.separatorChar
				+ this.getFileName(ReporterConstants.LOCATION_CLIENT_LOGO);
		String imgSrcCompanyLogo = "." + File.separatorChar
				+ ReporterConstants.FOLDER_SCREENRSHOTS + File.separatorChar
				+ this.getFileName(ReporterConstants.LOCATION_COMPANY_LOGO);
		if (file.exists()) {
			file.delete();
		}
		writer = new FileWriter(file, append);
		try {
			writer.write("<!DOCTYPE html>");
			writer.write("<html> ");
			writer.write("<head> ");
			writer.write("<meta charset='UTF-8'> ");
			writer.write("<title>Automation Execution Results Summary</title>");

			// Jquery java script
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/datatable/jquery.dataTables.css'>");
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/jquery-ui.css'>");
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/datatable/dataTables.jqueryui.css'>");
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/custom.css'>");

			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/jquery-1.11.1.min.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/datatable/jquery.dataTables.min.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/datatable/dataTables.jqueryui.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/jquery-ui.min.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/custom.js'></script>");

			writer.write("<style type='text/css'>");
			writer.write("body {");
			writer.write("background-color: #FFFFFF; ");
			writer.write("font-family: Verdana, Geneva, sans-serif; ");
			writer.write("text-align: center; ");
			writer.write("} ");

			writer.write("small { ");
			writer.write("font-size: 0.7em; ");
			writer.write("} ");

			writer.write("table { ");
			writer.write("box-shadow: 9px 9px 10px 4px #BDBDBD;");
			writer.write("border: 0px solid #4D7C7B;");
			writer.write("border-collapse: collapse; ");
			writer.write("border-spacing: 0px; ");
			writer.write("width: 1000px; ");
			writer.write("margin-left: auto; ");
			writer.write("margin-right: auto; ");
			writer.write("} ");

			writer.write("tr.heading { ");
			writer.write("background-color: #041944;");
			writer.write("color: #FFFFFF; ");
			writer.write("font-size: 0.7em; ");
			writer.write("font-weight: bold; ");
			writer.write("background:-o-linear-gradient(bottom, #999999 5%, #000000 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #999999), color-stop(1, #000000) );");
			writer.write("background:-moz-linear-gradient( center top, #999999 5%, #000000 100% );");
			writer.write("filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#999999, endColorstr=#000000);	background: -o-linear-gradient(top,#999999,000000);");
			writer.write("} ");

			writer.write("tr.subheading { ");
			writer.write("background-color: #6A90B6;");
			writer.write("color: #000000; ");
			writer.write("font-weight: bold; ");
			writer.write("font-size: 0.7em; ");
			writer.write("text-align: justify; ");
			writer.write("} ");

			writer.write("tr.section { ");
			writer.write("background-color: #A4A4A4; ");
			writer.write("color: #333300; ");
			writer.write("cursor: pointer; ");
			writer.write("font-weight: bold;");
			writer.write("font-size: 0.8em; ");
			writer.write("text-align: justify;");
			writer.write("background:-o-linear-gradient(bottom, #56aaff 5%, #e5e5e5 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #56aaff), color-stop(1, #e5e5e5) );");
			writer.write("background:-moz-linear-gradient( center top, #56aaff 5%, #e5e5e5 100% );");
			writer.write("filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#56aaff, endColorstr=#e5e5e5);	background: -o-linear-gradient(top,#56aaff,e5e5e5);");

			writer.write("} ");

			writer.write("tr.subsection { ");
			writer.write("cursor: pointer; ");
			writer.write("} ");

			writer.write("tr.content { ");
			writer.write("background-color: #FFFFFF; ");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.7em; ");
			writer.write("display: table-row; ");
			writer.write("} ");

			writer.write("tr.content2 { ");
			writer.write("background-color:#;E1E1E1");
			writer.write("border: 1px solid #4D7C7B;");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.7em; ");
			writer.write("display: table-row; ");
			writer.write("} ");

			writer.write("td, th { ");
			writer.write("padding: 5px; ");
			writer.write("border: 1px solid #4D7C7B; ");
			writer.write("text-align: inherit\0/; ");
			writer.write("} ");

			writer.write("th.Logos { ");
			writer.write("padding: 5px; ");
			writer.write("border: 0px solid #4D7C7B; ");
			writer.write("text-align: inherit /;");
			writer.write("} ");

			writer.write("td.justified { ");
			writer.write("text-align: justify; ");
			writer.write("} ");

			writer.write("td.pass {");
			writer.write("font-weight: bold; ");
			writer.write("color: green; ");
			writer.write("} ");

			writer.write("td.fail { ");
			writer.write("font-weight: bold; ");
			writer.write("color: red; ");
			writer.write("} ");

			writer.write("td.done, td.screenshot { ");
			writer.write("font-weight: bold; ");
			writer.write("color: black; ");
			writer.write("} ");

			writer.write("td.debug { ");
			writer.write("font-weight: bold; ");
			writer.write("color: blue; ");
			writer.write("} ");

			writer.write("td.warning { ");
			writer.write("font-weight: bold; ");
			writer.write("color: orange; ");
			writer.write("} ");
			writer.write("</style> ");

			writer.write("<script> ");
			writer.write("function toggleMenu(objID) { ");
			writer.write(" if (!document.getElementById) return;");
			writer.write(" var ob = document.getElementById(objID).style; ");
			writer.write("if(ob.display === 'none') { ");
			writer.write(" try { ");
			writer.write(" ob.display='table-row-group';");
			writer.write("} catch(ex) { ");
			writer.write("	 ob.display='block'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("else { ");
			writer.write(" ob.display='none'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("function toggleSubMenu(objId) { ");
			writer.write("for(i=1; i<10000; i++) { ");
			writer.write("var ob = document.getElementById(objId.concat(i)); ");
			writer.write("if(ob === null) { ");
			writer.write("break; ");
			writer.write("} ");
			writer.write("if(ob.style.display === 'none') { ");
			writer.write("try { ");
			writer.write(" ob.style.display='table-row'; ");
			writer.write("} catch(ex) { ");
			writer.write("ob.style.display='block'; ");
			writer.write("} ");
			writer.write(" } ");
			writer.write("else { ");
			writer.write("ob.style.display='none'; ");
			writer.write("} ");
			writer.write(" } ");
			writer.write("} ");
			writer.write("</script> ");
			writer.write("</head> ");

			writer.write("<body> ");
			writer.write("</br>");

			writer.write("<table id='Logos' class='testData'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("</colgroup> ");
			writer.write("<thead> ");

			writer.write("<tr class='content'>");
			writer.write("<th class ='Logos' colspan='2' >");
			writer.write("<img align ='left' src= " + imgSrcClientLogo
					+ "></img>");
			writer.write("</th>");
			writer.write("<th class = 'Logos' colspan='2' > ");
			writer.write("<img align ='right' src=  " + imgSrcCompanyLogo
					+ "></img>");
			writer.write("</th> ");
			writer.write("</tr> ");

			writer.write("</thead> ");
			writer.write("</table> ");

			writer.write("<table id='header' class='testData'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write(" <col style='width: 25%' /> ");
			writer.write("</colgroup> ");

			writer.write("<thead> ");

			writer.write("<tr class='heading'> ");
			writer.write("<th colspan='4' style='font-family:Copperplate Gothic Bold; font-size:1.4em;'> ");
			writer.write("Automation Execution Result Summary ");
			writer.write("</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Date&nbsp;&&nbsp;Time&nbsp;:&nbsp;" + ""
					+ "</th> ");
			// writer.write("<th>&nbsp;:&nbsp;08-Apr-2013&nbsp;06:24:21&nbsp;PM</th> ");
			writer.write("<th> &nbsp;" + CReporter.dateTime() + "&nbsp;</th> ");
			writer.write("<th>&nbsp;Device Name&nbsp;:&nbsp;</th> ");
			writer.write("<th>" + this.deviceContext.getDeviceName() + "</th> ");
			writer.write("</tr> ");

			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Device Platform&nbsp;:&nbsp;</th> ");
			writer.write("<th>" + this.deviceContext.getDevicePlatform() + "</th> ");
			writer.write("<th>&nbsp;Device Version&nbsp;:</th> ");
			writer.write("<th>" + this.deviceContext.getDeviceVersion()
					+ "</th> ");
			writer.write("</tr> ");

			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Host Name&nbsp;:</th> ");
			writer.write("<th>" + InetAddress.getLocalHost().getHostName()
					+ "</th> ");
			writer.write("<th>&nbsp;Application Type&nbsp;:</th> ");
			writer.write("<th>" + AppType + "</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");
			writer.write("</table> ");
			writer.write("<div class='mainTableDiv4'>");
			writer.write("<table id='main' class='testData'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 5%' /> ");
			writer.write("<col style='width: 35%' /> ");
			writer.write("<col style='width: 42%' /> ");
			writer.write("<col style='width: 10%' /> ");
			writer.write("<col style='width: 8%' /> ");
			writer.write("</colgroup> ");
			writer.write("<thead> ");
			writer.write("<tr class='heading'> ");
			writer.write("<th>S.NO</th> ");
			writer.write("<th>Test Case</th> ");
			writer.write("<th>Description</th> ");
			writer.write("<th>Time</th> ");
			writer.write("<th>Status</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");

			/* get corresponding map to browserContext */
			Map<String, String> testCaseRef = TestResult.mapDeviceContextTestCaseRef
					.get(this.deviceContext);

			Iterator<Entry<String, String>> iterator1 = testCaseRef.entrySet()
					.iterator();
			int serialNo = 1;
			writer.write("<tbody> ");
			while (iterator1.hasNext()) {

				Map.Entry<String, String> mapEntry1 = (Map.Entry<String, String>) iterator1
						.next();
				/* key contains packagename:testmethod */
				LOG.info("Key of mapEntry1 : " + mapEntry1.getKey());
				this.package_testname = mapEntry1.getKey().toString()
						.split(":");
				LOG.info("package is present in package_testname[0] : "
						+ this.package_testname[0]);
				LOG.info("test method is present in package_testname[1] : "
						+ this.package_testname[1]);
				String testCaseExecutionStatus = (String) mapEntry1.getValue();
				LOG.info("value against package_testname is : "
						+ testCaseExecutionStatus);
				// writer.write("<tbody> ");
				writer.write("<tr class='content2' > ");
				writer.write("<td class='justified'>" + serialNo + "</td>");
				if (testCaseExecutionStatus
						.equals(ReporterConstants.TEST_CASE_STATUS_PASS)) {
					writer.write("<td class='justified'><a href='"
							+ package_testname[1]
							+ "_Results"
							/* + TestResult.timeStamp */+ ".html#'"
							+ "' target='about_blank'>"
							+ this.package_testname[1].substring(0,
									this.package_testname[1].indexOf("-"))
							+ "</a></td>");
				} else {
					writer.write("<td class='justified'><a href='"
							+ this.package_testname[1]
							+ "_Results"
							/* + TestResult.timeStamp */+ ".html'"
							+ " target='about_blank'>"
							+ this.package_testname[1].substring(0,
									this.package_testname[1].indexOf("-"))
							+ "</a></td>");
				}
				String localTestDescription = "";
				if (TestResult.testDescription != null) {
					Map<String, String> mapTestDescription = TestResult.testDescription
							.get(this.deviceContext);
					if (mapTestDescription != null) {
						localTestDescription = mapTestDescription
								.get(this.package_testname[1]);
					}
				}
				writer.write("<td class='justified'>" + localTestDescription
						+ "</td>");

				writer.write("<td>"
						+ TestResult.executionTime.get(this.deviceContext)
								.get(this.package_testname[1])
						+ " Seconds</td>");
				if (TestResult.testResults.get(this.deviceContext)
						.get(this.package_testname[1])
						.equals(ReporterConstants.TEST_CASE_STATUS_PASS))
					writer.write("<td class='pass'>"
							+ ReporterConstants.TEST_CASE_STATUS_PASS
							+ "</td> ");
				else
					writer.write("<td class='fail'>"
							+ ReporterConstants.TEST_CASE_STATUS_FAIL
							+ "</td> ");
				writer.write("</tr>");
				// writer.write("</tbody> ");
				serialNo = serialNo + 1;
			}
			writer.write("</tbody> ");
			writer.flush();
			writer.close();

		} catch (Exception e) {
			LOG.info("Excepiton Encountered : " + e.getMessage());
			writer.flush();
			writer.close();
		}

	}

	/**
	 * 
	 * @param strStepName
	 * @param strStepDes
	 * @throws Exception 
	 */
	
	/**
	 * 
	 * @param strStepName
	 * @param strStepDes
	 * @param fileName
	 * @throws Exception 
	 */
	public void onFailure(String strStepName, String strStepDes,
			String filename) throws Exception {
		fileName = this.filePath() + File.separatorChar
				+ ReporterConstants.FOLDER_SCREENRSHOTS
				+ File.separatorChar + strStepName + ".jpeg";

		fileName = makeUniqueImagePath(fileName);
		 FileUtils.copyFile(new File(filename), new File(fileName));
		String href = "./"
				+ fileName
						.substring(
								fileName.indexOf(ReporterConstants.FOLDER_SCREENRSHOTS),
								fileName.length());
		String imgSrc = "'." + File.separatorChar
				+ ReporterConstants.FOLDER_SCREENRSHOTS + File.separatorChar
				+ this.getFileName(ReporterConstants.LOCATION_FAILED_LOGO)
				+ "'";
		Writer writer = null;
		try {
			File file = new File(this.filePath() + File.separatorChar
					+ TestResult.strTestName.get(this.deviceContext)
					+ "_Results" +
					/* + TestResult.timeStamp + */".html");// "SummaryReport.html"

			writer = new FileWriter(file, true);
			Integer stepNumValue = TestResult.stepNum.get(this.deviceContext);
			if (stepNumValue != null) {

				TestResult.stepNum.put(this.deviceContext, stepNumValue + 1);
			}

			writer.write("<tr class='content2' >");
			writer.write("<td>" + TestResult.stepNum.get(this.deviceContext)
					+ "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes + "</td> ");

			Integer failNumValue = TestResult.FailNum.get(this.deviceContext);
			if (stepNumValue != null) {

				TestResult.FailNum.put(this.deviceContext, failNumValue + 1);
			}

			/*
			 * writer.write("<td class='Fail' align='center'><a  href='"+
			 * "./Screenshots"+"/" + strStepDes.replace(" ", "_") + "_" +
			 * TestResult.timeStamp + ".jpeg'"+
			 * " alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img  src='./Screenshots/failed.ico' width='18' height='18'/></a></td>"
			 * );
			 */
			// New Screen shot code to avoid overriding \\\\
			writer.write("<td class='Fail' align='center'><a  href='"
					+ href
					+ "'"
					+ " alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img  src="
					+ imgSrc + "height='18'/></a></td>");

			String strFailTime = CReporter.getTime();
			writer.write("<td><small>" + strFailTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();
			String strPackageName = TestResult.packageName
					.get(this.deviceContext);
			String strTcName = TestResult.tc_name.get(this.deviceContext);
			if (!TestResult.mapDeviceContextTestCaseRef
					.get(this.deviceContext)
					.get(strPackageName + ":" + strTcName).equals("PASS")) {
				TestResult.mapDeviceContextTestCaseRef
						.get(this.deviceContext).put(
								strPackageName + ":" + strTcName, "FAIL");
			}
		} catch (Exception e) {
			LOG.info("Exception Encountered : " + e.getMessage());
			e.printStackTrace();
		}

	}

	
	@Test
	public void testHeader(String testName, boolean append) {
		Writer writer = null;

		try {
			String imgSrcClientLogo = "." + File.separatorChar
					+ ReporterConstants.FOLDER_SCREENRSHOTS
					+ File.separatorChar
					+ this.getFileName(ReporterConstants.LOCATION_CLIENT_LOGO);
			String imgSrcCompanyLogo = "." + File.separatorChar
					+ ReporterConstants.FOLDER_SCREENRSHOTS
					+ File.separatorChar
					+ this.getFileName(ReporterConstants.LOCATION_COMPANY_LOGO);
			TestResult.strTestName.put(this.deviceContext, testName);
			File file = new File(this.filePath() + File.separatorChar
					+ TestResult.strTestName.get(this.deviceContext)
					+ "_Results"
					/* + TestResult.timeStamp */+ ".html");// "Results.html"
			writer = new FileWriter(file, append);

			writer.write("<!DOCTYPE html> ");
			writer.write("<html>");
			writer.write("<head> ");
			writer.write("<meta charset='UTF-8'> ");
			writer.write("<title>"
					+ TestResult.strTestName.get(this.deviceContext)
					+ " Execution Results</title> ");

			// Jquery java script
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/datatable/jquery.dataTables.css'>");
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/jquery-ui.css'>");
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/datatable/dataTables.jqueryui.css'>");
			writer.write("<link rel='stylesheet' type='text/css' href='Screenshots/css/custom.css'>");

			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/jquery-1.11.1.min.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/datatable/jquery.dataTables.min.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/datatable/dataTables.jqueryui.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/jquery-ui.min.js'></script>");
			writer.write("<script type='text/javascript' language='javascript' src='Screenshots/js/custom.js'></script>");

			writer.write("<style type='text/css'> ");
			writer.write("body { ");
			writer.write("background-color: #FFFFFF; ");
			writer.write("font-family: Verdana, Geneva, sans-serif; ");
			writer.write("text-align: center; ");
			writer.write("} ");

			writer.write("small { ");
			writer.write("font-size: 0.7em; ");
			writer.write("} ");

			writer.write("table { ");
			writer.write("box-shadow: 9px 9px 10px 4px #BDBDBD;");
			writer.write("border: 0px solid #4D7C7B; ");
			writer.write("border-collapse: collapse; ");
			writer.write("border-spacing: 0px; ");
			writer.write("width: 1000px; ");
			writer.write("margin-left: auto; ");
			writer.write("margin-right: auto; ");
			writer.write("} ");

			writer.write("tr.heading { ");
			writer.write("background-color: #041944; ");
			writer.write("color: #FFFFFF; ");
			writer.write("font-size: 0.7em; ");
			writer.write("font-weight: bold; ");
			writer.write("background:-o-linear-gradient(bottom, #999999 5%, #000000 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #999999), color-stop(1, #000000) );");
			writer.write("background:-moz-linear-gradient( center top, #999999 5%, #000000 100% );");
			writer.write("filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#999999, endColorstr=#000000);	background: -o-linear-gradient(top,#999999,000000);");
			writer.write("} ");

			writer.write("tr.subheading { ");
			writer.write("background-color: #FFFFFF; ");
			writer.write("color: #000000; ");
			writer.write("font-weight: bold; ");
			writer.write("font-size: 0.7em; ");
			writer.write("text-align: justify; ");
			writer.write("} ");

			writer.write("tr.section { ");
			writer.write("background-color: #A4A4A4; ");
			writer.write("color: #333300; ");
			writer.write("cursor: pointer; ");
			writer.write("font-weight: bold; ");
			writer.write("font-size: 0.7em; ");
			writer.write("text-align: justify; ");
			writer.write("background:-o-linear-gradient(bottom, #56aaff 5%, #e5e5e5 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #56aaff), color-stop(1, #e5e5e5) );");
			writer.write("background:-moz-linear-gradient( center top, #56aaff 5%, #e5e5e5 100% );");
			writer.write("filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#56aaff, endColorstr=#e5e5e5);	background: -o-linear-gradient(top,#56aaff,e5e5e5);");
			writer.write("} ");

			writer.write("tr.subsection { ");
			writer.write("cursor: pointer; ");
			writer.write("} ");

			writer.write("tr.content { ");
			writer.write("background-color: #FFFFFF; ");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.7em; ");
			writer.write("display: table-row; ");
			writer.write("} ");

			writer.write("tr.content2 { ");
			writer.write("background-color: #E1E1E1; ");
			writer.write("border: 1px solid #4D7C7B;");
			writer.write("color: #000000; ");
			writer.write("font-size: 0.75em; ");
			writer.write("display: table-row; ");
			writer.write("} ");

			writer.write("td, th { ");
			writer.write("padding: 5px; ");
			writer.write("border: 1px solid #4D7C7B; ");
			writer.write("text-align: inherit\0/; ");
			writer.write("} ");

			writer.write("th.Logos { ");
			writer.write("padding: 5px; ");
			writer.write("border: 0px solid #4D7C7B; ");
			writer.write("text-align: inherit /;");
			writer.write("} ");

			writer.write("td.justified { ");
			writer.write("text-align: justify; ");
			writer.write("} ");

			writer.write("td.pass { ");
			writer.write("font-weight: bold; ");
			writer.write("color: green; ");
			writer.write("} ");

			writer.write("td.fail { ");
			writer.write("font-weight: bold; ");
			writer.write("color: red; ");
			writer.write("} ");

			writer.write("td.done, td.screenshot { ");
			writer.write("font-weight: bold; ");
			writer.write("color: black; ");
			writer.write("} ");

			writer.write("td.debug { ");
			writer.write("font-weight: bold;");
			writer.write("color: blue; ");
			writer.write("} ");

			writer.write("td.warning { ");
			writer.write("font-weight: bold; ");
			writer.write("color: orange; ");
			writer.write("} ");
			writer.write("</style> ");

			writer.write("<script> ");
			writer.write("function toggleMenu(objID) { ");
			writer.write("if (!document.getElementById) return; ");
			writer.write("var ob = document.getElementById(objID).style; ");
			writer.write("if(ob.display === 'none') { ");
			writer.write("try { ");
			writer.write("ob.display='table-row-group'; ");
			writer.write("} catch(ex) { ");
			writer.write("ob.display='block'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("else { ");
			writer.write("ob.display='none'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("function toggleSubMenu(objId) { ");
			writer.write("for(i=1; i<10000; i++) { ");
			writer.write("var ob = document.getElementById(objId.concat(i)); ");
			writer.write("if(ob === null) { ");
			writer.write("break; ");
			writer.write("} ");
			writer.write("if(ob.style.display === 'none') { ");
			writer.write("try { ");
			writer.write("ob.style.display='table-row'; ");
			writer.write("} catch(ex) { ");
			writer.write("ob.style.display='block'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("else { ");
			writer.write("ob.style.display='none'; ");
			writer.write("} ");
			writer.write("} ");
			writer.write("} ");
			writer.write("</script> ");
			writer.write("</head> ");

			writer.write(" <body> ");
			writer.write("</br>");

			writer.write("<table id='Logos' class='testData'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("</colgroup> ");
			writer.write("<thead> ");

			writer.write("<tr class='content'>");
			writer.write("<th class ='Logos' colspan='2' >");
			writer.write("<img align ='left' src= " + imgSrcClientLogo
					+ "></img>");
			writer.write("</th>");
			writer.write("<th class = 'Logos' colspan='2' > ");
			writer.write("<img align ='right' src= " + imgSrcCompanyLogo
					+ "></img>");
			writer.write("</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");
			writer.write("</table> ");

			writer.write("<table id='header' class='testData'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("<col style='width: 25%' /> ");
			writer.write("</colgroup> ");

			writer.write(" <thead> ");

			writer.write("<tr class='heading'> ");
			writer.write("<th colspan='4' style='font-family:Copperplate Gothic Bold; font-size:1.4em;'> ");
			writer.write("**" + TestResult.strTestName.get(this.deviceContext)
					+ " Execution Results **");
			writer.write("</th> ");
			writer.write("</tr> ");
			/*writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Date&nbsp;&&nbsp;Time&nbsp;:&nbsp;</th> ");
			writer.write("<th>" + CReporter.dateTime() + "</th> ");
			writer.write("</tr> ");*/
			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Device Name&nbsp;:&nbsp;</th> ");
			writer.write("<th>" + this.deviceContext.getDeviceName()
					+ "</th> ");
			writer.write("<th>Device Platform&nbsp;:</th> ");
			writer.write("<th>" + this.deviceContext.getDevicePlatform() + "</th> ");
			writer.write("</tr> ");

			writer.write("<tr class='subheading'> ");
			writer.write("<th>&nbsp;Device Version&nbsp;:&nbsp;</th> ");
			writer.write("<th>" + this.deviceContext.getDeviceVersion()
					+ "</th> ");
			writer.write("<th>&nbsp;Date&nbsp;&&nbsp;Time&nbsp;:&nbsp;</th> ");
			writer.write("<th>" + CReporter.dateTime() + "</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");
			writer.write("</table> ");

			writer.write("<div class='mainTableDiv4'>");
			writer.write("<table id='main' class='testData'> ");
			writer.write("<colgroup> ");
			writer.write("<col style='width: 5%' /> ");
			writer.write("<col style='width: 26%' /> ");
			writer.write("<col style='width: 51%' /> ");
			writer.write("<col style='width: 8%' /> ");
			writer.write("<col style='width: 10%' /> ");
			writer.write("</colgroup> ");
			writer.write("<thead> ");
			writer.write("<tr class='heading'> ");
			writer.write("<th>S.NO</th> ");
			writer.write("<th>Steps</th> ");
			writer.write("<th>Details</th> ");
			writer.write("<th>Status</th> ");
			writer.write("<th>Time</th> ");
			writer.write("</tr> ");
			writer.write("</thead> ");
			writer.close();

			String strPackageName = TestResult.packageName
					.get(this.deviceContext);
			String strTcName = TestResult.tc_name.get(this.deviceContext);

			/* get test case status map */
			Map<String, String> mapTestCaseStatus = TestResult.mapDeviceContextTestCaseRef
					.get(this.deviceContext);
			if (mapTestCaseStatus == null) {
				mapTestCaseStatus = new HashMap<String, String>();
			}

			mapTestCaseStatus.put(strPackageName + ":" + strTcName, "status");
			TestResult.mapDeviceContextTestCaseRef.put(this.deviceContext,
					mapTestCaseStatus);
		} catch (Exception e) {

		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (Exception e) {

			}
		}
	}


	public void closeDetailedReport() throws IOException {

		File file = new File(this.filePath() + File.separatorChar
				+ TestResult.strTestName.get(this.deviceContext) + "_Results"
				/* + TestResult.timeStamp */+ ".html");// "SummaryReport.html"
		Writer writer = null;

		try {
			writer = new FileWriter(file, true);
			writer.write("</table></div>");
			writer.write("<table id='footer' class='testData'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("</colgroup>");
			writer.write("<tfoot>");
			writer.write("<tr class='heading'> ");
			writer.write("<th colspan='4'>Execution Time In Seconds (Includes Report Creation Time) : "
					+ TestResult.executionTime.get(this.deviceContext).get(
							TestResult.tc_name.get(this.deviceContext))
					+ "&nbsp;</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='content'>");
			writer.write("<td class='pass'>&nbsp;Steps Passed&nbsp;:</td>");
			writer.write("<td class='pass'> "
					+ TestResult.PassNum.get(this.deviceContext) + "</td>");
			writer.write("<td class='fail'>&nbsp;Steps Failed&nbsp;: </td>");
			writer.write("<td class='fail'>"
					+ TestResult.FailNum.get(this.deviceContext) + "</td>");
			writer.write("</tr>");
			writer.close();
		} catch (Exception e) {

		}
	}

	public void closeSummaryReport() throws IOException {

		File file = new File(this.filePath() + File.separatorChar
				+ "SummaryResults"
				/* + TestResult.timeStamp */+ ".html");// "SummaryReport.html"
		Writer writer = null;
		try {
			// get pass/fail test cases count
			Integer passTestCasesCount = TestResult.passCounter
					.get(this.deviceContext) == null ? 0
					: TestResult.passCounter.get(this.deviceContext);
			Integer failTestCasesCount = TestResult.failCounter
					.get(this.deviceContext) == null ? 0
					: TestResult.failCounter.get(this.deviceContext);

			//
			writer = new FileWriter(file, true);

			writer.write("<table id='footer' class='testData'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' /> ");
			writer.write("</colgroup> ");
			writer.write("<tfoot>");
			writer.write("<tr class='heading'>");
			writer.write("<th colspan='4'>Total Duration  In Seconds (Including Report Creation) : "
					+ (int) ((double) TestResult.iSuiteExecutionTime
							.get(this.deviceContext)) + "</th>");
			writer.write("</tr>");
			writer.write("<tr class='content'>");
			writer.write("<td class='pass'>&nbsp;Tests Passed&nbsp;:</td>");

			// entry for pass test cases count
			writer.write("<td class='pass'> " + passTestCasesCount + "</td> ");
			writer.write("<td class='fail'>&nbsp;Tests Failed&nbsp;:</td>");

			// entry for fail test cases count
			writer.write("<td class='fail'> " + failTestCasesCount + "</td> ");
			writer.write("</tr>");
			writer.write("</tfoot>");
			writer.write("</table> ");

			writer.close();
		} catch (Exception e) {

		}
	}

	
	private static String dateTime() {
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"dd-MM-yyyy HH:mm:ss a");
		String formattedDate = formatter.format(todaysDate);
		return formattedDate;

	}

	private static String getTime() {
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss a");
		String formattedDate = formatter.format(todaysDate);
		return formattedDate;

	}

	// return time


	public void calculateTestCaseStartTime() {
		TestResult.iStartTime.put(this.deviceContext,
				System.currentTimeMillis());
	}

	/***
	 * This method is supposed to be used in the @AfterMethod to calculate the
	 * total test case execution time to show in Reports by taking the start
	 * time from the calculateTestCaseStartTime method.
	 */
	public void calculateTestCaseExecutionTime() {
		TestResult.iEndTime
				.put(this.deviceContext, System.currentTimeMillis());
		Long iExecutionTimeValue = TestResult.iEndTime.get(this.deviceContext)
				- TestResult.iStartTime.get(this.deviceContext);
		TestResult.iExecutionTime.put(this.deviceContext, iExecutionTimeValue);
		long execTimeInSecs = TimeUnit.MILLISECONDS
				.toSeconds(TestResult.iExecutionTime.get(this.deviceContext));
		String testCaseName = TestResult.tc_name.get(this.deviceContext);
		Map<String, String> mapTCExecTime = TestResult.executionTime
				.get(this.deviceContext);
		if (mapTCExecTime == null) {
			mapTCExecTime = new HashMap<String, String>();
		}
		mapTCExecTime.put(testCaseName, String.valueOf(execTimeInSecs));
		TestResult.executionTime.put(this.deviceContext, mapTCExecTime);

	}

	/***
	 * This method is supposed to be used in the @BeforeSuite in-order trigger
	 * the Suite Start Time which inturn used to calculate the Total Suite
	 * execution time to show in Reports.
	 */
	public void calculateSuiteStartTime() {

		TestResult.iSuiteStartTime.put(this.deviceContext,
				System.currentTimeMillis()); // Newly added
	}

	/***
	 * This method is supposed to be used in the @AfterMethod to calculate the
	 * total suite execution time to show in Reports by taking the suite start
	 * time from the calculateSuiteStartTime method.
	 */
	public void calculateSuiteExecutionTime() {

		TestResult.iSuiteEndTime.put(this.deviceContext,
				System.currentTimeMillis()); // Newly added
		double dblSuiteexecTime = (TestResult.iSuiteEndTime
				.get(this.deviceContext) - TestResult.iSuiteStartTime
				.get(this.deviceContext)) / 1000.000;
		Double DoubleSuiteExecTime = new Double(dblSuiteexecTime);
		TestResult.iSuiteExecutionTime.put(this.deviceContext,
				DoubleSuiteExecTime);
	}

	
	private static String makeUniqueImagePath(String fileName) {
		String newFileName = fileName;
		try {
			// Verifying if the file already exists, if so append the numbers
			// 1,2 so on to the fine name.

			File myPngImage = new File(fileName);
			int counter = 1;
			while (myPngImage.exists()) {
				newFileName = fileName + "_" + counter;
				myPngImage = new File(newFileName);
				counter++;
			}
			return newFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return newFileName;
		}
	}

	

	public void initTestCase(String packageName, String testCaseName,
			String testCaseDescription, boolean appendTestCaseResult) {
		TestResult.tc_name.put(this.deviceContext, testCaseName + "-");
		TestResult.packageName.put(this.deviceContext, packageName);
		this.testHeader(TestResult.tc_name.get(this.deviceContext),
				appendTestCaseResult);
		TestResult.stepNum.put(deviceContext, 0);
		TestResult.PassNum.put(deviceContext, 0);
		TestResult.FailNum.put(deviceContext, 0);
		TestResult.testName.put(deviceContext, testCaseName);
		this.calculateTestCaseStartTime();
		if (testCaseDescription != null) {
			this.initTestCaseDescription(testCaseDescription);
		}
	}

	public void initTestCaseDescription(String testCaseDescription) {
		if (testCaseDescription != null) {
			Map<String, String> mapTestDescription = TestResult.testDescription
					.get(this.getDeviceContext());
			if (mapTestDescription == null) {
				mapTestDescription = new HashMap<String, String>();

			}
			mapTestDescription.put(TestResult.tc_name.get(this.deviceContext),
					testCaseDescription);
			TestResult.testDescription.put(this.deviceContext,
					mapTestDescription);
		}
	}

	
	
	
	
	
	
	
	
	public void onInfo(String strStepName, String strStepDes,String filename) throws Exception 
	
	{
		String sStepName = strStepName;
		String sStepDes = strStepDes;
		
		fileName = this.filePath() + File.separatorChar
				+ ReporterConstants.FOLDER_SCREENRSHOTS
				+ File.separatorChar + strStepName + ".jpeg";

		fileName = makeUniqueImagePath(fileName);
		// FileUtils.copyFile(new File(filename), new File(fileName));
		String href = "./"
                  + fileName
                                .substring(
                                              fileName.indexOf(ReporterConstants.FOLDER_SCREENRSHOTS),
                                              fileName.length());
		String imgSrc = "'." + File.separatorChar
                  + ReporterConstants.FOLDER_SCREENRSHOTS + File.separatorChar
                  + this.getFileName(ReporterConstants.LOCATION_TEST_PASSED_LOGO)
                  + "'";
		Writer writer = null;
		try 
		{
            File file = new File(this.filePath() + File.separatorChar
                         + TestResult.strTestName.get(this.deviceContext)
                         + "_Results" +
                         /* + TestResult.timeStamp + */".html");// "SummaryReport.html"

            writer = new FileWriter(file, true);
            Integer stepNumValue = TestResult.stepNum.get(this.deviceContext);
            if (stepNumValue != null) 
            {
                  TestResult.stepNum.put(this.deviceContext, stepNumValue + 1);
            }

            writer.write("<tr class='content2' >");
            writer.write("<td>" + TestResult.stepNum.get(this.deviceContext)
                         + "</td> ");
            writer.write("<td class='justified'>" + sStepName + "</td>");
            writer.write("<td class='justified'>" + strStepDes + "</td> ");

            Integer passNumValue = TestResult.PassNum.get(this.deviceContext);
            if (passNumValue != null) {
				TestResult.PassNum.put(this.deviceContext, passNumValue + 1);
			}
            
            writer.write("<td class='Pass' align='center'><a  href='"
                         + href
                         + "'"
                         + " alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img  src="
                         + imgSrc + "height='18'/></a></td>");

            String strPassTime = CReporter.getTime();
				writer.write("<td><small>" + strPassTime + "</small></td> ");
				writer.write("</tr> ");
				writer.close();
            String strPackageName = TestResult.packageName
                         .get(this.deviceContext);
            String strTcName = TestResult.tc_name.get(this.deviceContext);
            if (!TestResult.mapDeviceContextTestCaseRef
                         .get(this.deviceContext)
                         .get(strPackageName + ":" + strTcName).equals("PASS")) {
                  TestResult.mapDeviceContextTestCaseRef
                                .get(this.deviceContext).put(
                                              strPackageName + ":" + strTcName, "FAIL");
            }
     } catch (Exception e) {
            LOG.info("Exception Encountered : " + e.getMessage());
            e.printStackTrace();
     }

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void onInfo1(String strStepName1, String strStepDes1,
			String filename) throws Exception {
fileName = this.filePath() + File.separatorChar+ ReporterConstants.FOLDER_SCREENRSHOTS+ File.separatorChar + strStepName1 + ".jpeg";
fileName = makeUniqueImagePath(fileName);
FileUtils.copyFile(new File(filename), new File(fileName));
String href = "./"	+ fileName.substring(fileName.indexOf(ReporterConstants.FOLDER_SCREENRSHOTS),fileName.length());
String imgSrc = "'." + File.separatorChar+ ReporterConstants.FOLDER_SCREENRSHOTS + File.separatorChar + this.getFileName(ReporterConstants.LOCATION_FAILED_LOGO)
				+ "'";
		Writer writer = null;
		try {
			File file = new File(this.filePath() + File.separatorChar
					+ TestResult.strTestName.get(this.deviceContext)
					+ "_Results" +
					/* + TestResult.timeStamp + */".html");// "SummaryReport.html"

			writer = new FileWriter(file, true);
			Integer stepNumValue = TestResult.stepNum.get(this.deviceContext);
			if (stepNumValue != null) {

				TestResult.stepNum.put(this.deviceContext, stepNumValue + 1);
			}

			writer.write("<tr class='content2' >");
			writer.write("<td>" + TestResult.stepNum.get(this.deviceContext)
					+ "</td> ");
			writer.write("<td class='justified'>" + strStepName1 + "</td>");
			writer.write("<td class='justified'>" + strStepDes1 + "</td> ");

			Integer failNumValue = TestResult.FailNum.get(this.deviceContext);
			if (stepNumValue != null) {

				TestResult.FailNum.put(this.deviceContext, failNumValue + 1);
			}

			// New Screen shot code to avoid overriding \\\\
			writer.write("<td class='Fail' align='center'><a  href='"
					+ href
					+ "'"
					+ " alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img  src="
					+ imgSrc + "height='18'/></a></td>");

			String strFailTime = CReporter.getTime();
			writer.write("<td><small>" + strFailTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();
			String strPackageName = TestResult.packageName
					.get(this.deviceContext);
			String strTcName = TestResult.tc_name.get(this.deviceContext);
			if (!TestResult.mapDeviceContextTestCaseRef
					.get(this.deviceContext)
					.get(strPackageName + ":" + strTcName).equals("PASS")) {
				TestResult.mapDeviceContextTestCaseRef
						.get(this.deviceContext).put(
								strPackageName + ":" + strTcName, "FAIL");
			}
		} catch (Exception e) 
		{
			LOG.info("Exception Encountered : " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	public void updateTestCaseStatus() {
		if (TestResult.FailNum.get(this.deviceContext) != 0) {
			Integer failCount = TestResult.failCounter.get(this.deviceContext) == null ? 1
					: TestResult.failCounter.get(this.deviceContext) + 1;
			TestResult.failCounter.put(this.deviceContext, failCount);
			Map<String, String> mapResult = TestResult.testResults
					.get(this.deviceContext);
			if (mapResult == null) {
				mapResult = new HashMap<String, String>();
			}
			mapResult.put(TestResult.tc_name.get(this.deviceContext),
					ReporterConstants.TEST_CASE_STATUS_FAIL);
			TestResult.testResults.put(this.deviceContext, mapResult);
		} else {
			Integer passCount = TestResult.passCounter.get(this.deviceContext) == null ? 1
					: TestResult.passCounter.get(this.deviceContext) + 1;
			TestResult.passCounter.put(this.deviceContext, passCount);
			Map<String, String> mapResult = TestResult.testResults
					.get(this.deviceContext);
			if (mapResult == null) {
				mapResult = new HashMap<String, String>();
			}
			mapResult.put(TestResult.tc_name.get(this.deviceContext),
					ReporterConstants.TEST_CASE_STATUS_PASS);
			TestResult.testResults.put(this.deviceContext, mapResult);
		}
	}

}
