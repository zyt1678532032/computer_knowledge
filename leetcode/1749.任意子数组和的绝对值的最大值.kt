package leetcode

import kotlin.math.max
import kotlin.math.min


/**
 * 一、动态规划、数组
 * @link https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 */
fun maxAbsoluteSum(nums: IntArray): Int {
    var positiveMax = 0; var negativeMin = 0
    var positiveSum = 0; var negativeSum = 0
    nums.forEach {
        positiveSum += it
        positiveMax = max(positiveMax, positiveSum)
        positiveSum = max(positiveSum, 0) // 子数组和的最大值【动态规划】

        negativeSum += it
        negativeMin = min(negativeMin, negativeSum)
        negativeSum = min(0, negativeSum)// 子数组和的最小值【动态规划】
    }
    return max(positiveMax, -negativeMin)
}