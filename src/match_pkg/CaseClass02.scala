package match_pkg

object CaseClass02 {
  //简化的List结构：
  abstract class List
  case object Nil extends List
  case class ::(head: Any, tail: List) extends List
  
  def main(args: Array[String]): Unit = {
    val lst = ::("Hello", ::("World", Nil))
    lst match{
//      case "Hello" :: _ => print("Hello ....")         //中置表示法：如果unapply方法产出一个对偶，则可在case语句中用来表示unapply方法
      case "Hello" :: ( l @ _ ) => print("Hello" + l)    //用@可将嵌套的置绑定到变量。  此处其实可以直接用 变量l 替换 ( l @ _ )
    }
    
  }
}