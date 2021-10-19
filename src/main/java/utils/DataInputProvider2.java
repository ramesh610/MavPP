package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import wrappers.GenericWrappers;
//import wrappers.GenericWrappers1;
//import wrappers.GenericWrappers1;

//public class DataInputProvider2 extends GenericWrappers {

	public class DataInputProvider2  {

	public static String[][] getSheet(String dataSheetName,int sheetNumber,int colcountarraysize,int endrow,int startrownum,int rowcountarraysize) {
//, int rowCount, int startRowNum
		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(new File("./data/"+dataSheetName+".xlsx"));
			
			
			
			//FileInputStream fis = new FileInputStream(new File("E:/Ramesh pendrive/Aish/POM/data/TC0021_InsLogin.xlsx"));  // for jenkins
			
		//	FileInputStream fis = new FileInputStream(new File("E:\\Ramesh pendrive\\Aish\\POM\\data\\TC0021_InsLogin.xlsx"));  // WORKS OF POM.XML
			
		//	FileInputStream fis = new FileInputStream(new File("E:/Ramesh pendrive/Aish/POM/data/"+dataSheetName+".xlsx"));
			
			//HSSFWorkbook workbook = new HSSFWorkbook(fis);
			//HSSFSheet sheet = workbook.getSheetAt(sheetNumber);	
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(sheetNumber);	
			
			data = new String[rowcountarraysize][colcountarraysize];


			// loop through the rows
			int k=0;
			for(int i=startrownum; i <=endrow; i++){
				
				try {
					//HSSFRow row = sheet.getRow(i);
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <colcountarraysize; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
								//System.out.println(" the cell values are "+cellValue);
								
								/*if (cellValue.equalsIgnoreCase("xxx")){
									System.out.println("the value is correct");
								}*/
							}catch(NullPointerException e){

							}

							data[k][j]  = cellValue; // add to the data array
						} catch (Exception e) {
 							e.printStackTrace();
						}				
					}k++;

				} catch (Exception e) {
 					e.printStackTrace();
				}
			}
			fis.close();

		} catch (Exception e) {
 			e.printStackTrace();
		}

		return data;

	}


}