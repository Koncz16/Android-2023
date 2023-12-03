package com.tasty.recipesapp.repository.recipe.dtos

data class UserRatingsDTO(
    var count_positive: Int?,
    var score: Double?,
    var count_negative: Int?
)
