package KotlinFunctions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


/* fun ClassName.functionName(parameters): ReturnType {
    // Function body
} */



// Extension function for String
fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}
data class User(val name: String, val age:Int)

//example 1
fun List<User>.ageChecker(age:Int): Boolean{
    return this.any{
        it.age < age
    }
}

//example 2
fun <T> List<T>.checkTheElement(user:T): Boolean{
    return this.contains(user)
}

//flow example
fun <T> Flow<T?>.filterNotNull(): Flow<T> {
    return this.filter { it != null } as Flow<T>
}

fun Flow<User>.filterTheUser(age:Int): Flow<User>{
    return this.filter { it.age < age }
}


//Live Data
/*
fun <T, R> LiveData<T>.map(transform: (T) -> R): LiveData<R> {
    return this.map(transform)
}



*/





fun main() {
    println("madam".isPalindrome()) // Output: true
    val userList: List<User> = listOf(User(name = "Adol", age = 25),User(name = "Ayub", age = 54),User(name = "Lina", age = 49))
    userList.ageChecker(30)
    userList.checkTheElement(User(name = "Adol", age = 25))

    val flowList = userList.asFlow()

    runBlocking {
        flowList.filterTheUser(50).collect{user->
        println(user)
    }
        flowList.filterNotNull().collect{
            println(it) //there is no null user
        }

    }

}


/*
The error "Type inference failed" means that the Kotlin compiler cannot automatically determine the type of generic parameter
based on the context. This usually happens when:
The relationship between the types is not clear.
The types are inconsistent or mismatched.
*/
