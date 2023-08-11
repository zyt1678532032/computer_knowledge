package leetcode

/**
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * @link https://leetcode.cn/problems/minimum-falling-path-sum-ii/
 */
fun minFallingPathSum(grid: Array<IntArray>): Int {
    val n = grid.size
    val f = Array(n) { IntArray(n) }
    f.forEachIndexed one@{ i, ints ->
        ints.forEachIndexed two@{ j, _ ->
            if (i == 0) {
                f[0][j] = grid[0][j]
                return@two
            }
            var result = Int.MAX_VALUE
            for (k in 0 until f[i - 1].size) {
                if (k == j) continue
                result = Math.min(result, f[i - 1][k])
            }
            f[i][j] = result + grid[i][j]
        }
    }
    var result = Int.MAX_VALUE
    f[n - 1].forEach {
        if (result > it) result = it
    }
    return result
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    println(minFallingPathSum(grid))
}