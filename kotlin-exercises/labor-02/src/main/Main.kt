package main

import kotlin.random.Random

fun main() {
    var problem:Int?=null
    try {
        problem = readLine()?.toInt()
    } catch (e: NumberFormatException) {
        println("Error: The provided value could not be converted to an integer.")
    }

    when(problem) {
        1->{
            val dict: IDictionary = DictionaryProvider.CreateDictionary(DictionaryType.HASH_SET)
            println("Number of words: ${dict.size()}")
            var word: String?
            while(true){
                print("What to find? ")
                word = readLine()
                if( word.equals("quit")){
                    break
                }
                println("Result: ${word?.let { dict.find(it) }}")
                }
            }
        2->{
            val name="John Smith"
            println(name.nameMonogram())

            val fruits = listOf("apple", "pear", "melon")
            val separator = "#"

            println(fruits.joinWithSeparator(separator))

            val fruits2 = listOf("apple", "pear","strawberry", "melon")
            println(fruits2.returnLongest());
        }
        3-> {
            val validDates = mutableListOf<Date>()
            while (validDates.size < 10) {
                val year = Random.nextInt(1900, 2100)
                val month = Random.nextInt(1, 13)
                val day = Random.nextInt(1, 32)

                val date = Date(year, month, day)

                if (date.isValidDate()) {
                    validDates.add(date)
                } else {
                    println("$date is not a valid date.")
                }
            }
            println("Print the valid dates list: ")
            validDates.forEach { x -> println(x) }
            println("Sorted list: ")
            var sortedDates = validDates.sorted()
            sortedDates.forEach { x -> println(x) }

            println("\nReverse sorted list: ")
            sortedDates.reversed().forEach { x -> println(x) }

            val sortBy = SortOrder.MONTH
            val customComparator = getComparator(sortBy)

            println("\nCustom sorted by $sortBy :")
            val customSorted = validDates.sortedWith(customComparator)
            customSorted.forEach { x -> println(x) }
        }
    }
}

fun String.nameMonogram():String=this.split(" ").map{it[0]}.joinToString ("")
fun List<String>.joinWithSeparator(separator: String): String =  this.joinToString(separator)
fun List<String>.returnLongest():String= this.maxBy { it.length }

fun getComparator (sortBy:SortOrder)= Comparator { date1: Date, date2: Date ->
    when (sortBy) {
        SortOrder.YEAR -> date1.year - date2.year
        SortOrder.MONTH -> date1.month - date2.month
        SortOrder.DAY -> date1.day - date2.day
    }
}

