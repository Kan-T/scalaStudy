package advanced

import scala.io.Source

object LazyOps {
  def main(args: Array[String]): Unit = {
    lazy val file = Source.fromFile("c:\\bookmarks.html")    //lazy表示该变量、常量在第一次被使用时才会初始化（延迟执行）
    println("File content: ")
    for(line <- file.getLines()){
      println(line)
    }
  }
}