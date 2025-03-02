package KotlinFunctions


/*
1. Top-Level Functions
These are functions defined outside any class, object, or interface.

They are directly accessible without needing an instance of a class.

Commonly used for utility functions or operations that don’t belong to a specific class.
* */


fun greet(name: String) {
    println("Hello, $name!")
}

fun main() {
    greet("Alice") // Output: Hello, Alice!
}