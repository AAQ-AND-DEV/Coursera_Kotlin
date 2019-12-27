package week_3.nullability

fun main(args: Array<String>) {
    val s = "what's up"
    println(s as? Int)    // null
    println(s as Int?)    // exception
}