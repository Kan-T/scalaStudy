package advanced

import java.io.PrintStream

trait Logged{
  def log(msg: String) { println("Logged!") }
}

trait ConsoleLogger extends Logged{
  override def log(msg: String){ println(msg) }
}

trait FileLogger extends Logged{
  val filename: String
  println("FileLogger constructed. filename = " + filename)
  
  val out = new PrintStream(filename)
  override def log(msg: String){ out.println(msg); out.flush() }
}

trait TimestampLogger extends Logged{
  override def log(msg: String){
    super.log(new java.util.Date() + " " + msg)    //super.log() 将调用 特质层级 中下一层级的log方法。
  }
}

trait ShortLogger extends Logged{
  val maxLength: Int                               //抽象字段
  override def log(msg: String){
    super.log( if(msg.length <= maxLength) msg else (msg.substring( 0, maxLength - 3 ) + "...") )  
  }
}

class SavingsAccount(name: String) extends Account(name) with Logged{
  println("SavingsAccount constructed.")            //SavingsAccount construct 的一部分
  def withdraw(amount: Double){
    if(amount > balance) log("Insufficient funds")
    else {
      balance -= amount
      log("Withdraw succeed")
    }
  }
}

object TraitDemo01 {
  def main(args: Array[String]): Unit = {

    var acct = new SavingsAccount("Allen")
   acct.deposit(1000); acct.withdraw(300)
   
   acct = new SavingsAccount("Tom") with ConsoleLogger      //ConsoleLogger子类中的log覆写了超类logged中的log方法
   acct.deposit(1000); acct.withdraw(300)
   
   acct = new SavingsAccount("Tom") with ConsoleLogger with TimestampLogger with ShortLogger{val maxLength = 15}    //override 特质中的 抽象字段
   acct.deposit(1000); acct.withdraw(300)
   
   acct = new SavingsAccount("Tom") with ConsoleLogger with ShortLogger with TimestampLogger{val maxLength = 15}    //特质从最后一个开始被处理 
   acct.deposit(1000); acct.withdraw(300)
   
//   acct = new SavingsAccount("Tom") with FileLogger{val filename = "c:\\camera.log"}           //这是一个匿名子类。子类是最后被构造的。所以会出错，需要用“提前定义”
   acct = new{val filename = "c:\\camera.log"} with SavingsAccount("Tom") with FileLogger      //提前定义
   acct.deposit(1000); acct.withdraw(300)
  }
}