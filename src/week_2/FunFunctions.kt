package week_2

fun main(){

    println(listOf('a','b','c').joinToString(
        separator = "", prefix = "(", postfix = ")"))

    //default separator is comma
    //prints 1,2,3.
    println(listOf(1,2,3).joinToString (postfix = "."))
    displaySeparator()
    println()
    displaySeparator('#', 5)
    println()
    displaySeparator(size = 12)
    println()
    displaySeparator(size= 3, char = '5')
}

fun displaySeparator(char: Char = '*', size: Int = 10){
    repeat(size){
        print(char)
    }
}
//will generate four overloaded functions
// sum(a,b,c) sum(a,b), sum(a), sum()
@JvmOverloads
fun sum(a: Int = 0, b: Int = 0, c: Int = 0) = a+b+c
