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


//  不拿出直接反转

fun reverseList(head: ListNode?): ListNode? {

    var dumyTail = head
    var dumyHead = head
    while (dumyTail?.next != null) {
        var current = dumyTail.next!!
        var next = current.next
        current.next = dumyHead
        dumyHead = current
        dumyTail.next = next
    }

    return dumyHead

}

// 创建新的链表来反转

fun reverseList1(head: ListNode?): ListNode? {
    var dummyHead: ListNode? = null
    var current = head
    while (current != null) {
        var next = current?.next
        current.next = dummyHead
        dummyHead = current
        current = next
    }

    return dummyHead

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