package utilty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData extends Utility {
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFCell cell;
	
	Properties prop=new Properties();
	
	/*
	 * Method to initialize Excel sheet and get Cell data
	 * Created by : Benarji Enamandala
	 * 
	 */
	 public  void getExcelData() throws IOException {
		 try {
			 prop = propFile(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
			 String excelFilePath=System.getProperty("user.dir")+prop.getProperty("excelpath");
			 String sheetName=prop.getProperty("sheetname");
		       File file =    new File(excelFilePath);
		       FileInputStream inputStream = new FileInputStream(file);
		      workbook=new XSSFWorkbook(inputStream);
		       //creating a Sheet object
		        sheet=workbook.getSheet(sheetName);
	
		 }catch (Exception e) {
			// TODO: handle exception
		}
		 }
	 

		/*
		 * Method to get Excel Data and get Cell data
		 * Attributes : text =Cell name to retrive data
		 * Created by : Benarji Enamandala
		 * 
		 */ 
	 	public String getData(String text) {
	 		String testData=null;
			 try {
				 getExcelData();
		       //getting the cell value from rowNumber and cell Number
		       int  rcount=sheet.getPhysicalNumberOfRows();
		       for (int i=0;i<rcount;i++) {
		    	   if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(text)) {
		    		  testData= sheet.getRow(i).getCell(1).getStringCellValue();
		    	   }
		       }
		        //returning the cell value as string
		    	}catch (Exception e) {
		    		e.printStackTrace();
					
				}
		        return testData;
		       
		    }

}
