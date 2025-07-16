package Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utlility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Rep.CreateContactPage;
import Pom_Rep.HomePage;
import Pom_Rep.LoginPage;
import Pom_Rep.ValidateCampPage;

public class CreateContactest extends BaseClass {

	
	@Test
	public void CreateContactTest () throws Throwable
	{
	HomePage homepage=new HomePage(drv);
	homepage.ClickContactsLink();
	
	CreateContactPage contact = new CreateContactPage(drv);
	contact.getcontactimage().click();
	
	WebElement namedd = contact.getsalutationtype();
	Select sel=new Select(namedd);
	sel.selectByIndex(2);
	
	Java_Utility ju = new Java_Utility();
	int rannum = ju.getRandomNum();
	
	Excel_Utility excel = new Excel_Utility();
	String cname = excel.getExcelValue("Contacts",0,0)+rannum;
	
	contact.getfirstname().sendKeys(cname);
	//drv.findElement(By.name("firstname")).sendKeys(cname);
	
	String lastname= excel.getExcelValue("Contacts",0,0);
	contact.getlastname().sendKeys(lastname);
	//drv.findElement(By.name("lastname")).sendKeys(lastname);
	
	
	contact.getSavecontactname();
	
	
//	ValidateCampPage contact1 = new ValidateCampPage(drv);
//	contact1.validatecontact(drv,lastname);
	
	homepage.logoutapp();
}

}
