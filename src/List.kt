import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    val catList: List<String> = listOf(
        "Puchu", "chuchu", "kochu", "mochu", "billu"
    )
    printList(catList)
}


fun printList(dataList: List<String>) {

    if (dataList is MutableList){
        dataList.remove("Puchu")
    }
    dataList.forEachIndexed{index,data->
        println("List no ${index+1} $data")
    }
}

/*
Exception 1: UnsupportedOperationException
List -> it means data type.It can be mutable or immutable means the list type can be changeable or unchangeable
listOf-> it means the content of the list is changeable or not. listOf consider as Immutatable. mutableListOf means it
can modify the value.


 val catList:List<String> = listOf(
        "Puchu",
        "chuchu", "kochu", "mochu", "billu"
    )
    printList(catList)


fun printList(dataList: List<String>) {
    >>problem is here the list is unchangeable how can i modify it
    if (dataList is MutableList<String>) {
        dataList.remove("chuchu")
    }
    println("List contain: ")
    dataList.forEach { data ->
        println(data)
    }
}

Exception 2: java.util.ConcurrentModificationException
 (The ConcurrentModificationException occurs because you're modifying a collection (adding "Motu" to catList) while iterating over it in the printList function.
 This is a common issue when multiple threads or coroutines modify the same collection concurrently.)

 val catList = mutableListOf(
        "Puchu",
        "chuchu", "kochu", "mochu", "billu"
    )

    runBlocking {
        launch { printList(catList)}
        launch { catList.remove("Puchu") }
    }

suspend fun printList(dataList: List<String>) {
    println("List contain: ")
    dataList.forEach { data ->
        println(data)
        yield()
    }
}

solution 1 for exception 2: copy the original list
explanation : The reason why this code works is that it creates a copy of the original list catList before iterating over it.
This copy, stored in newList, is not affected by the modifications made to the original list by the second coroutine.

suspend fun printList(dataList: List<String>) {
    val newList = ArrayList(dataList)
    println("List contain: ")
    newList.forEach { data ->
        println(data)
        yield()
    }
}

 */