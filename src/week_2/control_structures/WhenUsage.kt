package week_2.control_structures

//note: must use enum within same file for compiler to pass exhaustive check
import week_2.control_structures.Color.*

enum class Color{
    BLUE,ORANGE, RED
}

enum class ExtendedColor{
    RED, YELLOW, ORANGE, BLUE, GREEN, VIOLET, INDIGO
}

fun main(){
    println(getDescription(BLUE))
    //using label to allow for break from outerLoop
    /*
    loop@ while (true){
        println("isn't impeachment great?")
        val response = readLine()
        println(respondToInput(response!!))
        when (response){
            "n","no" -> break@loop
        }
    }
    */
    /*
    val pet = Cat("Willie")
    val pet2 = Dog("Roi")
    speak(pet)
    speak(pet2)
    val pet3 = getAPet()
    speak(pet3)
    */
    getSound()
}

fun getDescription(color:Color):  String =
    when(color){
        BLUE -> "cold"
        ORANGE -> "mild"
        RED -> "hot"
    }

//can use multiple values with comma separator
fun respondToInput(input: String) = when (input){
    "y", "yes" -> "I'm glad you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "I don't understand you"
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1,c2)) {
        setOf(ExtendedColor.RED, ExtendedColor.YELLOW) -> ExtendedColor.ORANGE
        setOf(ExtendedColor.YELLOW, ExtendedColor.BLUE) -> ExtendedColor.GREEN
        setOf(ExtendedColor.BLUE, ExtendedColor.VIOLET) -> ExtendedColor.INDIGO
        else -> throw Exception("Dirty Color")
    }

open class Pet(name: String){}

class Cat(val name:String):Pet(name){
    fun meow(){
        println("${this.name} meows")
    }
}

class Dog(val name: String): Pet(name){
    fun bark(){
        println("$name barks")
    }
}
fun speak(pet: Pet){
    when (pet){
        is Dog -> pet.bark()
        is Cat -> pet.meow()
        else -> println("Default pet telepathically communicates")
    }
}
//example of val assigned in 'when' clause
fun getSound() =
    when (val pet = getAPet()){
        is Cat -> pet.meow()
        is Dog -> pet.bark()
        else -> println("---")
    }

fun getAPet(): Pet{
    println("which pet? 1 for Willie, 2 for Roi")
    val input = readLine()
    return when (input?.toIntOrNull()){
        1 -> Cat("Willie")
        2 -> Dog("Roi")
        else -> Pet("Default")
    }

}