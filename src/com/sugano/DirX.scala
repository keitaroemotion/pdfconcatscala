package com.sugano

import scala.Array
//import java.util.prefs.Remove
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Array

class DirX {
	def GetFiles(dirName:String, ext:String):List[java.io.File]={
	  var mutableExt = ext;
	  if(ext.startsWith(".")){ mutableExt = "." + mutableExt;}
	  
	   var file1 =  new java.io.File(dirName).listFiles.filter(_.getName.endsWith(".jpg") ).toList
	   var file2 = new java.io.File(dirName).listFiles.filter(_.getName.endsWith(".jpeg") ).toList
	   return file1.:::(file2)
	}
	
	
	def isImage(name:String):Boolean={
			if(name.endsWith("jpg") || name.endsWith("jpeg") || name.endsWith("JPEG")){ return true }
			return false
	}
	
	def SortFiles(files:List[java.io.File]):List[FileLocationMap]={
		var newlist = List[FileLocationMap]()
		files.foreach(f => {
			 var fname = f.getName().replace(".jpg", "").replace(".jpeg", "").replace(".JPEG", "")
			 var ff = new FileLocationMap(){}
			 ff.file = f.getPath().toString()
			 ff.index = fname.substring(fname.length()-1).toInt
			 newlist = newlist.+:(ff);
		})
		newlist.sortBy(f => f.index)
		//newlist.reverse
		return newlist.reverse
	}
	
}