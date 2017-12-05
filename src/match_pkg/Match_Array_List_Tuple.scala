package match_pkg

object Match_Array_List_Tuple {
  def main(args: Array[String]): Unit = {
    
    println; println("========== Match Array ==========")
    val arr = Array(0,1,3)
    arr match {
      case Array(0) => println("0")                //Match包含一个0的数组
      case Array(x, y) => println(x + " " + y)     //Match任何带2个元素的数组; 
      case Array(0, _*) => println("0....")        //Match任何以0开头的数组
      case _ => println("something else")
    }
    
    println; println("========== Match List ==========")
    val lst = List(0, 1, 3)
    lst match{
      case 0 :: Nil => println("0")                  //与Match Array中case相似
      case x :: y :: Nil => println(x + " " + y)
      case 0 :: tail => println("0....")
      case _ => println("something else")
    }
    
    println; println("========== Match Tuple ==========")
    val tup = (0, 1)
    tup match {
      case (0, _) => println("0....")
      case (y, 0) => println(y + "0")
      case _ => println("something else")
    }
  }
}