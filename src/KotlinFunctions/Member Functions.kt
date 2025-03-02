package KotlinFunctions

//These are functions defined inside a class, object, or interface.
//They are called on an instance of the class (or the object/companion object).


class Greeter {
    // Member function
    fun greet(name: String) {
        println("Hello, $name!")
    }
}

fun main() {
    val greeter = Greeter()
    greeter.greet("Bob") // Output: Hello, Bob!
}