package rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import ld

fun main() {
    Observable.create<Int> {
        it.onNext(1)
        it.onComplete()
    }
        .map{
            return@map it
        }
        .flatMap {
            ld("flatmap ;$it")
            return@flatMap Observable.just(it)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())

        .subscribe {
            ld("subscribe ;$it")
        }

}