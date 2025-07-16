package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class logout {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("D:\\QSpider\\advsel\\vtigerlogin.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String Browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String un = pro.getProperty("username");
		String ps = pro.getProperty("password");
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
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		drv.findElement(By.name("user_name")).sendKeys(un);
		drv.findElement(By.name("user_password")).sendKeys(ps);
		drv.findElement(By.id("submitButton")).click();
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
		
		//Actions mouse = new Actions(drv);
		drv.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
		drv.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	}

}
