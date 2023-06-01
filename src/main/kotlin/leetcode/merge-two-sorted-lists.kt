package leetcode

fun main() {
    val list1 = fromArray(arrayListOf(-9,-7,-3,-3,-1,2,3))
    val list2 = fromArray(arrayListOf(-7,-7,-6,-6,-5,-3,2,4))
   // val list1 = fromArray(arrayListOf(1,2,4))
 //   val list2 = fromArray(arrayListOf(1,3,4))


    val res =mergeTwoLists(list1,list2)
    println(res!!.toReadableString())


}



    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        var ret = ListNode(0,null )
        var dummyHead = ret
        var a = list1
        var b = list2
        while (a!=null && b!=null){
            if (a.`val` <=b.`val`){
                ret.next = a
                a = a.next
                ret = ret.next!!
            }else{
                ret.next = b
                b = b.next
                ret= ret.next!!
            }
        }
        if (a !=null){
            ret.next = a
        }
        if (b !=null){
            ret.next = b
        }
        return dummyHead.next

    }



fun fromArray(list:List<Int>): ListNode {
    val node = ListNode(list[0],null)
    var tail = node
    for (i in 1 until list.size ){
        tail .next = ListNode(list[i],null)
        tail = tail.next!!
    }
    return node
}

fun ListNode.toReadableString(): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append("[")
    var cur:ListNode? = this
    while (cur !=null){
        stringBuilder.append("${cur.`val`},")
        cur = cur.next
    }
    stringBuilder.append("]")
    return stringBuilder.toString()
}


