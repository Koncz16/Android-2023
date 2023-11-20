package com.tasty.recipesapp.repository.recipe.dtos

data class RecipeResultDTO(
    val count: Int,
    val results: List<RecipeDTO>
)
