package main
import java.util.*

private val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val repo=ItemRepository()
    val service=ItemService(repo)
    val itemController=ItemController(service)
    print("Adja meg, hogy hány kérdéses legyen a teszt: ")
    val numberOfItems = scanner.nextLine().toInt()
    itemController.quiz(numberOfItems)

}