package advanced

object ExtendsAbstract02 {
  abstract class Person{   
    val name: String                          //没有初始化 - 带抽象 getter 方法的抽象字段
    var id: Int                               //带抽象 getter 和 setter 方法的抽象字段
    println("Person constructed.")
  }
  
  class Emp01(val name: String) extends Person{    //子类必须提供具体字段
    var id = name.hashCode()
    println("Emp01 constructed.")
  }

  def main(args: Array[String]): Unit = {
    val Ken = new Emp01("Ken")
    val Fred = new Person{                    //匿名子类 - 用匿名类型来定制抽象字段
      val name = "Fred"                       //{..}中的内容是匿名子类构造函数的一部分
      var id = 1
      println("Fred constructed.")
    }
    
  }
}