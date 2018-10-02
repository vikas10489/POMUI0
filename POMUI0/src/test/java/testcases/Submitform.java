package testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonUtill.CommonUtill;
import CommonUtill.DataUtil;
import CommonUtill.ExtentManager;
import pages.FormPage;
import basepage.BasePage;
import testbase.TestBase;

//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Submitform extends TestBase {
	public String testCaseName = "FormTest";
	BasePage bg = new BasePage(driver);

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testCaseName);
	}

	@Test(dataProvider = "getData")
	public void Test(Hashtable<String, String> data) {
		System.out.println("Test");
		test = extent.startTest(testCaseName);
		if (!DataUtil.isTestExecutable(xls, testCaseName) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		test.log(LogStatus.INFO, "Logging In..");
		openBrowser(data.get("Browser"));
		CommonUtill fp = new CommonUtill(driver);
		// driver.navigate().to("http://uitestpractice.com/Students/Form");

		// System.out.println("test2");
		// confused
		fp.ClickFormPageTab();
		try {
			enterFormDetails(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "getData")
	public void enterFormDetails(Hashtable<String, String> data) {
		System.out.println("enterFormDetails");
		bg.type("firstname", data.get("First Name"));

		// bg.waitingTime(1000);
		bg.type("lastname", data.get("Last Name"));
		if (data.get("Marital Status").equals("Married")) {
			bg.clickon("maritalstatus_married");
		} else {
			bg.clickon("maritalstatus_single");
		}
		// implement multiple hobbies is pending
		if (data.get("Hobbies").equals("Dancing")) {
			bg.clickon("hobbies_read");
		} else {
			bg.clickon("hobbies_dance");

		}

		bg.clickon("country_listbox");
		bg.dropdown("country_listbox", data.get("Country"));
		bg.clickon("datepicker");
		// Date date = new Date();
		// convert string to date with ddMMyyyy format example "14092011"
		// String ddMMyyyy = "14092011";
		// formatter =new SimpleDateFormat("ddMMyyyy");
		// convertedDate =(Date) formatter.parse(ddMMyyyy);
		// System.out.println("Date from ddMMyyyy String in Java : " +
		// convertedDate);
		/*
		 * String dob = data.get("Date of Birth"); System.out.println(dob);
		 * String[] arrOfStr = dob.split("/", 4); SimpleDateFormat formatter =
		 * new SimpleDateFormat("dd/MMM/yyyy"); String strDate =
		 * formatter.format(dob); System.out.println(strDate);
		 * System.out.println(dob);
		 * System.out.println("dob with dd/MMM/yyyy : "+ strDate); String[]
		 * arrOfStr2 = strDate.split("/", 4);
		 */
		bg.dropdown("datepicker_month", "Apr");
		bg.dropdown("datepicker_year", "1989");
		// how to enter date dynamically from runtime date
		bg.clickon("datepicker_day");

		// bg.type("phone_number", "incorrect");
		// not able to read numeric value i am sending the data like '8097722449
		bg.type("phone_number", data.get("Phone Number"));
		bg.type("username", data.get("Username"));
		// bg.type("email", "incorrect");
		bg.type("email", data.get("Email"));
		// doubt page not seen
		// bg.tab("email");
		// bg.waitingTime(2000);
		bg.type("comment_textarea", data.get("Comments"));
		bg.type("password", data.get("Password"));
		// bg.waitingTime(2000);
		bg.clickon("submit_button");
		// bg.waitingTime(2000);
		System.out.println("submitted form");
		System.out.println("logged out");
	}
}
