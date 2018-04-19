package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import config.Constants;
import executionEngine.DriverScript;

    public class ExcelUtils {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                public static  XSSFWorkbook workbook;
                private static org.apache.poi.ss.usermodel.Cell Cell;
                private static XSSFRow Row;
                //private static XSSFRow Row;
           
            public static void setExcelFile(String Path) throws Exception {
            	try {
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    
            	} catch (Exception e){
            		Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
            		new DriverScript().bResult = false;
                	}
            	}
            
            public static XSSFWorkbook setExcelFile1(String Path) throws Exception {
            	try {
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    workbook = new XSSFWorkbook(ExcelFile);
                   // xDriverSheet = workbook;
                    return workbook;
            	} 
            	catch (Exception e)
            	{
            		Log.error("Class Utils | Method setExcelFile | Exception desc : "+e.getMessage());
            		new DriverScript().bResult = false;
            		workbook = null;
            		return workbook;
                	}
            	}
            
            
            
            
            
            public static String getCellData(int RowNum, int ColNum, String SheetName ) throws Exception{
                try{
                	ExcelWSheet = ExcelWBook.getSheet(SheetName);
                   	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                    String CellData = Cell.getStringCellValue();
                    return CellData;
                 }catch (Exception e){
                     Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
                 	new DriverScript().bResult = false;
                     return"";
                     }
                 }
            
            public static String getCellData(int RowNum, int ColNum, String SheetName, XSSFWorkbook workbook ) throws Exception{
                try{
                	ExcelWSheet = workbook.getSheet(SheetName);
                   	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                    String CellData = Cell.getStringCellValue();
                    return CellData;
                 }catch (Exception e){
                     Log.error("Class Utils | Method getCellData | Exception desc : "+e.getMessage());
                 	new DriverScript().bResult = false;
                     return"";
                     }
                 }
            
            
        	
        	public static int getRowCount(String SheetName)throws Exception{
        		int iNumber=0;
        		try {
        			ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			iNumber=ExcelWSheet.getLastRowNum()+1;
        			
  
        			
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
        			new DriverScript().bResult = false;
        			}
        		return iNumber;
        		}
        	
        	public static int getRowCount(String SheetName, XSSFWorkbook workbook)throws Exception{
        		int iNumber=0;
        		try {
        			ExcelWSheet = workbook.getSheet(SheetName);
        			iNumber=ExcelWSheet.getLastRowNum()+1;
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
        			new DriverScript().bResult = false;
        			}
        		return iNumber;
        		}
        	
        	
        	public static int getColCount(String SheetName, int row)throws Exception{
        		int iNumber=0;
        		try {
        			ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			iNumber = ExcelWSheet.getRow(row).getLastCellNum();
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
        			new DriverScript().bResult = false;
        			}
        		return iNumber;
        		}
        	
        	
        	
        	
        	public static int getRowContains(String sTestCaseName, int colNum,String SheetName) throws Exception{
        		int iRowNum=0;	
        		try {
        		    //ExcelWSheet = ExcelWBook.getSheet(SheetName);
        			int rowCount = ExcelUtils.getRowCount(SheetName);
        			for (; iRowNum<rowCount; iRowNum++){
        				if  (ExcelUtils.getCellData(iRowNum,colNum,SheetName).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}       			
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
        			new DriverScript().bResult = false;
        			}
        		return iRowNum;
        		}
        	
        	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
        		try {
	        		for(int i=iTestCaseStart;i<=ExcelUtils.getRowCount(SheetName);i++){
	        			if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
	        				int number = i;
	        				return number;      				
	        				}
	        			}
	        		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	        		int number=ExcelWSheet.getLastRowNum()+1;
	        		return number;
        		} catch (Exception e){
        			Log.error("Class Utils | Method getRowContains | Exception desc : "+e.getMessage());
        			new DriverScript().bResult = false;
        			return 0;
                }
        	}
        	
        	@SuppressWarnings("static-access")
        	public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName,String datasheetloc) throws Exception    {
                   try{
                	   
                	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
                       Row  = ExcelWSheet.getRow(RowNum);
                       Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
                       if (Cell == null) {
                    	   Cell = Row.createCell(ColNum);
                    	   Cell.setCellValue(Result);
                    	   
                        } else {
                            Cell.setCellValue(Result);
                        }
                         FileOutputStream fileOut = new FileOutputStream(datasheetloc);
                         
                         XSSFFormulaEvaluator.evaluateAllFormulaCells(ExcelWBook);
                         //FormulaEvaluator evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
                         
                         // suppose your formula is in B3
                         /*CellReference cellReference = new CellReference("E295"); 
                        Row = ExcelWSheet.getRow(cellReference.getRow());
                         Cell = Row.getCell(cellReference.getCol());  
                         CellValue cellValue = evaluator.evaluate(Cell);*/
                         //evaluator.evaluateAll();
                         ExcelWBook.write(fileOut);
                         
                         // Added by vikram 
                         
                        // XSSFFormulaEvaluator.evaluateAllFormulaCells(ExcelWBook);
                         
                         
                         
                         //fileOut.flush();
                         //fileOut.close();
                         ExcelWSheet=null;
                         ExcelWBook=null;
                         
                         ExcelWBook = new XSSFWorkbook(new FileInputStream(datasheetloc));
                     }
                   catch(Exception e)
                   {
                    		new DriverScript().bResult = false;
              
                     }
                }

        	
        	
        	
        	public static void setCellData1(String Result,  int RowNum, int ColNum, String SheetName,String datasheetloc) throws Exception    {
                try{
             	   
             	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    Row  = ExcelWSheet.getRow(RowNum);
                    Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
                    if (Cell == null) {
                 	   Cell = Row.createCell(ColNum);
                 	   Cell.setCellValue(Result);
                     } else {
                         Cell.setCellValue(Result);
                     }
                      FileOutputStream fileOut = new FileOutputStream(datasheetloc);
                      //FormulaEvaluator evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
                      
                      // suppose your formula is in B3
                      /*CellReference cellReference = new CellReference("E295"); 
                     Row = ExcelWSheet.getRow(cellReference.getRow());
                      Cell = Row.getCell(cellReference.getCol());  
                      CellValue cellValue = evaluator.evaluate(Cell);*/
                      //evaluator.evaluateAll();
                      ExcelWBook.write(fileOut);
                      
                      // Added by vikram 
                      
                     // XSSFFormulaEvaluator.evaluateAllFormulaCells(ExcelWBook);
                      
                      
                      
                      //fileOut.flush();
                      //fileOut.close();
                      ExcelWSheet=null;
                      ExcelWBook=null;
                      
                      ExcelWBook = new XSSFWorkbook(new FileInputStream(datasheetloc));
                  }
                catch(Exception e)
                {
                 		new DriverScript().bResult = false;
           
                  }
             }

        	
        	
    	}