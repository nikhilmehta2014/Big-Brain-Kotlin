// BBK#4: Spin My Words

// Write a function that reverses all words in the String whose length is five or more.
// spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
// spinWords( "This is a test") => returns "This is a test"
// spinWords( "This is another test" )=> returns "This is rehtona test"

fun main() {
    println(spinWords("This is another test"))
}

/**
 * Approach 1
 * Java-ish solution = using [for] loop and [reversed]
 */
/*fun spinWords(input: String): String {
    val individualWordsList = input.split(" ")
    var reversedString = ""
    for (word in individualWordsList) {
        reversedString = if (word.length > 5) {
            "$reversedString ${word.reversed()}"
        } else {
            "$reversedString $word"
        }
    }
    return reversedString
}*/

/**
 * Approach 2
 * using [joinToString]
 */
fun spinWords(input: String): String = input.split(" ").joinToString(" ") { word ->
    if (word.length > 5) {
        word.reversed()
    } else
        word
}