package meta

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


fun main() {
    val serviceProxy = MyInvocationHandle().bind<Service>()
   // println(" the proxy obj is $serviceProxy")
    println(serviceProxy.getFromAnatation())
    println(serviceProxy.getFromFun())

}


class  MyInvocationHandle():InvocationHandler{
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any {
      //  println("the invoke proxy is $proxy")
        if (method.isAnnotationPresent(MockData::class.java)){
            val annotation = method.getAnnotation(MockData::class.java)
            return annotation.def
        }else{
            return  method.invoke(this,args)
        }
    }

    inline fun < reified P>bind():P{
       return Proxy.newProxyInstance(P::class.java.classLoader, arrayOf(P::class.java),this) as P
    }
}

@Target(AnnotationTarget.FUNCTION)
annotation class MockData(val key:String,val def:String)


interface   Service {
    @MockData(key = "lala", def = "getAnnotation")
    fun getFromAnatation():String

    fun getFromFun(): String {
        return "getFromFunction"
    }


}


