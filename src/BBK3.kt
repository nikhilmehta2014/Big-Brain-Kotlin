import java.util.*
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

// BBK#3: Mumbling

//Question
// mummble("abcd") -> "A-Bb-Ccc-Dddd"
// mummble("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
// mummble("cwAt") -> "C-Ww-Aaa-Tttt"

fun main() {
    println(mumble("cwAt"))
}

/**
 * Approach 1
 * using [toCharArray], [withIndex], [repeat], [toUpperCase], [toLowerCase]
 *
 * Performance : took ~ 0.154 ms
 */
/*fun mumble(input: String): String {
    measureNanoTime {
        val words = input.toCharArray()
        val mumble = StringBuilder()
        for ((index, word) in words.withIndex()) {
            mumble.append(word.toUpperCase())
            repeat(index) {
                mumble.append(word.toLowerCase())
            }
            if (index != words.size - 1) {
                mumble.append("-")
            }
        }
        println(mumble.toString())
    }.let {
        println("$it nanoseconds")
    }
    return ""
}*/

/**
 * Approach 2
 * using [toCharArray], [forEachIndexed], [toUpperCase], [toLowerCase]
 *
 * Performance : took ~ 0.16 ms
 */
/*fun mumble(input: String): String {
    measureNanoTime {
        var result = ""
        input.toCharArray().forEachIndexed { index, item ->
            result = "$result${item.toUpperCase()}"
            repeat(index) {
                result = "$result${item.toLowerCase()}"
            }
            if (input.length - 1 != index) {
                result = "$result-"
            }
        }
        println(result)
    }.let {
        println("$it nanoseconds")
    }
    return ""
}*/

/**
 * Approach 3
 * using [foldIndexed]
 */
/*fun mumble(input: String): String {
    val answer = input.toCharArray().foldIndexed("") { index, acc, item ->
        var result = "$acc${item.toUpperCase()}"
        repeat(index) {
            result = "$result${item.toLowerCase()}"
        }
        if ((input.length - 1) != index) {
            result = "$result-"
        }
        result
    }
    return answer
}*/

/**
 * Approach 4
 * using [mapIndexed], [joinToString]
 */
/*fun mumble(words: String): String =
    words.mapIndexed { index, word ->
        "${word.toUpperCase()}${word.toString().toLowerCase().repeat(index)}"
    }
        .joinToString("-")*/

/**
 * Approach 5
 * using [mapIndexed], [capitalize], [joinToString]
 *
 * Pros:
 * Cleaner alternative to Approach 4 by using [capitalize] and reducing the noise related to String Concatenation.
 */
fun mumble(words: String): String {
    val output = words.toLowerCase(Locale.getDefault()).mapIndexed { index, c ->
        c.toString().repeat(index + 1).capitalize()
    }
    return output.joinToString("-")
}
