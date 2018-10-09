package testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonUtill.DataUtil;

import testbase.TestBase;

public class FetchPdfDataTest extends TestBase {
	public String testCaseName = "PdfContentTest";
	String loan_no;
	String closing_date;
	String loan_program;
	String interest_rate;

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testCaseName);
	}

	@Test(dataProvider = "getData")
	public void checkPdf(Hashtable<String, String> data) throws IOException {
		test = extent.startTest(testCaseName);
		if (!DataUtil.isTestExecutable(xls, testCaseName) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		try {
			File file = new File(System.getProperty("user.dir") + "//Data//" + data.get("PDF Name") + ".pdf");

			FileInputStream fis = new FileInputStream(file);
			PDFParser parser = new PDFParser(fis);

			parser.parse();
			COSDocument cosdoc = parser.getDocument();
			PDDocument pddoc = new PDDocument(cosdoc);

			PDFTextStripper strip = new PDFTextStripper();
			String pdfDoc = strip.getText(pddoc);

			BufferedReader br = new BufferedReader(new FileReader(pdfDoc));
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.contains("Loan #")) {
					String tmp[] = line.split(":");
					for (int i = 0; i <= 10; i++) {
						tmp[i].equalsIgnoreCase("Loan #");
						loan_no = tmp[i + 1];
						System.out.println("Loan no is " + loan_no);
						break;
					}
				} else if (line.contains("PASSWORD")) {
					String tmp[] = line.split(":");
					for (int i = 0; i <= 10; i++) {
						tmp[i].equalsIgnoreCase("PASSWORD");
						closing_date = tmp[i + 1];
						System.out.println("PASSWORD is " + closing_date);
						break;
					}
				} else if (line.contains("Loan Program")) {
					String tmp[] = line.split(":");
					for (int i = 0; i <= 10; i++) {
						tmp[i].equalsIgnoreCase("Loan Program");
						loan_program = tmp[i + 1];
						System.out.println("Loan Program is " + loan_program);
						break;
					}
				} 
				br.close();
			}
			cosdoc.close();
			pddoc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
