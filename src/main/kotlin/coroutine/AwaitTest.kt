package coroutine

import kotlinx.coroutines.*
import ld

fun main() = runBlocking {
    ld("start")
    val s1 = step1()
    val s2 = step2()
    ld(s1.await() +s2.await())

}

fun step1() = GlobalScope.async(Dispatchers.IO){
    delay(2000)
    return@async "step1"
}

fun step2() = GlobalScope.async(Dispatchers.IO){
    delay(2000)
    return@async "step2"
}


