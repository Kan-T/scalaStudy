package advanced

trait LoggedException extends Exception with ConsoleLogger{    //特质扩展类，这个类将会自动成为所有混入该特质的超类
  def log() {
    log( getMessage() )
  }
}

class UnhappyException extends LoggedException {               //Exception自动成为UnhappyException的超类
  override def getMessage() = "Unhappy!"                       //覆写Exception的方法
}

object TraitDemo02 {
  def main(args: Array[String]): Unit = {
    var e = new UnhappyException
    e.log()   
  }
}