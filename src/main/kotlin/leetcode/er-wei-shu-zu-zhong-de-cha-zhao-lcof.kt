package leetcode

fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {

    if (matrix.size ==0){
        return false
    }

    val m = matrix.size
    val n = matrix[0].size

    for (i in 0 until m){
        m.let {  }
        for (j in 0 until n){
            if (matrix[i][j] == target){
                return true
            }
        }


    }

    return false

}