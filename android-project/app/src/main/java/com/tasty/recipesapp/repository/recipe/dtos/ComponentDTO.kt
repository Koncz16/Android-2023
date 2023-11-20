package com.tasty.recipesapp.repository.recipe.dtos

data class ComponentDTO(
    var extraComment: String,
    var ingredient: IngredientDTO,
    var id: Int,
    var position: Int,
    var measurements:List<MeasurementDTO>,
    var rawText: String
)
