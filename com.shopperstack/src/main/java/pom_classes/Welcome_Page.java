package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//step 1-->create class with respective webpage name
public class Welcome_Page {
	
	//step 2-->create constructor
	public Welcome_Page(WebDriver driver)
	{
		//step 3-->initialize the webelements
		PageFactory.initElements(driver,this);
	}
	
	//step 4-->identify webelement using @findby
	@FindBy(id = "loginBtn")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	 
}
