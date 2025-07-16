package Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utlility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Rep.HomePage;
import Pom_Rep.LoginPage;

public class createcontact {

	public static void main(String[] args) throws Throwable {
		
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
		homepage.ClickContactsLink();
		
		//drv.findElement(By.linkText("Contacts")).click();
		drv.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement namedd = drv.findElement(By.name("salutationtype"));
		Select sel=new Select(namedd);
		sel.selectByIndex(2);
		
		Java_Utility ju = new Java_Utility();
		int rannum = ju.getRandomNum();
		
		Excel_Utility excel = new Excel_Utility();
		String cname = excel.getExcelValue("Contacts",0,0)+rannum;
		drv.findElement(By.name("firstname")).sendKeys(cname);
		
		String lastname= excel.getExcelValue("Contacts",0,0);
		drv.findElement(By.name("lastname")).sendKeys(lastname);
		drv.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgname = drv.findElement(By.id("dtlview_First Name")).getText();
		if(orgname.equalsIgnoreCase(lastname))
		{
			System.out.println("created contact");
		}
		else
		{
			System.out.println("not created contact");
		}
//		drv.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		drv.findElement(By.linkText("Sign Out")).click();
		homepage.logoutapp();
	}

}
