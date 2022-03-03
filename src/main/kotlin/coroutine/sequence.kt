package coroutine

fun main() {
 fibonacci.take(10).forEach { println(it) }
}

val fibonacci = sequence {
    yield(1L) // first Fibonacci number
    var cur = 1L
    var next = 1L
    while (true) {
        yield(next) // next Fibonacci number
        val tmp = cur + next
        cur = next
        next = tmp
    }
}
