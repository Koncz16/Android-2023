package main

fun main(args: Array<String>) {
    val repo=ItemRepository()
    val service=ItemService(repo)
    val itemController=ItemController(service)
    val numberOfItems = 5
    itemController.quiz(numberOfItems)

}