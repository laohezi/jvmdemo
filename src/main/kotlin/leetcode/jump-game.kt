package leetcode

import kotlin.math.max

fun canJump(nums: IntArray): Boolean {
    var maxPosition = 0
   for (i in 0 until nums.size){
       if (i<=maxPosition){
           maxPosition = max(maxPosition,i+nums[i])
           if (maxPosition >nums.size-1){
               return true
           }
       }
   }


return false
}


