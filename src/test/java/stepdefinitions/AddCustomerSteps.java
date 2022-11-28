package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AddCustomerPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomerSteps {
	private AddCustomerPage addCustomerPage = new AddCustomerPage(DriverFactory.getDriver());

	@Given("user navigate to add customer page")
	public void user_navigate_to_add_customer_page() {
		DriverFactory.getDriver().get("https://demo.guru99.com/telecom/addcustomer.php");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InvalidFormatException, OpenXML4JException 
	{
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("C:\\Users\\DELL\\Documents\\eclipse-workspace\\CucumberMiniProject\\datatest.xlsx", sheetName);
		
		String bgstatus = testData.get(rowNumber).get("BGStatus");
		String firstname = testData.get(rowNumber).get("FirstName");
		String lastname = testData.get(rowNumber).get("LastName");
		String email = testData.get(rowNumber).get("Email");
		String address = testData.get(rowNumber).get("Address");
		String mobileno = testData.get(rowNumber).get("MobileNo");
		
		addCustomerPage.fillAddCustomerForm(bgstatus, firstname, lastname, email, address, mobileno);

	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		addCustomerPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMessage) {
		String actualSuccMessg = addCustomerPage.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
	}
	
}
