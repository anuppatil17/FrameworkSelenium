package config;

import java.util.HashMap;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.ExcelUtils;

// This Class is only for practice
public class test {

	public static void main(String[] args) throws Exception {

		 HashMap<Integer, String> hmap = new HashMap<Integer, String>();

	      /*Adding elements to HashMap*/
	      hmap.put(12, "Chaitanya");
	      hmap.put(2, "Rahul");
	      hmap.put(7, "Singh");
	      hmap.put(49, "Ajeet");
	      hmap.put(3, "Anuj");
	      String a = hmap.get(3);
	      System.out.println(a);
		
	}
}