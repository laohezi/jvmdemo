package lang

import kotlin.reflect.KProperty


class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "${thisRef?.javaClass}, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in ${thisRef?.javaClass}.")
    }
}

fun main() {
   var test = Test()
    test.string = "lalala"
    print(test.string)

}

class Test{
    var string by Delegate()

}

