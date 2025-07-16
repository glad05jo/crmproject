package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class properties {
	// properties file fetch and read practice done

	public static void main(String[] args) throws Throwable {
		//FileInputStream fis=new FileInputStream("\\D:\\QSpider\\advsel\\pro.properties");
		Properties pro = new Properties();
		//pro.load(fis);
		
		/*String fbrowser = pro.getProperty("browser");
		String furl = pro.getProperty("url");
		
		System.out.println(fbrowser +" " +  furl);
		
		WebDriver Drv;
		if(fbrowser.equalsIgnoreCase("chrome"))
		{
			Drv =new ChromeDriver();
		}
		else
		{
			Drv = new FirefoxDriver();
		}
		Drv.get(furl);
		*/
		FileOutputStream fos=new FileOutputStream("\\D:\\QSpider\\advsel\\pro.properties");
		pro.setProperty("fbrowser", "chrome");
		pro.store(fos, "pro");
		
		
	}

}
