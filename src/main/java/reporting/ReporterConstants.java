package reporting;

public interface ReporterConstants 
{
    String configReporterFile = "resources/ProjectReporter.properties";
	
 	
	/*Test case status as pass*/
	String TEST_CASE_STATUS_PASS = "PASS";
	/*Test case status as fail*/
	String TEST_CASE_STATUS_FAIL = "FAIL";
	/*ReportFormat*/
	String REPORT_FORMAT = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "reportFormat");
	/*#location of result*/
	String LOCATION_RESULT = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationResult");
	/*screenshot folder*/
	String FOLDER_SCREENRSHOTS = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "folderScreenShot");
	/*client logo*/
	String LOCATION_CLIENT_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationClientLogo");
	/*#company logo*/
	String LOCATION_COMPANY_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationCompanyLogo");
	/*#failed logo*/
	String LOCATION_FAILED_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationFailedLogo");
	/*#location minus logo*/
	String LOCATION_MINUS_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationMinusLogo");
	/*#location passed logo*/
	String LOCATION_PASSED_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationPassedLogo");
	/*#location plus logo*/
	String LOCATION_PLUS_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationPlusLogo");
	/*#location warning logo*/
	String LOCATION_WARNING_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationWarningLogo");
	/*#location Test passed logo*/
    String LOCATION_TEST_PASSED_LOGO = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationTestPassedLogo");

	/*screen shot to be taken if test step is pass */
	Boolean BOOLEAN_ONSUCCESS_SCREENSHOT = Boolean.parseBoolean(ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "onSuccessScreenshot"));
	/*css folder*/
	String LOCATION_JQUERY_CSS_FOLDER = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationCssFolder");
	/*js folder*/
	String LOCATION_JQUERY_JS_FOLDER = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationJsFolder");
	/*locationImagesFolder*/
	String LOCATION_JQUERY_IMAGES_FOLDER = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "locationImagesFolder");
	
	/*piechart
	String pieChart = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "pieChart");
	bargraph
	String barGraph = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "barGraph");
	linechart
	String lineChart = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "lineChart");*/
}
