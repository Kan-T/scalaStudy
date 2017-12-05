package advanced

object RegexConsoleDemo {
  def main(args: Array[String]): Unit = {
      println("Please enter:")
      val Input = Console.readLine()
      val pattern = """(\d+) ([a-z]+)""".r
      val pattern(num, item) = Input                    //Extractor: 此处调用了pattern.unapplySeq(Input)
      println("num: " + num + "; item = " + item)
  }
}