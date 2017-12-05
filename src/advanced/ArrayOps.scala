package advanced

import scala.collection.mutable.ArrayBuffer

object ArrayOps {
  def main(args: Array[String]): Unit = {
    val nums = new Array[Int](10)               
    val a = new Array[String](10)                 
    val s = Array("Hello", "World")   //已提供初始化值则不用new关键字。这里用的Array半生对象的apply方法
                                                  
    s(0) = "Goodbye"
    
    val b = ArrayBuffer[Int]()        //ArrayBuffer为变长数组
    b += 1                            // += 增加数组元素
    b += (1, 2, 3, 5)                  
    b ++= Array(8, 13, 21)            // ++= 追加任何集合
    
    b.trimEnd(5)                      //截去后5个元素
    b.insert(2, 6)                    //在index 2 的位置插入6， index从0开始
    b.insert(2, 7, 8, 9)              //在index 2 的位置插入7,8,9
    b.remove(2)
    b.remove(2, 3)                    //从index 2 的位置开始删除3个元素
    val c = b.toArray                 //将ArrayBuffer转化成Array
    for(i <- c) print(i + ", ")
    println
    
    for(i <- 0 until a.length) 
           println(i + ": " + a(i))
    
    val result = for(elmt <- c) yield elmt * 2        // yield的主要作用是记住每次迭代中的有关值,并逐一存入到一个数组中
    for(elmt <- c if elmt % 2 == 0) yield elmt * 2    // 只将c中的偶数乘以2
    c.filter(_%2==0).map(_*2)
    
    Array(1,7,2,9).sum
    Array(1,7,2,9).max
    Array("Ken","Cassie","Eason","baby").max
    
    val d = ArrayBuffer(1,7,2,9)
    val sorted = d.sorted
    
    val e = d.toArray
    scala.util.Sorting.quickSort(e)
    
    e.mkString(" and ")
    e.mkString("<", ",", ">")
    
    val matrix = Array.ofDim[Int](3, 4)
    matrix(1)(1) = 3
    
  }
}