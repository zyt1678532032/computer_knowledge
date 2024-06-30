package leetcode


/**
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

fun main() {
    println(isEquals("eat", "aet"))
    println(isEquals("eat", "ate"))
    println(isEquals("ddddddddddg", "dgggggggggg"))
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val strs2 = arrayOf("eat", "tea")
    val strs3 = arrayOf("ddddddddddg", "dgggggggggg")
    println(groupAnagrams(strs).toString())
    println(groupAnagrams(strs2).toString())
    println(groupAnagrams(strs3).toString())
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return listOf(listOf())

    val result = mutableListOf<MutableList<String>>()
    strs.forEach out@{ str1 ->
        var isContains = false
        result.forEach inner@{ strings ->
            val str2 = strings[0]
            if (isEquals(str1, str2)) {
                isContains = true
                strings += str1
                return@inner
            }
        }
        if (!isContains) {
            result += mutableListOf(str1)
        }
    }

    return result
}

fun isEquals(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false
    val map1 = mutableMapOf<Char, Int>()
    val map2 = mutableMapOf<Char, Int>()
    str1.forEach {
        if (!map1.containsKey(it)) {
            map1[it] = 1
            return@forEach
        }
        map1[it]?.let { value ->
            map1[it] = value + 1
        }
    }
    str2.forEach {
        if (!map2.containsKey(it)) {
            map2[it] = 1
            return@forEach
        }
        map2[it]?.let { value ->
            map2[it] = value + 1
        }
    }
    for (entity in map1.entries) {
        val (key, value) = entity
        if (map2[key] == null) {
            return false
        }
        if (map2[key] != value) {
            return false
        }
    }
    return true
}