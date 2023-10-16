package main
import main.Item
import java.io.File

class ItemRepository {
    private val items = mutableListOf<Item>()

    init {
        val lines =
            File("D:\\Egyetem\\android_programozas\\Android-2023\\kotlin-exercises\\labor-03\\res\\questions.txt")
                .useLines { it.toList() }

        for (i in lines.indices step 6) {
            val question = lines[i]
            val ans1 = lines[i + 1]
            val ans2 = lines[i + 2]
            val ans3 = lines[i + 3]
            val ans4 = lines[i + 4]
            val correct = lines[i + 5].trim()

            save(Item(question, mutableListOf(ans1, ans2, ans3, ans4), correct.toInt()))
        }
    }

    private fun save(item: Item) = items.add(item)
    fun size() = items.size

    fun randomItem(): Item {

        val randomIndex = (items.indices).random()
        return items[randomIndex]

    }

}