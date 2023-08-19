package leetcode

import java.util.Stack

fun main() {
    val arr = arrayOf(1,4,2,56,4,312,333,32,44,32,12,33,44,56,75,65,33,22)
    quickSortIt(arr)
    println(arr.joinToString())

}
//分解质因数
fun factorization(n: Int) {
    val stringBuilder = StringBuilder()
    var current = n;
    var end = false
    while (current>2&& !end) {
        for (i in 2 until current) {
            if (current % i == 0) {
                current /= i
                stringBuilder.append("${i}x")
                break;
            }
            //如果没有找到因数，说明当前数就是质数
            end = true
        }
    }
    stringBuilder.append(current)
    println(stringBuilder)
}

fun myQuickSort(arr: Array<Int>){
    val stack = Stack<Int>()
    stack.push(0)
    stack.push(arr.size-1)
    while (!stack.isEmpty()){
        val right = stack.pop()
        val left = stack.pop()
        if (left >= right) continue
        var i = left
        var j = right
        var pivot = arr[i]
        while (i<j){
            while (i<j && arr[j]>=pivot) j--
            if (i<j) arr[i] = arr[j]
            while (i<j && arr[i]<pivot) i++
            if (i<j) arr[j] = arr[i]
        }
        arr[i] = pivot
        stack.push(left)
        stack.push(i-1)
        stack.push(i+1)
        stack.push(right)

    }


}


//实现快速排序
fun quickSortIt(arr: Array<Int>) {
   val stack = Stack<Int>()
    stack.push(0)
    stack.push(arr.size-1)
    while (!stack.isEmpty()) {
        var right = stack.pop()
        var left = stack.pop()
        if (left >= right) {
            continue
        }
        var i = left
        var j = right
        val pivot = arr[i]
        while (i<j){
            while (i < j && arr[j] >= pivot) j--
            if (i<j){ arr[i] = arr[j]}

            while (i < j && arr[i] < pivot) i++
            if (i<j){
                arr[j] = arr[i]
            }
        }



        arr[i] = pivot
        stack.push(left)
        stack.push(i - 1)
        stack.push(i + 1)
        stack.push(right)
    }


}


fun quickSort(arr: Array<Int>, left: Int, right: Int) {

    var i = left
    var j = right
    if (i>=j){
        return
    }
    var pivot = arr[i]
    while (i<j){
        while (i<j && arr[j]>=pivot) j--
        arr[i] = arr[j]
        while (i<j && arr[i]<pivot) i++
        arr[j] = arr[i]
        arr[i] = pivot
        quickSort(arr,left,i-1)
        quickSort(arr,i+1,right)
    }

}


/*
fun quickSort(arr: IntArray, left: Int, right: Int) {
    if (left >= right) return // 当左右指针相遇或越界时结束递归
    val pivot = arr[left] // 选择第一个元素为基准元素
    var i = left // i从左边开始遍历
    var j = right // j从右边开始遍历
    while (i < j) {
        // 从右向左找第一个小于基准元素的元素
        while (i < j && arr[j] >= pivot) j--
        if (i < j) arr[i++] = arr[j] // 将该元素移到左边
        // 从左向右找第一个大于等于基准元素的元素
        while (i < j && arr[i] < pivot) i++
        if (i < j) arr[j--] = arr[i] // 将该元素移到右边
    }
    arr[i] = pivot // 将基准元素放到最终位置
    quickSort(arr, left, i - 1) // 递归排序左子数组
    quickSort(arr, i + 1, right) // 递归排序右子数组
}*/
