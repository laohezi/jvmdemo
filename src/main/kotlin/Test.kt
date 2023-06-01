
import java.util.*
import java.util.concurrent.CompletableFuture

lateinit var  a:DD
var b:EE? =EE()

 fun main() {
  /*a= b!!.dd!!
  b!!.dd = null
  b= null
  println(a)*/
  val constructor = Constructor(3,"kkk")
  val intToLong :(Int)->Long = {it.toLong()}
  val intToLong2:Int.()->Long = {toLong()}




}

inline fun higherOrderF(body:Constructor.()->Long) = body(Constructor())

class Constructor(){
 private  var name = "lala"
 constructor(age:Int,name: String):this(){
  this.name = name
  println(" I am constructor")
 }

 init {
     println("I am init and name = $name)")
 }

}

class DD(
 var  ss:String? = "lala"
)
class EE(
 var dd:DD? = DD()
)
