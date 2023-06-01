package leetcode

import kotlin.math.max
import kotlin.math.min

class BrutalForceGuPiao {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        val f = Array(n) { Array(n) { 0 } }
        var profit = 0

        for (i in 0 until n - 1) {
            for (j in i until n - 1) {
                profit = max(profit, prices[j] - prices[i])
            }
        }


        return profit

    }
}

class DoubleVariable {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var profit = 0
        for (i in 0 until prices.size) {
            if (prices[i]<min){
                min = prices[i]
            }else{
                profit = max(profit,prices[i]-min)
            }


        }

        return profit

    }
}
