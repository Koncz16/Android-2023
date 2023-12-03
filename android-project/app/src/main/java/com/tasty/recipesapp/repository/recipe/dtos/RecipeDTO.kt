package com.tasty.recipesapp.repository.recipe.dtos

import com.google.gson.annotations.SerializedName
import com.tasty.recipesapp.repository.recipe.models.RecipeModel

data class RecipeDTO(
    val id:Int,
    val name: String?,
    val description:String,
    val instructions: List<InstructionDTO> = emptyList(),
    val tags:List<TagDTO> = emptyList(),
    val price: PriceDTO?,
    @SerializedName("thumbnail_url")
    val thumbnail_url: String?,
    val original_video_url: String?,
    val user_ratings: UserRatingsDTO?,
    val compilations: List<CompilationDTO> = emptyList()


)