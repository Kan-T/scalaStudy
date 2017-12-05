package Advanced


object Ops {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet");$skip(42); 
  	val tuple = (1,2,3.14,"Rocky","Spark");System.out.println("""tuple  : (Int, Int, Double, String, String) = """ + $show(tuple ));$skip(66); 
    println("1. " + tuple._3);$skip(49);               //Tuple中，元素的index从1开始。
    
    val (first,sec,third,fourth, _) = tuple;System.out.println("""first  : Int = """ + $show(first ));System.out.println("""sec  : Int = """ + $show(sec ));System.out.println("""third  : Double = """ + $show(third ));System.out.println("""fourth  : String = """ + $show(fourth ));$skip(25); 
    println("2. " + sec);$skip(39); val res$0 = 
    "Rocky Spark".partition(_.isUpper);System.out.println("""res0: (String, String) = """ + $show(res$0));$skip(42); 
    
    val symbols = Array("[","-","]");System.out.println("""symbols  : Array[String] = """ + $show(symbols ));$skip(30); 
    val counts = Array(2,5,2);System.out.println("""counts  : Array[Int] = """ + $show(counts ));$skip(36); 
    val pairs = symbols.zip(counts);System.out.println("""pairs  : Array[(String, Int)] = """ + $show(pairs ));$skip(36); 
    for ((x,y) <- pairs) print(x*y);$skip(32); 
    
    val d = Array(1,7,2,9);System.out.println("""d  : Array[Int] = """ + $show(d ));$skip(27); 
    
    val e = d.toArray;System.out.println("""e  : Array[Int] = """ + $show(e ));$skip(36); 
    scala.util.Sorting.quickSort(e);$skip(25); val res$1 = 

    e.mkString(" and ");System.out.println("""res1: String = """ + $show(res$1));$skip(30); val res$2 = 
    e.mkString("<", ",", ">");System.out.println("""res2: String = """ + $show(res$2));$skip(24); val res$3 = 
    e.mkString(" and ");System.out.println("""res3: String = """ + $show(res$3));$skip(45); 
    
    val matrix = Array.ofDim[Int](3, 4);System.out.println("""matrix  : Array[Array[Int]] = """ + $show(matrix ));$skip(21); 
    matrix(1)(1) = 3;$skip(11); val res$4 = 
    matrix;System.out.println("""res4: Array[Array[Int]] = """ + $show(res$4))}
}
