package com.tasty.recipesapp.repository.recipe.models

import com.tasty.recipesapp.repository.recipe.dtos.CompilationDTO
import com.tasty.recipesapp.repository.recipe.dtos.InstructionDTO
import com.tasty.recipesapp.repository.recipe.dtos.PriceDTO
import com.tasty.recipesapp.repository.recipe.dtos.SectionDTO
import com.tasty.recipesapp.repository.recipe.dtos.TagDTO
import com.tasty.recipesapp.repository.recipe.dtos.UserRatingsDTO

class RecipeModel (
    val id: Int,
    val name: String?,
    val description: String = "No Description",
    val instructions: List<InstructionModel> = emptyList(),
    val tags:List<TagModel> = emptyList(),
    val price: PriceModel?,
    val thumbnail_url: String?,
    val original_video_url: String?,
    val user_ratings: UserRatingsModel?,
    val compilations: List<CompilationModel> = emptyList()
)
