package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	private AccountsPage accountsPage;
	
	@Given("user has already logged into a application")
	public void user_has_already_logged_into_a_application(DataTable credTable) throws InterruptedException {
	    
		List<Map<String, String>> credList = credTable.asMaps();
	    String userName =  credList.get(0).get("username");
	    String password =  credList.get(0).get("password");
	    
	    DriverFactory.getDriver().get("https://sso.teachable.com/secure/9521/identity/login/password");
	    accountsPage = loginpage.dologin(userName, password);
	    Thread.sleep(3000);
	
	}

	@Given("user is on  Accounts page")
	public void user_is_on_accounts_page() {
	    
		String title = accountsPage.getAccoutPageTitle();
		System.out.println(title);
	}

	@Then("users gets enroll course section")
	public void users_gets_enroll_course_section(DataTable courseSectionTable) {
		
		List<String> expectedCourseList = courseSectionTable.asList();
		System.out.println("Expected Course List: "+ expectedCourseList);
		
		List<String> actualCourseList =  accountsPage.getcourseEnrolList();
		System.out.println("Actual Course List: "+ actualCourseList);
		
		Assert.assertTrue(expectedCourseList.containsAll(actualCourseList));

	}

	@Then("enroll course section count should be {int}")
	public void enroll_course_section_count_should_be(Integer expectedCount) {
	    
		Assert.assertTrue(accountsPage.getcourseEnrolListCount() == expectedCount);
		
	}

}
