package advanced

object ExtendsDemo01 {
  
  sealed class Person(val name: String, var age: Int){     //sealed： 密封类。密封类的所有子类都必须在与该密封类相同的文件中定义。
    final override def equals(other: Any): Boolean = {     //覆写AnyRef.euqals方法。 定义为final, 不能被子类override。处于对称性考虑，子类中很难正确的扩展此方法。
      if(other.isInstanceOf[Person]) {} else return(false) 
      val that = other.asInstanceOf[Person]
      if(that == null) false
      else name == that.name && age == that.age
    }
  }
  
  class Employee(name: String, age: Int, var salary: Double) extends Person(name, age){      //子类主构造器调用超类主构造器
  
  }

  def main(args: Array[String]): Unit = {
    val emp = new Employee("Ken", 33, 20000.0)
    
    if( emp.isInstanceOf[Person] ) {                        //类型检查
      println("emp is an person.")    
      val per = emp.asInstanceOf[Person]                    //类型转换
      if(per.getClass == classOf[Employee]) println("per is still an employee. per's Class:  " + per.getClass)
    }
    
    
    val per1 = new Person("Ken", 33)                        //对象的比较
    val per2 = new Person("Ken", 33)
    val arr  = Array("Ken")
    println(per1.equals(per2))
    println(per1 == per2)
    println(arr == per2)
  }
}