package advanced

//在Scala中并没有枚举类型，但在标准类库中提供了Enumeration类来产出枚举。扩展Enumeration类后，调用Value方法来初始化枚举中的可能值。
//Value是Enumeration的方法，它返回Enumeration的一个内部类，该内部类也叫Value。

object TrafficLightColor extends Enumeration {      //枚举的类型是TrafficLightColor.Value
  type TrafficLightColor = Value     //增加一个类型别名，现在枚举的类型是 TrafficLightColor.TrafficLightColor
  val Red = Value(0, "Stop")         //内部类Value实际上是一个抽象类，真正创建的是Val。因为实际上是Val，所以可以为Value传入id和name
  val Yellow = Value(10)             //如果不指定，id就是在前一个枚举值id上加一，name则是字段名        
  val Green = Value("Go")
}
 
object Margin extends Enumeration {
  type Margin = Value
  val TOP, BOTTOM, LEFT, RIGHT = Value
}
 
object EnumDemo01 {
  def main(args: Array[String]): Unit = {
    
  }
}