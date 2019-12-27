package week_3.functional

fun main(){

    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE)
    )
    val mapByAge: Map<Int, List<Hero>> =
        heroes.groupBy { it.age }
    val (age, group) = mapByAge.maxBy { (_, group)->group.size }!!
    println(age)
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    //map access by square brackets -- returns null if not in
    println(mapByName["Frenchy"]?.age)
    //map .get() access throws exception
    val mapByName2 = heroes.associate { it.name to it.age }
    val unknownHero = Hero("Unknown", 0, null)
    println(mapByName.getOrElse("unknown"){unknownHero}.age)
    println(mapByName2.getOrElse("unknown"){0})

    //confusing one
    val allPossiblePairs = heroes
        .flatMap { first ->
            heroes.map{second -> first to second}
        }
        val (first, second) = allPossiblePairs
            .maxBy{it.first.age - it.second.age}!!
    println(first.name)
}