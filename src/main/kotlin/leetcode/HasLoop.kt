package leetcode


fun main() {

}

fun detectCycle(head: ListNode?): ListNode?{
   val map = HashSet<ListNode>()
    var current = head
    while (current!=null){
       if (map.contains(current)){
           return  current
       } else{
          map.add(current)
          current = current.next
       }

    }


    return null

}