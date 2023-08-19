package leetcode

fun main() {
    val map = LinkedHashMap<Int, Int>(64, 1f, true)
    map.put(1, 1)
    map.put(3, 3)
    map.put(2, 2)
    map.get(1)
    map.get(2)
    map.get(3)
    map.get(2)
    map.get(1)


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
    val cache = HashMap<Int, DLinkNode>()
    val dummyHead = DLinkNode(0, 0, null, null)
    val dummyTail = DLinkNode(0, 0, null, null)
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
        if (cache.containsKey(key)) {
            val node = cache[key]!!
            moveToHead(node)
            return node.value
        }

        return -1

    }

    fun put(key: Int, value: Int) {

        if (cache.containsKey(key)) {
            val node = cache.get(key)!!
            node.value = value
            cache.put(key, node)
            moveToHead(node)
        } else {
            val node = DLinkNode(key, value, null, null)
            cache.put(key, node)
            moveToHead(node)
            size++
        }
        if (size > capacity) {
            val lastNode = dummyTail.pre!!

            removeNode(lastNode)
            cache.remove(lastNode.key)
            size--
        }
    }

    fun moveToHead(node: DLinkNode) {
        removeNode(node)
        node.pre = dummyHead
        dummyHead.next?.apply {
            pre = node
            node.next = this
        }
        dummyHead.next = node
    }

    fun removeNode(node: DLinkNode) {

        node.next?.pre = node.pre
        node.pre?.next = node.next
    }


}


