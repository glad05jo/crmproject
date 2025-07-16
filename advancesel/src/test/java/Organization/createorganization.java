package Organization;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utlility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Rep.HomePage;
import Pom_Rep.LoginPage;

public class createorganization {

	public static void main(String[] args) throws Throwable {
		/* FileInputStream fis= new FileInputStream("D:\\QSpider\\advsel\\vtigerlogin.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String Browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String un = pro.getProperty("username");
		String ps = pro.getProperty("password");
		*/
		File_Utlility File = new File_Utlility();
		String Browser = File.getPropertyKeyValue("browser");
		String url = File.getPropertyKeyValue("url");
		String un = File.getPropertyKeyValue("username");
		String ps = File.getPropertyKeyValue("password");
		WebDriver drv;
		if(Browser.equalsIgnoreCase("chrome"))
		{
			drv=new ChromeDriver();
		}
		else
		{
			drv=new FirefoxDriver();
		}
		drv.get(url);
		LoginPage login= new LoginPage(drv);
		login.logintoApp(un, ps);
//		drv.findElement(By.name("user_name")).sendKeys(un);
//		drv.findElement(By.name("user_password")).sendKeys(ps);
//		drv.findElement(By.id("submitButton")).click();
		WebDriver_Utility webdriver = new WebDriver_Utility();
		webdriver.getmaximizewindow(drv);
		webdriver.getimplicitwait(drv);
		String username = drv.findElement(By.xpath("//span[@class='userName']")).getText();
		System.out.println(username);
		if(username.contains("Administrator"))
		{
			System.out.println("Login successfull");
		}
		else
		{
			System.out.println("not login ");
		}
		HomePage homepage=new HomePage(drv);
		homepage.ClickOrganizationsLink();
		//drv.findElement(By.linkText("Organizations")).click();
		drv.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		/*
		Random ran = new Random();
		int annum = ran.nextInt(1000);
		*/
		Java_Utility ju = new Java_Utility();
		int rannum = ju.getRandomNum();
		
		//FileInputStream fis1= new FileInputStream("D:\\QSpider\\advsel\\vtigerproductlist.xlsx");
		//Workbook owb = WorkbookFactory.create(fis1);
		//Sheet osheet = owb.getSheet("Organization");
		//Row orow = osheet.getRow(0);
		//Cell ocell = orow.getCell(0);
		//String oname = ocell.getStringCellValue()+ rannum;
		
		
		Excel_Utility excel = new Excel_Utility();
		String oname = excel.getExcelValue("Organization",0,0)+rannum;
		drv.findElement(By.name("accountname")).sendKeys(oname);
		
		
	//	Row opn = osheet.getRow(0);
	//	Cell opncell = opn.getCell(1);
		//DataFormatter format = new DataFormatter();
		//String opnvaue = format.formatCellValue(opncell);
		
		String opnvaue=excel.getExcelDataFormater("Product", 0, 1);
		drv.findElement(By.id("phone")).sendKeys(opnvaue) ;
		
				
		//Row oemail = osheet.getRow(0);
		//Cell oemailcell = oemail.getCell(2);
		//DataFormatter format1 = new DataFormatter();
	//	String oemailvalue = format1.formatCellValue(oemailcell);
		
		String oemailvalue = excel.getExcelDataFormater("Product", 0,2);
		drv.findElement(By.id("email")).sendKeys(oemailvalue);
		
		drv.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgname = drv.findElement(By.id("dtlview_Organization Name")).getText();
		if(orgname.equalsIgnoreCase(oname))
		{
			System.out.println("created org");
		}
		else
		{
			System.out.println("not created org");
		}
//		drv.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		drv.findElement(By.linkText("Sign Out")).click();
		homepage.logoutapp();
	}

}
