package Pom_Rep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgookUpImgPage {

	public OrgookUpImgPage(WebDriver drv)
	{
		
			PageFactory.initElements(drv, this);
		
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organlookup;

	public WebElement getorganlookup() {
		return organlookup;
	}

	public void clickorganlookup()
	{
		organlookup.click();
	}
}
