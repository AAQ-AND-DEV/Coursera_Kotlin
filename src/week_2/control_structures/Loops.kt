package week_2.control_structures

fun main(args: Array<String>){
    val list = listOf("a", "b", "c")
    for (s in list){
        print(s)
    }
    println()

    val  element = "b"
    if (element in list){println(true)}
    //same as .contains()
    if (list.contains(element)){println(true)}

    for ((index, element) in list.withIndex()){
        println("$index: $element")
    }
    val map = mapOf(1 to "one",
                    2 to "two",
                    3 to "three")

    for ((key, value) in map){
        println("$key = $value")
    }
    //iterate over range
    for (i in 1..9){
        print(i)
    }
    println()
    //until excludes upper bound
    for (i in 1 until 9){
        print(i)
    }
    println()
    //backwards (inclusive) and steps possible
    for (i in 9 downTo 1 step 2){
        print(i)
    }
    println()
    //iterate over chars in a string
    for (ch in "abcz"){
        //increments character by 1
        print(ch +1)
    }
    println()
    for (c in '0' until '9'){print(c)}
    println()
    println(isLetter('c'))
    println(isLetter('*'))
    println(isNotDigit('x'))
    println(isNotDigit('3'))
    println("in check for when")
    println(recognize('d'))
    println(recognize('G'))
    //this doesn't work to identify number 7
    //because of ASCII numbering
    println(7.toChar())
    println(recognize(7.toChar()))
    println(55.toChar())
    println(recognize(56.toChar()))

    println(recognize('*'))

    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java", "Scala"))
    println("ball" in "a".."k")
    println("zoo" in "a".."k")
}
//in can be used to check inclusion in range
fun isLetter(c:Char) = c in 'a'..'z' || c in 'A'..'Z'

//use !in to check if not in range
fun isNotDigit(c:Char) = c !in '0' .. '9'

//in used in when check
fun recognize(c:Char) = when (c){
    in '0'..'9' -> "it's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know"
}