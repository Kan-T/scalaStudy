package advanced

import scala.beans.BeanProperty

object ClassDemo {
   
  class Student{                   //Scala中的类不声明为public(默认即表示public)，一个Scala源文件中可以有多个类。 也可以标记访问修饰符private和protected
   var age = 0                     //Scala默认生成private的age字段；以及public的（getter/setter）方法，它们分别叫做age和age_=
   @BeanProperty var name:String = _     //@BeanProperty => 生成JAVA依赖的 getName() 和 setName() 方法
  }                                      //字段如果是val => val只生成getter方法，不生成setter方法；
  
  class Student_P{
   private var privateAge = 10    //Scala类中，指定为private的字段，将自动生成private的（getter/setter）方法。外部无法访问。
   def age = privateAge            //覆写age方法。方法默认为public
  }
  
  class Per{                     
//    private[this] var age = 0     //private[this] => 对象私有，方法只能访问当前对象的age字段，不能访问Per类型的其他对象的该字段。
    private var age = 0            
    
    def increment(){                //类的方法可以访问该类所有对象的private字段
      age += 1
    }  
    def current = age 
    def isOlder(other: Per) = age > other.age    //可以访问另一个对象的private对象。类的方法可以访问该类的所有对象的私有字段。
  }
  
  def main(args: Array[String]): Unit = {
    
    val student = new Student
    student.age = 20                //实际在JVM中，还是调用的student.age_= 的setter方法
    student.setName("Fred")         //调用@BeanProperty生成的JAVA setter方法
    println(student.name + "'s age is " + student.age)            //getter方法            
    
    val p = new Student_P
    println(p.age)
    
    val person1 = new Per()
    val person2 = new Per()
    person1.increment()              //调用无参方法时，圆括号是可写可不写的。推荐的做法是：如果是会改变对象状态的方法，就带上()；否则，就不带。
    println(person1.current)
    println(person1 isOlder person2)
  }
}