package advanced

object ApplyDemo01 {
  
  class Fraction(val num: Int, val den: Int){
    def *(other: Fraction) = new Fraction( num * other.num, den * other.den )
  }
  
  object Fraction{
    //apply 方法
    def apply(num: Int, den: Int) = new Fraction(num, den)                        
    
    //unapply 方法 - 提取器。接受对象，然后从中提取值。
    def unapply(f: Fraction) = if (f.den == 0) None else Some((f.num, f.den))    
    
  }
  
  def main(args: Array[String]): Unit = {
    
    //1. 在定义变量时使用unapply 方法。 变量a，b通过unapply方法取到值。
    val Fraction(a, b) = Fraction(3, 4) * Fraction(1, 2)    
    println("3/4 * 1/2 = " + a + "/" + b)
    
    //2. 用于模式匹配
    Fraction(1,2) match{
      case Fraction(a, b) => println("Matched fraction: " + a + "/" + b)
    }
    
  }
}