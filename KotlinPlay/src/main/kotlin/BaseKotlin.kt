class Test {
    val name = "chenglong"
    val age = 25
}

// 打印
fun main() {
    println("hello Konfu Man!")
    print("My name is ${Test().name}, and age is ${Test().age}")

    // 函数
    main1()
    sum(1,2)
    sum1(1,2)
    sumAB(1,2)
    val sum = sumABC(1,2,3)
    val sum1 = sum3(1,2,3)
    println("sum:$sum, sum1:$sum1")

    // 可空类型
    nullCheck()

    // 基本数据类型
    baseData()

    // 条件控制
    conditionControl()
}

// 函数
fun main1() {
    println('A')
}
fun sum(a:Int, b:Int): Unit {
    println("sum is ${a+b}")
}
fun sum1(a:Int, b:Int) {
    println("sum is ${a+b}")
}
fun sumAB(a:Int, b: Int): Int {
    return a+b
}
fun sumABC(a: Int, b: Int, c:Int) = a + b + c
public fun sum3(a:Int, b:Int, c:Int):Int = a + b + c //public 加返回类型

// NULL检查机制
fun nullCheck() {
    var age:String? = "000" //null
    val ages = age!!.toInt() //null则强解报错
    val ages1 = age?.toInt()
    val ages2 = age?.toInt() ?: -1
    println("age:$age, ages:$ages, ages1:$ages1, ages2:$ages2")
}

// 基本数据类型
fun baseData() {
    //数组
    val a = arrayOf(1,2,3)
    val b = Array(3,{ i -> (i * 2)} ) //次数为3 i=0 步长为2
    a[0] = a[1] + a[2]
    println("数组a:${a.first()}, 数组b:${b[0]}，${b[1]}，${b[2]}")
    //字符串
    val str = "This is a string"
    for (c in str) {
        print(c)
    }
    val text = """
        |多行的字符串
        |这是多行的
        |这多行的
        """.trimMargin() //删除前置空格
    println(text)
    val price = "${'$'}9.99"
    println(price)
}

// 条件控制
fun conditionControl() {
    // if
    fun max(a:Int, b: Int) :Int {
        var max = a
        if (a < b) max = b
        return max
    }
    fun max1(a:Int, b: Int) :Int { //把 IF 表达式的结果赋值给一个变量
        val max = if (a > b) {
            a
        } else {
            b
        }
        return max
    }
    val a = 100
    val b = 200
    val c = if (a > b) a else b //三目
    println(max(100,200))
    println(max1(100,200))
    println(c)
    // 区间
    val x = 5
    val y = 9
    if (x in 1..8) {
        println("$x 在1~8区间内")
    }
    // when
    val xArray = arrayOf(1,2,3,4,5)
    when(x) {
        0 -> println("x == 0")
        1,2 -> println("x==1 or x==2")
        in 3..5 -> println("x is range of 3-5")
        in xArray -> println("x in xArray")
        !in 10..20 -> println("x is outside the range 10-20")
        else -> println("none of the above")
    }

    // is 判断类型   = when(x) 相当于一个BOOL类型
    fun hasPrefix(x:Any) = when(x) {
        is String -> x.startsWith("Prefix")
        else -> false
    }
    val isPrefix = hasPrefix("Prefixxxxx")
    println("isPrefix:$isPrefix")

    // when 代替if else
    val string = " "
    when {
        string.isEmpty() -> println("string empty")
        string.isBlank() -> println("string is blank")
        else -> println("commmon string")
    }
}
