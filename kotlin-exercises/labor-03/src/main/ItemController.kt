package main
import java.util.*

class ItemController(private val itemService: ItemService) {

    private val scanner = Scanner(System.`in`)

    fun quiz(numberOfItems: Int) {
        val items = itemService.selectRandomItems(numberOfItems)
        if (items.isEmpty()) {
            println("Nem található elegendő elem a quiz indításához.")
        } else {
            var correct=0
            println("A quiz elemei:")
            for ((index, item) in items.withIndex()) {
                println("Kérdés ${index + 1}: ${item.question}")
                println("Válaszlehetőségek: ${item.answers.joinToString(", ")}")
                print("Válasz: ")
                val answer = scanner.nextLine().toInt()
                if (answer == item.correct) {
                    println("Helyes válasz!")
                    correct++
                } else {
                    println("Nem helyes válasz.")
                    println("A helyes válasz:  ${item.correct}")
                }
                println()
            }
            val percentage = (correct.toDouble() / numberOfItems) * 100
            println("A teszt véget ért. Összesen $correct helyes válasz volt $numberOfItems kérdésből, ami $percentage%-os eredményt jelent.")

        }
    }
}