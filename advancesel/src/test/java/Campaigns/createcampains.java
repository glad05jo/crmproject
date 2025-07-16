package Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utlility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Rep.CampLookUpImgPage;
import Pom_Rep.CreateCampPage;
import Pom_Rep.HomePage;
import Pom_Rep.LoginPage;
import Pom_Rep.ValidateCampPage;

public class createcampains {

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
		
//		drv.findElement(By.name("user_name")).sendKeys(un);
//		drv.findElement(By.name("user_password")).sendKeys(ps);
//		drv.findElement(By.id("submitButton")).click();
//		
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
		homepage.ClickMoreLink();
		homepage.ClickCampaignsLink();
//		drv.findElement(By.linkText("More")).click();
//		drv.findElement(By.name("Campaigns")).click();
		
	
		//drv.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		CampLookUpImgPage camplookup = new CampLookUpImgPage(drv);
		camplookup.clickcamplookupimg();
	
		Java_Utility ju = new Java_Utility();
		int rannum = ju.getRandomNum();
		Excel_Utility excel = new Excel_Utility();
		String exceldata = excel.getExcelValue("Campaign", 0, 0)+rannum;
//		drv.findElement(By.name("campaignname")).sendKeys(exceldata);
//		drv.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		CreateCampPage createcamp =new CreateCampPage(drv);
		createcamp.getCampname();
		createcamp.savecampname();
		
		ValidateCampPage validatecamppg =new ValidateCampPage(drv);
		validatecamppg.validatecamppage(drv, exceldata);
		
	//WebDriver_Utility web = new WebDriver_Utility();
		//web.windowswitching(drv,"product");
		drv.findElement(By.className("crmButton small save")).click();
		homepage.logoutapp();
	}

}
