package coroutine

import kotlinx.coroutines.*



class ByteCode {

   suspend  fun init(){

         step1()
         step2()
       step1()

   }


    suspend fun step1(){
        delay(1000)
        println("step1")
    }

    suspend fun  step2(){
        delay(1000)
        println("step2")
    }
}