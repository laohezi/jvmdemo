package leetcode

fun main() {
    var a:String? =null
    var b:String = a!!


}


fun containsDuplicate(numbers:IntArray): Boolean {
    for (i in numbers.indices) {
        for (j in i+1 until numbers.size) {
            if (numbers[i] == numbers[j])

            return  true
        }
    }
    return false
}



fun containsDuplicate1(numbers: IntArray): Boolean {
    val set = java.util.HashSet<Int>()
    set.addAll(numbers.toList())
    return set.size != numbers.size
}


suspend fun stest(){


}



