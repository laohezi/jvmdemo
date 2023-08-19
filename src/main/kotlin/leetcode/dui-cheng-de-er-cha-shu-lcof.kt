package leetcode

fun isSymmetric(root: TreeNode?): Boolean {


return isTwoSymetric(root,root)






}

fun isTwoSymetric(a:TreeNode?,b:TreeNode?): Boolean {
    if (a ==null && b==null){
        return true
    }
    if (a!=null&& b!=null){
        return a.`val` ==b.`val` && isTwoSymetric(a.left,b.right) && isTwoSymetric(a.right,b.left)
    }
    return false


}