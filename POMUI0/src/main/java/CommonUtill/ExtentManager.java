package CommonUtill;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
//i need to copy and write in system.
public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d = new Date();
			String filename = d.toString().replace(":", "_").replace(" ", "_") + ".html";
			String reportPath = System.getProperty("user.dir") + "//reports//" + filename;
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
			extent.addSystemInfo("Selenium Version", "3.7.0").addSystemInfo("Environment", "QA")
					.addSystemInfo("Browser", "Chrome");
		}
		return extent;
	}
}
