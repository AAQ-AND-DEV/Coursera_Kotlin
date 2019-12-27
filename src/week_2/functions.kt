package week_2

import week_2.extensions.lastChar2

fun main(){
    displayMax(24,94)
    displayMax(34,2)
    println(topLevel())
    val a = A()
    println(a.member())
    println(login("Jon Tester", "MontanaRules"))
    try {
        println(login("", "what?"))
    } catch (e: IllegalArgumentException){
        println("try to enter actual value")
    }

    println(login("This Person", ""))
    //using import of extension function above
    println("abc".lastChar2())
}

fun max(a:Int, b:Int):Int{
    return if (a>b) a else b
}

fun maxExpBody(a:Int, b:Int) = if (a<b) a else b

fun displayMax(a:Int, b: Int){
    println(max(a, b))
}

fun topLevel() = 1

class A {
    fun member() = 2
}

fun other(){
    fun local() = 3
}

//demo of local function
//from idiomatic kotlin medium article
//https://medium.com/tompee/idiomatic-kotlin-local-functions-4421f86ac864
fun login(username:String, pw: String) : Boolean{
    var something = 1
    fun validateInput(input:String){
        something++
        if (input.isEmpty()){
            throw IllegalArgumentException("Must not be empty")
        }
    }
    validateInput(username)
    validateInput(pw)
    return true

}