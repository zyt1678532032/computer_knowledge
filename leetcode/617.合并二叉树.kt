package leetcode

import leetcode.util.TreeNode
import java.util.LinkedList


/**
 * 合并二叉树
 * @link https://leetcode.cn/problems/merge-two-binary-trees/description/
 */
fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1

    val root = TreeNode(root1.`val` + root2.`val`)
    root.left = mergeTrees(root1.left, root2.left)
    root.right = mergeTrees(root1.right, root2.right)
    return root
}

// 层次遍历
fun mergeTreesByLevelOrder(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1

    val queue1 = LinkedList<TreeNode>()
    val queue2 = LinkedList<TreeNode>()
    val resultQueue = LinkedList<TreeNode>()
    queue1 += root1
    queue2 += root2
    val result = TreeNode(root1.`val` + root2.`val`)
    resultQueue += result

    while (queue1.isNotEmpty() && queue2.isNotEmpty()) {
        val node1 = queue1.poll()
        val node2 = queue2.poll()
        val resultNode = resultQueue.poll()

        val left1 = node1.left; val left2 = node2.left
        val right1 = node1.right; val right2 = node2.right

        if (left1 != null && left2 != null) {
            resultNode.left = TreeNode(left1.`val` + left2.`val`)
            resultQueue += resultNode.left!!
            queue1 += left1
            queue2 += left2
        } else if (left1 != null) {
            resultNode.left = left1
        } else if (left2 != null) {
            resultNode.left = left2
        }

        if (right1 != null && right2 != null) {
            resultNode.right = TreeNode(right1.`val` + right2.`val`)
            resultQueue += resultNode.right!!
            queue1 += right1
            queue2 += right2
        } else if (right1 != null) {
            resultNode.right = right1
        } else if (right2 != null) {
            resultNode.right = right2
        }
    }

    return result
}