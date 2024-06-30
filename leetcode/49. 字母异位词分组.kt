package leetcode

import java.util.Arrays


/**
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val strs2 = arrayOf("eat", "tea")
    val strs3 = arrayOf("ddddddddddg", "dgggggggggg")
    println(groupAnagrams(strs).toString())
    println(groupAnagrams(strs2).toString())
    println(groupAnagrams(strs3).toString())
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val dict = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val charArray = str.toCharArray()
        Arrays.sort(charArray)
        val key = String(charArray)
        dict[key] = dict[key] ?: mutableListOf()
        dict[key]?.let {
            it += str
        }
    }
    return dict.values.toList()
}
