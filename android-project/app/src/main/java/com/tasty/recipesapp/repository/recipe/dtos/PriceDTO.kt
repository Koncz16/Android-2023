package com.tasty.recipesapp.repository.recipe.dtos

data class PriceDTO(
    val consumption_portion: Int,
    val total: Int,
    val updated_at: String,
    val portion: Int,
    val consumption_total: Int
)