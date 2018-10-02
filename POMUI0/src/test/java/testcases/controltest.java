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

public class controltest extends TestBase {
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

		fp.ClickSelectPageTab();
		try {
			enterSelectDetails(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "getData")
	public void enterSelectDetails(Hashtable<String, String> data) {
		// TODO Auto-generated method stub
		System.out.println("enterSelectDetails");
		// bg.SelectValue("countriessingle_listbox", "India");
		bg.SelectMultipleValue("countries_multiple", "India", "China");
		bg.SelectValue("countries_button", "India");
	}
}
