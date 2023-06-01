package leetcode

import kotlin.math.min

fun mergeAlternately(word1: String, word2: String): String {
    val stringBuilder = StringBuilder()
    val l1 =word1.length
    val l2 = word2.length
    val min = min(l1,l2)
    for (  i in 0 until min){
        stringBuilder.append(word1[i])
        stringBuilder.append(word2[i])

    }
    if (l1==l2){
        return  stringBuilder.toString()
    }
    if (l1>l2){
        stringBuilder.append(word1.substring(min,l1))
    }else{
        stringBuilder.append(word2.substring(min,l2))
    }
    return  stringBuilder.toString()

}