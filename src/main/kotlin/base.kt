import java.text.SimpleDateFormat
import java.util.*

fun ld(msg:Any?){
    println("${Thread.currentThread().name}--${System.currentTimeMillis().toTimes()}--${msg.toString()}")
}
fun longToTimes(long: Long, pattern: String="HH-mm-ss-SSS"): String {
    val sf = SimpleDateFormat(pattern)
    return sf.format(Date(long))
}

fun Long.toTimes(pattern: String="HH:mm:ss:SSS"): String {
    return longToTimes(this,pattern)
}