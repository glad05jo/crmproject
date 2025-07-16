package DDT;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fileproperties {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fio= new FileInputStream("D:\\QSpider\\advsel\\ddt1.properties ");
		
		Properties pro= new Properties();
		pro.load(fio);
		String bro =pro.getProperty("browser");
		String url =pro.getProperty("url");
		String uname =pro.getProperty("username");
		String password =pro.getProperty("password");
		
		WebDriver Drv;
		if(bro.equalsIgnoreCase("chrome"))
		{
			Drv =new ChromeDriver();
		}
		else
		{
			Drv = new FirefoxDriver();
		}
		Drv.get(url);
		Drv.findElement(By.name("user_name")).sendKeys(uname);
		Drv.findElement(By.name("user_password")).sendKeys(password);
		Drv.findElement(By.id("submitButton")).click();
	}

}
