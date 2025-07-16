package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	public void getmaximizewindow(WebDriver drv )
	/* This method is used to maximize the window
	 * @author Gladish
	 */
	{
		drv.manage().window().maximize();
	}
	public void getimplicitwait(WebDriver drv) {
		/* This method is used to implicitwait the window
		 * @author Gladish
		 */
		drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/* This method is used to switch the window
	 * @author Gladish
	 */
	public void windowswitching(WebDriver drv,String partialTitle)
	{
		Set<String> allwin = drv.getWindowHandles();
		Iterator<String> it = allwin.iterator();
		
		while (it.hasNext())
		{
			String win=it.next();
			drv.switchTo().window(win);
			String title = drv.getTitle();
			if(title.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public void dropdown(WebElement ele, String data)
	{
		Select select=new Select(ele);
		select.selectByValue(data);
	}
	public void alertHandle(WebDriver drv) {
		
		drv.switchTo().alert().accept();
	}
	public static String takeSCreenShotEx(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
		
}
}
