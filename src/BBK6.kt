// BBK#6: The Morse Code

// You have received a secret message! unfortunately you can’t just read it, it is encoded in Morse code.
// Your task is to implement a function that would take the morse code as input and return a human-readable string.
// 3 spaces are used to separate words and Extra spaces before or after the code have no meaning and should be ignored

val morseDecoder = mapOf<String, String>(
    ".-" to "A",
    "-..." to "B",
    "-.-." to "C",
    "-.." to "D",
    "." to "E",
    "..-." to "F",
    "--." to "G",
    "...." to "H",
    ".." to "I",
    ".---" to "J",
    "-.-" to "K",
    ".-.." to "L",
    "--" to "M",
    "-." to "N",
    "---" to "O",
    ".--." to "P",
    "--.-" to "Q",
    ".-." to "R",
    "..." to "S",
    "-" to "T",
    "..-" to "U",
    "...-" to "V",
    ".--" to "W",
    "-..-" to "X",
    "-.--" to "Y",
    "--.." to "Z",
    ".----" to "1",
    "..---" to "2",
    "...--" to "3",
    "....-" to "4",
    "....." to "5",
    "-...." to "6",
    "--..." to "7",
    "---.." to "8",
    "----." to "9",
    "-----" to "0",
    "" to " ",
    ".-.-.-" to ".",
    "--..--" to ",",
    "---..." to ".",
    "..--.." to "?",
    "-.-.--" to "!",
    "...---..." to "SOS",
    "-....-" to "''",
    "-..-." to "/",
    "-.--.-" to "()",
    ".--.-." to "@",
    "-...-" to "="
)

fun main() {
    println(decodeMorse("-.-- --- ..-   .... .- ...- .   .-   -... .. --.   -... .-. .- .. -.   ..-. --- .-.   -.- --- - .-.. .. -."))
}

/**
 * Approach 1
 * Imperative way
 *
 * complexity : O(n^2)
 */
/*fun decodeMorse(code: String): String {
    val morseWords = code.split("   ")
    val humanized = StringBuilder()
    for (morseWord in morseWords) {
        val morseChars = morseWord.split(" ")
        for (morseChar in morseChars) {
            if (morseChar.isNotEmpty()) {
                humanized.append(morseDecoder[morseChar])
            }
        }
        humanized.append(" ")
    }
    return humanized.toString()
}*/

/**
 * Approach 2
 * Imperative equivalent code in functional style
 *
 * complexity : O(n^2)
 *
 * Performance hit in here due to [joinToString] operation one at the outer loop and multiple times into the inner loop.
 */
/*
fun decodeMorse(code: String): String {
    return code.trim()
        .split("   ")
        .joinToString(separator = " ") { word ->
            word.split(" ").joinToString(separator = "") { char ->
                morseDecoder[char] ?: ""
            }
        }
}*/

/**
 * Approach 3
 * using [flatMap], [map], [joinToString]
 *
 * complexity : O(n)
 */
fun decodeMorse(code: String) = code
    .split("  ")
    .flatMap {
        it.split(" ")
    }.joinToString("") {
        morseDecoder[it] ?: " "
    }