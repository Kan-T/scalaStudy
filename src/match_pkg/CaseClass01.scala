package match_pkg

object CaseClass01 {
  sealed abstract class Amount        //sealed： 密封类。密封类的所有子类都必须在与该密封类相同的文件中定义。
                                      //让所有同一组的样例类都扩展某个密封的类或特质是个好的做法。
  // 继承了普通类的两个样例类                    
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
  // 样例对象
  case object Nothing extends Amount
//在声明样例类时，下面的过程自动发生了：
//构造器的每个参数都成为val，除非显式被声明为var，但是并不推荐这么做；
//在伴生对象中提供了apply方法，所以可以不使用new关键字就可构建对象；
//提供unapply方法使模式匹配可以工作；
//生成toString、equals、hashCode和copy方法，除非显示给出这些方法的定义。
//除了上述之外，样例类和其他类型完全一样，方法字段等。
  
  def main(args: Array[String]): Unit = {
    val amt: Amount = Currency(29.95, "RMB")
    amt match {
      case Dollar(v) => print("$" + v)
      case x Currency "RMB" => print(x + "RMB")               //中置表示法：如果unapply方法产出一个对偶，则可在case语句中用来表示unapply方法
      case Currency(_, u) => print("Oh noes, I got " + u)    //如果case关键字后跟着一个变量，则匹配表达式会被赋值给那个变量
      case Nothing => print("Nothing")                       // 样例对象没有()
    }
    

  }
}