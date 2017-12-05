import scala.collection.mutable.ArrayBuffer

object ArrayOps {

  val left = List(1,2,3)                          //> left  : List[Int] = List(1, 2, 3)
  val right = List(4,5,6)                         //> right  : List[Int] = List(4, 5, 6)
  
  //以下操作等价
  left union right                                //> res0: List[Int] = List(1, 2, 3, 4, 5, 6)
  left ++ right                                   //> res1: List[Int] = List(1, 2, 3, 4, 5, 6)
  left ++: right                                  //> res2: List[Int] = List(1, 2, 3, 4, 5, 6)
  right.++:(left)                                 //> res3: List[Int] = List(1, 2, 3, 4, 5, 6)
  right.:::(left)                                 //> res4: List[Int] = List(1, 2, 3, 4, 5, 6)
  
  //以下操作等价
  0 +: left                                       //> res5: List[Int] = List(0, 1, 2, 3)
  left.+:(0)                                      //> res6: List[Int] = List(0, 1, 2, 3)
  
  //以下操作等价
  left :+ 4                                       //> res7: List[Int] = List(1, 2, 3, 4)
  left.:+(4)                                      //> res8: List[Int] = List(1, 2, 3, 4)
}