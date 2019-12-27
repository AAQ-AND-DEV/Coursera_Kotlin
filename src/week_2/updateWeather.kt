package week_2

fun updateWeather(degrees:Int){
    val (desc: String, color: Color) =
    if (degrees<10){
        Pair("cold", Color.BLUE)
    } else if (degrees<25){
        Pair("mild", Color.ORANGE)
    } else {
        Pair("hot", Color.RED)
    }

}
//more idiomatic kotlin syntax
fun updateWeatherWhen(degrees: Int){
    val (desc, color) = when{
        degrees<10 -> Pair("cold", Color.BLUE)
        degrees<25 -> Pair("mild", Color.ORANGE)
        else -> Pair("hot", Color.RED)
    }
    //val desc2 = (desc, color).first
    println("$desc, $color")
}
//even more idiomatic syntax (converting Pair to "x to y")
fun updateWeatherWhenAndTo(degrees: Int){
    val (desc, color) = when{
        degrees<10 -> "cold" to Color.BLUE
        degrees<25 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }

}

enum class Color{
    BLUE,
    ORANGE,
    RED
}