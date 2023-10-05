package main

class DictionaryProvider {
    companion object{
        fun CreateDictionary(type: DictionaryType):IDictionary{
            return when (type){
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.TREE_SET -> TreeSetDictionary
                DictionaryType.HASH_SET ->HashSetDictionary
            }
        }
    }
}