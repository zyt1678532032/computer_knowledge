package leetcode

/**
 * 示例:
 *  输入：n = 234
 *  输出：15
 *  解释：
 *  各位数之积 = 2 * 3 * 4 = 24
 *  各位数之和 = 2 + 3 + 4 = 9
 *  结果 = 24 - 9 = 15
 */
fun subtractProductAndSum(n: Int): Int {
    var product = 1
    var sum = 0
    var ele = n
    while (ele != 0) {
        val remainder = ele % 10
        ele /= 10
        product *= remainder
        sum += remainder
    }
    return product - sum
}