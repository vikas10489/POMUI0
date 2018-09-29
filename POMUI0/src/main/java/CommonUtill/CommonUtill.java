package CommonUtill;

import org.openqa.selenium.WebDriver;

import basepage.BasePage;

public class CommonUtill extends BasePage{

	public CommonUtill(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void ClickActionsPageTab() {
		System.out.println("Clicking on the form tab");
		clickon("actions_link");
		System.out.println("Clicked!");
	}
	public void ClickAjaxCallPageTab() {
		System.out.println("Clicking on the form tab");
		clickon("ajaxcall_link");
		System.out.println("Clicked!");
	}
	public void ClickControlsPageTab() {
		System.out.println("Clicking on the form tab");
		clickon("controls_link");
		System.out.println("Clicked!");
	}
	public void ClickFormPageTab() {
		System.out.println("Clicking on the form tab");
		clickon("form_link");
		System.out.println("Clicked!");
	}
	public void clickHomePageTab() {
		System.out.println("Clicking on the form tab");
		clickon("home_link");
		System.out.println("Clicked!");
	}
	public void ClickSelectPageTab() {
		System.out.println("Clicking on the form tab");
		clickon("select_link");
		System.out.println("Clicked!");
	}
	public void ClickSwitchToPageTab() {
		System.out.println("Clicking on the form tab");
		clickon("switchTo_link");
		System.out.println("Clicked!");
	}
	public void clickWidgetPageTab() {
		System.out.println("Clicking on the form tab");
		clickon("widget_link");
		System.out.println("Clicked!");
	}

}
