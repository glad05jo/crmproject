package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProvider2 {

	@Test(dataProvider ="readproduct")
	public void createproduct(String username,String password,String name)
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
		driver.findElement(By.name("productname")).sendKeys(name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] readproduct()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0] ="admin";
		obj[0][1]="admin";
		obj[0][2]="Battery10";
		
		obj[1][0] ="admin";
		obj[1][1]="admin";
		obj[1][2]="Battery20";
		
		return obj;
		
	}
	
}
