package Pom_Rep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage (WebDriver drv)
	{
		PageFactory.initElements(drv, this);
	}
		
	@FindBy(name="user_name")
	private WebElement	usernameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	/* This method is used to Login the Application
	 * @param username
	 * @param password
	 */	
	public void logintoApp(String username,String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitButton.click();
	}
	
}
