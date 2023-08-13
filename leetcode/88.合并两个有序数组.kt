package leetcode

/**
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * @link https://leetcode.cn/problems/merge-sorted-array/
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = 0
    var j = 0
    val sorted = IntArray(m + n)
    var s = 0
    while (i < m || j < n) {
        when {
            i == m -> {
                sorted[s++] = nums2[j++]
            }

            j == n -> {
                sorted[s++] = nums1[i++]
            }

            nums1[i] < nums2[j] -> {
                sorted[s++] = nums1[i++]
            }

            else -> {
                sorted[s++] = nums2[j++]
            }
        }
    }
    for (k in 0 until m + n) {
        nums1[k] = sorted[k]
    }
}

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)
    merge(nums1, 3, nums2, 3)
    println(nums1.contentToString())
}