package rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

import java.util.concurrent.TimeUnit


fun main() {
   val disposable =  Observable.interval(1,TimeUnit.SECONDS).map { return@map it }.flatMap { return@flatMap Observable.just(it) }.subscribe {
        println(it)

    }



    Thread.sleep(2000)
    disposable.dispose()


}