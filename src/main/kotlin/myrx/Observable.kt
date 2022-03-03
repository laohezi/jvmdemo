package myrx

import ld

interface  ObservableSource<T> {

    fun subscribe(observer: Observer<T>)
}

abstract class Observable<T>:ObservableSource<T>{
    fun <R>  map(function: (T) -> R):Observable<R>{
        return ObservableMap(function)
    }

    fun <T> just(t:T):Observable<T>{
        return ObservableJust(t)
    }

    override fun subscribe(observer: Observer<T>) {
        subscribeActual(observer)
    }


    abstract fun subscribeActual(observer: Observer<T>)
}

class  ObservableJust<T>(val t: T) :Observable<T>(){

    override fun subscribeActual(downStream: Observer<T>) {
        val observer = JustObserver(downStream)
        downStream.onSubscribe(observer)
        observer.onNext(t)
    }

    inner  class JustObserver<T>(val down:Observer<T>):Observer<T>,Disposable{
        override fun onSubscribe(upstream: Disposable) {

        }

        override fun onNext(t: T) {
            down.onNext(t)
        }

        override fun dispose() {
         ld("SingleObserver disposed")
        }

    }



}

abstract class ObservableWithUpstream<T,U>:Observable<U>(){

    abstract  fun source():ObservableSource<T>
}

class ObservableMap<T,R>(val function: (T) -> R):ObservableWithUpstream<T,R>(){
     var source:ObservableSource<T>? = null

    override fun source(): ObservableSource<T> {
       return  source!!
    }

    class MapObserver<T>():Observer<T>{

        override fun onSubscribe(upstream: Disposable) {

        }

        override fun onNext(t: T) {
            TODO("Not yet implemented")
        }

    }



    override fun subscribeActual(observer: Observer<R>) {
        TODO("Not yet implemented")
    }


}

interface Observer<T> {
    fun onSubscribe(upstream: Disposable)
    fun onNext(t: T)

}

interface Disposable {
    fun dispose()

}