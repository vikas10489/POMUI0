package testcases;
//import com.testautomationguru.utility.PDFUtil;

public class pdfutiltest {

}
/* 
		<dependency>
			<groupId>com.testautomationguru.pdfutil</groupId>
			<artifactId>pdf-util</artifactId>
			<version>0.0.1</version>
		</dependency>


	// To get page count

	PDFUtil pdfUtil = new PDFUtil();
	pdfUtil.getPageCount(System.getProperty("user.dir")+"//Data//comon.pdf"); //returns the page count
	// To get page content as plain text
	// returns the pdf content - all pages
	pdfUtil.getText(System.getProperty("user.dir")+"//Data//comon.pdf""); 

	// returns the pdf content from page number 2
	pdfUtil.getText(System.getProperty("user.dir")+"//Data//comon.pdf"",2); 

	// returns the pdf content from page number 5 to 8
	pdfUtil.getText(System.getProperty("user.dir")+"//Data//comon.pdf"", 5, 8);
	Copy To
	extract attached
	images from
	PDF
		//set the path where we need to store the images
		 pdfUtil.setImageDestinationPath("c:/imgpath");pdfUtil.extractImages(System.getProperty("user.dir")+"//Data//comon.pdf"");

	// extracts and saves the pdf content from page number 3
	pdfUtil.extractImages(System.getProperty("user.dir")+"//Data//comon.pdf"", 3);

	// extracts and saves the pdf content from page 2
	pdfUtil.extractImages(System.getProperty("user.dir")+"//Data//comon.pdf"", 2, 2);
	Copy To
	store PDF
	pages as
	images
		//set the path where we need to store the images
		 pdfUtil.setImageDestinationPath("c:/imgpath");pdfUtil.savePdfAsImage(System.getProperty("user.dir")+"//Data//comon.pdf"");
	Copy
	// To compare PDF files in text mode (faster – But it does not compare the
	// format, images etc in the PDF)
	String file1=(System.getProperty("user.dir")+"//Data//comon1.pdf");
	String file2 = (System.getProperty("user.dir") + "//Data//comon1.pdf");

	// compares the pdf documents and returns a boolean
	// true if both files have same content. false otherwise.
	pdfUtil.compare(file1,file2);

	// compare the 3rd page alone
	pdfUtil.compare(file1,file2,3,3);

	// compare the pages from 1 to 5
	pdfUtil.compare(file1,file2,1,5);
	Copy
	// To exclude certain text while comparing PDF files in text mode
	String file3=(System.getProperty("user.dir")+"//Data//comon1.pdf");
	String file1 = (System.getProperty("user.dir") + "//Data//comon2.pdf");

	// pass all the possible texts to be removed before comparing
	pdfutil.excludeText("1998","testautomation");

	// pass regex patterns to be removed before comparing
	// \\d+ removes all the numbers in the pdf before comparing
	pdfutil.excludeText("\\d+");

	// compares the pdf documents and returns a boolean
	// true if both files have same content. false otherwise.
	pdfUtil.compare(file1,file2);

	// compare the 3rd page alone
	pdfUtil.compare(file1,file2,3,3);

	// compare the pages from 1 to 5
	pdfUtil.compare(file1,file2,1,5);
	//Copy To	compare PDFfiles in	Visual mode (slower – compares PDF documents pixel by pixel – highlights pdf difference & store the result as image)
		// compares the pdf documents and returns a boolean
		// true if both files have same content. false otherwise.
		// Default is CompareMode.TEXT_MODE
		pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		pdfUtil.compare(file1, file2);

		// compare the 3rd page alone
		pdfUtil.compare(file1, file2, 3, 3);

		// compare the pages from 1 to 5
		pdfUtil.compare(file1, file2, 1, 5);

		//if you need to store the result
		pdfUtil.highlightPdfDifference(true);
		pdfUtil.setImageDestinationPath("c:/imgpath");
		pdfUtil.compare(file1, file2);
}
*/