package Pom_Rep;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ValidateCampPage {

	public ValidateCampPage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);
	}
	
	public void validatecamppage(WebDriver drv,String campage)
	{
		String campage1 = drv.findElement(By.linkText("Campaigns")).getText();
//		if(campage1.equals("Campaigns"))
//		{
//			System.out.println("campaign page displayed");
//		}
//		else
//		{
//			System.out.println("campaign page not displayed");
//		}
//		
		assertEquals(campage,campage1,"campaign page not displayed");
		System.out.println("campaign page  displayed");
		
	}
	public void validateproduct(WebDriver drv,String Productvalue)
	{
		String uploadedprdt = drv.findElement(By.id("dtlview_Product Name")).getText();
//		if(uploadedprdt.equals(Productvalue))
//		{
//			System.out.println("Product created ");
//		}
//		else
//		{
//			System.out.println("Product not created");
//		}
	SoftAssert soft = new SoftAssert();
	soft.assertEquals(Productvalue, uploadedprdt,"Product not created" );
	
	System.out.println("Product created ");
	soft.assertAll();
	}
	public void validateorg(WebDriver drv,String oname)
	{
		
	String orgname = drv.findElement(By.id("dtlview_Organization Name")).getText();
//		if(orgname.equalsIgnoreCase(oname))
//		{
//			System.out.println("created org");
//		}
//		else
//		{
//			System.out.println("not created org");
//		}
	assertEquals(oname,orgname,"not created org");
	System.out.println("created org");
	
	}
	public void validatecontact(WebDriver drv,String lastname)
	{
		
		String contactname = drv.findElement(By.id("dtlview_First Name")).getText();
		assertEquals(contactname,lastname,"not created org");
		System.out.println("created org");
		
	}
}
