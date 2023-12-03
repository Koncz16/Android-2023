package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.UserRatingsDTO
import com.tasty.recipesapp.repository.recipe.models.RecipeModel
import com.tasty.recipesapp.repository.recipe.models.UserRatingsModel

class UserRatingsMapper {
    companion object{
        fun UserRatingsDTO.toModel():UserRatingsModel{
            return UserRatingsModel(
                countPositive=this.count_positive,
                score=this.score,
                countNegative=this.count_negative)
        }
    }
}