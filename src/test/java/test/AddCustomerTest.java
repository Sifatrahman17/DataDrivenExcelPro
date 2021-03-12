package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("./data/Tf_excel file.xlsx");
	String userName = exlread.getCellData("Logininfo", "UserName", 2);
	String password = exlread.getCellData("Logininfo", "Password", 2);
	String fullName = exlread.getCellData("AddContactinfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContactinfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactinfo", "Email", 2);
	String phone = exlread.getCellData("AddContactinfo", "Phone", 2);
	String address = exlread.getCellData("AddContactinfo", "Address", 2);
	String city = exlread.getCellData("AddContactinfo", "City", 2);
	String country = exlread.getCellData("AddContactinfo", "Country", 2);
	String state = exlread.getCellData("AddContactinfo", "State", 2);
	String zip = exlread.getCellData("AddContactinfo", "Zip", 2);
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertfullName(fullName);;
		addCustomerPage.insertCompanyName(companyName);
		addCustomerPage.insertEmailAddress(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.enterCountryName(country);
		addCustomerPage.clickSubmitButton();
		
		addCustomerPage.clickOnListCustomerButton();
		addCustomerPage.verifyEnteredName();
	}
	
}
