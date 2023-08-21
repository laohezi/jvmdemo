package leetcode

import java.util.Stack


class IteratorSolution {

    fun inorderTraversal(root: TreeNode?): List<Int>? {
return null

    }

}


class RecursiveSolution {
    val list = ArrayList<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        root?.apply {
            inorderTraversal(left)
            list.add(`val`)
            inorderTraversal(right)
        }

        return list
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}