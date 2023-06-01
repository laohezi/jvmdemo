package leetcode

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
     val map = HashMap<Char,Int>()
        var max  =0
        var start = 0
       for (end in s.indices){
           val char = s[end]
           if (map.containsKey(char)){
               start = max(start,map[char]!!+1)
           }
           map[char] = end
           max = max(end-start+1,max)
       }
        return max
    }

}