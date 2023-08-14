package leetcode.util

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// 前序遍历
fun preorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()

    val result = mutableListOf(root.`val`)
    val leftElements = preorderTraversal(root.left)
    result += leftElements
    val rightElements = preorderTraversal(root.right)
    result += rightElements
    return result
}

// 中序遍历
fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()

    val result = mutableListOf<Int>()
    val leftElements = inorderTraversal(root.left)
    result += leftElements
    result += root.`val`
    val rightElements = inorderTraversal(root.right)
    result += rightElements
    return result
}

// 后序遍历
fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()

    val result = mutableListOf<Int>()
    val leftElements = postorderTraversal(root.left)
    result += leftElements
    val rightElements = postorderTraversal(root.right)
    result += rightElements
    result += root.`val`
    return result
}

// 层次遍历
fun levelOrder(root: TreeNode?): List<List<Int>> {
    return emptyList()
}

// 根据前序遍历构建TreeNode
fun createTreeNodeByPreorder(eles: List<Int>): TreeNode? {
    return null
}