package com.tasty.recipesapp.repository.recipe.models

data class ComponentModel(
    var extraComment: String,
    var ingredient: IngredientModel,
    var position: Int,
    var measurements: List<MeasurementModel>,
    var rawText: String
)
