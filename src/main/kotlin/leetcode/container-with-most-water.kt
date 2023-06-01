package leetcode
import  kotlin.math.max
fun maxArea(height: IntArray): Int {
    var max = 0
    var i = 0
    var j = height.size -1
    while (i<j){
        if (height[i]<height[j]){
            max = max(max,height[i]*(j-i))
            i++
        }else{
            max = max(max,height[j]*(j-i))
            j--
        }

    }
    return  max

}