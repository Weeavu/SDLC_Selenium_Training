package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static private  Sheet excelWSheet;
	static private  Workbook excelWBook;
	static private String excelFilePath;
	
	//This method is to set the File path and to open the Excel file, 
    //Pass Excel Path and Sheetname as Arguments to this method
	public static void openExcelFile(String path,String sheetName) {
		 try {
		      // Open the Excel file
			  File excel = new File(path);
		      FileInputStream ExcelFile = new FileInputStream(excel);
		      
		      // Access the required test data sheet
		      excelWBook = new XSSFWorkbook(ExcelFile);
		      excelWSheet = excelWBook.getSheet(sheetName);
		            
		 } catch (Exception e){
		      e.printStackTrace();
		 }
	}	
	//This method is to read the test data from the Excel cell
    // in this we are passing parameters as Row num and Col num
    public static String getCellData(int rowNum, int colNum) {
          try{
        	  Cell cell = excelWSheet.getRow(rowNum).getCell(colNum);
              String cellData = cell.toString();
              return cellData;
          }catch (Exception e){
        	  		e.printStackTrace();
                return"";
          }
    }
   
    
   
    
    //This method is to write in the Excel cell, 
    //Row num and Col num are the parameters 
	public static void setCellData(String value,  int rowNum, int colNum) {
           try{
        	   
              Row row = excelWSheet.getRow(rowNum);
              if(row == null) {
            	  row = excelWSheet.createRow(rowNum);
              }
              
              Cell cell = row.getCell(colNum);
              if(cell == null) {
            	  cell = row.createCell(colNum);
              }
              
              cell.setCellValue(value);

              // Constant variables Test Data path and Test Data file name
              FileOutputStream fileOut = new FileOutputStream(excelFilePath);
              excelWBook.write(fileOut);	               
              fileOut.close();
              
            }catch(Exception e){
                 e.printStackTrace();
            }
    }
        
//public static void setCellData(String excelPath, String district, String school) {
//
//Workbook workbook;
//Sheet sheet;
//int rows;
//Cell cell;
//int cols;
//
////public static void main(String[] args) {
//	String excelFilePath = "Schools.xls";
//	
//	//List<String> schools = new ArrayList<String>();
//	//List<String> addresses=new ArrayList<String>();
//	try {
//	
//		for(int i=0; i<20;i++){
//			schools.add(i, "School-"+i);
//		}
//
//		for(int i=0; i<18;i++){
//			addresses.add(i, "Address of school-"+i);
//		}
//		
//		FileInputStream fileInputStream = new FileInputStream(excelFilePath);
//		workbook = WorkbookFactory.create(fileInputStream);
//		sheet = workbook.getSheet("Sheet2");
//		if(sheet.getRow(0)==null){
//			sheet.createRow(0); //if now headers in file are defined				
//		}
//
//		for(int i = 0; i<schools.size(); i++){
//			if (sheet.getRow(i+1)==null) {
//				sheet.createRow(i+1);
//			}
//			cell=sheet.getRow(i+1).getCell(0);
//			
//			if (cell==null) {
//				cell=sheet.getRow(i+1).createCell(0);
//			}
//			
//			cell.setCellValue(schools.get(i));
//		}
//		
//		for(int i = 0; i<addresses.size(); i++){
//			if (sheet.getRow(i+1)==null) {
//				sheet.createRow(i+1);
//			}
//			cell=sheet.getRow(i+1).getCell(1);
//			
//			if (cell==null) {
//				cell=sheet.getRow(i+1).createCell(1);
//			}
//			
//			cell.setCellValue(addresses.get(i));
//		}
//		
//		FileOutputStream outStream = new FileOutputStream(excelFilePath);
//		workbook.write(outStream);
//		outStream.close();
//		workbook.close();
//	System.out.println("printing");
//
//	} catch (Exception e) {
//		System.out.println(e.getStackTrace());
//	}
//
//
//
//}
    	
    	public int getUsedRowsCount(){
    		try{
    			int rowCount = excelWSheet.getPhysicalNumberOfRows();
    			return rowCount;
    		}catch (Exception e){
    			e.printStackTrace();
    			return 0;
    		}

    	}
}

	

