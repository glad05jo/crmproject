package Pom_Rep;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpPage {
	
	public ProductLookUpPage(WebDriver drv)
	{
		
			PageFactory.initElements(drv, this);
		
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createprdt;

	public WebElement getCreateprdt() {
		return createprdt;
	}

	public void clickprdtLookup()
	{
		createprdt.click();
	}

}
