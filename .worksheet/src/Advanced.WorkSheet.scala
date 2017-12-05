package Advanced

object WorkSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(34); 
    val nums = new Array[Int](10);System.out.println("""nums  : Array[Int] = """ + $show(nums ));$skip(34); 
    val a = new Array[String](10);System.out.println("""a  : Array[String] = """ + $show(a ));$skip(60); 
    val s = Array("Hello", "World");System.out.println("""s  : Array[String] = """ + $show(s ));$skip(26);                 //直接传入数组
    
    s(0) = "Goodbye"}
}
