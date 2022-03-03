package rxjava

import io.reactivex.rxjava3.core.Observable
import ld

fun main() {
    Observable.just(1)
        .map{
            return@map it
        }
        .flatMap {
            ld("flatmap ;$it")
            return@flatMap Observable.just(it)
        }
        .blockingFirst()





}