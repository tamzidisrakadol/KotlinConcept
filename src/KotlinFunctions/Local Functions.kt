package KotlinFunctions


/*These are functions defined inside another function.

They are only accessible within the scope of the enclosing function.

Useful for breaking down complex logic into smaller, reusable pieces.*/



fun outerFunction() {
    // Local function
    fun localFunction(message: String) {
        println("Local: $message")
    }

    localFunction("Hello from inside!")
}

fun main() {
    outerFunction() // Output: Local: Hello from inside!
}

/*
Explanation:
In your code, the localFunction is defined inside the outerFunction. This means:

Scope of localFunction: The localFunction is only accessible within the body of outerFunction. It cannot be called from outside outerFunction, including from main.

Calling localFunction: Inside outerFunction, you explicitly call localFunction("Hello from inside!"). This is why the localFunction executes and prints the output.

Here’s the flow of execution:

When main calls outerFunction(), the control enters outerFunction.

Inside outerFunction, the localFunction is defined.

Immediately after defining localFunction, you call it with the argument "Hello from inside!".

The localFunction executes and prints "Local: Hello from inside!".

Control returns to main after outerFunction completes.*/
