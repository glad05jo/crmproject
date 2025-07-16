package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelfetchread {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("D:\\QSpider\\advsel\\data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet2 = workbook.getSheet("sheet2");
		
		Row row = sheet2.createRow(1);
		
		Cell cell = row.createCell(0);
		
		cell.setCellValue("Excel");
	
		FileOutputStream fos=new FileOutputStream("D:\\QSpider\\advsel\\data.xlsx");
		workbook.write(fos);
		workbook.close();
		
	}

}
