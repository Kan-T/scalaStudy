import scala.collection.mutable.ArrayBuffer

object ArrayOps {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(88); 

  val left = List(1,2,3);System.out.println("""left  : List[Int] = """ + $show(left ));$skip(26); 
  val right = List(4,5,6);System.out.println("""right  : List[Int] = """ + $show(right ));$skip(33); val res$0 = 
  
  //以下操作等价
  left union right;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(16); val res$1 = 
  left ++ right;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(17); val res$2 = 
  left ++: right;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(18); val res$3 = 
  right.++:(left);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(18); val res$4 = 
  right.:::(left);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(26); val res$5 = 
  
  //以下操作等价
  0 +: left;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(13); val res$6 = 
  left.+:(0);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(26); val res$7 = 
  
  //以下操作等价
  left :+ 4;System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(13); val res$8 = 
  left.:+(4);System.out.println("""res8: List[Int] = """ + $show(res$8))}
}
