package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class insertdata {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Properties pro=new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "http://localhost:8888/");
		
		FileOutputStream fio =new FileOutputStream("D:\\QSpider\\advsel\\dd2.properties");
		pro.store(fio, "ddt2");
		
		FileInputStream fis=new FileInputStream("D:\\QSpider\\advsel\\dd2.properties");
		pro.load(fis);
		String bro = pro.getProperty("browser");
		String url = pro.getProperty("url");
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
		
	}
		
		
		

	}


