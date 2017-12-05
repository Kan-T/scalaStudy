package advanced

import scala.util.matching.Regex

object RegexDemo {
  def main(args: Array[String]): Unit = {
    val separator = ", " 
    var pattern = "^cat".r
    
    println("===Regex语法 1=== 	^ 表示行首； $ 表示行尾 ")
    pattern = "^cat.*here.$".r
    val str01 = pattern.findFirstIn("cat is here.")
    println("str01: " + str01)
    println
    
    println("===Regex语法 2=== 	字符组: [....] ，匹配若干字符之一")
    //这几个的意义相同： H[1234567789],  H[1-9], H[1-34-9]
    //匹配所有数字和字母：[0-9A-Za-z]
    pattern = "[A-Z]".r
    val result02 = pattern.findAllIn("Hello World.")
    for (str <- result02) print(str + separator)
    println;println
    
    println("===Regex语法 3=== 	排除型字符组：[^....]，匹配未列出的字符")
    pattern = "[^0-9]".r
    val result03 = pattern.findAllIn("￥14000022rmb")
    for (str <- result03) print(str + separator)
    println;println
    
    println("===Regex语法 4=== 	匹配任意字符：. ，点号可匹配任意的字符")
    //.在字符组中只表示点号本身。[./]表示.或/的字符组
    pattern = "c.p".r
    val result04 = pattern.findAllIn("The cop has a cap.")
    for (str <- result04) print(str + separator)
    println;println
    
    println("===Regex语法 5=== 	多选结构 - 或：| ")
    //H[12] 与 H(1|2) 意义相同
    //^From|Subject|Date  与   ^(From|Subject|Date) 意义不同
    pattern = "^From|Subject|Date".r
    val result05 = pattern.findAllIn("From: ken.tao@hp.com; Subject: .......")
    for (str <- result05) print(str + separator)
    println;println    
    
    println("===Regex语法 6=== 	单词分界符：\b ")
    pattern = "\\bcat\\b".r                  //需加上转义符
    val result06 = pattern.findAllIn("caty is a cat.")
    for (str <- result06) print(str + separator)
    println;println    

    println("===Regex语法 7=== 	忽略大小写：i ")
    pattern = "".r                 
    val result07 = pattern.findAllIn("")
    for (str <- result07) print(str + separator)
    println;println       

    println("===Regex语法 8=== 	可选项元素： ? ")
    pattern = "July? (fourth|4(th)?)".r                 
    val result08 = pattern.findAllIn("Today is Jul 4.")
    for (str <- result08) print(str + separator)
    println;println           
    
    println("===Regex语法 9=== 	重复出现量词： ? , + , * ")
    //? -> 之前紧邻的元素出现 0次 或 1次                {0,1}
    //+ -> 之前紧邻的元素出现 1次 或 任意多次
    //* -> 之前紧邻的元素出现 0次 或 任意多次
    pattern = "[0-9]+ *".r                 
    val result09 = pattern.findAllIn("4     is even.")
    for (str <- result09) print(str + separator)
    println;println
    
    println("===Regex语法 10=== 	重复出现次数范围：{min,max}, {time}")
    pattern = "[a-zA-Z]{1,4}".r                 
    val result10 = pattern.findAllIn("gsyhxx 代表 工商银行")
    for (str <- result10) print(str + separator)
    println;println
    
    println("===Regex语法 11=== 	转义符：\\ 	使跟在其后的元字符失去意义，变为普通字符。转义符在字符组中无效")
    pattern = """\([a-z]+\)""".r                               //"""....""" 原始字符串语法
    val result11 = pattern.findAllIn("I am (very) happy")
    for (str <- result11) print(str + separator)
    println;println
    
    
  }
}