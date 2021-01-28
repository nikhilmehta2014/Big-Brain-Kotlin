// BBK#1: Find Middle Element

// Question: Print middle character of a string,
// if even, print middle two characters
// else the middle character

fun main() {
    println(getMiddle("nikhil"))
    println(getMiddle("nikhi"))
}

/**
 * Approach 1 -
 * using [String.toCharArray]
 */
/*fun getMiddle(word: String): String {
    val chars = word.toCharArray()
    val mid = chars.size / 2
    return if (chars.size % 2 == 0) {
        "${chars[mid - 1]}${chars[mid]}"
    } else {
        "${chars[mid]}"
    }
}*/

/**
 * Approach 2
 * using [String.drop] and [String.dropLast]
 */
/*fun getMiddle(word : String) : String {
    val worldLength = (word.length - 1) / 2
    return word.drop(worldLength).dropLast(worldLength)
}*/

/**
 * Approach 3
 * using [String.substring]
 */
fun getMiddle(word: String): String =
    word
        .substring(
            (word.length - 1) / 2..word.length / 2
        )