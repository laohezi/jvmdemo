package leetcode

import kotlin.math.max


fun main() {
    val nums1 = intArrayOf(1,2,3,2,1)
    val nums2 = intArrayOf(3,2,1,5,7)
    val maxContains = findLength(nums1,nums2)

}


class DPMLORS{

    fun findLength(nums1: IntArray, nums2: IntArray): Int{
        val m = nums1.size
        val n = nums2.size
        val dp = Array(m+1){Array(n+1){0} }
        var max = 0
        for (i in  m-1 downTo 0){
            for (j in n-1 downTo  0){
                if (nums1[i] ==nums2[j]){
                    dp[i][j] = dp[i+1][j+1] +1
                }else{
                    dp[i][j] = 0
                }
                max = max(max,dp[i][j])
            }
        }

        return max


    }


}

fun findLength(nums1: IntArray, nums2: IntArray): Int {

    var max = 0
    val map = HashMap<Int,Int>()
    var i =0
    var j = 0
    var step = 0
    while(i<nums1.size){
        while ( j< nums2.size){
           if (nums1[i]==nums2[j]){

               j++
               step++
               max = max(max,step)
               break
           }else{
               step=0
               j++
           }
       }
        i++

   }
    return  max


}