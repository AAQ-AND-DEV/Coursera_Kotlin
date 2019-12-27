package week_3.nullability

fun main(args: Array<String>){
    val s: String? = null
    //type will be Int?
    val length = s?.length
    //to use other default val than null
    val length0 = if (s!=null) s.length else 0
    //with elvis operator
    val lengthElvis = s?.length ?: 0

    val a: Int? = null
    val b: Int? = 1
    val c: Int = 2
    val sum1 = (a ?: 0) + c
    val sum2 = (b ?: 0) + c
    println("$sum1$sum2")

    val s2: String? = null
    if (s2 == null) return //or fail() which throws exception
    //compiler knows this is a smart cast to non-null String
    s2.length

    //can throw NPE if null val
    val s3: String? = null
    //throws NPE if null, tho not doing so!...what's up?

    println(s3!!.length) //doesn't print anything

    //for !! example of localized null check
    val action:MyAction = MyAction()
    if(action.isEnabled()){
        action.actionPerformed()
    }
    //isFoo1 compiler error b/c type is Name non-nullable
    //isFoo1(null)
    isFoo2(null)
    isFoo3(null)
    isFoo4(null)
}
//not really sure how to get list.selectedValue to work
//as shown in Nullable types video at 6:24
//using extension function
fun List<String>.selectedValue(): String {return get(0)}
class MyAction {
    val list = listOf("A", "B", "C")
    //here we can assume that isEnabled is checking null
    fun isEnabled(): Boolean = list.selectedValue() != null
    fun actionPerformed(){
        //here forcing Not-null assertion
        val value = list.selectedValue()!!
    }
}
class Name(val value: String){}

fun isFoo1(n: Name) = n.value == "foo"
//requires ? assertion
fun isFoo2(n:Name?) = n?.value == "foo"
fun isFoo3(n: Name?) = n != null && n.value == "foo"
fun isFoo4(n: Name?) = n?.value == "foo"




fun nullables(list1: List<Int?>, list2: List<Int>?){
    list1.size
    list2?.size
    val i: Int? = list1.get(0)
    val j: Int? = list2?.get(0)
}