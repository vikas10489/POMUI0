package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonUtill.CommonUtill;
import CommonUtill.ExtentManager;
import pages.FormPage;
import basepage.BasePage;
import testbase.TestBase;

public class Submitform extends TestBase {

	@Test
	public void test() {
		ExtentReports extent = ExtentManager.getInstance();
		ExtentTest test = extent.startTest("Form Test");
		test.log(LogStatus.INFO, "Logging In..");
		openBrowser("Chrome");
		CommonUtill fp = new CommonUtill(driver);
		// driver.navigate().to("http://uitestpractice.com/Students/Form");

		 
		// confused
		fp.ClickFormPageTab();
		try {
			enterFormDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		extent.endTest(test);
		extent.flush();
		closeBrowser();
	}

	public void enterFormDetails() {
		BasePage bg = new BasePage(driver);
		bg.type("firstname", "vikas");

		bg.waitingTime(1000);
		bg.type("lastname", "vikas");
		bg.clickon("maritalstatus_married");
		bg.clickon("maritalstatus_single");
		bg.clickon("hobbies_read");
		bg.clickon("hobbies_dance");

		bg.clickon("country_listbox");
		bg.selectdropdown("country_listbox", "India");

		bg.clickon("datepicker");
		bg.selectdropdown("datepicker_month", "Apr");
		bg.selectdropdown("datepicker_year", "1989");
		bg.clickon("datepicker_day");

		// bg.type("phone_number", "incorrect");
		bg.type("phone_number", "8097722345");
		bg.type("username", "Vikas12");
		// bg.type("email", "incorrect");
		bg.type("email", "Vikas12@gmail.com");
		//doubt page not seen
		//bg.tab("email");
		//bg.waitingTime(2000);
		bg.type("comment_textarea", "Vikas12");
		bg.type("password", "Vikas12");
		bg.waitingTime(2000);
		bg.clickon("submit_button");
		bg.waitingTime(2000);

	}

	public void closeBrowser() {
		
		driver.quit();
	}
}
