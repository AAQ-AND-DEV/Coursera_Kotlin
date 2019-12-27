package week_3.functional

fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf<Int>()
        listOf(it, it)
    }
}
//can use alternative labels
fun duplicateNonZero2(list: List<Int>): List<Int> {
    return list.flatMap l@{
        if (it == 0) return@l listOf<Int>()
        listOf(it, it)
    }
}
//local function approach
fun duplicateNonZeroLocalFunction(list: List<Int>): List<Int>{
    fun duplicateNonZeroElement(e:Int):List<Int>{
        if (e== 0) return listOf()
        return listOf(e,e)
    }
    return list.flatMap(::duplicateNonZeroElement)
}
//anonymous function approach
fun duplicateNonZeroAnon(list: List<Int>): List<Int>{
    return list.flatMap (fun (e): List<Int>{
        if (e==0) return listOf()
        return listOf(e,e)
    })
}
//if statement approach
fun duplicateNonZeroIf(list: List<Int>): List<Int>{
    return list.flatMap {
        if (it == 0) listOf()
        else listOf(it, it)
    }
}

fun main(args: Array<String>){

    println(duplicateNonZero(listOf(3, 0, 5)))
    println(duplicateNonZeroLocalFunction(listOf(2, 0, 5)))
    println(duplicateNonZeroAnon(listOf(3,0,5)))
    println(duplicateNonZeroIf(listOf(3,0,5)))
    val list = listOf(1,4,0,7)
    //labeled return doesn't break whole for loop,
    //just the current iteration
    list.forEach{
        if (it==0) return@forEach
        print(it)
    }
    foo(list)
    bar(list)
}

//return inside forEach doesn't correspond to break inside for loop
fun foo(list: List<Int>){
    list.forEach{
        if (it==0) return
        print(it)
    }
    println("####")
}
fun bar(list: List<Int>){
    for(element in  list){
        if (element == 0) break
        print(element)
    }
    println("###")
}