package advanced

object ExtendsDemo02 {
  
  class Creature {
    val range: Int = 10
    val env: Array[Int] = new Array[Int](range)
  }
  
//  class Ant extends Creature{                //快学scala 8.10
//    override val range:Int = 2               //在构造器内依赖val字段的值 可能不稳定
//  }

  class Ant extends {                        //提前定义 - 让你可以在超类构造器执行之前初始化子类的val字段
    override val range:Int = 2
  } with Creature
  
  def main(args: Array[String]): Unit = {
    println(new Creature().env.length)
    println(new Ant().range)
    println(new Ant().env.length)
  }
  
}