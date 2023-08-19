package rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import java.util.Objects

object  Rxbus{

    private  val subject = PublishSubject.create<Any>().toSerialized()





    fun <T>post(message:Message<T>){
        subject.onNext(message)
    }

     fun <T>toObservable(clz:Class<T>):Observable<T>{
        return  this.subject.ofType(clz)
    }




}


data  class Message<T>(val key:String,val value:Any?)