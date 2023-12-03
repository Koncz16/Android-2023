package com.tasty.recipesapp.repository.recipe.models

data class UserRatingsModel(
    var countPositive: Int?,
    var score: Double?,
    var countNegative: Int?
)
