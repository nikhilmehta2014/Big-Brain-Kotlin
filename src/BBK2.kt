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
/*
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
}*/

/**
 * Approach 2
 * using [String.fold]
 *
 * Pros:
 * 1. We got rid of external mutation by getting rid of [max],[min] variables
 * 2. By using [fold], we are reducing to the one result, mutations are scoped within the fold iteration.
 *
 * Cons:
 * 1. Still bit more Expressive code.
 */
/*fun highAndLow(numbers: String): String {
    val firstNumber: Int = numbers.split(" ")[0].toIntOrNull() ?: -1
    val result = numbers.split(" ")
        .fold(
            Pair<*//*max*//*Int,*//*min*//*Int>(firstNumber,firstNumber)
        ){ acc, it ->
            val item = it.toIntOrNull()?:-1
            return@fold when{
                item>acc.first -> acc.copy(first = item) // updateMax
                item<acc.second -> acc.copy(second = item) // updateMin
                else-> acc // do nothing..
            }
        }
    return "${result.first} ${result.second}"
}*/

/**
 * Approach 3
 * using [Collection.map], [filterNotNull], [maxOrNull], [minOrNull]
 */
/*fun highAndLow(numbers: String): String {
    val nums = numbers.split(" ")
        .map {
            it.toIntOrNull()
        }
        .filterNotNull()
    val max = nums.maxOrNull()
    val min = nums.minOrNull()
    return "$max $min"
}*/

/**
 * Approach 4
 * Shorter and cleaner form of Approach 3
 */
/*fun highAndLow(numbers: String): String =
    numbers.split(" ")
        .map(String::toIntOrNull)
        .filterNotNull()
        .let {
            "${it.max()} ${it.minOrNull()}"
        }*/

/**
 * Approach 5
 * Shorter and cleaner form of Approach 4
 */
/*fun highAndLow(numbers: String): String =
    numbers.split(" ").mapNotNull(String::toIntOrNull)
        .let {
            "${it.max()} ${it.minOrNull()}"
        }*/

/**
 * Approach 6
 * using [splitToSequence], [first], [maxOf]
 *
 * Notes:
 * 1. [splitToSequence] does not iterate on the string, it only generates a lazy sequence
 * 2. example used splitToSequence(' ') and not splitToSequence(" "), that is because char split is more efficient
 * 3. To make the solution even more efficient, should replace [acc.copy] part with [when] expression
 */
fun highAndLow(numbers:String):String{
    val seq = numbers.splitToSequence(' ')
    val first = seq.first().toIntOrNull()
    val result = seq.fold(Pair(first, first)) { acc, item ->
        val numb = item.toIntOrNull()
        return@fold if(numb!=null){
            acc.copy(first = maxOf(acc.first ?: -1, numb), second = minOf(acc.second ?: -1, numb))
        }else{
            acc
        }
    }
    return "${result.first} ${result.second}"
}