package week_3.functional

import week_3.functional.interopRunnable.postponeComputation
import java.util.*

fun main(args: Array<String>){
    //val x = 4
    //val y = 7
    val sum: (Int, Int) -> Int = {x, y -> x + y}

    val isEven: (Int) -> Boolean = {x -> x % 2 == 0}

    val res: Boolean = isEven(42)
    println(res)
    val list = listOf(0, 1, 2, 3, 4)
    println(list.any(isEven))
    println(list.filter(isEven))
    //use run to call a lambda directly
    run {println("Hey!")}

    //when interop with Java, use Runnable to capture lambda
    //pass as argument

    postponeComputation(1000){println(42)}
    val runnable = Runnable {println(43)}
    postponeComputation(1000, runnable)

    //compiler error (CE) because lambda not nullable
    //val f1: () -> Int? = null
    //is fine, lambda always returns null, receiver nullable
    val f2: () -> Int? = {null}
    val f3: (()-> Int)? = null
    val x = Random().nextInt(37)
    val cond = x%2==0
    val f3x: (() -> Int)? = if (cond) {
        { 42 }
    } else null
    val f3x2: (()-> Int)? = if (cond) ({42}) else null
    println(f3x)
    //CE because return type not nullable
    //val f4: (()-> Int)? = {null}

    val f: (()-> Int)? = null
    //CE b/c nullable function type requires null check
    //f()
    if (f!=null){
        f()
    }
    //safe access syntax
    f?.invoke()

}