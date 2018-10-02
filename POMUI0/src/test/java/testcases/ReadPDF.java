package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonUtill.DataUtil;
import testbase.TestBase;

public class ReadPDF extends TestBase {

	public String testCaseName = "PdfContentTest";

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
		File file = new File(System.getProperty("user.dir") + "//Data//" + data.get("PDF Name") + ".pdf");
		FileInputStream fis = new FileInputStream(file);
		PDFParser parser = new PDFParser(fis);

		parser.parse();
		COSDocument cosdoc = parser.getDocument();
		PDDocument pddoc = new PDDocument(cosdoc);

		PDFTextStripper strip = new PDFTextStripper();
		String pdfDoc = strip.getText(pddoc);

		test.log(LogStatus.INFO, "Checking the loan number");
		if (pdfDoc.contains(data.get("Loan Number"))) {			
			test.log(LogStatus.PASS, "Match Found: " + data.get("Loan Number"));
		} else
			test.log(LogStatus.FAIL, "Value Not Found: " + data.get("Loan Number")+" in "+data.get("PDF Name"));
		cosdoc.close();
		pddoc.close();

	}
}