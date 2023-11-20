package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.dtos.TagDTO
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.repository.recipe.models.TagModel

class TagMapper {
    companion object {
        fun TagDTO.toModel(): TagModel {
            return TagModel(
                displayName = this.display_name,
                type = this.type,
                name = this.name,
            )
        }
        fun List<TagDTO>.toModelList(): List<TagModel> = this.map { it.toModel() }

    }
}