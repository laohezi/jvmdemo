package coroutine

import kotlinx.coroutines.*
import ld

fun main() = runBlocking() {
val dispatcher1 = newSingleThreadContext("1")
val dispatcher2 = newSingleThreadContext("2")
val scope = CoroutineScope(Job())
launch {
    launch {
      val ss =    withContext(dispatcher1){
           ld("lalala ${this@withContext === this@launch}")
            delay(1000)
        }

        ld(ss)
    }
    launch {
        var start = System.currentTimeMillis()
        ld("start2")
       delay(1000)
        ld("after2")
    }


}.join()

}

