
fun main() {
    val withFiveDollarBill = calculateTotal(65.89, ::discountedForFiveDollar)
    val with10DollarDiscount = calculateTotal(78.98,::discountedForTenPercent)

    println(withFiveDollarBill)
    println(with10DollarDiscount)

    val calculateWithCouponCode = calculateTotal(120.56,discountedCoupon("10%"))
    println(calculateWithCouponCode)

    //Lambdas
    val total = calculateTotal(50.98,apply5DollarDiscount)
    val calculate10DollarDiscountWithLambda = calculateTotal(65.78) { price -> price * 0.9 }
    println(total)
    println(calculate10DollarDiscountWithLambda)
    val calculate = calculateTotal(99.99, discountedCoupon("15%"))
    println(calculate)

}


fun discountedForFiveDollar(price:Double):Double= price - 5.0    // check the parameter and the return type we can say like this (Double)->Double

fun discountedForTenPercent(price: Double):Double = price*0.9  //same as previous function

fun noDiscount(price: Double):Double = price


//Let's create a higher order function
//Passing function to function
fun calculateTotal(
    initialPrice:Double,
    applyDiscount:(Double)->Double)   //we can pass function here with the same parameter and return type
:Double{
    val priceAfterDiscount = applyDiscount(initialPrice)
    return priceAfterDiscount
}


//let's create another higher order function
//Returning function from function
fun discountedCoupon(couponCode:String):(Double)->Double = when(couponCode){
    // String -> fun with same parameter and return type

    "FIVE_DOLLAR" -> ::discountedForFiveDollar
    "10%"-> ::discountedForTenPercent
    "15%"-> {price-> price * 0.12}  //we can pass lambda instead of higher order function
    else-> ::noDiscount
}


//Lambda

val apply5DollarDiscount: (Double)->Double = {price -> price - 5.00}