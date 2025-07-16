package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utlility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Rep.DeletePrdt;
import Pom_Rep.HomePage;
import Pom_Rep.LoginPage;
import Pom_Rep.ProductLookUpPage;
import Pom_Rep.ValidateCampPage;

public class deleteproduct {

	public static void main(String[] args) throws Throwable {
		File_Utlility File = new File_Utlility();
		String Browser = File.getPropertyKeyValue("browser");
		String url = File.getPropertyKeyValue("url");
		String un = File.getPropertyKeyValue("username");
		String ps = File.getPropertyKeyValue("password");
		
		WebDriver drv;
		if(Browser.contains("chrome"))
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
		//drv.findElement(By.name("user_name")).sendKeys(un);
		//drv.findElement(By.name("user_password")).sendKeys(ps);
		//drv.findElement(By.id("submitButton")).click();
		
		WebDriver_Utility webdriver = new WebDriver_Utility();
		webdriver.getmaximizewindow(drv);
		webdriver.getimplicitwait(drv);
		
		
		String adminusername = drv.findElement(By.xpath("//span[@class='userName']")).getText();
		System.out.println(adminusername);
		if(adminusername.contains("Administrator"))
		{
			System.out.println("Login successfull");
		}
		else
		{
			System.out.println("not login ");
		}
		 
		HomePage homepage=new HomePage(drv);
		homepage.ClickProductLink();
		//drv.findElement(By.linkText("Products")).click();
		
		ProductLookUpPage prdtlookup =new ProductLookUpPage(drv);
		prdtlookup.clickprdtLookup();
		
		//drv.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_Utility ju = new Java_Utility();
		int rannum = ju.getRandomNum();
		
		Excel_Utility excel = new Excel_Utility();
		String Productvalue = excel.getExcelValue("Product", 0, 0)+rannum;
		
		drv.findElement(By.name("productname")).sendKeys(Productvalue);
		drv.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		String uploadedprdt = drv.findElement(By.id("dtlview_Product Name")).getText();
//		if(uploadedprdt.equals(Productvalue))
//		{
//			System.out.println("Product created ");
//		}
//		else
//		{
//			System.out.println("Product not created");
//		}
		
		ValidateCampPage prdtpgname= new ValidateCampPage(drv);
		prdtpgname.validateproduct(drv, Productvalue);
		
//		drv.findElement(By.linkText("Products")).click();
//	
//		drv.findElement(By.name("selectall")).click();//delete all product
//		
//		drv.findElement(By.xpath("//input[@value='Delete']")).click();
		
		DeletePrdt delectprdt =	new DeletePrdt(drv);
		delectprdt.clickdelete();
		
		WebDriver_Utility alert = new WebDriver_Utility();
		alert.alertHandle(drv);
//		drv.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		drv.findElement(By.linkText("Sign Out")).click();
		homepage.logoutapp();
		

	}

}
