package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class iinsertingdataexcel {

	public static void main(String[] args) throws Throwable{
		FileInputStream fis=new FileInputStream("./src/test/resources/Login.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.createRow(5);
		Cell cell = row.createCell(2);
		cell.setCellValue("hello");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Login.xlsx");
		wb.write(fos);
		wb.close();
		
	}
 
}
