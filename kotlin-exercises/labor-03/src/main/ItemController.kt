package main
import java.util.*

class ItemController(private val itemService: ItemService) {

    private val scanner = Scanner(System.`in`)

    fun quiz(numberOfItems: Int) {
        val items = itemService.selectRandomItems(numberOfItems)
        if (items.isEmpty()) {
            println("Nem található elegendő elem a quiz indításához.")
        } else {
            println("A quiz elemei:")
            for ((index, item) in items.withIndex()) {
                println("Kérdés ${index + 1}: ${item.question}")
                println("Válaszlehetőségek: ${item.answers.joinToString(", ")}")
                print("Válasz: ")
                val answer = scanner.nextLine()
                if (answer == item.answers[item.correct - 1]) {
                    println("Helyes válasz!")
                } else {
                    println("Nem helyes válasz.")
                }
                println()
            }
        }
    }
}