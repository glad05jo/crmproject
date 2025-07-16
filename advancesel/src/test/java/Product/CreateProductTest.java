
package Product;
//passed

import org.testng.annotations.Test;
import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Pom_Rep.CreateProductPage;
import Pom_Rep.HomePage;
import Pom_Rep.ProductLookUpPage;
import Pom_Rep.ValidateCampPage;


//Push 1
//pull 1
//push
//branch1
public class CreateProductTest extends BaseClass {
	@Test
	public void CreateProduct() throws Throwable
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
		
	}
	
	public void method1()
	{
		System.out.println("Method 1");
	}

}
