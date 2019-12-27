package week_2

fun main(args: Array<String>){
    val list = mutableListOf("Java")
    list.add("Kotlin")
    println(list)
    val readOnlyList = listOf("Java")
    //next line yields compiler error -- listOf create immutable list
    //readOnlyList.add("Kotlin")

}