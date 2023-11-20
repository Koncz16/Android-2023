package com.tasty.recipesapp.repository.recipe.dtos

data class Nutrition (
    var fiber: Int,
    var updatedAt: String,
    var protein: Int,
    var fat: Int,
    var calories: Int,
    var sugar: Int,
    var carbohydrates: Int
)