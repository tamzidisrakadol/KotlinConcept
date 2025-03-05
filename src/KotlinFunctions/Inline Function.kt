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


Inline Functions:
-Copy the function body to the call site.
-Improve performance for higher-order functions.
-Allow non-local return statements in lambdas.

noinline:

-Prevents a specific lambda from being inlined.
-Useful when the lambda needs to be stored or passed to another non-inline function.

crossinline:
-Ensures a lambda cannot use non-local return statements.
-Useful when the lambda is executed in a different context.

*/


inline fun Iterable<Int>.forEachInt(list: List<Int>, action: (Int) -> Unit){
    for (item in list) {
        action(item)
    }
}

inline fun inlineExample(onClick:()->Unit){
    onClick()
}

fun buttonClick(onClick: (Int) -> Int){
    onClick(100)
}

inline fun executeOperations(
    a: Int,
    b: Int,
    crossinline operation1: (Int, Int) -> Int, // Non-local returns NOT allowed
    noinline operation2: (Int, Int) -> Int // This lambda will NOT be inlined
): Int {
    val result1 = operation1(a, b)
    val result2 = operation2(a, b)
    return result1 + result2
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

    val returnData = buttonClick {
        it * 2
    }



    val result = executeOperations(
        5,
        10,
        { x, y -> x + y }, // operation1 (crossinline)
        { x, y -> x * y }  // operation2 (noinline)
    )
    println(result)


}




