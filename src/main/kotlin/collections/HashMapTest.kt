package collections

fun main() {

    val map = HashMap<Key, String>()
    val key = Key()
    map.put(key, "1")
    key.age = 1
    map.put(key, "2")
    println(map)
    map.remove(key)
    println(map)

}



class Key{
    var name:String = ""
    var age:Int = 0

    override fun hashCode(): Int {
        return age
    }

    override fun equals(other: Any?): Boolean {
        return other is Key && other.age == age
    }

}