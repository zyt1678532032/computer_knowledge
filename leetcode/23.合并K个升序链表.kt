package leetcode

import leetcode.util.ListNode

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @link https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var head: ListNode? = null
    for (i in lists.indices) {
        head = mergeTwoList(head, lists[i])
    }
    return head
}

/**
 *  合并两个有序链表
 *  时间复杂度: O(n)
 *  空间复杂度: O(1)
 */
fun mergeTwoList(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null || list2 == null) return list1 ?: list2

    val head = ListNode(0)
    var tail: ListNode = head
    var aPtr = list1;
    var bPtr = list2
    while (aPtr != null && bPtr != null) {
        if (aPtr.`val` < bPtr.`val`) {
            tail.next = aPtr
            tail = tail.next!!
            aPtr = aPtr.next
        } else {
            tail.next = bPtr
            tail = tail.next!!
            bPtr = bPtr.next
        }
    }
    tail.next = aPtr ?: bPtr
    return head.next
}
