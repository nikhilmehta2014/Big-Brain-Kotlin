import kotlin.math.abs

// BBK#5: Imposter Among Us

// Find the imposter from the given array with atleast 3 items, it's either entirely comprised of odd integers or
// entirely comprised of even integers except for a single integer N.
// Write a method that takes the array as an argument and returns this "Imposter" N.

// imposter(arrayOf(2,6,8,-10,3)) => returns 3
// imposter(arrayOf(206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781)) => returns 206847684
// imposter(arrayOf(Integer.MAX_VALUE, 0, 1))=> returns 0

fun main() {
    println(imposter(arrayOf(2, 6, 8, -10, 3)))
    println(imposter(arrayOf(21104421, 1056521, 35521, 7, 1901, 17, 7, 206847684, 1, 1, 7781)))
    println(imposter(arrayOf(Integer.MAX_VALUE, 0, 1)))
}

/**
 * Approach 1
 * using [map], [abs], [take], [fold]
 *
 * complexity: O(3n+2) ~ O(n)
 */
fun imposter(integers: Array<Int>): Int {
    // convert array to 0,1
    val flattened = integers.map {
        abs(it % 2)
    }
    // count numbers of 0 and 1
    val (zeroCount, oneCount) = flattened.take(3)
        .fold(0 to 0) { acc, item ->
            return@fold when {
                item == 0 -> acc.copy(first = acc.first + 1)
                else -> acc.copy(second = acc.second + 1)
            }
        }
    // if array of 1's find 0, else find 1
    val whoIsImposer = if (oneCount > zeroCount)
        0
    else
        1
    val imposterIndex = flattened.indexOf(whoIsImposer)
    return if (imposterIndex != -1)
        integers[imposterIndex]
    else
        -1
}

