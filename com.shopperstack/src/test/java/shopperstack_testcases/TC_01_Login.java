package shopperstack_testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pom_classes.Login_Page;
import pom_classes.Welcome_Page;
import utilities.ExcelUtility;
import utilities.PropertiesUtility;

public class TC_01_Login {

	@Test
	public void loginTest() throws IOException {
//		//fetch data from properties
//		
//		// step 1-->get the obj of external file
//		FileInputStream fis = new FileInputStream("./src/test/resources/commondata/data.properties");
//		// step 2-->create an obj for properties class
//		Properties prop = new Properties();
//		// step 3-->load the file
//		prop.load(fis);
//		// step 4-->get the data
//		String url = prop.getProperty("Url");
//		String browser = prop.getProperty("Browser");
//		System.out.println(url);
//		System.out.println(browser);
		
		PropertiesUtility prob=new PropertiesUtility();
		String url = prob.readDataFromProperties("Url");
		
		
		//navigate to shopperstack by using properties data
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get(url);

		// click on login button in welcome page
		Welcome_Page welcome = new Welcome_Page(driver);
		welcome.getLoginButton().click();

		// login
		Login_Page login = new Login_Page(driver);
		
		// read data from excel
		
//		// step 1-->get the object of excel file
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/testdata/shopperstack.xlsx");
//		// step 2-->open the excel in read mode
//		Workbook workbook = WorkbookFactory.create(fis1);
//		// step 3-->get sheet control
//		Sheet sheet = workbook.getSheet("login");
//		// step 4-->get the row control
//		Row row = sheet.getRow(1);
//		// step 5-->get the cell control
//		Cell cell = row.getCell(0);
//		// step 6-->fetch the data
//		String email = cell.getStringCellValue();
//		//System.out.println(email);
//
//		Row row1 = sheet.getRow(1);
//		Cell cell1 = row.getCell(1);
//		String pwd = cell1.getStringCellValue();
//		//System.out.println(pwd);
		ExcelUtility excel=new ExcelUtility();
		String email = excel.readDataFromExcel("login", 1, 0);
		String pwd = excel.readDataFromExcel("login", 1, 1);
		
		login.getEmailTextfield().sendKeys(email);
		login.getPassworddTextfield().sendKeys(pwd);
		login.getLoginButton().click();
	}

}
