package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	public String userDir=System.getProperty("user.dir");

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

	public void quitBrowser() {
		driver.quit();
	}
}
