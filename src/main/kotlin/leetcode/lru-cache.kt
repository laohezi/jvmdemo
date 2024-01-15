package leetcode

fun main() {
   val cache = LRUCache(2)
    cache.put(1,1)
    cache.put(2,2)
    cache.get(1)
    cache.put(3,3)
    cache.get(2)
    cache.put(4,4)
    cache.get(1)
    cache.get(3)
    cache.get(4)




}


class LinkedLRUCache(capacity: Int) {

    val map = LinkedHashMap<Int, Int>(capacity, 1f, true)

    val capacity: Int

    init {
        this.capacity = capacity

    }

    fun get(key: Int): Int {
        return map.getOrDefault(key, -1)


    }

    fun put(key: Int, value: Int) {
        map.put(key, value)
        if (map.size > capacity) {
            map.remove(map.keys.first())
        }

    }

}


class LRUCache(capacity: Int) {
    val capacity: Int
    val cache = HashMap<Int, DLinkNode?>()
    val dummyTail = DLinkNode(
        -1,-1,null,null
    )
     val dummyHead = DLinkNode(
         -1,-1,null,null
     )


    var size = 0

    init {
        this.capacity = capacity
        dummyHead.next = dummyTail
        dummyTail.pre = dummyHead
    }


    data class DLinkNode(
        val key: Int,
        var value: Int,
        var pre: DLinkNode?,
        var next: DLinkNode?
    )


    fun get(key: Int): Int {
       val value = cache.get(key)
        if (value ==null) return -1
        moveToHead(value)
        return  value.value
    }

    fun put(key: Int, value: Int) {
        val hint = cache.get(key)
        if (hint!=null){
            hint.value = value
            moveToHead(hint)
        }else{
            val node = DLinkNode(key,value,dummyHead,dummyHead.next)
            dummyHead.next!!.pre = node
            dummyHead.next = node
            size++
            cache.put(key,node)
            if (size>capacity){
                removeTail()
                size--
            }
        }



    }

    fun moveToHead(node:DLinkNode){
        if (node.pre !=dummyHead){
            node.pre!!.next = node.next
            node.next?.pre = node.pre
            node.pre = dummyHead
            node.next = dummyHead.next
            dummyHead.next = node
        }
    }

    fun removeTail(){
        val tail = dummyTail.pre
        if (tail != dummyHead){
            cache.remove(tail!!.key)
            tail.pre!!.next = dummyTail
            dummyTail.pre = tail.pre
            tail.next = null
            tail.pre = null
        }
    }

}


