package Generic_Utilities;



import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/** 
	 * This method is used to read data from excel file
	 * @param Sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @author Gladsh
	 */
	public String getExcelValue(String Sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("D:\\QSpider\\advsel\\vtigerproductlist.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(Sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell =row.getCell(cellnum);
		
		String name = cell.getStringCellValue();
		return name;
		}
	
	public String getExcelDataFormater(String Sheetname,int rownum1,int cellnum1) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("D:\\QSpider\\advsel\\vtigerproductlist.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(Sheetname);
		Row opn = sheet.getRow(rownum1);
		Cell opncell = opn.getCell(cellnum1);
		DataFormatter format = new DataFormatter();
		String opnvaue = format.formatCellValue(opncell);
		return opnvaue;
	}

}
