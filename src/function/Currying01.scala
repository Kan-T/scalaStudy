package function

object Currying01 {
  def mul(x:Int, y:Int) = x * y                  //原始的 接受2个参数的函数
  def mulOne(x:Int) = (y:Int) => x * y           //柯里化 - 将接受2个参数的函数 转化成 接受1个参数的函数
                                                 //传入参数(x:Int)， 得到结果函数 (y:Int) => x * y
  def mulByOne(x:Int)(y:Int) = x * y             //简化的 柯里化 定义  
  
  def main(args: Array[String]): Unit = {
    println( mulOne(2)(3) )                      //调用 柯里化的函数
    println( mulByOne(2)(3) )                    //调用 柯里化的函数
    
    println("Another example: ")
    val a = Array("Hello", "World")
    val b = Array("hello", "world")
//    val isEqual = a.corresponds(b)( (x, y) => x.equalsIgnoreCase(y) )    //StringOps 下的 corresponds 方法就是柯里化的函数。其后一个参数是一个二元函数。
    val isEqual = a.corresponds(b)(_.equalsIgnoreCase(_))                  //由于二元函数中的2个参数类型已可确定，所以可以用 _ 简化语句
    println("Is a equal to b: " + isEqual)
  }
}