package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.PriceDTO
import com.tasty.recipesapp.repository.recipe.models.PriceModel

class PriceMapper {
    companion object{
        fun PriceDTO.toModel(): PriceModel {
            return PriceModel(
                consumptionPortion = this.consumption_portion,
                total = this.total,
                updatedAt = this.updated_at,
                portion = this.portion,
                consumptionTotal = this.consumption_total
            )
        }
    }
}