package start

object HelloWorld {                          //In Scala, object is the entry for program.
  def main(args: Array[String]): Unit = {    //def function name(arg: arg type) | Unit: no return value.
    println("Hello world.")
    
    val chars = for(c <- "Char" if c.isUpper) yield c 
    println(chars)
    
    for(arg <- args){                         //print all args
      println(arg)
    }
  }
}