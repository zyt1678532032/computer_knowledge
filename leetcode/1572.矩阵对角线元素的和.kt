package leetcode

/**
 * 给你一个正方形矩阵mat，请你返回矩阵对角线元素的和。
 * i: 行 j: 列
 * [1,1] [2,2] ... [i,j] i == j
 * [i,1] [i-1,2] [i-2,3] ... [1,i]
 */
fun diagonalSum(mat: Array<IntArray>): Int {
    var sum = 0
    for (i in mat.indices) {
        sum += mat[i][i] + mat[i][mat.size - i - 1]
    }
    if (mat.size % 2 == 0) {
        return sum
    }
    return sum - mat[mat.size / 2][mat.size / 2]
}

fun main() {
    val ints = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1)
    )
    println(diagonalSum(ints))
    highFunction {
        return@highFunction
    }
}


// crossinline 所修饰的lambda表达式不允许非局部返回（non-local return）
inline fun highFunction(crossinline block: () -> Unit) {
    println("highFunction --> start")
    block.invoke()
    println("highFunction --> end")
}