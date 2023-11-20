package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.UnitDTO
import com.tasty.recipesapp.repository.recipe.models.UnitModel

class UnitMapper {
    companion object {
        fun UnitDTO.toModel(): UnitModel {
            return UnitModel(
                name = this.name,
            )
        }
        fun List<UnitDTO>.toModelList(): List<UnitModel> {
            return this.map { it.toModel() }
        }
    }
}