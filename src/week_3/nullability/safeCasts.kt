package week_3.nullability

fun main(){
    val any: Any = "foo"
    if (any is String){
        //cast not needed in Kotlin
        val s = any as String
        s.toUpperCase()
    }
    if (any is String){
        any.toUpperCase()
    }
    //also as? to do nullable instanceOf
    (any as? String)?.toUpperCase()
}