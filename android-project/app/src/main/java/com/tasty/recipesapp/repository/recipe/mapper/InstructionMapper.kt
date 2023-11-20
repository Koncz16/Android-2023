package com.tasty.recipesapp.repository.recipe.mapper

import com.tasty.recipesapp.repository.recipe.dtos.InstructionDTO
import com.tasty.recipesapp.repository.recipe.models.InstructionModel
import com.tasty.recipesapp.repository.recipe.models.InstructionTime

class InstructionMapper {
    companion object{
        fun InstructionDTO.toModel(): InstructionModel
        { return InstructionModel(
            display_text = this.display_text,
            time = InstructionTime(
                start_time = this.start_time,
                end_time = this.end_time ) ) }
        fun List<InstructionDTO>.toModelList(): List<InstructionModel>
        { return this.map { it.toModel() } }
    }
}