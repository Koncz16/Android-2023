package com.tasty.recipesapp.repository.recipe.dtos

data class MeasurementDTO (
    var unit: UnitDTO,
    var quantity: String,
    var id: Int
)