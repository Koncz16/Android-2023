package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.MeasurementDTO
import com.tasty.recipesapp.repository.recipe.mapper.MeasuremantMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.mapper.UnitMapper.Companion.toModel
import com.tasty.recipesapp.repository.recipe.models.MeasurementModel

class MeasuremantMapper {
    companion object {
        fun MeasurementDTO.toModel(): MeasurementModel {
            return MeasurementModel(
                quantity = this.quantity,
                unit = this.unit.toModel()
            )
        }
        fun List<MeasurementDTO>.toModelList(): List<MeasurementModel> {
            return this.map { it.toModel() }
        }

    }
}