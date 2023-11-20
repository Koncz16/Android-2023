package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.ComponentDTO
import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.mapper.ComponentMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.IngredientMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.MeasuremantMapper.Companion.toModelList
import com.tasty.recipesapp.repository.recipe.models.ComponentModel
import com.tasty.recipesapp.repository.recipe.models.RecipeModel

class ComponentMapper {
    companion object {
        fun ComponentDTO.toModel(): ComponentModel {
            return ComponentModel(
                extraComment = this.extraComment,
                ingredient = this.ingredient.toModel(),
                position = this.position,
                measurements = this.measurements.toModelList(),
                rawText = this.rawText
            )
        }
        fun List<ComponentDTO>.toModelList(): List<ComponentModel> {
            return this.map { it.toModel() }
        }
    }
}