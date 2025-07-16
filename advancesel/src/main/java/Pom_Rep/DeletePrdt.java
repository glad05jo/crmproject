package Pom_Rep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePrdt {

	public DeletePrdt(WebDriver drv)
	{
		PageFactory.initElements(drv, this);
	}
	
	@FindBy(css="[name='selectall']")
	private WebElement selectall ;
	
	@FindBy(css="[value='Delete']")
	private WebElement deletebutton ;
	
	public WebElement getSelectall() {
		return selectall;
	}
	public WebElement getDeletelink() {
		return deletebutton;
	}
public void clickdelete()
{
	selectall.click();
	deletebutton.click();
}
	
	}

