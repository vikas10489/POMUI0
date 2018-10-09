package CommonUtill;

import org.openqa.selenium.WebDriver;

import basepage.BasePage;

public class CommonUtill extends BasePage {

	public CommonUtill(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ClickActionsPageTab() {

		clickon("actions_link");
		System.out.println("Clicked! Tab");
	}

	public void ClickAjaxCallPageTab() {

		clickon("ajaxcall_link");
		System.out.println("Clicked! Tab");
	}

	public void ClickControlsPageTab() {

		clickon("controls_link");
		System.out.println("Clicked! Tab");
	}

	public void ClickFormPageTab() {

		clickon("form_link");
		System.out.println("Clicked! Tab");
	}

	public void clickHomePageTab() {

		clickon("home_link");
		System.out.println("Clicked! Tab");
	}

	public void ClickSelectPageTab() {

		clickon("select_link");
		System.out.println("Clicked! Tab");
	}

	public void ClickSwitchToPageTab() {

		clickon("switchTo_link");
		System.out.println("Clicked! Tab");
	}

	public void clickWidgetPageTab() {

		clickon("widget_link");
		System.out.println("Clicked! Tab");
	}
}
