package Pom_Rep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);
}
	
@FindBy(name="productname")
private WebElement Productname;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebutton;

public WebElement getProductname() {
	return Productname;
}

public WebElement getSavebutton() {
	return savebutton;
}

public void createprdt(String Productvalue)
{
	Productname.sendKeys(Productvalue);
	savebutton.click();
}
}
