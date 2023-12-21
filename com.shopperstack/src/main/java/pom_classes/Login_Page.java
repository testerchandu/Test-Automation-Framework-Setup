package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement emailTextfield;
	
	@FindBy(id = "Password")
	private WebElement passwordTextfield;
	
	@FindBy(name = "Login")
	private WebElement loginButton;

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getPassworddTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	

}
