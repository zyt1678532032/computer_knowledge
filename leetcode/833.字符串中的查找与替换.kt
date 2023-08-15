package leetcode

/**
 * @link https://leetcode.cn/problems/find-and-replace-in-string/description/
 *
 * 题解:https://leetcode.cn/problems/find-and-replace-in-string/solutions/2388853/xian-xing-zuo-fa-pythonjavacgojs-by-endl-uofo/
 */
fun findReplaceString(
    s: String,
    indices: IntArray,
    sources: Array<String>,
    targets: Array<String>
): String {
    val replaceStr = Array<String?>(s.length) { null }
    val replaceLen = Array<Int>(s.length) { 1 }

    for (i in indices.indices) {
        val index = indices[i]
        if (s.startsWith(sources[i], index)) {
            replaceStr[index] = targets[i]
            replaceLen[index] = sources[i].length
        }
    }

    var result = ""
    var j = 0
    for (i in s.indices) {
        if (i < j) continue
        if (replaceStr[i] == null) {
            result += s[i]
            j = i + 1
            continue
        }
        result += replaceStr[i]
        j = i + replaceLen[i]
    }
    return result
}