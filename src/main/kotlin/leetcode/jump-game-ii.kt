package leetcode

import  kotlin.math.max

fun jump(nums: IntArray): Int {

    var step = 0
    var n = nums.size
    var currentMax = 0
    var end =0
    for (i in 0 until n-1) {
        currentMax = max(currentMax, i + nums[i])
        if (i == end){
            end = currentMax
            step++
        }

    }


    return step

}






