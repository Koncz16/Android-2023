package com.tasty.recipesapp.repository.recipe.dtos

data class UnitDTO(
    var system: String,
    var name: String,
    var displayPlural: String,
    var displaySingular: String,
    var abbreviation: String
)
