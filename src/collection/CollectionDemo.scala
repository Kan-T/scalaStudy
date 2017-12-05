package collection

import scala.io.Source
import scala.collection.immutable.Stream.consWrapper
import scala.math.BigInt.int2bigInt

object CollectionDemo {
  def main(args: Array[String]): Unit = {
  //任何以冒号结果的操作符，都是右绑定的，即 0 :: List(1,2,3) = List(1,2,3).::(0) = List(0,1,2,3) 从这里可以看出操作::其实是右边List的操作符，而非左边Int类型的操作符
  //一般而言：+ 用于无序集合，如 Set ； +: 或 :+ 用于有序集合，如 List
  val left = List(1,2,3)
  val right = List(4,5,6)
  
  //以下操作等价
  println(left union right)
  println(left ++ right)     
  println(left ++: right) 
  println(right.++:(left))
  println(right.:::(left))
  
  //以下操作等价
  0 +: left    //List(0,1,2,3)
  left.+:(0)   //List(0,1,2,3)
  
  //以下操作等价
  left :+ 4    //List(1,2,3,4)
  left.:+(4)   //List(1,2,3,4)
  
  //以下操作等价
  0 :: left      //List(0,1,2,3)
  left.::(0)     //List(0,1,2,3)
  
  println; println("========== map split Demo ==========") 
  val nums = List(1,2,3)
  val square = (x: Int) => x*x  
//  def square(x: Int) = x*x                    //与上面方法定义的函数等效
  
  val squareNums1 = nums.map(num => num*num)   //List(1,4,9)
  val squareNums2 = nums.map(math.pow(_,2))    //List(1,4,9)
  val squareNums3 = nums.map(square)           //List(1,4,9)
  
  val text = List("Homeway,25,Male","XSDYM,23,Female")
  val usersList = text.map(_.split(",")(0))    
  val usersWithAgeList = text.map(line => {
      val fields = line.split(",")
      val user = fields(0)
      val age = fields(1).toInt
      (user,age)
      })
  println(usersList)
  println(usersWithAgeList)
  
  println; println("========== .flatMap, flatten ==========") 
  val text2 = List("A,B,C","D,E,F")
  val textMapped = text2.map(_.split(",").toList) // List(List("A","B","C"),List("D","E","F"))
  val textFlattened = textMapped.flatten          // List("A","B","C","D","E","F")
  val textFlatMapped = text2.flatMap(_.split(",").toList) // List("A","B","C","D","E","F")
  
  println; println("========== reduce ==========") 
  val nums2 = List(1,2,3)
  val sum1 = nums2.reduce((a,b) => a+b)   //6
  val sum2 = nums2.reduce(_+_)            //6
  val sum3 = nums2.sum                    //6
  
  println; println("========== reduce ==========") 
  val nums3 = List(2.0,2.0,3.0)
  val resultLeftReduce = nums3.reduceLeft(math.pow)  // = pow( pow(2.0,2.0) , 3.0) = 64.0
  val resultRightReduce = nums3.reduceRight(math.pow) // = pow(2.0, pow(2.0,3.0)) = 256.0
  
  println; println("========== fold 比reduce多一个初始值==========") 
  val nums4 = List(2,3,4)
  val sum4 = nums.fold(1)(_+_)  // = 1+2+3+4 = 9
  
  val nums5 = List(2.0,3.0)
  val result1 = nums5.foldLeft(4.0)(math.pow) // = pow(pow(4.0,2.0),3.0) = 4096
  val result2 = nums5.foldRight(1.0)(math.pow) // = pow(1.0,pow(2.0,3.0)) = 8.0
  
  println; println("========== sortBy,sortWith,sorted ==========") 
//  sortBy: sortBy[B](f: (A) ⇒ B)(implicit ord: math.Ordering[B]): List[A] 按照应用函数f之后产生的元素进行排序
//  sorted： sorted[B >: A](implicit ord: math.Ordering[B]): List[A] 按照元素自身进行排序
//  sortWith： sortWith(lt: (A, A) ⇒ Boolean): List[A] 使用自定义的比较函数进行排序
  val nums6 = List(1,3,2,4)
  val sorted = nums6.sorted  //List(1,2,3,4)
  
  val users = List(("HomeWay",25),("XSDYM",23))
  val sortedByAge = users.sortBy{case(user,age) => age}  //List(("XSDYM",23),("HomeWay",25))
  val sortedWith = users.sortWith{case(user1,user2) => user1._2 < user2._2} //List(("XSDYM",23),("HomeWay",25))
  
  println; println("========== filter, filterNot ==========") 
  //filter 保留列表中符合条件p的列表元素 ， filterNot，保留列表中不符合条件p的列表元素
  val nums7 = List(1,2,3,4)
  val odd = nums7.filter( _ % 2 != 0) // List(1,3)
  val even = nums7.filterNot( _ % 2 != 0) // List(2,4)
  
  println; println("========== 并行集合 par方法 ==========")  
  val coll = 1 to 10
  println("coll.par.sum: " + coll.par.sum)
  for(i <- (0 until 6).par) println(i + ": " + Thread.currentThread().getName)                    //并行处理时输出，顺序会乱
  println
  val seq = for(i <- (0 until 6).par) yield(i + ": " + Thread.currentThread().getName + "\n")    //顺序不会乱
  println(seq)
  val seq2 = (0 until 6).par.map(_ + ": " + Thread.currentThread().getName)                       //顺序不会乱
  println(seq2)
  
  println; println("==========流 Steam ==========")
  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n+1)         //此方法返回Stream对象
  val tenOrMore = numsFrom(10)
  println(tenOrMore)
  val squares = numsFrom(10).map(x => x * x)                            //Stream尾部是懒设计，它只会求当前值
  println(squares)
  println(squares.tail.tail)                                            //.tail会强制对下一元素求职
  println(squares)
  println(squares.take(5).force)                                        //调用take(n).force，可取出n个元素，再强制对所有元素求值
  println(squares)
  println("=======iterator.toStream=======")
  val lines = Source.fromFile("C:\\camera.log").getLines.toStream      //toStream: Converts this iterable collection to a stream.
  println(lines(1))                                                     //读第5个元素（从0算起）
  println(lines)                                                        //之前缓冲的元素也会一起读出来
  }
}