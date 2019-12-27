package week_3.functional

data class Hero(val name: String, val age: Int, val gender: Gender?) {
}
enum class Gender {MALE, FEMALE}