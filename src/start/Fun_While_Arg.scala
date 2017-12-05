package start

object Fun_While_Arg {

  //Function with no arg
  def doWhile(){                                       //This function has no return value, then it is also a process.
    var line = ""  
    do{
        line = readLine("Please enter: ")               //Scala automatically searches several packages, eg. predef 
        println("Read: " + line)      
    } while(line != "")
  }
  
  //Function with arg
  def looper(x: Long = 92, y: Long): Long={             //x: Long = 92  => Default value for the argument.
    var a = x
    var b = y
    while(a != 0){
      val temp = a
      a = b % a
      b = temp
    }
    b                                                 //return b
  }
  
  //变长参数
  def sum(args: Int*) ={                              //不指定返回类型，scala会推断出返回类型
    var sum = 0
    for (arg <- args) sum += arg
    sum
  }
  
  def main(args: Array[String]){                      //Unit can be omitted

    println("\n==================Method with no arg==================")    
    doWhile()                                         //Same as doWhile, () can be omitted.
    
    println("\n==================Method with arg==================")
    println( looper(92, 100) )
    println( looper(y=100) )                          //y=100  => 带名参数，这里参数x用的默认值。
    
    println("\n==================  变长参数方法  =================")    
    println( sum(1 to 10: _*) )                       //_*  => 一个序列的值的参数不能直接传给函数。 _*告诉编译器，希望这个参数被当做参数序列处理。
    
  }
  
}