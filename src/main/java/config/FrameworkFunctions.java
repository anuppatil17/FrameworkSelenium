package config;

import java.util.HashMap;
import java.util.Set;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import executionEngine.DriverScript;
import utility.ExcelUtils;

public class FrameworkFunctions

{
	public static String value ="";
	public static DriverScript dr;
	static ExcelUtils ex = new ExcelUtils();

	
	

	public static void LoadOR() throws Throwable {

		DriverScript dr = new DriverScript();
		String sORpath = dr.projectpath + "\\src\\main\\java\\ObjectRepository\\ObjectRepository.xlsm";
		// dr.h
		Workbook workbook1 = ex.setExcelFile1(sORpath);
		int iLastRow = ex.getRowCount("OR", (XSSFWorkbook) workbook1);

		dr.hGlobalOR = new HashMap<String, String>();
		for (int i = 1; i <= iLastRow; i++) {
			try {
				String sName = ex.getCellData(i, 0, "OR", (XSSFWorkbook) workbook1);
				String sBy = ex.getCellData(i, 1, "OR", (XSSFWorkbook) workbook1);
				String svalue = ex.getCellData(i, 2, "OR", (XSSFWorkbook) workbook1);
				String value = sBy + "|" + svalue;
				dr.hGlobalOR.put(sName, value);
				// System.out.println(hmap.get(sName));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(dr.hGlobalOR.size());
		Set<String> keys = dr.hGlobalOR.keySet();
		for (String key : keys) {
			//System.out.println(key);
		}
		//System.out.println("Done");
	}
	
	public static String OR(String key) throws NoSuchMethodException, SecurityException {
		dr = new DriverScript();
	value = dr.hGlobalOR.get(key);
	return value;
	
}
}
