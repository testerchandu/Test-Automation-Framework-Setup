package basetest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pom_classes.Login_Page;
import pom_classes.Welcome_Page;
import utilities.ExcelUtility;
import utilities.PropertiesUtility;

public class BaseTest {
	public WebDriver driver;

	@BeforeSuite
	public void dbopen() {
		System.out.println("db get connected");
	}

	@AfterSuite
	public void dbClose() {
		System.out.println("db get disconnected");
	}

	@BeforeTest
	public void test1() {
		System.out.println("test started");
	}

	@AfterTest
	public void test2() {
		System.out.println("test ended");
	}

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}

	@BeforeMethod
	public void login() throws IOException {
		PropertiesUtility prob = new PropertiesUtility();
		String url = prob.readDataFromProperties("Url");
		driver.get(url);
		// click on login button in welcome page
		Welcome_Page welcome = new Welcome_Page(driver);
		welcome.getLoginButton().click();
		// login
		Login_Page login = new Login_Page(driver);
		ExcelUtility excel = new ExcelUtility();
		String email = excel.readDataFromExcel("login", 1, 0);
		String pwd = excel.readDataFromExcel("login", 1, 1);
		login.getEmailTextfield().sendKeys(email);
		login.getPassworddTextfield().sendKeys(pwd);
		login.getLoginButton().click();
	}

	@AfterMethod
	public void logout() {
		System.out.println("logged out");
	}

}
