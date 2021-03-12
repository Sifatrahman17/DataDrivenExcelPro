package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[2]/div/h2")
	WebElement DASFBOARD_HEADER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/a")
	WebElement CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/ul/li[1]/a")
	WebElement CUSTOMER_ADD_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_FIELD;

	public void validateDashboardHeader() {

		waitForElement(driver, 5, DASFBOARD_HEADER_FIELD);
		Assert.assertEquals(DASFBOARD_HEADER_FIELD.getText(), "Dashboard", "DashBoard page not found!");
	}

	public void clickOnCustomerButton() {
		CUSTOMER_FIELD.click();
	}

	public void clickOnAddCustomerButton() {
		waitForElement(driver, 3, CUSTOMER_ADD_BUTTON);
		CUSTOMER_ADD_BUTTON.click();
	}
	
	
	public void clickOnListCustomerButton() {
		LIST_CUSTOMER_FIELD.click();
	}


}
