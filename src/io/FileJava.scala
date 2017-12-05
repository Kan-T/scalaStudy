package io

import java.io._

object FileJava {
  def subdir(dir: File): Iterator[File] = {
    val dirArray = dir.listFiles.filter(_.isDirectory())
    dirArray.toIterator ++ dirArray.toIterator.flatMap(subdir _)
  }
  def main(args: Array[String]): Unit = {
    subdir(new File("c:/")).map(print(_))
  }
}