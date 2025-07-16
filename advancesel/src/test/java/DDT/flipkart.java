package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {

	public static void main(String[] args) {
		WebDriver Drv = new ChromeDriver();
		Drv.get("https://www.flipkart.com/");
		Drv.findElement(By.className("Pke_EE"));
		
		

	}

}
