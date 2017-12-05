package match_pkg

object CaseClass03 {
  def main(args: Array[String]): Unit = {
    sealed abstract class TrafficLightColor       //可以使用样例类来模拟枚举类型
    case object Red extends TrafficLightColor
    case object Yellow extends TrafficLightColor
    case object Green extends TrafficLightColor
     
    var color:TrafficLightColor = Red
    val str = color match {
      case Red => "stop"
      case Yellow => "hurry up"
      case Green => "go"
    }
    println(str)
  }
}