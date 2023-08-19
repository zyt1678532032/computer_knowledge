package leetcode

/**
 * 2682. 找出转圈游戏输家
 * @link https://leetcode.cn/problems/find-the-losers-of-the-circular-game/description/
 */
fun circularGameLosers(n: Int, k: Int): IntArray {
    val peoples = IntArray(n + 1) { 0 }

    peoples[1] = 1
    var count = 1
    var index = 1
    while (true) {
        index = (index + count * k) % n
        count++
        if(index == 0) index = n
        peoples[index] = peoples[index] + 1
        if (peoples[index] == 2) break
    }

    val result = mutableListOf<Int>()
    for (i in 1 until peoples.size) {
        if (peoples[i] == 0) result += i
    }
    return result.toIntArray()
}

fun main() {
    println(circularGameLosers(4, 9).contentToString())
}
