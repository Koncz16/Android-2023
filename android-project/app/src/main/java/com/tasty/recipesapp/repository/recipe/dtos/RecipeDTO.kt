package com.tasty.recipesapp.repository.recipe.dtos

import com.tasty.recipesapp.repository.recipe.models.RecipeModel

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description:String,
    val instructions: List<InstructionDTO>?,
    val tags:List<TagDTO>?,
    val price: PriceDTO?,
    val thumbnail_url : String?,
    val ingredients: List<String>?,
    val user_ratings : UserRatingsDTO?,
    val video_url : String?,
    val total_time_tier:TotalTimeTierDTO?,
    val original_video_url : String?
)