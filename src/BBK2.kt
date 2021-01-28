// BBK#2: Find Max and Min

// Question: Print the Highest and Lowest number from the input string.
// "8 3 -5 42 -1 0 0 -9 4 7 4 -4"

fun main() {
    println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"))
}

/**
 * Approach 1
 * using [String.split], [String.toIntOrNull]
 *
 * Notes:
 * 1. Parsing to Int could fail, always use safe operations and provide fallbacks .i.e
 * instead of  toInt(), I have used [toIntOrNull] and did ?: handling
 * 2. Never propagate null from one scope to other, that is why ?: handling is important.
 *
 * Cons:
 * 1. Both [max] and [min] are mutable variable, and can be accidentally mutated anywhere within the scope of [highAndLow] function
 * 2. [forEach] iterations should be used only for reading values not for mutations,
 * here it is used to external mutation of variables outside the scope of [forEach] loop.
 * For such use cases transformation operators should be used example [String.map], [String.reduce] etc.
 * 3. Logic is over expressive.
 */
fun highAndLow(numbers: String): String {
    val numbs = numbers.split(" ")
    var max = numbs[0].toIntOrNull() ?: -1
    var min = numbs[0].toIntOrNull() ?: -1
    numbs.forEach { num ->
        val currentNumber = num.toIntOrNull() ?: -1
        if (currentNumber > max) {
            max = currentNumber
        }
        if (currentNumber < min) {
            min = currentNumber
        }
    }
    return "max = ${max}, min = ${min}"
}