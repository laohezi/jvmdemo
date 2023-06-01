package leetcode

import java.util.Stack

class CQueue() {

    val inStack = Stack<Int>()
    val outStack = Stack<Int>()


    fun appendTail(value: Int) {
        inStack.push(value)

    }

    fun deleteHead(): Int {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop())
            }
        }
        if (outStack.isEmpty()){
            return  -1
        }
        return  outStack.pop()
    }

}