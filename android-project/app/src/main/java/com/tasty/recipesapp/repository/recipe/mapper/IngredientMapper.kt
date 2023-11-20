package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.IngredientDTO
import com.tasty.recipesapp.repository.recipe.models.IngredientModel

class IngredientMapper {
    companion object {
        fun IngredientDTO.toModel(): IngredientModel {
            return IngredientModel(
                name = this.name,
                displaySingular = this.displaySingular,
                displayPlural = this.displayPlural,
            )
        }
        fun List<IngredientDTO>.toModelList(): List<IngredientModel> {
            return this.map { it.toModel() }
        }
    }
}