package concurrent

import ld

class DefaultLockTest {
    fun methodA(){
        for (i in 0..100){
            Thread.sleep(50)
            ld("methodA is runing")
        }

    }

    fun methodB(){

        for (i in 0..100){
            Thread.sleep(50)
            ld("methodA is runing")
        }
    }

}