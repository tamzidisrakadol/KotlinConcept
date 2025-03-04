package KotlinFunctions

/*
Infix Notation: Infix functions are called using infix notation,
which means you can write a functionName b instead of a.functionName(b).

Single Parameter: Infix functions must have exactly one parameter.
Member or Extension Functions: Infix functions can be either member functions (defined inside a class) or extension functions (defined outside a class).

infix fun ClassName.functionName(parameter: ParameterType): ReturnType {
    // Function body
}


*/
infix fun Int.isBetween(range: Pair<Int, Int>): Boolean {
    return this >= range.first && this <= range.second
}

//to add element in the list
infix fun <T> MutableList<T>.addElement(element: T) {
    this.add(element)
}

fun main() {
    val number = 5
    val range = 1 to 10 // Pair(1, 10)

    // Using infix notation
    val result = number isBetween range

    val list = mutableListOf(1, 2, 3)
    list addElement 4 // Infix notation

    println(result) // Output: true
    println(list)
}