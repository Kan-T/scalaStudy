package io

import scala.io.Source

object FileDemo01 {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("c:\\Windows\\system.ini")
    val str = file.mkString
    val separators = Array(' ', '.','=')
    val out = str.split(separators).map(_ + ";")
    for (str <- out){
      print(str)
    } 
  }
}