package start

object Basic02 {

  println("\n==================Static Block==================")
  println("It will execute before main function.")
  
  def main(args: Array[String]){                      

    println("\n==================if else==================")
/*    var file = "scala.txt"
      if(!args.isEmpty) file = args(0)*/
    var file = if(!args.isEmpty) args(0) else "scala.txt"
    println(file)
    
    
    println("\n==================for loop==================")
    for(i <- 1 to 3){                      //1 to 10  ==> 1.to(10) : it's a function of object 1.
      println("Number is " + i)
    }
    
    println("====================================")
    val files = new java.io.File(".").listFiles()
    for(file <- files){                    //foreach: for(temp var <- array)
      println(file)
    }
  }
}