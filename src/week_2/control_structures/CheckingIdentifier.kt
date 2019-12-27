package week_2.control_structures

fun isValidIdentifier(s: String): Boolean {
    var flag = true
    if (s.length == 0) return false
    when {
        //could have used char.isLetterOrDigit
        (s[0] !in 'a'..'z' && s[0] !in 'A'..'Z' && s[0] != '_')  -> flag = false
    }
    if (flag == false) return false
    fun isNotLetterNumberOrUnderscore(char: Char):Boolean{
        when {
            (char !in 'a'..'z' && char !in 'A'..'Z' && char !in '0'..'9' && char != '_')-> return false
        }
        return true
    }
    for (i in 1 until s.length){
        val c = s[i]
        flag = isNotLetterNumberOrUnderscore(c)
        if (flag == false) return false
    }

    return flag
}

fun isValidIdentifierSoln(s: String): Boolean{
    fun isValidCharacter(ch: Char) =
        ch == '_' || ch in '0'..'9' ||
                ch in 'a'..'z'|| ch in 'A'..'Z'
    //could have used char.isDigit
    if (s.isEmpty() || s[0] in '0'..'9') return false
    for (ch in s){
        if (!isValidCharacter(ch)) return false
    }
    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}