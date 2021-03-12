package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	ExcelReader exlread = new ExcelReader("./data/Tf_excel file.xlsx");
	String userName = exlread.getCellData("Logininfo", "UserName", 2);
	String password = exlread.getCellData("Logininfo", "Password", 2);

	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		
		
		
		BrowserFactory.tearDown();

	}

}
