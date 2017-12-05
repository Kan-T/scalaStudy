package advanced

object ClassConstructors {
  class Person(val name: String, var sex: Char = ' ', var age: Int = 0){    //主构造器。私有字段，公有getter/setter方法。
    println("This is a part of the main constructor")
    
    def this(name: String, sex: Char){                                       //辅助构造器的名称为this
      this(name)                                                             //辅助构造器必须以对（已定义好的）主构造器 或 其他辅助构造器 的调用开始
      println("This is auxiliary constructor")
      this.sex = sex
    }
    
  }
  
  def main(args: Array[String]): Unit = {
  println( new Person("Ken", 'M') )  
  }
  
}