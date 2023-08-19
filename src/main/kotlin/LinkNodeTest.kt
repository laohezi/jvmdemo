fun main() {

}

object Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    fun removeNthFromEnd(head: ListNode?,n: Int): ListNode?  {
       if (head ==null){
           return null
       }
        var quick = head
        var toDeletePre = head
        var dummyHead = head
       for (i in 1 ..n){
           quick = quick?.next
           if (quick ==null){ //
               return dummyHead.next
           }
       }
       while (quick !=null){
           quick = quick.next
           if (quick !=null){
               toDeletePre = toDeletePre?.next
           }
       }
        toDeletePre?.next = toDeletePre?.next?.next


      return  dummyHead






    }
}

class ListNode(var `val`: Int) {
         var next: ListNode? = null
     }