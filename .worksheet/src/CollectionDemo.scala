import scala.io.Source
import scala.collection.immutable.Stream.consWrapper
import scala.math.BigInt.int2bigInt

object CollectionDemo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(279); 

  //任何以冒号结果的操作符，都是右绑定的，即 0 :: List(1,2,3) = List(1,2,3).::(0) = List(0,1,2,3) 从这里可以看出操作::其实是右边List的操作符，而非左边Int类型的操作符
  val left = List(1,2,3);System.out.println("""left  : List[Int] = """ + $show(left ));$skip(26); 
  val right = List(4,5,6);System.out.println("""right  : List[Int] = """ + $show(right ));$skip(33); val res$0 = 
  
  //以下操作等价
  left union right;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(16); val res$1 = 
  left ++ right;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(39); val res$2 = 
  left ++: right;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(42); val res$3 =   // List(1,2,3,4,5,6)
  right.++:(left);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(40); val res$4 =     // List(1,2,3,4,5,6)
  right.:::(left);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(45); val res$5 =   // List(1,2,3,4,5,6)
  
  //以下操作等价
  0 +: left;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(31); val res$6 =     //List(0,1,2,3)
  left.+:(0);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(45); val res$7 =    //List(0,1,2,3)
  
  //以下操作等价
  left :+ 4;System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(31); val res$8 =     //List(1,2,3,4)
  left.:+(4);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(47); val res$9 =    //List(1,2,3,4)
  
  //以下操作等价
  0 :: left;System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(33); val res$10 =       //List(0,1,2,3)
  left.::(0);System.out.println("""res10: List[Int] = """ + $show(res$10));$skip(62);      //List(0,1,2,3)
  
  println; println("========== map split Demo ==========");$skip(25); 
  val nums = List(1,2,3);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(31); 
  val square = (x: Int) => x*x;System.out.println("""square  : Int => Int = """ + $show(square ));$skip(61); 
  val squareNums1 = nums.map(num => num*num);System.out.println("""squareNums1  : List[Int] = """ + $show(squareNums1 ));$skip(61);    //List(1,4,9)
  val squareNums2 = nums.map(math.pow(_,2));System.out.println("""squareNums2  : List[Double] = """ + $show(squareNums2 ));$skip(61);     //List(1,4,9)
  val squareNums3 = nums.map(square);System.out.println("""squareNums3  : List[Int] = """ + $show(squareNums3 ));$skip(58);            //List(1,4,9)
  
  val text = List("Homeway,25,Male","XSDYM,23,Female");System.out.println("""text  : List[String] = """ + $show(text ));$skip(44); 
  val usersList = text.map(_.split(",")(0));System.out.println("""usersList  : List[String] = """ + $show(usersList ));$skip(164); 
  val usersWithAgeList = text.map(line => {
      val fields = line.split(",")
      val user = fields(0)
      val age = fields(1).toInt
      (user,age)
      });System.out.println("""usersWithAgeList  : List[(String, Int)] = """ + $show(usersWithAgeList ));$skip(21); 
  println(usersList);$skip(28); 
  println(usersWithAgeList);$skip(65); 
  
  println; println("========== .flatMap, flatten ==========");$skip(36); 
  val text2 = List("A,B,C","D,E,F");System.out.println("""text2  : List[String] = """ + $show(text2 ));$skip(95); 
  val textMapped = text2.map(_.split(",").toList);System.out.println("""textMapped  : List[List[String]] = """ + $show(textMapped ));$skip(83);  // List(List("A","B","C"),List("D","E","F"))
  val textFlattened = textMapped.flatten;System.out.println("""textFlattened  : List[String] = """ + $show(textFlattened ));$skip(91);           // List("A","B","C","D","E","F")
  val textFlatMapped = text2.flatMap(_.split(",").toList);System.out.println("""textFlatMapped  : List[String] = """ + $show(textFlatMapped ));$skip(54);  // List("A","B","C","D","E","F")
  
  println; println("========== reduce ==========");$skip(26); 
  val nums2 = List(1,2,3);System.out.println("""nums2  : List[Int] = """ + $show(nums2 ));$skip(46); 
  val sum1 = nums2.reduce((a,b) => a+b);System.out.println("""sum1  : Int = """ + $show(sum1 ));$skip(46);    //6
  val sum2 = nums2.reduce(_+_);System.out.println("""sum2  : Int = """ + $show(sum2 ));$skip(46);             //6
  val sum3 = nums2.sum;System.out.println("""sum3  : Int = """ + $show(sum3 ));$skip(54);                     //6
  
  println; println("========== reduce ==========");$skip(32); 
  val nums3 = List(2.0,2.0,3.0);System.out.println("""nums3  : List[Double] = """ + $show(nums3 ));$skip(90); 
  val resultLeftReduce = nums3.reduceLeft(math.pow);System.out.println("""resultLeftReduce  : Double = """ + $show(resultLeftReduce ));$skip(90);   // = pow( pow(2.0,2.0) , 3.0) = 64.0
  val resultRightReduce = nums3.reduceRight(math.pow);System.out.println("""resultRightReduce  : Double = """ + $show(resultRightReduce ));$skip(54);  // = pow(2.0, pow(2.0,3.0)) = 256.0
  
  println; println("========== reduce ==========");$skip(26); 
  val nums4 = List(2,3,4);System.out.println("""nums4  : List[Int] = """ + $show(nums4 ));$skip(49); 
  val sum4 = nums.fold(1)(_+_);System.out.println("""sum4  : Int = """ + $show(sum4 ));$skip(31);   // = 1+2+3+4 = 9
  
  val nums5 = List(2.0,3.0);System.out.println("""nums5  : List[Double] = """ + $show(nums5 ));$skip(80); 
  val result1 = nums5.foldLeft(4.0)(math.pow);System.out.println("""result1  : Double = """ + $show(result1 ));$skip(80);  // = pow(pow(4.0,2.0),3.0) = 4096
  val result2 = nums5.foldRight(1.0)(math.pow);System.out.println("""result2  : Double = """ + $show(result2 ));$skip(70);  // = pow(1.0,pow(2.0,3.0)) = 8.0
  
  println; println("========== sortBy,sortWith,sorted ==========");$skip(270); 
