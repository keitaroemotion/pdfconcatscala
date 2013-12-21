package com.sugano

import scala.Array
//import java.util.prefs.Remove
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Array

class DirX {
	def GetFiles(dirName:String, ext:String):Array[java.io.File]={
	  var mutableExt = ext;
	  if(ext.startsWith(".")){ mutableExt = "." + mutableExt;}
	   return new java.io.File(dirName).listFiles.filter(_.getName.endsWith(mutableExt));
	}
	
	
	
	def SortFiles(files:Array[java.io.File]):Array[FileLocationMap]={
		var newlist = List[FileLocationMap]()
		files.foreach(f => {
			 var fname = f.getName().replace(".jpeg", "")
			 var ff = new FileLocationMap(){}
			 ff.file = f.getPath().toString()
			 ff.index = fname.substring(fname.length()-1).toInt
			 newlist = newlist.+:(ff);
		})
		newlist.sortBy(f => f.index)
		//newlist.reverse
		return newlist.toArray[FileLocationMap].reverse
	}
	
}