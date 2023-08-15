package leetcode

/**
 * @link https://leetcode.cn/problems/minimum-falling-path-sum/
 */
fun minFallingPathSum1(matrix: Array<IntArray>): Int {
    val n = matrix.size
    val f = Array(n) { IntArray(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == 0) {
                f[i][j] = matrix[i][j]
                continue
            }
            var min: Int
            if (j == 0) {
                min = Math.min(f[i - 1][j], f[i - 1][j + 1])
                f[i][j] = min + matrix[i][j]
                continue
            }
            if (j == n - 1) {
                min = Math.min(f[i - 1][j - 1], f[i - 1][j])
                f[i][j] = min + matrix[i][j]
                continue
            }
            min = Math.min(f[i - 1][j - 1], f[i - 1][j])
            min = Math.min(f[i - 1][j + 1], min)
            f[i][j] = min + matrix[i][j]
        }
    }
    var result = Int.MAX_VALUE
    f[n - 1].forEach {
        if (result > it) result = it
    }
    return result
}