package generic_pkg
//泛型: 即“参数化类型”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。那么参数化类型怎么理解呢？
//      顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），
//      然后在使用/调用时传入具体的类型（类型实参）。


class Pare[T, S](val first: T, val Second: S)  //泛型类：带有1个或多个类型参数
  
object Basic01 {
  def main(args: Array[String]): Unit = {
    val p1 = new Pare(42, "String")              //推断类型
    val p2 = new Pare[Any, Any](42, "String")    //自定义类型
    
    println; println("========== 泛型函数 ==========") 
    def getMiddle[T](a: Array[T]) = a( a.length / 2 )
    val arr = Array(1,2,3,4,5)
    println(getMiddle(arr))
    
  }
}