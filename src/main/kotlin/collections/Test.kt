package collections

fun main() {

    fold()
    println("--------------------------------------")
    reduce()

}

fun fold() {
    val list = listOf<Int>(0, 1, 2, 3, 4, 5, 6)
    list.fold(10) { a, b ->
        val t = a + b
        println("a=$a,b=$b,t=$t")
        t
    }
}

fun Myfold() {
    val list = listOf<Int>(0, 1, 2, 3, 4, 5, 6)

}


fun foldRight() {
    val list = listOf<Int>(0, 1, 2, 3, 4, 5, 6)
    list.foldRight(10) { a, b ->
        val t = a + b
        println("a=$a,b=$b,t=$t")
        t
    }
}

fun reduce() {
    val list = listOf<Int>(0, 1, 2, 3, 4, 5, 6)
    list.reduce() { a, b ->
        val t = a + b
        println("a=$a,b=$b,t=$t")
        t
    }
}


fun <T, R> List<T>.Myfold(initial: R, opration: (R, T) -> R) {
    var result = initial
    for (i in this) {
        result = opration(result, i)
    }

}
