package com.tasty.recipesapp.repository.recipe.models

data class PriceModel(
    val consumptionPortion: Int,
    val total: Int,
    val updatedAt: String,
    val portion: Int,
    val consumptionTotal: Int
)
