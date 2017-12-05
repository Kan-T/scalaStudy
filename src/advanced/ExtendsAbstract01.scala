package advanced

object ExtendsAbstract01 {
  abstract class Person(val name: String){   
    def id: Int                                //抽象方法，没有方法体
  }
  
  class Employee(name: String, var salary: Double) extends Person(name){      //子类主构造器调用超类主构造器
    def id = name.hashCode()                   //覆写超类抽象方法时，不需要加override
  }

  def main(args: Array[String]): Unit = {
    
    
  }
}