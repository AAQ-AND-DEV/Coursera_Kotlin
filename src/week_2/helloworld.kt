package week_2

fun main(args:Array<String>){
    val name = if (args.size>0) args[0] else "Kotlin"
    println("Hello, $name!")
    //println("Hello, ${args.getOrNull(0)}")
    println("First ${foo()}, second ${foo()}")
    val person1 = Person("Beatrice", 34)
    val person2 = Person("Beatrice", 34)
    val person3 = Person("Frank", 45)
    println(person1)
    println(person1==person2)
    println(person1==person3)
    updateWeatherWhen(22)
}

fun  foo():String{
    println("calculating foo...")
    return "foo"
}