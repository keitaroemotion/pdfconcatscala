package com.sugano;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfManager {
	static String DocumentDirectoryPath = "//Users//keitaroemotion//Documents//";
	static String File = DocumentDirectoryPath+"sample.pdf";
	public static void main(String[] args){
	try {
	      Document document = new Document();
	      PdfWriter.getInstance(document, new FileOutputStream(File));
	      document.setPageSize(PageSize.A4);
	      document.open();
	      addMetaData(document);
	      addContent(document);
	      document.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	

	  static void addContent(Document document) throws DocumentException, MalformedURLException, IOException {
	    // now add all this to the document
		Image image1 = Image.getInstance(DocumentDirectoryPath+"mangadata//Africa2.jpg");
	    document.add(image1);

	  }

	  private static void addMetaData(Document document) {
		    document.addTitle("My first PDF");
		    document.addSubject("Using iText");
		    document.addKeywords("Java, PDF, iText");
		    document.addAuthor("Lars Vogel");
		    document.addCreator("Lars Vogel");
		}
	
}
