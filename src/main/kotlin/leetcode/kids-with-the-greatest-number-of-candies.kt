package leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val candies = intArrayOf(1, 23, 4, 5, 6, 7)
    val extraCandies = 10
    val result = kidsWithCandies(candies,extraCandies)
    println(result)


}


fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val result = ArrayList<Boolean>(candies.size)
    var max = 0
    for (element in candies) {
        if (element>max){
            max = element
        }
        if (element + extraCandies >= max) {
            result.add(true)
        } else {
            result.add(false)
        }
    }
    return result
}


// 注意类名必须为 Main, 不要有任何 package xxx 信息
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        // 注意 hasNext 和 hasNextLine 的区别
        val s: String = `in`.nextLine()
        val size = s.length
        var count = 0
        var i = size - 1
        while (i == 0) {
            if (s[i] != ' ') {
                count++
            } else {
                break
            }
            i--
        }
        println(count)
    }
}