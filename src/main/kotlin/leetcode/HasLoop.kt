package leetcode

fun detectCycle(head: ListNode?): ListNode? {
    if (head ==null){
        return  null
    }
    var fast = head
    var slow = head

    while (fast!=null){
        slow = slow?.next

        if (fast.next ==null ){
            return null
        }else{
            fast = fast.next?.next
        }

        if (fast == slow){
            var ptr = head
            while (slow != ptr){
                ptr = ptr?.next
                slow = slow?.next
            }
            return  ptr
        }

    }

    return null









}