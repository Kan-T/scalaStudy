package start

object For_Function {
  def main(args: Array[String]): Unit = {
    println("==================For==================")
    for(i <- 1 to 2; j <- 1 to 2) print((100 * i + j) + "  ")
    println
    
    for(i <- 1 to 2; j <- 1 to 2 if i != j) print((100 * i + j) + "  ")   //守卫
    println
    
    println("==================Function==================")
    def add100(x: Int) = x + 100                //函数都有返回值（Unit表示null返回值），一般Scala可根据上下文推断出函数返回值，不用声明
    println("add100(2) : " + add100(2))
    
    val add = (x: Int) => x + 200               //=号右边是匿名函数
    println("add(2) : " + add(2))               //打印常量add，2作为参数传给了匿名函数
    
    def fac(n: Int): Int = if(n<=0) 1 else n * fac(n -1)    //递归调用中，必须指明返回值类型
    println("fac(10) : " + fac(10))
    
    def combine(content: String, left: String = "[", right: String = "]") = left + content + right
    println("combine() : " + combine("I am good"))          //函数的参数可以指定默认值
    
    def sum(args: Int*) = {                    //可变参数，参数个数是可变的
      var sum  = 0
      for (arg <- args) sum += arg
      sum
    }
    println("sum(1,2,3,4,5) : " + sum(1,2,3,4,5))
  }
}