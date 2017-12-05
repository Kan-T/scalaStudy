package collection

object ZipDemo {
  def main(args: Array[String]): Unit = {
    println("ken"*2)
    
    val symbols = Array("[","-","]")
    val counts = Array(2,5,2)
    val pairs = symbols.zip(counts)          //> pairs  : Array[(String, Int)] = Array(([,2), (-,5), (],2))  Tuple为元素的数组
    for ((x,y) <- pairs) print(x*y)
    
    println("\n==== 如果有一个键值的集合，可以用toMap方法转换成映射 ====")
    println(pairs.toMap)
    
  }
}