package advanced

import TrafficLightColor._
import Margin._
object EnumDemo02 extends App {                  //App特质。能快速将对象转化为 可执行的程序。 不需要定义main方法。
  println(BOTTOM, BOTTOM.id)
 
  def doWhat(color: TrafficLightColor) = {
    if (color == Red) "stop"
    else if (color == Yellow) "hurry up" else "go"
  }
 
  //使用match匹配
  def doWhat2(color: TrafficLightColor) = color match {
    case Red    => "stop"
    case Yellow => "hurry up"
    case _      => "go"
  }
 
  // load Red
  val red = TrafficLightColor(0)         // Calls Enumeration.apply 
  println(red, red.id)
  println(doWhat(red))
  println(doWhat2(TrafficLightColor.Yellow))
  println
   
   //打印出所有枚举
  Margin.values.foreach { v => println(v,v.id)}
}
