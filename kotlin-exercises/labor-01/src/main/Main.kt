import java.util.Base64
import kotlin.contracts.contract
import kotlin.random.Random

fun main(args: Array<String>) {
    //1
    sum()

    //2
    days()

    //3
    println( isPrime(17))
    val start=1
    val end=100

    for (i in start..end){
        if(isPrime(i)){
            println(i)
        }
    }

    // 4
    val text="alma a fa alatt"
    println("Text to encode: "+text)
    val encoded_text=encode(text)
    println("Encoded text: "+ encoded_text)
    val decoded_text=decode(encoded_text)
    println("Decoded text: "+ decoded_text)


    // 5
    println( isEvenNumber(1))
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("Even numbers in list: ")
    printEvenNumbers(numberList)
    println("\n")
    //6
    useMap()
    //7
    mutableLists()
    //8
     arrays()
}

fun sum() {
    val num1 = 2
    val num2 = 3
    val sum = num1 + num2

    println("$num1 + $num2 = $sum")
}

fun days(){
    val arr=listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
    println(arr)
    for (day in arr){
        println(day)
    }
    val daysWithT= arr.filter { it[0]=='T' }
    println("Days starting with letter T: $daysWithT")
    val daysContainingE=arr.filter {it.contains('e') }
    println("Days containing the letter e: $daysContainingE")
    val daysOfLength6=arr.filter { it.length==6 }
    println("Days of length 6: $daysOfLength6")
}

fun isPrime(a:Int):Boolean{
    if (a <= 1) {
        return false
    }
    if (a == 2) {
        return true
    }
    if (a % 2 == 0) {
        return false
    }

    val sqrt = kotlin.math.sqrt(a.toDouble()).toInt()
    for (i in 3..sqrt step 2) {
        if (a % i == 0) {
            return false
        }
    }
    return true
}

fun isEvenNumber(a:Int)=a%2==0   /// compact function
fun printEvenNumbers(arr:List<Int>)=print(arr.filter { it%2==0 })

fun encode(s:String):String{
    return  Base64.getEncoder().encodeToString(s.toByteArray())
}

fun decode(s:String):String{
    return String(Base64.getDecoder().decode(s))
}

fun useMap(){
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Number List: $numberList")
    val doubledNumbers = numberList.map{it*2}
    println("Doubled numbers: $doubledNumbers")
    val arr=listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
    println("Original list of days: $arr")
    val daysWithCapitalized=arr.map{it.uppercase()}
    println("Days with capitalized names: $daysWithCapitalized")
    val daysWithFirstLetterCap=arr.map{it.first()}
    println("First letters of the days: $daysWithFirstLetterCap")
    val lengthOfDays=arr.map { it.length }
    println("Length of each day's name: $lengthOfDays")
    val averageLength=arr.map { it.length }.average()
    println("Average length of day names: $averageLength")
}

fun mutableLists(){
    val arr=listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
    val mutableDaysOfWeek = arr.toMutableList()
    mutableDaysOfWeek.removeAll { it.contains('n')}
    println(mutableDaysOfWeek)
    for ((index, day) in mutableDaysOfWeek.withIndex()) {
        println("Item at $index is $day")
    }
    val sortedDaysOfWeek=mutableDaysOfWeek.sorted()
    println(sortedDaysOfWeek)
}

fun arrays(){
    val array = Array(10) { Random.nextInt(0, 100) }

    println("Array: ")
    array.forEach { println(it) }
    val sortedArray=array.sorted()
    println(sortedArray)
    if( array.any{it%2==0}){
        println("The array contains any even number!")
    }
    else{
        println("The array NOT contains any even number!")
    }
    if( array.all{it%2==0}){
        println("All the numbers are even!")
    }
    else{
        println("NOT all the numbers are even")
    }

    val avg=array.sum()/array.size
    println(avg)




}
