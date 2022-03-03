import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils

import java.util.*
import java.util.concurrent.CompletableFuture

lateinit var  a:DD
var b:EE? =EE()

 fun main() {
  a= b!!.dd!!
  b!!.dd = null
  b= null
  println(a)
}

class DD(
 var  ss:String? = "lala"
)
class EE(
 var dd:DD? = DD()
)
