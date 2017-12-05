package io

import scala.io.Source

object BasicFile {
  def main(args: Array[String]): Unit = {
    val file01 = Source.fromFile("c:\\Windows\\system.ini")
//    val file01 = Source.fromURL("http://www.scala-lang.org")
    
    println("1. File content: ")
    for(line <- file01.getLines()){
      println(line)
    }
    
    println
    val file02 = file01.reset()
    val str = file02.mkString
    println("2. File content: ")
    println(str)
    
    file01.close()
    file02.close()
  }
}