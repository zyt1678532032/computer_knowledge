package leetcode

import leetcode.util.TreeNode


/**
 * 合并二叉树
 * @link https://leetcode.cn/problems/merge-two-binary-trees/description/
 */
fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if(root1 == null) return root2
    if(root2 == null) return root1

    val root = TreeNode(root1.`val` + root2.`val`)
    root.left = mergeTrees(root1.left, root2.left)
    root.right = mergeTrees(root1.right, root2.right)
    return root
}