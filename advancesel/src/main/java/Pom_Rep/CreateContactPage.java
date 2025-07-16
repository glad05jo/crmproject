package Pom_Rep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactimage;
	
	
	@FindBy(name="salutationtype")
	private WebElement salutationtype;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savecontactname;

	@FindBy(name="firstname")
	private WebElement firstname;

	@FindBy(name="lastname")
	private WebElement lastname;
	
	public WebElement getcontactimage() {
		return contactimage;
	}
	public WebElement getsalutationtype() {
		return salutationtype;
	}
	public WebElement getSavecontactname() {
		return savecontactname;
	}
	public WebElement getfirstname() {
		return firstname;
	}
	public WebElement getlastname() {
		return lastname;
	}
	
	public void savecontactname()
	{
		savecontactname.click();
	}
	

}
