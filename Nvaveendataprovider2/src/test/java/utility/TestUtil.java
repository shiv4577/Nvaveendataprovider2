package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	 public static Workbook book;
	 public static Sheet sheet;
	public static String sheetpath= "E:\\All Selenium Workspace\\Think-App\\Nvaveendataprovider2\\src\\test\\resources\\Excel\\TestData.xlsx";
	
	public static Object[][]  getTestData(String RegisterTestCase) throws InvalidFormatException, IOException {
		FileInputStream file=null;
		
		 file= new FileInputStream ("E:\\All Selenium Workspace\\Think-App\\Nvaveendataprovider2\\src\\test\\resources\\Excel\\TestData.xlsx");
		 
		  book = WorkbookFactory.create(file);
		  
		   sheet=book.getSheet(RegisterTestCase);
		   
		   Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		   for(int i=0;i<sheet.getLastRowNum();i++) {
			   for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				   data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			   }
		   }
		   return data;
	}
}
