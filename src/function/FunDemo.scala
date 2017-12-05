package function

object FunDemo extends App{
  //一元函数
  val square = (x: Int) => x * x         //函数可以赋给变量、常量。 square是scala.Function1的一个实现。以下是完整定义
//  val square: Function1[Int,Int] = (x: Int) => x * x
  
  //二元函数
  val sum = (x: Int, y: Int) => x + y    //sum是scala.Function2的一个实现
  val a = sum(3, 5)
  
  //偏函数    It can specify inputs which it will not handle. 
  val f: PartialFunction[Char, Int] = { case '+' => 1; case '-' => 0 }
  println(f('-'))
  println(f.isDefinedAt(1))               //isDefinedAt: Checks if a value is contained in the function's domain.
  println(f.isDefinedAt('+'))
//  println(f('x'))                       //it will cause error
  
}