package leetcode


fun main() {
    val data = ListNode(
        1,
        ListNode(
            2,
            ListNode(
                2,
                ListNode(
                    4, ListNode(
                        5, null
                    )
                )
            )
        )
    )

    val ret = reverseList(data)

}


//  反转链表

fun reverseList(head: ListNode?): ListNode? {
    var ret: ListNode? = null

    var cur = head

    while (cur != null) {
        var next = cur.next
        cur.next = ret
        ret = cur
        cur = next
    }

    return ret

}

//递归反转链表
fun reverseList2(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val newHead = reverseList2(head.next)
    head.next?.next = head
    head.next = null
    return newHead
}


data class ListNode(
    val `val`: Int,
    var next: ListNode?
)