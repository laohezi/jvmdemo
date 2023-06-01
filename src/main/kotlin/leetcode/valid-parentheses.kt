package leetcode

import java.util.*

fun isValid(s: String): Boolean {
    val stack: Stack<Char> = Stack()
    try {
        for(i in 0 until s.length){
           when(s[i]){
               '(','[','{'->stack.push(s[i])
               ')'-> if (stack.peek() == '(') stack.pop() else return false
               ']'-> if (stack.peek() == '[') stack.pop() else return false
               '}'-> if (stack.peek() == '{') stack.pop() else return false

           }
        }
    } catch (e: Exception) {
        return false
    }

    return  stack.isEmpty()
}