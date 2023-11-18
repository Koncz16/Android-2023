package com.tasty.recipesapp.repository.recipe.model

data class RecipeDTO(
    val id:Int,
    val name:String,
    val description:String?="Default description",
    val aspect_ratio:String
)

fun RecipeDTO.toModell():RecipeModel{
    return RecipeModel(
        name=this.name,
        description=this.description
    )

    fun List<RecipeDTO>.toModelList():List<RecipeModel> = this.map{it.toModell()}
}