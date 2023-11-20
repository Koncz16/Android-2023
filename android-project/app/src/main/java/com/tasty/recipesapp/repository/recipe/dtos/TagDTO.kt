package com.tasty.recipesapp.repository.recipe.dtos

data class TagDTO(
    var display_name: String?,
    var type: String,
    var rootTagType: String,
    var name: String,
    var id: Int
)
