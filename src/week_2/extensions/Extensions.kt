package week_2.extensions

//by default, not visible in whole project
//must be imported to use in other package
fun String.lastChar() = this.get(this.length-1)
//same as
fun String.lastChar2() = get(length-1)

fun String.repeat(n: Int): String{
    val sb = StringBuilder(n*length)
    for (i in 1..n){
        sb.append(this)
    }
    return sb.toString()
}

fun main(args: Array<String>){
    val c: Char = "abc".lastChar()
    println(c)

    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    //using java standard util classes under the hood
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val q = """To code, or not to code"""
    val q2 = """To code, 
            |or not to code""".trimMargin()
    val q3 = """To code, 
|or not to code"""
    val q4 = """To code, 
            or not to code"""
    val q5 = """
        Keep Calm
        and Learn Kotlin
    """.trimIndent()
    val q6 = """
        Keep Calm
        and Learn Kotlin
    """.trimMargin()
    println(q)
    println(q2)
    println(q3)
    println(q4)
    println(q5)
    println(q6)
    ///triple-quoted Strings useful for Regex
    //don't need to escape backslash
    val regex = """\d{2}\.\d{2}\.\d{4}""".toRegex()
    println(regex.matches("15.02.2016"))
    println(regex.matches("15.02.16"))
}