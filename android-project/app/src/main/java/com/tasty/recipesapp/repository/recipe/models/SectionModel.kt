package com.tasty.recipesapp.repository.recipe.models

data class SectionModel(
    var components: List<ComponentModel> ,
    var name : String,
    var position : Int
)
