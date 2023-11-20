package com.tasty.recipesapp.repository.recipe.dtos

data class UserRatingsDTO(
    var countPositive: Int,
    var score: Double,
    var countNegative: Int
)
