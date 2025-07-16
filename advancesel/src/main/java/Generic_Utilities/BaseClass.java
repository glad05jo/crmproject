package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Pom_Rep.HomePage;
import Pom_Rep.LoginPage;

public class BaseClass {
public WebDriver drv;

	@BeforeSuite(groups={"smoke test","Regression test"})
	public void BS()
	{
		System.out.println("Database connection");
	}
	
	@BeforeTest(groups={"smoke test","Regression test"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	//@Parameters("Browser")
	
//	public void BC(String Browser) throws Throwable
//	{
	@BeforeClass(groups={"smoke test","Regression test"})
		public void BC() throws Throwable
		{
		File_Utlility File = new File_Utlility();
		String Browser = File.getPropertyKeyValue("browser");
		if(Browser.contains("chrome"))
		{
			drv=new ChromeDriver();
		}
		else
		{
			drv=new FirefoxDriver();
		}
		
		System.out.println("Browser launching done");
	}
	
	//@Parameters("url")
	@BeforeMethod(groups={"smoke test","Regression test"})
//	public void BM(String url) throws Throwable
//	{
		public void BM() throws Throwable
		{
		File_Utlility File = new File_Utlility();
		String url = File.getPropertyKeyValue("url");
		String un = File.getPropertyKeyValue("username");
		String ps = File.getPropertyKeyValue("password");
		
		drv.get(url);
		LoginPage login= new LoginPage(drv);
		login.logintoApp(un, ps);
		
		WebDriver_Utility webdriver = new WebDriver_Utility();
		webdriver.getmaximizewindow(drv);
		webdriver.getimplicitwait(drv);
		
		System.out.println("Login Application");
	}
	
	@AfterMethod(groups={"smoke test","Regression test"})
	public void AM()
	{
		HomePage homepage=new HomePage(drv);
		homepage.logoutapp();
		System.out.println("Logout Application");
	}
	
	@AfterClass(groups={"smoke test","Regression test"})
	public void AC()
	{
		System.out.println("close Browser");
		drv.quit();
	}
	@AfterTest(groups={"smoke test","Regression test"})
	public void AT()
	{
		System.out.println("close Parallel Execution");
	}
	@AfterSuite(groups={"smoke test","Regression test"})
	public void AS()
	{
		System.out.println("Database connection");
	}
}
