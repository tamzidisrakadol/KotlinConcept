//Kotlin function types

fun main() {
    val callTheFunc = ::makeReverse
    val output1 = callTheFunc("Ad_tech")
    println(output1)

    val callTheFunc2: Int.() -> Int = Int::makeDouble
    val value = 987
    val output2 = value.callTheFunc2()
    println(output2)
}


fun makeReverse(name: String) = name.reversed()

fun Int.makeDouble(): Int = this.times(2)


/*
Example 1:
=> Callable reference operator
fun callName(name: String) = name.plus("Vector")
//Function type return
val callTheFunc:(String)->String = ::callName <= callable reference operator
    val output = callTheFunc("Adol")
    print(output)

Example 2:
fun String.sizeOfTheString():Int=this.length

   //we cannot call only like this ::sizeOfTheString...we must declare the return type String::sizeOfTheString
    val extensionFuncType: String.()->Int = String::sizeOfTheString
    val output="Adtech".extensionFuncType()
    println(output)
*/