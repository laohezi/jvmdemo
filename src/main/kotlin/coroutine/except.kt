package coroutine

import kotlinx.coroutines.*
import ld

fun main() = runBlocking {

     exceptionForWithContext()
     ld("end")

}

 suspend fun exceptionForWithContext(){

     try {
         val s = withContext(Dispatchers.IO){
             ld(1)
             throw Exception("lalala")
         }
     } catch (e: Exception) {
             e.printStackTrace()
     }

 }

private suspend fun exceptionTest1() {
    ld(1)
    try {
        supervisorScope { //①
            ld(2)
            launch { // ②
                ld(3)
                launch { // ③
                    ld(4)
                    delay(100)
                    throw ArithmeticException("Hey!!")
                }
                ld(5)
            }
            ld(6)
            val job = launch { // ④
                ld(7)
                delay(1000)
            }
            try {
                ld(8)
                job.join()
                ld("9")
            } catch (e: Exception) {
                ld("10. $e")
            }
        }
        ld(11)
    } catch (e: Exception) {
        ld("12. $e")
    }
    ld(13)
}
