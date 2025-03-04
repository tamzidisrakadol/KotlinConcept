package KotlinFunctions

/*
What is an inline function?
-An inline function is a function marked with the inline keyword. When you call an inline function,
the Kotlin compiler replaces the function call with the actual body of the function at the call site.
This process is called inlining.

-When you mark a function as inline, the compiler replaces the function call with its actual code during compilation.

🔹 Why?
-Reduces function call overhead.
-Improves performance when passing lambdas.
-Lambda Overhead
-Function Call Overhead

Non-Local control Flow:
In Kotlin, if we want to return from a lambda expression then the Kotlin compiler does not allow us to do so.
With the help of the inline keyword, we can return from the lambda expression itself and
exit the function in which inlined function is called.


*/


inline fun Iterable<Int>.forEachInt(list: List<Int>, action: (Int) -> Unit){
    for (item in list) {
        action(item)
    }
}

inline fun inlineExample(onClick:()->Unit){
    onClick()
}


fun main() {
    val numList = listOf<Int>(65,5,23,454,23,12,34)

    numList.forEachInt(numList) {int->
        println(int)
    }

    inlineExample {
        print("Inline function is called and add return")
        return
    }

}




