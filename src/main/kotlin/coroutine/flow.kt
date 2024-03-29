package coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import ld

val flow = flow<Int> {
    repeat(100) {
        delay(100)
        emit(it)
    }
}
suspend fun main() {
    flow.
        buffer(3, onBufferOverflow = BufferOverflow.DROP_LATEST)
        .
    collect {
        
    }

}

suspend fun getFromLocal(): Deferred<Int> {
   return GlobalScope.async {
       ld("local")
        delay(100)
        return@async 1;
    }
}

suspend fun getFromRemote(): Deferred<Int> {
    return GlobalScope.async {
        ld("remote")
        delay(300)
        return@async 2;
    }
}

