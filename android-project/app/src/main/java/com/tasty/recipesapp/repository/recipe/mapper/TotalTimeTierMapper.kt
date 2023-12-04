package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.RecipeDTO
import com.tasty.recipesapp.repository.recipe.dtos.TotalTimeTierDTO
import com.tasty.recipesapp.repository.recipe.mapper.RecipeMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.repository.recipe.models.TotalTimeTierModel

class TotalTimeTierMapper {
    companion object {
        fun TotalTimeTierDTO.toModel(): TotalTimeTierModel {
            return TotalTimeTierModel(
                tier = this.tier,
                displayTier = this.display_tier
            )
        }
    }
}