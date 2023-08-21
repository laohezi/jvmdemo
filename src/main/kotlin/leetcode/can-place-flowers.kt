package leetcode

import coroutine.flow

fun main() {
    val list = intArrayOf(1, 0, 0, 0, 0, 1)
    canPlaceFlowers(list, 2)
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var n = n
    var i = 0
    while (i < flowerbed.size && n>=0) {
        if (flowerbed[i] == 1) {
            i += 2
        } else if (i ==flowerbed.size - 1 || flowerbed[i + 1] == 0) {
            n--
            i += 2
        } else {
            i += 3
        }

    }

    return n<=0


}