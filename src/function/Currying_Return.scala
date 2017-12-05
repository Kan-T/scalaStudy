package function
  
object Currying_Return {
  def until(condition: => Boolean)(block: => Unit){      //Currying 柯里化          ; 控制抽象
    if(!condition){
      block
      until(condition)(block)
    }
  }
  
  def indexOf(str: String, ch: Char): Int = {            //return 对于控制抽象很有用
    var i = 0
    until(i == str.length){
      if (str(i) == ch) return i                        //返回给带名函数
      i += 1
    }
    return -1
  }
  
  def main(args: Array[String]): Unit = {
    val list = scala.collection.immutable.List("imutable", "list")
    var varList = list                                    
    varList = list :+ "can modify"
    println("list:		" + list)                           //val对象不回改变
    println("varList:	" + varList)                        //var对象改变不影响val对象
    
    println(indexOf("Hello World.", 'e'))
  }
}
