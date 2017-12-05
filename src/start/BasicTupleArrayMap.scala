package start

object BasicTupleArrayMap {
  def main(args: Array[String]): Unit = {
    println("\n==================Tuple==================")
    val tuple = (100,"Scala","Spark")
    println(tuple._1)                  //Tuple index starts from 1
    println(tuple._2)
    
    println("\n==================Array==================")
    val array = Array(1,2,3)
//    for(i <- 0 until array.length){
//      println(array(i))
//    }
    for(elmt <- array) println(elmt)
    
    println("\n==================Map==================")
    val age = Map("Ken" -> 33, "Cassie" -> 31)
    for((k,v) <- age){
      println("Key ==>	" + k + ",	value ==>	" + v)
    }
    for((k,_) <- age){      //placeholder 占位符
      println("Key ==>	" + k)
    }
  }
}