import kotlin.reflect.full.memberProperties

/*
what is reified keyword in kotlin ?
  => In Kotlin, reified is a keyword used in combination with inline functions to retain the type information of a generic parameter at runtime.
    Normally, generic type parameters are erased at runtime due to type erasure.
   This means you cannot directly access the type of generic parameter inside a function.

What does reify solve?
=>  Reified solves the problem of type erasure by allowing access to the actual type of generic parameter at runtime.

Key Concepts:
1.Type Erasure:
=> In Java and Kotlin, generic types (e.g., List<T>) are erased at runtime.
You cannot access the type T directly at runtime because it gets replaced with Object (or its upper bound).

2.Reified Generics:
=> By using inline functions and marking a generic type parameter as reified, you preserve its type information at runtime.
This allows you to perform operations like type checks (is, as) or create instances of the generic type.

Advantages of reified:
1. Simplifies Type Checks
2. Avoids Passing Class<T>
3. Enables Runtime Reflection on Generic Types

Limitations:
1.Can only be used with inline functions.
2.Cannot be used for open-ended tasks like type inference for multiple different generic types in one place.

*/

fun main(){
    doSomething<Int>("Check the data")
    doSomethingElse(input = "Check the data", clazz = String::class.java)
    printClassProperties<User>()
    println()
    printClassProperties<Product>()
}


//inline :  Allows the function to be inlined at call sites.
// reified : Keeps the type of T available at runtime.
inline fun <reified T> doSomething(input:Any){
    if (input is T){
        println("Input is  type of T")
    }else{
        println("there are not same")
    }
}

//example of without reified keyword
//We have to add Class<T> because while in runtime jvm removes the data type
fun <T> doSomethingElse(input: Any,clazz: Class<T>){
    if (clazz.isInstance(input)){
        println("They are same")
    }else{
        println("they are not same")
    }
}


inline fun <reified T : Any> printClassProperties() {
    // Accessing the KClass of T
    val kClass = T::class

    println("Properties of ${kClass.simpleName}:") //simpleName = name of the data class
    // Using reflection to list all properties of the class
    kClass.memberProperties.forEach { property ->
        println("- ${property.name}: ${property.returnType}")
    }
}

data class User(val id: Int, val name: String, val isActive: Boolean)
data class Product(val id: Int, val title: String, val price: Double)
