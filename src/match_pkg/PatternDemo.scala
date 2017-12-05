package match_pkg

import scala.collection.JavaConversions.propertiesAsScalaMap

object PatternDemo {
  def main(args: Array[String]): Unit = {
    
    val (x, y) = (1, 2)                   
    println("x = " + x + "; y = " + y)
    
    val (q, r) = BigInt(10) /% 3
    println("q = " + q + "; r = " + r)
    
    val arr = Array(1, 2, 3, 4, 5)
    val Array(first, sec, _*) = arr
    println("first = " + first + "; sec = " + sec)
    
    val pattern = "([0-9]+) ([a-z]+)".r
    "99 bottles" match {
        case pattern(num, item) => println(num + " -> " + item)
     }
    
    val (s1, s2) = "Rocky Spark".partition(_.isUpper)
    println(s1 + "; " + s2)
    
//    for ((k, v) <- java.lang.System.getProperties) println(k + " -> " + v)
//    for ((k, v) <- java.lang.System.getProperties if k == "java.vm.version") println(k + " -> " + v)    
    for (("java.vm.version", v) <- java.lang.System.getProperties) println("java.vm.version" + " -> " + v)
    
    
  }
}