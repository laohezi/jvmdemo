import kotlinx.coroutines.*

fun main() = runBlocking {
    val scope = CoroutineScope(Job())
    val job = Job()
    val newJob = scope.launch(job) { }
    println(newJob)
    println(job)
    println(job.children.toList())

}

fun test(scope: CoroutineScope): Int {

    throw Exception("lallala")
    ld("hahahhahahah")
    return 1

}

fun getData(): Int {
    Thread.sleep(300)
    throw java.lang.Exception("lalal")
    return 1
}


suspend fun getResult(): String {
    delay(3000)
    return "I am result"
}

