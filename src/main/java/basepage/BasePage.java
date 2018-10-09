package basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	WebDriver driver;
	Properties pro;
	private File srcFile;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		pro = new Properties();
		String userDir = System.getProperty("user.dir");
		try {
			FileInputStream fis = new FileInputStream(userDir + "\\src\\main\\resources\\OR.properties");
			pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement getelement(String objRepoKey) {
		return driver.findElement(By.xpath(pro.getProperty(objRepoKey)));
	}

	public List<WebElement> getelements(String objRepoKey) {
		return driver.findElements(By.xpath(pro.getProperty(objRepoKey)));
	}

	public void clickon(String objRepoKey) {
		getelement(objRepoKey).click();
	}

	public void type(String objRepoKey, String value) {
		getelement(objRepoKey).sendKeys(value);
	}

	public void tab(String objRepoKey) {
		getelement(objRepoKey).sendKeys(Keys.TAB);
	}

	public void waitingTime(long timeinms) {

		try {
			Thread.sleep(timeinms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SelectMultipleValue(String objRepoKey, String value1, String value2) {
		Select sel = new Select(getelement(objRepoKey));
		if (sel.isMultiple()) {
			System.out.println("selected value is mutiple selection" );
			List<WebElement> optionslist = sel.getOptions();
			int count = optionslist.size();
			sel.getAllSelectedOptions();
			for (int i = 0; i <= count; i++) {
				String Svalue = optionslist.get(i).getText();
				System.out.println(Svalue);
			}
			sel.getAllSelectedOptions().clear();
			for (int i = 0; i <= count; i++) {
				String Svalue = optionslist.get(i).getText();
				System.out.println(Svalue);
				if (Svalue.equals(value1)) {
					sel.selectByVisibleText(value1);
				} else if (Svalue.equals(value2)) {
					sel.selectByVisibleText(value2);
				}

			}
			List<WebElement> s1 = sel.getAllSelectedOptions();
			for (WebElement webelementtemp:s1){
				System.out.println("selected value is" + s1);
			}
		} else {
			sel.selectByVisibleText(value1);

		}

	}


	public void dropdown(String objRepoKey, String value) {
		Select dropdown = new Select(getelement(objRepoKey));
		dropdown.selectByVisibleText(value);

		// dropdown.selectByIndex(0);
		// dropdown.selectByValue(value);
	}

	public void DragAndDrop(String objRepoKey, String objRepoKey2) {
		Actions selDragDrop = new Actions(driver);
		Action dragDrop = selDragDrop.clickAndHold(getelement(objRepoKey)).moveToElement(getelement(objRepoKey2))
				.release(getelement(objRepoKey2)).build();
		dragDrop.perform();
	}

	public void rightclick(String objRepoKey) {
		Actions action = new Actions(driver);
		action.moveToElement(getelement(objRepoKey)).perform();
		action.contextClick().perform();
	}

	public void deleteCookies(String objRepoKey) {
		driver.manage().deleteAllCookies();
	}

	public void refresh() {
		/*
		 * driver.navigate().refresh(); driver.sendkeys(keys.F5);
		 * driver.getCurrentUrl();
		 */
		driver.navigate().to(driver.getCurrentUrl());
	}
	public void bootstrapbuttonDropdown(String objRepoKey, String objRepoKey_value) throws InterruptedException {
		getelement(objRepoKey).click();
		getelement(objRepoKey_value).click();
		String S1 = getelement(objRepoKey).getText();
		System.out.println(S1);
		Thread.sleep(2000);
	}

	public void SelectValue(String objRepoKey, String value1) {
		Select sel = new Select(getelement(objRepoKey));
		sel.selectByVisibleText(value1);
		List<WebElement> s1 = sel.getAllSelectedOptions();
		for (WebElement webelementtemp:s1){
			System.out.println("selected value is " + s1);
		}
	}

	public void selectdropdown(String objRepoKey, String value) {
		Select dropdown = new Select(getelement(objRepoKey));
		dropdown.selectByVisibleText(value);
		// dropdown.selectByIndex(0);
		// dropdown.selectByValue(value);
	}

	public void Dropdown(String objRepoKey, String value1) throws InterruptedException {
		Select sel = new Select(getelement(objRepoKey));
		sel.selectByVisibleText(value1);
		/*keys over*/
		List<WebElement> webelement = sel.getOptions();
		System.out.println(webelement.size());
		for (WebElement webelementtemp : webelement) {
			System.out.println(webelementtemp.getText());
		}
		boolean ismultiple= sel.isMultiple();
		System.out.println("ismultiple=" + ismultiple);
		sel.getFirstSelectedOption();
		System.out.println("First selected option is"+getelement(objRepoKey).getText());
		sel.selectByIndex(0);
		System.out.println("after select a value"+getelement(objRepoKey).getText());
		sel.deselectByIndex(0);
		System.out.println("after deselect the value"+getelement(objRepoKey).getText());
		//to print multiple select values from multiple select drop down
		List<WebElement> webelement2 = sel.getAllSelectedOptions();
		System.out.println(webelement2.size());
		for (WebElement webelementtemp : webelement2) {
			System.out.println(webelementtemp.getText());
		}
		/*keys over*/
		sel.selectByVisibleText(value1);		
		Thread.sleep(2000);
	}

	public void MultiSelectDropdown(String objRepoKey, String objRepoKey_value) throws InterruptedException {
		Select sel = new Select(getelement(objRepoKey));
		sel.selectByVisibleText(objRepoKey_value);
		Thread.sleep(2000);
	}
	// ---------------------


	public void doubleClick(String objRepoKey) {
		Actions action = new Actions(driver);
		action.doubleClick(getelement(objRepoKey));
	}

	public void selectall(String objRepoKey) {
		// driver.presskey(Keys.CONTROL+Keys.A);
		// driver.releasekey(Keys.CONTROL+Keys.A);
	}

	public void hover(String objRepoKey) {
		Actions act = new Actions(driver);
		act.moveToElement(getelement(objRepoKey)).perform();
	}

	public void screenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("D:\\screenshot.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * public void reportfailure(string failure Message){
	 * test.log(Logstatus.FAIL,failureMessage); takescreenshot(); ASSERT.
	 * 
	 * Fail(Failure Message);
	 * 
	 * }
	 */
}