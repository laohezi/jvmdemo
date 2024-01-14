package leetcode


fun main() {

}

fun detectCycle(head: ListNode?): ListNode?{
    if (head == null) {
        return null
    }
    var fast = head
    var slow = head
    var loopNode:ListNode? =null
    while (fast != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (fast!=null && fast == slow) {
            loopNode = slow
        }
    }



    return loopNode

}