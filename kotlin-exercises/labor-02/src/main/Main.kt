package main

fun main() {
    val problem:Int?
    problem= readLine()?.toInt()

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

                var a= mutableListOf<String>()
        }
    }
}

fun String.nameMonogram():String=this.split(" ").map{it[0]}.joinToString ("")
fun mutableListOf<String>.
