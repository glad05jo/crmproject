package Pom_Rep;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage (WebDriver drv)
	{
		PageFactory.initElements(drv, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(linkText="More")
	private WebElement Morelink;
	
	@FindBy(name="Campaigns")
	private WebElement Campaignslink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement Signoutlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminlink;
	
	
	
	
	public WebElement getProductLink() {
		return ProductLink;
	}
	
	
	public WebElement getMorelink() {
		return Morelink;
	}


	public WebElement getCampaignslink() {
		return Campaignslink;
	}


	public WebElement getContactsLink() {
		return ContactsLink;
	}
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public void ClickProductLink()
	{
		ProductLink.click();
	}
	
	public void ClickMoreLink()
	{
		Morelink.click();
	}
	public void ClickCampaignsLink()
	{
		Campaignslink.click();
	}
	public void ClickContactsLink()
	{
		ContactsLink.click();
	}
	

	public void ClickOrganizationsLink()
	{
		OrganizationsLink.click();
	}


	public void logoutapp()
	{
		Adminlink.click();
		Signoutlink.click();
	}
}
