package Pom_Rep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;

public class CreateOrgPage {
	public CreateOrgPage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);
}
	@FindBy(name="accountname")
	private WebElement accountname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(id="phone")
	private WebElement phoneno;

	@FindBy(id="email")
	private WebElement email;
	
	
	public WebElement getAccountname() {
		return accountname;
	}
	
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getPhoneno() {
		return phoneno;
	}
	public WebElement getEmail() {
		return email;
	}
	
	public void createorgname(String oname)
	{
		accountname.sendKeys(oname);		
	}
	public void createorgphone(String opnvaue)
	{
		phoneno.sendKeys(opnvaue);
	}

	public void createorgemail(String oemailvalue)
	{
		email.sendKeys(oemailvalue);
	}
	public void createorg()
	
	{
		savebutton.click();
	}
}
