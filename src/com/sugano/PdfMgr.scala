package com.sugano


import java.lang.Float
import java.lang.Double
import com.itextpdf.text.Image
import com.itextpdf.text.PageSize
import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream
import java.io.File
import scala.sys.process._
import java.lang.ProcessBuilder
import java.awt.Desktop;

class PdfMgr {
  
    
	val DocumentDirectoryPath = "//Users//keitaroemotion//Pictures//";
	val fileName = DocumentDirectoryPath+"jpedoscomedy.pdf";
	  
	def Execute() = {
			try {
		      var document = new Document();
		      PdfWriter.getInstance(document, new FileOutputStream(fileName));
		      document.setPageSize(PageSize.A4);
		      document.open();
		      addContent(document,DocumentDirectoryPath+"pedos","jpg");
		      document.close();
		      Desktop.getDesktop().open(new File(fileName));
		    } catch{
 	 	      case e:Exception => {}
		    }
	}

	def ScalePercent(idealLength:Float , actualLength:Float, image:Image)={
			image.scalePercent((idealLength/actualLength)*100f * 0.9f)
	}
	
	def addContent(document:Document, dirpath:String, ext:String)={
	  var files = new DirX().GetFiles(dirpath,ext)
	  println("files.length |"+files.length)
	  
	  new DirX().SortFiles(files).foreach(f=>{
		  	println("> "+f.file.toString())
	      	var image = Image.getInstance(f.file.toString())
		  	ScalePercent(211f , image.getWidth()/2.835f, image)
		  	image.setIndentationLeft(-7f)
	    	document.add(image)
	  });
	}
	
}