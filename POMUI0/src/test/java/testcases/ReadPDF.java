package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadPDF {
	
	// doubt why main function why not public static void readfile{}
	public static void main(String[] args) throws IOException {

		File file = new File("C://Users//vikas//Downloads//comon.pdf");
		FileInputStream fis = new FileInputStream(file);
		PDFParser parser = new PDFParser(fis);

		parser.parse();
		COSDocument cosdoc = parser.getDocument();
		PDDocument pddoc = new PDDocument(cosdoc);

		PDFTextStripper strip = new PDFTextStripper();
		String data = strip.getText(pddoc);
		System.out.println(data);

		Assert.assertTrue(data.contains("Password"));
		cosdoc.close();
		pddoc.close();
		System.out.println("text found on pdf file");

	}
}