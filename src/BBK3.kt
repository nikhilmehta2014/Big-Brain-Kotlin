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
 * using [toCharArray], [withIndex], [toUpperCase], [toLowerCase]
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
fun mumble(input: String): String {
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
}