//  sortBy: sortBy[B](f: (A) ⇒ B)(implicit ord: math.Ordering[B]): List[A] 按照应用函数f之后产生的元素进行排序
//  sorted： sorted[B >: A](implicit ord: math.Ordering[B]): List[A] 按照元素自身进行排序
//  sortWith： sortWith(lt: (A, A) ⇒ Boolean): List[A] 使用自定义的比较函数进行排序
  val nums6 = List(1,3,2,4);System.out.println("""nums6  : List[Int] = """ + $show(nums6 ));$skip(45); 
  val sorted = nums6.sorted;System.out.println("""sorted  : List[Int] = """ + $show(sorted ));$skip(51);   //List(1,2,3,4)
  
  val users = List(("HomeWay",25),("XSDYM",23));System.out.println("""users  : List[(String, Int)] = """ + $show(users ));$skip(93); 
  val sortedByAge = users.sortBy{case(user,age) => age};System.out.println("""sortedByAge  : List[(String, Int)] = """ + $show(sortedByAge ));$skip(112);   //List(("XSDYM",23),("HomeWay",25))
  val sortedWith = users.sortWith{case(user1,user2) => user1._2 < user2._2};System.out.println("""sortedWith  : List[(String, Int)] = """ + $show(sortedWith ));$skip(65);  //List(("XSDYM",23),("HomeWay",25))
  
  println; println("========== filter, filterNot ==========");$skip(84); 
  //filter 保留列表中符合条件p的列表元素 ， filterNot，保留列表中不符合条件p的列表元素
  val nums7 = List(1,2,3,4);System.out.println("""nums7  : List[Int] = """ + $show(nums7 ));$skip(51); 
  val odd = nums7.filter( _ % 2 != 0);System.out.println("""odd  : List[Int] = """ + $show(odd ));$skip(55);  // List(1,3)
  val even = nums7.filterNot( _ % 2 != 0);System.out.println("""even  : List[Int] = """ + $show(even ));$skip(58);  // List(2,4)
  
  println; println("========== 并行集合 par方法 ==========");$skip(21); 
  val coll = 1 to 10;System.out.println("""coll  : scala.collection.immutable.Range.Inclusive = """ + $show(coll ));$skip(43); 
  println("coll.par.sum: " + coll.par.sum);$skip(105); 
  for(i <- (0 until 6).par) println(i + ": " + Thread.currentThread().getName);$skip(10);                     //顺序会乱
  println;$skip(106); 
  val seq = for(i <- (0 until 6).par) yield(i + ": " + Thread.currentThread().getName + "\n");System.out.println("""seq  : scala.collection.parallel.immutable.ParSeq[String] = """ + $show(seq ));$skip(15);      //顺序不会乱
  println(seq);$skip(54); 
  
  println; println("==========流 Steam ==========");$skip(88); 
  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n+1);System.out.println("""numsFrom: (n: BigInt)Stream[BigInt]""");$skip(31);          //此方法返回Stream对象
  val tenOrMore = numsFrom(10);System.out.println("""tenOrMore  : Stream[BigInt] = """ + $show(tenOrMore ));$skip(21); 
  println(tenOrMore);$skip(95); 
  val squares = numsFrom(10).map(x => x * x);System.out.println("""squares  : scala.collection.immutable.Stream[scala.math.BigInt] = """ + $show(squares ));$skip(19);                             //Stream尾部是懒设计，它只会求当前值
  println(squares);$skip(90); 
  println(squares.tail.tail);$skip(19);                                             //.tail会强制对下一元素求职
  println(squares);$skip(109); 
  println(squares.take(5).force);$skip(19);                                         //调用take(n).force，可取出n个元素，再强制对所有元素求值
  println(squares);$skip(45); 
  println("=======iterator.toStream=======");$skip(131); 
  val lines = Source.fromFile("c:/HPCamDrv.log").getLines.toStream;System.out.println("""lines  : scala.collection.immutable.Stream[String] = """ + $show(lines ));$skip(87);       //toStream: Converts this iterable collection to a stream.
  println(lines(5));$skip(89);                                                      //读第5个元素（从0算起）
  println(lines)                                                        //之前缓冲的元素也会一起读出来}

}
