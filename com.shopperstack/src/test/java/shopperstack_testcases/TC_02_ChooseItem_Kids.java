package shopperstack_testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pom_classes.Home_Page;
import pom_classes.Kids_Page;
import pom_classes.Login_Page;
import pom_classes.Welcome_Page;

public class TC_02_ChooseItem_Kids extends BaseTest {
	
	@Test
	public void chooseItemKids() throws InterruptedException {
//		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//		driver.manage().window().maximize();
//		driver.get("https://shoppersstack.com/");
//		
//		//click on login button in welcome page
//		Welcome_Page welcome=new Welcome_Page(driver);
//		welcome.getLoginButton().click();
//		
//		//login
//		Login_Page login=new Login_Page(driver);
//		login.getEmailTextfield().sendKeys("romeo@gmail.com");
//		login.getPassworddTextfield().sendKeys("Romeo@77");
//		login.getLoginButton().click();
		
		//click on kids in home page
		Home_Page home=new Home_Page(driver);
		Thread.sleep(2000);
		home.getKidsButton().click();
		//mouse hover
		Actions act=new Actions(driver);
		act.moveToElement(home.getUserIcon()).perform();
		
		//choose item in kids page
		Kids_Page kid=new Kids_Page(driver);
		kid.getKidsItems().get(0).click();
	}

}
