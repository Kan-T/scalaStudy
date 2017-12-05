package match_pkg

object MatchDemo01 {
  def main(args: Array[String]): Unit = {
    var sign = 0
    val ch: Char = '6'
    
    println; println("========== Old Style ==========")
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ => sign = 0                                    //case _ 表示捕获所有模式，等效于default
    }
    println("sign = " + sign)   
    
    println; println("========== 表达式 Style ==========")
    sign = ch match {
      case '+' => 1
      case '-' => -1
      case _ => 0
    }
    println("sign = " + sign)
    
    println; println("========== 每个case可添加 守卫 ==========")
    var digit = 0
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
//      case _ if Character.isDigit(ch) => { sign = 2; digit = Integer.parseInt(ch.toString()) }
//      case _ if ch.isDigit => { sign = 2; digit = ch.toInt - '0'.toInt }
      case _ if ch.isDigit => { sign = 2; digit = ch.asDigit }
      case _ => sign = 0                                    
    }
    println("sign = " + sign + "; digit = " + digit) 
    
    println; println("========== variables in Match statement ==========")
    var x = 'a'
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case x  => { sign = 2; digit = x.asDigit }        //如果case关键字后跟着一个变量，则匹配的表达式会被赋值给那个变量 (此处x作用域在match语句中)
//      case _ => sign = 0                              //this case became unreachable. Because "case a" covers all.       
    }
    println("sign = " + sign + "; digit = " + digit) 
    println("x = " + x)
    
    println; println("========== Match Type ==========")
    var obj: Any = 'c'
    obj match {
      case int: Int => println("Int type.")
      case s: String => println("String type.")
      case _: Char => println("Char type.")
      case _ => println("Unknown type.")
    }
    
  }
}