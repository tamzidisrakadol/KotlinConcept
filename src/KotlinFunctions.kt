//Kotlin function types

fun main() {
    val value = 987
    val callTheFunc = ::makeReverse
    val output1 = callTheFunc("Ad_tech")
    println(output1)

    val callTheFunc2: Int.() -> Int = Int::makeDouble


    val callTheFunc3 = value::makeDouble

    val output2 = value.callTheFunc2()
    val output3 = callTheFunc2(789)
    println(output2)
    println(output3)
    println(callTheFunc3)


    val book = Document("Once upon a time there was a developer")

    //property reference  :: this is a property reference operator
    val getStory = book::text::get  //receiver
    val length = book::length::get   //receiver

    val setStory = Document::text::set //return Unit
}


fun makeReverse(name: String) = name.reversed()

fun Int.makeDouble(): Int = this.times(2)

class Document(var text:String){
    val length get() = text.length
}



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

Example 3:

  // Bound Function reference
    val callTheFunc3 : ()->Int = value::makeDouble
    println(callTheFunc3)


    fun Int.makeDouble(): Int = this.times(2)

*/