package io

import scala.io.Source
import java.io.FileInputStream
import java.io.File

object IO_Demo {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("c:\\camera.log","UTF-8")
    val lineIters = source.getLines()
  
//    println("第一种处理方式：")
//    for(l <- lineIters) println(l)
//    
//    println("第二种处理方式：")
//    val lines = lineIters.toArray
//    for(l <- lines) println(l)
//    
//    println("第三种处理方式：")
//    val contents = source.mkString
//    print(contents)
//    
//    println("第四种处理方式：")
//    for(c <- source) print(c)

    source.close()
    
    println("用java类库处理字节数据")
    val file = new File("c:\\camera.log")
    val in = new FileInputStream(file) 
    val bytes = new Array[Byte](file.length.toInt)

    in.read(bytes)
    for(byte <- bytes) print(byte)
    
    in.close()

  }
}