package leetcode

import kotlin.math.max


fun main() {
    val nums1 = intArrayOf(1,2,3,2,1)
    val nums2 = intArrayOf(3,2,1,5,7)
    val maxContains = findLength(nums1,nums2)

}


class DPMLORS{

    fun findLength(nums1: IntArray, nums2: IntArray): Int{

        return 0



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