package pages;

import org.openqa.selenium.WebDriver;

import basepage.BasePage;



public class Homepage extends BasePage{
	public Homepage(WebDriver driver) {
		super(driver);
	}
 
	public void CreateNew(String objRepoKey, String Name) {
		clickon("create_new");
		type("create_firstname", "vikas");
		type("create_lastname", "agrawala");
		type("create_enrolldate", "12/20/1987 12:00:00 AM");
		clickon("create_submit_button");
	}

	public void SearchName(String objRepoKey, String Name) {
		type("searchData_textbox", "Vikas");
		clickon("find_submit_button");
	}

	public void EditName(String objRepoKey, String Name) {
		if (getelement("edit_record").isDisplayed()) {
			clickon("edit_record");
		} else if (getelement("edit_detail_record").isDisplayed()) {
			clickon("edit_detail_record");
		}
	}

	public void DeleteName(String objRepoKey, String Name) {
		clickon("delete_record");
	}

	public void ViewDetailsName(String Name) {
		clickon("view_record");
	}

	public void NextPage() {
		if (getelement("next_page").isDisplayed()) {
			clickon("next_page");
		}
	}

	public void PrevPage() {
		if (getelement("prev_page").isDisplayed()) {
			clickon("prev_page");
		}
	}

	public void pageByIndex(String indexvalue) {
		if (getelement("middle_page").isDisplayed()) {
			clickon("middle_page");
		}
	}
}
