package Product;
//passed
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utlility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Rep.CreateProductPage;
import Pom_Rep.DeletePrdt;
import Pom_Rep.HomePage;
import Pom_Rep.LoginPage;
import Pom_Rep.ProductLookUpPage;
import Pom_Rep.ValidateCampPage;

public class DeleteProductTest extends BaseClass {
	@Test
	public void DeleteProduct() throws Throwable
	{
		HomePage homepage=new HomePage(drv);
		homepage.ClickProductLink();
		
		ProductLookUpPage prdtlookup =new ProductLookUpPage(drv);
		prdtlookup.clickprdtLookup();
		
		Java_Utility ju = new Java_Utility();
		int rannum = ju.getRandomNum();
		
		Excel_Utility excel = new Excel_Utility();
		String Productvalue = excel.getExcelValue("Product", 0, 0)+rannum;
			
		CreateProductPage prdtpage= new CreateProductPage(drv);
		prdtpage.createprdt(Productvalue);
		
		ValidateCampPage prdtpgname= new ValidateCampPage(drv);
		prdtpgname.validateproduct(drv, Productvalue);
		
		homepage.ClickProductLink();
		
		DeletePrdt delectprdt =	new DeletePrdt(drv);
		delectprdt.clickdelete();
		
		WebDriver_Utility alert = new WebDriver_Utility();
		alert.alertHandle(drv);
		
		homepage.logoutapp();		
	}

}
