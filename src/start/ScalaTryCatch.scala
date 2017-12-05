package start

object ScalaTryCatch {
  def main(args: Array[String]): Unit = {
    val n =  97
    try{
      val half = if(n % 2 == 0) n / 2 else throw               //throw表达式类型是Nothing。if/else表达式中，如果一个分支是Nothing，则if/else表达式类型就是另一分支的类型。
          new RuntimeException("N must be even")
    }catch{
      case e: RuntimeException => println("The exception is : " + e.getMessage())
      case _: Exception => println("The exception is not a RuntimeException")        //如果不需要使用捕获的异常对象，可以使用通配符_来代替
    }finally{
      println("PGM will always execute finally, whether successful or not.")
    }
  }
}