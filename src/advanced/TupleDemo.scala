package advanced

object TupleDemo {
  def main(args: Array[String]): Unit = {
    
    val tuple = (1,2,3.14,"Rocky","Spark")
    println("1. " + tuple._3)                //Tuple中，元素的index从1开始。 
    
    val (first,sec,third,fourth, _) = tuple  //Tuple可以直接赋值给Tuple，不想接收的内容可用占位符
    println("2. " + sec) 
    
    val (s1, s2) = "Rocky Spark".partition(_.isUpper)   //同样的语法可用于任何带变量的模式中，如List，Array
    println("2. " + s1 + "; " + s2)
    
  }
}