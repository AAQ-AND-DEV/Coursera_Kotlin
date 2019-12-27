package week_3.functional

import kotlin.reflect.KFunction2

class Person2(val name: String, val age: Int, val email: String){
    fun isOlder(ageLimit: Int) = age > ageLimit
    //can make bound reference for instances of Person2 via this keyword
    //which can be omitted
    fun getAgePredicate() = ::isOlder
}

fun main(args: Array<String>){

    val people = listOf(
        Person2("Babs", 32, "babs@yo.co"),
        Person2("Candi", 23, "candi@yo.co"),
        Person2("Doug", 47, "Doug@yo.co")
    )

    people.maxBy{it.age}
    //member reference
    people.maxBy(Person2::age)
    //Person2::age is a reference to the property of the class,
    //not an instance

    val isEven: (Int) -> Boolean =
        {i: Int -> i % 2 ==0}

    fun isEven2(i:Int): Boolean = i%2==0
    //compiler error(CE) cannot store fun as variable
    //val predicate = isEven2

    //instead use function reference syntax
    val predicate2 = ::isEven2
    //same as lambda that only calls isEven2 fxn
    val predicate3 = {i:Int -> isEven2(i)}
    //Member references
    fun sendEmail(person2: Person2,msg: String){
        println("sending \"$msg\" by email to ${person2.name}")
    }
    val action = {person: Person2, msg: String ->
        sendEmail(person,msg)
    }
    //member ref allow hiding of params
    //types inferred
    val action2 = ::sendEmail
    //TODO not sure how to actually get action or action2 to run
    //run {action}
    action2.invoke(people[0], "hey there")
    println(action2.javaClass)
    //println(action2)
    //action2.call(people[0], "hey there")
    //use runnable?
    /*
    fun performWork(
        predicate: KFunction2<@ParameterName(name = "person2") Person2, @ParameterName(
            name = "msg") String, Unit>
    ){
        predicate.invoke(predicate.)
    }


    performWork(action2)
    */
    //types of predicates not necessary, merely for explication
    val agePredicate: (Person2, Int) -> Boolean = Person2::isOlder
    val alice = Person2("Alice", 29, "a@g.co")
    println(agePredicate(alice, 21))
    //bound member ref
    val agePredicate2: (Int)-> Boolean = alice::isOlder
    println(agePredicate2(21))

}