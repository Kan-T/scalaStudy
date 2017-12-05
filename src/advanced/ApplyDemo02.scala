package advanced

object ApplyDemo02 {
  
  class Name(val name: String){
      
  }
  
  object Name{
  
//    def unapply(name: String) = {
//      val pos = name.indexOf(" ")
//      if (pos == -1) None
//      else Some((name.substring(0,pos)), name.substring(pos + 1))
//    }
    
    //unapplySeq 方法 - 提取器。提取任意长度的值得序列
    def unapplySeq(name: String): Option[Seq[String]] = if (name.trim == "") None else Some(name.trim.split("\\s+"))    
    
  }
  
  def main(args: Array[String]): Unit = {
    val mike = "Mike Cut"                //注意，此处unapply 和 unapplySeq 方法的参数是字符串。
    val tom = "Tom D Green"
    
    val Name(first, last) = mike
    println("mike's First name is " + first + " & mike's Last name is " + last)
    
    mike match{
      case Name(s1) => println("First name")
      case Name(first, last) => println("First & Last name")
    }
    
    tom match{
      case Name(first) => println("First name")
      case Name(first, last) => println("First & Last name")
      case Name(first, middle, last) => println("First & middle & Last name")
    }
  }
}