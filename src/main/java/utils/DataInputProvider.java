package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataInputProvider extends wrappers.GenericWrappers {

	//public static Object cellValue;

	public static String[][] getSheet(String dataSheetName , String sh  ) {

		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(new File("./data/"+dataSheetName+".xlsx"));
		//	FileInputStream fis = new FileInputStream(new File("E:/Aish/POM/data/"+dataSheetName+".xlsx"));
			
			
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//XSSFSheet sheet = workbook.getSheetAt(0);	
			
		//Ramesh to refer the required sheet .getSheet(sh)
			
			XSSFSheet sheet = workbook.getSheet(sh);
			
			// get the number of rows
			int rowCount = sheet.getLastRowNum();
			
			
			
			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];


			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							

							try{
								cellValue = row.getCell(j).getStringCellValue();
								
								System.out.println(" cell count"+cellValue);
								
							}catch(NullPointerException e){

							}

							
							
							data[i-1][j]  = cellValue; // add to the data array
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
//						XSSFCell cellvalue1;
	//					cellvalue1= sheet.getRow(1).getCell(0);
		//				System.out.println(" the vaaaaaaa" +cellvalue1);
					}
					

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fis.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}

}
