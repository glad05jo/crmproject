package Pom_Rep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImgPage {
	
	public CampLookUpImgPage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);
	}
	
	@FindBy(css="[title='Create Campaign...\']")
	private WebElement camplookupimg;

	public WebElement getCamplookupimg() {
		return camplookupimg;
	}

	public void clickcamplookupimg()
	{
		camplookupimg.click();
	}
	
	

}
