package rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import ld

fun main() {
    val local = Observable.create<Int> {
       /* it.onNext(getFromLocal())
        it.onNext(getFromLocal())*/
        it.onNext(getFromLocal())
        it.onComplete()
    }.subscribeOn(Schedulers.io())

    val remote = Observable.create<Int> {
     /*   it.onNext(getFromeRomote())
        it.onNext(getFromeRomote())*/
        it.onNext(getFromeRomote())
        it.onComplete()
    }.subscribeOn(Schedulers.io())

    Observable.concat(local,remote)
        //.subscribeOn(Schedulers.io())
        //.take(1)
        .observeOn(Schedulers.io())
        .subscribe {
        ld(it)
            Thread.sleep(10)
    }

    Thread.sleep(10000)




}

fun getFromLocal(): Int {
    ld("loacal ")
    Thread.sleep(100)
    return 1
}

fun  getFromeRomote():Int{
    ld("remote ")
    Thread.sleep(100)
    return 2
}