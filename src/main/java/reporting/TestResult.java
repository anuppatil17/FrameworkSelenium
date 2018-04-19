package reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestResult {
	
	public static Map<DeviceContext , Integer> stepNum = new LinkedHashMap<DeviceContext, Integer>();
	public static Map<DeviceContext , Integer> PassNum = new LinkedHashMap<DeviceContext, Integer>();
	public static Map<DeviceContext , Integer> FailNum = new LinkedHashMap<DeviceContext, Integer>();
	public static Map<DeviceContext , Integer> passCounter = new LinkedHashMap<DeviceContext, Integer>();
	public static Map<DeviceContext , Integer> failCounter = new LinkedHashMap<DeviceContext, Integer>();
	public static Map<DeviceContext , String> testName = new LinkedHashMap<DeviceContext, String>();
	public static Map<DeviceContext , String> testCaseExecutionTime = new LinkedHashMap<DeviceContext, String>();
	public static Map<DeviceContext,Map<String, String>> testDescription = new LinkedHashMap<DeviceContext,Map<String, String>>();
	public static Map<DeviceContext,Map<String, String>> testResults = new LinkedHashMap<DeviceContext, Map<String,String>>();
	
	/*copied from HtmlReportSupport*/
	
	public static Map<DeviceContext,Long> iStartTime = new LinkedHashMap<DeviceContext,Long>();
	public static Map<DeviceContext,Long> iEndTime = new LinkedHashMap<DeviceContext,Long>();
	public static Map<DeviceContext,Long> iExecutionTime = new LinkedHashMap<DeviceContext,Long>();
	public static Map<DeviceContext,Long> iSuiteStartTime = new LinkedHashMap<DeviceContext,Long>();
	public static Map<DeviceContext,Long> iSuiteEndTime = new LinkedHashMap<DeviceContext,Long>();
	public static Map<DeviceContext,Double> iSuiteExecutionTime = new LinkedHashMap<DeviceContext,Double>();
	public ArrayList<Double> list = new ArrayList<Double>();
	public static Map<DeviceContext,Long> startStepTime = new LinkedHashMap<DeviceContext,Long>();
	public static Map<DeviceContext,Long> endStepTime = new LinkedHashMap<DeviceContext,Long>();
	public static Map<DeviceContext,Double> stepExecutionTime = new LinkedHashMap<DeviceContext,Double>();
	public static Map<DeviceContext,String> strTestName = new LinkedHashMap<DeviceContext,String>();
	public static Map<DeviceContext,String> startedAt = new LinkedHashMap<DeviceContext,String>();
	public static Map<DeviceContext,String> tc_name = new LinkedHashMap<DeviceContext,String>();
	public static Map<DeviceContext,String> packageName = new LinkedHashMap<DeviceContext,String>();
	public static Map<DeviceContext, Map<String,String>> mapDeviceContextTestCaseRef = new LinkedHashMap<DeviceContext,Map <String, String>>();	
	public static Map<DeviceContext,Map<String, String>> executionTime = new LinkedHashMap<DeviceContext,Map<String, String>>();
	
	public String currentSuite = "";
	public int pCount = 0;
	public int fCount = 0;
	

	public static String workingDir = System.getProperty("user.dir").replace(File.separator,"/");;
	public static Map<DeviceContext,Integer> BFunctionNo = new LinkedHashMap<DeviceContext,Integer>();
	
}
