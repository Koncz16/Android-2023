package com.tasty.recipesapp.repository.recipe.dtos

import com.tasty.recipesapp.repository.recipe.models.RecipeModel

data class RecipeDTO(
    val name: String,
    val description:String,
    val instructions: List<InstructionDTO>,
    val tags:List<TagDTO>,
    val price: PriceDTO
)