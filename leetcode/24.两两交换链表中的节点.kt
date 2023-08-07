package leetcode

import leetcode.util.ListNode

fun main() {
    val data = listOf(1, 2, 3, 4)
    val head = createListNode(data)
    swapPairs(head)
}

fun swapPairs(head: ListNode?): ListNode? {
    var cache = -1
    var p = head
    var pre = p
    while (p != null) {
        if (cache == -1) {
            cache = p.`val`
            pre = p
            p = p.next
            continue
        }
        pre?.`val` = p.`val`
        p.`val` = cache
        cache = -1
        pre = p.next
        p = pre
    }
    return head
}

fun createListNode(data: List<Int>): ListNode? {
    var head: ListNode? = null
    var help: ListNode? = null
    if (data.isNotEmpty()) {
        data.forEach {
            if (head == null) {
                head = ListNode(it)
                help = head
                return@forEach
            }
            help?.next = ListNode(it)
            help = help?.next
        }
    }
    return head
}
