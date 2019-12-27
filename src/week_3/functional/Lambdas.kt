package week_3.functional

fun main(){
    val list = listOf(1, 2, 3, 4)
    val check = list.any(){i-> i>0}
    println(check)
    //parens omitted if empty
    val res =    list.any {i-> i==2}
    println(res)
    //can replace i-> ... with it
    list.any { it > 0 }
    list.any {
        println("processing $it")
        //last expression of lambda is result
        it > 0
    }
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    //destructuring declarations syntax used instead of (key, val)->
    val mappingRes = map.mapValues { entry -> "${entry.key} -> ${entry.value}" }
    println(mappingRes)
    //can replace unused params with underscore
    val mappingRes2 = map.mapValues{ (_, value)-> "$value!"}
    println(mappingRes2)

    val res2 = list.map{ it%2==0}
    println("${res2.javaClass} $res2 ")
    val res3 = map.map { entry -> entry.key%2==1 }
    println("${res3.javaClass} $res3")
    val res4 = list.filter{it %2 == 1}
    println("${res4.javaClass} $res4")
    val res5 = list.map{ it* it}
    println(res5)
    //all()
    val min = 1
    val resAll = list.all(){it>min}
    println("all greater than $min: $resAll")
    //none()
    val resNone = list.none{ it <0}
    println("none less than 0: $resNone")
    //find() or firstOrNull or first (throws exception)
    //val resFirst = list.first {it > 3}
    //println(resFirst)
    //count() counts els that satisfy predicate
    val count = list.count{it%2==0}
    println(count)
    //partition() divided collection  into 2 collections
    val hmm = list.partition { it%2==0 }
    println(hmm)
    println(hmm.first)
    println(hmm.second)
    val personnel = listOf(Person("Alice",24), Person("Alice", 31),
        Person("Bob", 29), Person("Carol", 31) )
    //groupBy() maps to the predicate
    val personnelAgeMap = personnel.groupBy { it.age }
    println(personnelAgeMap)
    //associateBy()
    //removes non-unique keys (notice 2nd Alice) --not sure of utility
    //guess if key is unique, yields map to single element
    val personnelAssociate = personnel.associateBy { it.name }
    println(personnelAssociate)
    //associate()
    //builds map of keys to value
    val associatedMap = list.associate { 'a' + it -1 to 10 * it }
    println(associatedMap)
    //zip() zips elements from two lists into List<Pair(A,B)>
    val alphaList = listOf("a", "b", "c", "d")
    val zippedMap = list.zip(alphaList)
    println(zippedMap)
    //zipWithNext() returns List<Pair(x, x+1)>
    val zipNextList= list.zipWithNext()
    println(zipNextList)
    //flatten() takes list of lists returns combined
    val flattenedList = listOf(list, alphaList).flatten()
    println("${flattenedList.javaClass} $flattenedList")
    //flatMap argument is lambda converting el to list
    //and flattened from list of lists
    val sA = "abc"
    val sB = "def"
    val flatMap = listOf(sA, sB).flatMap { it.toList() }
    println(flatMap)
}
class Person(val name: String, val age: Int){
    override fun toString(): String {
        return "$name, $age"
    }
}