package leetcode


fun reverseString(s: CharArray): Unit {
    var pre = 0; var last = s.size - 1
    var cache: Char?
    while (pre < last) {
        cache = s[pre]
        s[pre] = s[last]
        s[last] = cache
        pre++
        last--
    }
}

fun main() {
    reverseString(charArrayOf('1', '2', '3', '4'))
}

