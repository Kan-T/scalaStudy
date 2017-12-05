package advanced

class Account(var name: String){                      //主构造器参数直接放在类名后，setter/getter自动生成
  println("==========Call Account main constructor===========")

  val id = Account.newUniqueID()                    //作用域内不可见，所以要加上 Account.
  var balance = 0.0
  def deposit(amount: Double) = { this.balance += amount }
  
  override def toString = "Name: " + this.name + ", ID: " + this.id
}

object Account{                        //伴生对象  ==> 经常作为伴生类的静态成员，方法的封装区域
  private var lastId = 0
  def newUniqueID() = {lastId += 1; lastId}
  
  def apply(name: String) = {                        //apply()方法，它相当于覆写了()方法，外部通过Account()调用
    println("==========Call apply()===========")
    new Account(name)
  }

}

object CompanionObj {
  def main(args: Array[String]): Unit = {
      println(Account.newUniqueID())
      println(Account.newUniqueID())
      
      val per1 = Account("Ken")                     //调用apply()方法，然后构造对象
      println(per1)
      
      val per2 = new Account("Cassie")              //调用主构造器构造对象
      println(per2)
      
  }
}