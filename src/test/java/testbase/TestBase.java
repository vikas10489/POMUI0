package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import CommonUtill.ExtentManager;
import CommonUtill.Xls_Reader;

public class TestBase {
	public WebDriver driver;
	public String userDir=System.getProperty("user.dir");
	public Xls_Reader xls=new Xls_Reader(System.getProperty("user.dir")+"//Data/Data.xlsx");;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public void openBrowser(String btype) {

		if (btype.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", userDir +"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (btype.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", userDir + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//driver = new ChromeDriver();
		driver.get("http://uitestpractice.com");
		driver.manage().window().maximize();

	}
	@AfterTest
	public void closeBrowser() {
		extent.endTest(test);
		extent.flush();
		driver.quit();
	}
}
