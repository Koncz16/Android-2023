package com.tasty.recipesapp.repository.recipe.models

import com.tasty.recipesapp.repository.recipe.dtos.InstructionDTO
import com.tasty.recipesapp.repository.recipe.dtos.PriceDTO
import com.tasty.recipesapp.repository.recipe.dtos.SectionDTO
import com.tasty.recipesapp.repository.recipe.dtos.TagDTO
import com.tasty.recipesapp.repository.recipe.dtos.UserRatingsDTO

class RecipeModel (
    val name: String,
    val description: String,
    val instructions: List<InstructionModel>,
    val tags:List<TagModel>,
    val price: PriceModel,
    val section: SectionModel


)
