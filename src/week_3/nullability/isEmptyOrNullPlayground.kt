package week_3.nullability

//my  solution
fun String?.isEmptyOrNull(): Boolean{
    if (this != null){
        return this.isEmpty()
    }
    return this==null
}
//better solution -- do the null check first, smart casts
fun String?.isEmptyOrNull2(): Boolean{
    return this == null || this.isEmpty()
}

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    assert(s1.isEmptyOrNull())
    assert(s2.isEmptyOrNull())

    val s3 = "   "
    assert(s3.isEmptyOrNull())
}