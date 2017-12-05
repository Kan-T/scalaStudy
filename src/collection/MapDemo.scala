package collection

object MapDemo {
  def main(args: Array[String]): Unit = {
    
    val map = Map("book"->10,"gun"->18,"ipad"->1000)                    //default map type is immutable
//    map -= "gun"                                                      //immutable Map can't be changed
    val map1 = for((k,v) <- map) yield(k,v*0.9)
    println("1. " + map1)
    
    var map2 = Map("book"->10,"gun"->18,"ipad"->1000)                  //val和var
    map2 -= "gun"                                                      //val和var 表明定义的变量（引用！）是否能被修改而指向其他内容
    
    val scores = scala.collection.mutable.Map("scala"->7,"hadoop"->8,"spark"->9)    //Mutable map
    val hadoopScore = scores.getOrElse("hadxxp", 0)                                 //wrong key
    println("2. " + hadoopScore)
    
    scores += ("R"->9)                                                  //add element
    scores += ("R"->8)                                                  //add an existing one to update element
    scores -= "hadoop"                                                  //remove element
    println("3. " + scores)
    
//    scores("hadoop") = 7                                              //another way to add element
    scores("hadoop") = scores.getOrElse("hadoop", 7)
    println("4. " + scores)
    
    scores += ("Flink" -> scores.getOrElse("Flink", 8))
    println("5. " + scores)
    
    scores += ("Flink" -> 9)                                            //key重复，第二个将第一个覆盖
    println("6. " + scores)
    
    val sortedScores = scala.collection.immutable.SortedMap("scala"->7,"hadoop"->8,"spark"->9)    //SortedMap自动排序
    println("7. " + sortedScores)
       
  }
}