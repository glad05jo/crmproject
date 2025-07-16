package Pom_Rep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {

	public CreateCampPage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);
	}
	@FindBy(name="campaignname")
	private WebElement campname;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement savecampname;
	
	public WebElement getCampname() {
		return campname;
	}
	
	public WebElement getSavecampname() {
		return savecampname;
	}

	
	public void getcampname()
	{
		campname.click();
	}
	
	public void savecampname()
	{
		savecampname.click();
	}
	
}
