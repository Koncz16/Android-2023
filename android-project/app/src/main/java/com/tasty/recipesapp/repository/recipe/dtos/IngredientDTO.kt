package com.tasty.recipesapp.repository.recipe.dtos

data class IngredientDTO(
    var createdAt: Int,
    var displayPlural: String,
    var id: Int,
    var displaySingular: String,
    var updatedAt: Int,
    var name: String
)
