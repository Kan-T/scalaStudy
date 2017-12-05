package Advanced

import scala.collection.mutable.ArrayBuffer

object ArrayOps {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(402); 
  def main(args: Array[String]): Unit = {
    val nums = new Array[Int](10)
    val a = new Array[String](10)
    val s = Array("Hello", "World")
                                                  
    s(0) = "Goodbye"
    
    val b = ArrayBuffer[Int]()
    b += 1
    b += (1, 2, 3, 5)
    b ++= Array(8, 13, 21)
    
	};System.out.println("""main: (args: Array[String])Unit""")}
}
